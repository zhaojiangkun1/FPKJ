package com.shuzutech.config;


import com.shuzutech.bean.EnvNum;
import com.shuzutech.bean.SaveAddr;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetSaveAddr {

    /**
     * 获取开票的链接
     *
     * @param num
     * @return
     * @throws IOException
     */
    public static String getSaveAddr(EnvNum num) throws IOException {

        SqlSession session = DataBaseUtil.getSqlSession();
        String env = num.toString();

        SaveAddr saveAddr = new SaveAddr();
        if (env.contains("PRO") || env.contains("pro")) {
            saveAddr = session.selectOne("getSaveAddr", "PRO");
        }
        if (env.contains("DEV") || env.contains("dev")) {
            saveAddr = session.selectOne("getSaveAddr", "DEV");
        }
        if (env.contains("TEST") || env.contains("test")) {
            saveAddr = session.selectOne("getSaveAddr", "TEST");
        }

        return saveAddr.getAddress();
    }

    public static void main(String[] args) {
        try {
            System.out.println("本次请求的token：" + getSaveAddr(EnvNum.PRO));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
