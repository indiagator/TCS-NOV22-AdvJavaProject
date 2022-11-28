package com.tcs.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NextServlet", value = "/next-servlet")
public class NextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        String username = null;
        if( (username = (String)session.getAttribute("username")) !=null  )
        {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.write("{\"username\":\""+username+"\"}");
            out.write("{\"message\":\"You Are now Looged In | Please checkout the Webapp\"}");

            out.flush();
        }
        else
        {
           RequestDispatcher view = request.getRequestDispatcher("index.jsp");
           view.forward(request, response);

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
