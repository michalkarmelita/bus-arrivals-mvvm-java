package com.michalkarmelita.bustimes.common.network;


import android.arch.lifecycle.LiveData;

import com.michalkarmelita.bustimes.common.network.model.ApiResponse;
import com.michalkarmelita.bustimes.common.network.model.ArrivalsResponse;
import com.michalkarmelita.bustimes.common.network.model.StopsResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * REST Api interface for Transport for London.
 */
public interface TflApi {

    @GET("/StopPoint")
    LiveData<ApiResponse<StopsResponse>> getStopPoints(@Query("lat") double lat, @Query("lon") double lon, @Query("stopTypes") String stopType, @Query("radius") int radius);

    @GET("/StopPoint/{id}/Arrivals")
    LiveData<ApiResponse<List<ArrivalsResponse>>> getArrivals(@Path("id") String stopId);
}
