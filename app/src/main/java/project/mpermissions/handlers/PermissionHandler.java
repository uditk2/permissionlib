package project.mpermissions.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

import project.mpermissions.callbacks.PermissionGroupRequestCallback;
import project.mpermissions.callbacks.PermissionRequestCallback;
import project.mpermissions.exceptions.ActivityAttachException;
import project.mpermissions.fragments.PermissionFragment;
import project.mpermissions.types.Permission;
import project.mpermissions.types.PermissionGrantStatus;
import project.mpermissions.types.PermissionGroup;

/**
 * Created by udit on 6/25/2016.
 */
public class PermissionHandler {
    // random tag for the permissions fragment
    private static final String PERMISSIONS_TAG = "mpermissions998";
    private static PermissionFragment permissionFragment;

    public synchronized static void attachToActivity(Activity activity) throws ActivityAttachException{
        if(activity.getFragmentManager().findFragmentByTag(PERMISSIONS_TAG)== null) {
            activity.getFragmentManager().beginTransaction().add(PermissionFragment.newInstance(), PERMISSIONS_TAG).commit();
        }else {
            throw new ActivityAttachException("PermissionHandler is already attached to this Activity");
        }
    }

    public static boolean isPermissionGroupGranted(Context context, PermissionGroup permissionGroup){
        for(Permission permission : permissionGroup.getPermissionGroupPermissions()){
            if(!isPermissionGranted(context, permission)){
                return false;
            }
        }
        return true;
    }

    public static void requestPermission(Context context, PermissionRequestCallback callback, Permission... permissions){

    }

    public static void requestPermissionGroup(Context context, PermissionGroupRequestCallback callback, PermissionGroup... permissionGroups){

    }


    public static boolean isPermissionGranted(Context context, Permission permission){
        if(ActivityCompat.checkSelfPermission(context, permission.getPermission()) == PackageManager.PERMISSION_DENIED){
            return false;
        }
        return true;
    }

    /**
     * Of the supplied permissions, get the list of granted permissions
     * @param context the application context
     * @param permissions
     * @return list of granted permissions
     */
    public static List<Permission> getGrantedPermissionList(Context context, Permission... permissions){
        return getGrantedDeniedPermissionList(context, true, permissions);
    }

    private static List<Permission> getGrantedDeniedPermissionList(Context context, boolean isGranted, Permission[] permissions){
        List<Permission> grantedDeniedList = new ArrayList<>();
        for(Permission permission  : permissions){
            if(isPermissionGranted(context, permission) == isGranted){
                grantedDeniedList.add(permission);
            }
        }
        return grantedDeniedList;
    }

    private static List<PermissionGroup> getGrantedDeniedPermissionGroupList(Context context, boolean isGranted, PermissionGroup[] permissions){
        List<PermissionGroup> grantedDeniedList = new ArrayList<>();
        for(PermissionGroup permission  : permissions){
            if(isPermissionGroupGranted(context, permission) == isGranted){
                grantedDeniedList.add(permission);
            }
        }
        return grantedDeniedList;
    }

    /**
     * Of the supplied list, get the list of granted permissions.
     * @param context the application context
     * @param permissions
     * @return list of denied permissions
     */
    public static List<Permission> getDeniedPermissionList(Context context, Permission... permissions){
        return getGrantedDeniedPermissionList(context, false, permissions);
    }

    /**
     * Of the supplied list, get the list of denied permission groups
     * @param context the application context
     * @param permissions
     * @return list of denied permission groups
     */
    public static List<PermissionGroup> getDeniedPermissionGroupList(Context context, PermissionGroup... permissions){
        return getGrantedDeniedPermissionGroupList(context, false, permissions);
    }

    /**
     * Of the supplied list, get the list of granted permission groups
     * @param context the application context
     * @param permissions
     * @return list of granted permission groups
     */
    public static List<PermissionGroup> getGrantedPermissionGroupList(Context context, PermissionGroup... permissions){
        return getGrantedDeniedPermissionGroupList(context, true, permissions);
    }

}
