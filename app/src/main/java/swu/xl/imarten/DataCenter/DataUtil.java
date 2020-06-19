package swu.xl.imarten.DataCenter;

import java.util.ArrayList;
import java.util.List;

import swu.xl.imarten.Bean.Bean;
import swu.xl.imarten.Bean.SRMarvelBean;
import swu.xl.imarten.Bean.SRTennisBean;
import swu.xl.imarten.Constant.DataType;
import swu.xl.imarten.Constant.MarvelConstant;
import swu.xl.imarten.Constant.TennisConstant;

public class DataUtil {
    /**
     * 返回数据
     */
    public static List<? extends Bean> getData(DataType dataType){
        if (dataType == DataType.DATA_TYPE_MARVEL) {
            return getMarvelData();
        }else {
            return getTennisData();
        }
    }

    /**
     * 加载漫威数据
     */
    public static List<SRMarvelBean> getMarvelData(){
        List<SRMarvelBean> beans = new ArrayList<>();

        for (int count = 0; count < 4; count++) {
            for (int i = 0; i < 4; i++) {

                SRMarvelBean bean = new SRMarvelBean(
                        MarvelConstant.avatar_ids[i],
                        MarvelConstant.poster_ids[i],
                        MarvelConstant.role_e_names[i],
                        MarvelConstant.role_c_names[i],
                        MarvelConstant.actor_e_names[i],
                        MarvelConstant.actor_c_names[i],
                        MarvelConstant.contents[i]
                );

                beans.add(bean);
            }
        }

        return beans;
    }

    /**
     * 加载网球数据
     */
    public static List<SRTennisBean> getTennisData(){
        List<SRTennisBean> beans = new ArrayList<>();

        for (int count = 0; count < 4; count++) {
            for (int i = 0; i < 4; i++) {

                SRTennisBean bean = new SRTennisBean(
                        TennisConstant.avatar_ids[i],
                        TennisConstant.poster_ids[i],
                        TennisConstant.e_names[i],
                        TennisConstant.c_names[i],
                        TennisConstant.ao_wang[i],
                        TennisConstant.fa_wang[i],
                        TennisConstant.wen_wang[i],
                        TennisConstant.mei_wang[i],
                        TennisConstant.content[i]
                );

                beans.add(bean);
            }
        }

        return beans;
    }
}
