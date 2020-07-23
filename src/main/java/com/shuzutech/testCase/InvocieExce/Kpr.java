package testCase.InvocieExce;

import com.shuzutech.bean.*;
import com.shuzutech.config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Kpr {

    /**
     * 开票人 复核人 审核人，如果不填，则读取设置的默认开票人，如果没有默认开票人，则必须要填开票人，否则开票失败
     */
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"正常开票"}, description = "开票人为管理员")
    public void kpr_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("kpr", "管理员");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("kpr_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "开票人为null")
    public void kpr_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("kpr", null);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("kpr_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"正常开票"}, description = "开票人含特殊字符")
    public void kpr_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("kpr2", "#%$%%#$%😄");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("kpr_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
