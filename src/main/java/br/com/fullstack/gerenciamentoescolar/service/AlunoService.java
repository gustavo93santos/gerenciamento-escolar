package br.com.fullstack.gerenciamentoescolar.service;

import br.com.fullstack.gerenciamentoescolar.model.AlunoModel;
import br.com.fullstack.gerenciamentoescolar.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    public List<AlunoModel> buscarAlunos(){
        return AlunoModel.getAlunos();
    }

    public AlunoModel buscarPorId(Integer id) throws Exception{
        return AlunoModel.buscarPorId(id);
    }

    public AlunoModel salvar(AlunoModel aluno) throws Exception {
        if (validar(aluno)){
            return AlunoModel.addAluno(aluno);
        }
        return null;
    }

    private boolean validar (AlunoModel aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()){
            throw new Exception("Nome é obrigatório.");
        }

        if (aluno.getDataNascimento() == null){
            throw new Exception("Data de nascimento é obrigatória.");
        }
        return true;
    }


}
