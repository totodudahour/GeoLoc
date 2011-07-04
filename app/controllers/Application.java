package controllers;

import java.io.IOException;
import java.util.Map;

import models.GeoLoc;

import org.apache.log4j.Logger;

import play.mvc.Controller;

import com.simplegeo.client.SimpleGeoContextClient;

public class Application extends Controller {

	private static final Logger logger = Logger.getLogger(Application.class);

	public static void index() {
		render();
	}

	/**
	 * Get the location context from the longitude and latitude values
	 * 
	 * @param lat
	 *            - the latitude
	 * @param lon
	 *            - the longitude
	 */
	public static void getLocation(double lat, double lon) {
		SimpleGeoContextClient client = GeoLoc.getInstance().getClient();
		try {
			Map<String, Object> map = client.getContext(lat, lon);
			System.out.println(map);
			renderJSON(map);
		} catch (IOException e) {
			logger.fatal(e);
		}
	}
}