/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Role;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface adminejbLocal {

    //Role 
    Collection<Role> getAllRoles();

    
}
