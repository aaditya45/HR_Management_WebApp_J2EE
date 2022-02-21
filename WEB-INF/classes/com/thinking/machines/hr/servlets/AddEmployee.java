package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class AddEmployee extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            EmployeeBean employeeBean;
            employeeBean = (EmployeeBean) request.getAttribute("employeeBean");
            String name;
            int designationCode;
            String designation;
            String dateOfBirth;
            String gender;
            boolean isIndian;
            String basicSalary;
            String panNumber;
            String aadharCardNumber;
            name = employeeBean.getName();
            designationCode = employeeBean.getDesignationCode();
            DesignationDAO designationDAO;
            designationDAO = new DesignationDAO();
            DesignationDTO designationDTO = designationDAO.getByCode(designationCode);
            employeeBean.setDesignation(designationDTO.getTitle());
            designation = employeeBean.getDesignation();
            System.out.println("Designation of : " + name + " is " + designation);
            dateOfBirth = employeeBean.getDateOfBirth();
            gender = employeeBean.getGender();
            isIndian = employeeBean.getIsIndian();
            System.out.println("Is indian : " + isIndian);
            basicSalary = employeeBean.getBasicSalary();
            panNumber = employeeBean.getPanNumber();
            aadharCardNumber = employeeBean.getAadharCardNumber();
            EmployeeDTO employee = new EmployeeDTO();
            employee.setName(name);
            employee.setDesignationCode(designationCode);
            employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth));
            employee.setDesignation(designation);
            employee.setGender(gender);
            employee.setIsIndian(isIndian);
            employee.setBasicSalary(new BigDecimal(basicSalary));
            employee.setPanNumber(panNumber);
            employee.setAadharCardNumber(aadharCardNumber);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            try {
                employeeDAO.add(employee);
                employeeBean.setEmployeeId(employee.getEmployeeId());
                MessageBean messageBean;
                messageBean = new MessageBean();
                messageBean.setHeading("Employee Added,add more ?");
                messageBean.setGenerateButton(true);
                messageBean.setGenerateTwoButton(true);
                messageBean.setButtonOneText("Yes");
                messageBean.setButtonTwoText("No");
                messageBean.setButtonOneAction("EmployeeAddForm.jsp");
                messageBean.setButtonTwoAction("Employees.jsp");
                request.setAttribute("messageBean", messageBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
                requestDispatcher.forward(request, response);
            } catch (DAOException daoException) {
                System.out.println(daoException.getMessage());
                ErrorBean errorBean;
                errorBean = new ErrorBean();
                errorBean.setError(daoException.getMessage());
                request.setAttribute("errorBean", errorBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/EmployeeAddForm.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            pw.println("" + exception.getMessage() + "");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
