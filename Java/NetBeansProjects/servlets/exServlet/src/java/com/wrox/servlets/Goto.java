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
public class Goto extends HttpServlet {
    
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
        
        String option = (String) request.getAttribute("option");
        PrintWriter out = response.getWriter();
        
        if (option != null) {
            
            if (option.equals("forward")) {
                out.println("You have been forwarded to this page");
            } else if (option.equals("include")) {
                out.println("This line will be includes in the response");
            }//end elseif
        }//end if
    }//end doGet
    
}//end class Goto
