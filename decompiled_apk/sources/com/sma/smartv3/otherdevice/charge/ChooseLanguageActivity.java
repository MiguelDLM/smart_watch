package com.sma.smartv3.otherdevice.charge;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.ItemSelectorHelperKt;
import com.angcyo.dsladapter.Xx000oIo;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nChooseLanguageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChooseLanguageActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChooseLanguageActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,220:1\n766#2:221\n857#2,2:222\n1549#2:227\n1620#2,2:228\n1622#2:231\n1747#2,3:234\n1549#2:258\n1620#2,3:259\n1855#2,2:262\n39#3,3:224\n42#3:230\n44#3,2:232\n31#3,2:237\n65#4,16:239\n93#4,3:255\n*S KotlinDebug\n*F\n+ 1 ChooseLanguageActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChooseLanguageActivity\n*L\n55#1:221\n55#1:222,2\n64#1:227\n64#1:228,2\n64#1:231\n71#1:234,3\n139#1:258\n139#1:259,3\n144#1:262,2\n64#1:224,3\n64#1:230\n64#1:232,2\n80#1:237,2\n97#1:239,16\n97#1:255,3\n*E\n"})
/* loaded from: classes12.dex */
public final class ChooseLanguageActivity extends BaseDSLRecyclerActivity {
    private boolean isSelectorAll;
    public LanguageTranslationData mLanguageTranslationData;
    private long textChangedLastTime;

