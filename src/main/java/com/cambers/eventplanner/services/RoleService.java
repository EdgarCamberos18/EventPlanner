package com.cambers.eventplanner.services;

import com.cambers.eventplanner.models.Role;
import com.cambers.eventplanner.repositories.RoleReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleReposiroty roleReposiroty;

    @Autowired
    public RoleService(RoleReposiroty roleReposiroty){
        this.roleReposiroty = roleReposiroty;
    }

    public List<Role> getAllRoles(){
        return roleReposiroty.findAll();
    }


}
