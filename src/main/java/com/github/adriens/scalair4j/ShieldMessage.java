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
public class ShieldMessage {
    
    private int schemaVersion = 1;
    private String label;
    private String message;
    private String color;


    public String toString(){
        String out = "";
        out += "schemaversion : <" + getSchemaVersion() + ">\n";
        out += "label : <" + getLabel() + ">\n";
        out += "message : <" + getMessage() + ">\n";
        out += "color : <" + getColor() + ">\n";
        return out;
    }
    /**
     * @return the schemaversion
     */
    public int getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * @param schemaversion the schemaversion to set
     */
    public void setSchemaVersion(int schemaversion) {
        this.schemaVersion = schemaVersion;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    

}
