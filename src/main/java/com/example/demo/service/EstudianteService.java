package com.example.demo.service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void guardar(Estudiante e) {
        repository.save(e);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
