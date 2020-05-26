package Case.InvocieExce;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Ghdwmc {
    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"异常开票"}, description = "购货单位名称为空")
    public void ghdwmc_0002() throws IOException, NoSuchAlgorithmException {
        map.put("ghdwmc", "");
        map.put("fplxdm","026");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwmc_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "购货单位名称为null")
    public void ghdwmc_0001() throws IOException, NoSuchAlgorithmException {
        map.put("ghdwmc", null);
        map.put("fplxdm","026");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwmc_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "购货单位名称过长")
    public void ghdwmc_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("ghdwmc", "南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwmc_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


}
