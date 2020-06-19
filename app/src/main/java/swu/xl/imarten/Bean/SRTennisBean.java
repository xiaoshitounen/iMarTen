package swu.xl.imarten.Bean;

/**
 * 网球类
 */
public class SRTennisBean extends Bean {
    //头像
    public int avatar_id;
    //海报
    public int poster_id;

    //英文名
    public String e_name;
    //中文名
    public String c_name;

    //四大赛事
    public int ao_wang;
    public int fa_wang;
    public int wen_wang;
    public int mei_wang;

    //内容
    public String content;

    public SRTennisBean(int avatar_id, int poster_id, String e_name, String c_name, int ao_wang, int fa_wang, int wen_wang, int mei_wang, String content) {
        super(avatar_id,poster_id,e_name,c_name,content);

        this.avatar_id = avatar_id;
        this.poster_id = poster_id;
        this.e_name = e_name;
        this.c_name = c_name;
        this.ao_wang = ao_wang;
        this.fa_wang = fa_wang;
        this.wen_wang = wen_wang;
        this.mei_wang = mei_wang;
        this.content = content;
    }

    @Override
    public String toString() {
        return "SRTennisBean{" +
                "avatar_id=" + avatar_id +
                ", poster_id=" + poster_id +
                ", e_name='" + e_name + '\'' +
                ", c_name='" + c_name + '\'' +
                ", ao_wang=" + ao_wang +
                ", fa_wang=" + fa_wang +
                ", wen_wang=" + wen_wang +
                ", mei_wang=" + mei_wang +
                ", content='" + content + '\'' +
                '}';
    }
}
