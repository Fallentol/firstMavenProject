/**
 * curl
 * https://na48.salesforce.com/services/oauth2/token
 * -d "grant_type=password"
 * -d "client_id=3MVG9QDx8IX8nP5SHWOHzxzIlX061uHpPZTejQUoUHbochOxdKNhRYNbqm3PV4b8ntjL4_QJ2OSPwJWUNSRDK"
 * -d "client_secret=7229401104744862355"
 * -d "username=alugovoi@cloudbudget.com"
 * -d "password=214926341qwerty!J5aJvH5vFYAI6xj97KZSSnPN3"
 * <p>
 * <p>
 * curl https://yourInstance.salesforce.com/services/data/v20.0/sobjects/
 * -H "Authorization: Bearer access_token"
 * -H "X-PrettyPrint:1"
 * curl https://na48.salesforce.com/services/data/v20.0/sobjects/ -H "Authorization: Bearer 00DU0000000JfPA!AQkAQI5HPX30XH24kVSE64epd6.7HxMzDb4AJqJPimCV6bAf_zv4rAaUB.Sw0LDcc36Tz7qpaDKEPoLBDRUE8Hwsu6.9IRnu" -H "X-PrettyPrint:1"
 */
package salesforce;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SalesForceREST {

    private static final Map<String, String> PARAMETERS_MAP = new HashMap<String, String>();

    static {
        PARAMETERS_MAP.put("client_id", "3MVG9QDx8IX8nP5SHWOHzxzIlX061uHpPZTejQUoUHbochOxdKNhRYNbqm3PV4b8ntjL4_QJ2OSPwJWUNSRDK");
        PARAMETERS_MAP.put("client_secret", "7229401104744862355");
        PARAMETERS_MAP.put("code", "00DU0000000JfPA!AQkAQI5HPX30XH24kVSE64epd6.7HxMzDb4AJqJPimCV6bAf_zv4rAaUB.Sw0LDcc36Tz7qpaDKEPoLBDRUE8Hwsu6.9IRnu");
        PARAMETERS_MAP.put("redirectUri", "https://cloudbudgetheroku.herokuapp.com/indexJSP");
        PARAMETERS_MAP.put("environment", "https://na48.salesforce.com/services/oauth2/token");
        PARAMETERS_MAP.put("username", "alugovoi@cloudbudget.com");
        PARAMETERS_MAP.put("grant_type", "password");
        PARAMETERS_MAP.put("password", "214926341qwerty!J5aJvH5vFYAI6xj97KZSSnPN3");
        PARAMETERS_MAP.put("uri", "https://na48.salesforce.com/services/oauth2/token");
    }


    public String getAuthorizationCode(HttpServletRequest request) {
        String access_token;
        HttpClient httpclient = new HttpClient();

        PostMethod post = new PostMethod(PARAMETERS_MAP.get("uri"));
        post.addParameter("grant_type", PARAMETERS_MAP.get("grant_type"));
        post.addParameter("client_id", PARAMETERS_MAP.get("client_id"));
        post.addParameter("client_secret", PARAMETERS_MAP.get("client_secret"));
        post.addParameter("username", PARAMETERS_MAP.get("username"));
        post.addParameter("password", PARAMETERS_MAP.get("password"));

        String responseBody;
        try {
            httpclient.executeMethod(post);
            responseBody = post.getResponseBodyAsString();
        } catch (IOException ioe) {
            System.out.println("IOException=" + ioe);
            return "ERROR";
        }

        try {
            JSONObject json = new JSONObject(responseBody);
            access_token = json.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
            access_token = " Exception = " + e;
        }

        // Save access_token in the session
        HttpSession session = request.getSession();
        session.setAttribute("access_token", access_token);
        System.out.println("access_token=" + access_token);

        return access_token;
    }

    public String getQueryRequest(HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");

        String query = request.getParameter("query");

        HttpClient httpclient = new HttpClient();
        GetMethod post = new GetMethod("https://na48.salesforce.com/services/data/v20.0/query?q=" + query);
        post.addRequestHeader("Authorization", "Bearer " + access_token);
        post.addRequestHeader("X-PrettyPrint", "1");
        httpclient.executeMethod(post);

        return post.getResponseBodyAsString();
    }

    public String getAnonymousRequest(HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");

        String body = request.getParameter("body");

        HttpClient httpclient = new HttpClient();
        GetMethod post = new GetMethod("http://na48.salesforce.com/services/data/v43.0/tooling/sobjects/");
        post.addRequestHeader("Authorization", "Bearer " + access_token);
        post.addRequestHeader("Content-Type", "application/json"); // ('Content-Type', 'application/json');
        try {
            httpclient.executeMethod(post);
        } catch (Exception e) {
            System.out.println("Exception:" + e);
            return e.getMessage();
        }

        return post.getResponseBodyAsString();
    }
}
