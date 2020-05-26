package Case.InvocieExce;

import Bean.*;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Ghdwdzdh {
    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = new HashMap();

    @Test(groups = {"异常开票"}, description = "专票开具，其购货单位地址电话为空")
    public void ghdwdzdh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "004");
        map.put("ghdwdzdh", "");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwdzdh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    /**
     * 购货单位地址电话未做特殊字符校验
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"正常开票"}, description = "除专票外，其它票种购货单位地址电话为null")
    public void ghdwdzdh_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("ghdwdzdh", null);
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwdzdh_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"异常开票"}, description = "购货单位地址电话长度过长")
    public void ghdwdzdh_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("ghdwdzdh", "南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司南京数族信息科技有限公司");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwdzdh_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

}
