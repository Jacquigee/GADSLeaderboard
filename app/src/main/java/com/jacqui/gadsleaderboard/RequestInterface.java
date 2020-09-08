package com.jacqui.gadsleaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface   RequestInterface {
    @GET("api/hours")
    Call<List<LearningHours>> getLearningJson();

}
