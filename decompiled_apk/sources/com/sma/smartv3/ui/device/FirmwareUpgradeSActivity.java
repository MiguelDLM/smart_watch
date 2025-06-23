package com.sma.smartv3.ui.device;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.ZipUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.sifli.siflidfu.DFUImagePath;
import com.sifli.siflidfu.ISifliDFUService;
import com.sifli.siflidfu.SifliDFUService;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.FirmwareUpgradeSActivity$localBroadcastReceiver$2;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.ProgressButton;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareUpgradeSActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareUpgradeSActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeSActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,298:1\n15#2:299\n15#2:300\n*S KotlinDebug\n*F\n+ 1 FirmwareUpgradeSActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeSActivity\n*L\n209#1:299\n210#1:300\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareUpgradeSActivity extends BaseFirmwareUpgradeActivity {
    private boolean isBound;
    private int lastProgress;

    @OXOo.oOoXoXO
    private SifliDFUService.SifliDFUBinder mBinder;

    @OXOo.oOoXoXO
    private String mFilePath;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatest;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware;

    @OXOo.oOoXoXO
    private ISifliDFUService sifliDFUService;

    @OXOo.OOXIXo
    private final String TAG = "UpgradeS";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO localBroadcastReceiver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FirmwareUpgradeSActivity$localBroadcastReceiver$2.AnonymousClass1>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeSActivity$localBroadcastReceiver$2

        /* renamed from: com.sma.smartv3.ui.device.FirmwareUpgradeSActivity$localBroadcastReceiver$2$1, reason: invalid class name */
        /* loaded from: classes12.dex */
        public static final class AnonymousClass1 extends BroadcastReceiver {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ FirmwareUpgradeSActivity f21878oIX0oI;

            public AnonymousClass1(FirmwareUpgradeSActivity firmwareUpgradeSActivity) {
                this.f21878oIX0oI = firmwareUpgradeSActivity;
            }

            public static final void I0Io(FirmwareUpgradeSActivity this$0, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                this$0.getTvTip().setText(this$0.getString(R.string.starting));
                this$0.getProgressButton().setProgress(i / 100.0f);
            }

            public static final void oxoX(int i, FirmwareUpgradeSActivity this$0) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                if (i != 0) {
                    if (i != 63) {
                        this$0.getTvTip().setText(this$0.getString(R.string.firmware_upgrading_failed) + "  error=" + i);
                        ProgressButton.X0o0xo(this$0.getProgressButton(), R.string.firmware_upgrading_failed, false, 2, null);
                        if (this$0.isAutoUpdate()) {
                            this$0.finish();
                            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, Integer.valueOf(i));
                        }
                        BaseFirmwareUpgradeActivity.uploadOtaRecord$default(this$0, "-1", "dfuStateResult = " + i, null, null, null, 28, null);
                    } else {
                        this$0.getTvTip().setText(this$0.getString(R.string.firmware_upgrading_failed));
                        String string = this$0.getString(R.string.request_bluetooth_permission_denied_tip);
                        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                        ToastUtils.showLong(string, new Object[0]);
                        if (this$0.isAutoUpdate()) {
                            this$0.finish();
                            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, string);
                        }
                        BaseFirmwareUpgradeActivity.uploadOtaRecord$default(this$0, "-1", "dfuStateResult = " + i, null, null, null, 28, null);
                    }
                } else {
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
                    ToastUtils.showLong(R.string.upgrade_successful);
                    this$0.finish();
                    if (this$0.isAutoUpdate()) {
                        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, "done");
                    }
                    BaseFirmwareUpgradeActivity.uploadOtaRecord$default(this$0, "0", null, null, null, null, 30, null);
                }
                this$0.setMStarted(false);
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
                int i;
                kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
                kotlin.jvm.internal.IIX0o.x0xO0oo(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1936294892) {
                        if (hashCode != 888644493) {
                            if (hashCode == 1761809728 && action.equals(SifliDFUService.BROADCAST_DFU_LOG)) {
                                String stringExtra = intent.getStringExtra(SifliDFUService.EXTRA_LOG_MESSAGE);
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f21878oIX0oI.TAG + " DFU LOG - " + stringExtra);
                                return;
                            }
                            return;
                        }
                        if (action.equals(SifliDFUService.BROADCAST_DFU_STATE)) {
                            int intExtra = intent.getIntExtra(SifliDFUService.EXTRA_DFU_STATE, 0);
                            final int intExtra2 = intent.getIntExtra(SifliDFUService.EXTRA_DFU_STATE_RESULT, 0);
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f21878oIX0oI.TAG + " BROADCAST_DFU_STATE result : dfuState=" + intExtra + "  dfuStateResult = " + intExtra2);
                            if (intExtra != 7) {
                                if (intExtra == 100) {
                                    final FirmwareUpgradeSActivity firmwareUpgradeSActivity = this.f21878oIX0oI;
                                    ThreadUtils.runOnUiThread(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a3: INVOKE 
                                          (wrap:java.lang.Runnable:0x00a0: CONSTRUCTOR 
                                          (r5v6 'intExtra2' int A[DONT_INLINE])
                                          (r4v11 'firmwareUpgradeSActivity' com.sma.smartv3.ui.device.FirmwareUpgradeSActivity A[DONT_INLINE])
                                         A[MD:(int, com.sma.smartv3.ui.device.FirmwareUpgradeSActivity):void (m), WRAPPED] (LINE:161) call: com.sma.smartv3.ui.device.Ix00oIoI.<init>(int, com.sma.smartv3.ui.device.FirmwareUpgradeSActivity):void type: CONSTRUCTOR)
                                         STATIC call: com.blankj.utilcode.util.ThreadUtils.runOnUiThread(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (m)] (LINE:164) in method: com.sma.smartv3.ui.device.FirmwareUpgradeSActivity$localBroadcastReceiver$2.1.onReceive(android.content.Context, android.content.Intent):void, file: classes12.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.Ix00oIoI, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 59 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "context"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                                        java.lang.String r4 = "intent"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                                        java.lang.String r4 = r5.getAction()
                                        if (r4 == 0) goto Lfe
                                        int r0 = r4.hashCode()
                                        r1 = -1936294892(0xffffffff8c967c14, float:-2.3185836E-31)
                                        r2 = 0
                                        if (r0 == r1) goto Lb4
                                        r1 = 888644493(0x34f7a38d, float:4.6126334E-7)
                                        if (r0 == r1) goto L57
                                        r1 = 1761809728(0x69031540, float:9.904352E24)
                                        if (r0 == r1) goto L26
                                        goto Lfe
                                    L26:
                                        java.lang.String r0 = "com.sifli.siflidfu.BROADCAST_DFU_LOG"
                                        boolean r4 = r4.equals(r0)
                                        if (r4 != 0) goto L30
                                        goto Lfe
                                    L30:
                                        java.lang.String r4 = "com.sifli.siflidfu.EXTRA_LOG_MESSAGE"
                                        java.lang.String r4 = r5.getStringExtra(r4)
                                        OI0.oIX0oI r5 = OI0.oIX0oI.f1507oIX0oI
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r1 = r3.f21878oIX0oI
                                        java.lang.String r1 = com.sma.smartv3.ui.device.FirmwareUpgradeSActivity.access$getTAG$p(r1)
                                        r0.append(r1)
                                        java.lang.String r1 = " DFU LOG - "
                                        r0.append(r1)
                                        r0.append(r4)
                                        java.lang.String r4 = r0.toString()
                                        r5.oIX0oI(r4)
                                        goto Lfe
                                    L57:
                                        java.lang.String r0 = "com.sifli.siflidfu.BROADCAST_DFU_STATE"
                                        boolean r4 = r4.equals(r0)
                                        if (r4 != 0) goto L61
                                        goto Lfe
                                    L61:
                                        java.lang.String r4 = "com.sifli.siflidfu.EXTRA_DFU_STATE"
                                        int r4 = r5.getIntExtra(r4, r2)
                                        java.lang.String r0 = "com.sifli.siflidfu.EXTRA_DFU_STATE_RESULT"
                                        int r5 = r5.getIntExtra(r0, r2)
                                        OI0.oIX0oI r0 = OI0.oIX0oI.f1507oIX0oI
                                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                        r1.<init>()
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r2 = r3.f21878oIX0oI
                                        java.lang.String r2 = com.sma.smartv3.ui.device.FirmwareUpgradeSActivity.access$getTAG$p(r2)
                                        r1.append(r2)
                                        java.lang.String r2 = " BROADCAST_DFU_STATE result : dfuState="
                                        r1.append(r2)
                                        r1.append(r4)
                                        java.lang.String r2 = "  dfuStateResult = "
                                        r1.append(r2)
                                        r1.append(r5)
                                        java.lang.String r1 = r1.toString()
                                        r0.oIX0oI(r1)
                                        r0 = 7
                                        if (r4 == r0) goto La7
                                        r0 = 100
                                        if (r4 == r0) goto L9c
                                        goto Lfe
                                    L9c:
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r4 = r3.f21878oIX0oI
                                        com.sma.smartv3.ui.device.Ix00oIoI r0 = new com.sma.smartv3.ui.device.Ix00oIoI
                                        r0.<init>(r5, r4)
                                        com.blankj.utilcode.util.ThreadUtils.runOnUiThread(r0)
                                        goto Lfe
                                    La7:
                                        com.sma.smartv3.util.Xo0 r4 = com.sma.smartv3.util.Xo0.f24349oIX0oI
                                        com.blankj.utilcode.util.SPUtils r4 = r4.II0xO0()
                                        java.lang.String r5 = "firmware_upgrade_failed"
                                        r0 = 1
                                        r4.put(r5, r0)
                                        goto Lfe
                                    Lb4:
                                        java.lang.String r0 = "com.sifli.siflidfu.EXTRA_BROADCAST_PROGRESS"
                                        boolean r4 = r4.equals(r0)
                                        if (r4 != 0) goto Lbd
                                        goto Lfe
                                    Lbd:
                                        java.lang.String r4 = "com.sifli.siflidfu.EXTRA_DFU_PROGRESS"
                                        int r4 = r5.getIntExtra(r4, r2)
                                        java.lang.String r0 = "com.sifli.siflidfu.EXTRA_DFU_PROGRESS_TYPE"
                                        r5.getIntExtra(r0, r2)
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r5 = r3.f21878oIX0oI
                                        int r5 = com.sma.smartv3.ui.device.FirmwareUpgradeSActivity.access$getLastProgress$p(r5)
                                        if (r4 == r5) goto Lfe
                                        OI0.oIX0oI r5 = OI0.oIX0oI.f1507oIX0oI
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r1 = r3.f21878oIX0oI
                                        java.lang.String r1 = com.sma.smartv3.ui.device.FirmwareUpgradeSActivity.access$getTAG$p(r1)
                                        r0.append(r1)
                                        java.lang.String r1 = " progress - "
                                        r0.append(r1)
                                        r0.append(r4)
                                        java.lang.String r0 = r0.toString()
                                        r5.oIX0oI(r0)
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r5 = r3.f21878oIX0oI
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity.access$setLastProgress$p(r5, r4)
                                        com.sma.smartv3.ui.device.FirmwareUpgradeSActivity r5 = r3.f21878oIX0oI
                                        com.sma.smartv3.ui.device.oI r0 = new com.sma.smartv3.ui.device.oI
                                        r0.<init>(r5, r4)
                                        com.blankj.utilcode.util.ThreadUtils.runOnUiThread(r0)
                                    Lfe:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.FirmwareUpgradeSActivity$localBroadcastReceiver$2.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
                                }
                            }

                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final AnonymousClass1 invoke() {
                                return new AnonymousClass1(FirmwareUpgradeSActivity.this);
                            }
                        });

                        @OXOo.OOXIXo
                        private final ServiceConnection serviceConnection = new oIX0oI();

                        @OXOo.OOXIXo
                        private final String mCurrent = BleCache.getString$default(BleCache.INSTANCE, BleKey.FIRMWARE_VERSION, null, null, 6, null);

                        /* loaded from: classes12.dex */
                        public static final class oIX0oI implements ServiceConnection {
                            public oIX0oI() {
                            }

                            @Override // android.content.ServiceConnection
                            public void onServiceConnected(@OXOo.OOXIXo ComponentName name, @OXOo.OOXIXo IBinder service) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(service, "service");
                                FirmwareUpgradeSActivity.this.mBinder = (SifliDFUService.SifliDFUBinder) service;
                                FirmwareUpgradeSActivity firmwareUpgradeSActivity = FirmwareUpgradeSActivity.this;
                                SifliDFUService.SifliDFUBinder sifliDFUBinder = firmwareUpgradeSActivity.mBinder;
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(sifliDFUBinder);
                                firmwareUpgradeSActivity.sifliDFUService = sifliDFUBinder.getDfuService();
                                FirmwareUpgradeSActivity.this.isBound = true;
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeSActivity.this.TAG + " onServiceConnected");
                            }

                            @Override // android.content.ServiceConnection
                            public void onServiceDisconnected(@OXOo.OOXIXo ComponentName name) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeSActivity.this.TAG + " onServiceDisconnected");
                                FirmwareUpgradeSActivity.this.isBound = false;
                            }
                        }

                        public FirmwareUpgradeSActivity() {
                            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                            this.mLatest = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
                            this.mLatestFirmware = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
                        }

                        private final BroadcastReceiver getLocalBroadcastReceiver() {
                            return (BroadcastReceiver) this.localBroadcastReceiver$delegate.getValue();
                        }

                        private final void registerDfuLocalBroadcast() {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(SifliDFUService.BROADCAST_DFU_LOG);
                            intentFilter.addAction(SifliDFUService.BROADCAST_DFU_STATE);
                            intentFilter.addAction(SifliDFUService.BROADCAST_DFU_PROGRESS);
                            LocalBroadcastManager.getInstance(getBaseContext()).registerReceiver(getLocalBroadcastReceiver(), intentFilter);
                        }

                        public final void checkFirmware() {
                            if (isAutoUpdate()) {
                                FirmwareVersion firmwareVersion = this.mLatestFirmware;
                                if (firmwareVersion == null) {
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " isAutoUpdate = " + isAutoUpdate() + "  checkFirmware  mLatestFirmware = null ");
                                    finish();
                                    com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, "mLatestFirmware = null");
                                    return;
                                }
                                getTvTip().setText(getString(R.string.preparing));
                                ProgressButton.X0o0xo(getProgressButton(), R.string.preparing, false, 2, null);
                                download(firmwareVersion);
                                return;
                            }
                            FirmwareVersion firmwareVersion2 = this.mLatest;
                            if (firmwareVersion2 != null) {
                                getTvTip().setText(getString(R.string.preparing));
                                ProgressButton.X0o0xo(getProgressButton(), R.string.preparing, false, 2, null);
                                download(firmwareVersion2);
                            }
                        }

                        public final void download(@OXOo.OOXIXo FirmwareVersion firmwareVersion) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " download " + firmwareVersion);
                            StringBuilder sb = new StringBuilder();
                            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                            sb.append(com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi));
                            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                            sb.append(firmwareVersion.getFileName());
                            this.mFilePath = sb.toString();
                            NetWorkUtils.INSTANCE.download(firmwareVersion.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi), firmwareVersion.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeSActivity$download$1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeSActivity.this.TAG + " download firmware error -> " + error);
                                    FirmwareUpgradeSActivity.this.getTvTip().setText(String.valueOf(FirmwareUpgradeSActivity.this.getString(R.string.request_error)));
                                    FirmwareUpgradeSActivity.this.setMStarted(false);
                                }

                                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                                public void handleProgress(int i) {
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO String str) {
                                    FirmwareUpgradeSActivity.this.upgrade();
                                }
                            });
                        }

                        @Override // com.bestmafen.androidbase.base.oIX0oI
                        public void init(@OXOo.oOoXoXO Bundle bundle) {
                            registerDfuLocalBroadcast();
                            bindService(new Intent(this, (Class<?>) SifliDFUService.class), this.serviceConnection, 1);
                        }

                        @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.oIX0oI
                        public void initView() {
                            super.initView();
                            if (this.mLatest == null) {
                                getTvLatest().setText(getString(R.string.v_s, this.mCurrent));
                                ViewParent parent = getTvCurrent().getParent();
                                kotlin.jvm.internal.IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                                ((ViewGroup) parent).setVisibility(8);
                                getProgressButton().setVisibility(8);
                            } else {
                                setMCurrentVersion(this.mCurrent);
                                setMTargetVersion(this.mLatest.getVersion());
                                getTvLatest().setText(getString(R.string.v_s, getMTargetVersion()));
                                getTvCurrent().setText(getString(R.string.v_s, getMCurrentVersion()));
                            }
                            if (isAutoUpdate()) {
                                checkFirmware();
                            }
                        }

                        @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, androidx.activity.ComponentActivity, android.app.Activity
                        public void onBackPressed() {
                            if (getMStarted()) {
                                return;
                            }
                            super.onBackPressed();
                        }

                        public final void onBottomClick(@OXOo.OOXIXo View view) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                            checkFirmware();
                        }

                        @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
                        public void onDestroy() {
                            BleConnector.INSTANCE.launch();
                            LocalBroadcastManager.getInstance(getBaseContext()).unregisterReceiver(getLocalBroadcastReceiver());
                            if (this.isBound) {
                                unbindService(this.serviceConnection);
                                this.isBound = false;
                            }
                            if (com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false)) {
                                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.XoI0Ixx0.f24419XO, null, 2, null);
                            }
                            super.onDestroy();
                        }

                        public final void startOTA(@OXOo.OOXIXo String zipFilePath, @OXOo.OOXIXo String destDirPath) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(zipFilePath, "zipFilePath");
                            kotlin.jvm.internal.IIX0o.x0xO0oo(destDirPath, "destDirPath");
                            List<File> unzipFile = ZipUtils.unzipFile(zipFilePath, destDirPath);
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(unzipFile);
                            ArrayList<DFUImagePath> oxoX2 = UtilsKt.oxoX(unzipFile);
                            String mBleAddress = BleCache.INSTANCE.getMBleAddress();
                            if (mBleAddress != null && mBleAddress.length() != 0) {
                                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24456oo, mBleAddress);
                            } else {
                                mBleAddress = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24456oo);
                                kotlin.jvm.internal.IIX0o.oO(mBleAddress, "getString(...)");
                            }
                            String str = mBleAddress;
                            ISifliDFUService iSifliDFUService = this.sifliDFUService;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(iSifliDFUService);
                            iSifliDFUService.startActionDFUNorExt(this, str, oxoX2, 1, 0);
                            setMStarted(true);
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " mStarted = " + getMStarted());
                        }

                        public final void upgrade() {
                            String str = this.mFilePath;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
                            if (!kotlin.text.OxI.XO0o(str, "zip", false, 2, null)) {
                                ToastUtils.showLong("文件格式选择错误 请选择zip格式", new Object[0]);
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " upgrade result  mFilePath = " + this.mFilePath);
                                return;
                            }
                            String str2 = this.mFilePath;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
                            startOTA(str2, com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI));
                        }
                    }
