import org.junit.Test;

import play.libs.WS;
import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset("utf-8", response);
    }
    
    @Test
    public void testTheWS() {
	WS.HttpResponse response = WS.url("http://localhost:9000/Application/getLocation").setParameter("lat", new Double(47.989921667414166)).setParameter("lon", new Double(1.0546875)).post();
	assertEquals(new Double(200), new Double(response.getStatus()));
	assertNotNull(response.getJson());
    }
}