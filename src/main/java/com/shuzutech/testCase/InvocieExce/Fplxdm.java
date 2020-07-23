package com.shuzutech.testCase.InvocieExce;


import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Fplxdm {
    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = new HashMap();

    /**
     * 为null和为空是一致的
     * 发票类型代码为空，分两种情况
     * 1）如果在老板通——扫码台配置的界面，配置了默认开票的发票类型，则取这个默认值
     * 2）如果未配置默认的开票类型，则发票类型代码必须为空
     * <p>
     * 商户扫码台开票企业信息未正确配置
     * 1000025
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"异常开票"}, description = "开票其它参数正常，发票类型代码为空")
    public void fplxdm_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fplxdm_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    /**
     * 发票类型代码不存在  若商户扫码台开票企业信息未正确配置，则开票失败，否则开票成功
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"}, description = "开票其它参数正常，发票类型代码为027")
    public void fplxdm2() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "027");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fplxdm_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
