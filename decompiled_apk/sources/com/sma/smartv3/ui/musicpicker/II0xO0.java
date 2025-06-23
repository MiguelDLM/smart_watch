package com.sma.smartv3.ui.musicpicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.provider.MediaStore;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;

/* loaded from: classes11.dex */
public class II0xO0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f23657X0o0xo = 990;

    /* renamed from: XO, reason: collision with root package name */
    public static final String[] f23658XO = {"_id", "title", "album", "duration", "_size", "artist", "_data", "is_music", "_display_name"};

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f23659I0Io = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Context f23660II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ContentResolver f23661oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Cursor f23662oxoX;

    public II0xO0(@NonNull Context context) {
        this.f23660II0xO0 = context;
        this.f23661oIX0oI = context.getContentResolver();
    }

    public boolean I0Io(String name) {
        if (!name.endsWith(".mp3") && !name.endsWith(".MP3")) {
            return false;
        }
        return true;
    }

    public boolean II0xO0(String filePath, MediaMetadataRetriever retriever) {
        retriever.setDataSource(filePath);
        String extractMetadata = retriever.extractMetadata(12);
        LogUtils.d(filePath + " 当前监测出来的数据  --- >   mimeType = " + extractMetadata);
        return MimeTypes.AUDIO_MPEG.equalsIgnoreCase(extractMetadata);
    }

    public void X0o0xo(boolean cancel) {
        this.f23659I0Io = cancel;
    }

    public final Cursor oIX0oI(String condition) {
        if (condition == null) {
            condition = "";
        }
        return this.f23661oIX0oI.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, f23658XO, "title LIKE '%" + condition + "%'", null, "_id");
    }

    public void oxoX(I0Io callBack) {
        oIX0oI oix0oi;
        long currentTimeMillis = System.currentTimeMillis();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor oIX0oI2 = oIX0oI(null);
        oIX0oI2.moveToFirst();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        while (!oIX0oI2.isAfterLast() && !this.f23659I0Io) {
            String string = oIX0oI2.getString(oIX0oI2.getColumnIndex("_data"));
            long j = oIX0oI2.getLong(oIX0oI2.getColumnIndex("_id"));
            oIX0oI oix0oi2 = new oIX0oI(oIX0oI2.getLong(oIX0oI2.getColumnIndex("_id")), oIX0oI2.getString(oIX0oI2.getColumnIndex("_display_name")), oIX0oI2.getString(oIX0oI2.getColumnIndex("album")), oIX0oI2.getInt(oIX0oI2.getColumnIndex("duration")), oIX0oI2.getLong(oIX0oI2.getColumnIndex("_size")), oIX0oI2.getString(oIX0oI2.getColumnIndex("artist")), string, null, 0);
            if (oIX0oI2.getInt(oIX0oI2.getColumnIndex("is_music")) != 0 && oix0oi2.OOXIXo() >= 1000) {
                if (Build.VERSION.SDK_INT > 28) {
                    oix0oi = oix0oi2;
                    oix0oi.xXxxox0I(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(j)).build().toString());
                } else {
                    oix0oi = oix0oi2;
                }
                if (I0Io(oix0oi.x0xO0oo()) && II0xO0(string, mediaMetadataRetriever)) {
                    longSparseArray.put(j, oix0oi);
                    callBack.oIX0oI(oix0oi);
                    oIX0oI2.moveToNext();
                }
            }
            oIX0oI2.moveToNext();
        }
        oIX0oI2.close();
        try {
            mediaMetadataRetriever.release();
        } catch (IOException unused) {
        }
        Cursor cursor = this.f23662oxoX;
        if (cursor != null) {
            cursor.close();
            this.f23662oxoX = null;
        }
        LogUtils.d("加载完成，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }
}
