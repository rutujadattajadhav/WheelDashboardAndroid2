package com.railway.wheeldashboard.signup;

public class ResistrationBean {

    private String fname;

    private String lname;


    private String mob;


    private String password;


    private String confirmpassword;


    private String email;


//    public ResistrationBean(String fname, String lname, String mob, String password, String confirmpassword, String email) {
//        this.fname = fname;
//        this.lname = lname;
//        this.mob = mob;
//        this.password = password;
//        this.confirmpassword = confirmpassword;
//        this.email = email;
//    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
