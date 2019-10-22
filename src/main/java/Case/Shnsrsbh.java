package Case;

import Bean.TestEnv;
import Config.UpdateFpqqlsh;
import Model.AcquireSubstr;;
import Model.Java2XML;
import Model.PostRequest;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Shnsrsbh {
    HashMap map = new HashMap();

    @Test(description = "销方纳税人识别号为空")
    public void shnsrsbh1() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","");
        map.put("fpqqlsh", UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
    }

    @Test(groups = {"异常开票"},description = "销方纳税人识别号与机身编号中税号不一致")
    public void shnsrsbh2() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","12312312312312");
        map.put("fpqqlsh", UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode","1000050");
        jsonObject.put("returnmsg","机身编号\n" +
                "中的税号与传入的纳税人识别号不一致");
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject jsonObject1 = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,jsonObject1);
    }


}
