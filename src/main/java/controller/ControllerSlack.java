package controller;

import java.net.http.HttpClient;

/**
 *
 * @author raylane
 */
public class ControllerSlack {
    private static  HttpClient client = HttpClient.newHttpClient();
    private static final  String url = "webhook";
}
