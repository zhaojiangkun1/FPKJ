package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Yhlx {
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"正常开票"}, description = "yhlx用户类型为空")
    public void yhlx_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("yhlx", "");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yhlx_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    /**
     * 用户类型为3，也默认开票成功（电子发票）,也就是当用户类型不存在，则怀疑是取了扫码台的发票配置
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"}, description = "用户类型3")
    public void yhlx_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("yhlx", "3");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yhlx_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}


