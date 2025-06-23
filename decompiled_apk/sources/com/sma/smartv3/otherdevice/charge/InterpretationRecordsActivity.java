package com.sma.smartv3.otherdevice.charge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIFunctionType;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes12.dex */
public final class InterpretationRecordsActivity extends BaseDSLRecyclerActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mAllDeleteTipPopup;
    private List<AIRecords> mList;

    @OXOo.OOXIXo
    private final String TAG = "InterpretationRecordsActivity";

    @OXOo.OOXIXo
    private final AIRecordsDao mRecordsDao = MyDb.INSTANCE.getMDatabase().aiRecordsDao();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) InterpretationRecordsActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    private final void setList() {
        initList();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append(" list = ");
        List<AIRecords> list = this.mList;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
            list = null;
        }
        sb.append(list.size());
        oix0oi.oIX0oI(sb.toString());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity$setList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo final DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                InterpretationRecordsActivity.this.getDslAdapter().clearAllItems();
                renderAdapter.getItemSelectorHelper().IoOoX(1);
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = InterpretationRecordsActivity.this.getDslViewHolder();
                final InterpretationRecordsActivity interpretationRecordsActivity = InterpretationRecordsActivity.this;
                dslViewHolder.postDelay(500L, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity$setList$1.1
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
                        List<AIRecords> list2;
                        list2 = InterpretationRecordsActivity.this.mList;
                        if (list2 == null) {
                            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                            list2 = null;
                        }
                        for (final AIRecords aIRecords : list2) {
                            DslAdapter dslAdapter = InterpretationRecordsActivity.this.getDslAdapter();
                            final InterpretationRecordsActivity interpretationRecordsActivity2 = InterpretationRecordsActivity.this;
                            DslAdapterExKt.oO(dslAdapter, R.layout.item_list_interpretation_records, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity.setList.1.1.1
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
                                    final InterpretationRecordsActivity interpretationRecordsActivity3 = InterpretationRecordsActivity.this;
                                    final AIRecords aIRecords2 = aIRecords;
                                    dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity.setList.1.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(4);
                                        }

                                        @Override // Oox.Oxx0xo
                                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list3) {
                                            invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list3);
                                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                                        }

                                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> list3) {
                                            String str;
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(list3, "<anonymous parameter 3>");
                                            OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                                            StringBuilder sb2 = new StringBuilder();
                                            str = InterpretationRecordsActivity.this.TAG;
                                            sb2.append(str);
                                            sb2.append(" mAIRecords item = ");
                                            sb2.append(aIRecords2);
                                            oix0oi2.oIX0oI(sb2.toString());
                                            TextView tv = itemHolder.tv(R.id.interpretation_records_language_left_tv);
                                            if (tv != null) {
                                                tv.setText(InterpretationRecordsActivity.this.getString(R.string.save_recording_translate) + ':');
                                            }
                                            TextView tv2 = itemHolder.tv(R.id.interpretation_records_language);
                                            if (tv2 != null) {
                                                tv2.setText(aIRecords2.getMTranslateLanguage());
                                            }
                                            TextView tv3 = itemHolder.tv(R.id.interpretation_records_to_language);
                                            if (tv3 != null) {
                                                tv3.setText(aIRecords2.getMTranslateToLanguage());
                                            }
                                            TextView tv4 = itemHolder.tv(R.id.interpretation_records_duration);
                                            if (tv4 != null) {
                                                tv4.setText(InterpretationRecordsActivity.this.getString(R.string.action_details) + ": " + com.sma.smartv3.util.xoIox.Io(aIRecords2.getMAudioDuration()));
                                            }
                                            TextView tv5 = itemHolder.tv(R.id.interpretation_records_title);
                                            if (tv5 != null) {
                                                tv5.setText(aIRecords2.getMAITitle());
                                            }
                                            TextView tv6 = itemHolder.tv(R.id.interpretation_records_content);
                                            if (tv6 != null) {
                                                tv6.setText(aIRecords2.getMContent() + aIRecords2.getMExtraInfo());
                                            }
                                            TextView tv7 = itemHolder.tv(R.id.interpretation_records_location);
                                            if (tv7 != null) {
                                                String mLocation = aIRecords2.getMLocation();
                                                if (mLocation.length() == 0) {
                                                    mLocation = HelpFormatter.DEFAULT_OPT_PREFIX;
                                                }
                                                tv7.setText(mLocation);
                                            }
                                            TextView tv8 = itemHolder.tv(R.id.interpretation_records_time);
                                            if (tv8 != null) {
                                                tv8.setText(aIRecords2.getMLocalTime());
                                            }
                                            final InterpretationRecordsActivity interpretationRecordsActivity4 = InterpretationRecordsActivity.this;
                                            final AIRecords aIRecords3 = aIRecords2;
                                            itemHolder.clickItem(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity.setList.1.1.1.1.2
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
                                                public final void invoke2(@OXOo.OOXIXo View it) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                    InterpretationRecordsActivity interpretationRecordsActivity5 = InterpretationRecordsActivity.this;
                                                    AIRecords aIRecords4 = aIRecords3;
                                                    Bundle bundle = new Bundle();
                                                    bundle.putString("mArg0", null);
                                                    bundle.putParcelable("mArg2", null);
                                                    bundle.putSerializable("mArg3", aIRecords4);
                                                    Intent intent = new Intent(interpretationRecordsActivity5, (Class<?>) InterpretationRecordsDetailActivity.class);
                                                    intent.putExtras(bundle);
                                                    interpretationRecordsActivity5.startActivity(intent);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                        DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity.setList.1.1.2
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                                invoke2(dslAdapter2);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(render, "$this$render");
                                DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                            }
                        }, 3, null);
                    }
                });
            }
        });
    }

    public final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AIRecordsDao getMRecordsDao() {
        return this.mRecordsDao;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @OXOo.OOXIXo
    public final List<AIRecords> initList() {
        List<AIRecords> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.mRecordsDao.getListDESC(AIFunctionType.SIMULTANEOUS_INTERPRETATION.getType()));
        this.mList = o0Xo0XII;
        if (o0Xo0XII == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
            return null;
        }
        return o0Xo0XII;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(getString(R.string.interpretation_record));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_interpretation_records;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        setList();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24609XIXIxO)
    public final void onRefreshList(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onFirmwareRepair");
        setList();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showDeleteTipPopup();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    public final void showDeleteTipPopup() {
        if (this.mAllDeleteTipPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.clear_ai_chat_list));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity$showDeleteTipPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.InterpretationRecordsActivity$showDeleteTipPopup$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    List<AIRecords> list;
                    List<AIRecords> list2;
                    List list3;
                    list = InterpretationRecordsActivity.this.mList;
                    if (list == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list = null;
                    }
                    for (AIRecords aIRecords : list) {
                        aIRecords.setMIsDelete(1);
                        aIRecords.setMIsSync(0);
                    }
                    AIRecordsDao mRecordsDao = InterpretationRecordsActivity.this.getMRecordsDao();
                    list2 = InterpretationRecordsActivity.this.mList;
                    if (list2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list2 = null;
                    }
                    mRecordsDao.update(list2);
                    list3 = InterpretationRecordsActivity.this.mList;
                    if (list3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list3 = null;
                    }
                    list3.clear();
                    InterpretationRecordsActivity.this.getDslAdapter().clearAllItems();
                    InterpretationRecordsActivity.this.getDslAdapter().notifyDataSetChanged();
                    ToastUtils.showLong(R.string.clear_success);
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24646oxxXoxO, null, 2, null);
                    return Boolean.TRUE;
                }
            });
            this.mAllDeleteTipPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mAllDeleteTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }
}
