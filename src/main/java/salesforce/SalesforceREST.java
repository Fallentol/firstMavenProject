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


public class SalesforceREST {

    private static final Map<String, String> PARAMETERS_MAP = new HashMap<String, String>();

    static {
        PARAMETERS_MAP.put("clientId", "3MVG9QDx8IX8nP5SHWOHzxzIlX061uHpPZTejQUoUHbochOxdKNhRYNbqm3PV4b8ntjL4_QJ2OSPwJWUNSRDK");
        PARAMETERS_MAP.put("clientSecret", "7229401104744862355");
        PARAMETERS_MAP.put("code", "00DU0000000JfPA!AQkAQI5HPX30XH24kVSE64epd6.7HxMzDb4AJqJPimCV6bAf_zv4rAaUB.Sw0LDcc36Tz7qpaDKEPoLBDRUE8Hwsu6.9IRnu");
        PARAMETERS_MAP.put("redirectUri", "https://cloudbudgetheroku.herokuapp.com/indexJSP");
        PARAMETERS_MAP.put("environment", "https://na48.salesforce.com/services/oauth2/token");
    }

    public String access_token = "NA";

    public String getAutorizationCode(HttpServletRequest request) throws IOException {

        //curl
        // https://na48.salesforce.com/services/oauth2/token
        // -d "grant_type=password"
        // -d "client_id=3MVG9QDx8IX8nP5SHWOHzxzIlX061uHpPZTejQUoUHbochOxdKNhRYNbqm3PV4b8ntjL4_QJ2OSPwJWUNSRDK"
        // -d "client_secret=7229401104744862355"
        // -d "username=alugovoi@cloudbudget.com"
        // -d "password=214926341qwerty!J5aJvH5vFYAI6xj97KZSSnPN3"
        String result = " getAutorizationCode: ";
        HttpClient httpclient = new HttpClient();
        PostMethod post = new PostMethod("https://na48.salesforce.com/services/oauth2/token");
        post.addParameter("grant_type", "password");
        post.addParameter("client_id", "3MVG9QDx8IX8nP5SHWOHzxzIlX061uHpPZTejQUoUHbochOxdKNhRYNbqm3PV4b8ntjL4_QJ2OSPwJWUNSRDK");
        post.addParameter("client_secret", "7229401104744862355");
        post.addParameter("username", "alugovoi@cloudbudget.com");
        post.addParameter("password", "214926341qwerty!J5aJvH5vFYAI6xj97KZSSnPN3");
        httpclient.executeMethod(post);
        String responseBody = post.getResponseBodyAsString();
        result += " respbody=" + responseBody;

        JSONObject json = null;
        String autorizationCode = null;
        try {
            json = new JSONObject(responseBody);
            access_token = json.getString("access_token");
            result += " access_token:" + access_token;
        } catch (Exception e) {
            e.printStackTrace();
            result += " Exception = " + e;
        }

        HttpSession session = request.getSession();
        session.setAttribute("sfident", access_token);

        return result;
    }

    public String secondRequest(HttpServletRequest request) throws IOException {

        //curl https://yourInstance.salesforce.com/services/data/v20.0/sobjects/
        // -H "Authorization: Bearer access_token"
        // -H "X-PrettyPrint:1"

        //curl https://na48.salesforce.com/services/data/v20.0/sobjects/ -H "Authorization: Bearer 00DU0000000JfPA!AQkAQI5HPX30XH24kVSE64epd6.7HxMzDb4AJqJPimCV6bAf_zv4rAaUB.Sw0LDcc36Tz7qpaDKEPoLBDRUE8Hwsu6.9IRnu" -H "X-PrettyPrint:1"
        HttpSession session = request.getSession();
        access_token = (String) session.getAttribute("sfident");

        String query = request.getParameter("query");

        String result = "";
        HttpClient httpclient = new HttpClient();
        //SELECT+name+from+Account
        //SELECT+name+from+User
        GetMethod post = new GetMethod("https://na48.salesforce.com/services/data/v20.0/query?q=" + query);//SELECT+name+from+Account
        post.addRequestHeader("Authorization", "Bearer " + access_token);
        post.addRequestHeader("X-PrettyPrint", "1");
        httpclient.executeMethod(post);
        String responseBody = post.getResponseBodyAsString();
        result += responseBody;

        return result;
    }


    public String secondFAILRequest() throws IOException {

        String result = "Result: ";

        HttpClient httpclient = new HttpClient();
        PostMethod post = new PostMethod(PARAMETERS_MAP.get("environment"));
        post.addParameter("code", PARAMETERS_MAP.get("code"));
        post.addParameter("grant_type", "authorization_code");
        post.addParameter("client_id", PARAMETERS_MAP.get("clientId"));
        post.addParameter("client_secret", PARAMETERS_MAP.get("clientSecret"));
        post.addParameter("redirect_uri", PARAMETERS_MAP.get("redirectUri"));

        httpclient.executeMethod(post);
        String responseBody = post.getResponseBodyAsString();
        result += " respbody=" + responseBody;

        String accessToken = null;
        JSONObject json = null;
        try {
            json = new JSONObject(responseBody);
            accessToken = json.getString("access_token");
            String issuedAt = json.getString("issued_at");

        } catch (Exception e) {
            e.printStackTrace();
            result += " Exception = " + e;
        }

        return result;

        /*HttpServletResponse httpResponse = new HttpServletResponse();
        Cookie session = new Cookie("ACCESS_TOKEN", accessToken);
        session.setMaxAge(-1); //cookie not persistent, destroyed on browser exit
        httpResponse.addCookie(session);*/
    }
}
