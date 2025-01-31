package com.railway.wheeldashboard.wheelPohDetail;

import com.google.gson.annotations.SerializedName;

public class WheelPoh {
    private Long id;

    @SerializedName("date")
    private String date;

    @SerializedName("wheelNo")
    private String wheelNo;

    @SerializedName("wheelType")
    private String wheelType;

    @SerializedName("treadDia")
    private Integer treadDia;

    @SerializedName("flange")
    private Double flange;

    @SerializedName("journalDiaA")
    private Double journalDiaA;

    @SerializedName("snpdBearingA")
    private String snpdBearingA;

    @SerializedName("bearingMake")
    private String bearingMake;

    @SerializedName("shrinkingA")
    private Double shrinkingA;

    @SerializedName("journalDiaB")
    private Double journalDiaB;

    @SerializedName("snpdBearingB")
    private String snpdBearingB;

    @SerializedName("shrinkingB")
    private Double shrinkingB;

    @SerializedName("ust")
    private String ust;

    @SerializedName("bearing")
    private String bearing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWheelNo() {
        return wheelNo;
    }

    public void setWheelNo(String wheelNo) {
        this.wheelNo = wheelNo;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    public Integer getTreadDia() {
        return treadDia;
    }

    public void setTreadDia(Integer treadDia) {
        this.treadDia = treadDia;
    }

    public Double getFlange() {
        return flange;
    }

    public void setFlange(Double flange) {
        this.flange = flange;
    }

    public Double getJournalDiaA() {
        return journalDiaA;
    }

    public void setJournalDiaA(Double journalDiaA) {
        this.journalDiaA = journalDiaA;
    }

    public String getSnpdBearingA() {
        return snpdBearingA;
    }

    public void setSnpdBearingA(String snpdBearingA) {
        this.snpdBearingA = snpdBearingA;
    }

    public String getBearingMake() {
        return bearingMake;
    }

    public void setBearingMake(String bearingMake) {
        this.bearingMake = bearingMake;
    }

    public Double getShrinkingA() {
        return shrinkingA;
    }

    public void setShrinkingA(Double shrinkingA) {
        this.shrinkingA = shrinkingA;
    }

    public Double getJournalDiaB() {
        return journalDiaB;
    }

    public void setJournalDiaB(Double journalDiaB) {
        this.journalDiaB = journalDiaB;
    }

    public String getSnpdBearingB() {
        return snpdBearingB;
    }

    public void setSnpdBearingB(String snpdBearingB) {
        this.snpdBearingB = snpdBearingB;
    }

    public Double getShrinkingB() {
        return shrinkingB;
    }

    public void setShrinkingB(Double shrinkingB) {
        this.shrinkingB = shrinkingB;
    }

    public String getUst() {
        return ust;
    }

    public void setUst(String ust) {
        this.ust = ust;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }
}
