package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DesignationDeleteConfirmation extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int code = Integer.parseInt(request.getParameter("code"));
            DesignationDTO designationDTO;
            DesignationDAO designationDAO = new DesignationDAO();
            try {
                designationDTO = designationDAO.getByCode(code);
                DesignationBean designationBean = new DesignationBean();
                designationBean.setCode(code);
                designationBean.setTitle(designationDTO.getTitle());
                request.setAttribute("designationBean", designationBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/DesignationDeleteConfirmation.jsp");
                requestDispatcher.forward(request, response);
            } catch (DAOException daoException) {
                ErrorBean errorBean;
                errorBean = new ErrorBean();
                System.out.println(daoException.getMessage());
                errorBean.setError(daoException.getMessage());
                request.setAttribute("errorBean", errorBean);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("/Designations.jsp");
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