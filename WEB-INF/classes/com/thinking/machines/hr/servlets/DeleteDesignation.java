package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteDesignation extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            DesignationBean designationBean;
            designationBean = (DesignationBean) request.getAttribute("designationBean");
            int code;
            code = designationBean.getCode();
            DesignationDAO designationDAO = new DesignationDAO();
            try {
                designationDAO.deleteByCode(code);
                MessageBean messageBean;
                messageBean = new MessageBean();
                messageBean.setHeading("Notification");
                messageBean.setMessage("Designation Deleted");
                messageBean.setGenerateButton(true);
                messageBean.setButtonOneText("Ok");
                messageBean.setButtonOneAction("Designations.jsp");
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
                messageBean.setButtonOneAction("Designations.jsp");
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
