package com.senai.gerenciamentoalunos.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CursoModel {
    private static Integer proximoId = 1;
    @Getter
    private static List<CursoModel> cursos = new ArrayList<>();


    @Setter(AccessLevel.NONE)
    private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;

    private static Integer getProximoId(){
        return proximoId++;
    }

    public static CursoModel addCurso(CursoModel curso){
        curso.id = getProximoId();
        cursos.add(curso);
        return curso;
    }
}
