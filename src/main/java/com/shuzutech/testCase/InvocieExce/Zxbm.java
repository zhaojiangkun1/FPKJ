package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Zxbm {
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"正常开票"}, description = "自行编码为00")
    public void zxbm_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("zxbm", "00");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zxbm_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);

    }

    @Test(groups = {"正常开票"}, description = "自行编码为null")
    public void zxbm_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("zxbm", null);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("zxbm_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

}
