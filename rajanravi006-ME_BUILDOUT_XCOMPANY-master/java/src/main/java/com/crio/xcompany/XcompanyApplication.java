package com.crio.xcompany;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.crio.xcompany.company.Company;
import com.crio.xcompany.company.Employee;
import com.crio.xcompany.company.Gender;

public class XcompanyApplication {

	public static void main(String[] args) {
        if (args.length != 2){
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        String inputFile = commandLineArgs.get(0).split("=")[1];
        String outputFile = commandLineArgs.get(1).split("=")[1];
        run(inputFile,outputFile);
    }

    public static void run(String inputFile, String outputFile){

        // Initialize Company
        Company company = Company.create("Crio.Do",new Employee("Rathina",Gender.MALE));

        

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                List<String> tokens = Arrays.asList(line.split(" "));

                // Execute Services
                switch(tokens.get(0)){
					case "REGISTER_EMPLOYEE":
					{
                        writer.write("REGISTER_EMPLOYEE :>\n");
                        String employeeName = tokens.get(1);
                        String gender = tokens.get(2);
                        company.registerEmployee(employeeName, Gender.valueOf(gender));
                        writer.write("EMPLOYEE_REGISTRATION_SUCCEEDED\n");
                        writer.write("\n");
                        writer.flush();
					}
					break;

                    case "ASSIGN_MANAGER":
					{
                        writer.write("ASSIGN_MANAGER :>\n");
                        String employeeName = tokens.get(1);
                        String managerName = tokens.get(2);
                        company.assignManager(employeeName, managerName);
                        writer.write("MANAGER_ASSIGNMENT_SUCCEEDED\n");
                        writer.write("\n");
                        writer.flush();
					}
                    break;

                    case "GET_EMPLOYEE":
					{
                        writer.write("GET_EMPLOYEE :>\n");
                        String employeeName = tokens.get(1);
                        Employee e = company.getEmployee(employeeName);
                        if(e == null){
                            writer.write("EMPLOYEE_NOT_FOUND\n");
                        }else{
                            writer.write(e.toString());
                            writer.write("\n");
                        }
                        writer.write("\n");
                        writer.flush();
					}
                    break;
                    case "GET_DIRECT_REPORTS":
					{
                        writer.write("GET_DIRECT_REPORTS :>\n");
                        String managerName = tokens.get(1);
                        List<Employee> eList = company.getDirectReports(managerName);
                        writer.write(eList.toString());
                        writer.write("\n");
                        writer.write("\n");
                        writer.flush();
					}
                    break;
                    case "GET_TEAMMATES":
					{
                        writer.write("GET_TEAMMATES :>\n");
                        String employeeName = tokens.get(1);
                        List<Employee> eList = company.getTeamMates(employeeName);
                        writer.write(eList.toString());
                        writer.write("\n");
                        writer.write("\n");
                        writer.flush();
					}
                    break;
                    case "DELETE_EMPLOYEE":
					{
                        writer.write("DELETE_EMPLOYEE :>\n");
                        String employeeName = tokens.get(1);
                        company.deleteEmployee(employeeName);
                        writer.write("EMPLOYEE_DELETION_SUCCEEDED\n");
                        writer.write("\n");
                        writer.flush();
					}
                    break;
                    case "EMPLOYEE_HIERARCHY":
					{
                        writer.write("EMPLOYEE_HIERARCHY :>\n");
                        String managerName = tokens.get(1);
                        List<List<Employee>> eLists = company.getEmployeeHierarchy(managerName);
                        for(List<Employee> eList : eLists){
                            for(Employee e: eList){
                                writer.write(e.toString());
                                writer.write("\t");
                            }
                            writer.write("\n");
                        }
                        writer.write("\n");
                        writer.flush();
					}
                    break;

                    default:
                        throw new RuntimeException("Invalid Command");
                }
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
