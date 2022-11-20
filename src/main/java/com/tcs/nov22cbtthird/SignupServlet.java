package com.tcs.nov22cbtthird;

import com.tcs.model.Credential;
import org.apache.commons.codec.digest.DigestUtils;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "SignupServlet", value = "/signup-servlet")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();

        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(md5Hex);


        Jsonb jsonb = JsonbBuilder.create();
        String credentialJson = jsonb.toJson((Credential)credential);

        HttpSession session = request.getSession(true);
        session.setAttribute("username",username);

        //response.setContentType("application/json");
        //PrintWriter out = response.getWriter();
        //out.write(credentialJson);
        //out.flush();

        Set<Credential> cresdentialList = new HashSet<>();
        String line = null;
        BufferedReader credentialReader = Files.newBufferedReader(Paths.get("D:\\SOftware Dev and Training Material\\NewWinCode\\tcsnov22\\nov22cbtthird\\src\\main\\resources\\data\\credentials.txt"));
        while( (line = credentialReader.readLine())!=null )
        {
            Credential tempCredential = jsonb.fromJson(line,Credential.class);
            cresdentialList.add(tempCredential);
        }
        cresdentialList.add(credential);

        BufferedWriter credentialWriter = Files.newBufferedWriter(Paths.get("D:\\SOftware Dev and Training Material\\NewWinCode\\tcsnov22\\nov22cbtthird\\src\\main\\resources\\data\\credentials.txt"));

        cresdentialList.forEach(credential1 -> {
            try {
                credentialWriter.write(jsonb.toJson(credential1)+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        credentialWriter.flush();

        RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request, response);




    }
}
