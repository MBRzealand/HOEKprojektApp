package com.example.helloworld.model;

public class AfskrivningElement {

    private String kostpris;
    private String scrapvaerdi;
    private String brugstid;

    private String afskrivningsprocent;
    private String bogfoertPrimovaerdi;

    private String afskrivning;

    public String getAfskrivning() {
        return afskrivning;
    }

    public void setAfskrivning(String afskrivning) {
        this.afskrivning = afskrivning;
    }

    public String getKostpris() {
        return kostpris;
    }

    public void setKostpris(String kostpris) {
        this.kostpris = kostpris;
    }

    public String getScrapvaerdi() {
        return scrapvaerdi;
    }

    public void setScrapvaerdi(String scrapvaerdi) {
        this.scrapvaerdi = scrapvaerdi;
    }

    public String getBrugstid() {
        return brugstid;
    }

    public void setBrugstid(String brugstid) {
        this.brugstid = brugstid;
    }

    public String getAfskrivningsprocent() {
        return afskrivningsprocent;
    }

    public void setAfskrivningsprocent(String afskrivningsprocent) {
        this.afskrivningsprocent = afskrivningsprocent;
    }

    public String getBogfoertPrimovaerdi() {
        return bogfoertPrimovaerdi;
    }

    public void setBogfoertPrimovaerdi(String bogfoertPrimovaerdi) {
        this.bogfoertPrimovaerdi = bogfoertPrimovaerdi;
    }


}
