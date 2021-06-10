package br.unit.ME_CRUD.controller;

import java.util.List;
import java.util.Optional;

import br.unit.ME_CRUD.model.Curso;
import br.unit.ME_CRUD.repository.CursoRepository;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="Retorna lista de cursos")
    public List<Curso> index(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna um curso")
    public Object show(@PathVariable(value = "id") int id){
        Optional<Curso> optional = cursoRepository.findById(id);
        if(optional.isPresent()){
            return optional;
        }
        return new ResponseEntity<>("Desculpe, não encontramos esse curso :(", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ApiOperation(value="Cria curso")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso store(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @PutMapping
    @ApiOperation(value="Atualiza curso")
    public Curso update(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta curso")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        cursoRepository.deleteById(id);
    }

}
