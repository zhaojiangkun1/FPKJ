package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Bz {

    HashMap<String, String> map = new HashMap();

    @Test(groups = {"正常开票"}, description = "备注长度为空")
    public void bz_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("bz", "");
       InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("bz_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"正常开票"}, description = "备注长度为null")
    public void bz_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("bz", null);
       InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("bz_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    /**
     * 165也能开出来
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"}, description = "备注长度超过数据库存储长度")
    public void bz_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
//        map.put("fpqqlsh","Lm20820200724114212");
        map.put("bz", "888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888213123131231231243526");
       InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("bz_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
