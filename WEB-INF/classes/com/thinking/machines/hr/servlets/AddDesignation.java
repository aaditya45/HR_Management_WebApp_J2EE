package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddDesignation extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            RequestDispatcher requestDispatcher;
            /*HttpSession session = (HttpSession)request.getSession();
            if(session.getAttribute("username").equals){
                requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
                requestDispatcher.forward(request,response);
                return;
            }*/
            DesignationBean designationBean;
            designationBean= (DesignationBean) request.getAttribute("designationBean");
            String title;
            title = designationBean.getTitle();
            DesignationDTO designation = new DesignationDTO();
            designation.setTitle(title);
            DesignationDAO designationDAO = new DesignationDAO();
            try {
                designationDAO.add(designation);
                designationBean.setCode(designation.getCode());
                MessageBean messageBean = new MessageBean();
                messageBean.setHeading("Designation (Add Module)");
                messageBean.setMessage("Designation Added , add more?");
                messageBean.setGenerateButton(true);
                messageBean.setGenerateTwoButton(true);
                messageBean.setButtonOneText("Yes");
                messageBean.setButtonOneAction("DesignationAddForm.jsp");
                messageBean.setButtonTwoText("No");
                messageBean.setButtonTwoAction("Designations.jsp");
                request.setAttribute("messageBean",messageBean);
                requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
                requestDispatcher.forward(request,response);
            } catch (DAOException e) {
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError(e.getMessage());
                request.setAttribute("errorBean",errorBean);
                requestDispatcher = request.getRequestDispatcher("/DesignationAddForm.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (Exception r) {
                
            }
        }
    }
}