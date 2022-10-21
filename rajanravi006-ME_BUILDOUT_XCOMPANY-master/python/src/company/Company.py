from typing import List
from src.company import Employee, Gender


class Company:
    def __init__(self,company_name: str, founder: Employee) -> None:
        self._company_name = company_name
        self._founder = founder
        self._employee_book = {}
        self._employee_book[founder.get_name()] = founder

    def get_company_name(self) -> str:
        self._company_name

    # TODO: CRIO_TASK_MODULE_XCOMPANY
    # Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    # This will ensure that the project can be compiled successfully.




    




    

    