package com.applaudo.applaudoteams.api;

import com.applaudo.applaudoteams.model.Teams;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;

public interface Api {

    @GET("/applaudo_homework.json")
    void getTeams( Callback<List<Teams>> response);

}
