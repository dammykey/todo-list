package com.d1.QuickToDO.request;

public class AddUserRequest {
    private String uname;

    public AddUserRequest() {
    }

    public AddUserRequest(String uname, String pword) {
        this.uname = uname;
        this.pword = pword;
    }



    public String getUname() {
        return uname;
    }


    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    private String pword;

}
