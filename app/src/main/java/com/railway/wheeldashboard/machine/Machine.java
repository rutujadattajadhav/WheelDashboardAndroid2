package com.railway.wheeldashboard.machine;

import com.google.gson.annotations.SerializedName;

public class Machine {
    private Long id;

    @SerializedName("plantNo")
    private Integer plantNo;

    @SerializedName("description")
    private String description;

    @SerializedName("make")
    private String make;

    @SerializedName("acquisitionDate")
    private String acquisitionDate;

    @SerializedName("capacity")
    private String capacity;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlantNo() {
        return plantNo;
    }

    public void setPlantNo(Integer plantNo) {
        this.plantNo = plantNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
