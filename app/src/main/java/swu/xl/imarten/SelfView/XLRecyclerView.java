package swu.xl.imarten.SelfView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

import swu.xl.imarten.Bean.Bean;
import swu.xl.imarten.Bean.SRMarvelBean;
import swu.xl.imarten.Constant.DataType;
import swu.xl.imarten.Constant.LayoutType;
import swu.xl.imarten.DataCenter.DataManager;
import swu.xl.imarten.R;

public class XLRecyclerView extends RecyclerView {
    //布局类型
    private LayoutType layoutType = LayoutType.LAYOUT_TYPE_GRID;

    //数据类型
    private DataType dataType = DataType.DATA_TYPE_MARVEL;

    //监听者
    private OnItemClickListener listener;

    /**
     * 构造方法：Xml代码初始化
     * @param context
     * @param attrs
     */
    public XLRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        if (attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XLRecyclerView);

            int enum_layout_type = typedArray.getInt(R.styleable.XLRecyclerView_layoutType, 0);
            int enum_data_type = typedArray.getInt(R.styleable.XLRecyclerView_dataType, 0);

            layoutType = enum_layout_type == 0 ? LayoutType.LAYOUT_TYPE_GRID : LayoutType.LAYOUT_TYPE_FLOAT;
            dataType = enum_data_type == 0 ? DataType.DATA_TYPE_MARVEL : DataType.DATA_TYPE_TENNIS;

            typedArray.recycle();
        }

        //初始化操作
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        //设置布局类型
        RecyclerView.LayoutManager layoutManager =
                layoutType == LayoutType.LAYOUT_TYPE_GRID ?
                        new GridLayoutManager(getContext(),2)
                        :
                        new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        setLayoutManager(layoutManager);

        //设置适配器
        setAdapter(new MyAdapter(DataManager.getDataManager().loadData(dataType).beans));
    }

    /**
     * 适配器
     */
    class MyAdapter extends Adapter{
        //存储数据
        private List<? extends Bean> beans;

        //构造方法
        public MyAdapter(List<? extends Bean> beans) {
            this.beans = beans;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //加载的布局
            int layout = R.layout.item_layout;

            //加载布局
            View inflate = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

            //返回布局
            return new XLViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            //获取数据模型
            Bean bean = beans.get(position);

            //设置数据
            XLViewHolder XLViewHolder = (XLViewHolder) holder;
            XLViewHolder.icon_view.setBackgroundResource(bean.avatar_id);
            XLViewHolder.e_name_view.setText(bean.e_name);
            XLViewHolder.c_name_view.setText(bean.c_name);
            String[] split = bean.content.split("。");
            XLViewHolder.content.setText(split[0]);

            //设置点击事件
            XLViewHolder.icon_view.getRootView().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onItemClick(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return beans.size();
        }
    }

    /**
     * ViewHolder
     */
    static class XLViewHolder extends ViewHolder{
        //显示的头像
        ImageView icon_view;
        //显示的角色英文名
        TextView e_name_view;
        //显示角色的中文名
        TextView c_name_view;
        //显示的内容
        TextView content;

        /**
         * 构造方法
         * @param itemView
         */
        public XLViewHolder(@NonNull View itemView) {
            super(itemView);

            //绑定控件
            icon_view = itemView.findViewById(R.id.icon);
            e_name_view = itemView.findViewById(R.id.e_name);
            c_name_view = itemView.findViewById(R.id.c_name);
            content = itemView.findViewById(R.id.content);
        }
    }

    /**
     * 监听item被点击
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
