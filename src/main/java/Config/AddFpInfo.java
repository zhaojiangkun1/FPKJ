package Config;

import Bean.SaveFpInfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class AddFpInfo {

    public static int getFpInfoId() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        SaveFpInfo saveFpInfo = session.selectOne("getFpInfo");
        return saveFpInfo.getId();
    }


    public static void updateFpInfo(SaveFpInfo saveFpInfo) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        session.update("insertfpinfo",saveFpInfo);
        session.commit();
    }
}
