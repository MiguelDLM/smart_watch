package com.blankj.utilcode.constant;

import android.annotation.SuppressLint;
import com.kuaishou.weapon.p0.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"InlinedApi"})
/* loaded from: classes8.dex */
public final class PermissionConstants {
    public static final String ACTIVITY_RECOGNITION = "ACTIVITY_RECOGNITION";
    public static final String CALENDAR = "CALENDAR";
    public static final String CAMERA = "CAMERA";
    public static final String CONTACTS = "CONTACTS";
    public static final String LOCATION = "LOCATION";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String PHONE = "PHONE";
    public static final String SENSORS = "SENSORS";
    public static final String SMS = "SMS";
    public static final String STORAGE = "STORAGE";
    private static final String[] GROUP_CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] GROUP_CAMERA = {"android.permission.CAMERA"};
    private static final String[] GROUP_CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", g.f};
    private static final String[] GROUP_LOCATION = {g.g, g.h};
    private static final String[] GROUP_MICROPHONE = {"android.permission.RECORD_AUDIO"};
    private static final String[] GROUP_PHONE = {g.c, "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] GROUP_PHONE_BELOW_O = {g.c, "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] GROUP_SENSORS = {"android.permission.BODY_SENSORS"};
    private static final String[] GROUP_SMS = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] GROUP_STORAGE = {g.i, g.j};
    private static final String[] GROUP_ACTIVITY_RECOGNITION = {"android.permission.ACTIVITY_RECOGNITION"};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface PermissionGroup {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x007d, code lost:
    
        if (r3.equals(com.blankj.utilcode.constant.PermissionConstants.LOCATION) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] getPermissions(java.lang.String r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L6
            java.lang.String[] r3 = new java.lang.String[r0]
            return r3
        L6:
            r1 = -1
            int r2 = r3.hashCode()
            switch(r2) {
                case -1611296843: goto L77;
                case -1596608551: goto L6c;
                case -1166291365: goto L61;
                case 82233: goto L56;
                case 76105038: goto L4b;
                case 140654183: goto L40;
                case 215175251: goto L35;
                case 604302142: goto L2a;
                case 1856013610: goto L1e;
                case 1980544805: goto L11;
                default: goto Le;
            }
        Le:
            r0 = -1
            goto L80
        L11:
            java.lang.String r0 = "CAMERA"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L1a
            goto Le
        L1a:
            r0 = 9
            goto L80
        L1e:
            java.lang.String r0 = "MICROPHONE"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L27
            goto Le
        L27:
            r0 = 8
            goto L80
        L2a:
            java.lang.String r0 = "CALENDAR"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L33
            goto Le
        L33:
            r0 = 7
            goto L80
        L35:
            java.lang.String r0 = "CONTACTS"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L3e
            goto Le
        L3e:
            r0 = 6
            goto L80
        L40:
            java.lang.String r0 = "ACTIVITY_RECOGNITION"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L49
            goto Le
        L49:
            r0 = 5
            goto L80
        L4b:
            java.lang.String r0 = "PHONE"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L54
            goto Le
        L54:
            r0 = 4
            goto L80
        L56:
            java.lang.String r0 = "SMS"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L5f
            goto Le
        L5f:
            r0 = 3
            goto L80
        L61:
            java.lang.String r0 = "STORAGE"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L6a
            goto Le
        L6a:
            r0 = 2
            goto L80
        L6c:
            java.lang.String r0 = "SENSORS"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L75
            goto Le
        L75:
            r0 = 1
            goto L80
        L77:
            java.lang.String r2 = "LOCATION"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L80
            goto Le
        L80:
            switch(r0) {
                case 0: goto Lac;
                case 1: goto La9;
                case 2: goto La6;
                case 3: goto La3;
                case 4: goto L97;
                case 5: goto L94;
                case 6: goto L91;
                case 7: goto L8e;
                case 8: goto L8b;
                case 9: goto L88;
                default: goto L83;
            }
        L83:
            java.lang.String[] r3 = new java.lang.String[]{r3}
            return r3
        L88:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_CAMERA
            return r3
        L8b:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_MICROPHONE
            return r3
        L8e:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_CALENDAR
            return r3
        L91:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_CONTACTS
            return r3
        L94:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_ACTIVITY_RECOGNITION
            return r3
        L97:
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r3 >= r0) goto La0
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_PHONE_BELOW_O
            return r3
        La0:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_PHONE
            return r3
        La3:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_SMS
            return r3
        La6:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_STORAGE
            return r3
        La9:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_SENSORS
            return r3
        Lac:
            java.lang.String[] r3 = com.blankj.utilcode.constant.PermissionConstants.GROUP_LOCATION
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.constant.PermissionConstants.getPermissions(java.lang.String):java.lang.String[]");
    }
}
