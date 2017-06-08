package com.michalkarmelita.bustimes.stops.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.michalkarmelita.bustimes.common.injection.qualifiers.ForApplication;
import com.michalkarmelita.bustimes.stops.location.LocationLiveData;
import com.michalkarmelita.bustimes.stops.model.StopData;
import com.michalkarmelita.bustimes.stops.repository.StopsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StopsViewModel extends AndroidViewModel {

    private final LiveData<List<StopData>> stopsObservable;
    private final LocationLiveData locationLiveData;
    private final LiveData<List<MarkerOptions>> mapMarkers;

    public StopsViewModel(Application application, final StopsRepository stopsRepository, LocationLiveData locationLiveData) {
        super(application);
        this.locationLiveData = locationLiveData;
        stopsObservable = Transformations.switchMap(locationLiveData, new Function<Location, LiveData<List<StopData>>>() {
            @Override
            public LiveData<List<StopData>> apply(Location location) {
                return stopsRepository.getStops(location.getLatitude(), location.getLongitude());
            }
        });

        mapMarkers = Transformations.map(stopsObservable, new Function<List<StopData>, List<MarkerOptions>>() {
            @Override
            public List<MarkerOptions> apply(List<StopData> input) {
                List<MarkerOptions> markers = new ArrayList<>();
                for (StopData stopData : input) {
                    markers.add(new MarkerOptions().position(new LatLng(stopData.getLat(), stopData.getLon())));
                }
                return markers;
            }
        });

    }

    public LiveData<List<StopData>> getStops() {
        return stopsObservable;
    }

    public LiveData<List<MarkerOptions>> getMapMarkers() {
        return mapMarkers;
    }

    public void requestLocation() {
        locationLiveData.reconnect();
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private final Application application;
        private final StopsRepository stopsRepository;
        private final LocationLiveData locationLiveData;

        @Inject
        public Factory(@ForApplication Application application, StopsRepository stopsUseCase, LocationLiveData locationLiveData) {
            this.application = application;
            this.stopsRepository = stopsUseCase;
            this.locationLiveData = locationLiveData;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new StopsViewModel(application, stopsRepository, locationLiveData);
        }
    }
}
