package com.HuseinProject.LeaveTrackingSystem;

import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeData {
    private static final AtomicInteger counter = new AtomicInteger();
    private Integer empId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private Integer leaveBalance = 30;

    public void setEmpId() {
        empId = counter.incrementAndGet();
    }

    public int getEmpId() {
        return this.empId;
    }

    public void setUserName(String name) {
        this.userName = name;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email1) {
        this.email = email1;
    }
    public String getEmail() {
        return this.email;
    }

    public void setDob(String DOB) {
        this.dob = DOB;
    }
    public String getDob() {
        return this.dob;
    }

    public void setLeaveBalance(Integer leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
    public Integer getLeaveBalance() {
        return this.leaveBalance;
    }
}