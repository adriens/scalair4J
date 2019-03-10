/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.scalair4j;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author salad74
 */
public class StationCrawler {

    public static final String URL_STATIONS = "http://www.scalair.nc/index.php#";

    /*private static int POSITION_HTML_GENERAL = 1;
    private static int POSITION_HTML_LOGICOOP = 2;
    private static int POSITION_HTML_MONTRAVEL = 3;
    private static int POSITION_HTML_FAUBOURG = 4;
    private static int POSITION_HTML_VATA = 5;
     */
    private static String XPATH_STATUS_GENERAL = "/html/body/div[1]/div[3]/div/main/div[2]/div/div[1]/div[1]/div/div[3]/a[1]/span";
    private static String XPATH_STATUS_LOGICOOP = "/html/body/div[1]/div[3]/div/main/div[2]/div/div[1]/div[1]/div/div[3]/a[2]/strong/span";
    private static String XPATH_STATUS_MONTRAVEL = "/html/body/div[1]/div[3]/div/main/div[2]/div/div[1]/div[1]/div/div[3]/a[3]/strong/span";
    private static String XPATH_STATUS_FAUBOURG = "/html/body/div[1]/div[3]/div/main/div[2]/div/div[1]/div[1]/div/div[3]/a[4]/strong/span";
    private static String XPATH_STATUS_ANSE_VATA = "/html/body/div[1]/div[3]/div/main/div[2]/div/div[1]/div[1]/div/div[3]/a[5]/strong/span";

    final static Logger logger = LoggerFactory.getLogger(StationCrawler.class);

    private HashMap<String, Station> stationsStatuses;

    public StationCrawler() throws IOException {
        try {
            fillStations();
        } catch (IOException ex) {
            logger.error("Unable to fetch datas : " + ex.getMessage());
            throw ex;
        }
    }

