package com.HuseinProject.LeaveTrackingSystem;

import java.util.concurrent.atomic.AtomicInteger;

public class LeaveData {
    private static final AtomicInteger counter = new AtomicInteger();
    private Integer empId;
    private Integer leaveNumber;
    private String leaveStart;
    private String leaveEnd;
    private Integer days;
    private String reason;
    private String status = "Approval_Pending";

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setLeaveNumber() {
        leaveNumber = counter.incrementAndGet();
    }

    public Integer getLeaveNumber() {
        return leaveNumber;
    }

    public void setLeaveStart(String leaveStart) {
        this.leaveStart = leaveStart;
    }

    public String getLeaveStart() {
        return leaveStart;
    }

    public void setLeaveEnd(String leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public String getLeaveEnd() {
        return leaveEnd;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getDays() {
        return days;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}