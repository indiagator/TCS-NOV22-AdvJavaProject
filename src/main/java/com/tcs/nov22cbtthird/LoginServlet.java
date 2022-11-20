package com.tcs.nov22cbtthird;

import com.tcs.model.Credential;
import org.apache.commons.codec.digest.DigestUtils;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        password=null;


        Jsonb jsonb = JsonbBuilder.create();

        BufferedReader credentialreader = Files.newBufferedReader(Paths.get("D:\\SOftware Dev and Training Material\\NewWinCode\\tcsnov22\\nov22cbtthird\\src\\main\\resources\\data\\credentials.txt"));
        List<Credential> credentialList = new ArrayList<>();
        String line= null;
        while( (line = credentialreader.readLine()) !=null)
        {
            credentialList.add(jsonb.fromJson(line,Credential.class));

        }
        Set<Credential> creSet = new HashSet<>();
        credentialList.forEach(credential -> creSet.add(credential));


        Optional<Credential> user ;
        //Authentication
        if(  (user = creSet.stream().filter(credential -> credential.getUsername().equals(username)).findFirst()).isPresent() )
        {
            if(user.get().getPassword().equals(md5Hex))
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


        RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request,response);

    }
}
