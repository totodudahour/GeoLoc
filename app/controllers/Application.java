package controllers;

import java.io.IOException;
import java.util.Map;

import play.mvc.Controller;

import com.simplegeo.client.SimpleGeoContextClient;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void getLocation(double lat, double lon) {
	SimpleGeoContextClient client = SimpleGeoContextClient.getInstance();
	client.getHttpClient().setToken("X6KaFHCvJxPMdvzvp4Y6kbKbhJPeA7vq", "SE7W5gmB3gLG2eNAxhUbk6M6mA7FUT99");
	try {
	    Map<String, Object> map = client.getContext(lat, lon);
	    renderJSON(map);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}