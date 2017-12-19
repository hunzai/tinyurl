package com.payu.service;

import com.payu.exceptions.InvalidUrlException;

/**
 * Created by asaleem on 19/12/17.
 */
public interface TinyUrlBuilder {
    /**
     * Implements algorithm on how to build the url
     * @param url
     * @return
     */
    String build(String url) throws InvalidUrlException;
}
