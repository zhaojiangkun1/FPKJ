package com.shuzutech.config;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.bean.EnvNum;
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
