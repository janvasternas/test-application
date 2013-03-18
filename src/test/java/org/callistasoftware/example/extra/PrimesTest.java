package org.callistasoftware.example.extra;

import static org.junit.Assert.*;

import org.callistasoftware.example.extra.Primes;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Not used yet")
public class PrimesTest {

    private Primes primes = new Primes();
    
    @Test
    public void firstPrimeIs2() {
        int actual = primes.getPrime(1);
        assertEquals(2, actual);
    }

    public void secondPrimeIs3() {
        int actual = primes.getPrime(2);
        assertEquals(3, actual);
    }

    public void sumOfFirst100Primes() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += primes.getPrime(i);
        }
        
        assertEquals(24333, sum);
    }
}
