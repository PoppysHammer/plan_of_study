package org.example.demo.design;

public class AwardRes {

    private String resCode;

    private String msg;

    public AwardRes() {
    }

    public AwardRes(String resCode, String msg) {
        this.resCode = resCode;
        this.msg = msg;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
