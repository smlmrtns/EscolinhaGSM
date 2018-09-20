/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
    * @author GSM
    * @since 03/04/2018 - 19:11
    * @version 1.5 Los Angeles
    */
public class DAOFactory {
    
    private static ProfessorDAO professorDAO = new ProfessorDAO();
    
    public static ProfessorDAO getProfessorDAO(){
        return professorDAO;
      }

    private static AlunoDAO alunoDAO = new AlunoDAO();
    
    public static AlunoDAO getAlunoDAO(){
        return alunoDAO;
    }
    
    private static DirecaoDAO direcaoDAO = new DirecaoDAO();
    
    public static DirecaoDAO getDirecaoDAO(){
        return direcaoDAO;
    }
    
    private static TurmaDAO turmaDAO = new TurmaDAO();
    
    public static TurmaDAO getTurmaDAO(){
        return turmaDAO;
    }
    
}


