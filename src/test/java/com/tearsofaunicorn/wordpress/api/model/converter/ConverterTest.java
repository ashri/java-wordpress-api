package com.tearsofaunicorn.wordpress.api.model.converter;

import junit.framework.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class ConverterTest<T> {

    @SuppressWarnings("unchecked")
    protected T loadObject(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Object o = in.readObject();
        Assert.assertNotNull(o);
        return (T) o;
    }
}
