package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ExtraPackageData;
import com.sma.smartv3.ui.device.LanguageRepairRActivity;
import com.sma.smartv3.ui.device.LanguageRepairSmaActivity;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.entity.Languages;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class LanguageListActivity extends BaseDSLRecyclerActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mRepairPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) LanguageListActivity.this.findViewById(R.id.root_view);
        }
    });
    private final String defaultLanguage = Locale.getDefault().getLanguage();

    /* loaded from: classes11.dex */
    public static final class oIX0oI implements com.sma.smartv3.biz.II0XooXoX<ExtraPackageData[]> {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.biz.II0XooXoX
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
            boolean z;
            if (extraPackageDataArr != null) {
                if (extraPackageDataArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    LanguageListActivity.this.showData(extraPackageDataArr);
                }
            }
        }

        @Override // com.sma.smartv3.biz.II0XooXoX
        public void onFailure(@OXOo.OOXIXo String error) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getRootView() {
        return (LinearLayout) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showData(final ExtraPackageData[] extraPackageDataArr) {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity$showData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslViewHolder dslViewHolder = LanguageListActivity.this.getDslViewHolder();
                final LanguageListActivity languageListActivity = LanguageListActivity.this;
                final ExtraPackageData[] extraPackageDataArr2 = extraPackageDataArr;
                dslViewHolder.post(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity$showData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        final LanguageListActivity languageListActivity2 = LanguageListActivity.this;
                        final ExtraPackageData[] extraPackageDataArr3 = extraPackageDataArr2;
                        languageListActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity.showData.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                for (final ExtraPackageData extraPackageData : extraPackageDataArr3) {
                                    if (extraPackageData.getType() != 3) {
                                        final LanguageListActivity languageListActivity3 = languageListActivity2;
                                        DslAdapterExKt.oO(renderAdapter2, R.layout.item_language_select, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity.showData.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                invoke2(dslAdapterItem);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                final LanguageListActivity languageListActivity4 = LanguageListActivity.this;
                                                final ExtraPackageData extraPackageData2 = extraPackageData;
                                                dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity.showData.1.1.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(4);
                                                    }

                                                    @Override // Oox.Oxx0xo
                                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                        invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                        String str;
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                        LanguageListActivity.this.getResources().getConfiguration().setLocale(Languages.codeToLanguage$default(Languages.INSTANCE, extraPackageData2.getType(), null, 2, null));
                                                        TextView tv = itemHolder.tv(R.id.languageName);
                                                        if (tv != null) {
                                                            tv.setText(LanguageListActivity.this.getResources().getConfiguration().locale.getDisplayName());
                                                        }
                                                        Configuration configuration = LanguageListActivity.this.getResources().getConfiguration();
                                                        str = LanguageListActivity.this.defaultLanguage;
                                                        configuration.setLocale(new Locale(str));
                                                    }
                                                });
                                                final ExtraPackageData extraPackageData3 = extraPackageData;
                                                final LanguageListActivity languageListActivity5 = LanguageListActivity.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity.showData.1.1.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo final View it) {
                                                        Activity mContext;
                                                        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
                                                        LinearLayout rootView;
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(ExtraPackageData.class.getName(), new Gson().toJson(ExtraPackageData.this));
                                                        LanguageListActivity languageListActivity6 = languageListActivity5;
                                                        mContext = languageListActivity5.getMContext();
                                                        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(mContext, 0, 2, null);
                                                        final LanguageListActivity languageListActivity7 = languageListActivity5;
                                                        xoI0Ixx02.IoOoX(R.string.language_repair_remind);
                                                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
                                                        xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.LanguageListActivity$showData$1$1$1$1$2$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // Oox.oIX0oI
                                                            @OXOo.OOXIXo
                                                            public final Boolean invoke() {
                                                                int O0Xx2 = ProductManager.f20544oIX0oI.O0Xx();
                                                                if (O0Xx2 == 0) {
                                                                    LanguageListActivity languageListActivity8 = LanguageListActivity.this;
                                                                    String obj = ((PFMedium) it.findViewById(R.id.languageName)).getText().toString();
                                                                    int mArg1 = LanguageListActivity.this.getMArg1();
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putString("mArg0", obj);
                                                                    bundle.putInt("mArg1", mArg1);
                                                                    bundle.putParcelable("mArg2", null);
                                                                    bundle.putSerializable("mArg3", null);
                                                                    Intent intent = new Intent(languageListActivity8, (Class<?>) LanguageRepairRActivity.class);
                                                                    intent.putExtras(bundle);
                                                                    languageListActivity8.startActivity(intent);
                                                                } else if (O0Xx2 != 1) {
                                                                    ToastUtils.showLong(R.string.stay_tuned);
                                                                } else {
                                                                    LanguageListActivity languageListActivity9 = LanguageListActivity.this;
                                                                    String obj2 = ((PFMedium) it.findViewById(R.id.languageName)).getText().toString();
                                                                    int mArg12 = LanguageListActivity.this.getMArg1();
                                                                    Bundle bundle2 = new Bundle();
                                                                    bundle2.putString("mArg0", obj2);
                                                                    bundle2.putInt("mArg1", mArg12);
                                                                    bundle2.putParcelable("mArg2", null);
                                                                    bundle2.putSerializable("mArg3", null);
                                                                    Intent intent2 = new Intent(languageListActivity9, (Class<?>) LanguageRepairSmaActivity.class);
                                                                    intent2.putExtras(bundle2);
                                                                    languageListActivity9.startActivity(intent2);
                                                                }
                                                                return Boolean.TRUE;
                                                            }
                                                        });
                                                        languageListActivity6.mRepairPopup = xoI0Ixx02;
                                                        xoI0Ixx0 = languageListActivity5.mRepairPopup;
                                                        if (xoI0Ixx0 != null) {
                                                            rootView = languageListActivity5.getRootView();
                                                            kotlin.jvm.internal.IIX0o.oO(rootView, "access$getRootView(...)");
                                                            xoI0Ixx0.OxxIIOOXO(rootView);
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(getMArg1());
        DeviceInfoChecker.Oo(DeviceInfoChecker.f19983oIX0oI, new oIX0oI(), null, 2, null);
        getRecyclerView().setHasFixedSize(false);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_language_list;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(1, 1));
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }
}
