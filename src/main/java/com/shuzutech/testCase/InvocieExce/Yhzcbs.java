package com.shuzutech.testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.model.GongYouFangFa;
import com.shuzutech.model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Yhzcbs {
    HashMap<String, String> map = new HashMap();


    @Test(groups = {"正常开票"}, description = "优惠政策标识为1,增值税特殊管理为免税")
    public void yhzcbs_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("yhzcbs", "1");
        map.put("zzstsgl", "免税");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yhzcbs_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "优惠政策标识含特殊字符")
    public void yhzcbs_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        //入库失败(业务单据明细表)
        map.put("yhzcbs", "*&&&&&");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("yhzcbs_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
