package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import android.text.TextUtils;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ListDoubleConverter {
    @OOXIXo
    @TypeConverter
    public final String objectToString(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "list");
        String json = new Gson().toJson(list);
        IIX0o.oO(json, "toJson(...)");
        return json;
    }

    @OOXIXo
    @TypeConverter
    public final List<Double> stringToObject(@OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        Type type = new TypeToken<List<? extends Double>>() { // from class: com.sma.smartv3.db.entity.ListDoubleConverter$stringToObject$listType$1
        }.getType();
        if (TextUtils.isEmpty(value)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Object fromJson = new Gson().fromJson(value, type);
        IIX0o.ooOOo0oXI(fromJson);
        return (List) fromJson;
    }
}
