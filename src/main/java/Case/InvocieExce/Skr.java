package Case.InvocieExce;

import Bean.*;
import Config.GetInvoiceCase;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Skr {

    HashMap<String, String> map = new HashMap();

    @Test(groups = {"正常开票"}, description = "收款人为空")
    public void skr_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("skr", "");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("skr_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"正常开票"}, description = "收款人为null")
    public void skr_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("skr", null);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("skr_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
