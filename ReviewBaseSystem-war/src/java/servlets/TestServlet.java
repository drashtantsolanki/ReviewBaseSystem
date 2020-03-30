/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.adminejbLocal;
import ejb.clientejbLocal;
import ejb.commanejbLocal;
import entity.Advertise;
import entity.Category;
import entity.Categoryratingcriteria;
import entity.Product;
import entity.Ratingcriterias;
import entity.Role;
import entity.Rolepermission;
import entity.Userrole;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import javafx.geometry.Side;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author hi
 */
public class TestServlet extends HttpServlet {

    @EJB
    adminejbLocal admin;

    @EJB
    private commanejbLocal commanejb;

    @EJB
    private clientejbLocal clientejb;

    @EJB
    adminejbLocal al;

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");

            //==============================================================================
            //==============================================================================
            //----------Role--------------------Role------------Role--------------------------------
            //==============================================================================
            //==============================================================================
//            Role role=new Role("User");
//            Role role1=new Role("Rakesh");
//            
//            al.addRole(role);
//            al.addRole(role1);
//
//            Role role=new Role();
//            role.setRoleName("Roshan");
//            al.updateRole(6, role);
//            
//            Role obj=al.getRoleById(6);
//            out.println("Method getRoleById<h3> Role ID "+ obj.getRoleId() +" Role name "+obj.getRoleName()+"</h3>");
//
//            Role objRoleByName=al.getRoleByName("Rakesh");
//            out.println("Method getRoleByName<h3> Role ID "+ objRoleByName.getRoleId() +" Role name "+objRoleByName.getRoleName()+"</h3>");
////            al.removeRole(3);
////            al.removeRole(4);
////            al.removeRole(5);
//
//            Collection<Role> lstrole=al.getAllRoles();
//            for (Role r : lstrole) {
//                out.println("Role ID "+r.getRoleId() + " RoleName "+r.getRoleName()+"<br>");
//            }
            //==============================================================================
            //==============================================================================
            //----------Permission--------------------permission------------Permission--------------------------------
            //==============================================================================
            //==============================================================================
//            Permission permission=new Permission("See Review");
//            al.addPermission(permission);
//            Permission permissionForUpdate=new Permission();
//            permissionForUpdate.setPermissionName("remove Review");
//            al.updatePermission(2, permissionForUpdate);
//            al.removePermission(1);
//            Permission permissionGetById=al.getPermissionById(2);
//            out.println("Method getPermissionById <h3> Permission ID "+ permissionGetById.getPermissionId() +" Permission name "+permissionGetById.getPermissionName()+"</h3>");
//
//
//            Permission permissionGetByName=al.getPermissionByName("Show Review");
//            out.println("Method getPermissionByName <h3> Permission ID "+ permissionGetByName.getPermissionId() +" Permission name "+permissionGetByName.getPermissionName()+"</h3>");
//                
//            Collection<Permission> lstpermission= al.getAllPermissions();
//            
//            for (Permission p : lstpermission) {
//                out.println("Permission ID= "+p.getPermissionId() + " Permission name= "+p.getPermissionName()+"<br>");
//            }
            //==============================================================================
            //==============================================================================
            //----------Role Permission--------------------Role permission------------Role Permission--------------------------------
            //==============================================================================
            //==============================================================================
            //--------------add---------------
//            al.addRolePermission(1,2);
            //-------------------update----------------
//            al.updateRolePermission(1, 2, 2);
//            al.removeRolePermission(5);
//            Rolepermission rpById=al.getRolePermissionById(2);
//            out.println("get rolePermissionByid "+rpById.getPermissionId()+"  role= "+rpById.getRoleId()+" permission "+rpById.getPermissionId()+"<br>");
            
//            Rolepermission rpByPid=al.getRolePermissionByPermissionId(2);
//            out.println("get rolePermissionByPermissionid "+rpByPid.getPermissionId()+"  role= "+rpByPid.getRoleId()+" permission "+rpByPid.getPermissionId()+"<br>");    

//            Rolepermission rpByRid=al.getRolePermissionByRoleId(1);
//            out.println("get rolePermissionByRoleid "+rpByRid.getPermissionId()+"  role= "+rpByRid.getRoleId()+" permission "+rpByRid.getPermissionId()+"<br>");    

            
//            Collection<Rolepermission> lstRp = al.getAllRolePermission();
//            for (Rolepermission obj : lstRp) {
//                out.println("RolePermissionId ID= "+obj.getRolePermissionId() + " Role ID= "+obj.getRoleId().getRoleName()+" Permission id "+ obj.getPermissionId().getPermissionName() +" <br>");
//            }

