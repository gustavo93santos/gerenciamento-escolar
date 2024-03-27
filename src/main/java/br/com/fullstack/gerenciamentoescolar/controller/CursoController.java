package com.senai.gerenciamentoalunos.controller;

import com.senai.gerenciamentoalunos.model.CursoModel;
import com.senai.gerenciamentoalunos.service.CursoService;
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

}
