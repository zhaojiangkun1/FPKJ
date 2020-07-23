package com.shuzutech.config;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.bean.EnvNum;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

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

        if (num == EnvNum.bwt_test) {
            appInfo = sqlSession.selectOne("getAppInfo", "TEST");
        }
        if (num == EnvNum.bwt_dev) {
            System.out.println("num:" + num.toString());
            appInfo = sqlSession.selectOne("getAppInfo", "DEV");
        }
        if (num == EnvNum.bwt_pro) {
            appInfo = sqlSession.selectOne("getAppInfo", "PRO");
        }
        if (num.toString().contains("TEST") || num.toString().contains("PRO") || num.toString().contains("DEV")){
            appInfo = sqlSession.selectOne("getAppInfo", num.toString());
        }
        return appInfo;
    }

    @Test
    public void test() throws IOException {
//        SqlSession sqlSession = DataBaseUtil.getSqlSession();
//        AppInfo appInfo = sqlSession.selectOne("getAppInfo", "DEV");
        System.out.println(getAppInfo(EnvNum.bwt_dev).getAppid());
    }

}
