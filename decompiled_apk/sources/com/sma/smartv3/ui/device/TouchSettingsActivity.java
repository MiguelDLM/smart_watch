package com.sma.smartv3.ui.device;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.AbhSettingsHeader;
import com.sma.smartv3.view.AbhSettingsItem;
import com.sma.smartv3.view.SettingsPanel;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleTouchSettings;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes12.dex */
public final class TouchSettingsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mFailPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeader$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemHeader$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) TouchSettingsActivity.this.findViewById(R.id.item_header);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO containerPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SettingsPanel>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$containerPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SettingsPanel invoke() {
            return (SettingsPanel) TouchSettingsActivity.this.findViewById(R.id.item_container);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderMusic$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemHeaderMusic$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) TouchSettingsActivity.this.findViewById(R.id.item_header_music);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderPhoto$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemHeaderPhoto$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) TouchSettingsActivity.this.findViewById(R.id.item_header_photo);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderSlide$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemHeaderSlide$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) TouchSettingsActivity.this.findViewById(R.id.item_header_slide);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemHeaderCustom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsHeader>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemHeaderCustom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsHeader invoke() {
            return (AbhSettingsHeader) TouchSettingsActivity.this.findViewById(R.id.item_header_custom);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemSingle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemSingle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) TouchSettingsActivity.this.findViewById(R.id.item_single);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemDouble$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemDouble$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) TouchSettingsActivity.this.findViewById(R.id.item_double);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemLong$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$itemLong$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            return (AbhSettingsItem) TouchSettingsActivity.this.findViewById(R.id.item_long);
        }
    });

    @OXOo.OOXIXo
    private final List<com.sma.smartv3.pop.Ix00oIoI> mSingleChoiceItems = getSingleChoiceItems();

    @OXOo.OOXIXo
    private final BleTouchSettings mSettings = (BleTouchSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.TOUCH_SET, BleTouchSettings.class, null, null, 12, null);

    @OXOo.OOXIXo
    private TouchSettingsActivity$mBluetoothReceiver$1 mBluetoothReceiver = new BroadcastReceiver() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$mBluetoothReceiver$1
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
        
            r10 = r0.mLoadingPopup;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(@OXOo.oOoXoXO android.content.Context r10, @OXOo.oOoXoXO android.content.Intent r11) {
            /*
                r9 = this;
                if (r11 == 0) goto Le5
                java.lang.String r10 = r11.getAction()
                if (r10 == 0) goto Le5
                com.sma.smartv3.ui.device.TouchSettingsActivity r0 = com.sma.smartv3.ui.device.TouchSettingsActivity.this
                OI0.oIX0oI r1 = OI0.oIX0oI.f1507oIX0oI
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "BluetoothReceiver onReceive intent -> "
                r2.append(r3)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.oIX0oI(r2)
                int r2 = r10.hashCode()
                r3 = 1821585647(0x6c9330ef, float:1.4235454E27)
                if (r2 == r3) goto Ld3
                r3 = 2116862345(0x7e2cc189, float:5.7408027E37)
                if (r2 == r3) goto L30
                goto Le5
            L30:
                java.lang.String r2 = "android.bluetooth.device.action.BOND_STATE_CHANGED"
                boolean r10 = r10.equals(r2)
                if (r10 != 0) goto L3a
                goto Le5
            L3a:
                java.lang.String r10 = "android.bluetooth.device.extra.DEVICE"
                android.os.Parcelable r10 = r11.getParcelableExtra(r10)
                android.bluetooth.BluetoothDevice r10 = (android.bluetooth.BluetoothDevice) r10
                if (r10 != 0) goto L45
                return
            L45:
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r10)
                java.lang.String r11 = r10.getAddress()
                com.szabh.smable3.component.BleCache r2 = com.szabh.smable3.component.BleCache.INSTANCE
                java.lang.String r2 = r2.getMBleAddress()
                boolean r11 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r11, r2)
                if (r11 != 0) goto L59
                return
            L59:
                int r11 = r10.getBondState()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "BluetoothReceiver onReceive ACTION_BOND_STATE_CHANGED -> device = "
                r2.append(r3)
                r2.append(r10)
                java.lang.String r10 = ", bondState = "
                r2.append(r10)
                r2.append(r11)
                java.lang.String r10 = r2.toString()
                r1.oIX0oI(r10)
                r10 = 10
                if (r11 == r10) goto La9
                r10 = 12
                if (r11 == r10) goto L82
                goto Le5
            L82:
                com.sma.smartv3.pop.I0X0x0oIo r10 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMLoadingPopup$p(r0)
                if (r10 == 0) goto L8b
                r10.dismiss()
            L8b:
                com.szabh.smable3.entity.BleTouchSettings r10 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMSettings$p(r0)
                r11 = 1
                r10.setMEnabled(r11)
                com.szabh.smable3.component.BleConnector r1 = com.szabh.smable3.component.BleConnector.INSTANCE
                com.szabh.smable3.BleKey r2 = com.szabh.smable3.BleKey.TOUCH_SET
                com.szabh.smable3.BleKeyFlag r3 = com.szabh.smable3.BleKeyFlag.UPDATE
                com.szabh.smable3.entity.BleTouchSettings r4 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMSettings$p(r0)
                r7 = 24
                r8 = 0
                r5 = 0
                r6 = 0
                com.szabh.smable3.component.BleConnector.sendObject$default(r1, r2, r3, r4, r5, r6, r7, r8)
                com.sma.smartv3.ui.device.TouchSettingsActivity.access$updateUI(r0)
                goto Le5
            La9:
                com.sma.smartv3.pop.I0X0x0oIo r10 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMLoadingPopup$p(r0)
                if (r10 == 0) goto Lb2
                r10.dismiss()
            Lb2:
                com.szabh.smable3.entity.BleTouchSettings r10 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMSettings$p(r0)
                r11 = 0
                r10.setMEnabled(r11)
                com.szabh.smable3.component.BleConnector r1 = com.szabh.smable3.component.BleConnector.INSTANCE
                com.szabh.smable3.BleKey r2 = com.szabh.smable3.BleKey.TOUCH_SET
                com.szabh.smable3.BleKeyFlag r3 = com.szabh.smable3.BleKeyFlag.UPDATE
                com.szabh.smable3.entity.BleTouchSettings r4 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMSettings$p(r0)
                r7 = 24
                r8 = 0
                r5 = 0
                r6 = 0
                com.szabh.smable3.component.BleConnector.sendObject$default(r1, r2, r3, r4, r5, r6, r7, r8)
                com.sma.smartv3.ui.device.TouchSettingsActivity.access$showConnectFailPopup(r0)
                com.sma.smartv3.ui.device.TouchSettingsActivity.access$updateUI(r0)
                goto Le5
            Ld3:
                java.lang.String r11 = "android.bluetooth.device.action.ACL_DISCONNECTED"
                boolean r10 = r10.equals(r11)
                if (r10 != 0) goto Ldc
                goto Le5
            Ldc:
                com.sma.smartv3.pop.I0X0x0oIo r10 = com.sma.smartv3.ui.device.TouchSettingsActivity.access$getMLoadingPopup$p(r0)
                if (r10 == 0) goto Le5
                r10.dismiss()
            Le5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.TouchSettingsActivity$mBluetoothReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    private final SettingsPanel getContainerPanel() {
        return (SettingsPanel) this.containerPanel$delegate.getValue();
    }

    private final AbhSettingsItem getItemDouble() {
        return (AbhSettingsItem) this.itemDouble$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsHeader getItemHeader() {
        return (AbhSettingsHeader) this.itemHeader$delegate.getValue();
    }

    private final AbhSettingsHeader getItemHeaderCustom() {
        return (AbhSettingsHeader) this.itemHeaderCustom$delegate.getValue();
    }

    private final AbhSettingsHeader getItemHeaderMusic() {
        return (AbhSettingsHeader) this.itemHeaderMusic$delegate.getValue();
    }

    private final AbhSettingsHeader getItemHeaderPhoto() {
        return (AbhSettingsHeader) this.itemHeaderPhoto$delegate.getValue();
    }

    private final AbhSettingsHeader getItemHeaderSlide() {
        return (AbhSettingsHeader) this.itemHeaderSlide$delegate.getValue();
    }

    private final AbhSettingsItem getItemLong() {
        return (AbhSettingsItem) this.itemLong$delegate.getValue();
    }

    private final AbhSettingsItem getItemSingle() {
        return (AbhSettingsItem) this.itemSingle$delegate.getValue();
    }

    private final List<com.sma.smartv3.pop.Ix00oIoI> getSingleChoiceItems() {
        return CollectionsKt__CollectionsKt.X00IoxXI(new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_none, 0), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_double, R.string.touch_screen_double_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_swipe_up, R.string.touch_screen_swipe_up_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_swipe_down, R.string.touch_screen_swipe_down_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_swipe_left, R.string.touch_screen_swipe_left_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_swipe_right, R.string.touch_screen_swipe_right_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_swipe_back, R.string.touch_screen_exit_application_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_vol_inc, R.string.touch_screen_vol_increase_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_vol_dec, R.string.touch_screen_vol_down_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_music_prev, R.string.touch_screen_play_pre_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_music_next, R.string.touch_screen_play_next_tip), new com.sma.smartv3.pop.Ix00oIoI(R.string.touch_screen_music_play_pause, R.string.touch_screen_play_pause_and_stop_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConnectFailPopup() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (this.mFailPopup == null) {
            final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.hid_connect_fail);
            xoI0Ixx02.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$showConnectFailPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$showConnectFailPopup$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    com.sma.smartv3.pop.XoI0Ixx0.this.dismiss();
                    this.tryConnectHID();
                    return Boolean.TRUE;
                }
            });
            this.mFailPopup = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mFailPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mFailPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryConnectHID() {
        if (this.mLoadingPopup == null) {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(this);
            i0X0x0oIo.xXxxox0I(R.string.device_connecting);
            i0X0x0oIo.xxX(Integer.valueOf(R.string.connecting_hid_tip));
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
        BleConnector.INSTANCE.connectHID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        boolean z;
        boolean z2;
        boolean z3;
        AbhSettingsHeader itemHeader = getItemHeader();
        itemHeader.setChecked(oOXoIIIo.I0Io.II0xO0(this.mSettings.getMEnabled()));
        itemHeader.setMListener(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$updateUI$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(final boolean z4) {
                AbhSettingsHeader itemHeader2;
                final TouchSettingsActivity touchSettingsActivity = TouchSettingsActivity.this;
                if (com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$updateUI$1$1.1
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
                        BleTouchSettings bleTouchSettings;
                        BleTouchSettings bleTouchSettings2;
                        AbhSettingsHeader itemHeader3;
                        BleTouchSettings bleTouchSettings3;
                        BleTouchSettings bleTouchSettings4;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        if (!z4) {
                            bleTouchSettings = touchSettingsActivity.mSettings;
                            bleTouchSettings.setMEnabled(0);
                            BleKey bleKey = BleKey.TOUCH_SET;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            bleTouchSettings2 = touchSettingsActivity.mSettings;
                            BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTouchSettings2, false, false, 24, null);
                            touchSettingsActivity.updateUI();
                            return;
                        }
                        if (BleConnector.INSTANCE.isBoundHID()) {
                            bleTouchSettings3 = touchSettingsActivity.mSettings;
                            bleTouchSettings3.setMEnabled(1);
                            BleKey bleKey2 = BleKey.TOUCH_SET;
                            BleKeyFlag bleKeyFlag2 = BleKeyFlag.UPDATE;
                            bleTouchSettings4 = touchSettingsActivity.mSettings;
                            BleConnector.sendObject$default(it, bleKey2, bleKeyFlag2, bleTouchSettings4, false, false, 24, null);
                            touchSettingsActivity.updateUI();
                            return;
                        }
                        itemHeader3 = touchSettingsActivity.getItemHeader();
                        itemHeader3.setChecked(false);
                        touchSettingsActivity.tryConnectHID();
                    }
                }, 1, null)) {
                    return;
                }
                itemHeader2 = TouchSettingsActivity.this.getItemHeader();
                itemHeader2.setChecked(!z4);
            }
        });
        AbhSettingsHeader itemHeaderMusic = getItemHeaderMusic();
        itemHeaderMusic.getCheckEnabled().setButtonDrawable(R.drawable.selector_radio);
        boolean z4 = false;
        if (this.mSettings.getMType() == 0) {
            z = true;
        } else {
            z = false;
        }
        itemHeaderMusic.setChecked(z);
        itemHeaderMusic.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.Ix0x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouchSettingsActivity.updateUI$lambda$3$lambda$2(TouchSettingsActivity.this, view);
            }
        });
        getItemHeaderPhoto().setVisibility(8);
        AbhSettingsHeader itemHeaderPhoto = getItemHeaderPhoto();
        itemHeaderPhoto.getCheckEnabled().setButtonDrawable(R.drawable.selector_radio);
        if (this.mSettings.getMType() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        itemHeaderPhoto.setChecked(z2);
        itemHeaderPhoto.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.OOxOOxIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouchSettingsActivity.updateUI$lambda$5$lambda$4(TouchSettingsActivity.this, view);
            }
        });
        if (ProductManager.f20544oIX0oI.OOxOOxIO()) {
            getItemHeaderSlide().setVisibility(0);
        } else {
            getItemHeaderSlide().setVisibility(8);
        }
        AbhSettingsHeader itemHeaderSlide = getItemHeaderSlide();
        itemHeaderSlide.getCheckEnabled().setButtonDrawable(R.drawable.selector_radio);
        if (this.mSettings.getMType() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        itemHeaderSlide.setChecked(z3);
        itemHeaderSlide.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.XIOOI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouchSettingsActivity.updateUI$lambda$7$lambda$6(TouchSettingsActivity.this, view);
            }
        });
        AbhSettingsHeader itemHeaderCustom = getItemHeaderCustom();
        itemHeaderCustom.getCheckEnabled().setButtonDrawable(R.drawable.selector_radio);
        if (this.mSettings.getMType() == 3) {
            z4 = true;
        }
        itemHeaderCustom.setChecked(z4);
        itemHeaderCustom.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.oox000IX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouchSettingsActivity.updateUI$lambda$9$lambda$8(TouchSettingsActivity.this, view);
            }
        });
        getContainerPanel().oIX0oI(!oOXoIIIo.I0Io.II0xO0(this.mSettings.getMEnabled()));
        AbhSettingsItem itemSingle = getItemSingle();
        String string = getString(this.mSingleChoiceItems.get(this.mSettings.getMCustomSingle()).XO());
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        itemSingle.setMRightText(string);
        AbhSettingsItem itemDouble = getItemDouble();
        String string2 = getString(this.mSingleChoiceItems.get(this.mSettings.getMCustomDouble()).XO());
        kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
        itemDouble.setMRightText(string2);
        AbhSettingsItem itemLong = getItemLong();
        String string3 = getString(this.mSingleChoiceItems.get(this.mSettings.getMCustomLong()).XO());
        kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
        itemLong.setMRightText(string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUI$lambda$3$lambda$2(final TouchSettingsActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$updateUI$2$1$1
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
                BleTouchSettings bleTouchSettings;
                BleTouchSettings bleTouchSettings2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                bleTouchSettings = TouchSettingsActivity.this.mSettings;
                bleTouchSettings.setMType(0);
                BleKey bleKey = BleKey.TOUCH_SET;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                bleTouchSettings2 = TouchSettingsActivity.this.mSettings;
                BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTouchSettings2, false, false, 24, null);
                TouchSettingsActivity.this.updateUI();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUI$lambda$5$lambda$4(final TouchSettingsActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$updateUI$3$1$1
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
                BleTouchSettings bleTouchSettings;
                BleTouchSettings bleTouchSettings2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                bleTouchSettings = TouchSettingsActivity.this.mSettings;
                bleTouchSettings.setMType(1);
                BleKey bleKey = BleKey.TOUCH_SET;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                bleTouchSettings2 = TouchSettingsActivity.this.mSettings;
                BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTouchSettings2, false, false, 24, null);
                TouchSettingsActivity.this.updateUI();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUI$lambda$7$lambda$6(final TouchSettingsActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$updateUI$4$1$1
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
                BleTouchSettings bleTouchSettings;
                BleTouchSettings bleTouchSettings2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                bleTouchSettings = TouchSettingsActivity.this.mSettings;
                bleTouchSettings.setMType(2);
                BleKey bleKey = BleKey.TOUCH_SET;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                bleTouchSettings2 = TouchSettingsActivity.this.mSettings;
                BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTouchSettings2, false, false, 24, null);
                TouchSettingsActivity.this.updateUI();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUI$lambda$9$lambda$8(final TouchSettingsActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$updateUI$5$1$1
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
                BleTouchSettings bleTouchSettings;
                BleTouchSettings bleTouchSettings2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                bleTouchSettings = TouchSettingsActivity.this.mSettings;
                bleTouchSettings.setMType(3);
                BleKey bleKey = BleKey.TOUCH_SET;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                bleTouchSettings2 = TouchSettingsActivity.this.mSettings;
                BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTouchSettings2, false, false, 24, null);
                TouchSettingsActivity.this.updateUI();
            }
        }, 1, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.oIX0oI oix0oi = com.sma.smartv3.util.oIX0oI.f24510oIX0oI;
        TouchSettingsActivity$mBluetoothReceiver$1 touchSettingsActivity$mBluetoothReceiver$1 = this.mBluetoothReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
        oix0oi.oIX0oI(this, touchSettingsActivity$mBluetoothReceiver$1, intentFilter, 2);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.touch_set);
        updateUI();
        if (oOXoIIIo.I0Io.II0xO0(this.mSettings.getMEnabled()) && !BleConnector.INSTANCE.isBoundHID()) {
            tryConnectHID();
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_touch_settings;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mBluetoothReceiver);
    }

    public final void onShowKeysPopup(@OXOo.OOXIXo final View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.x0 x0Var = new com.sma.smartv3.pop.x0(this, this.mSingleChoiceItems, 0, 4, null);
        int id = view.getId();
        if (id != R.id.item_double) {
            if (id != R.id.item_long) {
                if (id == R.id.item_single) {
                    x0Var.xI(R.string.touch_set_single);
                    x0Var.IIX0o(this.mSettings.getMCustomSingle());
                }
            } else {
                x0Var.xI(R.string.touch_set_long);
                x0Var.IIX0o(this.mSettings.getMCustomLong());
            }
        } else {
            x0Var.xI(R.string.touch_set_double);
            x0Var.IIX0o(this.mSettings.getMCustomDouble());
        }
        x0Var.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$onShowKeysPopup$mKeysPopup$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(final int i) {
                final View view2 = view;
                final TouchSettingsActivity touchSettingsActivity = this;
                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TouchSettingsActivity$onShowKeysPopup$mKeysPopup$1$1.1
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
                        BleTouchSettings bleTouchSettings;
                        BleTouchSettings bleTouchSettings2;
                        BleTouchSettings bleTouchSettings3;
                        BleTouchSettings bleTouchSettings4;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        int id2 = view2.getId();
                        if (id2 == R.id.item_double) {
                            bleTouchSettings = touchSettingsActivity.mSettings;
                            bleTouchSettings.setMCustomDouble(i);
                        } else if (id2 == R.id.item_long) {
                            bleTouchSettings3 = touchSettingsActivity.mSettings;
                            bleTouchSettings3.setMCustomLong(i);
                        } else if (id2 == R.id.item_single) {
                            bleTouchSettings4 = touchSettingsActivity.mSettings;
                            bleTouchSettings4.setMCustomSingle(i);
                        }
                        BleKey bleKey = BleKey.TOUCH_SET;
                        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                        bleTouchSettings2 = touchSettingsActivity.mSettings;
                        BleConnector.sendObject$default(it, bleKey, bleKeyFlag, bleTouchSettings2, false, false, 24, null);
                        touchSettingsActivity.updateUI();
                    }
                }, 1, null));
            }
        });
        x0Var.IIXOooo();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
