package com.tanx.exposer.achieve;

import android.database.Cursor;
import android.text.TextUtils;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import java.util.concurrent.atomic.AtomicInteger;
import o0oIxXOx.XIxXXX0x0;
import org.json.JSONException;
import xIx.oxoX;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f26493I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final int f26494II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f26495II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f26496OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oxoX f26497Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public AdMonitorType f26498X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f26499XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f26500oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public AdMonitorRetryType f26501oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f26502oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public long f26503xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public AtomicInteger f26504xxIXOIIO;

    public II0xO0(String str, String str2, AdMonitorType adMonitorType, String str3, String str4, int i) {
        this.f26500oIX0oI = -1L;
        this.f26504xxIXOIIO = new AtomicInteger(0);
        this.f26501oOoXoXO = AdMonitorRetryType.MEMORY;
        this.f26495II0xO0 = str;
        this.f26493I0Io = str2;
        this.f26498X0o0xo = adMonitorType;
        this.f26502oxoX = str3;
        this.f26499XO = str4;
        this.f26494II0XooXoX = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.f26496OOXIXo = XOxoX.II0xO0.oIX0oI(currentTimeMillis, "yyyy-MM-dd");
        this.f26503xoIox = currentTimeMillis + 86400000;
    }

    public int I0Io() {
        return this.f26494II0XooXoX;
    }

    public AtomicInteger II0XooXoX() {
        return this.f26504xxIXOIIO;
    }

    public String II0xO0() {
        return this.f26496OOXIXo;
    }

    public String OOXIXo() {
        return this.f26495II0xO0;
    }

    public void Oxx0IOOO(oxoX oxox) {
        this.f26497Oxx0IOOO = oxox;
    }

    public void X0o0xo(long j) {
        this.f26500oIX0oI = j;
    }

    public void XO(AdMonitorRetryType adMonitorRetryType) {
        this.f26501oOoXoXO = adMonitorRetryType;
    }

    public long oIX0oI() {
        return this.f26503xoIox;
    }

    public String oO() {
        return this.f26502oxoX;
    }

    public AdMonitorType oOoXoXO() {
        return this.f26498X0o0xo;
    }

    public AdMonitorRetryType ooOOo0oXI() {
        return this.f26501oOoXoXO;
    }

    public long oxoX() {
        return this.f26500oIX0oI;
    }

    public String x0XOIxOo() {
        return this.f26499XO;
    }

    public oxoX xoIox() {
        return this.f26497Oxx0IOOO;
    }

    public String xxIXOIIO() {
        return this.f26493I0Io;
    }

    public II0xO0(Cursor cursor) {
        this.f26500oIX0oI = -1L;
        this.f26504xxIXOIIO = new AtomicInteger(0);
        this.f26501oOoXoXO = AdMonitorRetryType.MEMORY;
        this.f26500oIX0oI = cursor.getLong(cursor.getColumnIndex("id"));
        this.f26498X0o0xo = AdMonitorType.valueOf(cursor.getString(cursor.getColumnIndex("monitor_type")));
        this.f26495II0xO0 = cursor.getString(cursor.getColumnIndex("monitor_url"));
        this.f26493I0Io = cursor.getString(cursor.getColumnIndex("monitor_original_url"));
        this.f26502oxoX = cursor.getString(cursor.getColumnIndex("monitor_url_host"));
        this.f26499XO = cursor.getString(cursor.getColumnIndex("monitor_url_hash"));
        this.f26504xxIXOIIO = new AtomicInteger(cursor.getInt(cursor.getColumnIndex("retry_times")));
        this.f26494II0XooXoX = cursor.getInt(cursor.getColumnIndex("max_retry_times"));
        this.f26496OOXIXo = cursor.getString(cursor.getColumnIndex(XIxXXX0x0.f31178xoIox));
        this.f26503xoIox = cursor.getLong(cursor.getColumnIndex("expire_time"));
        String string = cursor.getString(cursor.getColumnIndex("monitor_extra_params"));
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.f26497Oxx0IOOO = new oxoX(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
