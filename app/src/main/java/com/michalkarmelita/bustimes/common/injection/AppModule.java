package com.michalkarmelita.bustimes.common.injection;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.michalkarmelita.bustimes.common.App;
import com.michalkarmelita.bustimes.common.injection.qualifiers.ForApplication;
import com.michalkarmelita.bustimes.common.injection.scopes.PerApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @PerApplication
    @ForApplication
    Context provideApplicationContext() {
        return mApp;
    }

    @Provides
    @PerApplication
    @ForApplication
    Application provideApplication() {
        return mApp;
    }

    @Provides
    @PerApplication
    Resources provideResources(@ForApplication Context context) {
        return context.getResources();
    }

    @Provides
    @PerApplication
    Gson provideGson() {
        return new Gson();
    }
}
