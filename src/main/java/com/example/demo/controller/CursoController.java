package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", service.listarTodos());
        return "cursos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Curso curso) {
        service.guardar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable Long id, Model model) {
        Curso curso = service.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        model.addAttribute("curso", curso);
        model.addAttribute("cursos", service.listarTodos());
        return "cursos";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Curso curso) {
        service.guardar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/cursos";
    }
}
