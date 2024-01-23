package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{

    private Film[] filmer;
    private int antall;

    public Filmarkiv(int kapasitet){
        this.filmer = new Film[kapasitet];
        this.antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (Film film : filmer){
            if (film.getFilmNr() == nr) return film;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall < filmer.length){
            filmer[antall] = nyFilm;
            antall++;
        }else{
            Film[] tmp = new Film[filmer.length*2];
            for (int i = 0; i < filmer.length; i++) tmp[i] = filmer[i];
            filmer = tmp;
            filmer[antall] = nyFilm;
            antall++;
        }
        
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i<filmer.length; i++) {
            if (filmer[i].getFilmNr() == filmnr){
                for (int y = i+1; y<filmer.length; y++){
                    filmer[y-1] = filmer[y];
                }
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] tmp = new Film[filmer.length];
        for (int i = 0; i < tmp.length; i++) {
            if (filmer[i].getTittel().contains(delstreng)) tmp[i] = filmer[i];
        }
        Film[] medTittel = new Film[tmp.length];
        for (int i = 0; i < medTittel.length; i++) {
            medTittel[i] = tmp[i];
        }
        return medTittel;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] tmp = new Film[filmer.length];
        for (int i = 0; i < tmp.length; i++) {
            if (filmer[i].getProd().contains(delstreng)) tmp[i] = filmer[i];
        }
        Film[] medProd = new Film[tmp.length];
        for (int i = 0; i < medProd.length; i++) {
            medProd[i] = tmp[i];
        }
        return medProd;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (Film film : filmer) {
            if (film.getSjanger().equals(sjanger)) teller++;
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }
    
}
