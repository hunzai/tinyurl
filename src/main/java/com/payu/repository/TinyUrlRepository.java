package com.payu.repository;

import com.payu.models.TinyUrlModel;

/**
 * Created by asaleem on 19/12/17.
 */
public interface TinyUrlRepository {
    TinyUrlModel findByOriginalUrl(String url);
    TinyUrlModel findByTinyUrl(String tinyUrl);
    TinyUrlModel save(TinyUrlModel tinyUrlModel);
}
