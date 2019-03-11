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
public class Main {
    public static void main(String[] args) {
        try {
            StationCrawler crawler = new StationCrawler();
            Station aStation = crawler.getStationsStatuses().get(Station.NOM_STATION_ANSE_VATA);
            System.out.println("#########################################");
            System.out.println(aStation);
            System.out.println("#########################################");
            
            System.out.println(aStation.getShieldMessage());
            
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
