package swu.xl.imarten.Fragment.RealFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import swu.xl.imarten.Activity.MessageActivity;
import swu.xl.imarten.R;
import swu.xl.imarten.SelfView.XLRecyclerView;

public class MarvelFloatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        View inflate = inflater.inflate(R.layout.marvel_float_layout, null);

        //找到视图
        XLRecyclerView recyclerView = inflate.findViewById(R.id.recycler);

        //跳转界面
        recyclerView.setOnItemClickListener(new XLRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                intent.putExtra("type",0);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        //刷新
        final SwipeRefreshLayout refresh = inflate.findViewById(R.id.refresh);
        refresh.setColorSchemeColors(Color.parseColor("#307DF0"));
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                //取消刷新
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (refresh.isRefreshing()) {
                            refresh.setRefreshing(false);
                        }
                    }
                }, 500);
            }
        });

        return inflate;
    }
}
