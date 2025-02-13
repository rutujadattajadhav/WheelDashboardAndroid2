package com.railway.wheeldashboard.axleRejection;

public class AxleRejectionModel {

    private Long id;
    private String axleNo;
    private Integer yearOfMfg;
    private String reasonOfRejectionAxle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAxleNo() {
        return axleNo;
    }

    public void setAxleNo(String axleNo) {
        this.axleNo = axleNo;
    }

    public Integer getYearOfMfg() {
        return yearOfMfg;
    }

    public void setYearOfMfg(Integer yearOfMfg) {
        this.yearOfMfg = yearOfMfg;
    }

    public String getReasonOfRejectionAxle() {
        return reasonOfRejectionAxle;
    }

    public void setReasonOfRejectionAxle(String reasonOfRejectionAxle) {
        this.reasonOfRejectionAxle = reasonOfRejectionAxle;
    }
}
