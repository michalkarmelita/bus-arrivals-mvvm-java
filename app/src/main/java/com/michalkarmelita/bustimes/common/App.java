package com.michalkarmelita.bustimes.common;

import android.app.Application;

import com.michalkarmelita.bustimes.BuildConfig;
import com.michalkarmelita.bustimes.common.injection.AppComponent;
import com.michalkarmelita.bustimes.common.injection.AppModule;
import com.michalkarmelita.bustimes.common.injection.DaggerAppComponent;
import com.michalkarmelita.bustimes.common.injection.NetworkModule;

import butterknife.ButterKnife;

public class App extends Application {

    private static App app;

    private final AppComponent mComponent;

    public App() {
        app = this;
        mComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
        mComponent.inject(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }

    public static App get() {
        return app;
    }

    public AppComponent getComponent() {
        return mComponent;
    }

}
