package com.example.demo.controller;

import com.example.demo.model.Matricula;
import com.example.demo.service.MatriculaService;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    public MatriculaController(MatriculaService matriculaService,
                               EstudianteService estudianteService,
                               CursoService cursoService) {
        this.matriculaService = matriculaService;
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("matriculas", matriculaService.listarTodas());
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("matricula", new Matricula());
        return "matriculas";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Matricula matricula) {
        matriculaService.guardar(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return "redirect:/matriculas";
    }
}
