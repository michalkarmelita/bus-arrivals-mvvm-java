package com.michalkarmelita.bustimes.common.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import javax.inject.Inject;

public class PermissionManagerImpl implements PermissionManager {
    private Activity activity;

    @Inject
    public PermissionManagerImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void requestPermissions(int requestCode, @NonNull String... permissions) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    @Override
    public boolean shouldShowPermissionRequestRationale(@NonNull String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    @Override
    public boolean hasPermission(@NonNull String permission) {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public boolean hasPermissions(@NonNull String... permissions) {
        for (int i = 0; i < permissions.length; i++) {
            if (!hasPermission(permissions[i])) {
                return false;
            }
        }

        return true;
    }
}
