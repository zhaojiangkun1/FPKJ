package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Jsbh {

    HashMap<String, String> map = new HashMap();
    InvoiceCase invoiceCase = new InvoiceCase();

    /**
     * 机身编号为空(null)的话。如果纳税人识别号是正常，会从识别号找设备。
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"正常开票"}, description = "机身编号为空")
    public void jsbh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("jsbh", "");
        invoiceCase = GetInvoiceCase.getInvoiceCase("jsbh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


    /**
     * 机身编号格式不正确
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"}, description = "开票终端标识~~纳税人标号")
    public void jsbh_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("jsbh", "110101201707010043~~499000152157");
        invoiceCase = GetInvoiceCase.getInvoiceCase("jsbh_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
