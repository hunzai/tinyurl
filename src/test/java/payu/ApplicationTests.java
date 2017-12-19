package payu;


import com.payu.Application;
import com.payu.exceptions.InvalidUrlException;
import com.payu.models.TinyUrlModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by asaleem on 19/12/17.
 */
public class ApplicationTests {

    private Application app;

    @Before
    public void before(){
        app = new Application();
    }

    @Test
    public void testTinyUrlBuild() throws InvalidUrlException {
        String url = "https://stackoverflow.com/questions/47883666/valueerror-too-many-values-to-unpack-scipys-fmin-vs-least-squares";
        TinyUrlModel tinyUrlModel =  app.getTinyUrl(url);
        Assert.assertNotNull(tinyUrlModel);
        Assert.assertNotNull(tinyUrlModel.getTinyUrl());
    }


    @Test
    public void testOriginalUrlBuild() throws InvalidUrlException {
        String url = "https://stackoverflow.com/questions/47883666/valueerror-too-many-values-to-unpack-scipys-fmin-vs-least-squares";
        TinyUrlModel tinyUrlModel =  app.getTinyUrl(url);
        Assert.assertNotNull(tinyUrlModel.getOriginalUrl());
    }

    @Test
    public void testOriginalFromTinyUrl(){
        //TODO: needs mocked
    }

    @Test
    public void testWhenOriginalUrlExists(){
        //TODO: needs mocked
    }
}
