package com.shuzutech.testCase.baiwangtong;

import com.shuzutech.bean.EnvNum;
import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import com.shuzutech.model.PostRequest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class BaiWangTongDianPiao {
    HashMap<String, String> map = new HashMap<>();

    /**
     * zsfs  传1  会报商品信息不合法
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"开具电票"}, description = "所有参数都正常，开具一张电票")
    public void dianPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", InvoiceParamters.bwt_jpfplxdm);
        map.put("shnsrsbh", InvoiceParamters.nsrsbh);
        map.put("kpzdbs", InvoiceParamters.kpzdbs);
        map.put("ghdwmc","上海盛付通电子支付服务有限公司");
        map.put("ghdwsbh","9131011567624841X0");
        map.put("gwdwdzdh","");
        map.put("gwdwyhzh","");
        map.put("spmc", "服务费");
        map.put("spsl","");
        map.put("dj","");
        map.put("je","1309.39");
        map.put("sl","0.06");
        map.put("se","78.56");
        map.put("zsfs","0");
        map.put("spsm","");
//        map.put("sprsjh", "13701476279");
//        System.out.println(Java2XML.BuildXMLDoc(map));
        PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), EnvNum.bwt_test);
    }

    @Test(groups = {"自助开票"},description = "所有参数都正常，自助开票")
    public void ziZhuKaiPiao_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", InvoiceParamters.bwt_dzfplxdm);
        map.put("shnsrsbh", InvoiceParamters.nsrsbh);
        map.put("kpzdbs", InvoiceParamters.kpzdbs);
//        map.put("fpqqlsh","Rf37720200611141153");
//        map.put("je","282.075");
        map.put("fplxdm","026");
        map.put("yhlx","1");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"电票冲红"},description = "所有参数均正常，开具一张负数发票")
    public void dianPiao_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", InvoiceParamters.bwt_dzfplxdm);
        map.put("shnsrsbh", InvoiceParamters.nsrsbh);
        map.put("kpzdbs", InvoiceParamters.kpzdbs);
        map.put("kplx","1");
        map.put("spmc","大米");
        map.put("spsl","-3");
        map.put("dj","2.3000");
        map.put("je","-6.90");
        map.put("sl","0.03");
        map.put("se","-0.21");
        map.put("yfpdm","150003521565");
        map.put("yfphm","49955150");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
