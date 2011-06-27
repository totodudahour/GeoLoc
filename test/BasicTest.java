import java.io.IOException;

import models.GeoLoc;

import org.apache.log4j.Logger;
import org.junit.Test;

import play.test.UnitTest;

import com.simplegeo.client.SimpleGeoContextClient;

import controllers.Application;

public class BasicTest extends UnitTest {

    private static final Logger logger = Logger.getLogger(Application.class);

    @Test
    public void aVeryImportantThingToTest() {
	assertEquals(2, 1 + 1);
    }

    @Test
    public void testTheWS() {
	SimpleGeoContextClient client = GeoLoc.getInstance().getClient();
	try {
	    assertNotNull(client.getContextByIP("82.228.72.221"));
	} catch (IOException e) {
	    fail();
	    logger.fatal(e);
	}
    }
}
