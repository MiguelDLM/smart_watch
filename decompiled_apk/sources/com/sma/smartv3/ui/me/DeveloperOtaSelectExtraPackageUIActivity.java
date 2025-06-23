package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.ExtraPackageData;
import com.sma.smartv3.model.ExtraPackageDataList;
import com.sma.smartv3.model.FirmwareVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaSelectExtraPackageUIActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaSelectExtraPackageUIActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectExtraPackageUIActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n11#2,2:91\n19#2:93\n15#2:94\n11#2,2:113\n69#3,3:95\n72#3,5:99\n69#3,3:104\n72#3,5:108\n1#4:98\n1#4:107\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaSelectExtraPackageUIActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaSelectExtraPackageUIActivity\n*L\n32#1:91,2\n34#1:93\n34#1:94\n75#1:113,2\n43#1:95,3\n43#1:99,5\n86#1:104,3\n86#1:108,5\n43#1:98\n86#1:107\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaSelectExtraPackageUIActivity extends BaseListActivity<ExtraPackageData> {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelectRemind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectExtraPackageUIActivity$tvSelectRemind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectExtraPackageUIActivity.this.findViewById(R.id.tv_select_remind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSelect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectExtraPackageUIActivity$tvSelect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaSelectExtraPackageUIActivity.this.findViewById(R.id.tv_select);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btNext$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaSelectExtraPackageUIActivity$btNext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperOtaSelectExtraPackageUIActivity.this.findViewById(R.id.bt_next);
        }
    });

    @OXOo.OOXIXo
    private final ArrayList<ExtraPackageData> dataList = new ArrayList<>();

    @OXOo.OOXIXo
    private final ExtraPackVersions extraPackVersions = new ExtraPackVersions(null, null, null, null, null, null, 63, null);

    private final AppCompatButton getBtNext() {
        return (AppCompatButton) this.btNext$delegate.getValue();
    }

    private final TextView getTvSelect() {
        return (TextView) this.tvSelect$delegate.getValue();
    }

    private final TextView getTvSelectRemind() {
        return (TextView) this.tvSelectRemind$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$1$lambda$0(DeveloperOtaSelectExtraPackageUIActivity this$0, ExtraPackageData item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        this$0.getTvSelect().setText(item.getVersion() + "  -- " + item.getInfo());
        this$0.extraPackVersions.setUiPackVersion(new FirmwareVersion(item.getFileName(), item.getFileSize(), item.getFileUrl(), item.getVersion(), item.getInfo(), 0, null, null, null, 480, null));
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(ExtraPackVersions.class.getName(), new Gson().toJson(this$0.extraPackVersions));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.II0xO0().put(ExtraPackVersions.class.getName(), new Gson().toJson(this.extraPackVersions));
        SPUtils II0xO02 = xo0.II0xO0();
        Object extraPackageDataList = new ExtraPackageDataList(0, null, 3, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(ExtraPackageDataList.class.getName()), (Class<Object>) ExtraPackageDataList.class);
        if (fromJson != null) {
            extraPackageDataList = fromJson;
        }
        Iterator<ExtraPackageData> it = ((ExtraPackageDataList) extraPackageDataList).getData().iterator();
        while (it.hasNext()) {
            ExtraPackageData next = it.next();
            if (next.getType() == -1) {
                this.dataList.add(next);
            }
        }
        if (this.dataList.size() == 0) {
            startActivity(new Intent(this, (Class<?>) DeveloperOtaSelectExtraPackageLanguageActivity.class));
        }
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<ExtraPackageData> initList() {
        return this.dataList;
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTvSelectRemind().setText(R.string.select_remind_ui_pack);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return android.R.layout.simple_list_item_1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_ota_select_version_list;
    }

    public final void nextOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        getBtNext().setVisibility(8);
        startActivity(new Intent(this, (Class<?>) DeveloperOtaSelectExtraPackageLanguageActivity.class));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getBtNext().setVisibility(0);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo final ExtraPackageData item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(android.R.id.text1, "version:" + item.getVersion() + "\nfileName:" + item.getFileName() + "\nfirmwareVersion:" + item.getFirmwareVersion() + "\ninfo:" + item.getInfo());
        holder.oO(android.R.id.text1, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.OOXIxO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperOtaSelectExtraPackageUIActivity.initItem$lambda$1$lambda$0(DeveloperOtaSelectExtraPackageUIActivity.this, item, view);
            }
        });
    }
}
