package Config;

import Bean.AppInfo;
import Bean.EnvNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetAppInfo {
    /**
     * 获取Token
     *
     * @param num
     * @return
     * @throws IOException
     */
    public static AppInfo getAppInfo(EnvNum num) throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        AppInfo appInfo = new AppInfo();
//        String env = getEnv(num);
//        num.toString();
        appInfo = sqlSession.selectOne("getAppInfo", num.toString());

        return appInfo;
    }

}
