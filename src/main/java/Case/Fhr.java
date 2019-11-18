package Case;
import Bean.*;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Fhr {
    HashMap<String,String> map = new HashMap();
    InvoiceCase invoiceCase = new InvoiceCase();

    @Test(groups = {"正常开票"},description = "复核人为空")
    public void  fhr_0001() throws IOException,NoSuchAlgorithmException{
        map.put("fhr","");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fhr_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "复核人为Null")
    public void  fhr_0002() throws IOException,NoSuchAlgorithmException{
        map.put("fhr",null);
        invoiceCase = GetInvoiceCase.getInvoiceCase("fhr_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "复核人含特殊字符")
    public void  fhr_0003() throws IOException,NoSuchAlgorithmException{
        map.put("fhr","#$%@%#%#😄@！@#");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fhr_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }
}
