package com.nuc.project.entity;

/**
 * @author changzhibin
 * @create 2023-01-25-11:43
 * 物流信息实体类，用于测试git
 */
public class Logistics {
    private String logisticsId;
    private String logisticsName;

    public Logistics() {
    }

    public Logistics(String logisticsId, String logisticsName) {
        this.logisticsId = logisticsId;
        this.logisticsName = logisticsName;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "logisticsId='" + logisticsId + '\'' +
                ", logisticsName='" + logisticsName + '\'' +
                '}';
    }
}
