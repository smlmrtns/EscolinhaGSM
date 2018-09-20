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
import modelo.AlunoVO;
import modelo.TurmaVO;
import persistencia.ConexaoBanco;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class AlunoDAO {

    public void cadastrarAluno(AlunoVO aVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "insert into aluno(idaluno, nome, sexo, idade, n1, n2, idturma)"
                    + "values(null, '" + aVO.getNomeAluno() + "', '" + aVO.getSexo() + "', " + aVO.getIdadeAluno() + ", 0 , 0 ," + aVO.getTurma().getIdTurma() + ")";
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar aluno!");
        } finally {
            con.close();
            stat.close();
        }
    }

    public ArrayList<AlunoVO> filtrarAluno(String query) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "select * from aluno " + query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<AlunoVO> aluno = new ArrayList<>();
            while (rs.next()) {
                AlunoVO a = new AlunoVO();

                a.setIdAluno(rs.getLong("idaluno"));
                a.setNomeAluno(rs.getString("nome"));
                a.setSexo(rs.getString("sexo"));
                a.setIdadeAluno(rs.getInt("idade"));
                a.setN1(rs.getDouble("n1"));
                a.setN2(rs.getDouble("n2"));
                TurmaVO t = new TurmaVO();
                t.setIdTurma(rs.getLong("idturma"));
                a.setTurma(t);
                aluno.add(a);
            }
            return aluno;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar aluno! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    } 

    public ArrayList<AlunoVO> buscarAluno() throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "select * from aluno";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<AlunoVO> alunos = new ArrayList<>();
            while (rs.next()) {
                AlunoVO a = new AlunoVO();

                a.setIdAluno(rs.getLong("idaluno"));
                a.setNomeAluno(rs.getString("nome"));
                a.setSexo(rs.getString("sexo"));
                a.setIdadeAluno(rs.getInt("idade"));
                a.setN1(rs.getDouble("n1"));
                a.setN2(rs.getDouble("n2"));
                TurmaVO t = new TurmaVO();
                t.setIdTurma(rs.getLong("idturma"));
                a.setTurma(t);
                alunos.add(a);
            }
            return alunos;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar aluno! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public void alterarAluno(AlunoVO aVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "update aluno "
                    + "set n1= " + aVO.getN1() + ", n2= " + aVO.getN2()
                    + " where idaluno = " + aVO.getIdAluno();

            stat.executeUpdate(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar !");
        } finally {
            con.close();
            stat.close();
        }
    }
}
