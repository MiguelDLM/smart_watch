package com.sma.smartv3.ui.device.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.component.BleConnector;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;

/* loaded from: classes12.dex */
public final class HIDGuideFragment extends BaseGuideFragment {
    private int bondFailedTime;
    private boolean canSwipe;

    @oOoXoXO
    private I0X0x0oIo mLoadingPopup;
    private final int BOUND_MAX_TIME = 3;

    @OOXIXo
    private final X0IIOO tvHighTip$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.guide.HIDGuideFragment$tvHighTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = HIDGuideFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_high_tip);
        }
    });

    @OOXIXo
    private HIDGuideFragment$mBluetoothReceiver$1 mBluetoothReceiver = new BroadcastReceiver() { // from class: com.sma.smartv3.ui.device.guide.HIDGuideFragment$mBluetoothReceiver$1
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00de, code lost:
        
            r5 = r0.mLoadingPopup;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(@OXOo.oOoXoXO android.content.Context r5, @OXOo.oOoXoXO android.content.Intent r6) {
            /*
                r4 = this;
                if (r6 == 0) goto Le7
                java.lang.String r5 = r6.getAction()
                if (r5 == 0) goto Le7
                com.sma.smartv3.ui.device.guide.HIDGuideFragment r0 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.this
                OI0.oIX0oI r1 = OI0.oIX0oI.f1507oIX0oI
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "BluetoothReceiver onReceive intent -> "
                r2.append(r3)
                r2.append(r6)
                java.lang.String r2 = r2.toString()
                r1.oIX0oI(r2)
                int r2 = r5.hashCode()
                r3 = 1821585647(0x6c9330ef, float:1.4235454E27)
                if (r2 == r3) goto Ld5
                r3 = 2116862345(0x7e2cc189, float:5.7408027E37)
                if (r2 == r3) goto L30
                goto Le7
            L30:
                java.lang.String r2 = "android.bluetooth.device.action.BOND_STATE_CHANGED"
                boolean r5 = r5.equals(r2)
                if (r5 != 0) goto L3a
                goto Le7
            L3a:
                java.lang.String r5 = "android.bluetooth.device.extra.DEVICE"
                android.os.Parcelable r5 = r6.getParcelableExtra(r5)
                android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5
                if (r5 != 0) goto L45
                return
            L45:
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r5)
                java.lang.String r6 = r5.getAddress()
                com.szabh.smable3.component.BleCache r2 = com.szabh.smable3.component.BleCache.INSTANCE
                java.lang.String r2 = r2.getMBleAddress()
                boolean r6 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r6, r2)
                if (r6 != 0) goto L59
                return
            L59:
                int r6 = r5.getBondState()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "BluetoothReceiver onReceive ACTION_BOND_STATE_CHANGED -> device = "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r5 = ", bondState = "
                r2.append(r5)
                r2.append(r6)
                java.lang.String r5 = ", bondFailedTime = "
                r2.append(r5)
                int r5 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getBondFailedTime$p(r0)
                r2.append(r5)
                java.lang.String r5 = r2.toString()
                r1.oIX0oI(r5)
                r5 = 10
                r1 = 1
                if (r6 == r5) goto La4
                r5 = 12
                if (r6 == r5) goto L8f
                goto Le7
            L8f:
                com.sma.smartv3.pop.I0X0x0oIo r5 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getMLoadingPopup$p(r0)
                if (r5 == 0) goto L98
                r5.dismiss()
            L98:
                android.widget.Button r5 = r0.getBtnSet()
                r6 = 4
                r5.setVisibility(r6)
                com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$doPairDone(r0, r1)
                goto Le7
            La4:
                com.sma.smartv3.pop.I0X0x0oIo r5 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getMLoadingPopup$p(r0)
                if (r5 == 0) goto Lad
                r5.dismiss()
            Lad:
                int r5 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getBondFailedTime$p(r0)
                int r5 = r5 + r1
                com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$setBondFailedTime$p(r0, r5)
                int r5 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getBondFailedTime$p(r0)
                int r6 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getBOUND_MAX_TIME$p(r0)
                if (r5 < r6) goto Le7
                r5 = 0
                com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$doPairDone(r0, r5)
                android.widget.Button r6 = r0.getBtnSet()
                r1 = 2132021286(0x7f141026, float:1.968096E38)
                r6.setText(r1)
                android.widget.TextView r6 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getTvHighTip(r0)
                r6.setVisibility(r5)
                goto Le7
            Ld5:
                java.lang.String r6 = "android.bluetooth.device.action.ACL_DISCONNECTED"
                boolean r5 = r5.equals(r6)
                if (r5 != 0) goto Lde
                goto Le7
            Lde:
                com.sma.smartv3.pop.I0X0x0oIo r5 = com.sma.smartv3.ui.device.guide.HIDGuideFragment.access$getMLoadingPopup$p(r0)
                if (r5 == 0) goto Le7
                r5.dismiss()
            Le7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.guide.HIDGuideFragment$mBluetoothReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPairDone(boolean z) {
        this.canSwipe = true;
        if (z) {
            x0xO0oo.oIX0oI(x0xO0oo.f24572IO, Boolean.FALSE);
        }
        AppGuideActivity appGuideActivity = getAppGuideActivity();
        if (appGuideActivity != null) {
            appGuideActivity.setSwipe(true);
            if (z) {
                appGuideActivity.getNext().setText(R.string.next);
            } else {
                appGuideActivity.getNext().setText(R.string.ignore);
            }
        }
    }

    private final AppGuideActivity getAppGuideActivity() {
        if (getMActivity() instanceof AppGuideActivity) {
            Activity mActivity = getMActivity();
            IIX0o.x0XOIxOo(mActivity, "null cannot be cast to non-null type com.sma.smartv3.ui.device.guide.AppGuideActivity");
            return (AppGuideActivity) mActivity;
        }
        return null;
    }

    private final Spanned getTip(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String string = getString(i);
        IIX0o.oO(string, "getString(...)");
        sb.append(OxI.IIOIX(string, "\n", "<br>", false, 4, null));
        sb.append("<br><br><font color = ");
        sb.append(tipColor());
        sb.append(kotlin.text.XIxXXX0x0.f29545XO);
        String string2 = getString(i2);
        IIX0o.oO(string2, "getString(...)");
        sb.append(OxI.IIOIX(string2, "\n", "<br>", false, 4, null));
        sb.append("</font>");
        Spanned fromHtml = Html.fromHtml(sb.toString());
        IIX0o.oO(fromHtml, "fromHtml(...)");
        return fromHtml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvHighTip() {
        return (TextView) this.tvHighTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(HIDGuideFragment this$0, View view, int i, KeyEvent keyEvent) {
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

    public final boolean getCanSwipe() {
        return this.canSwipe;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.oIX0oI oix0oi = com.sma.smartv3.util.oIX0oI.f24510oIX0oI;
        Activity mActivity = getMActivity();
        HIDGuideFragment$mBluetoothReceiver$1 hIDGuideFragment$mBluetoothReceiver$1 = this.mBluetoothReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        oix0oi.oIX0oI(mActivity, hIDGuideFragment$mBluetoothReceiver$1, intentFilter, 2);
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvPic().setImageResource(R.drawable.pic_guide_hid_pair);
        getTvTitle().setText(R.string.guide_hid_pair_title);
        getTvTip().setText(R.string.guide_hid_pair_tip);
        if (this.bondFailedTime >= this.BOUND_MAX_TIME) {
            getTvHighTip().setVisibility(0);
            getBtnSet().setText(R.string.re_pair);
        } else {
            getTvHighTip().setVisibility(8);
            getBtnSet().setText(R.string.pairing);
        }
        getBtnSet().setOnKeyListener(new View.OnKeyListener() { // from class: com.sma.smartv3.ui.device.guide.XO
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean initView$lambda$1;
                initView$lambda$1 = HIDGuideFragment.initView$lambda$1(HIDGuideFragment.this, view, i, keyEvent);
                return initView$lambda$1;
            }
        });
        if (BleConnector.INSTANCE.isBoundHID()) {
            getBtnSet().setVisibility(4);
            doPairDone(true);
        } else {
            getBtnSet().setVisibility(0);
        }
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
        if (this.bondFailedTime >= this.BOUND_MAX_TIME) {
            x0xO0oo.II0xO0(x0xO0oo.f24565I0oOoX, null, 2, null);
            AppGuideActivity appGuideActivity = getAppGuideActivity();
            if (appGuideActivity != null) {
                appGuideActivity.setNeedConnectHID(false);
            }
            getMActivity().finish();
            return;
        }
        if (this.mLoadingPopup == null) {
            this.mLoadingPopup = new I0X0x0oIo(getMActivity());
        }
        I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.IIXOooo();
        }
        BleConnector.INSTANCE.connectHID();
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        TextView next;
        AppGuideActivity appGuideActivity = getAppGuideActivity();
        if (appGuideActivity != null && (next = appGuideActivity.getNext()) != null) {
            next.setText(R.string.next);
        }
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        AppGuideActivity appGuideActivity = getAppGuideActivity();
        if (appGuideActivity != null) {
            if (this.bondFailedTime >= this.BOUND_MAX_TIME) {
                appGuideActivity.getNext().setText(R.string.ignore);
            } else {
                appGuideActivity.getNext().setText(R.string.next);
            }
        }
    }

    public final void setCanSwipe(boolean z) {
        this.canSwipe = z;
    }
}
