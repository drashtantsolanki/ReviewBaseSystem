/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.UserRoleJerseyClient;
import entity.Userrole;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.RowEditEvent;


/**
 *
 * @author hi
 */
@Named(value = "userRoleManagedBean")
@RequestScoped
public class UserRoleManagedBean {

    /**
     * Creates a new instance of UserRoleManagedBean
     */
    
    UserRoleJerseyClient urjc=new UserRoleJerseyClient();
    private int userroleid,userid,roleid;
    private Collection<Userrole> userRoleList;

    public UserRoleManagedBean() {
    }
    
    public int getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(int userroleid) {
        this.userroleid = userroleid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Collection<Userrole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(Collection<Userrole> userRoleList) {
        this.userRoleList = userRoleList;
    }
    
    
    @PostConstruct
    public void init()
    {
        Response response = urjc.getUserRole(Response.class);
        ArrayList<Userrole> alist = new ArrayList<Userrole>();
        GenericType<Collection<Userrole>> gur=new GenericType<Collection<Userrole>>(){};
        userRoleList=response.readEntity(gur);
        System.out.println(userRoleList);
    }
    
    public String addUserRole()
    {
        System.out.println("in add");
        System.out.println(" user "+userid+" role "+roleid);
        urjc.addUserRole(userid+"", roleid+"");
        return "/Admin/userroleindex.xhtml?faces-redirect=true";
    }
    
    
    public void onRowEditRole(RowEditEvent<Userrole> event) {
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getUserId().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        urjc.updateUserRole(event.getObject().getUserRoleId()+"", event.getObject().getUserId().getUserId()+"", event.getObject().getRoleId().getRoleId()+"");
    }

    public void onRowCancelRole(RowEditEvent<Userrole> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getUserId().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String deleteUserRole(int id)
    {
        System.out.println("userroleid "+id);
        urjc.deleteUserrole(id+"");
        return "/Admin/userroleindex.xhtml?faces-redirect=true";
    }
}
