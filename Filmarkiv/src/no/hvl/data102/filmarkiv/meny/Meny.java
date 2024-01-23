package no.hvl.data102.filmarkiv.meny;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Velkommen til et system for å arkivere filmer!");
        System.out.println("skriv q når du er ferdig med å registrere en film for å avslutte programmet ");
        System.out.println("trykk enter for å starte");
        String input = sc.nextLine();
        while(!input.equals("q")){
            Film film = tekstgr.lesFilm(sc);
            filmarkiv.leggTilFilm(film);
            input = sc.nextLine();
            tekstgr.skrivUtFilm(film);
        }
        sc.close();
    }   
    }
