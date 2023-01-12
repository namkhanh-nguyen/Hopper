package com.hopper;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class KeyGen implements IdentifierGenerator {

    public String randomNumbers(){
        int value = (int)Math.round((Math.random() * 1000)+1);
        String stringValue = Integer.toString(value);
        return stringValue;
    }

    public String randomLetters(){
        Random random = new Random();

        char one = (char)(random.nextInt(26) + 'a');
        char two = (char)(random.nextInt(26) + 'a');
        char three = (char)(random.nextInt(26) + 'a');

        String prefix = String.valueOf(one) + String.valueOf(two) + String.valueOf(three);

        return prefix;
    }
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        String offset = randomLetters();
        String suffix = randomNumbers();

        return offset + suffix;
    }
}