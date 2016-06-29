package project.mpermissions.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import project.mpermissions.callbacks.GenericRequestCallback;
import project.mpermissions.callbacks.PermissionGroupRequestCallback;
import project.mpermissions.callbacks.PermissionRequestCallback;
import project.mpermissions.helpers.PermissionHelper;
import project.mpermissions.types.Permission;
import project.mpermissions.types.PermissionGroup;

/**
 * Headless fragment which attaches itself to the main activity and is responsible
 * for providing success and failure callbacks depending on permissions granted or revoked.
 * Created by udit on 1/18/2016.
 */
public class PermissionFragment extends Fragment{

    private static final String CALLBACK_KEY = "calback-key";
    PermissionRequestCallback permissionRequestCallback;
    PermissionGroupRequestCallback permissionGroupRequestCallback;
    HashMap<Integer, WeakReference<GenericRequestCallback>> permissionCallbacks;
    public int REQUEST_CODE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public static PermissionFragment newInstance(){
       return new PermissionFragment();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        WeakReference<GenericRequestCallback> callbackWeakReference = permissionCallbacks.get(requestCode);
        GenericRequestCallback callback = callbackWeakReference.get();
        if(callback instanceof PermissionGroupRequestCallback){
            Set<PermissionGroup> permissionGroupList = new TreeSet<>();
            for(int i =0 ; i < permissions.length; i++){
                if(!PermissionHelper.verifyPermissionResult(grantResults[i])){
                    permissionGroupList.add(PermissionGroup.getPermissionGroup(Permission.fromPermissionString(permissions[i])));
                }
            }
            if(permissionGroupList.size() > 0){
                ArrayList<PermissionGroup> permissionGroups = new ArrayList<>();
                permissionGroups.addAll(permissionGroupList);
                ((PermissionGroupRequestCallback)callback).onPermissionGroupDenied(permissionGroups);
            } else {
                callback.onAllPermissionsGranted();
            }
        } else if(callback instanceof  PermissionRequestCallback){
            List<Permission> permissionList = new ArrayList<>();
            for(int i =0 ; i < permissions.length; i++){
                if(!PermissionHelper.verifyPermissionResult(grantResults[i])){
                    Permission permission = Permission.fromPermissionString(permissions[i]);
                    permissionList.add(permission);
                }
                if(permissionList.size() > 0){
                    ((PermissionRequestCallback) callback).onPermissionDenied(permissionList);
                } else {
                    callback.onAllPermissionsGranted();
                }
            }
        }


    }


    public void requestPermission(PermissionRequestCallback callback, Permission... permissions){
        String[] permissionsList = new String[permissions.length];
        for(int i =0 ; i < permissions.length; i++){
            permissionsList[i] = permissions[i].getPermission();
        }
        permissionCallbacks.put(REQUEST_CODE, new WeakReference<GenericRequestCallback>(callback));
        ActivityCompat.requestPermissions(getActivity(), permissionsList, REQUEST_CODE++);
    }


    public void requestPermissionGroup(PermissionGroupRequestCallback callback, PermissionGroup... permissionGroups){
        ArrayList<String> permissionsList = new ArrayList<>();
        for(int i=0; i < permissionGroups.length; i++){
            permissionsList.addAll(permissionGroups[i].getPermissionList());
        }
        permissionCallbacks.put(REQUEST_CODE, new WeakReference<GenericRequestCallback>(callback));
        ActivityCompat.requestPermissions(getActivity(), (String[]) permissionsList.toArray(), REQUEST_CODE++);
    }
}
