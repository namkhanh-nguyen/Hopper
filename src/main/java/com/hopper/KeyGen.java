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
     * @return a random 4-digit number between 0 and 9999
     */
    public String randomNumbers(){
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    /**
     * A method which generates the key's string prefix.
     * @return a string consisting of 4 random alphabetical letters
     */
    public String randomLetters(){
        Random random = new Random();

        char one = (char)(random.nextInt(26) + 'a');
        char two = (char)(random.nextInt(26) + 'a');
        char three = (char)(random.nextInt(26) + 'a');
        char four = (char)(random.nextInt(26) + 'a');

        String prefix = String.valueOf(one) + String.valueOf(two) + String.valueOf(three) + String.valueOf(four);

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