package com.cambers.eventplanner.services;

import com.cambers.eventplanner.exeptions.DisabledException;
import com.cambers.eventplanner.exeptions.SubscriptionExpiredException;
import com.cambers.eventplanner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.cambers.eventplanner.models.User> userOptional = userRepository.findByEmail(email);

        // Verificar si el usuario existe
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        // Obtener el usuario
        com.cambers.eventplanner.models.User user = userOptional.get();

        // Verificar la fecha de expiración de la suscripción
        if (user.getSubscriptionExpiryDate() != null
                && user.getSubscriptionExpiryDate().isBefore(LocalDate.now())) {
            throw new SubscriptionExpiredException("La suscripción ha expirado");
        }

        // Verificar si el usuario está habilitado
        if (!user.isEnabled()) {
            throw new DisabledException("La cuenta de usuario está deshabilitada");
        }

        // Obtener los roles del usuario como una lista de cadenas
        var roles = user.getRoles().stream()
                .map(roleEntity -> "ROLE_" + roleEntity.getName())
                .collect(Collectors.toList());

        // Devolver UserDetails
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(roles.toArray(String[]::new))
                .build();

    }

}