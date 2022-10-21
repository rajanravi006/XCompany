from sys import argv
import traceback

from src.company import Company, Gender
from src.company.Employee import Employee


def main():
    if len(argv) != 3:
        raise Exception()
    inputFile = argv[1].split("=")[1]
    outputFile = argv[2].split("=")[1]
    run(inputFile,outputFile)

def run(inputFile: str, outputFile: str) -> None:

    # Initialize Company
    company = Company("Crio.Do",Employee("Rathina",Gender.MALE))

    try:
        f = open(inputFile, 'r')
        w = open(outputFile,'w')
        while True:
            line = f.readline()
            if not line:
                break
            tokens = line.strip().split(" ")

            # Execute Services
            if tokens[0] == "REGISTER_EMPLOYEE":
                w.write("REGISTER_EMPLOYEE :>\n")
                employee_name = tokens[1]
                gender = Gender(tokens[2])
                company.register_employee(employee_name,gender)
                w.write("EMPLOYEE_REGISTRATION_SUCCEEDED\n")
                w.write("\n")
                w.flush()

            elif tokens[0] == "ASSIGN_MANAGER":
                w.write("ASSIGN_MANAGER :>\n")
                employee_name = tokens[1]
                manager_name = tokens[2]
                company.assign_manager(employee_name,manager_name)
                w.write("MANAGER_ASSIGNMENT_SUCCEEDED\n")
                w.write("\n")
                w.flush()

            elif tokens[0] == "GET_EMPLOYEE":
                w.write("GET_EMPLOYEE :>\n")
                employee_name = tokens[1]
                e = company.get_employee(employee_name)
                if e is None:
                    w.write("EMPLOYEE_NOT_FOUND\n")
                else:
                    w.write(e.__repr__())
                    w.write("\n")
                w.write("\n")
                w.flush()
                
            elif tokens[0] == "GET_DIRECT_REPORTS":
                w.write("GET_DIRECT_REPORTS :>\n")
                manager_name = tokens[1]
                eList = company.get_direct_reports(manager_name)
                w.write(eList.__repr__())
                w.write("\n")
                w.write("\n")
                w.flush()

            elif tokens[0] == "GET_TEAMMATES":
                w.write("GET_TEAMMATES :>\n")
                employee_name = tokens[1]
                eList = company.get_team_mates(employee_name)
                w.write(eList.__repr__())
                w.write("\n")
                w.write("\n")
                w.flush()           

            elif tokens[0] == "DELETE_EMPLOYEE":
                w.write("DELETE_EMPLOYEE :>\n")
                employee_name = tokens[1]
                company.delete_employee(employee_name)
                w.write("EMPLOYEE_DELETION_SUCCEEDED\n")
                w.write("\n")
                w.flush()

            elif tokens[0] == "EMPLOYEE_HIERARCHY":
                w.write("EMPLOYEE_HIERARCHY :>\n")
                manager_name = tokens[1]
                eLists = company.get_employee_hierarchy(manager_name)
                for eList in eLists:
                    for e in eList:
                        w.write(e.__repr__())
                        w.write("\t")
                    w.write("\n")
                w.write("\n")
                w.flush()
            else:
                raise Exception("Invalid Command")
        f.close()
        w.close()
    except Exception as e:
        print(e.__class__, '-', e)
        traceback.print_exc()

    
if __name__ == "__main__":
    main()