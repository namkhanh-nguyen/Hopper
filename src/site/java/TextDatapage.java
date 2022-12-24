package net.codejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TextDatapage")

public String textinput;
public String KeyOffset;
public String Key;

public class TextDatapage implements HttpServlet,GenerateKey {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        textinput = request.getParameter("textInput");
        KeyOffset = request.getParameter("test");
        Key = KeyCreate(KeyOffset);

        PrintWriter writer = response.getWriter();

        String htmlResponse = "<html>";
        htmlResponse += "<h2> Your HopperKey is:" + Key + "<br/>";
        htmlResponse += textinput + "</h2>";
        htmlResponse += "</html>";

        writer.println(htmlResponse);
    }



    public void setRetrieval(string s){

    }
}

