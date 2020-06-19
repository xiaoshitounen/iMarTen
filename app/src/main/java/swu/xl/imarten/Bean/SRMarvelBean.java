package swu.xl.imarten.Bean;

/**
 * 漫威模型类
 */
public class SRMarvelBean extends Bean {
    //头像
    public int avatar_id;
    //海报
    public int poster_id;

    //角色英文名
    public String e_name;
    //角色中文名
    public String c_name;

    //演员英文名
    public String actor_e_name;
    //演员中文名
    public String actor_c_name;

    //内容
    public String content;

    public SRMarvelBean(int avatar_id, int poster_id, String e_name, String c_name, String actor_e_name, String actor_c_name, String content) {
        super(avatar_id,poster_id,e_name,c_name,content);

        this.avatar_id = avatar_id;
        this.poster_id = poster_id;
        this.e_name = e_name;
        this.c_name = c_name;
        this.actor_e_name = actor_e_name;
        this.actor_c_name = actor_c_name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "SRMarvelBean{" +
                "avatar_id=" + avatar_id +
                ", poster_id=" + poster_id +
                ", role_e_name='" + e_name + '\'' +
                ", role_c_name='" + c_name + '\'' +
                ", actor_e_name='" + actor_e_name + '\'' +
                ", actor_c_name='" + actor_c_name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
