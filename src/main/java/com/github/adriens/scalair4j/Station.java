/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.scalair4j;

/**
 *
 * @author salad74
 */
public class Station {
    private StationTypologie typologie;
    private StationLieu lieu;
    
    private String nom;
    private int positionHtml;
    private IGA iga;
    
    
    public final static String NOM_STATION_FAUBOURG_BLANCHOT = "Faubourg Blanchot";
    public final static String NOM_STATION_LOGICOOP = "Logicoop";
    public final static String NOM_STATION_MONTRAVEL = "Montravel";
    public final static String NOM_STATION_ANSE_VATA = "Anse Vata";
    public final static String NOM_STATION_GENERAL = "Général";
    
    
    public Station(){
        
    }
    

    public String toString(){
        String out = "";
        out += "Nom : <" + getNom() + ">\n";
        out += "Coleur : <" + getIga().getColor() + ">\n";
        out += "IGA : <" + getIga().getIndice() + ">\n";
        out += "Message : <" + getIga().getMessage() + ">\n";
        out += "Typologie : <" + getTypologie() + ">";
        return out;
    }
    
    
    
    /**
     * @return the typologie
     */
    public StationTypologie getTypologie() {
        return typologie;
    }

    /**
     * @param typologie the typologie to set
     */
    public void setTypologie(StationTypologie typologie) {
        this.typologie = typologie;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the positionHtml
     */
    public int getPositionHtml() {
        return positionHtml;
    }

    /**
     * @param positionHtml the positionHtml to set
     */
    public void setPositionHtml(int positionHtml) {
        this.positionHtml = positionHtml;
    }

    /**
     * @return the iga
     */
    public IGA getIga() {
        return iga;
    }

    /**
     * @param iga the iga to set
     */
    public void setIga(IGA iga) {
        this.iga = iga;
    }

    /**
     * @return the lieu
     */
    public StationLieu getLieu() {
        return lieu;
    }

    /**
     * @param lieu the lieu to set
     */
    public void setLieu(StationLieu lieu) {
        this.lieu = lieu;
    }
}
