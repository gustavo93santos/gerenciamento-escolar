package br.com.fullstack.gerenciamentoescolar.service;

import br.com.fullstack.gerenciamentoescolar.model.AlunoModel;
import br.com.fullstack.gerenciamentoescolar.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public List<CursoModel> buscarCursos(){
        return CursoModel.getCursos();
    }

    public CursoModel buscarPorId(Integer id) throws Exception{
        return CursoModel.buscarPorId(id);
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

    public CursoModel matricularAluno(Integer id, Integer alunoId) throws Exception {
        CursoModel curso = buscarPorId(id);
        AlunoModel aluno = alunoService.buscarPorId(alunoId);

        CursoModel.matricular(curso,aluno);
        return curso;
    }
}
