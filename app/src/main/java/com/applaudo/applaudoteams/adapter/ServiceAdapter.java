package com.applaudo.applaudoteams.adapter;

/**
 * Created by Javier Hernandez on 14/06/2015.
 */
import com.applaudo.applaudoteams.api.Api;

import retrofit.RestAdapter;

public class ServiceAdapter {

    private static String  API_URL = "http://107.170.150.115/homework";
    private static ServiceAdapter mInstance = null;


    RestAdapter rest = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API_URL).build();
    Api mApi = rest.create(Api.class);


    public Api getmApi(){

        return mApi;
    }

    public static ServiceAdapter getInstance(){

        if(mInstance == null)
        {
            mInstance = new ServiceAdapter();
        }

        return mInstance;
    }


}
