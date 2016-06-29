package project.mpermissions.callbacks;

import android.os.IBinder;

import java.util.List;

import project.mpermissions.types.Permission;

/**
 * Created by udit on 1/18/2016.
 */
public abstract class PermissionRequestCallback implements GenericRequestCallback{

    public abstract void onPermissionDenied(List<Permission> deniedPermissions);
    public abstract void onAllPermissionsGranted();
}