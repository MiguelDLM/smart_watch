package com.sma.smartv3.ui.device.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.XIxXXX0x0;

/* loaded from: classes12.dex */
public final class ClassicPairGuideFragment extends BaseGuideFragment {
    private int bondFailedTime;

    @OOXIXo
    private ClassicPairGuideFragment$mBluetoothReceiver$1 mBluetoothReceiver = new BroadcastReceiver() { // from class: com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment$mBluetoothReceiver$1
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00e7, code lost:
        
            r6 = r2.mLoadingPopup;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(@OXOo.oOoXoXO android.content.Context r6, @OXOo.oOoXoXO android.content.Intent r7) {
            /*
                r5 = this;
                r6 = 0
                r0 = 1
                if (r7 == 0) goto Lf0
                java.lang.String r1 = r7.getAction()
                if (r1 == 0) goto Lf0
                com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment r2 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.this
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "BluetoothReceiver onReceive intent -> "
                r3.append(r4)
                r3.append(r7)
                java.lang.String r3 = r3.toString()
                java.lang.Object[] r4 = new java.lang.Object[r0]
                r4[r6] = r3
                com.blankj.utilcode.util.LogUtils.d(r4)
                int r3 = r1.hashCode()
                r4 = 1821585647(0x6c9330ef, float:1.4235454E27)
                if (r3 == r4) goto Lde
                r4 = 2116862345(0x7e2cc189, float:5.7408027E37)
                if (r3 == r4) goto L34
                goto Lf0
            L34:
                java.lang.String r3 = "android.bluetooth.device.action.BOND_STATE_CHANGED"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L3e
                goto Lf0
            L3e:
                java.lang.String r1 = "android.bluetooth.device.extra.DEVICE"
                android.os.Parcelable r7 = r7.getParcelableExtra(r1)
                android.bluetooth.BluetoothDevice r7 = (android.bluetooth.BluetoothDevice) r7
                if (r7 != 0) goto L49
                return
            L49:
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r7)
                java.lang.String r1 = r7.getAddress()
                com.szabh.smable3.component.BleCache r3 = com.szabh.smable3.component.BleCache.INSTANCE
                java.lang.String r3 = r3.getMClassicAddress()
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
                if (r1 != 0) goto L5d
                return
            L5d:
                int r1 = r7.getBondState()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "BluetoothReceiver onReceive ACTION_BOND_STATE_CHANGED -> device = "
                r3.append(r4)
                r3.append(r7)
                java.lang.String r7 = ", bondState = "
                r3.append(r7)
                r3.append(r1)
                java.lang.String r7 = ", bondFailedTime = "
                r3.append(r7)
                int r7 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getBondFailedTime$p(r2)
                r3.append(r7)
                java.lang.String r7 = r3.toString()
                java.lang.Object[] r3 = new java.lang.Object[r0]
                r3[r6] = r7
                com.blankj.utilcode.util.LogUtils.d(r3)
                r6 = 10
                if (r1 == r6) goto La8
                r6 = 12
                if (r1 == r6) goto L96
                goto Lf0
            L96:
                com.sma.smartv3.pop.I0X0x0oIo r6 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getMLoadingPopup$p(r2)
                if (r6 == 0) goto L9f
                r6.dismiss()
            L9f:
                android.widget.Button r6 = r2.getBtnSet()
                r7 = 4
                r6.setVisibility(r7)
                goto Lf0
            La8:
                com.sma.smartv3.pop.I0X0x0oIo r6 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getMLoadingPopup$p(r2)
                if (r6 == 0) goto Lb1
                r6.dismiss()
            Lb1:
                int r6 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getBondFailedTime$p(r2)
                int r6 = r6 + r0
                com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$setBondFailedTime$p(r2, r6)
                int r6 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getBondFailedTime$p(r2)
                r7 = 3
                if (r6 < r7) goto Lf0
                android.widget.Button r6 = r2.getBtnSet()
                r7 = 2132021565(0x7f14113d, float:1.9681525E38)
                r6.setText(r7)
                android.widget.TextView r6 = r2.getTvTip()
                r7 = 2132018793(0x7f140669, float:1.9675903E38)
                r0 = 2132018744(0x7f140638, float:1.9675803E38)
                android.text.Spanned r7 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getTip(r2, r7, r0)
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r6.setText(r7)
                goto Lf0
            Lde:
                java.lang.String r6 = "android.bluetooth.device.action.ACL_DISCONNECTED"
                boolean r6 = r1.equals(r6)
                if (r6 != 0) goto Le7
                goto Lf0
            Le7:
                com.sma.smartv3.pop.I0X0x0oIo r6 = com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment.access$getMLoadingPopup$p(r2)
                if (r6 == 0) goto Lf0
                r6.dismiss()
            Lf0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.guide.ClassicPairGuideFragment$mBluetoothReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    @oOoXoXO
    private I0X0x0oIo mLoadingPopup;

    /* JADX INFO: Access modifiers changed from: private */
    public final Spanned getTip(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String string = getString(i);
        IIX0o.oO(string, "getString(...)");
        sb.append(OxI.IIOIX(string, "\n", "<br>", false, 4, null));
        sb.append("<br><br><font color = ");
        sb.append(tipColor());
        sb.append(XIxXXX0x0.f29545XO);
        String string2 = getString(i2);
        IIX0o.oO(string2, "getString(...)");
        sb.append(OxI.IIOIX(string2, "\n", "<br>", false, 4, null));
        sb.append("</font>");
        Spanned fromHtml = Html.fromHtml(sb.toString());
        IIX0o.oO(fromHtml, "fromHtml(...)");
        return fromHtml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(ClassicPairGuideFragment this$0, View view, int i, KeyEvent keyEvent) {
        I0X0x0oIo i0X0x0oIo;
        IIX0o.x0xO0oo(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4 || (i0X0x0oIo = this$0.mLoadingPopup) == null || !i0X0x0oIo.isShowing()) {
            return false;
        }
        return true;
    }

    private final String tipColor() {
        return "grey";
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.oIX0oI oix0oi = com.sma.smartv3.util.oIX0oI.f24510oIX0oI;
        Activity mActivity = getMActivity();
        ClassicPairGuideFragment$mBluetoothReceiver$1 classicPairGuideFragment$mBluetoothReceiver$1 = this.mBluetoothReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        oix0oi.oIX0oI(mActivity, classicPairGuideFragment$mBluetoothReceiver$1, intentFilter, 2);
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        Spanned string;
        super.initView();
        getIvPic().setImageResource(R.drawable.pic_guide_classice_pair);
        getTvTitle().setText(R.string.guide_classic_pair_title);
        TextView tvTip = getTvTip();
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707)) {
            string = getTip(R.string.guide_classic_pair_tip, R.string.guide_classic_pair_tip_2);
        } else {
            string = getString(R.string.guide_classic_pair_tip);
        }
        tvTip.setText(string);
        getBtnSet().setText(R.string.go_pair);
        getBtnSet().setOnKeyListener(new View.OnKeyListener() { // from class: com.sma.smartv3.ui.device.guide.X0o0xo
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean initView$lambda$1;
                initView$lambda$1 = ClassicPairGuideFragment.initView$lambda$1(ClassicPairGuideFragment.this, view, i, keyEvent);
                return initView$lambda$1;
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getMActivity().unregisterReceiver(this.mBluetoothReceiver);
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment
    public void onSetClick() {
        getBtnSet().setFocusableInTouchMode(true);
        getBtnSet().requestFocus();
        if (this.bondFailedTime >= 3) {
            startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
            return;
        }
        if (this.mLoadingPopup == null) {
            this.mLoadingPopup = new I0X0x0oIo(getMActivity());
        }
        I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.IIXOooo();
        }
        BleConnector.INSTANCE.connectClassic();
    }
}
