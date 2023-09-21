package com.cambers.eventplanner.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        //verifica si ya esta autenticado, si es asi entonces lo manda a su pagina de inicio
        // en base al rol, si no entonces ahora si muestra la ventana para que se autentique
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated() && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/users/index";
        } else if (auth.isAuthenticated() && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PLANNER"))) {
            return "redirect:/user/dashboard";
        }

        return "/common/login";
    }
}
