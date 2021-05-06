/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import models.User;

public interface UserDAO {
    public Integer addUser(User role);
    public Integer updateUser(User role);
    public Integer deleteUser(User user);
    public User getUserById(Integer id);
    public Integer getUserIdByName(String name);
    public Integer getUserIdByEmailandPass(String email, String pass);
    public List<User> getAllUser();
    
}
