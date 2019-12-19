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
        String env = getEnv(num);
        appInfo = sqlSession.selectOne("getAppInfo", env);

        return appInfo;
    }

    public static String getEnv(EnvNum num) {
        String env = "";
        if (num == EnvNum.PRO) {
            env = "PRO";
        }
        if (num == EnvNum.DEV) {
            env = "DEV";
        }
        if (num == EnvNum.TEST) {
            env = "TEST";
        }
        if (num == EnvNum.TEST1) {
            env = "TEST1";
        }
        if (num == EnvNum.PRO1) {
            env = "PRO1";
        }
        if (num == EnvNum.DEV1) {
            env = "DEV1";
        }
        if (num == EnvNum.DEV2) {
            env = "DEV2";
        }
        return env;
    }

}
