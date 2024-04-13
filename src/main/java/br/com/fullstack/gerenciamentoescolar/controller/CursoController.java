package br.com.fullstack.gerenciamentoescolar.controller;

import br.com.fullstack.gerenciamentoescolar.model.AlunoModel;
import br.com.fullstack.gerenciamentoescolar.model.CursoModel;
import br.com.fullstack.gerenciamentoescolar.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<CursoModel> get() {
        return cursoService.buscarCursos();
    }

    @PostMapping
    public CursoModel post(@RequestBody CursoModel curso) throws Exception {
        return cursoService.salvar(curso);
    }

    @PostMapping("{id}/add-aluno")
    public CursoModel post(@PathVariable Integer id, @RequestBody AlunoModel aluno) throws Exception {
        return cursoService.matricularAluno(id, aluno.getId());
    }

}
