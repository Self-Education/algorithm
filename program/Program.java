// import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
// import java.util.List;
// import java.util.Stack;



import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Program {
    public static void main(String[] args) {
        Program solution = new Program();
        String url = "https://jsonplaceholder.typicode.com/album";
        solution.method1(url);

    }

    // use java.net.HttpURLConnection
    private void method1(String s) {
        BufferedReader br;
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(s);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set up request properties
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // get the response
            int status = connection.getResponseCode();
            System.out.println(status);
            String line;
            if (status > 299) { // fail
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

            } else {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            System.out.println(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
