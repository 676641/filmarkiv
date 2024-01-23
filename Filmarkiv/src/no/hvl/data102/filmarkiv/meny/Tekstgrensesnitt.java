package no.hvl.data102.filmarkiv.meny;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {


    public Tekstgrensesnitt(){
    }

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(Scanner sc){
    System.out.println("fyll ut følgende informasjon for å legge til en film:");
    System.out.println("Hva er tittelen? ");
    String tittel = sc.nextLine();
    System.out.println("Hvem er produsenten? ");
    String prod = sc.nextLine();
    System.out.println("Når ble filmen først utgitt? ");
    int dato = Integer.parseInt(sc.nextLine());
    System.out.println("er filmen:\nAction\nDrama\nHistory\nScifi");
    System.out.println(("(svar nøyaktig)"));
    String sj = sc.nextLine();
    Sjanger sjanger = null;
    switch (sj.toUpperCase()) {
        case "ACTION":
            sjanger = Sjanger.ACTION;
            break;
        
        case "DRAMA":
        sjanger = Sjanger.DRAMA;
            break;
    
        case "HISTORY":
        sjanger = Sjanger.HISTORY;
            break;

        case "SCIFI":
        sjanger = Sjanger.SCIFI;
            break;
    
        default:
        sjanger = Sjanger.UKJENT;
            break;
    }
    System.out.println("Hvilket filmselskap publiserte filmen?");
    String filmselskap = sc.nextLine();
    return new Film(prod, tittel, dato, sjanger, filmselskap);    
    }
    


    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        String[] data = {"Tittel: ", "Filmnummer: ", "Produsent: ", "Dato: ", "Sjanger: ", "Filmselskap: "};
        String[] info = film.info();
        for (int i = 0; i < info.length; i++) {
            System.out.println(data[i] + info[i]);
        }
        System.out.println();
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] medTittel = arkiv.soekTittel(delstreng);
        for (Film film : medTittel) {
            skrivUtFilm(film);
        }
    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] avProdusent = arkiv.soekProdusent(delstreng);
        for (Film film : avProdusent) {
            skrivUtFilm(film);
        }
    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("totalt antall filmer: "+arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println("Antall"+sjanger.toString().toLowerCase()+" filmer:"+arkiv.antall(sjanger));
        }
    }
    // osv ... andre metoder
}
    