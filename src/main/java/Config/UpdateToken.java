package Config;

import Bean.AppInfo;
import Bean.EnvNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UpdateToken {

    public static void updateToken(AppInfo appInfo, EnvNum num) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
            appInfo.setEnv(num.toString());
            session.update("updateToken", appInfo);

        session.commit();
    }
}
