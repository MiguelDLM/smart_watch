package II0XooXoX;

import com.alibaba.aliagentsdk.domain.Sid;
import com.baidu.nplatform.comapi.MapItem;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final /* synthetic */ int f222oIX0oI = 0;

    static {
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
    }

    public static byte[] II0xO0(String str, String str2) {
        try {
            String jSONStringer = new JSONStringer().object().key(MapItem.KEY_ITEM_SID).value(str).key("data").value(str2).key("ver").value(1L).endObject().toString();
            XO.II0xO0("DataUtils", "target to bt data json ==> " + jSONStringer);
            return jSONStringer.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] oIX0oI(byte b) {
        byte[] bArr = {3, 1, 0, 85};
        bArr[3] = b;
        String oIX0oI2 = oxoX.oIX0oI(bArr);
        XO.II0xO0("DataUtils", "encodeStr ==> " + oIX0oI2);
        return II0xO0(Sid.FND, oIX0oI2);
    }
}
