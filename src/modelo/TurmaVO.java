/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class TurmaVO {

    private long idTurma;
    private String materia;
    private AlunoVO aluno;
    private ProfessorVO professor;

    public TurmaVO() {
    }

    public TurmaVO(long idTurma, String materia, AlunoVO aluno, ProfessorVO professor) {
        this.idTurma = idTurma;
        this.materia = materia;
        this.aluno = aluno;
        this.professor = professor;
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public AlunoVO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoVO aluno) {
        this.aluno = aluno;
    }

    public ProfessorVO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorVO professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return idTurma + " - " + materia;
    }

}
