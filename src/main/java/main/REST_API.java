package main;

import org.apache.commons.httpclient.NameValuePair;

import java.util.ArrayList;

public class REST_API  {
    public static void main(String[] args) {
        String postURL = "http://www.example.com/page.php";

        HttpPost post = new HttpPost(postURL);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("id", "10"));

        UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, "UTF-8");
        post.setEntity(ent);

        HttpClient client = new DefaultHttpClient();
        HttpResponse responsePOST = client.execute(post);
    }
}
