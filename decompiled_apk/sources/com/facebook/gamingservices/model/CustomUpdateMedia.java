package com.facebook.gamingservices.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class CustomUpdateMedia {

    @oOoXoXO
    private final CustomUpdateMediaInfo gif;

    @oOoXoXO
    private final CustomUpdateMediaInfo video;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomUpdateMedia() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomUpdateMedia copy$default(CustomUpdateMedia customUpdateMedia, CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            customUpdateMediaInfo = customUpdateMedia.gif;
        }
        if ((i & 2) != 0) {
            customUpdateMediaInfo2 = customUpdateMedia.video;
        }
        return customUpdateMedia.copy(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    @oOoXoXO
    public final CustomUpdateMediaInfo component1() {
        return this.gif;
    }

    @oOoXoXO
    public final CustomUpdateMediaInfo component2() {
        return this.video;
    }

    @OOXIXo
    public final CustomUpdateMedia copy(@oOoXoXO CustomUpdateMediaInfo customUpdateMediaInfo, @oOoXoXO CustomUpdateMediaInfo customUpdateMediaInfo2) {
        return new CustomUpdateMedia(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateMedia)) {
            return false;
        }
        CustomUpdateMedia customUpdateMedia = (CustomUpdateMedia) obj;
        return IIX0o.Oxx0IOOO(this.gif, customUpdateMedia.gif) && IIX0o.Oxx0IOOO(this.video, customUpdateMedia.video);
    }

    @oOoXoXO
    public final CustomUpdateMediaInfo getGif() {
        return this.gif;
    }

    @oOoXoXO
    public final CustomUpdateMediaInfo getVideo() {
        return this.video;
    }

    public int hashCode() {
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        int hashCode = (customUpdateMediaInfo == null ? 0 : customUpdateMediaInfo.hashCode()) * 31;
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        return hashCode + (customUpdateMediaInfo2 != null ? customUpdateMediaInfo2.hashCode() : 0);
    }

    @OOXIXo
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        if (customUpdateMediaInfo != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", customUpdateMediaInfo.getUrl());
            jSONObject.put("gif", jSONObject2);
        }
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", customUpdateMediaInfo2.getUrl());
            jSONObject.put("video", jSONObject3);
        }
        return jSONObject;
    }

    @OOXIXo
    public String toString() {
        return "CustomUpdateMedia(gif=" + this.gif + ", video=" + this.video + HexStringBuilder.COMMENT_END_CHAR;
    }

    public CustomUpdateMedia(@oOoXoXO CustomUpdateMediaInfo customUpdateMediaInfo, @oOoXoXO CustomUpdateMediaInfo customUpdateMediaInfo2) {
        this.gif = customUpdateMediaInfo;
        this.video = customUpdateMediaInfo2;
    }

    public /* synthetic */ CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : customUpdateMediaInfo, (i & 2) != 0 ? null : customUpdateMediaInfo2);
    }
}
