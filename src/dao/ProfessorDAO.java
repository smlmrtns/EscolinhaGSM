/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ProfessorVO;
import persistencia.ConexaoBanco;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class ProfessorDAO {

    public void alterarAluno(ProfessorVO pVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "update aluno set "
                    + "nome ='" + pVO.getNome() + "', idade=" + pVO.getIdade()
                    + ", n1=" + pVO.getAluno().getN1() + ", n2=" + pVO.getAluno().getN2()
                    + ", median= " + pVO.getAluno().calcularMedia() + " "
                    + "where idaluno=" + pVO.getAluno().getIdAluno() + "";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar "
                    + "aluno! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public ArrayList<ProfessorVO> buscarProfessor() throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "select * from professor";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<ProfessorVO> professores = new ArrayList<>();
            while (rs.next()) {
                ProfessorVO pVO = new ProfessorVO();
                pVO.setIdProfessor(rs.getLong("idprofessor"));
                pVO.setNome(rs.getString("nome"));
                pVO.setSexo(rs.getString("sexo"));
                pVO.setIdade(rs.getInt("idade"));
                professores.add(pVO);
            }
            return professores;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar professor! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public void cadastrarProfessor(ProfessorVO pVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;

            sql = "insert into professor(idprofessor,nome,sexo,idade)"
                    + "values(null,'" + pVO.getNome() + "', '" + pVO.getSexo() + "', " + pVO.getIdade() + ")";

            stat.execute(sql);

        } catch (SQLException se) {
            throw new SQLException("Erro ao cadastrar episódio! " + se.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
}
