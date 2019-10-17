package Model;

import com.alibaba.fastjson.JSONObject;

public class AcquireSubstr {

    public static JSONObject analyzeString(String result){
        String leftTag1 = "<returncode>";
        String rightTag1 = "</returncode>";
        String leftTag2 = "<returnmsg>";
        String rightTag2 = "</returnmsg>";

        String returnCode = result.substring(result.indexOf(leftTag1)+leftTag1.length(),result.indexOf(rightTag1));
        String returnmsg = result.substring(result.indexOf(leftTag2)+leftTag2.length(),result.indexOf(rightTag2));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returncode",returnCode);
        jsonObject.put("returnmsg",returnmsg);

        return jsonObject;

    }

}
