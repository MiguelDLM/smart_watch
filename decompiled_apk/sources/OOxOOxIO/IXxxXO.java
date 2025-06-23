package OOxOOxIO;

import android.content.Context;
import android.text.TextUtils;
import androidx.media2.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class IXxxXO implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public x0xO0oo f1824IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1825Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public RewardVideoADListener f1826Oxx0xo = new oIX0oI();

    /* renamed from: XO, reason: collision with root package name */
    public RewardVideoAD f1827XO;

    /* JADX INFO: Access modifiers changed from: private */
    public void II0XooXoX() {
        if (this.f1825Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            oIX0oI();
            create.add(50005, this.f1824IXxxXO);
            this.f1825Oo.call(60000, create.build(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OOXIXo() {
        if (this.f1825Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            oIX0oI();
            create.add(50005, this.f1824IXxxXO);
            this.f1825Oo.call(60003, create.build(), null);
        }
    }

    private void Oxx0IOOO(String str, String str2) {
        RewardVideoAD rewardVideoAD;
        OxxIIOOXO.oIX0oI("setServerSideVerificationOptions userId = " + str + " customStr = " + str2);
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        if (str != null) {
            builder.setUserId(str);
        }
        if (str2 != null) {
            builder.setCustomData(str2);
        }
        if ((str != null || !TextUtils.isEmpty(str2)) && (rewardVideoAD = this.f1827XO) != null) {
            rewardVideoAD.setServerSideVerificationOptions(builder.build());
        }
    }

    private void X0o0xo(Bridge bridge) {
        OxxIIOOXO.oIX0oI("load ad bridge = " + bridge);
        RewardVideoAD rewardVideoAD = this.f1827XO;
        if (rewardVideoAD != null) {
            this.f1825Oo = bridge;
            rewardVideoAD.loadAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XO(AdError adError) {
        if (this.f1825Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1825Oo.call(60001, create.build(), null);
        }
    }

    private void oIX0oI() {
        if (this.f1824IXxxXO == null) {
            this.f1824IXxxXO = new x0xO0oo(this.f1827XO);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40000) {
            oxoX((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class), !valueSet.booleanValue(50001), (String) valueSet.objectValue(50002, String.class));
            return null;
        }
        if (i == 40001) {
            Oxx0IOOO((String) valueSet.objectValue(50003, String.class), (String) valueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, String.class));
            return null;
        }
        if (i == 40002) {
            X0o0xo((Bridge) valueSet.objectValue(10004, Bridge.class));
            return null;
        }
        return null;
    }

    public final void oxoX(Context context, String str, boolean z, String str2) {
        OxxIIOOXO.oIX0oI("createRewardVideoAd context = " + context + " adnId = " + str + " volumeOn = " + z + " adm = " + str2);
        if (context != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.f1827XO = new RewardVideoAD(context, str, this.f1826Oxx0xo, z, str2);
            } else {
                this.f1827XO = new RewardVideoAD(context, str, this.f1826Oxx0xo, z);
            }
            if (!Thread.currentThread().getName().equals("gm_t_main")) {
                xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements RewardVideoADListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            OxxIIOOXO.oIX0oI("adn onADClick");
            if (IXxxXO.this.f1824IXxxXO != null) {
                IXxxXO.this.f1824IXxxXO.oxoX();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            OxxIIOOXO.oIX0oI("adn onADClose");
            if (IXxxXO.this.f1824IXxxXO != null) {
                IXxxXO.this.f1824IXxxXO.Oxx0IOOO();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            OxxIIOOXO.oIX0oI("adn onADLoad");
            IXxxXO.this.II0XooXoX();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            OxxIIOOXO.oIX0oI("adn onADShow");
            if (IXxxXO.this.f1824IXxxXO != null) {
                IXxxXO.this.f1824IXxxXO.oIX0oI();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            OxxIIOOXO.oIX0oI("adnOnError adError = " + adError);
            IXxxXO.this.XO(adError);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            OxxIIOOXO.oIX0oI("adn onReward map = " + map);
            if (IXxxXO.this.f1824IXxxXO != null) {
                IXxxXO.this.f1824IXxxXO.I0Io(map);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            OxxIIOOXO.oIX0oI("adn onVideoCached");
            IXxxXO.this.OOXIXo();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            OxxIIOOXO.oIX0oI("adn onVideoComplete");
            if (IXxxXO.this.f1824IXxxXO != null) {
                IXxxXO.this.f1824IXxxXO.XO();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
        }
    }
}
