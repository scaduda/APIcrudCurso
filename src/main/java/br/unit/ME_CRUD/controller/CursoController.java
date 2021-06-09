package br.unit.ME_CRUD.controller;

import java.util.List;
import java.util.Optional;

import br.unit.ME_CRUD.model.Curso;
import br.unit.ME_CRUD.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> index(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Object show(@PathVariable(value = "id") int id){
        Optional<Curso> optional = cursoRepository.findById(id);
        if(optional.isPresent()){
            return optional;
        }
        return new ResponseEntity<>("Desculpe, não encontramos esse curso :(", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso store(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @PutMapping
    public Curso update(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        cursoRepository.deleteById(id);
    }

}
