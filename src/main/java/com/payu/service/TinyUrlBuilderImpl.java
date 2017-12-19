package com.payu.service;

import com.payu.exceptions.InvalidUrlException;

import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by asaleem on 19/12/17.
 */
public class TinyUrlBuilderImpl implements TinyUrlBuilder {

    private final String ALLOWED_TINY_URL_SIGNS =  "@+*$" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
    private final int TINY_URL_PATH_LENGTH = 8;
    private final String PAYU_URL = "http://payu.tiny";

    private Logger logger = Logger.getLogger("TinyUrlBuilderImpl");

    private String randomPathString(String allowedPathSymbols, int length ){
        Random random = new SecureRandom();

        logger.info("Building tinyUrl");

        StringBuilder randomString = new StringBuilder( length );
        for( int i = 0; i < length; i++ ) {
            int nextIndex = random.nextInt(allowedPathSymbols.length());
            char nextCharacter = allowedPathSymbols.charAt(nextIndex);
            randomString.append(nextCharacter);
        }
        return randomString.toString();
    }

    @Override
    public String build(String url) throws InvalidUrlException {

        //TODO: this could be improved with URL = new URL(url)
        if (!isValidUrl(url)){
            logger.warning("Not a valid url : " + url);
            throw new InvalidUrlException("Invalid Url");
        }

        String tinyUrl =  PAYU_URL + "/" + randomPathString(ALLOWED_TINY_URL_SIGNS, TINY_URL_PATH_LENGTH);
        return tinyUrl;
    }

    private boolean isValidUrl(String url){
        return  !(url == null || url.isEmpty()) &&
                (url.startsWith("https://") || url.startsWith("http://") || url.startsWith("ftp://"));
    }
}
