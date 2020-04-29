/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hi
 */
@Named(value = "loginManagedBean")
@RequestScoped
public class LoginManagedBean {

    @Inject
    SecurityContext sc;
    private String email, pass, message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginManagedBean() {
    }

    public String getValue() {
        System.out.println("in get val");
        return "";
    }

    public String checkLogin() {
        System.out.println("In Checking");
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            Credential credential = new UsernamePasswordCredential(getEmail(), new Password(getPass()));
            AuthenticationStatus status = sc.authenticate(request, response, withParams().credential(credential));
            System.err.println(status);
            System.out.println("email=" + email + " pass=" + pass);
            if (status.equals(SUCCESS)) {
                HttpSession session = request.getSession(true);
//                    session.setAttribute("email",email);
//                    session.setAttribute("password",pass);
                System.out.println(sc.isCallerInRole("Admin"));
                if (sc.isCallerInRole("Admin")) {
                    session.setAttribute("role", "Admin");
                    session.setAttribute("Admin", email);
                    response.sendRedirect("Admin/Roleindex.xhtml");
                    //return "/Admin/Roleindex.xhtml";

                } else if (sc.isCallerInRole("User")) {
                    session.setAttribute("role", "User");
                    session.setAttribute("User", email);
                    response.sendRedirect("User/userindex.xhtml");
                    //return "/User/userindex.xhtml";
                } else {
                    System.out.println("No Role Found");
                }
            } else if (status.equals(SEND_FAILURE)) {
                message = "Username Or Password is Wrong";
                return "Login.xhtml";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void redirectToGoogle() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect("https://www.google.com");
    }
}
