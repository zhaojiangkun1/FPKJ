package com.shuzutech.testCase.InvocieExce;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class De {
    //dw-spsl-dj-je-sl-se
    JSONObject expectedResult = new JSONObject();
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"正常开票"}, description = "单位商品数量单价税率税额均合理")
    public void de_0001() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh","110101201707010064~~110101201707010064");
        map.put("shnsrsbh","110101201707010064");
        map.put("fplxdm", "026");
        map.put("dw", "个");
        map.put("spsl", "2.9");
        map.put("dj", "32.1");
        map.put("je", "93.09");
        map.put("sl", "0.13");
        map.put("se", "12.10");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("de_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "不含税金额*税率与税额误差大于 0.06")
    public void de_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("dw", "组");
        map.put("spsl", "10");
        map.put("dj", "32.1");
        map.put("je", "321");
        map.put("sl", "0.03");
        map.put("se", "10");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("de_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "数量*单价与金额误差大于 0.01")
    public void de_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("spsl", "11");
        map.put("dj", "32.1");
        map.put("je", "321");
        map.put("sl", "0.03");
        map.put("se", "9.63");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("de_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
