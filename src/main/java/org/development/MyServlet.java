package org.development;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    ServletConfig myConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init Method");
        myConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.println("<HTML>");
        out.println("<head>");
        out.println("<title>The Post Method</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello First Servlet</h1>");
        out.println("<br>Welcome to Servlets and JSP Course");
        System.out.println("I am inside the service method");
        String str = myConfig.getInitParameter("AdminEmail");
        out.println("the administrator email is: "+str);
        String country = myConfig.getInitParameter("country");
        String age = myConfig.getInitParameter("age");
        out.println("<h1>I am from "+country+" and I am "+age+" years old</h1>");
        out.println("<body>");
        out.println("</HTML>");
    }

    @Override
    public String getServletInfo() {
        return "My first Servlet";
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Method");
    }
}
