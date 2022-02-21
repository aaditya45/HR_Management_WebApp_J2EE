package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NotifyFormResubmission extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        try {
            MessageBean messageBean = new MessageBean();
            messageBean.setHeading("Notification");
            messageBean.setMessage("Form is not to be resubmitted");
            messageBean.setGenerateButton(true);
            messageBean.setGenerateTwoButton(false);
            messageBean.setButtonOneText("Ok");
            messageBean.setButtonOneAction("Designations.jsp");
            request.setAttribute("messageBean",messageBean);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
            requestDispatcher.forward(request,response);
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
