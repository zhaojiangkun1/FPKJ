package com.shuzutech.model;

import com.shuzutech.bean.SaveFpInfo;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class SaveInvoiceMessage {

    public void saveSuccessInvoiceMessage(HashMap<String, String> map, Date date) throws IOException {
        int id = GetSaveFpInfo.getSaveFpInfo().getId() + 1;
        SqlSession session = DataBaseUtil.getSqlSession();
        SaveFpInfo saveFpInfo = new SaveFpInfo();
        saveFpInfo.setId(id);
        if (map.containsKey("jsbh")){
            saveFpInfo.setJsbh(map.get("jsbh"));
        }
       if (map.containsKey("kpzdbs")){
           saveFpInfo.setJsbh(map.get("kpzdbs"));
       }
        saveFpInfo.setFpqqlsh(map.get("fpqqlsh"));
        saveFpInfo.setFplxdm(map.get("fplxdm"));
        saveFpInfo.setFpdm(map.get("fpdm"));
        saveFpInfo.setFphm(map.get("fphm"));
        saveFpInfo.setUpdateTime(date);
        session.insert("insertFpInfo", saveFpInfo);
        session.commit();
    }
}
