package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.facebook.appevents.UserDataStore;
import com.kuaishou.weapon.p0.t;
import com.sma.smartv3.ui.me.IXxxXO;
import com.tencent.connect.common.II0xO0;
import java.util.Locale;

/* loaded from: classes10.dex */
public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", t.f18411a).replaceAll("q", t.f18411a).replaceAll("x", t.f18411a).replaceAll(t.c, f.f6163a).replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", "t").replaceAll(UserDataStore.PHONE, "fh").replaceAll("b", "p").replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", "A").replaceAll("[aeiou]", "3").replaceAll("j", "y").replaceAll("^y3", "Y3").replaceAll("^y", "A").replaceAll("y", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", II0xO0.f26892xOOxIO).replaceAll("g", t.f18411a).replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", "3").replaceAll(IAdInterListener.AdReqParam.WIDTH, "2").replaceAll("^h", "A").replaceAll(IAdInterListener.AdReqParam.HEIGHT, "2").replaceAll("r3", "R3").replaceAll("r$", "3").replaceAll("r", "2").replaceAll("l3", IXxxXO.f23351oxoX).replaceAll("l$", "3").replaceAll("l", "2").replaceAll("2", "").replaceAll("3$", "A").replaceAll("3", "") + TEN_1).substring(0, 10);
    }
}
