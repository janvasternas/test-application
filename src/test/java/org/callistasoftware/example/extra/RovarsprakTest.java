package org.callistasoftware.example.extra;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("Not used yet")
public class RovarsprakTest {

    private Rovarsprak translator = new Rovarsprak();
    
    @Test
    public void noTextGiveNoText() {
        String encoded = translator.encode("");
        assertEquals("", encoded);
    }

    @Test
    public void aIsReturnedAsA() {
        String encoded = translator.encode("a");
        assertEquals("a", encoded);
    }

    @Test
    public void bIsReturnedAsBob() {
        String encoded = translator.encode("b");
        assertEquals("bob", encoded);
    }

    @Test
    public void encodeLongerString() {
        String encoded = translator.encode("nu går inget fel");
        assertEquals("nonu gogåror inongogetot fofelol", encoded);
    }

}
