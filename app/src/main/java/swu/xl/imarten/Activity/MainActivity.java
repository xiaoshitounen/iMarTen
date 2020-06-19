package swu.xl.imarten.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import swu.xl.imarten.BottomView.MyItem;
import swu.xl.imarten.BottomView.XLBottomView;
import swu.xl.imarten.Fragment.MarvelFragment;
import swu.xl.imarten.Fragment.MyAdapterFragment;
import swu.xl.imarten.Fragment.TennisFragment;
import swu.xl.imarten.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private XLBottomView bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化视图
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        //底部控制图
        bottomView = findViewById(R.id.bottom_view);
        bottomView.setItems(loadItemData());

        //ViewPager
        pager = findViewById(R.id.pager);
        pager.setAdapter(new MyAdapterFragment(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                loadFragmentData())
                );

        //监听
        bottomView.setXLBottomViewItemListener(new XLBottomView.XLBottomViewItemListener() {
            @Override
            public void itemStatusDidChange(int index) {
                pager.setCurrentItem(index);
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                bottomView.post(new Runnable() {
                    @Override
                    public void run() {
                        bottomView.getLastItem().changeStatus(MyItem.STATUS_NORMAL);
                        for (MyItem item_view : bottomView.getItem_views()) {
                            if (item_view.getItem_index() == position){
                                item_view.changeStatus(MyItem.STATUS_SELECT);

                                bottomView.setLastItem(item_view);

                                break;
                            }
                        }
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * XLNewBottomView的数据初始化
     */
    private List<XLBottomView.BottomViewItem> loadItemData(){
        List<XLBottomView.BottomViewItem> items = new ArrayList<>();

        XLBottomView.BottomViewItem item1 = new XLBottomView.BottomViewItem(
                R.drawable.tab_marvel,
                "漫威"
        );

        XLBottomView.BottomViewItem item2 = new XLBottomView.BottomViewItem(
                R.drawable.tab_tennis,
                "网球"
        );

        items.add(item1);
        items.add(item2);

        return items;
    }

    /**
     * ViewPager的数据初始化
     */
    private List<Fragment> loadFragmentData(){
        //数据源
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MarvelFragment());
        fragments.add(new TennisFragment());

        return fragments;
    }
}