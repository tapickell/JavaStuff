/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrox.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.security.*;


/**
 *
 * @author toddpickell
 */
public class ProtectedServlet extends HttpServlet {
    
    /**
     *
     * @param cfg
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                          throws IOException, ServletException {
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String authType = request.getAuthType();
        out.println("You are authorized to view this page.");
        out.println("You were authenticated using: " + authType + " method of authentication.");
        Principal princ = request.getUserPrincipal();
        out.println("The user is: " + princ.getName());
    }
}
