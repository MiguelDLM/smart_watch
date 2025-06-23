package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionDataKt;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.ai.item.AISearchTopItem;
import com.sma.smartv3.ui.ai.item.SearchAIFillingItem;
import com.sma.smartv3.ui.ai.item.SearchAIFunctionItem;
import com.sma.smartv3.util.Xo0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nCourseSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseSearchActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseSearchActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,279:1\n65#2,16:280\n93#2,3:296\n1855#3,2:299\n1549#3:304\n1620#3,2:305\n1622#3:308\n39#4,3:301\n42#4:307\n44#4,2:309\n31#4,2:311\n*S KotlinDebug\n*F\n+ 1 CourseSearchActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseSearchActivity\n*L\n77#1:280,16\n77#1:296,3\n145#1:299,2\n157#1:304\n157#1:305,2\n157#1:308\n157#1:301,3\n157#1:307\n157#1:309,2\n239#1:311,2\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseSearchActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int SEARCH_FILLING = 255;
    private static final int SEARCH_INITIAL = 253;
    private static final int SEARCH_RESULT = 254;
    private boolean isProgrammaticallySet;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mAllDeleteTipPopup;

    @OXOo.oOoXoXO
    private List<String> mRecords;

    @OXOo.OOXIXo
    private final X0IIOO searchView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$searchView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CourseSearchActivity.this.findViewById(R.id.search_view);
        }
    });
    private int mAdapterType = 253;

    /* loaded from: classes12.dex */
    public static final class I0Io implements TextView.OnEditorActionListener {
        public I0Io() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@OXOo.oOoXoXO TextView textView, int i, @OXOo.oOoXoXO KeyEvent keyEvent) {
            if (i != 0 && i != 6) {
                return false;
            }
            Editable text = CourseSearchActivity.this.getSearchView().getText();
            CourseSearchActivity.this.saveRecords(text.toString());
            CourseSearchActivity.this.editChanged(text);
            return true;
        }
    }

    @XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 CourseSearchActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseSearchActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n78#2,4:98\n71#3:102\n77#4:103\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            if (!CourseSearchActivity.this.isProgrammaticallySet()) {
                CourseSearchActivity.this.editChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editChanged(Editable editable) {
        int i;
        if (editable != null && editable.length() == 0) {
            i = 253;
        } else {
            i = 255;
        }
        this.mAdapterType = i;
        notifyDataChanged(String.valueOf(editable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getSearchView() {
        return (EditText) this.searchView$delegate.getValue();
    }

    public static /* synthetic */ List initList$default(CourseSearchActivity courseSearchActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return courseSearchActivity.initList(str);
    }

    private final void showData(String str) {
        int i;
        final List<AIFunction> initList = initList(str);
        View findViewById = findViewById(R.id.rv_empty);
        if (initList.isEmpty() && this.mAdapterType != 253) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo final DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.clearAllItems();
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = CourseSearchActivity.this.getDslViewHolder();
                final CourseSearchActivity courseSearchActivity = CourseSearchActivity.this;
                final List<AIFunction> list = initList;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        int i2;
                        List list2;
                        List list3;
                        List list4;
                        i2 = CourseSearchActivity.this.mAdapterType;
                        switch (i2) {
                            case 253:
                                DslAdapter dslAdapter = renderAdapter;
                                list2 = CourseSearchActivity.this.mRecords;
                                IIX0o.ooOOo0oXI(list2);
                                DslAdapterExKt.x0xO0oo(dslAdapter, new AISearchTopItem(list2), new Oox.oOoXoXO<AISearchTopItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity.showData.1.1.1
                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AISearchTopItem aISearchTopItem) {
                                        invoke2(aISearchTopItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo AISearchTopItem dslItem) {
                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        dslItem.setItemSpanCount(-1);
                                    }
                                });
                                break;
                            case 254:
                                DslAdapter dslAdapter2 = renderAdapter;
                                list3 = CourseSearchActivity.this.mRecords;
                                IIX0o.ooOOo0oXI(list3);
                                DslAdapterExKt.x0xO0oo(dslAdapter2, new AISearchTopItem(list3), new Oox.oOoXoXO<AISearchTopItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity.showData.1.1.4
                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AISearchTopItem aISearchTopItem) {
                                        invoke2(aISearchTopItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo AISearchTopItem dslItem) {
                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        dslItem.setItemSpanCount(-1);
                                    }
                                });
                                List<AIFunction> list5 = list;
                                final CourseSearchActivity courseSearchActivity2 = CourseSearchActivity.this;
                                for (final AIFunction aIFunction : list5) {
                                    DslAdapterExKt.x0xO0oo(courseSearchActivity2.getDslAdapter(), new SearchAIFunctionItem(), new Oox.oOoXoXO<SearchAIFunctionItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showData$1$1$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SearchAIFunctionItem searchAIFunctionItem) {
                                            invoke2(searchAIFunctionItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo SearchAIFunctionItem dslItem) {
                                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            dslItem.setItemData(AIFunction.this);
                                            final CourseSearchActivity courseSearchActivity3 = courseSearchActivity2;
                                            final AIFunction aIFunction2 = AIFunction.this;
                                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showData$1$1$5$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // Oox.oOoXoXO
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                    invoke2(view);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@OXOo.OOXIXo View it) {
                                                    IIX0o.x0xO0oo(it, "it");
                                                    AIFunctionDataKt.toAIFunction(CourseSearchActivity.this, aIFunction2);
                                                }
                                            });
                                        }
                                    });
                                }
                                break;
                            case 255:
                                if (list.isEmpty()) {
                                    DslAdapter dslAdapter3 = renderAdapter;
                                    list4 = CourseSearchActivity.this.mRecords;
                                    IIX0o.ooOOo0oXI(list4);
                                    DslAdapterExKt.x0xO0oo(dslAdapter3, new AISearchTopItem(list4), new Oox.oOoXoXO<AISearchTopItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity.showData.1.1.2
                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AISearchTopItem aISearchTopItem) {
                                            invoke2(aISearchTopItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo AISearchTopItem dslItem) {
                                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            dslItem.setItemSpanCount(-1);
                                        }
                                    });
                                    break;
                                } else {
                                    List<AIFunction> list6 = list;
                                    final CourseSearchActivity courseSearchActivity3 = CourseSearchActivity.this;
                                    for (final AIFunction aIFunction2 : list6) {
                                        DslAdapterExKt.x0xO0oo(courseSearchActivity3.getDslAdapter(), new SearchAIFillingItem(), new Oox.oOoXoXO<SearchAIFillingItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showData$1$1$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SearchAIFillingItem searchAIFillingItem) {
                                                invoke2(searchAIFillingItem);
                                                return oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo final SearchAIFillingItem dslItem) {
                                                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                dslItem.setItemData(AIFunction.this);
                                                final CourseSearchActivity courseSearchActivity4 = courseSearchActivity3;
                                                final AIFunction aIFunction3 = AIFunction.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showData$1$1$3$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo View it) {
                                                        IIX0o.x0xO0oo(it, "it");
                                                        CourseSearchActivity.this.saveRecords(aIFunction3.getTitle());
                                                        SearchAIFillingItem searchAIFillingItem = dslItem;
                                                        final CourseSearchActivity courseSearchActivity5 = CourseSearchActivity.this;
                                                        final AIFunction aIFunction4 = aIFunction3;
                                                        searchAIFillingItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity.showData.1.1.3.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // Oox.oOoXoXO
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                                invoke2(view);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(@OXOo.OOXIXo View it2) {
                                                                IIX0o.x0xO0oo(it2, "it");
                                                                AIFunctionDataKt.toAIFunction(CourseSearchActivity.this, aIFunction4);
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                    break;
                                }
                        }
                        DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity.showData.1.1.6
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter4) {
                                invoke2(dslAdapter4);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                                IIX0o.x0xO0oo(render, "$this$render");
                                DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                            }
                        }, 3, null);
                    }
                });
            }
        });
    }

    public static /* synthetic */ void showData$default(CourseSearchActivity courseSearchActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        courseSearchActivity.showData(str);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    @OXOo.OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24623o0)
    public final void clearRecords(@OXOo.OOXIXo String item) {
        IIX0o.x0xO0oo(item, "item");
        showDeleteTipPopup();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @OXOo.OOXIXo
    public final List<AIFunction> initList(@OXOo.OOXIXo String newText) {
        IIX0o.x0xO0oo(newText, "newText");
        List<AIFunction> aIFunction = AIFunctionDataKt.getAIFunction();
        ArrayList arrayList = new ArrayList();
        if (newText.length() > 0) {
            for (AIFunction aIFunction2 : aIFunction) {
                if (StringsKt__StringsKt.ooO0oXxI(aIFunction2.getTitle(), newText, true)) {
                    arrayList.add(aIFunction2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.transparentStatusBar(this);
        getSearchView().setText("功能开发中..");
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        EditText searchView = getSearchView();
        IIX0o.oO(searchView, "<get-searchView>(...)");
        searchView.addTextChangedListener(new II0xO0());
        getSearchView().setOnEditorActionListener(new I0Io());
        notifyDataChanged("");
    }

    public final boolean isProgrammaticallySet() {
        return this.isProgrammaticallySet;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_search_func;
    }

    public final void notifyDataChanged(@OXOo.OOXIXo String item) {
        IIX0o.x0xO0oo(item, "item");
        showData(item);
        if (getDslAdapter() != null) {
            getDslAdapter().notifyDataSetChanged();
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24575Io)
    public final void onCodePairChange(@OXOo.OOXIXo String item) {
        IIX0o.x0xO0oo(item, "item");
        this.mAdapterType = 254;
        this.isProgrammaticallySet = true;
        getSearchView().setText(item);
        saveRecords(item);
        getSearchView().setSelection(item.length());
        this.isProgrammaticallySet = false;
        List<AIFunction> initList = initList(item);
        if (initList.size() == 1 && IIX0o.Oxx0IOOO(initList.get(0).getTitle(), item)) {
            AIFunctionDataKt.toAIFunction(this, initList.get(0));
        } else {
            notifyDataChanged(item);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        List ooXIXxIX2;
        super.onResume();
        if (getDslAdapter() != null) {
            try {
                JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(String.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
                IIX0o.ooOOo0oXI(asJsonArray);
                ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                Iterator<JsonElement> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    ooXIXxIX2.add(new Gson().fromJson(it.next(), String.class));
                }
            } catch (Exception unused) {
                ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            this.mRecords = ooXIXxIX2;
            getDslAdapter().notifyDataSetChanged();
        }
    }

    public final void onSearch(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        String obj = getSearchView().getText().toString();
        this.mAdapterType = 254;
        saveRecords(obj);
        notifyDataChanged(obj);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
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

    public final void saveRecords(@OXOo.OOXIXo String text) {
        List list;
        IIX0o.x0xO0oo(text, "text");
        List<String> list2 = this.mRecords;
        if (list2 != null) {
            list = CollectionsKt___CollectionsKt.o0Xo0XII(list2);
        } else {
            list = null;
        }
        IIX0o.ooOOo0oXI(list);
        if (!list.contains(text)) {
            if (list.size() > 10) {
                list.remove(0);
            }
            list.add(text);
            this.mRecords = CollectionsKt___CollectionsKt.oOo0o(list);
            Xo0.f24349oIX0oI.XO().put(String.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(list));
        }
    }

    public final void setProgrammaticallySet(boolean z) {
        this.isProgrammaticallySet = z;
    }

    public final void showDeleteTipPopup() {
        if (this.mAllDeleteTipPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.clear_ai_chat_records));
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showDeleteTipPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.course.CourseSearchActivity$showDeleteTipPopup$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    List list;
                    list = CourseSearchActivity.this.mRecords;
                    List o0Xo0XII = list != null ? CollectionsKt___CollectionsKt.o0Xo0XII(list) : null;
                    if (o0Xo0XII != null) {
                        o0Xo0XII.clear();
                    }
                    CourseSearchActivity.this.mRecords = o0Xo0XII != null ? CollectionsKt___CollectionsKt.oOo0o(o0Xo0XII) : null;
                    SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                    IIX0o.ooOOo0oXI(o0Xo0XII);
                    XO2.put(String.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
                    ToastUtils.showLong(R.string.clear_success);
                    CourseSearchActivity courseSearchActivity = CourseSearchActivity.this;
                    courseSearchActivity.notifyDataChanged(courseSearchActivity.getSearchView().getText().toString());
                    return Boolean.TRUE;
                }
            });
            this.mAllDeleteTipPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mAllDeleteTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }
}
