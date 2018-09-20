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
import modelo.TurmaVO;
import persistencia.ConexaoBanco;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class TurmaDAO {

    public void cadastrarTurma(TurmaVO tVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "insert into turma(idturma,materia,idprofessor)"
                    + "values(null, '" + tVO.getMateria() + "', " + tVO.getProfessor().getIdProfessor() + ")";
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar turma!");
        } finally {
            con.close();
            stat.close();
        }

    }

    public ArrayList<TurmaVO> buscarTurma() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "select * from turma";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<TurmaVO> turmas = new ArrayList<>();

            while (rs.next()) {
                TurmaVO tVO = new TurmaVO();

                tVO.setIdTurma(rs.getLong("idturma"));
                tVO.setMateria(rs.getString("materia"));
                turmas.add(tVO);
            }

            return turmas;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }

    }
}
