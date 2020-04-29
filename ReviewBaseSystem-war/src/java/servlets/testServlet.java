/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.adminejbLocal;
import ejb.clientejbLocal;
import entity.Role;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hi
 */
public class testServlet extends HttpServlet {

    @EJB
    //clientejbLocal client;
    adminejbLocal admin;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");
            out.println("</head>");
            out.println("<body>");

//            admin.removeRole(11);
            
//            Collection<Role> rlist = admin.getAllRoles();
//            for (Role role : rlist) {
//                System.out.println("in loop");
//                out.println("role id= " + role.getRoleId() + " rolename= " + role.getRoleName() + "<br>");
//            }
//            try {
//                String bdate = "01-06-1997";
//                Date d1 = new SimpleDateFormat("MM-dd-yyyy").parse(bdate);
//                client.addUser("Leo", "leo@gmail.com", "77777777777", "movies", "male", d1, "surat", "leo@123");
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            try {
//                String bdate = "04-08-1980";
//                Date d1 = new SimpleDateFormat("MM-dd-yyyy").parse(bdate);
//                client.addUser("john wick", "john@gmail.com", "8888888888", "movies", "male", d1, "New York", "john@123");
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            Collection<Users> ulist = client.getAllUsers();
//            for (Users u : ulist) {
//                out.println("name =" + u.getName() + " birthdate=" + u.getBirthdate() + " password=" + u.getPassword()+"<br>");
//            }

            out.println("<h1>Servlet testServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
