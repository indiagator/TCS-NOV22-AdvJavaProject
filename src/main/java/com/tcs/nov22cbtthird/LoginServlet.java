package com.tcs.nov22cbtthird;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("ranganath"))
        {
            if(password.equals("tcs@123"))
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("username",username);
            }
            else
            {
                // Incorrect Password
            }
        }
        else {
            //Incorrect Username
        }


    }
}
