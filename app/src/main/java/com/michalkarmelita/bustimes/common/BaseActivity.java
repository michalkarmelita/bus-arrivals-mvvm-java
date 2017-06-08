package com.michalkarmelita.bustimes.common;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.michalkarmelita.bustimes.common.injection.AppComponent;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public abstract class BaseActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    protected static final String[] MANDATORY_PERMISSIONS = {ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION};

    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistry;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectComponent(((App) getApplication()).getComponent());
    }

    protected abstract void injectComponent(AppComponent appComponent);
}
