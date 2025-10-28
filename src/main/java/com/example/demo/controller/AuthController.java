package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String username, 
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {
        if (usuarioService.autenticar(username, password)) {
            session.setAttribute("usuarioLogueado", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
    }

    @GetMapping("/register")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@Valid @ModelAttribute Usuario usuario,
                                    BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        
        if (usuarioService.buscarPorUsername(usuario.getUsername()).isPresent()) {
            model.addAttribute("error", "El usuario ya existe");
            return "register";
        }

        usuario.setRol("USER");
        usuarioService.guardar(usuario);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        return "index";
    }
}
