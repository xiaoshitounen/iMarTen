package swu.xl.imarten.Bean;

import android.os.Parcelable;

import java.io.Serializable;

public class Bean {
    //头像
    public int avatar_id;
    //海报
    public int poster_id;
    //英文名
    public String e_name;
    //中文名
    public String c_name;
    //内容
    public String content;

    public Bean(int avatar_id, int poster_id, String e_name, String c_name, String content) {
        this.avatar_id = avatar_id;
        this.poster_id = poster_id;
        this.e_name = e_name;
        this.c_name = c_name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "avatar_id=" + avatar_id +
                ", poster_id=" + poster_id +
                ", e_name='" + e_name + '\'' +
                ", c_name='" + c_name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
