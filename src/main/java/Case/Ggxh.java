package Case;

import Bean.*;
import Config.GetInvoiceCase;
import Model.GongYouFangFa;
import Model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Ggxh {
    /**
     * 规格型号可以含有特殊字符
     */
    HashMap<String, String> map = new HashMap();
    InvoiceCase invoiceCase = new InvoiceCase();

    @Test(groups = {"正常开票"}, description = "开票参数含有规格型号")
    public void ggxh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "025");
//        map.put("spmc","氨糖软骨素钙片");
        map.put("ggxh", "285.6g(1.02g*80片*1瓶+1.02g*100片*2瓶)");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ggxh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
