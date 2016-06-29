package project.mpermissions.callbacks;

import java.util.List;

import project.mpermissions.types.PermissionGroup;

/**
 * This callback is called even after the activity goes to the background.
 * Created by udit on 6/25/2016.
 */
public abstract class PermissionGroupRequestCallback implements GenericRequestCallback {
    public abstract void onPermissionGroupDenied(List<PermissionGroup> deniedPermissions);
    public abstract void onAllPermissionsGranted();
}
