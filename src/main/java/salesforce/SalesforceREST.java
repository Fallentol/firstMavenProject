package salesforce;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SalesforceREST {

    private static final Map<String, String> PARAMETERS_MAP = new HashMap<String, String>();

    static {
        PARAMETERS_MAP.put("clientId", "3MVG9QDx8IX8nP5SHWOHzxzIlX061uHpPZTejQUoUHbochOxdKNhRYNbqm3PV4b8ntjL4_QJ2OSPwJWUNSRDK");
        PARAMETERS_MAP.put("clientSecret", "7229401104744862355");
        PARAMETERS_MAP.put("redirectUri", "https://localhost:8080");
        PARAMETERS_MAP.put("environment", "https://na48.salesforce.com/services/oauth2/token");
    }


    public void testRequest() throws IOException {

        HttpClient httpclient = new HttpClient();
        PostMethod post = new PostMethod(PARAMETERS_MAP.get("environment"));
        post.addParameter("code", PARAMETERS_MAP.get("code"));
        post.addParameter("grant_type", "authorization_code");

        post.addParameter("client_id", PARAMETERS_MAP.get("clientId"));
        post.addParameter("client_secret", PARAMETERS_MAP.get("clientSecret"));
        post.addParameter("redirect_uri", PARAMETERS_MAP.get("redirectUri"));

        //exception handling removed for brevity...
        //this is the post from step 2

        httpclient.executeMethod(post);
        String responseBody = post.getResponseBodyAsString();

        String accessToken = null;
        JSONObject json = null;
        try {
            json = new JSONObject(responseBody);
            accessToken = json.getString("access_token");
            String issuedAt = json.getString("issued_at");
            /** Use this to validate session
             * instead of expiring on browser close.
             */

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*HttpServletResponse httpResponse = new HttpServletResponse();
        Cookie session = new Cookie("ACCESS_TOKEN", accessToken);
        session.setMaxAge(-1); //cookie not persistent, destroyed on browser exit
        httpResponse.addCookie(session);*/
    }
}
