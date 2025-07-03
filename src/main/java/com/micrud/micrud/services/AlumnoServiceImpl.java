package com.micrud.micrud.services;

import com.micrud.micrud.entities.Alumno;
import com.micrud.micrud.repositories.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepo;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepo) {
        this.alumnoRepo = alumnoRepo;
    }

    @Override
    public List<Alumno> findAll() {
        return List.of();
    }

    public Optional<Alumno> findById(Long id) {
        return alumnoRepo.findById(id);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepo.save(alumno);
    }

    public Optional<Alumno> deleteById(Long id) {
        Optional<Alumno> alumno = alumnoRepo.findById(id);
        alumno.ifPresent(a -> alumnoRepo.delete(a));
        return alumno;
    }
}
