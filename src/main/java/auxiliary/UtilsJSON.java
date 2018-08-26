package auxiliary;

import org.json.JSONArray;
import org.json.JSONObject;

public class UtilsJSON {

    private static String simpleJSON = "{\n" +
            "\"name\":\"John\"," +
            "\"age\":30," +
            "\"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ]" +
            "}";

    public static void getTest() {
        JSONObject jsonObject = new JSONObject(simpleJSON);
        String r = jsonObject.getString("name");
        JSONArray cars = jsonObject.getJSONArray("cars");

        System.out.println("r=" + r);
        for(int i = 0; i<cars.length(); i++) {
            System.out.println("car=" + cars.getString(i));
        }
    }
}
