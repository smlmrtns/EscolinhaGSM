/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class ServicosFactory {

    private static EscolaServicos escolaServicos = new EscolaServicos();

    public static EscolaServicos getEscolaServicos() {

        return escolaServicos;
    }

}
