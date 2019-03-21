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
public class IQA {

    private int indice;
    private String message;
    private IQAColor color;
    
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
    
    public IQA() {

    }

    public IQA(int anIndice) {
        setIndice(anIndice);
        
    }
    public String toString(){
        return getIndice() + "/" + getColor() + " (" + getMessage() + ")";
    }
    
    public IQAColor getColor(){
        if(getIndice() <= 4){
            return IQAColor.GREEN;
        }
        else if ( (getIndice() >= 5) && (getIndice() <= 7)){
            return IQAColor.YELLOW;
        }
        else if (getIndice() > 7) {
            return IQAColor.RED;
        }
        else {
            return IQAColor.UNKNOWN;
        }
    }
    public String getMessage(){
        String out = "";
        return IQA.MESSAGES[getIndice()-1];
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
    
    public static final HashMap<Integer, IQA> getIQAs(){
        HashMap<Integer, IQA> out = new HashMap<Integer, IQA>();
        for(int i=0; i<MESSAGES.length; i++){
            IQA aIGA = new IQA(i+1);
              out.put(new Integer(i),aIGA );
              System.out.println(aIGA);
         }
        return out;
    }
    
    public static void main(String[] args){
        HashMap<Integer, IQA> out = IQA.getIGAs();
        System.out.println("Found <" + out.size() + "> IGAs");
    }
}
