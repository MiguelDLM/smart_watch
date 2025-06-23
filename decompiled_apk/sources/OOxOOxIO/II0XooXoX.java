package OOxOOxIO;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.qq.e.comm.util.AdError;

/* loaded from: classes6.dex */
public class II0XooXoX implements Bridge {

    /* renamed from: XO, reason: collision with root package name */
    public AdError f1811XO;

    public II0XooXoX(AdError adError) {
        this.f1811XO = adError;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        int i2;
        if (i == 40005) {
            AdError adError = this.f1811XO;
            if (adError != null) {
                i2 = adError.getErrorCode();
            } else {
                i2 = 0;
            }
            return (T) Integer.valueOf(i2);
        }
        if (i == 40006) {
            AdError adError2 = this.f1811XO;
            if (adError2 != null) {
                return (T) adError2.getErrorMsg();
            }
            return "";
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
