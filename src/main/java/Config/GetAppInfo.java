package Config;

import Bean.AppInfo;
import Bean.EnvNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetAppInfo {
    /**
     * 获取Token
     * @param num
     * @return
     * @throws IOException
     */
    public static AppInfo getAppInfo(EnvNum num) throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        AppInfo appInfo = new AppInfo();
        if (num == EnvNum.PRO){
            appInfo = sqlSession.selectOne("getAppInfo","PRO");
        }
        if (num == EnvNum.DEV){
            appInfo = sqlSession.selectOne("getAppInfo","DEV");
        }
        if (num == EnvNum.TEST){
            appInfo = sqlSession.selectOne("getAppInfo","TEST");
        }
        if (num == EnvNum.TEST1){
            appInfo = sqlSession.selectOne("getAppInfo","TEST1");
        }
        return appInfo;
    }

}
