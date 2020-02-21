/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Role;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author hi
 */
@Stateless
public class adminejb implements adminejbLocal {

    @Override
    public Collection<Role> getAllRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
