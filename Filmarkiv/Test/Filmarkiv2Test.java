package no.hvl.data102.filmarkiv.test;

import org.junit.Test;
import static org.junit.Assert.*;

import no.hvl.data102.filmarkiv.Filmarkiv2.Filmarkiv2;

class Filmarkiv2Test {
    private Filmarkiv2<Film> filmarkiv;

    @Test
    public void testInit(){
        this.filmarkiv = new Filmarkiv2<>();
        assertEquals(0, filmarkiv.antall());
        assertEquals(1, filmarkiv.antall());
    }
}
