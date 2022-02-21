package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.bl.*;
import com.thinking.machines.hr.beans.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeesJS extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/javascript");
            // The following is very bad idea , hence commented
            // File file=new
            // File("c:\\tomcate9\\webapps\\styletwo\\WEB-INF\\js\\Employees.js");
            ServletContext servletContext = getServletContext();
            File file = new File(servletContext.getRealPath("") + File.separator + "WEB-INF" + File.separator + "js"+ File.separator + "EmployeesJS.js");
            //servletContex.getRealPath("") will return the /web path of our project
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
                pw.println(randomAccessFile.readLine());
                //reading the javascript file in response
            }
            randomAccessFile.close();
            List<EmployeeBean> employees = new EmployeeBL().getAll();
            pw.println("var employee;\n");
            int i = 0;
            // Populating Employees in employees array
            for (EmployeeBean employeeBean : employees) {
                pw.println("employee=new Employee();");
                pw.println("employee.employeeId=\"" + employeeBean.getEmployeeId() + "\";");
                pw.println("employee.name=\"" + employeeBean.getName() + "\";");
                pw.println("employee.designationCode=\"" + employeeBean.getDesignationCode() + "\";");
                pw.println("employee.designation=\"" + employeeBean.getDesignation() + "\";");
                pw.println("employee.dateOfBirth=\"" + employeeBean.getDateOfBirth() + "\";");
                pw.println("employee.gender=\"" + employeeBean.getGender() + "\";");
                pw.println("employee.isIndian=\"" + employeeBean.getIsIndian() + "\";");
                System.out.println(employeeBean.getName() + " is " + employeeBean.getIsIndian());
                pw.println("employee.basicSalary=\"" + employeeBean.getBasicSalary() + "\";");
                pw.println("employee.panNumber=\"" + employeeBean.getPanNumber() + "\";");
                pw.println("employee.aadharCardNumber=\"" + employeeBean.getAadharCardNumber() + "\";");
                pw.println("employees[" + i + "]=employee;");
                i++;
            }
        } catch (Exception exception) {
            RequestDispatcher requestDispatcher;
            requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
            try {
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}