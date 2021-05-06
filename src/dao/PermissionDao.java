/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;

import models.Permission;


public interface PermissionDao {
    public Integer addPermission(Permission permission);
    public Integer updatePermission(Permission permission);
    public Integer deletePermission(Permission permission);
    public Permission getPermissionById(Integer id);
    public Integer getPermissionIdByName(String name);
    public List<Permission> getAllPermission();
    public List<Permission> getPermissionOf(Integer roleId);
}
