package com.senai.gerenciamentoalunos.service;

import com.senai.gerenciamentoalunos.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoService {

    public List<CursoModel> buscarCursos(){
        return CursoModel.getCursos();
    }

    public CursoModel salvar(CursoModel curso) throws Exception {
        if (validar(curso)){
            return CursoModel.addCurso(curso);
        }
        return null;
    }

    private boolean validar (CursoModel curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()){
            throw new Exception("Nome é obrigatório.");
        }

        if (curso.getCargaHoraria() == null){
            throw new Exception("Data de nascimento é obrigatória.");
        }
        return true;
    }
}
