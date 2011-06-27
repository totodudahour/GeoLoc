package models;

import com.simplegeo.client.SimpleGeoContextClient;

public class GeoLoc {

    private static GeoLoc model;

    private static final String KEY = "X6KaFHCvJxPMdvzvp4Y6kbKbhJPeA7vq";
    private static final String SECRET = "SE7W5gmB3gLG2eNAxhUbk6M6mA7FUT99";

    private SimpleGeoContextClient client;

    private GeoLoc() {
	super();
	client = SimpleGeoContextClient.getInstance();
	client.getHttpClient().setToken(KEY, SECRET);
    }

    public static GeoLoc getInstance() {
	if (model == null) {
	    model = new GeoLoc();
	}
	return model;
    }

    public SimpleGeoContextClient getClient() {
	return client;
    }
}