    private static WebClient buildWebClient() {
        // Disable verbose logs
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
        WebClient webClient = new WebClient(BrowserVersion.CHROME.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setDownloadImages(false);
        return webClient;
    }

    /**
     * @return the stationsStatuses
     */
    public HashMap<String, Station> getStationsStatuses() {
        return stationsStatuses;
    }

    /**
     * @param stationsStatuses the stationsStatuses to set
     */
    public void setStationsStatuses(HashMap<String, Station> stationsStatuses) {
        this.stationsStatuses = stationsStatuses;
    }

    public void fillStations() throws IOException {
        WebClient webClient = buildWebClient();
        HtmlPage htmlPage = webClient.getPage(URL_STATIONS);
        this.stationsStatuses = new HashMap<String, Station>();

        // Variables
        String stationStatus;
        int indiceIGA;
        StationLieu lieu;
        IGA iga;
        Station aStation;

        ///////////////////////////////////////////////////////////////
        // Logicoop
        logger.info("Getting Station <" + StationLieu.LOGICOOP + "> status...");
        stationStatus = ((HtmlSpan) (htmlPage.getFirstByXPath(XPATH_STATUS_LOGICOOP))).getTextContent();
        logger.info("Found status : <" + StringUtils.trim(stationStatus) + ">");
        indiceIGA = Integer.parseInt(StringUtils.trim(stationStatus));
        lieu = StationLieu.LOGICOOP;
        // build IGA
        iga = new IGA(indiceIGA);
        aStation = new Station();
        aStation.setIga(iga);
        aStation.setLieu(lieu);
        aStation.setNom(Station.NOM_STATION_LOGICOOP);
        aStation.setTypologie(StationTypologie.INDUSTRIELLE);
        logger.info(aStation.toString());
        logger.info("Got <" + aStation.getNom() + ">.");
        this.stationsStatuses.put(Station.NOM_STATION_LOGICOOP, aStation);
        logger.info("-------------------------------------------------------");

        ///////////////////////////////////////////////////////////////
        // Montravel
        logger.info("Getting Station <" + StationLieu.MONTRAVEL + "> status...");
        stationStatus = ((HtmlSpan) (htmlPage.getFirstByXPath(XPATH_STATUS_MONTRAVEL))).getTextContent();
        logger.info("Found status : <" + StringUtils.trim(stationStatus) + ">");
        indiceIGA = Integer.parseInt(StringUtils.trim(stationStatus));
        lieu = StationLieu.MONTRAVEL;
        // build IGA
        iga = new IGA(indiceIGA);
        aStation = new Station();
        aStation.setIga(iga);
        aStation.setLieu(lieu);
        aStation.setNom(Station.NOM_STATION_MONTRAVEL);
        aStation.setTypologie(StationTypologie.URBAINE_INDUSTRIELLE);
        logger.info(aStation.toString());
        logger.info("Got <" + aStation.getNom() + ">.");
        this.stationsStatuses.put(Station.NOM_STATION_MONTRAVEL, aStation);
        logger.info("-------------------------------------------------------");

        ///////////////////////////////////////////////////////////////
        // Faubourg
        logger.info("Getting Station Faubourg Blanchot status...");
        stationStatus = ((HtmlSpan) (htmlPage.getFirstByXPath(XPATH_STATUS_FAUBOURG))).getTextContent();
        logger.info("Found status : <" + StringUtils.trim(stationStatus) + ">");
        indiceIGA = Integer.parseInt(StringUtils.trim(stationStatus));
        lieu = StationLieu.FAUBOURG_BLANCHOT;
        // build IGA
        iga = new IGA(indiceIGA);
        aStation = new Station();
        aStation.setIga(iga);
        aStation.setLieu(lieu);
        aStation.setNom(Station.NOM_STATION_FAUBOURG_BLANCHOT);
        aStation.setTypologie(StationTypologie.URBAINE);
        logger.info(aStation.toString());
        logger.info("Got <" + aStation.getNom() + ">.");
        this.stationsStatuses.put(Station.NOM_STATION_FAUBOURG_BLANCHOT, aStation);

        ///////////////////////////////////////////////////////////////
        // Anse Vata
        logger.info("Getting Station <" + Station.NOM_STATION_ANSE_VATA + "> status...");
        stationStatus = ((HtmlSpan) (htmlPage.getFirstByXPath(XPATH_STATUS_ANSE_VATA))).getTextContent();
        logger.info("Found status : <" + StringUtils.trim(stationStatus) + ">");
        indiceIGA = Integer.parseInt(StringUtils.trim(stationStatus));
        lieu = StationLieu.ANSE_VATA;
        // build IGA
        iga = new IGA(indiceIGA);
        aStation = new Station();
        aStation.setIga(iga);
        aStation.setLieu(lieu);
        aStation.setNom(Station.NOM_STATION_ANSE_VATA);
        aStation.setTypologie(StationTypologie.URBAINE);
        logger.info(aStation.toString());
        logger.info("Got <" + aStation.getNom() + ">.");
        this.stationsStatuses.put(Station.NOM_STATION_ANSE_VATA, aStation);

        ///////////////////////////////////////////////////////////////
        // Général
        logger.info("Getting Station <" + Station.NOM_STATION_GENERAL + "> status...");
        stationStatus = ((HtmlSpan) (htmlPage.getFirstByXPath(XPATH_STATUS_GENERAL))).getTextContent();
        logger.info("Found status : <" + StringUtils.trim(stationStatus) + ">");
        indiceIGA = Integer.parseInt(StringUtils.trim(stationStatus));
        lieu = StationLieu.GENERAL;
        // build IGA
        iga = new IGA(indiceIGA);
        aStation = new Station();
        aStation.setIga(iga);
        aStation.setLieu(lieu);
        aStation.setNom(Station.NOM_STATION_GENERAL);
        aStation.setTypologie(StationTypologie.URBAINE);
        logger.info(aStation.toString());
        logger.info("Got <" + aStation.getNom() + ">.");
        this.stationsStatuses.put(Station.NOM_STATION_GENERAL, aStation);
    }
}
