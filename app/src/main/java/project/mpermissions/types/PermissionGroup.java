package project.mpermissions.types;

import android.Manifest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by udit on 6/25/2016.
 */
public enum PermissionGroup {
    CALENDAR(Permission.READ_CALENDAR, Permission.WRITE_CALENDAR),
    CAMERA(Permission.CAMERA),
    CONTACTS(Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, Permission.GET_ACCOUNTS),
    LOCATION(Permission.ACCESS_COARSE_LOCATION, Permission.ACCESS_FINE_LOCATION),
    MICROPHONE(Permission.RECORD_AUDIO),
    PHONE(Permission.READ_PHONE_STATE, Permission.CALL_PHONE, Permission.READ_CALL_LOG,
            Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS),
    SENSORS(Permission.BODY_SENSORS),
    SMS(Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS),
    STORAGE(Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE),
    INVALID_PERMISSION_GROUP(Permission.INVALID_PERMISSION);

    private PermissionGroup(Permission... permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    Permission[] permissionGroup;

    public List<String> getPermissionList() {
        List<String> permissions = new ArrayList<>();
        int count = 0;
        for (Permission permission : permissionGroup) {
           permissions.add(permission.permission);
        }
        return permissions;
    }

    public Permission[] getPermissionGroupPermissions(){
        return permissionGroup;
    }

    public static PermissionGroup getPermissionGroup(Permission permission){
        switch (permission){
            case READ_CALENDAR:
            case WRITE_CALENDAR:
                return CALENDAR;
            case CAMERA:
                return CAMERA;
            case READ_CONTACTS:
            case WRITE_CONTACTS:
            case GET_ACCOUNTS:
                return CONTACTS;
            case ACCESS_COARSE_LOCATION:
            case ACCESS_FINE_LOCATION:
                return LOCATION;
            case RECORD_AUDIO:
                return MICROPHONE;
            case READ_PHONE_STATE:
            case CALL_PHONE:
            case  READ_CALL_LOG:
            case WRITE_CALL_LOG:
            case ADD_VOICEMAIL:
            case USE_SIP:
            case PROCESS_OUTGOING_CALLS:
                return PHONE;
            case BODY_SENSORS:
                return SENSORS;
            case SEND_SMS:
            case RECEIVE_SMS:
            case READ_SMS:
            case RECEIVE_WAP_PUSH:
            case RECEIVE_MMS:
                return SMS;
            case READ_EXTERNAL_STORAGE:
            case WRITE_EXTERNAL_STORAGE:
                return STORAGE;
            default:
                return INVALID_PERMISSION_GROUP;
        }
    }
}
