/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

/**
 *
 * @author Ariel
 */
public class Util {
    public static String getMensagemErro(Exception e) {
        while(e.getCause()!=null){
            e = (Exception) e.getCause();
        }
        String retorno = e.getMessage();
        if(retorno.contains("viola restrição de chave estrangeira")){
            retorno = "registro não pode ser excluido, pois esta sendo referenciado em outra tabela";
        }
        return retorno;
    }
}
