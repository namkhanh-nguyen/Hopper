package com.hopper;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class KeyGen implements IdentifierGenerator {

    public String randomNumbers(){
        int value = (int)Math.round((Math.random() * 1000)+1);
        String stringValue = Integer.toString(value);
        return stringValue;
    }
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        Content content = new Content();
        String offset = content.getKeyOffset();
        String suffix = randomNumbers();

        return offset + suffix;
    }
}