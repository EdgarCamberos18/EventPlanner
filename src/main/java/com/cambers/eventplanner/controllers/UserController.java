package com.cambers.eventplanner.controllers;

import com.cambers.eventplanner.models.Role;
import com.cambers.eventplanner.models.User;
import com.cambers.eventplanner.services.RoleService;
import com.cambers.eventplanner.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("admin/users")
public class UserController {


    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;



    @GetMapping("/template")
    public String inicio(){
        return "/common/template";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = userService.getAllUsersWithRoles();
        model.addAttribute("users", users);
        log.info("El valor de miVariable es: {}", users);
        return "admin/users/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        log.info("El valor de miVariable es: {}", roles);
        return "admin/users/create";
    }



}
