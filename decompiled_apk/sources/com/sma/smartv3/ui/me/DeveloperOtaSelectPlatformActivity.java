package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BleFirmwareInfo;
import com.sma.smartv3.model.BleFirmwareVersionInfoList;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.ExtraPackageData;
import com.sma.smartv3.model.ExtraPackageDataList;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.FirmwareVersionList;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaSelectPlatformActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaSelectPlatformActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectPlatformActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n27#2,2:74\n27#2,2:76\n27#2,2:78\n27#2,2:80\n27#2,2:82\n27#2,2:84\n27#2,2:86\n87#3,7:88\n94#3,3:96\n70#3,7:99\n97#3:106\n87#3,7:107\n94#3,3:115\n70#3,7:118\n97#3:125\n87#3,7:126\n94#3,3:134\n70#3,7:137\n97#3:144\n87#3,7:145\n94#3,3:153\n70#3,7:156\n97#3:163\n87#3,7:164\n94#3,3:172\n70#3,7:175\n97#3:182\n87#3,7:183\n94#3,3:191\n70#3,7:194\n97#3:201\n87#3,7:202\n94#3,3:210\n70#3,7:213\n97#3:220\n87#3,7:221\n94#3,3:229\n70#3,7:232\n97#3:239\n1#4:95\n1#4:114\n1#4:133\n1#4:152\n1#4:171\n1#4:190\n1#4:209\n1#4:228\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaSelectPlatformActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectPlatformActivity\n*L\n22#1:74,2\n23#1:76,2\n24#1:78,2\n25#1:80,2\n26#1:82,2\n27#1:84,2\n28#1:86,2\n34#1:88,7\n34#1:96,3\n34#1:99,7\n34#1:106\n39#1:107,7\n39#1:115,3\n39#1:118,7\n39#1:125\n44#1:126,7\n44#1:134,3\n44#1:137,7\n44#1:144\n49#1:145,7\n49#1:153,3\n49#1:156,7\n49#1:163\n54#1:164,7\n54#1:172,3\n54#1:175,7\n54#1:182\n59#1:183,7\n59#1:191,3\n59#1:194,7\n59#1:201\n64#1:202,7\n64#1:210,3\n64#1:213,7\n64#1:220\n69#1:221,7\n69#1:229,3\n69#1:232,7\n69#1:239\n34#1:95\n39#1:114\n44#1:133\n49#1:152\n54#1:171\n59#1:190\n64#1:209\n69#1:228\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaSelectPlatformActivity extends BaseActivity {
    public final void SIFLIOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 6);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 6);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void ZKLXOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 7);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 7);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void goodixOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 2);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void goodixOtaQ(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 4);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 4);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.II0xO0().remove(BleFirmwareInfo.class.getName());
        xo0.II0xO0().remove(BleFirmwareVersionInfoList.class.getName());
        xo0.II0xO0().remove(FirmwareVersion.class.getName());
        xo0.II0xO0().remove(FirmwareVersionList.class.getName());
        xo0.II0xO0().remove(ExtraPackageData.class.getName());
        xo0.II0xO0().remove(ExtraPackVersions.class.getName());
        xo0.II0xO0().remove(ExtraPackageDataList.class.getName());
    }

    public final void jlOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 5);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 5);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_ota_select_platform;
    }

    public final void mtkOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 3);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 3);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void nordicOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 1);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void realtekOta(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I, 0);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 0);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) DeveloperOtaSelectBleNameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
