package com.hopper;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class KeyGen implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        Content content = new Content();
        String offset = content.getKeyOffset();
        String suffix = content.randomNumbers();

        return offset + suffix;
    }
}