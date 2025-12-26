package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/hello-servlet")
public class SimpleHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setStatus(200);
        res.setContentType("text/plain");
        res.getWriter().write("Hello from Simple Servlet");
    }

    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet";
    }
}
