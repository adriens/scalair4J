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
    private IGA iga;
    
    private int id;
    
    
    public final static String NOM_STATION_FAUBOURG_BLANCHOT = "Faubourg Blanchot";
    public final static String NOM_STATION_LOGICOOP = "Logicoop";
    public final static String NOM_STATION_MONTRAVEL = "Montravel";
    public final static String NOM_STATION_ANSE_VATA = "Anse Vata";
    public final static String NOM_STATION_GENERAL = "Général";
    
    public final static int ID_STATION_FAUBOURG_BLANCHOT = 98003;
    public final static int ID_STATION_LOGICOOP = 98001;
    public final static int ID_STATION_MONTRAVEL = 98002;
    public final static int ID_STATION_ANSE_VATA = 98004;
    public final static int ID_STATION_GENERAL = 0;// pas une vraie station
    
    
    public Station(){
        
    }
    

    public String toString(){
        String out = "";
        out += "Nom : <" + getNom() + ">\n";
        out += "Coleur : <" + getIga().getColor() + ">\n";
        out += "IGA : <" + getIga().getIndice() + ">\n";
        out += "Message : <" + getIga().getMessage() + ">\n";
        out += "Typologie : <" + getTypologie() + ">\n";
        out += "Id : <" + getId() + ">\n";
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
