package com.sma.smartv3.model;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class JsonFieldContainer {
    public final /* synthetic */ <T> T jsonField(String json) {
        IIX0o.x0xO0oo(json, "json");
        try {
            Gson gson = new Gson();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) gson.fromJson(json, (Class) Object.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
