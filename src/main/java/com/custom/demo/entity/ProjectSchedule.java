package com.custom.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project_schedule")
public class ProjectSchedule implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 名字
     */
    @Column(name = "schedule_name")
    private String scheduleName;
    /**
     * 描述
     */
    @Column(name = "schedule_describe")
    private String scheduleDescribe;
    /**
     * 类型：0前端，1后端
     */
    @Column(name = "schedule_type")
    private Integer scheduleType;
    /**
     * 提出人
     */
    @Column(name = "schedule_initiator")
    private String scheduleInitiator;
    /**
     * 提出时间
     */
    @Column(name = "schedule_start_time")
    private String scheduleStartTime;
    /**
     * 完成状态
     */
    @Column(name = "complete_status")
    private Integer completeStatus;
    /**
     * 完成人
     */
    @Column(name = "consummator")
    private String consummator;
    /**
     * 完成时间
     */
    @Column(name = "complete_time")
    private String completeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleDescribe() {
        return scheduleDescribe;
    }

    public void setScheduleDescribe(String scheduleDescribe) {
        this.scheduleDescribe = scheduleDescribe;
    }

    public Integer getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(Integer scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getScheduleInitiator() {
        return scheduleInitiator;
    }

    public void setScheduleInitiator(String scheduleInitiator) {
        this.scheduleInitiator = scheduleInitiator;
    }

    public String getScheduleStartTime() {
        return scheduleStartTime;
    }

    public void setScheduleStartTime(String scheduleStartTime) {
        this.scheduleStartTime = scheduleStartTime;
    }

    public Integer getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Integer completeStatus) {
        this.completeStatus = completeStatus;
    }

    public String getConsummator() {
        return consummator;
    }

    public void setConsummator(String consummator) {
        this.consummator = consummator;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    @Override
    public String toString() {
        return "ProjectSchedule [id=" + id + ", scheduleName=" + scheduleName + ", scheduleDescribe=" + scheduleDescribe
                + ", scheduleType=" + scheduleType + ", scheduleInitiator=" + scheduleInitiator + ", scheduleStartTime="
                + scheduleStartTime + ", completeStatus=" + completeStatus + ", consummator=" + consummator
                + ", completeTime=" + completeTime + "]";
    }

    
}
