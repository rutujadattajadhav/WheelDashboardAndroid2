package com.railway.wheeldashboard.breakdownhistory;

public class BreakdownHistory {
    public BreakdownHistory(Long serialNumber, Long id, String plantName, String issue, Integer noOfDays, String fromDate, String toDate) {
        this.serialNumber = serialNumber;
        this.id = id;
        this.plantName = plantName;
        this.issue = issue;
        this.noOfDays = noOfDays;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    private Long serialNumber;
    private Long id;
    private String plantName;
    private String issue;
    private Integer noOfDays;
    private String fromDate;
    private String toDate;

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

}
