/**
 * All sObjects parent
 */
package sObjects;


import dataBase.DataBase;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Set;

public class SObject {
    public String Id;
    public String Name;

    /**
     * @param s JSON string
     * @return new sObject
     */
    public static SObject createNewSObjectFromJSONString(String s) {
        SObject result;

        JSONObject object = new JSONObject(s);
        Set<String> keys = object.keySet();

        JSONObject attributes = object.getJSONObject("attributes");
        String sObjectType = attributes.getString("type");

        try {
            Class<?> c = Class.forName("sObjects." + sObjectType);
            Constructor<?> cons = c.getConstructor(String.class);
            result = (SObject) cons.newInstance(sObjectType);
        } catch (Exception e) {
            System.out.println("I can't create instance " + sObjectType + " because " + e.getMessage());
            return null;
        }
        for (String key : keys) {
            if (key.equals("attributes")) continue;
            if (key.contains("__r")) {
                SObject inBuiltSobject = createNewSObjectFromJSONString(object.getJSONObject(key).toString());
                result.put(key, inBuiltSobject);
                continue;
            }
            result.put(key, object.get(key));
        }
        DataBase.INSTANCE.mainSObjectMap.put(result.Id, result);
        return result;
    }

    /**
     * @param fieldName sObject field name
     * @return
     */
    public Object get(String fieldName) {
        try {
            Field f = this.getClass().getField(fieldName);
            return f.get(this);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access (GET)");
        } catch (NoSuchFieldException k) {
            System.out.println("GET. There is no such field: " + fieldName);
        }
        return null;
    }

    /**
     * @param fieldName sObject field name
     * @param arg       any object
     */
    public void put(String fieldName, Object arg) {
        try {
            Field f = this.getClass().getField(fieldName);
            f.set(this, arg);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access (PUT)");
        } catch (NoSuchFieldException k) {
            System.out.println("PUT. There is no such field: " + fieldName);
        }
    }


    @Override
    public String toString() {
        return "SObject{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}


