package com.hopper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomSuffixTest {
    @Test
    void randomNumTest(){
        KeyGen keygen = new KeyGen();
        String randomNum = keygen.randomNumbers();
        int x = Integer.parseInt(randomNum);

        assertTrue(x<1000);
    }
}