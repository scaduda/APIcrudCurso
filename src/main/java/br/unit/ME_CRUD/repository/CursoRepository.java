package br.unit.ME_CRUD.repository;

import br.unit.ME_CRUD.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository  extends JpaRepository<Curso, Integer> {

}
