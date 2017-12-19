package payu;

import com.payu.exceptions.InvalidUrlException;
import com.payu.service.TinyUrlBuilder;
import com.payu.service.TinyUrlBuilderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by asaleem on 18/12/17.
 */
public class TinyUrlTests {

    private TinyUrlBuilder tinyUrlBuilder;
    private final String PAYU_URL = "http://payu.tiny";

    @Before
    public void before(){
        tinyUrlBuilder = new TinyUrlBuilderImpl();
    }

    @Test
    public void testBuildTinyUrl() throws InvalidUrlException {
        String url = "https://en.wikipedia.org/wiki/Passband#Digital_transmission";
        String tinyUrl = tinyUrlBuilder.build(url);
        Assert.assertTrue(tinyUrl.startsWith(PAYU_URL));
    }

    @Test(expected = InvalidUrlException.class)
    public void testBuildTinyUrlFromInvalidUrl() throws InvalidUrlException {
        String url = "payu_com_xyl";
        String tinyUrl = tinyUrlBuilder.build(url);
        Assert.assertTrue(tinyUrl.startsWith(PAYU_URL));
    }

    @Test
    public void testDontCreateIfUrlExists(){
        //TODO: needs mocks
    }

}
