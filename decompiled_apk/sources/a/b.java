package a;

import II0XooXoX.XO;
import com.alibaba.aliagentsdk.callback.ISend2LpCallback;

/* loaded from: classes.dex */
public class b implements ISend2LpCallback {
    public b(a aVar) {
    }

    @Override // com.alibaba.aliagentsdk.callback.ISend2LpCallback
    public void onSendFailed(int i, String str, int i2) {
        XO.II0xO0("DefaultDataHandler", "send\u3000CCM failed ===> " + i + " msg ==> " + str + " code ==> " + i2);
    }

    @Override // com.alibaba.aliagentsdk.callback.ISend2LpCallback
    public void onSendSuccess(int i) {
        XO.II0xO0("DefaultDataHandler", "send CCM success in id2.");
    }
}
