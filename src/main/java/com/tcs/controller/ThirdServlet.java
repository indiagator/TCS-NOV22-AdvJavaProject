package com.tcs.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ThirdServlet", value = "/third-servlet")
public class ThirdServlet extends HttpServlet {

    //servlets should not have any data members

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> headers = request.getHeaderNames();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write("{");

        //more code to fetch data from other parties like database

        int cntr=0;
        while(headers.hasMoreElements())
        {
            String element = headers.nextElement();
            out.write("\""+element+"\":"+"\""+request.getHeader(element)+"\",");
            cntr++;
        }

        out.write("\"eof\":\"eof\"}");
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
