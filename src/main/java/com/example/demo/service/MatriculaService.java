package com.example.demo.service;

import com.example.demo.model.Matricula;
import com.example.demo.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;

    public MatriculaService(MatriculaRepository repository) {
        this.repository = repository;
    }

    public List<Matricula> listarTodas() {
        return repository.findAll();
    }

    public void guardar(Matricula matricula) {
        repository.save(matricula);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
