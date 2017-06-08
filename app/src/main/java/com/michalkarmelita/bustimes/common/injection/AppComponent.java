package com.michalkarmelita.bustimes.common.injection;

import com.michalkarmelita.bustimes.common.App;
import com.michalkarmelita.bustimes.common.injection.scopes.PerApplication;
import com.michalkarmelita.bustimes.stops.injection.StopsComponent;
import com.michalkarmelita.bustimes.stops.injection.StopsModule;

import dagger.Component;

@PerApplication
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    StopsComponent plus(StopsModule stopsModule);
}
