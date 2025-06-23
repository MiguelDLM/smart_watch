package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.google.gson.Gson;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class JsonField {
    @OOXIXo
    public final String toJson() {
        String json = new Gson().toJson(this);
        IIX0o.oO(json, "toJson(...)");
        return json;
    }
}
