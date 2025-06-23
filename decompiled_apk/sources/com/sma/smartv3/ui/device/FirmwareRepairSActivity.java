package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.ZipUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sifli.siflidfu.DFUImagePath;
import com.sifli.siflidfu.ISifliDFUService;
import com.sifli.siflidfu.SifliDFUService;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.FirmwareVersionLatest;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.ui.device.FirmwareRepairSActivity$localBroadcastReceiver$2;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairSActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairSActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,243:1\n18#2,2:244\n15#2:246\n151#3,11:247\n171#3:266\n208#4,7:258\n226#4:265\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairSActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSActivity\n*L\n51#1:244,2\n51#1:246\n162#1:247,11\n162#1:266\n162#1:258,7\n162#1:265\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairSActivity extends BaseFirmwareRepairActivity {

    @OXOo.OOXIXo
    private final String TAG = "RepairS";
    private boolean isBound;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO localBroadcastReceiver$delegate;

    @OXOo.oOoXoXO
    private SifliDFUService.SifliDFUBinder mBinder;

    @OXOo.OOXIXo
    private final BleDeviceInfo mDeviceInfo;

    @OXOo.oOoXoXO
    private String mFilePath;

    @OXOo.OOXIXo
    private final ServiceConnection serviceConnection;

    @OXOo.oOoXoXO
    private ISifliDFUService sifliDFUService;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ServiceConnection {
        public oIX0oI() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@OXOo.OOXIXo ComponentName name, @OXOo.OOXIXo IBinder service) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
            kotlin.jvm.internal.IIX0o.x0xO0oo(service, "service");
            FirmwareRepairSActivity.this.mBinder = (SifliDFUService.SifliDFUBinder) service;
            FirmwareRepairSActivity firmwareRepairSActivity = FirmwareRepairSActivity.this;
            SifliDFUService.SifliDFUBinder sifliDFUBinder = firmwareRepairSActivity.mBinder;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(sifliDFUBinder);
            firmwareRepairSActivity.sifliDFUService = sifliDFUBinder.getDfuService();
            FirmwareRepairSActivity.this.isBound = true;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairSActivity.this.TAG + " onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@OXOo.OOXIXo ComponentName name) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairSActivity.this.TAG + " onServiceDisconnected");
            FirmwareRepairSActivity.this.isBound = false;
        }
    }

    public FirmwareRepairSActivity() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(BleDeviceInfo.class.getName()), (Class<Object>) BleDeviceInfo.class);
        this.mDeviceInfo = (BleDeviceInfo) (fromJson == null ? BleDeviceInfo.class.newInstance() : fromJson);
        this.localBroadcastReceiver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FirmwareRepairSActivity$localBroadcastReceiver$2.AnonymousClass1>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSActivity$localBroadcastReceiver$2

            @kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairSActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairSActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSActivity$localBroadcastReceiver$2$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,243:1\n27#2,2:244\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairSActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSActivity$localBroadcastReceiver$2$1\n*L\n90#1:244,2\n*E\n"})
            /* renamed from: com.sma.smartv3.ui.device.FirmwareRepairSActivity$localBroadcastReceiver$2$1, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass1 extends BroadcastReceiver {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ FirmwareRepairSActivity f21810oIX0oI;

                public AnonymousClass1(FirmwareRepairSActivity firmwareRepairSActivity) {
                    this.f21810oIX0oI = firmwareRepairSActivity;
                }

                public static final void I0Io(FirmwareRepairSActivity this$0, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    this$0.getTvTip().setText(this$0.getString(R.string.starting));
                    this$0.getDfuProgress().setProgress(i / 100.0f);
                }

                public static final void oxoX(int i, FirmwareRepairSActivity this$0) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    if (i != 0) {
                        if (i != 63) {
                            this$0.getTvTip().setText(this$0.getString(R.string.firmware_upgrading_failed) + "  error=" + i);
                        } else {
                            this$0.getTvTip().setText(this$0.getString(R.string.firmware_upgrading_failed));
                            ToastUtils.showLong(this$0.getString(R.string.request_bluetooth_permission_denied_tip), new Object[0]);
                        }
                    } else {
                        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                        xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
                        ToastUtils.showLong(R.string.upgrade_successful);
                        xo0.II0xO0().remove(FirmwareVersion.class.getName());
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24613XOxIOxOx, null, 2, null);
                        this$0.finish();
                    }
                    this$0.setMStarted(false);
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(intent, "intent");
                    String action = intent.getAction();
                    if (action != null) {
                        int hashCode = action.hashCode();
                        if (hashCode != -1936294892) {
                            if (hashCode != 888644493) {
                                if (hashCode == 1761809728 && action.equals(SifliDFUService.BROADCAST_DFU_LOG)) {
                                    String stringExtra = intent.getStringExtra(SifliDFUService.EXTRA_LOG_MESSAGE);
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f21810oIX0oI.TAG + " DFU LOG - " + stringExtra);
                                    return;
                                }
                                return;
                            }
                            if (action.equals(SifliDFUService.BROADCAST_DFU_STATE)) {
                                int intExtra = intent.getIntExtra(SifliDFUService.EXTRA_DFU_STATE, 0);
                                final int intExtra2 = intent.getIntExtra(SifliDFUService.EXTRA_DFU_STATE_RESULT, 0);
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f21810oIX0oI.TAG + "  BROADCAST_DFU_STATE  result : dfuState=" + intExtra + "  dfuStateResult = " + intExtra2);
                                if (intExtra != 7) {
                                    if (intExtra == 100) {
                                        final FirmwareRepairSActivity firmwareRepairSActivity = this.f21810oIX0oI;
                                        ThreadUtils.runOnUiThread(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a3: INVOKE 
                                              (wrap:java.lang.Runnable:0x00a0: CONSTRUCTOR 
                                              (r5v3 'intExtra2' int A[DONT_INLINE])
                                              (r4v11 'firmwareRepairSActivity' com.sma.smartv3.ui.device.FirmwareRepairSActivity A[DONT_INLINE])
                                             A[MD:(int, com.sma.smartv3.ui.device.FirmwareRepairSActivity):void (m), WRAPPED] (LINE:161) call: com.sma.smartv3.ui.device.I0X0x0oIo.<init>(int, com.sma.smartv3.ui.device.FirmwareRepairSActivity):void type: CONSTRUCTOR)
                                             STATIC call: com.blankj.utilcode.util.ThreadUtils.runOnUiThread(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (m)] (LINE:164) in method: com.sma.smartv3.ui.device.FirmwareRepairSActivity$localBroadcastReceiver$2.1.onReceive(android.content.Context, android.content.Intent):void, file: classes12.dex
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.I0X0x0oIo, state: NOT_LOADED
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
                                            if (r4 == 0) goto Lf1
                                            int r0 = r4.hashCode()
                                            r1 = -1936294892(0xffffffff8c967c14, float:-2.3185836E-31)
                                            r2 = 0
                                            if (r0 == r1) goto Lb4
                                            r1 = 888644493(0x34f7a38d, float:4.6126334E-7)
                                            if (r0 == r1) goto L57
                                            r1 = 1761809728(0x69031540, float:9.904352E24)
                                            if (r0 == r1) goto L26
                                            goto Lf1
                                        L26:
                                            java.lang.String r0 = "com.sifli.siflidfu.BROADCAST_DFU_LOG"
                                            boolean r4 = r4.equals(r0)
                                            if (r4 != 0) goto L30
                                            goto Lf1
                                        L30:
                                            java.lang.String r4 = "com.sifli.siflidfu.EXTRA_LOG_MESSAGE"
                                            java.lang.String r4 = r5.getStringExtra(r4)
                                            OI0.oIX0oI r5 = OI0.oIX0oI.f1507oIX0oI
                                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                            r0.<init>()
                                            com.sma.smartv3.ui.device.FirmwareRepairSActivity r1 = r3.f21810oIX0oI
                                            java.lang.String r1 = com.sma.smartv3.ui.device.FirmwareRepairSActivity.access$getTAG$p(r1)
                                            r0.append(r1)
                                            java.lang.String r1 = " DFU LOG - "
                                            r0.append(r1)
                                            r0.append(r4)
                                            java.lang.String r4 = r0.toString()
                                            r5.oIX0oI(r4)
                                            goto Lf1
                                        L57:
                                            java.lang.String r0 = "com.sifli.siflidfu.BROADCAST_DFU_STATE"
                                            boolean r4 = r4.equals(r0)
                                            if (r4 != 0) goto L61
                                            goto Lf1
                                        L61:
                                            java.lang.String r4 = "com.sifli.siflidfu.EXTRA_DFU_STATE"
                                            int r4 = r5.getIntExtra(r4, r2)
                                            java.lang.String r0 = "com.sifli.siflidfu.EXTRA_DFU_STATE_RESULT"
                                            int r5 = r5.getIntExtra(r0, r2)
                                            OI0.oIX0oI r0 = OI0.oIX0oI.f1507oIX0oI
                                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                            r1.<init>()
                                            com.sma.smartv3.ui.device.FirmwareRepairSActivity r2 = r3.f21810oIX0oI
                                            java.lang.String r2 = com.sma.smartv3.ui.device.FirmwareRepairSActivity.access$getTAG$p(r2)
                                            r1.append(r2)
                                            java.lang.String r2 = "  BROADCAST_DFU_STATE  result : dfuState="
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
                                            goto Lf1
                                        L9c:
                                            com.sma.smartv3.ui.device.FirmwareRepairSActivity r4 = r3.f21810oIX0oI
                                            com.sma.smartv3.ui.device.I0X0x0oIo r0 = new com.sma.smartv3.ui.device.I0X0x0oIo
                                            r0.<init>(r5, r4)
                                            com.blankj.utilcode.util.ThreadUtils.runOnUiThread(r0)
                                            goto Lf1
                                        La7:
                                            com.sma.smartv3.util.Xo0 r4 = com.sma.smartv3.util.Xo0.f24349oIX0oI
                                            com.blankj.utilcode.util.SPUtils r4 = r4.II0xO0()
                                            java.lang.String r5 = "firmware_upgrade_failed"
                                            r0 = 1
                                            r4.put(r5, r0)
                                            goto Lf1
                                        Lb4:
                                            java.lang.String r0 = "com.sifli.siflidfu.EXTRA_BROADCAST_PROGRESS"
                                            boolean r4 = r4.equals(r0)
                                            if (r4 != 0) goto Lbd
                                            goto Lf1
                                        Lbd:
                                            java.lang.String r4 = "com.sifli.siflidfu.EXTRA_DFU_PROGRESS"
                                            int r4 = r5.getIntExtra(r4, r2)
                                            java.lang.String r0 = "com.sifli.siflidfu.EXTRA_DFU_PROGRESS_TYPE"
                                            r5.getIntExtra(r0, r2)
                                            OI0.oIX0oI r5 = OI0.oIX0oI.f1507oIX0oI
                                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                            r0.<init>()
                                            com.sma.smartv3.ui.device.FirmwareRepairSActivity r1 = r3.f21810oIX0oI
                                            java.lang.String r1 = com.sma.smartv3.ui.device.FirmwareRepairSActivity.access$getTAG$p(r1)
                                            r0.append(r1)
                                            java.lang.String r1 = " progress - "
                                            r0.append(r1)
                                            r0.append(r4)
                                            java.lang.String r0 = r0.toString()
                                            r5.oIX0oI(r0)
                                            com.sma.smartv3.ui.device.FirmwareRepairSActivity r5 = r3.f21810oIX0oI
                                            com.sma.smartv3.ui.device.XX0 r0 = new com.sma.smartv3.ui.device.XX0
                                            r0.<init>(r5, r4)
                                            com.blankj.utilcode.util.ThreadUtils.runOnUiThread(r0)
                                        Lf1:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.FirmwareRepairSActivity$localBroadcastReceiver$2.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
                                    }
                                }

                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // Oox.oIX0oI
                                @OXOo.OOXIXo
                                public final AnonymousClass1 invoke() {
                                    return new AnonymousClass1(FirmwareRepairSActivity.this);
                                }
                            });
                            this.serviceConnection = new oIX0oI();
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
                            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                            oix0oi.oIX0oI(this.TAG + " Server -> " + UtilsKt.IXxxXO());
                            oix0oi.oIX0oI(this.TAG + " checkFirmware deviceInfo -> " + this.mDeviceInfo);
                            getTvTip().setText(R.string.firmware_repair_download_tip);
                            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
                            HashMap<String, String> checkFirmwareVersionBody = RequestBodyKt.getCheckFirmwareVersionBody("0", "N", this.mDeviceInfo.getMBleName(), this.mDeviceInfo.getMFirmwareFlag());
                            final xxxI.II0xO0<FirmwareVersion> iI0xO0 = new xxxI.II0xO0<FirmwareVersion>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSActivity$checkFirmware$1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairSActivity.this.TAG + " NetWorkUtils firmware error -> " + error);
                                    FirmwareRepairSActivity.this.getTvTip().setText(FirmwareRepairSActivity.this.getString(R.string.request_error));
                                    FirmwareRepairSActivity.this.setMStarted(false);
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO FirmwareVersion firmwareVersion) {
                                    if (firmwareVersion != null) {
                                        FirmwareRepairSActivity firmwareRepairSActivity = FirmwareRepairSActivity.this;
                                        firmwareRepairSActivity.getTvName().setText(firmwareVersion.getFileName());
                                        firmwareRepairSActivity.getTvSize().setText(ConvertUtils.byte2FitMemorySize(firmwareVersion.getFileSize()));
                                        firmwareRepairSActivity.download(firmwareVersion);
                                    }
                                }
                            };
                            final Activity mContext = getMContext();
                            final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(mContext, null);
                            String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), FirmwareVersionLatest.URL);
                            netWorkUtils.printParam(convertBaseUrl + FirmwareVersionLatest.URL, checkFirmwareVersionBody);
                            NetWork netWork = NetWork.f19682oIX0oI;
                            String str = convertBaseUrl + FirmwareVersionLatest.URL;
                            final xxxI.II0xO0<Response<FirmwareVersion>> iI0xO02 = new xxxI.II0xO0<Response<FirmwareVersion>>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSActivity$checkFirmware$$inlined$post$default$1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO Response<FirmwareVersion> response) {
                                    NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                                    Activity activity = mContext;
                                    xxxI.II0xO0 iI0xO03 = iI0xO0;
                                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                                    LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                                    if (response == null) {
                                        response = new Response<>();
                                        response.setCode(-1000);
                                    }
                                    netWorkUtils2.responseWhenCheck(activity, response, iI0xO03);
                                    if (i0X0x0oIo != null) {
                                        i0X0x0oIo.dismiss();
                                    }
                                }
                            };
                            AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkFirmwareVersionBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, FirmwareVersion.class), new ParsedRequestListener<Response<FirmwareVersion>>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSActivity$checkFirmware$$inlined$post$default$2
                                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void onResponse(@OXOo.OOXIXo Response<FirmwareVersion> response) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                                    xxxI.II0xO0.this.handleResponse(response);
                                }

                                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                                public void onError(@OXOo.oOoXoXO ANError aNError) {
                                    Integer num;
                                    String str2;
                                    String str3;
                                    Response response;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("errorCode:");
                                    Integer num2 = null;
                                    if (aNError != null) {
                                        num = Integer.valueOf(aNError.getErrorCode());
                                    } else {
                                        num = null;
                                    }
                                    sb.append(num);
                                    sb.append(", errorBody:");
                                    if (aNError != null) {
                                        str2 = aNError.getErrorBody();
                                    } else {
                                        str2 = null;
                                    }
                                    sb.append(str2);
                                    sb.append(", ");
                                    if (aNError != null) {
                                        str3 = aNError.getErrorDetail();
                                    } else {
                                        str3 = null;
                                    }
                                    sb.append(str3);
                                    LogUtils.d(sb.toString());
                                    if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                                        num2 = Integer.valueOf(response.getCode());
                                    } else if (aNError != null) {
                                        num2 = Integer.valueOf(aNError.getErrorCode());
                                    }
                                    xxxI.II0xO0.this.handleError(String.valueOf(num2));
                                }
                            });
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
                            NetWorkUtils.INSTANCE.download(firmwareVersion.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi), firmwareVersion.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSActivity$download$1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairSActivity.this.TAG + " download firmware error -> " + error);
                                    FirmwareRepairSActivity.this.getTvTip().setText(String.valueOf(FirmwareRepairSActivity.this.getString(R.string.request_error)));
                                    FirmwareRepairSActivity.this.setMStarted(false);
                                }

                                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                                public void handleProgress(int i) {
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO String str) {
                                    FirmwareRepairSActivity.this.upgrade();
                                }
                            });
                        }

                        @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
                        public void init(@OXOo.oOoXoXO Bundle bundle) {
                            registerDfuLocalBroadcast();
                            bindService(new Intent(this, (Class<?>) SifliDFUService.class), this.serviceConnection, 1);
                        }

                        @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
                        public void initView() {
                            super.initView();
                            checkFirmware();
                        }

                        @Override // com.bestmafen.androidbase.base.BaseActivity, android.app.Activity, android.view.Window.Callback
                        public void onAttachedToWindow() {
                            super.onAttachedToWindow();
                            setMStarted(true);
                        }

                        @Override // androidx.activity.ComponentActivity, android.app.Activity
                        public void onBackPressed() {
                            if (getMStarted()) {
                                return;
                            }
                            super.onBackPressed();
                        }

                        @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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
                            ISifliDFUService iSifliDFUService = this.sifliDFUService;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(iSifliDFUService);
                            iSifliDFUService.startActionDFUNorExt(this, BleCache.INSTANCE.getMBleAddress(), oxoX2, 1, 0);
                            setMStarted(true);
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
