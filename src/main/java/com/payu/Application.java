package com.payu;

import com.payu.exceptions.InvalidUrlException;
import com.payu.models.TinyUrlModel;
import com.payu.repository.TinyUrlRepository;
import com.payu.repository.TinyUrlRepositoryImpl;
import com.payu.service.TinyUrlBuilder;
import com.payu.service.TinyUrlBuilderImpl;

import java.util.logging.Logger;

/**
 * Created by asaleem on 19/12/17.
 */
public class Application {

    private TinyUrlBuilder tinyUrlBuilder = new TinyUrlBuilderImpl();
    private TinyUrlRepository tinyUrlRepository = new TinyUrlRepositoryImpl();

    private Logger logger = Logger.getLogger("Application");

    public TinyUrlModel getTinyUrl(String url) throws InvalidUrlException {

        logger.info("getting tinyUrl from " + url);
       TinyUrlModel tinyUrlModel =  tinyUrlRepository.findByOriginalUrl(url);

        if (tinyUrlModel == null) {
           String tinyUrl =  tinyUrlBuilder.build(url);
            tinyUrlModel = new TinyUrlModel();
            tinyUrlModel.setOriginalUrl(url);
            tinyUrlModel.setTinyUrl(tinyUrl);
            tinyUrlRepository.save(tinyUrlModel);
            logger.info("new tinyUrl is stored: tinyUrl = " + tinyUrl);
        }

        return tinyUrlModel;
    }

    public TinyUrlModel getOriginalUrl(String tinyUrl){
        logger.info("getting original url for " + tinyUrl);
        return tinyUrlRepository.findByTinyUrl(tinyUrl);
    }
}
