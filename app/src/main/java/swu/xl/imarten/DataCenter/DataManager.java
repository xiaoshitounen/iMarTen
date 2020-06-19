package swu.xl.imarten.DataCenter;

import java.util.List;

import swu.xl.imarten.Bean.Bean;
import swu.xl.imarten.Constant.DataType;

public class DataManager {
    //存储的数据
    public List<? extends Bean> beans;

    //单例模式
    private static DataManager instance = null;
    private DataManager(){}
    public static DataManager getDataManager(){
        if (instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * 加载数据
     */
    public DataManager loadData(DataType type) {
        beans = DataUtil.getData(type);

        return instance;
    }
}
