package com.example.bomin_project;

public class RideData {
    private String pm_name;
    private String pm_distance;
    private String pm_date;
    private String pm_time;

    public RideData(String pm_name, String pm_distance, String pm_date, String pm_time) {
        this.pm_name = pm_name;
        this.pm_distance = pm_distance;
        this.pm_date = pm_date;
        this.pm_time = pm_time;
    }

    public String getPm_distance(){return pm_distance;}
    public String getPm_time(){return pm_time;}
    public String getPm_name(){return pm_name;}
    public String getPm_date(){return pm_date;}

}