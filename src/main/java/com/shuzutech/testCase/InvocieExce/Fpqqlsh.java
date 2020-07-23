package testCase.InvocieExce;

import com.shuzutech.bean.EnvNum;
import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.config.GetInvoiceCase;
import com.shuzutech.config.UpdateFpqqlsh;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Fpqqlsh {

    JSONObject expectedResult = new JSONObject();
    InvoiceCase invoiceCase = new InvoiceCase();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"异常开票"},description = "发票请求流水号为空")
    public void fpqqlsh_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh", "");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "发票请求流水号为1个数字",priority = 4)
    public void fpqqlsh_0002() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh","0");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "发票请求流水号为1个字母")
    public void fpqqlsh_0003() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh",String.valueOf(UpdateFpqqlsh.randGenerated()));
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "发票请求流水号为64位数字")
    public void fpqqlsh_0004() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh", UpdateFpqqlsh.numbers64());
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0004");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "发票请求流水号为64位字母")
    public void fpqqlsh_0005() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh", UpdateFpqqlsh.letters64());
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0005");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "发票请求流水号为字母和数字的组合")
    public void fpqqlsh_0006() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh", UpdateFpqqlsh.numbersLetters());
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0006");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "发票请求流水号为65位")
    public void fpqqlsh_0007() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("fpqqlsh",UpdateFpqqlsh.numbers64()+"A");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0007");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }


    @Test(groups = {"异常开票"},description = "发票请求流水号含有特殊字符")
    public void fpqqlsh_0008() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","1111%%￥&jhhhd");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0008");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "发票请求流水号为null")
    public void fpqqlsh_0009() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh",null);
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0009");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"异常开票"},description = "同一应用开票，发票请求流水号相同")
    public void fpqqlsh_0010() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","0");
        invoiceCase = GetInvoiceCase.getInvoiceCase("fpqqlsh_0010");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"正常开票"},description = "不同应用，发票请求流水号相同")
    public void fpqqlsh11() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","0");
        System.out.println("本次请求的报文:"+Java2XML.BuildXMLDoc(map));
        expectedResult.put("returncode",0);
        expectedResult.put("returnmsg","提交成功，请稍后查询");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), EnvNum.DEV1);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }







}
