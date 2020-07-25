package com.shuzutech.model;

import java.util.ArrayList;

public class GroupModelList {

    public static ArrayList<GroupModel> groupModelArrayList() {
        ArrayList<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel = new GroupModel("马铃薯", "16", "0.03", "0.48", "1010102010000000000");
        GroupModel groupModel1 = new GroupModel("苹果", "10", "0.03", "0.3", "1010115019900000000");
        GroupModel groupModel2 = new GroupModel("停车费", "10", "0.09", "0.9", "3040502020200000000");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        groupModels.add(groupModel2);
        return groupModels;
    }

    public static ArrayList<GroupModel> groupModelArrayListRed(){
        ArrayList<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel = new GroupModel("马铃薯", "-16", "0.03", "-0.48", "1010102010000000000");
        GroupModel groupModel1 = new GroupModel("苹果", "-10", "0.03", "-0.3", "1010115019900000000");
        GroupModel groupModel2 = new GroupModel("停车费", "-10", "0.09", "-0.9", "3040502020200000000");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        groupModels.add(groupModel2);
        return groupModels;

    }

}
