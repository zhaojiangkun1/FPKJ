package Config;

import Bean.AppInfo;
import Bean.EnvNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UpdateToken {

    public static void updateToken(AppInfo appInfo, EnvNum num) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        if (num == EnvNum.PRO){
            appInfo.setEnv("PRO");
            session.update("updateToken",appInfo);
        }
        if (num == EnvNum.DEV){
            appInfo.setEnv("DEV");
            session.update("updateToken",appInfo);
        }
        if (num == EnvNum.TEST){
            appInfo.setEnv("TEST");
            session.update("updateToken",appInfo);
        }
        if (num == EnvNum.TEST1){
            appInfo.setEnv("TEST1");
            session.update("updateToken",appInfo);
        }
        if (num == EnvNum.PRO1){
            appInfo.setEnv("PRO1");
            session.update("updateToken",appInfo);
        }
        if (num == EnvNum.DEV1){
            appInfo.setEnv("DEV1");
            session.update("updateToken",appInfo);
        }
        session.commit();
    }
}
