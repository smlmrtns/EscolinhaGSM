/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.AlunoDAO;
import dao.DAOFactory;
import dao.ProfessorDAO;
import dao.DirecaoDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AlunoVO;
import modelo.DirecaoVO;
import modelo.ProfessorVO;
import modelo.TurmaVO;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class EscolaServicos {

    public void cadastrarUsuario(DirecaoVO dVO) throws SQLException {
        DirecaoDAO uDAO = DAOFactory.getDirecaoDAO();
        uDAO.cadastrarUsuario(dVO);
    }

    public ArrayList<DirecaoVO> buscarUsuarios() throws SQLException {
        DirecaoDAO dDAO = DAOFactory.getDirecaoDAO();
        return dDAO.buscarUsuarios();
    } 

    public boolean validarSenha(DirecaoVO d) throws SQLException {
        DirecaoDAO uDAO = DAOFactory.getDirecaoDAO();
        return uDAO.validarSenha(d);
    }

    public ArrayList<AlunoVO> buscarAluno() throws SQLException {
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        return aDAO.buscarAluno();
    }

    public ArrayList<AlunoVO> filtrarAluno(String query) throws SQLException {
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        return aDAO.filtrarAluno(query);
    }  

    public void cadastrarAluno(AlunoVO aVO) throws SQLException {
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.cadastrarAluno(aVO);
    }

    public void cadastrarTurma(TurmaVO tVO) throws SQLException {
        TurmaDAO tDAO = DAOFactory.getTurmaDAO();
        tDAO.cadastrarTurma(tVO);
    }

    public ArrayList<TurmaVO> buscarTurma() throws SQLException {
        TurmaDAO tDAO = DAOFactory.getTurmaDAO();
        return tDAO.buscarTurma();
    }

    public void cadastrarProfessor(ProfessorVO pVO) throws SQLException {
        ProfessorDAO pDAO = DAOFactory.getProfessorDAO();
        pDAO.cadastrarProfessor(pVO);
    }

    public ArrayList<ProfessorVO> buscarProfessor() throws SQLException {
        ProfessorDAO pDAO = DAOFactory.getProfessorDAO();
        return pDAO.buscarProfessor();
    }

    public void alterarAluno(AlunoVO aVO) throws SQLException {
        AlunoDAO aDAO = DAOFactory.getAlunoDAO();
        aDAO.alterarAluno(aVO);
    }
}
