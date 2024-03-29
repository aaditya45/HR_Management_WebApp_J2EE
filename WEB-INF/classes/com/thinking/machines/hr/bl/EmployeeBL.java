package com.thinking.machines.hr.bl;
import java.text.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
public class EmployeeBL {
    public List<EmployeeBean> getAll() {
        List<EmployeeBean> employees = new LinkedList<>();
        try {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            List<EmployeeDTO> dlEmployees = employeeDAO.getAll();
            EmployeeBean employeeBean;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (EmployeeDTO dlEmployee : dlEmployees) {
                employeeBean = new EmployeeBean();
                employeeBean.setEmployeeId(dlEmployee.getEmployeeId());
                employeeBean.setName(dlEmployee.getName());
                employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
                employeeBean.setDesignation(dlEmployee.getDesignation());
                employeeBean.setDateOfBirth(sdf.format(dlEmployee.getDateOfBirth()));
                employeeBean.setGender(dlEmployee.getGender());
                employeeBean.setIsIndian(dlEmployee.getIsIndian());
                employeeBean.setBasicSalary(dlEmployee.getBasicSalary().toPlainString());
                employeeBean.setPanNumber(dlEmployee.getPanNumber());
                employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
                employees.add(employeeBean);
            }
        } catch (DAOException daoException) {
            System.out.println(daoException.getMessage());
        }
        return employees;
    }
}