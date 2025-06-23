package com.szabh.smable3.ota;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ZipUtils;
import com.sifli.siflidfu.DFUImagePath;
import com.sifli.siflidfu.ISifliDFUService;
import com.sifli.siflidfu.SifliDFUService;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.ota.SOTAManager$localBroadcastReceiver$2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes13.dex */
public final class SOTAManager extends com.szabh.smable3.ota.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final X0IIOO f26468II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @oOoXoXO
    public String f26469OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @oOoXoXO
    public ISifliDFUService f26470Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final String f26471X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public SifliDFUService.SifliDFUBinder f26472XO;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final ServiceConnection f26473xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f26474xxIXOIIO;

    /* loaded from: classes13.dex */
    public static final class oIX0oI implements ServiceConnection {
        public oIX0oI() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@OOXIXo ComponentName name, @OOXIXo IBinder service) {
            ISifliDFUService iSifliDFUService;
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(service, "service");
            SOTAManager.this.f26472XO = (SifliDFUService.SifliDFUBinder) service;
            SOTAManager sOTAManager = SOTAManager.this;
            SifliDFUService.SifliDFUBinder sifliDFUBinder = sOTAManager.f26472XO;
            if (sifliDFUBinder != null) {
                iSifliDFUService = sifliDFUBinder.getDfuService();
            } else {
                iSifliDFUService = null;
            }
            sOTAManager.f26470Oxx0IOOO = iSifliDFUService;
            SOTAManager.this.f26474xxIXOIIO = true;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SOTAManager.this.f26471X0o0xo + " onServiceConnected");
            SOTAManager.this.IIXOooo();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@OOXIXo ComponentName name) {
            IIX0o.x0xO0oo(name, "name");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(SOTAManager.this.f26471X0o0xo + " onServiceDisconnected");
            SOTAManager.this.f26474xxIXOIIO = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SOTAManager(@OOXIXo Context context, @OOXIXo I0Io callback) {
        super(context, callback);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        this.f26471X0o0xo = "SOTAManager";
        this.f26468II0XooXoX = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SOTAManager$localBroadcastReceiver$2.AnonymousClass1>() { // from class: com.szabh.smable3.ota.SOTAManager$localBroadcastReceiver$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.szabh.smable3.ota.SOTAManager$localBroadcastReceiver$2$1] */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final AnonymousClass1 invoke() {
                final SOTAManager sOTAManager = SOTAManager.this;
                return new BroadcastReceiver() { // from class: com.szabh.smable3.ota.SOTAManager$localBroadcastReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@OOXIXo Context context2, @OOXIXo Intent intent) {
                        IIX0o.x0xO0oo(context2, "context");
                        IIX0o.x0xO0oo(intent, "intent");
                        String action = intent.getAction();
                        if (action != null) {
                            int hashCode = action.hashCode();
                            if (hashCode != -1936294892) {
                                if (hashCode != 888644493) {
                                    if (hashCode == 1761809728 && action.equals(SifliDFUService.BROADCAST_DFU_LOG)) {
                                        String stringExtra = intent.getStringExtra(SifliDFUService.EXTRA_LOG_MESSAGE);
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(SOTAManager.this.f26471X0o0xo + " BROADCAST_DFU_LOG : " + stringExtra);
                                        return;
                                    }
                                    return;
                                }
                                if (action.equals(SifliDFUService.BROADCAST_DFU_STATE)) {
                                    int intExtra = intent.getIntExtra(SifliDFUService.EXTRA_DFU_STATE, 0);
                                    int intExtra2 = intent.getIntExtra(SifliDFUService.EXTRA_DFU_STATE_RESULT, 0);
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(SOTAManager.this.f26471X0o0xo + " BROADCAST_DFU_STATE result : dfuState=" + intExtra + "  dfuStateResult = " + intExtra2);
                                    if (intExtra == 100) {
                                        if (intExtra2 == 0) {
                                            oIX0oI.oOoXoXO(SOTAManager.this, 6, null, XIXIX.OOXIXo.f3760XO, 6, null);
                                            return;
                                        }
                                        oIX0oI.oOoXoXO(SOTAManager.this, 7, "dfuState=" + intExtra + ", dfuStateResult=" + intExtra2, XIXIX.OOXIXo.f3760XO, 4, null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (action.equals(SifliDFUService.BROADCAST_DFU_PROGRESS)) {
                                int intExtra3 = intent.getIntExtra(SifliDFUService.EXTRA_DFU_PROGRESS, 0);
                                intent.getIntExtra(SifliDFUService.EXTRA_DFU_PROGRESS_TYPE, 0);
                                oIX0oI.oOoXoXO(SOTAManager.this, 5, null, intExtra3 / 100.0d, 2, null);
                            }
                        }
                    }
                };
            }
        });
        this.f26473xoIox = new oIX0oI();
        OxxIIOOXO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void IIXOooo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26471X0o0xo + " start ota process");
        List<File> unzipFile = ZipUtils.unzipFile(this.f26469OOXIXo, PathUtils.getExternalAppCachePath());
        IIX0o.ooOOo0oXI(unzipFile);
        ArrayList<DFUImagePath> Oxx0xo2 = Oxx0xo(unzipFile);
        ISifliDFUService iSifliDFUService = this.f26470Oxx0IOOO;
        if (iSifliDFUService != null) {
            iSifliDFUService.startActionDFUNorExt(I0Io(), II0xO0(), Oxx0xo2, 1, 0);
        }
    }

    public final ArrayList<DFUImagePath> Oxx0xo(List<? extends File> list) {
        int i;
        ArrayList<DFUImagePath> arrayList = new ArrayList<>();
        for (File file : list) {
            Uri fromFile = Uri.fromFile(file);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("getDFUImagePath  path=" + fromFile.getPath() + ",scheme=" + fromFile.getScheme());
            String name = file.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2014123484:
                        if (name.equals("otaFont.bin")) {
                            i = 4;
                            break;
                        }
                        break;
                    case -1426007810:
                        if (name.equals("otaApp.bin")) {
                            i = 0;
                            break;
                        }
                        break;
                    case -676093707:
                        if (name.equals("ctrl_packet.bin")) {
                            i = -1;
                            break;
                        }
                        break;
                    case 464502781:
                        if (name.equals("otaRes.bin")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 1683716375:
                        if (name.equals("otaroot.bin")) {
                            i = 5;
                            break;
                        }
                        break;
                }
            }
            i = -333;
            if (i != -333) {
                arrayList.add(new DFUImagePath(null, fromFile, i));
            }
        }
        return arrayList;
    }

    public final void OxxIIOOXO() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26471X0o0xo + " registerDfuLocalBroadcast");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SifliDFUService.BROADCAST_DFU_LOG);
        intentFilter.addAction(SifliDFUService.BROADCAST_DFU_STATE);
        intentFilter.addAction(SifliDFUService.BROADCAST_DFU_PROGRESS);
        LocalBroadcastManager.getInstance(I0Io()).registerReceiver(oI0IIXIo(), intentFilter);
    }

    @Override // com.szabh.smable3.ota.oIX0oI
    public void X0o0xo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26471X0o0xo + " release ota");
        LocalBroadcastManager.getInstance(I0Io()).unregisterReceiver(oI0IIXIo());
        if (this.f26474xxIXOIIO) {
            I0Io().unbindService(this.f26473xoIox);
            this.f26474xxIXOIIO = false;
        }
    }

    public final BroadcastReceiver oI0IIXIo() {
        return (BroadcastReceiver) this.f26468II0XooXoX.getValue();
    }

    @Override // com.szabh.smable3.ota.oIX0oI
    public void xxIXOIIO(@OOXIXo String filePath, @oOoXoXO String str, boolean z) {
        IIX0o.x0xO0oo(filePath, "filePath");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26471X0o0xo + " startOTA -> " + filePath + ", " + str + ", " + this.f26474xxIXOIIO);
        this.f26469OOXIXo = filePath;
        if (TextUtils.isEmpty(str)) {
            str = BleCache.INSTANCE.getMBleAddress();
        }
        XO(str);
        com.szabh.smable3.ota.oIX0oI.oOoXoXO(this, 1, null, XIXIX.OOXIXo.f3760XO, 6, null);
        I0Io().bindService(new Intent(I0Io(), (Class<?>) SifliDFUService.class), this.f26473xoIox, 1);
    }
}
