package com.shuzutech.config;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.InvoiceCase;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetInvoiceCase {

    public static InvoiceCase getInvoiceCase(String id) throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        InvoiceCase invoiceCase = sqlSession.selectOne("queryInvoiceCase", id);
        return invoiceCase;
    }

    public static JSONObject expectedResult(int statusCode, String returnMsg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode", statusCode);
        jsonObject.put("returnmsg", returnMsg);

        return jsonObject;
    }
}
