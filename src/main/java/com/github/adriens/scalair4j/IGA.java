/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.scalair4j;

import java.util.HashMap;

/**
 *
 * @author salad74
 */
public class IGA {

    private int indice;
    private String message;
    private IGAColor color;
    
    public final static String MESSAGE_INDICE_1 = "Très bon";
    public final static String MESSAGE_INDICE_2 = "Très bon";
    public final static String MESSAGE_INDICE_3 = "Bon";
    public final static String MESSAGE_INDICE_4 = "Bon";
    public final static String MESSAGE_INDICE_5 = "Moyen";
    public final static String MESSAGE_INDICE_6 = "Médiocre";
    public final static String MESSAGE_INDICE_7 = "Médiocre";
    public final static String MESSAGE_INDICE_8 = "Mauvais";
    public final static String MESSAGE_INDICE_9 = "Mauvais";
    public final static String MESSAGE_INDICE_10 = "Très mauvais";
    public final static String[] MESSAGES = {MESSAGE_INDICE_1,
                                                MESSAGE_INDICE_2,
                                                MESSAGE_INDICE_3,
                                                MESSAGE_INDICE_4,
                                                MESSAGE_INDICE_5,
                                                MESSAGE_INDICE_6,
                                                MESSAGE_INDICE_7,
                                                MESSAGE_INDICE_8,
                                                MESSAGE_INDICE_9,
                                                MESSAGE_INDICE_10
                                                };
    
    public IGA() {

    }

    public IGA(int anIndice) {
        setIndice(anIndice);
        
    }
    public String toString(){
        return getIndice() + "";
    }
    
    public IGAColor getColor(){
        if(getIndice() <= 4){
            return IGAColor.GREEN;
        }
        else if ( (getIndice() > 4) && (getIndice() <= 7)){
            return IGAColor.YELLOW;
        }
        else if (getIndice() >= 8) {
            return IGAColor.RED;
        }
        else {
            return IGAColor.UNKNOWN;
        }
    }
    public String getMessage(){
        String out = "";
        return IGA.MESSAGES[getIndice()];
    }
    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public static final HashMap<Integer, IGA> getIGAs(){
        HashMap<Integer, IGA> out = new HashMap<Integer, IGA>();
        for(int i=1; i<=MESSAGES.length; i++){
              out.put(new Integer(i), new IGA(i));
         }
        return out;
    }
    
    public static void main(String[] args){
        HashMap<Integer, IGA> out = IGA.getIGAs();
        System.out.println("Found <" + out.size() + "> IGAs");
    }
}
