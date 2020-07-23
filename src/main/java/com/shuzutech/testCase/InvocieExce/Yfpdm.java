package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Yfpdm {
    HashMap<String, String> map = new HashMap();

    /**
     * 存在已开具的正数发票
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"异常开票"}, description = "当开票类型为1时,只有原发票代码")
    public void yfpdm_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("kplx", "1");
        map.put("dj", "6");
        map.put("spsl", "-1");
        map.put("je", "-6");
        map.put("sl", "0.03");
        map.put("se", "-0.18");
        map.put("yfpdm", "150000456123");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yfpdm_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "当开票类型为1时,只有原发票号码")
    public void yfpdm_0002() throws IOException, NoSuchAlgorithmException {
        map.put("kplx", "1");
        map.put("dj", "6");
        map.put("spsl", "-1");
        map.put("je", "-6");
        map.put("sl", "0.03");
        map.put("se", "-0.18");
        map.put("yfphm", "20201329");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yfpdm_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


    @Test(groups = {"异常开票"}, description = "负数发票，原发票不存在")
    public void yfpdm_0003() throws IOException, NoSuchAlgorithmException {
        map.put("kplx", "1");
        map.put("dj", "6");
        map.put("spsl", "-1");
        map.put("je", "-6");
        map.put("sl", "0.03");
        map.put("se", "-0.18");
        map.put("yfpdm", "0300001002");
        map.put("yfphm", "20201329");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yfpdm_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

}