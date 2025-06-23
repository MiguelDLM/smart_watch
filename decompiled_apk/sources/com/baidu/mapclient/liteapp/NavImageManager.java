package com.baidu.mapclient.liteapp;

import OXOo.OOXIXo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapclient.liteapp.NavImageManager$mReceiver$2;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.Utils;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleNaviImage;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class NavImageManager {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private boolean isSyncing;

    @OOXIXo
    private final NavImageManager$mBleHandleCallback$1 mBleHandleCallback;

    @OOXIXo
    private final String TAG = "NavImageManager";

    @OOXIXo
    private final X0IIOO mReceiver$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NavImageManager$mReceiver$2.AnonymousClass1>() { // from class: com.baidu.mapclient.liteapp.NavImageManager$mReceiver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.mapclient.liteapp.NavImageManager$mReceiver$2$1] */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final AnonymousClass1 invoke() {
            final NavImageManager navImageManager = NavImageManager.this;
            return new BroadcastReceiver() { // from class: com.baidu.mapclient.liteapp.NavImageManager$mReceiver$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@OOXIXo Context context, @OOXIXo Intent intent) {
                    String str;
                    String str2;
                    String str3;
                    IIX0o.x0xO0oo(context, "context");
                    IIX0o.x0xO0oo(intent, "intent");
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    StringBuilder sb = new StringBuilder();
                    str = NavImageManager.this.TAG;
                    sb.append(str);
                    sb.append(" receiver -> ");
                    sb.append(intent);
                    oix0oi.oIX0oI(sb.toString());
                    String action = intent.getAction();
                    if (action != null) {
                        int hashCode = action.hashCode();
                        if (hashCode != -2128145023) {
                            if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                                StringBuilder sb2 = new StringBuilder();
                                str3 = NavImageManager.this.TAG;
                                sb2.append(str3);
                                sb2.append(" receiver -> ACTION_SCREEN_ON");
                                oix0oi.oIX0oI(sb2.toString());
                                return;
                            }
                            return;
                        }
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            StringBuilder sb3 = new StringBuilder();
                            str2 = NavImageManager.this.TAG;
                            sb3.append(str2);
                            sb3.append(" receiver -> ACTION_SCREEN_OFF");
                            oix0oi.oIX0oI(sb3.toString());
                        }
                    }
                }
            };
        }
    });

    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final boolean isSupportNavImage() {
            BleCache bleCache = BleCache.INSTANCE;
            String mFirmwareFlag = bleCache.getMFirmwareFlag();
            int hashCode = mFirmwareFlag.hashCode();
            if (hashCode != -1985244648) {
                if (hashCode != -1982474085) {
                    if (hashCode == -599721284 && mFirmwareFlag.equals("AC05W_C033")) {
                        return false;
                    }
                } else if (mFirmwareFlag.equals("AC05W_C035_S09")) {
                    return false;
                }
            } else if (mFirmwareFlag.equals("AC05W_C032_S09")) {
                return false;
            }
            if (bleCache.getMSupportNavImage() != 1) {
                return false;
            }
            return true;
        }

        private Companion() {
        }
    }

    public NavImageManager() {
        NavImageManager$mBleHandleCallback$1 navImageManager$mBleHandleCallback$1 = new NavImageManager$mBleHandleCallback$1(this);
        this.mBleHandleCallback = navImageManager$mBleHandleCallback$1;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("NavImageManager -> init");
        this.isSyncing = false;
        BleConnector.INSTANCE.addHandleCallback(navImageManager$mBleHandleCallback$1);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        Utils.getApp().registerReceiver(getMReceiver(), intentFilter);
    }

    private final NavImageManager$mReceiver$2.AnonymousClass1 getMReceiver() {
        return (NavImageManager$mReceiver$2.AnonymousClass1) this.mReceiver$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendNavImage$lambda$0(NavImageManager this$0, String guideText, NavType type, Bitmap bitmap) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(guideText, "$guideText");
        IIX0o.x0xO0oo(type, "$type");
        try {
            if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
                NavGuideImage navGuideImage = new NavGuideImage();
                IIX0o.ooOOo0oXI(bitmap);
                if (TextUtils.isEmpty(guideText)) {
                    guideText = "开始导航";
                }
                byte[] navGuideByteArray = navGuideImage.getNavGuideByteArray(navGuideImage.getNavGuideBitmap(bitmap, guideText, type, SizeUtils.dp2px(100.0f)));
                if (navGuideByteArray != null) {
                    BleConnector.sendStream$default(BleConnector.INSTANCE, BleKey.NAVI_IMAGE, new BleNaviImage(navGuideByteArray).toByteArray(), 0, 4, (Object) null);
                    return;
                }
                return;
            }
            this$0.isSyncing = false;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> snapshot bitmap error");
        } catch (Exception e) {
            e.printStackTrace();
            this$0.isSyncing = false;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " -> snapshot bitmap error: " + e.getMessage());
        }
    }

    public final void destroy() {
        this.isSyncing = false;
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
        Utils.getApp().unregisterReceiver(getMReceiver());
    }

    public final void sendNavImage(@OOXIXo BaiduMap map, @OOXIXo final String guideText, @OOXIXo final NavType type) {
        IIX0o.x0xO0oo(map, "map");
        IIX0o.x0xO0oo(guideText, "guideText");
        IIX0o.x0xO0oo(type, "type");
        if (!this.isSyncing && BleConnector.INSTANCE.isAvailable()) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> sendNavImage " + type + ", " + guideText);
            this.isSyncing = true;
            map.snapshot(new BaiduMap.SnapshotReadyCallback() { // from class: com.baidu.mapclient.liteapp.I0Io
                @Override // com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) {
                    NavImageManager.sendNavImage$lambda$0(NavImageManager.this, guideText, type, bitmap);
                }
            });
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> can not sendNavImage");
    }
}
