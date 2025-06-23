package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairModeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairModeActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairModeActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n11#2,2:54\n69#3,3:56\n72#3,5:60\n1#4:59\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairModeActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairModeActivity\n*L\n37#1:54,2\n43#1:56,3\n43#1:60,5\n43#1:59\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairModeActivity extends BaseListActivity<String> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$1(FirmwareRepairModeActivity this$0, String item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_REALTEK)) {
            SPUtils II0xO02 = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0();
            FirmwareVersion firmwareVersion = new FirmwareVersion(null, 0, null, null, null, 0, null, null, null, 511, null);
            firmwareVersion.setFileUrl(item);
            String substring = firmwareVersion.getFileUrl().substring(StringsKt__StringsKt.XIxO(firmwareVersion.getFileUrl(), IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, null) + 1);
            kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
            firmwareVersion.setFileName(substring);
            II0xO02.put(FirmwareVersion.class.getName(), new Gson().toJson(firmwareVersion));
            this$0.startActivity(new Intent(this$0, (Class<?>) FirmwareRepairRActivity.class));
            return;
        }
        ToastUtils.showLong(R.string.stay_tuned);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<String> initList() {
        return CollectionsKt___CollectionsKt.o0Xo0XII(ProductManager.f20544oIX0oI.oxxXoxO());
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.firmware_repair_mode);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_common;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_firmware_repair_mode;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo final String item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        ((TextView) holder.X0o0xo(R.id.tv_name)).setText(getString(R.string.firmware_repair_mode) + TokenParser.SP + (i + 1));
        ((LinearLayout) holder.X0o0xo(R.id.ll_item_panel)).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.xXOx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareRepairModeActivity.initItem$lambda$1(FirmwareRepairModeActivity.this, item, view);
            }
        });
    }
}
