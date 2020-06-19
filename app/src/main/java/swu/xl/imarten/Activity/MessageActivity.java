package swu.xl.imarten.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import swu.xl.imarten.Bean.Bean;
import swu.xl.imarten.Bean.SRMarvelBean;
import swu.xl.imarten.Bean.SRTennisBean;
import swu.xl.imarten.Constant.DataType;
import swu.xl.imarten.DataCenter.DataManager;
import swu.xl.imarten.R;

public class MessageActivity extends AppCompatActivity {

    DataType dataType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //加载数据
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        dataType = type == 0 ? DataType.DATA_TYPE_MARVEL : DataType.DATA_TYPE_TENNIS;
        int position = intent.getIntExtra("position", 0);
        List<? extends Bean> beans = DataManager.getDataManager().loadData(dataType).beans;

        //判断类型
        if (dataType == DataType.DATA_TYPE_MARVEL){
            //获取数据
            SRMarvelBean bean = (SRMarvelBean) beans.get(position);

            //设置布局
            setContentView(R.layout.activity_message_marvel);

            //找到控件
            ImageView poster = findViewById(R.id.poster);
            poster.setImageResource(bean.poster_id);
            TextView role_e_name = findViewById(R.id.role_e_name);
            role_e_name.setText(bean.e_name);
            TextView role_c_name = findViewById(R.id.role_c_name);
            role_c_name.setText(bean.c_name);
            TextView actor_e_name = findViewById(R.id.actor_e_name);
            actor_e_name.setText(bean.actor_e_name);
            TextView actor_c_name = findViewById(R.id.actor_c_name);
            actor_c_name.setText(bean.actor_c_name);
            TextView content = findViewById(R.id.content);
            content.setText(bean.content);
        }else {
            //获取数据
            SRTennisBean bean = (SRTennisBean) beans.get(position);

            //设置布局
            setContentView(R.layout.activity_message_tennis);

            //找到控件
            ImageView poster = findViewById(R.id.poster);
            poster.setImageResource(bean.poster_id);
            TextView role_e_name = findViewById(R.id.role_e_name);
            role_e_name.setText(bean.e_name);
            TextView role_c_name = findViewById(R.id.role_c_name);
            role_c_name.setText(bean.c_name);
            TextView ao = findViewById(R.id.ao_wang);
            ao.setText(String.valueOf(bean.ao_wang));
            TextView fa = findViewById(R.id.fa_wang);
            fa.setText(String.valueOf(bean.fa_wang));
            TextView wen = findViewById(R.id.wen_wang);
            wen.setText(String.valueOf(bean.wen_wang));
            TextView mei = findViewById(R.id.mei_wang);
            mei.setText(String.valueOf(bean.mei_wang));
            TextView content = findViewById(R.id.content);
            content.setText(bean.content);
        }


    }
}