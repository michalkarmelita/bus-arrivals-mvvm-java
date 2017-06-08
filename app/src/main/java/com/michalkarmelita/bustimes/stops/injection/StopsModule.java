package com.michalkarmelita.bustimes.stops.injection;

import android.app.Activity;
import android.content.Context;

import com.michalkarmelita.bustimes.common.injection.qualifiers.ForActivity;
import com.michalkarmelita.bustimes.common.permissions.PermissionManager;
import com.michalkarmelita.bustimes.common.permissions.PermissionManagerImpl;
import com.michalkarmelita.bustimes.stops.repository.StopsRepository;
import com.michalkarmelita.bustimes.stops.repository.StopsRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class StopsModule {

    private final Context context;

    public StopsModule(Context context) {
        this.context = context;
    }

    @Provides
    @ForActivity
    Context provideContext() {
        return context;
    }

    @Provides
    Activity provideActivity() {
        return (Activity) context;
    }

    @Provides
    PermissionManager providePermissionManager(PermissionManagerImpl manager) {
        return manager;
    }

    @Provides
    StopsRepository provideStopsRepository(StopsRepositoryImpl repository) {
        return repository;
    }

}