    @OXOo.OOXIXo
    private final String TAG = "ChooseLanguageActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSearchEdit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$mSearchEdit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) ChooseLanguageActivity.this.findViewById(R.id.choose_language_search_text);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSearchIcon$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$mSearchIcon$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ChooseLanguageActivity.this.findViewById(R.id.choose_language_search_icon);
        }
    });

    @OXOo.OOXIXo
    private List<LanguageTranslationData> mAllLanguageList = new ArrayList();

    @OXOo.OOXIXo
    private List<LanguageTranslationData> mHistoryLanguageList = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements com.angcyo.dsladapter.Xx000oIo {
        public II0xO0() {
        }

        @Override // com.angcyo.dsladapter.Xx000oIo
        public void II0xO0(@OXOo.OOXIXo List<DslAdapterItem> selectorItems, @OXOo.OOXIXo List<Integer> selectorIndexList, boolean z, @OXOo.OOXIXo com.angcyo.dsladapter.IO selectorParams) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorItems, "selectorItems");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorIndexList, "selectorIndexList");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
            Xx000oIo.oIX0oI.oIX0oI(this, selectorItems, selectorIndexList, z, selectorParams);
            ChooseLanguageActivity.this.setSelectorAll(z);
        }

        @Override // com.angcyo.dsladapter.Xx000oIo
        public void oIX0oI(int i, int i2) {
            Xx000oIo.oIX0oI.II0xO0(this, i, i2);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 ChooseLanguageActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChooseLanguageActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n98#2,6:98\n71#3:104\n77#4:105\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - ChooseLanguageActivity.this.getTextChangedLastTime() > 500) {
                ChooseLanguageActivity.this.setTextChangedLastTime(currentTimeMillis);
                ChooseLanguageActivity.this.searchName(StringsKt__StringsKt.oIoIXxIO(String.valueOf(editable)).toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ChooseLanguageActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.searchName(StringsKt__StringsKt.oIoIXxIO(this$0.getMSearchEdit().getText().toString()).toString());
    }

    public final void getHistoryLanguageList() {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(LanguageTranslationData.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), LanguageTranslationData.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.mHistoryLanguageList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getMLanguageTranslationData() {
        LanguageTranslationData languageTranslationData = this.mLanguageTranslationData;
        if (languageTranslationData != null) {
            return languageTranslationData;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mLanguageTranslationData");
        return null;
    }

    public final EditText getMSearchEdit() {
        return (EditText) this.mSearchEdit$delegate.getValue();
    }

    public final ImageView getMSearchIcon() {
        return (ImageView) this.mSearchIcon$delegate.getValue();
    }

    public final long getTextChangedLastTime() {
        return this.textChangedLastTime;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.LanguageTranslationData");
        setMLanguageTranslationData((LanguageTranslationData) mArg3);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(getString(R.string.translation_language));
        EditText mSearchEdit = getMSearchEdit();
        kotlin.jvm.internal.IIX0o.oO(mSearchEdit, "<get-mSearchEdit>(...)");
        mSearchEdit.addTextChangedListener(new oIX0oI());
        getMSearchIcon().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.Xx000oIo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseLanguageActivity.initView$lambda$3(ChooseLanguageActivity.this, view);
            }
        });
        getDslAdapter().getItemSelectorHelper().oo(new II0xO0());
        getDslAdapter().getItemSelectorHelper().ooXIXxIX(new com.angcyo.dsladapter.IO(null, ItemSelectorHelperKt.xoXoI(false), false, false, false, null, false, false, false, null, 1021, null));
        getDslAdapter().getItemSelectorHelper().IoOoX(1);
    }

    public final boolean isSelectorAll() {
        return this.isSelectorAll;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_choose_language;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        getHistoryLanguageList();
        LanguageTranslationKt.clearTranslationLanguageList();
        List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(LanguageTranslationKt.getTranslationLanguageList());
        if (this.mHistoryLanguageList.size() > 0) {
            List<LanguageTranslationData> list = this.mHistoryLanguageList;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((LanguageTranslationData) it.next()).getName());
            }
            final Set XxI0 = CollectionsKt___CollectionsKt.XxI0(arrayList);
            kotlin.collections.OxI.xOoOIoI(o0Xo0XII, new Oox.oOoXoXO<LanguageTranslationData, Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$onInitBaseLayoutAfter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo LanguageTranslationData it2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                    return Boolean.valueOf(XxI0.contains(it2.getName()));
                }
            });
            String string = getString(R.string.choose_language_all);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            o0Xo0XII.add(0, new LanguageTranslationData(string, null, null, null, false, 0, null, 1, 126, null));
            Iterator<T> it2 = this.mHistoryLanguageList.iterator();
            while (it2.hasNext()) {
                o0Xo0XII.add(0, (LanguageTranslationData) it2.next());
            }
            String string2 = getString(R.string.choose_language_recently_used);
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            o0Xo0XII.add(0, new LanguageTranslationData(string2, null, null, null, false, 0, null, 1, 126, null));
        } else {
            String string3 = getString(R.string.choose_language_all);
            kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
            o0Xo0XII.add(0, new LanguageTranslationData(string3, null, null, null, false, 0, null, 1, 126, null));
        }
        this.mAllLanguageList.addAll(o0Xo0XII);
        setData(this.mAllLanguageList);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void putHistoryLanguageList(@OXOo.OOXIXo LanguageTranslationData mLanguageTranslationData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mLanguageTranslationData, "mLanguageTranslationData");
        List<LanguageTranslationData> list = this.mHistoryLanguageList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((LanguageTranslationData) it.next()).getName(), mLanguageTranslationData.getName())) {
                    break;
                }
            }
        }
        if (this.mHistoryLanguageList.size() < 3) {
            this.mHistoryLanguageList.add(mLanguageTranslationData);
        } else {
            this.mHistoryLanguageList.remove(0);
            this.mHistoryLanguageList.add(mLanguageTranslationData);
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + "  putHistoryLanguageList  mHistoryLanguageList = " + this.mHistoryLanguageList + "  mLanguageTranslationData = " + mLanguageTranslationData);
        SPUtils oIX0oI2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI();
        List<LanguageTranslationData> list2 = this.mHistoryLanguageList;
        StringBuilder sb = new StringBuilder();
        sb.append(LanguageTranslationData.class.getName());
        sb.append(oOXoIIIo.XO.f32008oIX0oI);
        oIX0oI2.put(sb.toString(), new Gson().toJson(list2));
        saveListSuccess();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    public final void saveListSuccess() {
        Intent intent = getIntent();
        intent.putExtra("language", getMLanguageTranslationData());
        setResult(-1, intent);
        finish();
    }

    public final void searchName(@OXOo.OOXIXo String text) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        if (text.length() == 0) {
            setData(this.mAllLanguageList);
            return;
        }
        List<LanguageTranslationData> list = this.mAllLanguageList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (StringsKt__StringsKt.o00xOoIO(((LanguageTranslationData) obj).getName(), text, false, 2, null)) {
                arrayList.add(obj);
            }
        }
        setData(arrayList);
    }

    public final void setData(@OXOo.OOXIXo final List<LanguageTranslationData> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        if (list.isEmpty()) {
            return;
        }
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$setData$1
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
            public final void invoke2(@OXOo.OOXIXo final DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                ChooseLanguageActivity.this.getDslAdapter().clearAllItems();
                renderAdapter.getItemSelectorHelper().IoOoX(1);
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = ChooseLanguageActivity.this.getDslViewHolder();
                final List<LanguageTranslationData> list2 = list;
                final ChooseLanguageActivity chooseLanguageActivity = ChooseLanguageActivity.this;
                dslViewHolder.postDelay(50L, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$setData$1.1
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
                        for (final LanguageTranslationData languageTranslationData : list2) {
                            if (languageTranslationData.getType() == 1) {
                                DslAdapterExKt.oO(chooseLanguageActivity.getDslAdapter(), R.layout.item_list_choose_language_title, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity.setData.1.1.1
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
                                        final LanguageTranslationData languageTranslationData2 = LanguageTranslationData.this;
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity.setData.1.1.1.1
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list3) {
                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list3);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> list3) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list3, "<anonymous parameter 3>");
                                                TextView tv = itemHolder.tv(R.id.tv);
                                                if (tv == null) {
                                                    return;
                                                }
                                                tv.setText(LanguageTranslationData.this.getName());
                                            }
                                        });
                                    }
                                });
                            } else {
                                DslAdapter dslAdapter = chooseLanguageActivity.getDslAdapter();
                                final ChooseLanguageActivity chooseLanguageActivity2 = chooseLanguageActivity;
                                final DslAdapter dslAdapter2 = renderAdapter;
                                DslAdapterExKt.oO(dslAdapter, R.layout.item_list_choose_language, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity.setData.1.1.2

                                    /* renamed from: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$setData$1$1$2$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes12.dex */
                                    public static final class C09301 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                        final /* synthetic */ LanguageTranslationData $item;
                                        final /* synthetic */ DslAdapter $this_renderAdapter;
                                        final /* synthetic */ ChooseLanguageActivity this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public C09301(LanguageTranslationData languageTranslationData, ChooseLanguageActivity chooseLanguageActivity, DslAdapter dslAdapter) {
                                            super(4);
                                            this.$item = languageTranslationData;
                                            this.this$0 = chooseLanguageActivity;
                                            this.$this_renderAdapter = dslAdapter;
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$0(ChooseLanguageActivity this$0, LanguageTranslationData item, ImageView imageView, DslAdapter this_renderAdapter, View view) {
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(this_renderAdapter, "$this_renderAdapter");
                                            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(this$0.getMLanguageTranslationData().getName(), item.getName())) {
                                                Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.file_check_icon)).into(imageView);
                                                this$0.setMLanguageTranslationData(item);
                                                this_renderAdapter.notifyDataChanged();
                                                this$0.putHistoryLanguageList(item);
                                                return;
                                            }
                                            this$0.finish();
                                        }

                                        @Override // Oox.Oxx0xo
                                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                                        }

                                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                            TextView tv = itemHolder.tv(R.id.tv);
                                            if (tv != null) {
                                                tv.setText(this.$item.getName());
                                            }
                                            final ImageView img = itemHolder.img(R.id.list_item_choose_iv);
                                            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.this$0.getMLanguageTranslationData().getName(), this.$item.getName())) {
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(img);
                                                Glide.with(img.getContext()).load(Integer.valueOf(R.drawable.file_check_icon)).into(img);
                                            } else {
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(img);
                                                Glide.with(img.getContext()).load(Integer.valueOf(R.drawable.file_uncheck_icon)).into(img);
                                            }
                                            View view = itemHolder.itemView;
                                            final ChooseLanguageActivity chooseLanguageActivity = this.this$0;
                                            final LanguageTranslationData languageTranslationData = this.$item;
                                            final DslAdapter dslAdapter = this.$this_renderAdapter;
                                            view.setOnClickListener(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007f: INVOKE 
                                                  (r3v1 'view' android.view.View)
                                                  (wrap:android.view.View$OnClickListener:0x007c: CONSTRUCTOR 
                                                  (r5v8 'chooseLanguageActivity' com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity A[DONT_INLINE])
                                                  (r6v5 'languageTranslationData' com.sma.smartv3.model.LanguageTranslationData A[DONT_INLINE])
                                                  (r4v7 'img' android.widget.ImageView A[DONT_INLINE])
                                                  (r0v0 'dslAdapter' com.angcyo.dsladapter.DslAdapter A[DONT_INLINE])
                                                 A[MD:(com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity, com.sma.smartv3.model.LanguageTranslationData, android.widget.ImageView, com.angcyo.dsladapter.DslAdapter):void (m), WRAPPED] call: com.sma.smartv3.otherdevice.charge.X00IoxXI.<init>(com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity, com.sma.smartv3.model.LanguageTranslationData, android.widget.ImageView, com.angcyo.dsladapter.DslAdapter):void type: CONSTRUCTOR)
                                                 VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity.setData.1.1.2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.X00IoxXI, state: NOT_LOADED
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
                                                java.lang.String r4 = "itemHolder"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r4)
                                                java.lang.String r4 = "adapterItem"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                                                java.lang.String r4 = "<anonymous parameter 3>"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r4)
                                                r4 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                                android.widget.TextView r4 = r3.tv(r4)
                                                if (r4 != 0) goto L19
                                                goto L22
                                            L19:
                                                com.sma.smartv3.model.LanguageTranslationData r5 = r2.$item
                                                java.lang.String r5 = r5.getName()
                                                r4.setText(r5)
                                            L22:
                                                r4 = 2131365828(0x7f0a0fc4, float:1.8351532E38)
                                                android.widget.ImageView r4 = r3.img(r4)
                                                com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity r5 = r2.this$0
                                                com.sma.smartv3.model.LanguageTranslationData r5 = r5.getMLanguageTranslationData()
                                                java.lang.String r5 = r5.getName()
                                                com.sma.smartv3.model.LanguageTranslationData r6 = r2.$item
                                                java.lang.String r6 = r6.getName()
                                                boolean r5 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r5, r6)
                                                if (r5 == 0) goto L59
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r4)
                                                android.content.Context r5 = r4.getContext()
                                                com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.with(r5)
                                                r6 = 2131233517(0x7f080aed, float:1.8083174E38)
                                                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                                                com.bumptech.glide.RequestBuilder r5 = r5.load(r6)
                                                r5.into(r4)
                                                goto L72
                                            L59:
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r4)
                                                android.content.Context r5 = r4.getContext()
                                                com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.with(r5)
                                                r6 = 2131233518(0x7f080aee, float:1.8083176E38)
                                                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                                                com.bumptech.glide.RequestBuilder r5 = r5.load(r6)
                                                r5.into(r4)
                                            L72:
                                                android.view.View r3 = r3.itemView
                                                com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity r5 = r2.this$0
                                                com.sma.smartv3.model.LanguageTranslationData r6 = r2.$item
                                                com.angcyo.dsladapter.DslAdapter r0 = r2.$this_renderAdapter
                                                com.sma.smartv3.otherdevice.charge.X00IoxXI r1 = new com.sma.smartv3.otherdevice.charge.X00IoxXI
                                                r1.<init>(r5, r6, r4, r0)
                                                r3.setOnClickListener(r1)
                                                r3 = 0
                                                r4.setVisibility(r3)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity$setData$1.AnonymousClass1.AnonymousClass2.C09301.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                                        }
                                    }

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
                                        dslItem.setItemBindOverride(new C09301(LanguageTranslationData.this, chooseLanguageActivity2, dslAdapter2));
                                    }
                                });
                            }
                        }
                        DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChooseLanguageActivity.setData.1.1.3
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter3) {
                                invoke2(dslAdapter3);
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

    public final void setMLanguageTranslationData(@OXOo.OOXIXo LanguageTranslationData languageTranslationData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(languageTranslationData, "<set-?>");
        this.mLanguageTranslationData = languageTranslationData;
    }

    public final void setSelectorAll(boolean z) {
        this.isSelectorAll = z;
    }

    public final void setTextChangedLastTime(long j) {
        this.textChangedLastTime = j;
    }
}
