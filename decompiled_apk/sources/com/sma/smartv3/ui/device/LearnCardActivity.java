package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.LearnCardDataItem;
import com.sma.smartv3.model.LearnCardItemList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

@kotlin.jvm.internal.XX({"SMAP\nLearnCardActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LearnCardActivity.kt\ncom/sma/smartv3/ui/device/LearnCardActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,315:1\n1855#2:316\n1855#2,2:317\n1856#2:319\n1855#2,2:320\n173#3,7:322\n180#3,3:330\n143#3,7:333\n183#3:340\n1#4:329\n*S KotlinDebug\n*F\n+ 1 LearnCardActivity.kt\ncom/sma/smartv3/ui/device/LearnCardActivity\n*L\n179#1:316\n184#1:317,2\n179#1:319\n197#1:320,2\n216#1:322,7\n216#1:330,3\n216#1:333,7\n216#1:340\n216#1:329\n*E\n"})
/* loaded from: classes12.dex */
public final class LearnCardActivity extends BaseJLFileManageActivity {

    @OXOo.oOoXoXO
    private Handler mHandler111;

    @OXOo.OOXIXo
    private final List<LearnCardItemList> mTypeFiles = new ArrayList();

    @OXOo.OOXIXo
    private Runnable myTask = new oIX0oI();
    private int progress1111;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            LearnCardActivity learnCardActivity = LearnCardActivity.this;
            learnCardActivity.setProgress1111(learnCardActivity.getProgress1111() + 1);
            LearnCardActivity.this.mTask();
            if (LearnCardActivity.this.getProgress1111() <= 100 && (handler = LearnCardActivity.this.mHandler111) != null) {
                handler.postDelayed(this, 40L);
            }
        }
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void allSelect(boolean z) {
        super.allSelect(z);
        setDeleteNum(0);
        for (LearnCardItemList learnCardItemList : this.mTypeFiles) {
            learnCardItemList.setAllChoose(isAllSelect());
            if (isAllSelect()) {
                setDeleteNum(getDeleteNum() + learnCardItemList.getList().size());
            }
            Iterator<T> it = learnCardItemList.getList().iterator();
            while (it.hasNext()) {
                ((LearnCardDataItem) it.next()).setChoose(isAllSelect());
            }
        }
        if (getOpenDeleteType()) {
            changeDeleteBtnText(getDeleteNum());
        }
        getDslAdapter().notifyDataChanged();
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void confirmDeleteFile() {
        super.confirmDeleteFile();
        Iterator<T> it = this.mTypeFiles.iterator();
        while (it.hasNext()) {
            Iterator<LearnCardDataItem> it2 = ((LearnCardItemList) it.next()).getList().iterator();
            while (it2.hasNext()) {
                if (it2.next().isChoose()) {
                    it2.remove();
                }
            }
        }
        showList();
        setOpenDeleteType(false);
        changeActivityState();
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void getFile() {
        super.getFile();
        String obj = getTvFreeSpace().getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", obj);
        bundle.putInt("mArg1", 1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) OnLineLearningFileActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 255);
    }

    @OXOo.OOXIXo
    public final List<LearnCardItemList> getMTypeFiles() {
        return this.mTypeFiles;
    }

    @OXOo.OOXIXo
    public final Runnable getMyTask() {
        return this.myTask;
    }

    public final int getProgress1111() {
        return this.progress1111;
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity, com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(getString(R.string.item_learn_card_title));
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_audio_book_learn;
    }

    public final void mTask() {
        getTvProgressTip().setText(R.string.transfering);
        getTvName().setText(getString(R.string.waiting));
        getTvTotalProgress().setText("");
        getPbProgress().setProgress(this.progress1111);
        TextView tvProgress = getTvProgress();
        StringBuilder sb = new StringBuilder();
        sb.append(this.progress1111);
        sb.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        tvProgress.setText(sb.toString());
        if (this.progress1111 > 100) {
            getTaskPanel().setVisibility(8);
            getRecyclerView().setVisibility(0);
            getRecyclerViewTitle().setVisibility(0);
            getRightBtn().setVisibility(0);
            Handler handler = this.mHandler111;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mHandler111 = null;
            showList();
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("mTask  ---------- >  progress = " + this.progress1111);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 255 && i2 == -1) {
            if (this.mHandler111 == null) {
                this.mHandler111 = new Handler(Looper.getMainLooper());
            }
            this.progress1111 = 0;
            getTaskPanel().setVisibility(0);
            getRecyclerView().setVisibility(8);
            getTvProgressTip().setText(R.string.studycard_transmission_tip);
            getRightBtn().setVisibility(8);
            getRecyclerViewTitle().setVisibility(8);
            getTvCancel().setVisibility(0);
            getTvRetry().setVisibility(8);
            Handler handler = this.mHandler111;
            if (handler != null) {
                handler.postDelayed(this.myTask, 40L);
            }
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (getOpenDeleteType()) {
            showDeleteTipPopup(R.string.audio_book_delete_pop_title, R.string.audio_book_delete_pop_content, R.string.audio_book_delete_pop_sure);
        } else {
            getFile();
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        showList();
    }

    public final void setMyTask(@OXOo.OOXIXo Runnable runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "<set-?>");
        this.myTask = runnable;
    }

    public final void setProgress1111(int i) {
        this.progress1111 = i;
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void showList() {
        super.showList();
        getDslAdapter().resetItem(new ArrayList());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.LearnCardActivity$showList$1
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
                for (final LearnCardItemList learnCardItemList : LearnCardActivity.this.getMTypeFiles()) {
                    if (!learnCardItemList.getList().isEmpty()) {
                        DslAdapter dslAdapter = LearnCardActivity.this.getDslAdapter();
                        final LearnCardActivity learnCardActivity = LearnCardActivity.this;
                        DslAdapterExKt.oO(dslAdapter, R.layout.item_learn_card_title, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.LearnCardActivity$showList$1.1

                            @kotlin.jvm.internal.XX({"SMAP\nLearnCardActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LearnCardActivity.kt\ncom/sma/smartv3/ui/device/LearnCardActivity$showList$1$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,315:1\n1855#2,2:316\n*S KotlinDebug\n*F\n+ 1 LearnCardActivity.kt\ncom/sma/smartv3/ui/device/LearnCardActivity$showList$1$1$1\n*L\n68#1:316,2\n*E\n"})
                            /* renamed from: com.sma.smartv3.ui.device.LearnCardActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes12.dex */
                            public static final class C09481 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                final /* synthetic */ LearnCardItemList $category;
                                final /* synthetic */ DslAdapterItem $this_dslItem;
                                final /* synthetic */ LearnCardActivity this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C09481(LearnCardItemList learnCardItemList, LearnCardActivity learnCardActivity, DslAdapterItem dslAdapterItem) {
                                    super(4);
                                    this.$category = learnCardItemList;
                                    this.this$0 = learnCardActivity;
                                    this.$this_dslItem = dslAdapterItem;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void invoke$lambda$1(LearnCardItemList category, ImageView imageView, LearnCardActivity this$0, View view) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(category, "$category");
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                    category.setAllChoose(!category.isAllChoose());
                                    if (category.isAllChoose()) {
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                                        Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(imageView);
                                    } else {
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                                        Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(imageView);
                                    }
                                    for (LearnCardDataItem learnCardDataItem : category.getList()) {
                                        if (learnCardDataItem.isChoose()) {
                                            this$0.setDeleteNum(this$0.getDeleteNum() + 1);
                                        } else {
                                            this$0.setDeleteNum(this$0.getDeleteNum() - 1);
                                        }
                                        learnCardDataItem.setChoose(category.isAllChoose());
                                    }
                                    this$0.changeDeleteBtnText(this$0.getDeleteNum());
                                    this$0.getDslAdapter().notifyDataChanged();
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void invoke$lambda$2(DslAdapterItem this_dslItem, ImageView imageView, LearnCardActivity this$0, View view, View view2) {
                                    int i;
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                    this_dslItem.setItemGroupExtend(!this_dslItem.getItemGroupExtend());
                                    if (this_dslItem.getItemGroupExtend()) {
                                        if (this$0.getOpenDeleteType() && view != null) {
                                            view.setVisibility(0);
                                        }
                                        i = R.drawable.learn_card_ic_arrow_closure;
                                    } else {
                                        if (view != null) {
                                            view.setVisibility(8);
                                        }
                                        i = R.drawable.learn_card_ic_arrow_open;
                                    }
                                    imageView.setImageResource(i);
                                }

                                @Override // Oox.Oxx0xo
                                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                    invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                    int i2;
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
                                    final View v = itemHolder.v(R.id.learn_card_all_choose_layout);
                                    final ImageView imageView = (ImageView) itemHolder.v(R.id.learn_card_all_choose_icon);
                                    if (v != null) {
                                        if (this.this$0.getOpenDeleteType()) {
                                            View view = itemHolder.itemView;
                                            final LearnCardItemList learnCardItemList = this.$category;
                                            final LearnCardActivity learnCardActivity = this.this$0;
                                            view.setOnClickListener(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0077: INVOKE 
                                                  (r7v4 'view' android.view.View)
                                                  (wrap:android.view.View$OnClickListener:0x0074: CONSTRUCTOR 
                                                  (r0v1 'learnCardItemList' com.sma.smartv3.model.LearnCardItemList A[DONT_INLINE])
                                                  (r6v3 'imageView' android.widget.ImageView A[DONT_INLINE])
                                                  (r1v0 'learnCardActivity' com.sma.smartv3.ui.device.LearnCardActivity A[DONT_INLINE])
                                                 A[MD:(com.sma.smartv3.model.LearnCardItemList, android.widget.ImageView, com.sma.smartv3.ui.device.LearnCardActivity):void (m), WRAPPED] call: com.sma.smartv3.ui.device.oXIoO.<init>(com.sma.smartv3.model.LearnCardItemList, android.widget.ImageView, com.sma.smartv3.ui.device.LearnCardActivity):void type: CONSTRUCTOR)
                                                 VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.LearnCardActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.oXIoO, state: NOT_LOADED
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
                                                	... 27 more
                                                */
                                            /*
                                                this = this;
                                                java.lang.String r5 = "itemHolder"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                                                java.lang.String r5 = "<anonymous parameter 2>"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r5)
                                                java.lang.String r5 = "<anonymous parameter 3>"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r5)
                                                r5 = 2131365761(0x7f0a0f81, float:1.8351396E38)
                                                android.widget.TextView r5 = r4.tv(r5)
                                                if (r5 != 0) goto L19
                                                goto L22
                                            L19:
                                                com.sma.smartv3.model.LearnCardItemList r6 = r3.$category
                                                java.lang.String r6 = r6.getTypeName()
                                                r5.setText(r6)
                                            L22:
                                                r5 = 2131365760(0x7f0a0f80, float:1.8351394E38)
                                                android.widget.TextView r5 = r4.tv(r5)
                                                if (r5 != 0) goto L2c
                                                goto L51
                                            L2c:
                                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                                r6.<init>()
                                                com.sma.smartv3.model.LearnCardItemList r7 = r3.$category
                                                java.util.List r7 = r7.getList()
                                                int r7 = r7.size()
                                                r6.append(r7)
                                                com.sma.smartv3.ui.device.LearnCardActivity r7 = r3.this$0
                                                r0 = 2132019342(0x7f14088e, float:1.9677016E38)
                                                java.lang.String r7 = r7.getString(r0)
                                                r6.append(r7)
                                                java.lang.String r6 = r6.toString()
                                                r5.setText(r6)
                                            L51:
                                                r5 = 2131365758(0x7f0a0f7e, float:1.835139E38)
                                                android.view.View r5 = r4.v(r5)
                                                r6 = 2131365757(0x7f0a0f7d, float:1.8351388E38)
                                                android.view.View r6 = r4.v(r6)
                                                android.widget.ImageView r6 = (android.widget.ImageView) r6
                                                if (r5 != 0) goto L64
                                                goto L81
                                            L64:
                                                com.sma.smartv3.ui.device.LearnCardActivity r7 = r3.this$0
                                                boolean r7 = r7.getOpenDeleteType()
                                                if (r7 == 0) goto L7c
                                                android.view.View r7 = r4.itemView
                                                com.sma.smartv3.model.LearnCardItemList r0 = r3.$category
                                                com.sma.smartv3.ui.device.LearnCardActivity r1 = r3.this$0
                                                com.sma.smartv3.ui.device.oXIoO r2 = new com.sma.smartv3.ui.device.oXIoO
                                                r2.<init>(r0, r6, r1)
                                                r7.setOnClickListener(r2)
                                                r6 = 0
                                                goto L7e
                                            L7c:
                                                r6 = 8
                                            L7e:
                                                r5.setVisibility(r6)
                                            L81:
                                                r6 = 2131365759(0x7f0a0f7f, float:1.8351392E38)
                                                android.view.View r4 = r4.v(r6)
                                                android.widget.ImageView r4 = (android.widget.ImageView) r4
                                                if (r4 == 0) goto L9e
                                                com.angcyo.dsladapter.DslAdapterItem r6 = r3.$this_dslItem
                                                boolean r6 = r6.getItemGroupExtend()
                                                if (r6 == 0) goto L98
                                                r6 = 2131234748(0x7f080fbc, float:1.808567E38)
                                                goto L9b
                                            L98:
                                                r6 = 2131234749(0x7f080fbd, float:1.8085673E38)
                                            L9b:
                                                r4.setImageResource(r6)
                                            L9e:
                                                if (r4 == 0) goto Lac
                                                com.angcyo.dsladapter.DslAdapterItem r6 = r3.$this_dslItem
                                                com.sma.smartv3.ui.device.LearnCardActivity r7 = r3.this$0
                                                com.sma.smartv3.ui.device.o0IXXIx r0 = new com.sma.smartv3.ui.device.o0IXXIx
                                                r0.<init>(r6, r4, r7, r5)
                                                r4.setOnClickListener(r0)
                                            Lac:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.LearnCardActivity$showList$1.AnonymousClass1.C09481.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                        dslItem.setItemGroupExtend(false);
                                        dslItem.setItemBindOverride(new C09481(LearnCardItemList.this, learnCardActivity, dslItem));
                                        dslItem.setItemTag(LearnCardItemList.this.getTypeName());
                                    }
                                });
                            }
                            for (final LearnCardDataItem learnCardDataItem : learnCardItemList.getList()) {
                                DslAdapter dslAdapter2 = LearnCardActivity.this.getDslAdapter();
                                final LearnCardActivity learnCardActivity2 = LearnCardActivity.this;
                                DslAdapterExKt.oO(dslAdapter2, R.layout.item_list_audio_book_learn, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.LearnCardActivity$showList$1.2

                                    /* renamed from: com.sma.smartv3.ui.device.LearnCardActivity$showList$1$2$1, reason: invalid class name */
                                    /* loaded from: classes12.dex */
                                    public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                        final /* synthetic */ LearnCardDataItem $item;
                                        final /* synthetic */ LearnCardActivity this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass1(LearnCardDataItem learnCardDataItem, LearnCardActivity learnCardActivity) {
                                            super(4);
                                            this.$item = learnCardDataItem;
                                            this.this$0 = learnCardActivity;
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$0(LearnCardDataItem item, LearnCardActivity this$0, ImageView imageView, View view) {
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                            item.setChoose(!item.isChoose());
                                            if (item.isChoose()) {
                                                this$0.setDeleteNum(this$0.getDeleteNum() + 1);
                                            } else {
                                                this$0.setDeleteNum(this$0.getDeleteNum() - 1);
                                            }
                                            this$0.changeDeleteBtnText(this$0.getDeleteNum());
                                            if (item.isChoose()) {
                                                Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(imageView);
                                            } else {
                                                Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(imageView);
                                            }
                                        }

                                        @Override // Oox.Oxx0xo
                                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                                        }

                                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
                                            int i2;
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
                                            final ImageView img2 = itemHolder.img(R.id.list_item_choose_iv);
                                            if (this.$item.isChoose()) {
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(img2);
                                                Glide.with(img2.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(img2);
                                            } else {
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(img2);
                                                Glide.with(img2.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(img2);
                                            }
                                            if (this.this$0.getOpenDeleteType()) {
                                                View view = itemHolder.itemView;
                                                final LearnCardDataItem learnCardDataItem = this.$item;
                                                final LearnCardActivity learnCardActivity = this.this$0;
                                                view.setOnClickListener(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0098: INVOKE 
                                                      (r2v3 'view' android.view.View)
                                                      (wrap:android.view.View$OnClickListener:0x0095: CONSTRUCTOR 
                                                      (r4v8 'learnCardDataItem' com.sma.smartv3.model.LearnCardDataItem A[DONT_INLINE])
                                                      (r5v3 'learnCardActivity' com.sma.smartv3.ui.device.LearnCardActivity A[DONT_INLINE])
                                                      (r3v11 'img2' android.widget.ImageView A[DONT_INLINE])
                                                     A[MD:(com.sma.smartv3.model.LearnCardDataItem, com.sma.smartv3.ui.device.LearnCardActivity, android.widget.ImageView):void (m), WRAPPED] call: com.sma.smartv3.ui.device.XoIxOXIXo.<init>(com.sma.smartv3.model.LearnCardDataItem, com.sma.smartv3.ui.device.LearnCardActivity, android.widget.ImageView):void type: CONSTRUCTOR)
                                                     VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.LearnCardActivity.showList.1.2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.XoIxOXIXo, state: NOT_LOADED
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
                                                    	... 21 more
                                                    */
                                                /*
                                                    this = this;
                                                    java.lang.String r3 = "itemHolder"
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r3)
                                                    java.lang.String r3 = "adapterItem"
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
                                                    java.lang.String r3 = "payloads"
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r3)
                                                    r3 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                                    android.widget.ImageView r3 = r2.img(r3)
                                                    if (r3 == 0) goto L21
                                                    com.sma.smartv3.model.LearnCardDataItem r4 = r1.$item
                                                    int r4 = r4.getPath()
                                                    r3.setImageResource(r4)
                                                L21:
                                                    r3 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                                    android.widget.TextView r3 = r2.tv(r3)
                                                    if (r3 != 0) goto L2b
                                                    goto L34
                                                L2b:
                                                    com.sma.smartv3.model.LearnCardDataItem r4 = r1.$item
                                                    java.lang.String r4 = r4.getName()
                                                    r3.setText(r4)
                                                L34:
                                                    r3 = 2131362054(0x7f0a0106, float:1.8343878E38)
                                                    android.widget.TextView r3 = r2.tv(r3)
                                                    if (r3 != 0) goto L3e
                                                    goto L43
                                                L3e:
                                                    java.lang.String r4 = ""
                                                    r3.setText(r4)
                                                L43:
                                                    r3 = 2131365828(0x7f0a0fc4, float:1.8351532E38)
                                                    android.widget.ImageView r3 = r2.img(r3)
                                                    com.sma.smartv3.model.LearnCardDataItem r4 = r1.$item
                                                    boolean r4 = r4.isChoose()
                                                    if (r4 == 0) goto L6c
                                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
                                                    android.content.Context r4 = r3.getContext()
                                                    com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
                                                    r5 = 2131232380(0x7f08067c, float:1.8080868E38)
                                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                                    com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
                                                    r4.into(r3)
                                                    goto L85
                                                L6c:
                                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
                                                    android.content.Context r4 = r3.getContext()
                                                    com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
                                                    r5 = 2131232381(0x7f08067d, float:1.808087E38)
                                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                                    com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
                                                    r4.into(r3)
                                                L85:
                                                    com.sma.smartv3.ui.device.LearnCardActivity r4 = r1.this$0
                                                    boolean r4 = r4.getOpenDeleteType()
                                                    if (r4 == 0) goto L9d
                                                    android.view.View r2 = r2.itemView
                                                    com.sma.smartv3.model.LearnCardDataItem r4 = r1.$item
                                                    com.sma.smartv3.ui.device.LearnCardActivity r5 = r1.this$0
                                                    com.sma.smartv3.ui.device.XoIxOXIXo r0 = new com.sma.smartv3.ui.device.XoIxOXIXo
                                                    r0.<init>(r4, r5, r3)
                                                    r2.setOnClickListener(r0)
                                                    r2 = 0
                                                    goto L9f
                                                L9d:
                                                    r2 = 8
                                                L9f:
                                                    r3.setVisibility(r2)
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.LearnCardActivity$showList$1.AnonymousClass2.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                            dslItem.setItemBindOverride(new AnonymousClass1(learnCardDataItem, learnCardActivity2));
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            }
