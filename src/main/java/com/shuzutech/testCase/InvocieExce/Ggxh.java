package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Ggxh {
    /**
     * 规格型号可以含有特殊字符
     * 旋极，税控服务器，规格型号：45
     * 合力：规格型号：39
     */
    HashMap<String, String> map = InvoiceParamters.hashMap("026");
    InvoiceCase invoiceCase = new InvoiceCase();

    @Test(groups = {"正常开票"}, description = "开票参数含有规格型号")
    public void ggxh_0001() throws IOException, NoSuchAlgorithmException {
//        map.put("fpqqlsh","de67820200724140714");
//        map.put("spmc","氨糖软骨素钙片");
        map.put("ggxh", "285.6g(1.02g*80片*1瓶+1.02g*100片*222");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ggxh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
