package com.shuzutech.testCase.Invoice;

import com.shuzutech.bean.*;
import com.shuzutech.model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import static com.shuzutech.config.GetInvoiceCase.*;
import static com.shuzutech.model.GongYouFangFa.gongYouFangFa;

public class JuanPiao {

    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = InvoiceParamters.hashMap("025");

    @Test(groups = {"开具卷票"}, description = "所有参数均正常，开具一张卷票")
    public void juanPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "025");
        map.put("shnsrsbh","");
        map.put("readonly", "0");
        invoiceCase = getInvoiceCase("juanPiao_0001");
        gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"冲红卷票"}, description = "所有参数均正常，开具一张负数卷票")
    public void juanPiaoChongHong_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "025");
        map.put("kplx", "1");
        map.put("sprsjh", "");
        map.put("spsl", "-1");
        map.put("hsje", "-299");
        map.put("se", "-18.04");
        map.put("yfpdm", "150001201509");
        map.put("yfphm", "20191099");
        invoiceCase = getInvoiceCase("juanPiao_0002");
        gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张6行商品的卷票")
    public void multiGroupJuanPiao_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","025");
        map.put("shnsrsbh","");
        String file = Java2XML.BuildXMLDoc(map,6);
        invoiceCase = getInvoiceCase("juanPiao_0003");
        gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张8行商品的卷票")
    public void multiGroupJuanPiao_0004() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","025");
        String file = Java2XML.BuildXMLDoc(map,8);
        invoiceCase = getInvoiceCase("juanPiao_0004");
        gongYouFangFa(file, invoiceCase);
    }

    @Test(groups = {"多行卷票开具"}, description = "所有参数均正常，开具一张超过8行商品的卷票")
    public void multiGroupJuanPiao_0005() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","025");
        map.put("shnsrsbh","");
        String file = Java2XML.BuildXMLDoc(map,10);
        InvoiceCase invoiceCase = getInvoiceCase("juanPiao_0005");
        gongYouFangFa(file, invoiceCase);
    }


}
