package no.hvl.data102.filmarkiv.impl;


public class Film {
    private static int filmTeller = 1000;
    private Integer filmNr;
    private String produsent;
    private String tittel;
    private int lanseringsDato;
    private Sjanger sjanger;
    private String filmselskap;


    public Film(){
        this.filmNr = filmTeller++;
    }

    public Film(String prod, String tittel, int dato, Sjanger sjanger, String filmselskap){
        this.filmNr = filmTeller++;
        this.produsent = prod;
        this.tittel = tittel;
        this.lanseringsDato = dato;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }


    @Override
    public boolean equals(Object o){
        // if (o instanceof Film){
        //     Film film = (Film) o;
        //     if (hashCode() ==  film.hashCode()) return true;
        // }
        // return false;
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode(){
        return filmNr.hashCode();
    }

    public String[] info(){
        String[] info = new String[6];
        info[0] = tittel;
        info[1] = filmNr.toString();
        info[2] = produsent;
        info[3] = String.valueOf(lanseringsDato);
        info[4] = sjanger.toString();
        info[5] = filmselskap;
        return info;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getProd(){
        return produsent;
    }

    public String getTittel(){
        return tittel;
    }

    public String getFilmselskap(){
        return filmselskap;
    }

    public int getFilmNr(){
        return filmNr;
    }

    public int getDato(){
        return lanseringsDato;
    }

    public Sjanger getSjanger(){
    return sjanger;
    }

    public void setProd(String prod){
        this.produsent = prod;
    }

    public void setTittel(String tittel){
        this.tittel = tittel;
    }

    public void setSelskap(String selskap){
        this.filmselskap = selskap;
    }

    public void setDato(int dato){
        this.lanseringsDato = dato;
    }

    public void setSjanger(Sjanger sjanger){
        this.sjanger = sjanger;
    }

}
