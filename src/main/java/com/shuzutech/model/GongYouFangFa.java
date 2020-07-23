package Model;

import com.shuzutech.bean.InvoiceCase;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.AddFpInfo;
import com.shuzutech.config.DataBaseUtil;
import com.shuzutech.config.GetInvoiceCase;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GongYouFangFa {

    public static void gongYouFangFa(String file, InvoiceCase invoiceCase) throws IOException, NoSuchAlgorithmException {
        JSONObject expectedResult = GetInvoiceCase.expectedResult(invoiceCase.getStatusCode(), invoiceCase.getReturnMsg());
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        String runStatus = "";
        if (expectedResult.toString().equals(actualResult.toString())) {
            runStatus = "Pass";
        } else {
            runStatus = "Failed";
        }

        invoiceCase.setRunResult(actualResult.toString());
        invoiceCase.setRunStatus(runStatus);
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        sqlSession.update("updateResult", invoiceCase);
        sqlSession.commit();
        AddFpInfo.addFpInfo(file);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
