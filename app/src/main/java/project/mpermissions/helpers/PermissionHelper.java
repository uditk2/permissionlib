package project.mpermissions.helpers;

import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import project.mpermissions.types.Permission;
import project.mpermissions.types.PermissionGroup;

/**
 * The helper class here takes in the permission requested by the user and redirects this to the permission fragment
 * which then manages the request and sends callback based on permission grant/revoke.
 * Created by udit on 6/25/2016.
 */
public class PermissionHelper {

    public static boolean verifyPermissionResult(int grantResult){
        if(grantResult == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }

    public static List<Permission> getDeniedPermissions(String[] permission, int[] grantResults){
        List<Permission> deniedPermissions = new ArrayList<>();
        for(int i =0 ; i < grantResults.length; i++){
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                deniedPermissions.add(Permission.fromPermissionString(permission[i]));
            }
        }
        return deniedPermissions;
    }

    public static List<PermissionGroup> getDeniedPermissionGroups(String[] permission, int[] grantResults){
        List<PermissionGroup> deniedPermissions = new ArrayList<>();
        for(int i =0 ; i < grantResults.length; i++){
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                PermissionGroup permissionGroup = PermissionGroup.getPermissionGroup(Permission.fromPermissionString(permission[i]));
                if(!deniedPermissions.contains(permissionGroup)){
                    deniedPermissions.add(permissionGroup);
                }
            }
        }
        return deniedPermissions;
    }
}
