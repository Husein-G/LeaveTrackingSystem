package com.HuseinProject.LeaveTrackingSystem;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeeService {
   public List<EmployeeData> users = new ArrayList<>();

    public void createUser(String uname, String fname, String lname, String dob, String email) {
        EmployeeData employeeData1 = new EmployeeData();
        employeeData1.setEmpId();
        employeeData1.setUserName(uname);
        employeeData1.setFirstName(fname);
        employeeData1.setLastName(lname);
        employeeData1.setDob(dob);
        employeeData1.setEmail(email);
        users.add(employeeData1);
    }

    public List<EmployeeData> getUsers() {
        return users;
    }

    public EmployeeData findById(Integer id) {
        EmployeeData employeeData = new EmployeeData();
        for (EmployeeData employeeData1 : users) {
            if (employeeData1.getEmpId() == id) {
                employeeData = employeeData1;
            }
            else {
                employeeData = null;
            }
        }
        return employeeData;
    }

    public void updateById(Integer empId, String uname, String fname,
                           String lname, String dob, String email) {

    }

    public void deleteById(Integer id) {
        EmployeeData employee = findById(id);
        users.remove(employee);
    }

    public boolean ifExists(Integer id) {
        return findById(id) != null;
    }
}
