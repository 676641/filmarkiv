package no.hvl.data102.filmarkiv.Filmarkiv2;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv2 implements FilmarkivADT{

    LinearNode forste;
    int antall;

    public Filmarkiv2(){
        this.antall = 0;
    }

    public void setForste(LinearNode node){
        this.forste = node;
        antall++;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode tmp = forste;
        Film funnet = null;
        while (tmp.harNeste()) {
            if (tmp.data().getFilmNr()==nr) {
                funnet = tmp.data();
            }
            tmp = tmp.neste();
        }
        return funnet;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode ny = new LinearNode(nyFilm);
        ny.setNeste(forste);
        forste = ny;
        antall++;
    }


    //må teste om metoden klarer å slette alle instanser av en film hvis den ligger i listen flere ganger
    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode tmp = forste;
        boolean funnet = false;
        if (forste.data().getFilmNr()==filmnr){
            forste = forste.neste();
            antall--;
            funnet = true;
        }
        while (tmp.harNeste()) {
            if (tmp.neste().data().getFilmNr()==filmnr) {
                tmp.setNeste(tmp.neste().neste());
                antall--;
                funnet = true;
            }
            tmp = tmp.neste();
        }
        return funnet;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode tmp = forste;
        Film[] medTittel = new Film[antall];
        int teller = 0;
        while (tmp.harNeste()) {
            if (tmp.data().getTittel().contains(delstreng)) {
                medTittel[teller] = tmp.data();
                teller++;
            }
            tmp = tmp.neste();
        }
        return medTittel;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode tmp = forste;
        Film[] medProd = new Film[antall];
        int teller = 0;
        while (tmp.harNeste()) {
            if (tmp.data().getProd().contains(delstreng)) {
                medProd[teller] = tmp.data();
                teller++;
            }
            tmp = tmp.neste();
        }
        return medProd;
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode tmp = forste;
        int teller = 0;
        while (tmp.harNeste()) {
            if (tmp.data().getSjanger().equals(sjanger)) {
                teller++;
            }
            tmp = tmp.neste();
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }




    private class LinearNode {
        private Film data;
        private LinearNode neste;

        public LinearNode(Film data){
            this.data = data;
        }

        public void setNeste(LinearNode neste){
            this.neste = neste;
        }
        
        public LinearNode neste(){
            return neste;
        }

        public Film data(){
            return data;
        }

        public boolean harNeste(){
            return neste != null;
        }
    }
    
}
