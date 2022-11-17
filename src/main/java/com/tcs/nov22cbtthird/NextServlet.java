package com.tcs.nov22cbtthird;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NextServlet", value = "/next-servlet")
public class NextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        HttpSession session = request.getSession(false);
        String username = (String)session.getAttribute("username");

        PrintWriter out = response.getWriter();
        out.write("{\"username\":\""+username+"\"}");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
