package OIoxIx;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.aw;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f1653I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f1654II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f1655Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f1656X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f1657XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f1658oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f1659oxoX;

    public I0Io(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f1658oIX0oI = jSONObject.getInt("dataScale");
                if (jSONObject.has("key")) {
                    this.f1654II0xO0 = jSONObject.getString("key");
                }
                if (jSONObject.has("calcType")) {
                    this.f1653I0Io = jSONObject.getString("calcType");
                }
                this.f1659oxoX = jSONObject.getString("deviceMac");
                this.f1656X0o0xo = jSONObject.getInt("deviceSubType");
                this.f1657XO = jSONObject.getInt(aw.e);
                this.f1655Oxx0IOOO = jSONObject.getInt("deviceVendor");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I0Io)) {
            return false;
        }
        I0Io i0Io = (I0Io) obj;
        if (this.f1656X0o0xo == i0Io.f1656X0o0xo && this.f1657XO == i0Io.f1657XO && this.f1655Oxx0IOOO == i0Io.f1655Oxx0IOOO && this.f1654II0xO0.equals(i0Io.f1654II0xO0)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "DeviceInfo{dataScale=" + this.f1658oIX0oI + ", key='" + this.f1654II0xO0 + "', calcType='" + this.f1653I0Io + "', deviceMac='" + this.f1659oxoX + "', deviceSubType=" + this.f1656X0o0xo + ", deviceType=" + this.f1657XO + ", deviceVendor=" + this.f1655Oxx0IOOO + '}';
    }
}
