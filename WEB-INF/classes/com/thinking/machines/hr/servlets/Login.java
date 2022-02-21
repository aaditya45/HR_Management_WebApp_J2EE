package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            AdministratorBean administratorBean;
            administratorBean= (AdministratorBean) request.getAttribute("administratorBean");
            if(administratorBean == null){
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError("Invalid Password/Username");
                request.setAttribute("errorBean",errorBean);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
                requestDispatcher.forward(request,response);
                return;
            }
            String username;
            String password;
            username = administratorBean.getUsername();
            password = administratorBean.getPassword();
            AdministratorDTO administrator;
            AdministratorDAO administratorDAO = new AdministratorDAO();
            try {
                administrator = administratorDAO.getByUsername(username);
                if(password.equals(administrator.getPassword()) == false){
                    ErrorBean errorBean = new ErrorBean();
                    errorBean.setError("Invalid Password/Username");
                    request.setAttribute("errorBean",errorBean);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
                    requestDispatcher.forward(request,response);
                    return;
                }
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request,response);
            } catch (DAOException e) {
                ErrorBean errorBean = new ErrorBean();
                errorBean.setError(e.getMessage());
                request.setAttribute("errorBean",errorBean);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginPage.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (Exception r) {
                
            }
        }
    }
}
