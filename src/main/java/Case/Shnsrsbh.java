package Case;

import Bean.InvoiceCase;
import Bean.TestEnv;
import Config.GetInvoiceCase;
import Model.*;;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Shnsrsbh {
    HashMap map = new HashMap();

    /**
     * 销方纳税人识别号和机身编号有关系
     * 如果机身编号且存在填了，则允许销方纳税人识别号为空，否则必须存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "销方纳税人识别号与机身编号同时为空")
    public void shnsrsbh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("shnsrsbh","");
        map.put("jsbh","");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("shnsrsbh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    /**
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "销方纳税人识别号与机身编号中税号不一致")
    public void shnsrsbh_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("shnsrsbh","000012312312312");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("shnsrsbh_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "机身编号存在，但是销方纳税人识别号为空")
    public void shnsrsbh_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("shnsrsbh","");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("shnsrsbh_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }


}
