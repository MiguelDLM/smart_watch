package com.sma.smartv3.ui.device;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.view.DfuProgress;
import com.szabh.smable3.component.BleConnector;

@SuppressLint({"Registered"})
/* loaded from: classes12.dex */
public abstract class BaseFirmwareRepairActivity extends BaseActivity {
    private boolean mStarted;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareRepairActivity$tvTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareRepairActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareRepairActivity$tvName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareRepairActivity.this.findViewById(R.id.tv_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSize$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareRepairActivity$tvSize$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareRepairActivity.this.findViewById(R.id.tv_size);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO dfuProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DfuProgress>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareRepairActivity$dfuProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DfuProgress invoke() {
            return (DfuProgress) BaseFirmwareRepairActivity.this.findViewById(R.id.dfu_progress);
        }
    });

    @OXOo.OOXIXo
    public final DfuProgress getDfuProgress() {
        Object value = this.dfuProgress$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (DfuProgress) value;
    }

    public final boolean getMStarted() {
        return this.mStarted;
    }

    @OXOo.OOXIXo
    public final TextView getTvName() {
        Object value = this.tvName$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvSize() {
        Object value = this.tvSize$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvTip() {
        Object value = this.tvTip$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.closeConnection(true);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void initView() {
        BleInitializer.f20700XO.xx0X0(true);
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.firmware_repair);
    }

    public boolean isNeedLaunch() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_firmware_repair;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleInitializer.f20700XO.xx0X0(false);
        if (isNeedLaunch()) {
            BleConnector.INSTANCE.launch();
        }
        super.onDestroy();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (!this.mStarted) {
            finish();
        }
    }

    public final void setMStarted(boolean z) {
        this.mStarted = z;
        if (z) {
            disableOrientation();
        }
    }
}
