package com.micrud.micrud.repositories;

import com.micrud.micrud.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Profile({"instancia1", "instancia2"})
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
