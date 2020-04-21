/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.UsersJerseyClient;
import ejb.clientejbLocal;
import entity.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hi
 */
@Named(value = "usersManagedBean")
@RequestScoped
public class UsersManagedBean {

    @EJB clientejbLocal client;
    UsersJerseyClient ujc=new UsersJerseyClient(); 
    /**
     * Creates a new instance of UsersManagedBean
     */
    private int userid;
    private String name,email,phno,interest,gender,city,password;
    private Date birthdate;
    private Collection<Users> ulist;

    public clientejbLocal getClient() {
        return client;
    }

    public void setClient(clientejbLocal client) {
        this.client = client;
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
    
    
    public Collection<Users> getAllUsers()
    {
        Response response = ujc.getAllUsers(Response.class);
        ArrayList<Users> alist = new ArrayList<Users>();
        GenericType<Collection<Users>> gAdd = new GenericType<Collection<Users>>(){};
        
        ulist = (ArrayList<Users>) response.readEntity(gAdd);
        return ulist;
    }
    
    public String getUser(String uid)
    {
        Response response=ujc.getUserById(Response.class, uid);
        GenericType<Users> gUser=new GenericType<Users>(){};
        Users u=response.readEntity(gUser);
        this.userid=u.getUserId();
        this.city=u.getCity();
        this.email=u.getEmail();
        this.gender=u.getGender();
        this.interest=u.getInterest();
        this.name=u.getName();
        this.password=u.getPassword();
        this.phno=u.getPhoneNumber();
//        DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
        this.birthdate=u.getBirthdate();
        return "addUser.xhtml";
    }
    
    public String addUser()
    {
        System.out.println("in adduser1");
        if(userid!=0)
        {
//            ujc.updateUser(this.userid+"", name, phno, password, interest, gender, email, city, birthdate);
        }
        else
        {
            System.out.println(this.name+" "+phno+" "+password+" "+interest+" "+gender+" "+email+" "+city+" "+birthdate);
            DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
            String bdate=df.format(birthdate);
            ujc.addUser(name, phno, password, interest, gender, email, city, bdate);
        }
        return "usersindex.xhtml";
    }
    
    public String deleteUser(String uid)
    {
        ujc.deleteUser(uid);
        return "usersTemplateClient.xhtml";
    }
    
    
    public UsersManagedBean() {
    }
    
}
