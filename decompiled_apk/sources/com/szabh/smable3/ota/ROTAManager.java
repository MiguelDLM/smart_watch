package com.szabh.smable3.ota;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.text.TextUtils;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.utils.ConnectParams;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.realsil.sdk.dfu.utils.GattDfuAdapter;
import com.szabh.smable3.component.BleCache;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* loaded from: classes13.dex */
public final class ROTAManager extends com.szabh.smable3.ota.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @oOoXoXO
    public DfuConfig f26461II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f26462Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final String f26463X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final X0IIOO f26464XO;

    /* renamed from: xoIox, reason: collision with root package name */
    @oOoXoXO
    public String f26465xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @oOoXoXO
    public OtaDeviceInfo f26466xxIXOIIO;

    @XX({"SMAP\nROTAManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ROTAManager.kt\ncom/szabh/smable3/ota/ROTAManager$mDfuCallback$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class oIX0oI extends DfuAdapter.DfuHelperCallback {
        public oIX0oI() {
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onError(int i, int i2) {
            com.szabh.smable3.ota.oIX0oI.oOoXoXO(ROTAManager.this, 7, "type=" + i + ", code=" + i2, XIXIX.OOXIXo.f3760XO, 4, null);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(int i, @oOoXoXO Throughput throughput) {
            if (i == 258) {
                com.szabh.smable3.ota.oIX0oI.oOoXoXO(ROTAManager.this, 6, null, XIXIX.OOXIXo.f3760XO, 6, null);
            }
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OOXIXo DfuProgressInfo progressInfo) {
            IIX0o.x0xO0oo(progressInfo, "progressInfo");
            com.szabh.smable3.ota.oIX0oI.oOoXoXO(ROTAManager.this, 5, null, progressInfo.getProgress() / 100.0d, 2, null);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(int i) {
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(ROTAManager.this.f26463X0o0xo + " onStateChanged -> state = " + i);
            if (i != 258) {
                if (i != 527) {
                    if (i == 4097) {
                        com.szabh.smable3.ota.oIX0oI.oOoXoXO(ROTAManager.this, 7, "STATE_DISCONNECTED", XIXIX.OOXIXo.f3760XO, 4, null);
                        return;
                    }
                    return;
                }
                com.szabh.smable3.ota.oIX0oI.oOoXoXO(ROTAManager.this, 3, "STATE_DISCONNECTED", XIXIX.OOXIXo.f3760XO, 4, null);
                ROTAManager rOTAManager = ROTAManager.this;
                rOTAManager.f26466xxIXOIIO = rOTAManager.Oxx0xo().getOtaDeviceInfo();
                oix0oi.oIX0oI(ROTAManager.this.f26463X0o0xo + " onStateChanged -> mOtaDeviceInfo = " + ROTAManager.this.f26466xxIXOIIO);
                ROTAManager.this.OxxIIOOXO();
                return;
            }
            String II0xO02 = ROTAManager.this.II0xO0();
            if (II0xO02 != null) {
                ROTAManager.this.oI0IIXIo(II0xO02);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ROTAManager(@OOXIXo Context context, @OOXIXo I0Io callback) {
        super(context, callback);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        this.f26463X0o0xo = "ROTAManager";
        this.f26464XO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.szabh.smable3.ota.ROTAManager$mDfuHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final GattDfuAdapter invoke() {
                return GattDfuAdapter.getInstance(ROTAManager.this.I0Io());
            }
        });
        this.f26462Oxx0IOOO = new oIX0oI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void OxxIIOOXO() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26463X0o0xo + " start ota process");
        DfuConfig dfuConfig = this.f26461II0XooXoX;
        if (dfuConfig != null) {
            dfuConfig.setOtaWorkMode(0);
            dfuConfig.setFilePath(this.f26465xoIox);
            GattDfuAdapter Oxx0xo2 = Oxx0xo();
            if (Oxx0xo2 != null) {
                Oxx0xo2.startOtaProcedure(dfuConfig, this.f26466xxIXOIIO, true);
            }
        }
    }

    public final GattDfuAdapter Oxx0xo() {
        return (GattDfuAdapter) this.f26464XO.getValue();
    }

    @Override // com.szabh.smable3.ota.oIX0oI
    public void X0o0xo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26463X0o0xo + " release ota");
        GattDfuAdapter Oxx0xo2 = Oxx0xo();
        if (Oxx0xo2 != null) {
            Oxx0xo2.abort();
            Oxx0xo2.close();
        }
    }

    public final void oI0IIXIo(String str) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26463X0o0xo + " ota connect " + str);
        Oxx0xo().connectDevice(new ConnectParams.Builder().address(str).reconnectTimes(3).build());
    }

    @Override // com.szabh.smable3.ota.oIX0oI
    public void xxIXOIIO(@OOXIXo String filePath, @oOoXoXO String str, boolean z) {
        IIX0o.x0xO0oo(filePath, "filePath");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26463X0o0xo + " startOTA -> " + filePath + ", " + str);
        this.f26465xoIox = filePath;
        if (TextUtils.isEmpty(str)) {
            str = BleCache.INSTANCE.getMBleAddress();
        }
        XO(str);
        DfuConfig dfuConfig = new DfuConfig();
        dfuConfig.setAddress(II0xO0());
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        dfuConfig.setVersionCheckEnabled(false);
        this.f26461II0XooXoX = dfuConfig;
        com.szabh.smable3.ota.oIX0oI.oOoXoXO(this, 1, null, XIXIX.OOXIXo.f3760XO, 6, null);
        Oxx0xo().initialize(this.f26462Oxx0IOOO);
    }
}
