package Case;

import Bean.*;
import Config.GetInvoiceCase;
import Model.GongYouFangFa;
import Model.Java2XML;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Ghdwyhzh {
    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String, String> map = new HashMap();


    @Test(groups = {"异常开票"}, description = "购货单位银行账号长度过长")
    public void ghdwyhzh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("ghdwyhzh", "中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918中国建设银行股份有限公司上海张江支行31050161393600001918");
        invoiceCase = GetInvoiceCase.getInvoiceCase("ghdwyhzh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }
}
