package testCase.InvocieExce;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Ghdwsbh {
    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"异常开票"}, description = "专票开具，购货单位识别号为空")
    public void ghdwsbh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "004");
        map.put("ghdwsbh", "");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwsbh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


    @Test(groups = {"正常开票"}, description = "购货单位识别号为null,开个人发票")
    public void ghdwsbh_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("ghdwmc", "个人");
        map.put("ghdwsbh", null);
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwsbh_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
