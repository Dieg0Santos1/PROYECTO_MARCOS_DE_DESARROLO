package com.example.demo.controller;

import com.example.demo.service.EstudianteService;
import com.example.demo.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    public HomeController(EstudianteService estudianteService, CursoService cursoService) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
}
