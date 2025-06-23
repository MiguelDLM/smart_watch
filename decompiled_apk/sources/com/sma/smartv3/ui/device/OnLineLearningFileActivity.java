package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.ItemSelectorHelperKt;
import com.angcyo.dsladapter.Xx000oIo;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppFileDetail;
import com.sma.smartv3.model.AppStoreFileList;
import com.sma.smartv3.model.AppStoreFileManager;
import com.sma.smartv3.model.AudioBookItem;
import com.sma.smartv3.model.LearnCardDataItem;
import com.sma.smartv3.model.LearnCardItemList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

@kotlin.jvm.internal.XX({"SMAP\nOnLineLearningFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnLineLearningFileActivity.kt\ncom/sma/smartv3/ui/device/OnLineLearningFileActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,356:1\n50#2,3:357\n53#2:363\n55#2,2:365\n1549#3:360\n1620#3,2:361\n1622#3:364\n1549#3:367\n1620#3,3:368\n*S KotlinDebug\n*F\n+ 1 OnLineLearningFileActivity.kt\ncom/sma/smartv3/ui/device/OnLineLearningFileActivity\n*L\n61#1:357,3\n61#1:363\n61#1:365,2\n61#1:360\n61#1:361,2\n61#1:364\n332#1:367\n332#1:368,3\n*E\n"})
/* loaded from: classes12.dex */
public final class OnLineLearningFileActivity extends BaseDSLRecyclerActivity {
    private boolean isSelectorAll;
    private int mChooseNumber;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvFreeSpace$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$tvFreeSpace$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) OnLineLearningFileActivity.this.findViewById(R.id.tv_free_space);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mButton$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$mButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) OnLineLearningFileActivity.this.findViewById(R.id.online_learning_button);
        }
    });
    private final boolean openChooseType = true;

    @OXOo.OOXIXo
    private List<AudioBookItem> mChooseAudioBookItem = new ArrayList();

    @OXOo.OOXIXo
    private List<AudioBookItem> mAlreadyHaveList = new ArrayList();

    @OXOo.OOXIXo
    private final List<AudioBookItem> mOnLineAudioBookItemFiles = new ArrayList();

    @OXOo.OOXIXo
    private final List<LearnCardItemList> mFileTypeFiles = new ArrayList();

    @OXOo.OOXIXo
    private final List<DslAdapterItem> fixedItemList = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements com.angcyo.dsladapter.Xx000oIo {
        public oIX0oI() {
        }

        @Override // com.angcyo.dsladapter.Xx000oIo
        public void II0xO0(@OXOo.OOXIXo List<DslAdapterItem> selectorItems, @OXOo.OOXIXo List<Integer> selectorIndexList, boolean z, @OXOo.OOXIXo com.angcyo.dsladapter.IO selectorParams) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorItems, "selectorItems");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorIndexList, "selectorIndexList");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
            Xx000oIo.oIX0oI.oIX0oI(this, selectorItems, selectorIndexList, z, selectorParams);
            OnLineLearningFileActivity.this.setSelectorAll(z);
        }

        @Override // com.angcyo.dsladapter.Xx000oIo
        public void oIX0oI(int i, int i2) {
            Xx000oIo.oIX0oI.II0xO0(this, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAppStoreBinOnlinePath(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private final TextView getTvFreeSpace() {
        return (TextView) this.tvFreeSpace$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViewBg(View view, float f, float f2, float f3, float f4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{f, f, f3, f3, f4, f4, f2, f2});
        gradientDrawable.setColor(getResources().getColor(R.color.audio_book_tv_bg_color));
        if (view != null) {
            view.setBackground(gradientDrawable);
        }
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getFixedItemList() {
        return this.fixedItemList;
    }

    @OXOo.OOXIXo
    public final List<AudioBookItem> getMAlreadyHaveList() {
        return this.mAlreadyHaveList;
    }

    public final Button getMButton() {
        return (Button) this.mButton$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final List<AudioBookItem> getMChooseAudioBookItem() {
        return this.mChooseAudioBookItem;
    }

    public final int getMChooseNumber() {
        return this.mChooseNumber;
    }

    @OXOo.OOXIXo
    public final List<LearnCardItemList> getMFileTypeFiles() {
        return this.mFileTypeFiles;
    }

    @OXOo.OOXIXo
    public final List<AudioBookItem> getMOnLineAudioBookItemFiles() {
        return this.mOnLineAudioBookItemFiles;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(com.sma.smartv3.util.XoI0Ixx0.f24394OX)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), AudioBookItem.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.mAlreadyHaveList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String string;
        super.initView();
        this.mChooseNumber = 0;
        getMButton().setEnabled(false);
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        if (getMArg1() == 0) {
            string = getString(R.string.item_audio_book_learn_title);
        } else {
            string = getString(R.string.item_learn_card_title);
        }
        textView.setText(string);
        getTvFreeSpace().setText(getMArg0());
    }

    public final boolean isSelectorAll() {
        return this.isSelectorAll;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_on_line_learning_file;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mChooseAudioBookItem == null) {
            finish();
            return;
        }
        Intent intent = new Intent();
        this.mChooseAudioBookItem.clear();
        List<AudioBookItem> list = this.mOnLineAudioBookItemFiles;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        for (AudioBookItem audioBookItem : list) {
            if (audioBookItem.isChoose()) {
                this.mChooseAudioBookItem.add(audioBookItem);
            }
            arrayList.add(kotlin.oXIO0o0XI.f29392oIX0oI);
        }
        intent.putExtra("chooseItem", new Gson().toJson(this.mChooseAudioBookItem));
        setResult(-1, intent);
        finish();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new GridLayoutManager(this, 3));
        selectorListener();
        showAudioBookList();
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

    public final void selectorListener() {
        getDslAdapter().getItemSelectorHelper().oo(new oIX0oI());
    }

    public final void setMAlreadyHaveList(@OXOo.OOXIXo List<AudioBookItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.mAlreadyHaveList = list;
    }

    public final void setMChooseAudioBookItem(@OXOo.OOXIXo List<AudioBookItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.mChooseAudioBookItem = list;
    }

    public final void setMChooseNumber(int i) {
        this.mChooseNumber = i;
    }

    public final void setSelectorAll(boolean z) {
        this.isSelectorAll = z;
    }

    public final void showAudioBookList() {
        String str;
        AppStoreFileManager appStoreFileManager = AppStoreFileManager.INSTANCE;
        if (getMArg1() == 0) {
            str = "2";
        } else {
            str = "3";
        }
        appStoreFileManager.getAudioBookFileList(str, new Oox.oOoXoXO<List<? extends AppFileDetail>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showAudioBookList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends AppFileDetail> list) {
                invoke2((List<AppFileDetail>) list);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO List<AppFileDetail> list) {
                String appStoreBinOnlinePath;
                if (list != null) {
                    OnLineLearningFileActivity.this.getMOnLineAudioBookItemFiles().clear();
                    OnLineLearningFileActivity.this.getDslAdapter().getItemSelectorHelper().ooXIXxIX(new com.angcyo.dsladapter.IO(null, ItemSelectorHelperKt.xoXoI(false), false, false, false, null, false, false, false, null, 1021, null));
                    OnLineLearningFileActivity.this.getDslAdapter().getItemSelectorHelper().IoOoX(1);
                    OnLineLearningFileActivity onLineLearningFileActivity = OnLineLearningFileActivity.this;
                    for (AppFileDetail appFileDetail : list) {
                        List<AudioBookItem> mOnLineAudioBookItemFiles = onLineLearningFileActivity.getMOnLineAudioBookItemFiles();
                        String appPreImg = appFileDetail.getAppPreImg();
                        String appName = onLineLearningFileActivity.getMArg1() == 0 ? appFileDetail.getAppName() : appFileDetail.getAppGroupName();
                        int appSize = (int) (appFileDetail.getAppSize() * 1024);
                        appStoreBinOnlinePath = onLineLearningFileActivity.getAppStoreBinOnlinePath(appFileDetail.getAppPack());
                        mOnLineAudioBookItemFiles.add(new AudioBookItem(0, appName, appSize, false, appPreImg, appStoreBinOnlinePath, appFileDetail.getAppNewFlag(), appFileDetail.getAppPackName(), 0, 265, null));
                    }
                    OnLineLearningFileActivity.this.showLearningData();
                }
            }
        });
    }

    public final void showLearnCardList() {
        AppStoreFileManager.INSTANCE.getAppStoreFileList("3", new Oox.oOoXoXO<List<? extends AppStoreFileList>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends AppStoreFileList> list) {
                invoke2((List<AppStoreFileList>) list);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO List<AppStoreFileList> list) {
                if (list != null) {
                    OnLineLearningFileActivity.this.getDslAdapter().resetItem(new ArrayList());
                    final OnLineLearningFileActivity onLineLearningFileActivity = OnLineLearningFileActivity.this;
                    onLineLearningFileActivity.renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1.1
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
                            renderAdapter.getItemSelectorHelper().IoOoX(1);
                            DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                            for (final LearnCardItemList learnCardItemList : OnLineLearningFileActivity.this.getMFileTypeFiles()) {
                                if (!learnCardItemList.getList().isEmpty()) {
                                    DslAdapter dslAdapter = OnLineLearningFileActivity.this.getDslAdapter();
                                    final OnLineLearningFileActivity onLineLearningFileActivity2 = OnLineLearningFileActivity.this;
                                    DslAdapterExKt.oO(dslAdapter, R.layout.item_learn_card_title, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity.showLearnCardList.1.1.1

                                        /* renamed from: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                        /* loaded from: classes12.dex */
                                        public static final class C09511 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                            final /* synthetic */ LearnCardItemList $category;
                                            final /* synthetic */ DslAdapterItem $this_dslItem;
                                            final /* synthetic */ OnLineLearningFileActivity this$0;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public C09511(LearnCardItemList learnCardItemList, OnLineLearningFileActivity onLineLearningFileActivity, DslAdapterItem dslAdapterItem) {
                                                super(4);
                                                this.$category = learnCardItemList;
                                                this.this$0 = onLineLearningFileActivity;
                                                this.$this_dslItem = dslAdapterItem;
                                            }

                                            /* JADX INFO: Access modifiers changed from: private */
                                            public static final void invoke$lambda$0(DslAdapterItem this_dslItem, View view) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                                                this_dslItem.setItemGroupExtend(!this_dslItem.getItemGroupExtend());
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                TextView tv = itemHolder.tv(R.id.learn_card_arrow_tv_title);
                                                if (tv != null) {
                                                    tv.setText(this.$category.getTypeName());
                                                }
                                                TextView tv2 = itemHolder.tv(R.id.learn_card_arrow_tv_content);
                                                if (tv2 != null) {
                                                    tv2.setText(this.$category.getList().size() + this.this$0.getString(R.string.learn_card_project_tip));
                                                }
                                                View v = itemHolder.v(R.id.learn_card_all_choose_layout);
                                                if (v != null) {
                                                    v.setVisibility(8);
                                                }
                                                ImageView imageView = (ImageView) itemHolder.v(R.id.learn_card_arrow_icon);
                                                if (imageView != null) {
                                                    imageView.setImageResource(this.$this_dslItem.getItemGroupExtend() ? R.drawable.learn_card_ic_arrow_closure : R.drawable.learn_card_ic_arrow_open);
                                                }
                                                if (imageView != null) {
                                                    final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                                                    imageView.setOnClickListener(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0086: INVOKE 
                                                          (r2v2 'imageView' android.widget.ImageView)
                                                          (wrap:android.view.View$OnClickListener:0x0083: CONSTRUCTOR (r3v11 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE]) A[MD:(com.angcyo.dsladapter.DslAdapterItem):void (m), WRAPPED] call: com.sma.smartv3.ui.device.OOxOI.<init>(com.angcyo.dsladapter.DslAdapterItem):void type: CONSTRUCTOR)
                                                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.OnLineLearningFileActivity.showLearnCardList.1.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.OOxOI, state: NOT_LOADED
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
                                                        	... 23 more
                                                        */
                                                    /*
                                                        this = this;
                                                        java.lang.String r3 = "itemHolder"
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r3)
                                                        java.lang.String r3 = "<anonymous parameter 2>"
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
                                                        java.lang.String r3 = "<anonymous parameter 3>"
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r3)
                                                        r3 = 2131365761(0x7f0a0f81, float:1.8351396E38)
                                                        android.widget.TextView r3 = r2.tv(r3)
                                                        if (r3 != 0) goto L19
                                                        goto L22
                                                    L19:
                                                        com.sma.smartv3.model.LearnCardItemList r4 = r1.$category
                                                        java.lang.String r4 = r4.getTypeName()
                                                        r3.setText(r4)
                                                    L22:
                                                        r3 = 2131365760(0x7f0a0f80, float:1.8351394E38)
                                                        android.widget.TextView r3 = r2.tv(r3)
                                                        if (r3 != 0) goto L2c
                                                        goto L51
                                                    L2c:
                                                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                                        r4.<init>()
                                                        com.sma.smartv3.model.LearnCardItemList r5 = r1.$category
                                                        java.util.List r5 = r5.getList()
                                                        int r5 = r5.size()
                                                        r4.append(r5)
                                                        com.sma.smartv3.ui.device.OnLineLearningFileActivity r5 = r1.this$0
                                                        r0 = 2132019342(0x7f14088e, float:1.9677016E38)
                                                        java.lang.String r5 = r5.getString(r0)
                                                        r4.append(r5)
                                                        java.lang.String r4 = r4.toString()
                                                        r3.setText(r4)
                                                    L51:
                                                        r3 = 2131365758(0x7f0a0f7e, float:1.835139E38)
                                                        android.view.View r3 = r2.v(r3)
                                                        if (r3 != 0) goto L5b
                                                        goto L60
                                                    L5b:
                                                        r4 = 8
                                                        r3.setVisibility(r4)
                                                    L60:
                                                        r3 = 2131365759(0x7f0a0f7f, float:1.8351392E38)
                                                        android.view.View r2 = r2.v(r3)
                                                        android.widget.ImageView r2 = (android.widget.ImageView) r2
                                                        if (r2 == 0) goto L7d
                                                        com.angcyo.dsladapter.DslAdapterItem r3 = r1.$this_dslItem
                                                        boolean r3 = r3.getItemGroupExtend()
                                                        if (r3 == 0) goto L77
                                                        r3 = 2131234748(0x7f080fbc, float:1.808567E38)
                                                        goto L7a
                                                    L77:
                                                        r3 = 2131234749(0x7f080fbd, float:1.8085673E38)
                                                    L7a:
                                                        r2.setImageResource(r3)
                                                    L7d:
                                                        if (r2 == 0) goto L89
                                                        com.angcyo.dsladapter.DslAdapterItem r3 = r1.$this_dslItem
                                                        com.sma.smartv3.ui.device.OOxOI r4 = new com.sma.smartv3.ui.device.OOxOI
                                                        r4.<init>(r3)
                                                        r2.setOnClickListener(r4)
                                                    L89:
                                                        return
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1.AnonymousClass1.C09501.C09511.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                                dslItem.setItemIsGroupHead(true);
                                                dslItem.setItemIsHover(false);
                                                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(LearnCardItemList.this.getTypeName()));
                                                dslItem.setItemBindOverride(new C09511(LearnCardItemList.this, onLineLearningFileActivity2, dslItem));
                                                dslItem.setItemTag(LearnCardItemList.this.getTypeName());
                                            }
                                        });
                                    }
                                    for (final LearnCardDataItem learnCardDataItem : learnCardItemList.getList()) {
                                        DslAdapter dslAdapter2 = OnLineLearningFileActivity.this.getDslAdapter();
                                        final OnLineLearningFileActivity onLineLearningFileActivity3 = OnLineLearningFileActivity.this;
                                        DslAdapterExKt.oO(dslAdapter2, R.layout.item_list_audio_book_learn, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity.showLearnCardList.1.1.2

                                            /* renamed from: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1$1$2$1, reason: invalid class name and collision with other inner class name */
                                            /* loaded from: classes12.dex */
                                            public static final class C09521 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                                final /* synthetic */ LearnCardDataItem $item;
                                                final /* synthetic */ DslAdapterItem $this_dslItem;
                                                final /* synthetic */ DslAdapter $this_renderAdapter;
                                                final /* synthetic */ OnLineLearningFileActivity this$0;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public C09521(LearnCardDataItem learnCardDataItem, DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, OnLineLearningFileActivity onLineLearningFileActivity) {
                                                    super(4);
                                                    this.$item = learnCardDataItem;
                                                    this.$this_dslItem = dslAdapterItem;
                                                    this.$this_renderAdapter = dslAdapter;
                                                    this.this$0 = onLineLearningFileActivity;
                                                }

                                                /* JADX INFO: Access modifiers changed from: private */
                                                public static final void invoke$lambda$0(DslAdapterItem this_dslItem, LearnCardDataItem item, View view) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
                                                    DslAdapterItem.updateItemSelector$default(this_dslItem, !this_dslItem.getItemIsSelected(), false, 2, null);
                                                    item.setChoose(this_dslItem.getItemIsSelected());
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
                                                    ImageView img = itemHolder.img(R.id.iv);
                                                    if (img != null) {
                                                        img.setImageResource(this.$item.getPath());
                                                    }
                                                    TextView tv = itemHolder.tv(R.id.tv);
                                                    if (tv != null) {
                                                        tv.setText(this.$item.getName());
                                                    }
                                                    TextView tv2 = itemHolder.tv(R.id.audio_book_file_size);
                                                    if (tv2 != null) {
                                                        tv2.setText("");
                                                    }
                                                    ImageView img2 = itemHolder.img(R.id.list_item_choose_iv);
                                                    if (img2 != null) {
                                                        img2.setVisibility(0);
                                                    }
                                                    if (this.$this_dslItem.getItemIsSelected() && this.$item.isChoose()) {
                                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(img2);
                                                        Glide.with(img2.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(img2);
                                                    } else {
                                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(img2);
                                                        Glide.with(img2.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(img2);
                                                    }
                                                    View view = itemHolder.itemView;
                                                    final DslAdapterItem dslAdapterItem = this.$this_dslItem;
                                                    final LearnCardDataItem learnCardDataItem = this.$item;
                                                    view.setOnClickListener(
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009f: INVOKE 
                                                          (r1v1 'view' android.view.View)
                                                          (wrap:android.view.View$OnClickListener:0x009c: CONSTRUCTOR 
                                                          (r2v12 'dslAdapterItem' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                                                          (r3v6 'learnCardDataItem' com.sma.smartv3.model.LearnCardDataItem A[DONT_INLINE])
                                                         A[MD:(com.angcyo.dsladapter.DslAdapterItem, com.sma.smartv3.model.LearnCardDataItem):void (m), WRAPPED] call: com.sma.smartv3.ui.device.XO00XOO.<init>(com.angcyo.dsladapter.DslAdapterItem, com.sma.smartv3.model.LearnCardDataItem):void type: CONSTRUCTOR)
                                                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.OnLineLearningFileActivity.showLearnCardList.1.1.2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.XO00XOO, state: NOT_LOADED
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
                                                        java.lang.String r2 = "itemHolder"
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r2)
                                                        java.lang.String r2 = "adapterItem"
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r2)
                                                        java.lang.String r2 = "payloads"
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r2)
                                                        r2 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                                        android.widget.ImageView r2 = r1.img(r2)
                                                        if (r2 == 0) goto L21
                                                        com.sma.smartv3.model.LearnCardDataItem r3 = r0.$item
                                                        int r3 = r3.getPath()
                                                        r2.setImageResource(r3)
                                                    L21:
                                                        r2 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                                        android.widget.TextView r2 = r1.tv(r2)
                                                        if (r2 != 0) goto L2b
                                                        goto L34
                                                    L2b:
                                                        com.sma.smartv3.model.LearnCardDataItem r3 = r0.$item
                                                        java.lang.String r3 = r3.getName()
                                                        r2.setText(r3)
                                                    L34:
                                                        r2 = 2131362054(0x7f0a0106, float:1.8343878E38)
                                                        android.widget.TextView r2 = r1.tv(r2)
                                                        if (r2 != 0) goto L3e
                                                        goto L43
                                                    L3e:
                                                        java.lang.String r3 = ""
                                                        r2.setText(r3)
                                                    L43:
                                                        r2 = 2131365828(0x7f0a0fc4, float:1.8351532E38)
                                                        android.widget.ImageView r2 = r1.img(r2)
                                                        if (r2 != 0) goto L4d
                                                        goto L51
                                                    L4d:
                                                        r3 = 0
                                                        r2.setVisibility(r3)
                                                    L51:
                                                        com.angcyo.dsladapter.DslAdapterItem r3 = r0.$this_dslItem
                                                        boolean r3 = r3.getItemIsSelected()
                                                        if (r3 == 0) goto L7b
                                                        com.sma.smartv3.model.LearnCardDataItem r3 = r0.$item
                                                        boolean r3 = r3.isChoose()
                                                        if (r3 == 0) goto L7b
                                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
                                                        android.content.Context r3 = r2.getContext()
                                                        com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)
                                                        r4 = 2131232380(0x7f08067c, float:1.8080868E38)
                                                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                                                        com.bumptech.glide.RequestBuilder r3 = r3.load(r4)
                                                        r3.into(r2)
                                                        goto L94
                                                    L7b:
                                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
                                                        android.content.Context r3 = r2.getContext()
                                                        com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)
                                                        r4 = 2131232381(0x7f08067d, float:1.808087E38)
                                                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                                                        com.bumptech.glide.RequestBuilder r3 = r3.load(r4)
                                                        r3.into(r2)
                                                    L94:
                                                        android.view.View r1 = r1.itemView
                                                        com.angcyo.dsladapter.DslAdapterItem r2 = r0.$this_dslItem
                                                        com.sma.smartv3.model.LearnCardDataItem r3 = r0.$item
                                                        com.sma.smartv3.ui.device.XO00XOO r4 = new com.sma.smartv3.ui.device.XO00XOO
                                                        r4.<init>(r2, r3)
                                                        r1.setOnClickListener(r4)
                                                        com.angcyo.dsladapter.DslAdapter r1 = r0.$this_renderAdapter
                                                        com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1$1$2$1$2 r2 = new com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1$1$2$1$2
                                                        com.sma.smartv3.ui.device.OnLineLearningFileActivity r3 = r0.this$0
                                                        r2.<init>()
                                                        r1.setOnDispatchUpdatesAfterOnce(r2)
                                                        return
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearnCardList$1.AnonymousClass1.AnonymousClass2.C09521.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(LearnCardItemList.this.getTypeName()));
                                                dslItem.setItemBindOverride(new C09521(learnCardDataItem, dslItem, renderAdapter, onLineLearningFileActivity3));
                                            }
                                        });
                                    }
                                }
                                DslAdapter.setAdapterStatus$default(renderAdapter, 0, null, 2, null);
                            }
                        });
                    }
                }
            });
        }

        public final void showLearningData() {
            getDslAdapter().resetItem(new ArrayList());
            renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearningData$1
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
                    for (final AudioBookItem audioBookItem : OnLineLearningFileActivity.this.getMOnLineAudioBookItemFiles()) {
                        DslAdapter dslAdapter = OnLineLearningFileActivity.this.getDslAdapter();
                        final OnLineLearningFileActivity onLineLearningFileActivity = OnLineLearningFileActivity.this;
                        DslAdapterExKt.oO(dslAdapter, R.layout.item_list_audio_book_learn, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearningData$1.1

                            @kotlin.jvm.internal.XX({"SMAP\nOnLineLearningFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnLineLearningFileActivity.kt\ncom/sma/smartv3/ui/device/OnLineLearningFileActivity$showLearningData$1$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,356:1\n1747#2,3:357\n*S KotlinDebug\n*F\n+ 1 OnLineLearningFileActivity.kt\ncom/sma/smartv3/ui/device/OnLineLearningFileActivity$showLearningData$1$1$1\n*L\n188#1:357,3\n*E\n"})
                            /* renamed from: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearningData$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes12.dex */
                            public static final class C09541 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                final /* synthetic */ AudioBookItem $item;
                                final /* synthetic */ OnLineLearningFileActivity this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C09541(AudioBookItem audioBookItem, OnLineLearningFileActivity onLineLearningFileActivity) {
                                    super(4);
                                    this.$item = audioBookItem;
                                    this.this$0 = onLineLearningFileActivity;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void invoke$lambda$1(View view) {
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void invoke$lambda$2(AudioBookItem item, OnLineLearningFileActivity this$0, ImageView imageView, View view) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                    boolean z = true;
                                    item.setChoose(!item.isChoose());
                                    if (item.isChoose()) {
                                        this$0.setMChooseNumber(this$0.getMChooseNumber() + 1);
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                                        Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(imageView);
                                    } else {
                                        this$0.setMChooseNumber(this$0.getMChooseNumber() - 1);
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                                        Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(imageView);
                                    }
                                    Button mButton = this$0.getMButton();
                                    if (this$0.getMChooseNumber() <= 0) {
                                        z = false;
                                    }
                                    mButton.setEnabled(z);
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
                                    TextView tv2 = itemHolder.tv(R.id.audio_book_file_size);
                                    if (tv2 != null) {
                                        tv2.setText(this.$item.getSize() + "kb");
                                    }
                                    this.this$0.setViewBg(tv2, 0.0f, 0.0f, 0.0f, 20.0f);
                                    TextView tv3 = itemHolder.tv(R.id.audio_book_file_top_tip);
                                    ImageView img = itemHolder.img(R.id.iv);
                                    if (img != null) {
                                        Glide.with(img.getContext()).load(this.$item.getOnlinePath()).into(img);
                                    }
                                    final ImageView img2 = itemHolder.img(R.id.list_item_choose_iv);
                                    if (tv3 == null) {
                                        return;
                                    }
                                    List<AudioBookItem> mAlreadyHaveList = this.this$0.getMAlreadyHaveList();
                                    AudioBookItem audioBookItem = this.$item;
                                    int i2 = 0;
                                    if (!(mAlreadyHaveList instanceof Collection) || !mAlreadyHaveList.isEmpty()) {
                                        Iterator<T> it = mAlreadyHaveList.iterator();
                                        while (it.hasNext()) {
                                            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((AudioBookItem) it.next()).getOnlinePath(), audioBookItem.getOnlinePath())) {
                                                tv3.setText(this.this$0.getString(R.string.audio_book_already_have));
                                                this.this$0.setViewBg(tv3, 20.0f, 0.0f, 0.0f, 0.0f);
                                                itemHolder.itemView.setOnClickListener(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00d7: INVOKE 
                                                      (wrap:android.view.View:0x00d0: IGET (r9v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder) A[WRAPPED] (LINE:16) androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView android.view.View)
                                                      (wrap:android.view.View$OnClickListener:0x00d4: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.sma.smartv3.ui.device.OXXoIoXI.<init>():void type: CONSTRUCTOR)
                                                     VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:16) in method: com.sma.smartv3.ui.device.OnLineLearningFileActivity.showLearningData.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.OXXoIoXI, state: NOT_LOADED
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
                                                    	... 39 more
                                                    */
                                                /*
                                                    this = this;
                                                    java.lang.String r10 = "itemHolder"
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r10)
                                                    java.lang.String r10 = "adapterItem"
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r10)
                                                    java.lang.String r10 = "<anonymous parameter 3>"
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r12, r10)
                                                    r10 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                                    android.widget.TextView r10 = r9.tv(r10)
                                                    if (r10 != 0) goto L19
                                                    goto L22
                                                L19:
                                                    com.sma.smartv3.model.AudioBookItem r11 = r8.$item
                                                    java.lang.String r11 = r11.getName()
                                                    r10.setText(r11)
                                                L22:
                                                    r10 = 2131362054(0x7f0a0106, float:1.8343878E38)
                                                    android.widget.TextView r1 = r9.tv(r10)
                                                    if (r1 != 0) goto L2c
                                                    goto L46
                                                L2c:
                                                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                                                    r10.<init>()
                                                    com.sma.smartv3.model.AudioBookItem r11 = r8.$item
                                                    int r11 = r11.getSize()
                                                    r10.append(r11)
                                                    java.lang.String r11 = "kb"
                                                    r10.append(r11)
                                                    java.lang.String r10 = r10.toString()
                                                    r1.setText(r10)
                                                L46:
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity r0 = r8.this$0
                                                    r4 = 0
                                                    r5 = 1101004800(0x41a00000, float:20.0)
                                                    r2 = 0
                                                    r3 = 0
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity.access$setViewBg(r0, r1, r2, r3, r4, r5)
                                                    r10 = 2131362055(0x7f0a0107, float:1.834388E38)
                                                    android.widget.TextView r10 = r9.tv(r10)
                                                    r11 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                                    android.widget.ImageView r11 = r9.img(r11)
                                                    if (r11 == 0) goto L75
                                                    android.content.Context r12 = r11.getContext()
                                                    com.bumptech.glide.RequestManager r12 = com.bumptech.glide.Glide.with(r12)
                                                    com.sma.smartv3.model.AudioBookItem r0 = r8.$item
                                                    java.lang.String r0 = r0.getOnlinePath()
                                                    com.bumptech.glide.RequestBuilder r12 = r12.load(r0)
                                                    r12.into(r11)
                                                L75:
                                                    r11 = 2131365828(0x7f0a0fc4, float:1.8351532E38)
                                                    android.widget.ImageView r11 = r9.img(r11)
                                                    if (r10 != 0) goto L80
                                                    goto Lfa
                                                L80:
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity r12 = r8.this$0
                                                    java.util.List r12 = r12.getMAlreadyHaveList()
                                                    java.lang.Iterable r12 = (java.lang.Iterable) r12
                                                    com.sma.smartv3.model.AudioBookItem r0 = r8.$item
                                                    boolean r1 = r12 instanceof java.util.Collection
                                                    r6 = 0
                                                    r7 = 8
                                                    if (r1 == 0) goto L9b
                                                    r1 = r12
                                                    java.util.Collection r1 = (java.util.Collection) r1
                                                    boolean r1 = r1.isEmpty()
                                                    if (r1 == 0) goto L9b
                                                    goto Le1
                                                L9b:
                                                    java.util.Iterator r12 = r12.iterator()
                                                L9f:
                                                    boolean r1 = r12.hasNext()
                                                    if (r1 == 0) goto Le1
                                                    java.lang.Object r1 = r12.next()
                                                    com.sma.smartv3.model.AudioBookItem r1 = (com.sma.smartv3.model.AudioBookItem) r1
                                                    java.lang.String r1 = r1.getOnlinePath()
                                                    java.lang.String r2 = r0.getOnlinePath()
                                                    boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
                                                    if (r1 == 0) goto L9f
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity r12 = r8.this$0
                                                    r0 = 2132017626(0x7f1401da, float:1.9673536E38)
                                                    java.lang.String r12 = r12.getString(r0)
                                                    r10.setText(r12)
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity r0 = r8.this$0
                                                    r4 = 0
                                                    r5 = 0
                                                    r2 = 1101004800(0x41a00000, float:20.0)
                                                    r3 = 0
                                                    r1 = r10
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity.access$setViewBg(r0, r1, r2, r3, r4, r5)
                                                    android.view.View r9 = r9.itemView
                                                    com.sma.smartv3.ui.device.OXXoIoXI r12 = new com.sma.smartv3.ui.device.OXXoIoXI
                                                    r12.<init>()
                                                    r9.setOnClickListener(r12)
                                                    if (r11 != 0) goto Ldd
                                                    goto Lf7
                                                Ldd:
                                                    r11.setVisibility(r7)
                                                    goto Lf7
                                                Le1:
                                                    android.view.View r9 = r9.itemView
                                                    com.sma.smartv3.model.AudioBookItem r12 = r8.$item
                                                    com.sma.smartv3.ui.device.OnLineLearningFileActivity r0 = r8.this$0
                                                    com.sma.smartv3.ui.device.XooIO0oo0 r1 = new com.sma.smartv3.ui.device.XooIO0oo0
                                                    r1.<init>(r12, r0, r11)
                                                    r9.setOnClickListener(r1)
                                                    if (r11 != 0) goto Lf2
                                                    goto Lf5
                                                Lf2:
                                                    r11.setVisibility(r6)
                                                Lf5:
                                                    r6 = 8
                                                Lf7:
                                                    r10.setVisibility(r6)
                                                Lfa:
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.OnLineLearningFileActivity$showLearningData$1.AnonymousClass1.C09541.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                            dslItem.setItemBindOverride(new C09541(AudioBookItem.this, onLineLearningFileActivity));
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
