package com.michalkarmelita.bustimes.common.permissions;

import android.support.annotation.NonNull;

/**
 * Manager dealing with the new Runtime Permissions.
 */
public interface PermissionManager {

    /**
     * Request runtime permissions.
     *
     * @param requestCode Code to be expected in the activity callback with the result of the request.
     * @param permissions List of {@link android.Manifest.permission} to be requested.
     **/
    void requestPermissions(int requestCode, @NonNull String... permissions);

    /**
     * Checks whether the given permission was previously denied and therefore we might explain
     * the users the effects of not granting it.
     *
     * @param permission {@link android.Manifest.permission} to check for.
     * @return True if the permissions was previously denied, false otherwise.
     **/
    boolean shouldShowPermissionRequestRationale(@NonNull String permission);

    /**
     * Checks whether a permission is enabled or not.
     *
     * @param permission Any of {@link android.Manifest.permission}
     * @return True if the permission is enabled, false otherwise
     **/
    boolean hasPermission(@NonNull String permission);

    /**
     * Checks whether a list of permission are enabled or not.
     *
     * @param permissions Any of {@link android.Manifest.permission}
     * @return True if the permissions are all enabled, false otherwise
     **/
    boolean hasPermissions(@NonNull String... permissions);
}
