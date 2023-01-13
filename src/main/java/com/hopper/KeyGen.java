package com.hopper;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * Generates a custom ID for the database
 */
public class KeyGen implements IdentifierGenerator {

    /**
     * A method which generates the key's numeral suffix.
     * @return a random 3-digit number between 100 and 999
     */
    public String randomNumbers(){
        int value = (int)Math.round((Math.random() * 1000)+1);
        return Integer.toString(value);
    }

    /**
     * A method which generates the key's string prefix.
     * @return a string consisting of 3 random alphabetical letters
     */
    public String randomLetters(){
        Random random = new Random();

        char one = (char)(random.nextInt(26) + 'a');
        char two = (char)(random.nextInt(26) + 'a');
        char three = (char)(random.nextInt(26) + 'a');

        String prefix = String.valueOf(one) + String.valueOf(two) + String.valueOf(three);

        return prefix;
    }

    /**
     *
     * @param session
     * @param object
     * @return the final primary key of the database which can now be used to access it
     * @throws HibernateException
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        String offset = randomLetters();
        String suffix = randomNumbers();

        return offset + suffix;
    }
}