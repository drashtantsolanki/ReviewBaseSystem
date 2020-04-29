/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author hi
 */


@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(loginPage = "Login.xhtml")
)

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "review",
        callerQuery = "SELECT Password FROM users WHERE Email=?",
        groupsQuery = "select RoleName from users u,role r, userrole ur where ur.UserId = u.UserId and ur.RoleId = r.RoleId and u.Email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)

@Named
@ApplicationScoped
public class ProjectConfig {
    
}
