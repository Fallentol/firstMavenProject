/**
 * All sObjects parent
 */
package sObjects;


import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Set;

public class SObject {
    public String Id;
    public String Name;

    public SObject createNewSObject(String s) throws ClassNotFoundException {
        SObject result;

        JSONObject object = new JSONObject(s);
        Set<String> keys = object.keySet();

        JSONObject attributes = object.getJSONObject("attributes");
        String sObjectType = attributes.getString("type");

        try {
            Class<?> c = Class.forName(sObjectType);
            Constructor<?> cons = c.getConstructor(String.class);
            result = (SObject) cons.newInstance("MyAttributeValue");
        } catch (Exception e) {

        }
        for (String key : keys) {
            if (key.equals("attributes")) continue;

        }
        return null;
    }

    public Object get(String fieldName) {
        try {
            Field f = this.getClass().getField(fieldName);
            return f.get(this);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access");
        } catch (NoSuchFieldException k) {
            System.out.println("There is no such field: " + fieldName);
        }
        return null;
    }

    public void put(String fieldName, Object arg) {
        try {
            Field f = this.getClass().getField(fieldName);
            f.set(this, arg);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access");
        } catch (NoSuchFieldException k) {
            System.out.println("There is no such field: " + fieldName);
        }
    }



}


