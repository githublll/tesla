package com.example.sumsang_rookie.mytab;

public class OperateItem {
    private String operateName;
    private int imageId;
    public OperateItem(String operateName,int imageId) {
        this.operateName=operateName;
        this.imageId=imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getOperateName() {
        return operateName;
    }
}
