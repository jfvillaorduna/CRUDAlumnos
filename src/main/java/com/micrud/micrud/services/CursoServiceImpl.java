package com.micrud.micrud.services;

import com.micrud.micrud.entities.Curso;
import com.micrud.micrud.repositories.CursoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile({"instancia1", "instancia2"})
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepo;

    public CursoServiceImpl(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    public List<Curso> findAll() {
        return cursoRepo.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepo.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepo.save(curso);
    }

    public void deleteById(Long id) {
        if (cursoRepo != null) {
            cursoRepo.deleteById(id);
        }
    }
}

