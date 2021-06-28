package com.HuseinProject.LeaveTrackingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    EmployeeService employeeService = new EmployeeService();
    LeaveService leaveService = new LeaveService();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<LeaveData> getAllLeaves() {
        return leaveService.getLeaves();
    }

    @RequestMapping(value = "/single", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<LeaveData>> getSingleUserLeaves(@RequestParam("eid")Integer empId) {
        return new ResponseEntity(leaveService.findById(empId), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String newLeave(@RequestParam("eid")Integer eid, @RequestParam("leaveStart")String leaveStart,
                           @RequestParam("leaveEnd")String leaveEnd, @RequestParam("days")Integer days,
                           @RequestParam("reason")String reason) {
        if (employeeService.ifExists(eid)){}
        else {return "User not found!";}
        leaveService.createLeave(eid,leaveStart,leaveEnd,days,reason);
        return "Leave Request created successfully";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    @ResponseBody
    public String actionOnLeave (@RequestParam("leavenum")Integer leaveNum,
                               @RequestParam("command")String cmd) {
        if (cmd.equalsIgnoreCase("approve")) {
            leaveService.grantLeave(leaveNum);
            return "Leave Request approved successfully!";
        }
        else if (cmd.equalsIgnoreCase("reject")) {
            leaveService.rejectLeave(leaveNum);
            return "Leave Request rejected successfully!";
        }
        else {
            return "Incorrect command provided.";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteLeaveRequest(@RequestParam("leaveid")Integer leaveNum) {
        leaveService.deleteLeave(leaveNum);
        return "Leave Id: " + leaveNum + " deleted successfully!";
    }
}