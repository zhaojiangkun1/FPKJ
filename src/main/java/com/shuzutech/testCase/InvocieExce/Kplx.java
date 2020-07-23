package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Kplx {

    HashMap<String, String> map = new HashMap();


    @Test(groups = {"异常开票"}, description = "开票其它参数均正常，开票类型为空")
    public void kplx_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("kplx", "");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("kplx_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "开票其它参数均正常，开票类型为null")
    public void kplx_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("kplx", null);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("kplx_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "开票其它参数均正常，开票类型为2")
    public void kplx_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("kplx", "2");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("kplx_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

}
