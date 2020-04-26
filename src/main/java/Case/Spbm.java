package Case;

import Bean.*;
import Config.GetInvoiceCase;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Spbm {
    HashMap<String, String> map = new HashMap();

    /**
     * 商品：如果该商户在老板通上配置了默认商品，则不传商品，取老板通上默认商品，否则报错
     * 商品编码相关节点应该全部存在或不存在
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"}, description = "存在商品信息，但是商品编码为空")
    public void spbm_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm", "026");
        map.put("spbm", "");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("spbm_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }


    @Test(groups = {"异常开票"}, description = "传入商品编码在局端不存在")
    public void spbm_0002() throws IOException, NoSuchAlgorithmException {
        map.put("spbm", "84796000");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("spbm_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

    @Test(groups = {"正常开票"}, description = "该商户在老板通上存在默认商品，只传商品金额等信息，不传商品名称及商品编码")
    public void spbm_0003() throws IOException, NoSuchAlgorithmException {
        map.put("spmc", "");
        map.put("spsl", "1");
        map.put("dj", "6.3");
        map.put("je", "6.3");
        map.put("sl", "0");
        map.put("se", "0");
        map.put("spbm", "");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("spbm_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map), invoiceCase);
    }

}