            //==============================================================================
            //==============================================================================
            //----------users--------------------users------------users--------------------------------
            //==============================================================================
            //==============================================================================
//            Users userForInsert=new Users();
//            userForInsert.setName("john Robinson");
//            userForInsert.setEmail("john@gmail.com");
//            userForInsert.setPhoneNumber("5555555555");
//            userForInsert.setInterest("games");
//            userForInsert.setGender("male");
//            String bdate="8/6/1980";
//            userForInsert.setBirthdate(new SimpleDateFormat("dd/MM/yyyy").parse(bdate));
//            userForInsert.setCity("NewYork");
//            userForInsert.setPassword(clientejb.getEncryptedPassword("john451245"));
//            clientejb.addUser(userForInsert);
//            Users userForUpdate=new Users(2);
//            userForUpdate.setName("Penny Robinson");
//            userForUpdate.setEmail("penny@yahoo.com");
//            userForUpdate.setPhoneNumber("987456321");
//            userForUpdate.setInterest("books");
//            userForUpdate.setGender("female");
//            String bdate="13/6/1997";
//            userForUpdate.setBirthdate(new SimpleDateFormat("dd/MM/yyyy").parse(bdate));
//            userForUpdate.setCity("NewYork");
//            userForUpdate.setPassword(clientejb.getEncryptedPassword("penny1223456789"));
//            clientejb.updateUser(userForUpdate);
//            clientejb.removeUser(3);
//            Users findByName=clientejb.getUserByName("Will Robinson");
//            out.println("Method FindByName "+"<h1> Name="+findByName.getName()+" interset="+findByName.getInterest()+"</h1>");
//
//            
//            Users findByEmail=clientejb.getUserByEmail("penny@yahoo.com");
//            out.println("Method FindByEmail "+"<h1> Name="+findByEmail.getName()+" interset="+findByEmail.getInterest()+"</h1>");
//            
//            Collection<Users> lstUserByCity =clientejb.getUserByCity("NewYork");
//            
//            
//            for (Users u1 : lstUserByCity) {
//                out.println("<h4>Users by Their City</h4>");
//                out.println("Name= "+u1.getName()+" Email= "+u1.getEmail()+" Phno= "+u1.getPhoneNumber()+" Interest= "+u1.getInterest()+" gender= "+u1.getGender()+" Birthdate= "+u1.getBirthdate()+" city= "+u1.getCity()+" Password= "+u1.getPassword()+"<br>");
//            }
//            
//            
//            Collection<Users> lst=clientejb.getAllUsers();
//            
//            for (Users u : lst) {
//                
//                out.println("Name= "+u.getName()+" Email= "+u.getEmail()+" Phno= "+u.getPhoneNumber()+" Interest= "+u.getInterest()+" gender= "+u.getGender()+" Birthdate= "+u.getBirthdate()+" city= "+u.getCity()+" Password= "+u.getPassword()+"<br>");
//                out.println("<hr>");
//            }
            //==============================================================================
            //==============================================================================
            //----------Advertise--------------------Advertise------------Advertise--------------------------------
            //==============================================================================
            //==============================================================================
            
            
//            String sd="14/2/2020";
//            String ed="19/2/2020";
//            clientejb.addAdvertise(new SimpleDateFormat("dd/MM/yyyy").parse(sd),new SimpleDateFormat("dd/MM/yyyy").parse(ed),2);

//            Advertise objAdForUpdate=new Advertise(4);
            String sd="15/3/2020";
            String ed="20/3/2020";
//            objAdForUpdate.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(sd));
//            objAdForUpdate.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(ed));
//            objAdForUpdate.setProductId(new Product(2));
//            clientejb.updateAdvertise(6,new SimpleDateFormat("dd/MM/yyyy").parse(sd),new SimpleDateFormat("dd/MM/yyyy").parse(ed),3);


//            clientejb.removeAdvertise(2);

//            String tdate="16/3/2020";
//            Collection<Advertise> getAdFromDate=clientejb.getAdvertiseByDate(new SimpleDateFormat("dd/MM/yyyy").parse(tdate));
//            out.println("<h3>Folling ad will display on "+tdate+"</h3><br>");
//            for (Advertise advertise : getAdFromDate) {
//                DateFormat df=new SimpleDateFormat("dd MMM,yyyy");
//                String  tempSdate = df.format(advertise.getStartDate());
//                String  tempEedate = df.format(advertise.getEndDate());
//                out.println("AdId "+advertise.getAdvertiseId()+"| AdStart "+tempSdate+"| AdEnd "+tempEedate+"| Product "+advertise.getProductId().getProductName()+"<br>");
//                
//            }
//            out.println("<hr>");
//            
//            Collection<Advertise> lst=clientejb.getAllAdvertise();
//           
//            for (Advertise a : lst) 
//            {
//                DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");  
//                String  sdate = dateFormat.format(a.getStartDate());
//                String  edate = dateFormat.format(a.getEndDate());
//                out.println("ID="+a.getAdvertiseId()+"| Strat Date="+sdate+
//                        "| End Date="+edate+"| Product="
//                        +a.getProductId().getProductName()+"<br>");
//            }

            //==============================================================================
            //==============================================================================
            //----------userrole--------------------userrole------------userrole--------------------------------
            //==============================================================================
            //==============================================================================

            
                //-----------------------------add userrole---------------------
//            al.addUserRole(4,6);
            
//            Userrole userRoleForUpdate=new Userrole(2);
//            userRoleForUpdate.setRoleId(new Role(1));
//            userRoleForUpdate.setUserId(new Users(1));

//            al.updateUserRole(4,2,3);

//            al.removeUserRole(4);
            
//            Collection<Userrole> lst=al.getAllUserRole();
//            for (Userrole ur : lst) {
//                out.println("UserRole ID="+ur.getUserRoleId()+" | Role="+ur.getRoleId().getRoleName()+" | user="+ur.getUserId().getName()+"<br>");
//            }
            
            
            out.println("<body>");

//            Collection<Ratingcriterias> ratingcriteriases = admin.getAllRatingCriteria();

//            for (Ratingcriterias ratingcriteriase : ratingcriteriases) {
//                out.println(ratingcriteriase.getCriteriaName());
//            }

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            
        }
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
