package com.HuseinProject.LeaveTrackingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public EmployeeService employeeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<EmployeeData>> getAllUsers() {
        return new ResponseEntity<List<EmployeeData>>(employeeService.getUsers(),HttpStatus.OK);
    }

    @RequestMapping(value = "/single", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<EmployeeData>> fetchSingleUser(@RequestParam("id")Integer eid) {
        return new ResponseEntity(employeeService.findById(eid),HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestParam("uname")String uname, @RequestParam("fname")String fname,
                             @RequestParam("lname")String lname, @RequestParam("dob")String dob,
                             @RequestParam("email")String email) {
        employeeService.createUser(uname, fname,lname, dob, email);
        return "User created successfully!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestParam("eid")Integer empId, @RequestParam("uname")String uname, @RequestParam("fname")String fname,
                             @RequestParam("lname")String lname, @RequestParam("dob")String dob,
                             @RequestParam("email")String email) {
        employeeService.updateById(empId, uname, fname, lname, dob, email);
        return "Employee id: " + empId + " updated successfully!";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(@RequestParam("eid")Integer eid) {
        employeeService.deleteById(eid);
        return "User " + eid + " deleted successfully!";
    }
}