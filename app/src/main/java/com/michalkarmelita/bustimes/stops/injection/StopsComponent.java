package com.michalkarmelita.bustimes.stops.injection;

import com.michalkarmelita.bustimes.common.injection.scopes.PerActivity;
import com.michalkarmelita.bustimes.stops.view.StopsActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(
        modules = {
                StopsModule.class
        }
)
public interface StopsComponent {
    void inject(StopsActivity stopsActivity);
}
