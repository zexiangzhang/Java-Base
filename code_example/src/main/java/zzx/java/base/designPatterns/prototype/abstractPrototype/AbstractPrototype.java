package zzx.java.base.designPatterns.prototype.abstractPrototype;

import java.io.*;

/**
 * 抽象原型
 */
public class AbstractPrototype implements Cloneable, Serializable {

    private String fieldKey;

    private String fieldValue;

    public String getFieldKey(){
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getFieldValue(){
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public Object clone() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bo);
            objectOutputStream.writeObject(this);
            byte[] bytes = bo.toByteArray();
            ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(bs);
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
