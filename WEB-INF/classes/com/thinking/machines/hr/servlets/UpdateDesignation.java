package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateDesignation extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            DesignationBean designationBean;
            designationBean = (DesignationBean) request.getAttribute("designationBean");
            int code;
            String title;
            code = designationBean.getCode();
            title = designationBean.getTitle();
            System.out.println(code);
            System.out.println(title);
            DesignationDTO designation = new DesignationDTO();
            designation.setCode(code);
            designation.setTitle(title);
            DesignationDAO designationDAO = new DesignationDAO();
            try {
                designationDAO.update(designation);
                MessageBean messageBean;
                messageBean = new MessageBean();
                messageBean.setHeading("Notification");
                messageBean.setMessage("Designation updated");
                messageBean.setGenerateButton(true);
                messageBean.setButtonOneText("Ok");
                messageBean.setButtonOneAction("Designations.jsp");
                request.setAttribute("messageBean", messageBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
                requestDispatcher.forward(request, response);
            } catch (DAOException daoException) {
                System.out.println(daoException.getMessage());
                ErrorBean errorBean;
                errorBean = new ErrorBean();
                System.out.println(daoException.getMessage());
                errorBean.setError(daoException.getMessage());
                request.setAttribute("errorBean", errorBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/DesignationEditForm.jsp");
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
