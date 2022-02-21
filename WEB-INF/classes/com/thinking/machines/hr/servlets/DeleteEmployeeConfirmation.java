package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteEmployeeConfirmation extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            EmployeeBean employeeBean;
            String employeeId;
            employeeId = request.getParameter("employeeId");
            
            EmployeeDAO employeeDAO = new EmployeeDAO();
            try {
                employeeDAO.deleteByEmployeeId(employeeId);
                MessageBean messageBean;
                messageBean = new MessageBean();
                messageBean.setHeading("Notification");
                messageBean.setMessage("Employee Deleted");
                messageBean.setGenerateButton(true);
                messageBean.setButtonOneText("Ok");
                messageBean.setButtonOneAction("Employees.jsp");
                request.setAttribute("messageBean", messageBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
                requestDispatcher.forward(request, response);
            } catch (DAOException daoException) {
                System.out.println(daoException.getMessage());
                MessageBean messageBean;
                messageBean = new MessageBean();
                messageBean.setHeading("Notification");
                messageBean.setMessage(daoException.getMessage());
                messageBean.setGenerateButton(true);
                messageBean.setButtonOneText("Ok");
                messageBean.setButtonOneAction("Employees.jsp");
                request.setAttribute("messageBean", messageBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
