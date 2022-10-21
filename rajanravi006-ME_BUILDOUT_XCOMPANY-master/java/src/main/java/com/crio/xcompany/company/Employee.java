package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Gender gender;

    // List of child
    private List<Employee> directReportees;


    // 
    private List<Employee> teamMates;

    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;  // list of teamates and list of direct reports
        this.directReportees = new ArrayList<>();
        this.teamMates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.

   //Employee E1 = new Employee();
   // E2
   // E1.assignManager(E2);
   // 
   // assignManager(E1, E2);

    public void assignManager(Employee employee)
    {
       employee.directReportees.add(this);
       this.teamMates.add(employee);
       this.teamMates.addAll(employee.directReportees);
       
    }

    public List<Employee> getDirectReportees() {
        return directReportees;
    }

    public List<Employee> getTeamMates(){
        return teamMates;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }  
     
}
