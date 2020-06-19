package swu.xl.imarten.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import swu.xl.imarten.Fragment.RealFragment.MarvelFloatFragment;
import swu.xl.imarten.Fragment.RealFragment.MarvelGridFragment;
import swu.xl.imarten.Fragment.RealFragment.SimpleAdapterFragment;
import swu.xl.imarten.R;

public class MarvelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        View inflate = inflater.inflate(R.layout.fragment_layout, null);

        //绑定控件
        ViewPager pager = inflate.findViewById(R.id.pager);
        TabLayout tab = inflate.findViewById(R.id.tabLayout);

        //fragment数据源
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MarvelGridFragment());
        fragments.add(new MarvelFloatFragment());

        //标题数据源
        String[] titles = getResources().getStringArray(R.array.title);

        //设置适配器
        pager.setAdapter(
                new SimpleAdapterFragment(
                        getChildFragmentManager(),
                        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                        fragments,
                        titles
                )
        );

        //绑定tab和fragment
        tab.setupWithViewPager(pager);

        return inflate;
    }
}
