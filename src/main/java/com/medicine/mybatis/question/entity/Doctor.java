package com.medicine.mybatis.question.entity;

public class Doctor {
    private int doctor_id;
    private String doctor_name;
    private String position;
    private String hosptial;
    private String job;
    private String jointime;
    private String adept;
    private String introduce;
    private int helpnum;
    private int adoptrate;
    private int satisfatdegree;

    public Doctor(){
    }
    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHosptial() {
        return hosptial;
    }

    public void setHosptial(String hosptial) {
        this.hosptial = hosptial;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getHelpnum() {
        return helpnum;
    }

    public void setHelpnum(int helpnum) {
        this.helpnum = helpnum;
    }

    public int getAdoptrate() {
        return adoptrate;
    }

    public void setAdoptrate(int adoptrate) {
        this.adoptrate = adoptrate;
    }

    public int getSatisfatdegree() {
        return satisfatdegree;
    }

    public void setSatisfatdegree(int satisfatdegree) {
        this.satisfatdegree = satisfatdegree;
    }
}
