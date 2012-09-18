/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox.servlets;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author toddpickell
 */
@SuppressWarnings("serial")
public class ExampleServlet extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                                         throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>");
        out.println("Servlet Example");
        out.println("</title></head><body>");
        out.println("<h1>This is an example servlet.</h1>");
        out.println("Query string being processed: <br>");
        out.println(request.getQueryString());
        out.println("<p>");
        out.println("Request parameters:<p>");
        
        Enumeration enumParam = request.getParameterNames();
        while (enumParam.hasMoreElements()) {
            
            String paramName = (String) enumParam.nextElement();
            String paramValues[] = request.getParameterValues(paramName);
            
            if (paramValues != null) {
                
                for (int i = 0; i < paramValues.length; i++) {
                    
                    out.println(paramName);
                    out.println(" (" + i + "): ");
                    out.println(paramValues[i]);
                    out.println("<br>");
                }
            }
            
        }
        out.println("<br>");
        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();
        out.println("Values retrieved for the init prarmeters are: ");
        out.println("URL: " + getInitParameter("URL"));
        out.println("UID: " + config.getInitParameter("UID"));
        out.println("PWD: " + config.getInitParameter("PWD"));
        out.println("some-port: " + context.getInitParameter("some-port"));
        out.println("</body></html>");
        out.close();
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                                          throws ServletException, IOException {
        
        doGet(request, response);
    }
}
