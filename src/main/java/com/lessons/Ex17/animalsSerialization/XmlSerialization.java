package com.lessons.Ex17.animalsSerialization;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by mtzadmin on 13.04.2017.
 */
public class XmlSerialization implements FileRWInterface {
    @Override
    public String getImplementationName() {
        return "XML serialization with standard Java methods";
    }

    @Override
    public void saveToFile(String filename, Object object) throws Exception {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new FileOutputStream(filename));
            encoder.writeObject(object);
        }
        finally {
            if (encoder!=null){
                encoder.close();
            }
        }
    }

    @Override
    public Object loadFromFile(String filename, Class objectClass) throws Exception {
        XMLDecoder decoder = null;
        Object result = null;
        try {
            decoder = new XMLDecoder(new FileInputStream(filename));
            result = decoder.readObject();
        }
        finally {
            if (decoder!=null){
                decoder.close();
            }
        }
        return result;
    }

    @Override
    public Zoo loadAll(String filename) throws Exception {
        return (Zoo)this.loadFromFile(filename, Zoo.class);
    }
}
