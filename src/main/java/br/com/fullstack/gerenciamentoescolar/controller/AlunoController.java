package br.com.fullstack.gerenciamentoescolar.controller;

import br.com.fullstack.gerenciamentoescolar.model.AlunoModel;
import br.com.fullstack.gerenciamentoescolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<AlunoModel> get() {
        return alunoService.buscarAlunos();
    }

    @PostMapping
    public AlunoModel post(@RequestBody AlunoModel aluno) throws Exception {
        return alunoService.salvar(aluno);
    }

}

