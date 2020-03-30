/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Advertise;
import entity.Users;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface clientejbLocal {
    //user    
    Collection<Users> getAllUsers();
    Users getUserById(int userId);
    Users getUserByName(String name);
    Users getUserByEmail(String email);
    Collection<Users> getUserByCity(String city);
    void addUser(Users objUser);
    void updateUser(Users objUser);
    void removeUser(int userId);
    String getEncryptedPassword(String Password);
    
    
    //advertisement
    
    Collection<Advertise> getAllAdvertise();
    Advertise getAdvertiseById(int advertiseId);
    Advertise getAdvertiseByProductId(int productId);
    Collection<Advertise> getAdvertiseByDate(Date date); 
    //(if advertise is exists between start date and end date)
    void addAdvertise(Date startDate,Date endDate,int productId);
    void updateAdvertise(int advertiseId,Date startDate,Date endDate,int productId);
    void removeAdvertise(int advertiseId);
    public Collection<Advertise> getAdvertiseByDate(String tdate);
}
