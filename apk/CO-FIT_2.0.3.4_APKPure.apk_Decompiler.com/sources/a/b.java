package a;

import II0XooXoX.XO;
import com.alibaba.aliagentsdk.callback.ISend2LpCallback;

public class b implements ISend2LpCallback {
    public b(a aVar) {
    }

    public void onSendFailed(int i, String str, int i2) {
        XO.II0xO0("DefaultDataHandler", "send　CCM failed ===> " + i + " msg ==> " + str + " code ==> " + i2);
    }

    public void onSendSuccess(int i) {
        XO.II0xO0("DefaultDataHandler", "send CCM success in id2.");
    }
}
