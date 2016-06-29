package dao;

import java.util.List;

import domain.Role;
 
 // CRUD
public interface RoleDao {
    Long create(Role role);
    Role read(Long id);
    void update(Role role);
    void delete(Role role);
    List<Role> findAll();
    List<Role> findRolesByBeginString(String begin);
}
