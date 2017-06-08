package com.michalkarmelita.bustimes.stops.repository;

import android.arch.lifecycle.LiveData;

import com.michalkarmelita.bustimes.stops.model.StopData;

import java.util.List;

public interface StopsRepository {

    LiveData<List<StopData>> getStops(double latitude, double longitude);
}
