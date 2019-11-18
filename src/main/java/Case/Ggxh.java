package Case;
import Bean.*;
import Config.GetInvoiceCase;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Ggxh {
    /**
     * 规格型号可以含有特殊字符
     */
    HashMap<String,String> map = new HashMap();
    InvoiceCase invoiceCase = new InvoiceCase();

    @Test(groups = {"正常开票"},description = "开票参数含有规格型号")
    public void  ggxh_0001() throws IOException,NoSuchAlgorithmException{
        map.put("ggxh","10");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ggxh_0001");
    }

}
