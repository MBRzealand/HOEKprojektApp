package com.example.helloworld.model;

import java.io.Serializable;

public class Model implements Serializable {

    private long omsaetning;
    private long vareforbrug;
    private long bruttofortjeneste;
    private long markedsfoeringsomkostninger;
    private long markedsfoeringsbidrag;
    private long oevrigeKapacitetsomkostninger;
    private long indtjeningsbidrag;
    private long afskrivninger;
    private long resultatFoerRenter;
    private long renteomkostninger;
    private long resultat;

    public Model() {

    }

    public long getOmsaetning() {
        return omsaetning;
    }

    public void setOmsaetning(long omsaetning) {
        this.omsaetning = omsaetning;
    }

    public long getVareforbrug() {
        return vareforbrug;
    }

    public void setVareforbrug(long vareforbrug) {
        this.vareforbrug = vareforbrug;
    }

    public long getBruttofortjeneste() {
        return bruttofortjeneste;
    }

    public void setBruttofortjeneste(long bruttofortjeneste) {
        this.bruttofortjeneste = bruttofortjeneste;
    }

    public long getMarkedsfoeringsomkostninger() {
        return markedsfoeringsomkostninger;
    }

    public void setMarkedsfoeringsomkostninger(long markedsfoeringsomkostninger) {
        this.markedsfoeringsomkostninger = markedsfoeringsomkostninger;
    }

    public long getMarkedsfoeringsbidrag() {
        return markedsfoeringsbidrag;
    }

    public void setMarkedsfoeringsbidrag(long markedsfoeringsbidrag) {
        this.markedsfoeringsbidrag = markedsfoeringsbidrag;
    }

    public long getOevrigeKapacitetsomkostninger() {
        return oevrigeKapacitetsomkostninger;
    }

    public void setOevrigeKapacitetsomkostninger(long oevrigeKapacitetsomkostninger) {
        this.oevrigeKapacitetsomkostninger = oevrigeKapacitetsomkostninger;
    }

    public long getIndtjeningsbidrag() {
        return indtjeningsbidrag;
    }

    public void setIndtjeningsbidrag(long indtjeningsbidrag) {
        this.indtjeningsbidrag = indtjeningsbidrag;
    }

    public long getAfskrivninger() {
        return afskrivninger;
    }

    public void setAfskrivninger(long afskrivninger) {
        this.afskrivninger = afskrivninger;
    }

    public long getResultatFoerRenter() {
        return resultatFoerRenter;
    }

    public void setResultatFoerRenter(long resultatFoerRenter) {
        this.resultatFoerRenter = resultatFoerRenter;
    }

    public long getRenteomkostninger() {
        return renteomkostninger;
    }

    public void setRenteomkostninger(long renteomkostninger) {
        this.renteomkostninger = renteomkostninger;
    }

    public long getResultat() {
        return resultat;
    }

    public void setResultat(long resultat) {
        this.resultat = resultat;
    }
}
