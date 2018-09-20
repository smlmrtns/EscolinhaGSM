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
public class Validacao {

    public static boolean testarNome(String n) {
        String exp = "^[a-zA-Z ]{2,30}$";
        return n.matches(exp);
    }
}
