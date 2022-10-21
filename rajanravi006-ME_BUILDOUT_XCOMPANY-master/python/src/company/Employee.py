from typing import List
from src.company import Gender


class Employee:
    def __init__(self,name: str , gender: Gender) -> None:
        self._name = name
        self._gender = gender

    def get_name(self) -> str:
        return self._name

    def get_gender(self) -> str:
        return self._gender

    # TODO: CRIO_TASK_MODULE_XCOMPANY
    # Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    # This will ensure that the project can be compiled successfully.


    def __repr__(self) -> str:
        return f'Employee [name={self._name}, gender={self._gender.value}]'





    

