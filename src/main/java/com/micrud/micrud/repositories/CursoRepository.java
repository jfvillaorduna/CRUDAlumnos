package com.micrud.micrud.repositories;

import com.micrud.micrud.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
