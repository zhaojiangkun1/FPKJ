package com.shuzutech.model;

import com.shuzutech.bean.SaveFpInfo;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetSaveFpInfo {
    public static SaveFpInfo getSaveFpInfo() throws IOException {
        SaveFpInfo saveFpInfo = new SaveFpInfo();
        SqlSession session = DataBaseUtil.getSqlSession();
        saveFpInfo = session.selectOne("getFpInfo");
        return saveFpInfo;
    }
}
