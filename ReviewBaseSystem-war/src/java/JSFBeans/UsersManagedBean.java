/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.UsersJerseyClient;
import ejb.clientejbLocal;
import entity.Users;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author hi
 */
@Named(value = "usersManagedBean")
@RequestScoped
public class UsersManagedBean {

    @EJB
    clientejbLocal client;
    UsersJerseyClient ujc = new UsersJerseyClient();
    /**
     * Creates a new instance of UsersManagedBean
     */

    private int userid;
    private String name, email, phno, interest, gender, city, password, birthdateString, sessionEmail;
    private Date birthdate;
    private Collection<Users> ulist;

    public clientejbLocal getClient() {
        return client;
    }

    public void setClient(clientejbLocal client) {
        this.client = client;
    }

    public String getSessionEmail() {
        return sessionEmail;
    }

    public void setSessionEmail(String sessionEmail) {
        this.sessionEmail = sessionEmail;
    }

    public void birthdatechange(ValueChangeEvent e) {
        birthdateString = e.getNewValue().toString();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Users> getUlist() {
        return ulist;
    }

    public void setUlist(Collection<Users> ulist) {
        this.ulist = ulist;
    }
    
    
    public Date getToday() {
        return new Date();
    }

//    public Collection<Users> getAllUsers() {
//        Response response = ujc.getAllUsers(Response.class);
//        ArrayList<Users> alist = new ArrayList<Users>();
//        GenericType<Collection<Users>> gAdd = new GenericType<Collection<Users>>() {
//        };
//
//        ulist = (ArrayList<Users>) response.readEntity(gAdd);
//        return ulist;
//    }
    
    @PostConstruct
    public void init()
    {
        Response response = ujc.getAllUsers(Response.class);
        ArrayList<Users> alist = new ArrayList<Users>();
        GenericType<Collection<Users>> gAdd = new GenericType<Collection<Users>>() {
        };

        ulist = (ArrayList<Users>) response.readEntity(gAdd);
    }

    public String getUser(String uid) {
        Response response = ujc.getUserById(Response.class, uid);
        GenericType<Users> gUser = new GenericType<Users>() {
        };
        Users u = response.readEntity(gUser);
        this.userid = u.getUserId();
        this.city = u.getCity();
        this.email = u.getEmail();
        this.gender = u.getGender();
        this.interest = u.getInterest();
        this.name = u.getName();
        this.password = u.getPassword();
        this.phno = u.getPhoneNumber();
//        DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
        this.birthdate = u.getBirthdate();
        return "addUser.xhtml";
    }

    public String addUser() {
        System.out.println("in adduser");
        if (userid != 0) {
//            ujc.updateUser(this.userid+"", name, phno, password, interest, gender, email, city, birthdate);
        } else {            
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            String bdate=df.format(birthdate);
//            System.out.println(bdate);
            System.out.println(this.name + " " + phno + " " + password + " " + interest + " " + gender + " " + email + " " + city + " " + bdate);
            ujc.addUser(name, phno, password, interest, gender, email, city, bdate);
        }
        return "/User/userindex.xhtml";
    }
    
    public void onRowEditUser(RowEditEvent<Users> event) {
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //ujc.updateCategory(event.getObject().getCategoryId() + "", event.getObject().getCategoryName());
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String bdate=df.format(event.getObject().getBirthdate());
        ujc.updateUser(event.getObject().getUserId()+"", event.getObject().getName(), event.getObject().getPhoneNumber(), event.getObject().getInterest(), event.getObject().getGender(), event.getObject().getEmail(), event.getObject().getCity(), bdate);
    }
    
    public void onRowCancelUser(RowEditEvent<Users> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    
    public String addUserByAdmin()
    {
        System.out.println("in adduser");
        if (userid != 0) {
//            ujc.updateUser(this.userid+"", name, phno, password, interest, gender, email, city, birthdate);
        } else {            
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            String bdate=df.format(birthdate);
//            System.out.println(bdate);
            System.out.println(this.name + " " + phno + " " + password + " " + interest + " " + gender + " " + email + " " + city + " " + bdate);
            ujc.addUser(name, phno, password, interest, gender, email, city, bdate);
        }
        return "/Admin/userindex.xhtml?faces-redirect=true";
    }

    public String deleteUser(String uid) {
        ujc.deleteUser(uid);
        return "/Admin/userindex.xhtml?faces-redirect=true";
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("in init");
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            System.out.println("session null");
//        } else {
//            System.out.println("session not null");
//        }
//        try {
//            if (session.getAttribute("User") == "" || session.getAttribute("User") == null) {
//                System.out.println("in if"+session.getAttribute("User"));
//                response.sendRedirect(request.getContextPath() + "/Login.xhtml");
//                //backToLogin();
//            } else {
//                System.out.println("in else "+session.getAttribute("User"));
//                setSessionEmail(session.getAttribute("User").toString());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    
    public String backToLogin()
    {
        return "http://localhost:8080/ReviewBaseSystem-war/Login.xhtml";
    }

    public UsersManagedBean() {
    }
    
    public void logout() throws IOException {
        System.out.println("in logout");
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        ec.invalidateSession();
//        ec.redirect(ec.getRequestContextPath() + "/Login.xhtml");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpSession session = request.getSession(true);
        try {
            session.invalidate();
            request.logout();
            response.sendRedirect(request.getContextPath() + "/Login.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
