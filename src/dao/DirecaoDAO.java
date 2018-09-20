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
import modelo.DirecaoVO;
import persistencia.ConexaoBanco;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class DirecaoDAO {

    public void cadastrarUsuario(DirecaoVO dVO) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "insert into usuario(idusuario, login, senha)"
                    + "values(null, '" + dVO.getLogin() + "', '" + dVO.getSenha() + "')";
            stat.execute(sql);

        } catch (SQLException se) {
            throw new SQLException("Erro ao inserir usuário! " + se.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public ArrayList<DirecaoVO> buscarUsuarios() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "select * from usuario";

            ResultSet rs = stat.executeQuery(sql);
            ArrayList<DirecaoVO> users = new ArrayList<>();
            while (rs.next()) {
                DirecaoVO d = new DirecaoVO();

                d.setIdUsuario(rs.getLong("idusuario"));
                d.setLogin(rs.getString("nome"));
                d.setSenha(rs.getString("senha"));
                users.add(d);
            }

            return users;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar usuários! " + se.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public boolean validarSenha(DirecaoVO d) throws SQLException {

        Connection conexao = ConexaoBanco.getConexao();
        Statement stat = conexao.createStatement();

        String sql;

        sql = "select count(*)"
                + " from usuario"
                + " where login ='" + d.getLogin() + "' and"
                + " senha = '" + d.getSenha() + "' ";

        ResultSet rs = stat.executeQuery(sql);
        int retorno = -2;

        while (rs.next()) {
            retorno = rs.getInt(1);
        }

        if (retorno == 1) {
            stat.close();
            return true;
        } else {
            return false;
        }
    }

}
