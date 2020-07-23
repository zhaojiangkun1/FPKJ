package com.shuzutech.bean;

import java.util.Objects;

public class InvoiceCase {
    private String id;
    private String title;
    private String priority;
    private int statusCode;
    private String returnMsg;
    private String runResult;
    private String runStatus;

    public InvoiceCase() {
    }

    public InvoiceCase(String id, String title, String priority, int statusCode, String returnMsg, String runResult, String runStatus) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.statusCode = statusCode;
        this.returnMsg = returnMsg;
        this.runResult = runResult;
        this.runStatus = runStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getRunResult() {
        return runResult;
    }

    public void setRunResult(String runResult) {
        this.runResult = runResult;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceCase that = (InvoiceCase) o;
        return statusCode == that.statusCode &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(returnMsg, that.returnMsg) &&
                Objects.equals(runResult, that.runResult) &&
                Objects.equals(runStatus, that.runStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, priority, statusCode, returnMsg, runResult, runStatus);
    }

    @Override
    public String toString() {
        return "InvoiceCase{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", priority='" + priority + '\'' +
                ", statusCode=" + statusCode +
                ", returnMsg='" + returnMsg + '\'' +
                ", runResult='" + runResult + '\'' +
                ", runStatus='" + runStatus + '\'' +
                '}';
    }
}
