package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.TimeRangePopup;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.AbhSettingsHeader;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleRelaxReminder;
import com.szabh.smable3.entity.BleTimeRange;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class RelaxReminderSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIntervalPopup;

    @OXOo.oOoXoXO
    private TimeRangePopup mTimeRangePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return RelaxReminderSettingsActivity.this.findViewById(R.id.root);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) RelaxReminderSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTimeRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$itemTimeRange$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) RelaxReminderSettingsActivity.this.findViewById(R.id.item_time_range);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemInterval$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$itemInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) RelaxReminderSettingsActivity.this.findViewById(R.id.item_interval);
        }
    });

    @OXOo.OOXIXo
    private final BleRelaxReminder mBleRelaxReminderSettings = (BleRelaxReminder) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.RELAX_REMINDER, BleRelaxReminder.class, null, null, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    private final AbhSettingsItem getItemInterval() {
        return (AbhSettingsItem) this.itemInterval$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemTimeRange() {
        return (AbhSettingsItem) this.itemTimeRange$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.relax_reminder);
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(ProductManager.f20544oIX0oI.oX0I0O(this.mBleRelaxReminderSettings.getMBleTimeRange().getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$initView$1$1

            /* renamed from: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$initView$1$1$1, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass1 extends Lambda implements Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI> {
                final /* synthetic */ boolean $isChecked;
                final /* synthetic */ RelaxReminderSettingsActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(RelaxReminderSettingsActivity relaxReminderSettingsActivity, boolean z) {
                    super(1);
                    this.this$0 = relaxReminderSettingsActivity;
                    this.$isChecked = z;
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                    invoke2(bleConnector);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                    BleRelaxReminder bleRelaxReminder;
                    BleRelaxReminder bleRelaxReminder2;
                    BleRelaxReminder bleRelaxReminder3;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    bleRelaxReminder = this.this$0.mBleRelaxReminderSettings;
                    LogUtils.d(bleRelaxReminder);
                    bleRelaxReminder2 = this.this$0.mBleRelaxReminderSettings;
                    bleRelaxReminder2.getMBleTimeRange().setMEnabled(oOXoIIIo.I0Io.I0Io(this.$isChecked));
                    BleKey bleKey = BleKey.RELAX_REMINDER;
                    BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                    bleRelaxReminder3 = this.this$0.mBleRelaxReminderSettings;
                    BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleRelaxReminder3, false, false, 24, null);
                    new Handler(Looper.getMainLooper()).postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: INVOKE 
                          (wrap:android.os.Handler:0x0040: CONSTRUCTOR 
                          (wrap:android.os.Looper:0x003c: INVOKE  STATIC call: android.os.Looper.getMainLooper():android.os.Looper A[MD:():android.os.Looper (c), WRAPPED])
                         A[MD:(android.os.Looper):void (c), WRAPPED] (LINE:8) call: android.os.Handler.<init>(android.os.Looper):void type: CONSTRUCTOR)
                          (wrap:java.lang.Runnable:0x0045: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.sma.smartv3.ui.device.Oxo00O.<init>():void type: CONSTRUCTOR)
                          (150 long)
                         VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:8) in method: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$initView$1$1.1.invoke(com.szabh.smable3.component.BleConnector):void, file: classes12.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.Oxo00O, state: NOT_LOADED
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
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r0)
                        com.sma.smartv3.ui.device.RelaxReminderSettingsActivity r0 = r10.this$0
                        com.szabh.smable3.entity.BleRelaxReminder r0 = com.sma.smartv3.ui.device.RelaxReminderSettingsActivity.access$getMBleRelaxReminderSettings$p(r0)
                        r1 = 1
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        r2 = 0
                        r1[r2] = r0
                        com.blankj.utilcode.util.LogUtils.d(r1)
                        com.sma.smartv3.ui.device.RelaxReminderSettingsActivity r0 = r10.this$0
                        com.szabh.smable3.entity.BleRelaxReminder r0 = com.sma.smartv3.ui.device.RelaxReminderSettingsActivity.access$getMBleRelaxReminderSettings$p(r0)
                        com.szabh.smable3.entity.BleTimeRange r0 = r0.getMBleTimeRange()
                        boolean r1 = r10.$isChecked
                        int r1 = oOXoIIIo.I0Io.I0Io(r1)
                        r0.setMEnabled(r1)
                        com.szabh.smable3.BleKey r3 = com.szabh.smable3.BleKey.RELAX_REMINDER
                        com.szabh.smable3.BleKeyFlag r4 = com.szabh.smable3.BleKeyFlag.UPDATE
                        com.sma.smartv3.ui.device.RelaxReminderSettingsActivity r0 = r10.this$0
                        com.szabh.smable3.entity.BleRelaxReminder r5 = com.sma.smartv3.ui.device.RelaxReminderSettingsActivity.access$getMBleRelaxReminderSettings$p(r0)
                        r8 = 24
                        r9 = 0
                        r6 = 0
                        r7 = 0
                        r2 = r11
                        com.szabh.smable3.component.BleConnector.sendObject$default(r2, r3, r4, r5, r6, r7, r8, r9)
                        android.os.Handler r11 = new android.os.Handler
                        android.os.Looper r0 = android.os.Looper.getMainLooper()
                        r11.<init>(r0)
                        com.sma.smartv3.ui.device.Oxo00O r0 = new com.sma.smartv3.ui.device.Oxo00O
                        r0.<init>()
                        r1 = 150(0x96, double:7.4E-322)
                        r11.postDelayed(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$initView$1$1.AnonymousClass1.invoke2(com.szabh.smable3.component.BleConnector):void");
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                AbhSettingsHeader itemHeader2;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new AnonymousClass1(RelaxReminderSettingsActivity.this, z), 1, null)) {
                    return;
                }
                itemHeader2 = RelaxReminderSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z);
            }
        });
        getItemTimeRange().setMRightText(TextConvertKt.xoxXI(this.mBleRelaxReminderSettings.getMBleTimeRange().getMStartHour(), this.mBleRelaxReminderSettings.getMBleTimeRange().getMStartMinute(), this.mBleRelaxReminderSettings.getMBleTimeRange().getMEndHour(), this.mBleRelaxReminderSettings.getMBleTimeRange().getMEndMinute(), ProjectManager.f19822oIX0oI.IO()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_relax_reminder_settings;
    }

    public final void onSetInterval(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
    }

    public final void onSetTimeRange(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mTimeRangePopup == null) {
            TimeRangePopup timeRangePopup = new TimeRangePopup(this, ProjectManager.f19822oIX0oI.IO());
            timeRangePopup.xI(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$onSetTimeRange$1$1
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i, final int i2, final int i3, final int i4) {
                    final RelaxReminderSettingsActivity relaxReminderSettingsActivity = RelaxReminderSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.RelaxReminderSettingsActivity$onSetTimeRange$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            BleRelaxReminder bleRelaxReminder;
                            BleRelaxReminder bleRelaxReminder2;
                            AbhSettingsItem itemTimeRange;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            bleRelaxReminder = RelaxReminderSettingsActivity.this.mBleRelaxReminderSettings;
                            BleTimeRange mBleTimeRange = bleRelaxReminder.getMBleTimeRange();
                            int i5 = i;
                            int i6 = i2;
                            int i7 = i3;
                            int i8 = i4;
                            mBleTimeRange.setMStartHour(i5);
                            mBleTimeRange.setMStartMinute(i6);
                            mBleTimeRange.setMEndHour(i7);
                            mBleTimeRange.setMEndMinute(i8);
                            BleKey bleKey = BleKey.RELAX_REMINDER;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleRelaxReminder2 = RelaxReminderSettingsActivity.this.mBleRelaxReminderSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleRelaxReminder2, false, false, 24, null);
                            itemTimeRange = RelaxReminderSettingsActivity.this.getItemTimeRange();
                            itemTimeRange.setMRightText(TextConvertKt.xoxXI(i, i2, i3, i4, ProjectManager.f19822oIX0oI.IO()));
                        }
                    }, 1, null));
                }
            });
            this.mTimeRangePopup = timeRangePopup;
        }
        TimeRangePopup timeRangePopup2 = this.mTimeRangePopup;
        if (timeRangePopup2 != null) {
            timeRangePopup2.oo0xXOI0I(this.mBleRelaxReminderSettings.getMBleTimeRange().getMStartHour(), this.mBleRelaxReminderSettings.getMBleTimeRange().getMStartMinute(), this.mBleRelaxReminderSettings.getMBleTimeRange().getMEndHour(), this.mBleRelaxReminderSettings.getMBleTimeRange().getMEndMinute());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            timeRangePopup2.OxxIIOOXO(rootView);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
