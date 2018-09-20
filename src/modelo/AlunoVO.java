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
public class AlunoVO {

    private long idAluno;
    private String nomeAluno, sexo;
    private int idadeAluno;
    private double n1;
    private double n2;
    private TurmaVO turma;
    private double media;

    public AlunoVO() {
    }

    public AlunoVO(long idAluno, String nomeAluno, int idadeAluno, double n1, double n2) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.idadeAluno = idadeAluno;
        this.n1 = n1;
        this.n2 = n2;

    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public int getIdadeAluno() {
        return idadeAluno;
    }

    public void setIdadeAluno(int idadeAluno) {
        this.idadeAluno = idadeAluno;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TurmaVO getTurma() {
        return turma;
    }

    public void setTurma(TurmaVO turma) {
        this.turma = turma;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = calcularMedia();
    }

    public double calcularMedia() {
        return (n1 + n2) / 2;
    }

    public String verificarSituacao() {
        if (calcularMedia() >= 6) {
            return "APROVADO";
        }
        return "REPROVADO";
    }

    @Override
    public String toString() {
        return "\nAluno: " + nomeAluno
                + "\nIdade: " + idadeAluno
                + "\nTurma: " + turma.getIdTurma()
                + "\nN1 : " + n1
                + "\nN2 : " + n2
                + "\nMedia : " + calcularMedia()
                + "\nSituação : " + verificarSituacao();
    }

}
