package com.sma.smartv3.util;

import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class IXxxXO extends TypeAdapter<float[]> {

    /* loaded from: classes12.dex */
    public class oIX0oI extends TypeToken<List<float[]>> {
    }

    public static List<float[]> oIX0oI(String jsonString) {
        return (List) new GsonBuilder().registerTypeAdapter(float[].class, new IXxxXO()).create().fromJson(jsonString, new oIX0oI().getType());
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter out, float[] value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginArray();
        for (float f : value) {
            out.value(f);
        }
        out.endArray();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public float[] read2(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        in.beginArray();
        while (in.hasNext()) {
            arrayList.add(Float.valueOf(Float.parseFloat("" + in.nextDouble())));
        }
        in.endArray();
        float[] fArr = new float[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            fArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        return fArr;
    }
}
