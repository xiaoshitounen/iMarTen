package swu.xl.imarten.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 适配器
 */
public class MyAdapterFragment extends FragmentPagerAdapter {
    //保存传递的fragment集合
    private List<Fragment> fragments;

    /**
     * 构造方法
     * @param fm
     * @param behavior
     */
    public MyAdapterFragment(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments) {
        super(fm, behavior);

        //获取fragments数据源
        this.fragments = fragments;
    }

    //返回对应位置的 fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //获取 fragment 的数量
    @Override
    public int getCount() {
        return fragments.size();
    }
}
