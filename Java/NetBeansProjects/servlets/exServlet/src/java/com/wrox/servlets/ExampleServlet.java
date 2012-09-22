/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox.servlets;

import java.io.*;
import java.util.Date;
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
        
        HttpSession session = request.getSession(true);
        
        Integer totalCount = (Integer) getServletContext().getAttribute("com.wrox.servlets.total");
        
        if (totalCount == null) {
            totalCount = new Integer(1);
        } else {
            totalCount = new Integer(totalCount.intValue() + 1);
        }
        
        Integer count = (Integer) session.getAttribute("count");
        
        if (count == null) {
            count = new Integer(1);
        } else {
            count = new Integer(count.intValue() + 1);
        }
        
        session.setAttribute("count", count);
        getServletContext().setAttribute("com.wrox.servlets.total", totalCount);
        
        out.println("<html><head><title>");
        out.println("Servlet Example");
        out.println("</title></head><body>");
        out.println("<h1>Session Details</h1>");
        out.println("You have visited this page " + count + ((count.intValue() == 1) ? " time." : " times.") + "<br/>");
        out.println("Total number of visits: " + totalCount + "<br/>");
        out.println("<h3>Details of this session:</h3>");
        out.println("Session id: " + session.getId() + "<br/>");
        out.println("New Session: " + session.isNew() + "<br/>");
        out.println("Timeout: " + session.getMaxInactiveInterval() + "<br/>");
        out.println("Creation time: " + new Date(session.getCreationTime()) + "<br/>");
        out.println("Last access time: "+ new Date(session.getLastAccessedTime()) + "<br/>");
        out.println("<br/>");
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
