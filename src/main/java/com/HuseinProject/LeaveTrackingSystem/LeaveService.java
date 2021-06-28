package com.HuseinProject.LeaveTrackingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveService {
    private List<LeaveData> leaveDataList = new ArrayList<>();
    EmployeeData employeeData = new EmployeeData();
    @Autowired
    EmployeeService employeeService = new EmployeeService();

    public void createLeave(int eid, String leaveStart, String leaveEnd, Integer days, String reason) {
        LeaveData leaveData = new LeaveData();
        leaveData.setEmpId(eid);
        leaveData.setLeaveNumber();
        leaveData.setLeaveStart(leaveStart);
        leaveData.setLeaveEnd(leaveEnd);
        leaveData.setDays(days);
        leaveData.setReason(reason);
        leaveDataList.add(leaveData);
    }

    public List<LeaveData> getLeaves() {
        return leaveDataList;
    }

    public List<LeaveData> findById(Integer empId) {
        List<LeaveData> leaveDataArrayList = new ArrayList<>();
        for (LeaveData leaveData : leaveDataList) {
            if (leaveData.getEmpId() == empId) {
                leaveDataArrayList.add(leaveData);
            }
        }
        return leaveDataArrayList;
    }

    public LeaveData findByLeaveNumber(Integer leaveNum) {
        LeaveData leaveData1 = new LeaveData();
        for (LeaveData leaveData : leaveDataList) {
            if (leaveData.getLeaveNumber().equals(leaveNum))
                leaveData1 = leaveData;
        }
        return leaveData1;
    }

    public void grantLeave(Integer leaveNum) {
        LeaveData leaveData = new LeaveData();
        leaveData = findByLeaveNumber(leaveNum);
        leaveData.setStatus("Approved");
        Integer empId = leaveData.getEmpId();
        employeeData = employeeService.findById(empId);
        Integer leaveBal = employeeData.getLeaveBalance();
        Integer leaveReq = leaveData.getDays();
        Integer leave = leaveBal - leaveReq;
        employeeData.setLeaveBalance(leave);
    }

    public void rejectLeave(Integer leaveNum) {
        LeaveData leaveData = findByLeaveNumber(leaveNum);
        leaveData.setStatus("Rejected");
    }

    public void deleteLeave(Integer leaveNum) {
        LeaveData leaveData = findByLeaveNumber(leaveNum);
        leaveDataList.remove(leaveData);
    }
}