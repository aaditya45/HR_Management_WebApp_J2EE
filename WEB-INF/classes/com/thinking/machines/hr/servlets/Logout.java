package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("username");
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginForm.jsp");
                dispatcher.forward(request,response);    
            } catch (Exception e) {
                //handle exception
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
