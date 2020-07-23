package com.shuzutech.config;

import com.shuzutech.bean.SaveFpInfo;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import java.io.IOException;
import java.util.Date;


public class AddFpInfo {

    public static int getFpInfoId() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        SaveFpInfo saveFpInfo = session.selectOne("getFpInfo");
        return saveFpInfo.getId();
    }


    public static void updateFpInfo(SaveFpInfo saveFpInfo) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        session.update("insertfpinfo", saveFpInfo);
        session.commit();
    }

    public static void addFpInfo(String file) {
        Document document = null;
        try {
            document = DocumentHelper.parseText(file);//将字符串转换成XML
            Element rootElt = document.getRootElement();//获取根节点
            String nsrsbh = "";
            Element bodyEle = rootElt.element("body");//获取body节点
            Element inputEle = bodyEle.element("input");//获取input节点
            String shnsrsbh = inputEle.elementTextTrim("shnsrsbh");
            if (shnsrsbh == null || shnsrsbh.equals("")){
                String jsbh = inputEle.elementTextTrim("jsbh");
                System.out.println(jsbh.indexOf('~'));
                nsrsbh = jsbh.substring(0,jsbh.indexOf('~'));
            }
            else {
                nsrsbh = shnsrsbh;
            }
            String fplxdm = inputEle.elementTextTrim("fplxdm");
            String fpqqlsh = inputEle.elementTextTrim("fpqqlsh");
            SaveFpInfo saveFpInfo = new SaveFpInfo();
            saveFpInfo.setId(getFpInfoId() + 1);
            saveFpInfo.setFpqqlsh(fpqqlsh);
            saveFpInfo.setNsrsbh(nsrsbh);
            saveFpInfo.setFplxdm(fplxdm);
            Date date = new Date();
            saveFpInfo.setUpdateTime(date);
            updateFpInfo(saveFpInfo);


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
