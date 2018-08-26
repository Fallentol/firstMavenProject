/**
 * Singleton
 */
package dataBase;

import sObjects.SObject;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static final DataBase INSTANCE = new DataBase();

    /**
     * key = sObject Id
     * value = sObject
     */
    public Map<String, SObject> mainSObjectMap = new HashMap<String, SObject>();
}
