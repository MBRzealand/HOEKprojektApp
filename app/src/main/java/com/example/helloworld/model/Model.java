package com.example.helloworld.model;

import java.io.Serializable;

public class Model implements Serializable {

    private int omsaetning;
    private int vareforbrug;
    private int bruttofortjeneste;
    private int markedsfoeringsomkostninger;
    private int markedsfoeringsbidrag;
    private int oevrigeKapacitetsomkostninger;
    private int indtjeningsbidrag;
    private int afskrivninger;
    private int resultatFoerRenter;
    private int renteomkostninger;
    private int resultat;

    public int getOmsaetning() {
        return omsaetning;
    }

    public void setOmsaetning(int omsaetning) {
        this.omsaetning = omsaetning;
    }

    public int getVareforbrug() {
        return vareforbrug;
    }

    public void setVareforbrug(int vareforbrug) {
        this.vareforbrug = vareforbrug;
    }

    public int getBruttofortjeneste() {
        return bruttofortjeneste;
    }

    public void setBruttofortjeneste(int bruttofortjeneste) {
        this.bruttofortjeneste = bruttofortjeneste;
    }

    public int getMarkedsfoeringsomkostninger() {
        return markedsfoeringsomkostninger;
    }

    public void setMarkedsfoeringsomkostninger(int markedsfoeringsomkostninger) {
        this.markedsfoeringsomkostninger = markedsfoeringsomkostninger;
    }

    public int getMarkedsfoeringsbidrag() {
        return markedsfoeringsbidrag;
    }

    public void setMarkedsfoeringsbidrag(int markedsfoeringsbidrag) {
        this.markedsfoeringsbidrag = markedsfoeringsbidrag;
    }

    public int getOevrigeKapacitetsomkostninger() {
        return oevrigeKapacitetsomkostninger;
    }

    public void setOevrigeKapacitetsomkostninger(int oevrigeKapacitetsomkostninger) {
        this.oevrigeKapacitetsomkostninger = oevrigeKapacitetsomkostninger;
    }

    public int getIndtjeningsbidrag() {
        return indtjeningsbidrag;
    }

    public void setIndtjeningsbidrag(int indtjeningsbidrag) {
        this.indtjeningsbidrag = indtjeningsbidrag;
    }

    public int getAfskrivninger() {
        return afskrivninger;
    }

    public void setAfskrivninger(int afskrivninger) {
        this.afskrivninger = afskrivninger;
    }

    public int getResultatFoerRenter() {
        return resultatFoerRenter;
    }

    public void setResultatFoerRenter(int resultatFoerRenter) {
        this.resultatFoerRenter = resultatFoerRenter;
    }

    public int getRenteomkostninger() {
        return renteomkostninger;
    }

    public void setRenteomkostninger(int renteomkostninger) {
        this.renteomkostninger = renteomkostninger;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }



}
