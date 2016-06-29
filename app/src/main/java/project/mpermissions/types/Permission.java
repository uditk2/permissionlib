package project.mpermissions.types;

import android.Manifest;

/**
 * Created by udit on 6/25/2016.
 */
public enum Permission {
    READ_CALENDAR(Manifest.permission.READ_CALENDAR),
    WRITE_CALENDAR(Manifest.permission.WRITE_CALENDAR),
    CAMERA(Manifest.permission.CAMERA),
    READ_CONTACTS(Manifest.permission.READ_CONTACTS),
    WRITE_CONTACTS(Manifest.permission.WRITE_CONTACTS),
    GET_ACCOUNTS(Manifest.permission.GET_ACCOUNTS),
    ACCESS_FINE_LOCATION(Manifest.permission.ACCESS_FINE_LOCATION),
    ACCESS_COARSE_LOCATION(Manifest.permission.ACCESS_COARSE_LOCATION),
    RECORD_AUDIO(Manifest.permission.RECORD_AUDIO),
    READ_PHONE_STATE(Manifest.permission.READ_PHONE_STATE),
    CALL_PHONE(Manifest.permission.CALL_PHONE),
    READ_CALL_LOG(Manifest.permission.READ_CALL_LOG),
    WRITE_CALL_LOG(Manifest.permission.WRITE_CALL_LOG),
    ADD_VOICEMAIL(Manifest.permission.ADD_VOICEMAIL),
    USE_SIP(Manifest.permission.USE_SIP),
    PROCESS_OUTGOING_CALLS(Manifest.permission.PROCESS_OUTGOING_CALLS),
    BODY_SENSORS(Manifest.permission.BODY_SENSORS),
    SEND_SMS(Manifest.permission.SEND_SMS),
    RECEIVE_SMS(Manifest.permission.RECEIVE_SMS),
    READ_SMS(Manifest.permission.READ_SMS),
    RECEIVE_WAP_PUSH(Manifest.permission.RECEIVE_WAP_PUSH),
    RECEIVE_MMS(Manifest.permission.RECEIVE_MMS),
    READ_EXTERNAL_STORAGE(Manifest.permission.READ_EXTERNAL_STORAGE),
    WRITE_EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE),
    INVALID_PERMISSION("Invalid Permission");

    String permission;

    private Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public static Permission fromPermissionString(String permission) {
        switch (permission) {
            case (Manifest.permission.READ_CALENDAR):
                return READ_CALENDAR;
            case (Manifest.permission.WRITE_CALENDAR):
                return WRITE_CALENDAR;
            case (Manifest.permission.CAMERA):
                return CAMERA;
            case (Manifest.permission.READ_CONTACTS):
                return READ_CONTACTS;
            case (Manifest.permission.WRITE_CONTACTS):
                return WRITE_CONTACTS;
            case (Manifest.permission.GET_ACCOUNTS):
                return GET_ACCOUNTS;
            case (Manifest.permission.ACCESS_FINE_LOCATION):
                return ACCESS_FINE_LOCATION;
            case (Manifest.permission.ACCESS_COARSE_LOCATION):
                return ACCESS_COARSE_LOCATION;
            case (Manifest.permission.RECORD_AUDIO):
                return RECORD_AUDIO;
            case (Manifest.permission.READ_PHONE_STATE):
                return READ_PHONE_STATE;
            case (Manifest.permission.CALL_PHONE):
                return CALL_PHONE;
            case (Manifest.permission.READ_CALL_LOG):
                return READ_CALL_LOG;
            case (Manifest.permission.WRITE_CALL_LOG):
                return WRITE_CALL_LOG;
            case (Manifest.permission.ADD_VOICEMAIL):
                return ADD_VOICEMAIL;
            case (Manifest.permission.USE_SIP):
                return USE_SIP;
            case (Manifest.permission.PROCESS_OUTGOING_CALLS):
                return PROCESS_OUTGOING_CALLS;
            case (Manifest.permission.BODY_SENSORS):
                return BODY_SENSORS;
            case (Manifest.permission.SEND_SMS):
                return SEND_SMS;
            case (Manifest.permission.RECEIVE_SMS):
                return RECEIVE_SMS;
            case (Manifest.permission.READ_SMS):
                return READ_SMS;
            case (Manifest.permission.RECEIVE_WAP_PUSH):
                return RECEIVE_WAP_PUSH;
            case (Manifest.permission.RECEIVE_MMS):
                return RECEIVE_MMS;
            case (Manifest.permission.READ_EXTERNAL_STORAGE):
                return READ_EXTERNAL_STORAGE;
            case (Manifest.permission.WRITE_EXTERNAL_STORAGE):
                return WRITE_EXTERNAL_STORAGE;
            default:
                return INVALID_PERMISSION;
        }
    }
}
