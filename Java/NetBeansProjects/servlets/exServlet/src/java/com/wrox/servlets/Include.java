/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author toddpickell
 */
public class Include extends HttpServlet {
    
    String forwardingAddress = "Goto";
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response)
                                          throws ServletException, IOException {
        
        request.setAttribute("option", "include");
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardingAddress);
        dispatcher.include(request, response);
        
        PrintWriter out = response.getWriter();
        out.println("Response included successfully");
    }
}
