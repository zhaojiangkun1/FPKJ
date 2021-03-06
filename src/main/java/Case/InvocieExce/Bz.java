package Case.InvocieExce;

import Bean.*;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Bz {

    HashMap<String, String> map = new HashMap();
    InvoiceCase invoiceCase = new InvoiceCase();

    @Test(groups = {"正常开票"}, description = "备注长度为空")
    public void bz_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("bz", "");
        invoiceCase = GetInvoiceCase.getInvoiceCase("bz_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"正常开票"}, description = "备注长度为null")
    public void bz_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("bz", null);
        invoiceCase = GetInvoiceCase.getInvoiceCase("bz_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "备注长度超过数据库存储长度")
    public void bz_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("bz", "1------------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "----------------------------------------------------------------" +
                "----------------1-----------------------------------------------" +
                "-------------------------------------------------");
        invoiceCase = GetInvoiceCase.getInvoiceCase("bz_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
