package com.vtrump.vtble;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes13.dex */
public class oo0xXOI0I {

    /* renamed from: I0Io, reason: collision with root package name */
    public static oo0xXOI0I f27530I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Context f27531II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xI f27532oIX0oI;

    public oo0xXOI0I(Context context) {
        this.f27531II0xO0 = context;
        this.f27532oIX0oI = new xI(context, "mm003.db");
    }

    public static oo0xXOI0I oIX0oI(Context context) {
        if (f27530I0Io == null) {
            f27530I0Io = new oo0xXOI0I(context);
        }
        return f27530I0Io;
    }

    public void I0Io(VTDevice vTDevice) {
        if (vTDevice == null) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f27532oIX0oI.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", vTDevice.oI0IIXIo());
        contentValues.put("bt_address", vTDevice.Oo().getAddress());
        contentValues.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, vTDevice.x0xO0oo());
        contentValues.put("protocol", Integer.valueOf(vTDevice.Oxx0xo().oxoX()));
        contentValues.put("type", Integer.valueOf(vTDevice.Oxx0xo().I0Io()));
        contentValues.put("sub_type", Integer.valueOf(vTDevice.Oxx0xo().II0xO0()));
        contentValues.put("vendor", Integer.valueOf(vTDevice.Oxx0xo().X0o0xo()));
        writableDatabase.insert(DeviceRequestsHelper.DEVICE_INFO_DEVICE, null, contentValues);
        writableDatabase.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        if (r6 != 21) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.vtrump.vtble.VTDevice> II0xO0() {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.oo0xXOI0I.II0xO0():java.util.ArrayList");
    }

    public void X0o0xo(VTDevice vTDevice) {
        if (vTDevice == null || vTDevice.Oo() == null || TextUtils.isEmpty(vTDevice.Oo().getAddress())) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f27532oIX0oI.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", vTDevice.oI0IIXIo());
        contentValues.put("bt_address", vTDevice.Oo().getAddress());
        contentValues.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, vTDevice.x0xO0oo());
        contentValues.put("protocol", Integer.valueOf(vTDevice.Oxx0xo().oxoX()));
        contentValues.put("type", Integer.valueOf(vTDevice.Oxx0xo().I0Io()));
        contentValues.put("sub_type", Integer.valueOf(vTDevice.Oxx0xo().II0xO0()));
        contentValues.put("vendor", Integer.valueOf(vTDevice.Oxx0xo().X0o0xo()));
        writableDatabase.update(DeviceRequestsHelper.DEVICE_INFO_DEVICE, contentValues, "bt_address=?", new String[]{vTDevice.Oo().getAddress()});
        writableDatabase.close();
    }

    public int oxoX(VTDevice vTDevice) {
        if (vTDevice == null) {
            return 0;
        }
        return this.f27532oIX0oI.getWritableDatabase().delete(DeviceRequestsHelper.DEVICE_INFO_DEVICE, "bt_address=?", new String[]{String.valueOf(vTDevice.Oo().getAddress())});
    }
}
