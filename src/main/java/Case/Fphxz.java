package Case;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.GongYouFangFa;
import Model.Java2XML;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Fphxz {
    HashMap<String,String> map = new HashMap();
    InvoiceCase invoiceCase = new InvoiceCase();

    @Test(groups = {"异常开票"},description = "非折扣行商品，单个商品的发票行性质为空")
    public void  fphxz_0001() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fphxz_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "非折扣行商品，单个商品发票行性质为1")
    public void  fphxz_0002() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","1");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fphxz_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);

    }

    @Test(groups = {"异常开票"},description = "非折扣行商品，单个商品的发票行性质为2")
    public void  fphxz_0003() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","2");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fphxz_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "单个商品的发票行性质为null")
    public void  fphxz_0004() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz",null);
        invoiceCase = GetInvoiceCase.getInvoiceCase("fphxz_0004");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "单个商品的发票行性质为3")
    public void fphxz5() throws IOException, NoSuchAlgorithmException {
        map.put("fphxz","3");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fphxz_0005");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);

    }
}
