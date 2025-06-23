package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DragCallbackHelper;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleSMSQuickReplyContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class SMSQuickReplyActivity extends BaseDSLRecyclerActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.IIX0o mEditPop;
    private List<BleSMSQuickReplyContent> mList;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$tvTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SMSQuickReplyActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$btnBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SMSQuickReplyActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    private final void checkCount(List<BleSMSQuickReplyContent> list) {
        int i;
        boolean z = true;
        TextView tvTip = getTvTip();
        if (list.isEmpty()) {
            i = 8;
        } else {
            i = 0;
        }
        tvTip.setVisibility(i);
        int IoOoo2 = ProductManager.f20544oIX0oI.IoOoo();
        getTvTip().setText(getString(R.string.sms_quick_reply_tip, Integer.valueOf(IoOoo2)));
        View btnBottom = getBtnBottom();
        if (list.size() >= IoOoo2) {
            z = false;
        }
        btnBottom.setEnabled(z);
    }

    private final View getBtnBottom() {
        return (View) this.btnBottom$delegate.getValue();
    }

    private final TextView getTvTip() {
        return (TextView) this.tvTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showList(final List<BleSMSQuickReplyContent> list) {
        getDslAdapter().resetItem(new ArrayList());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1
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
                if (list.isEmpty()) {
                    DslAdapter.setAdapterStatus$default(this.getDslAdapter(), 1, null, 2, null);
                    return;
                }
                DslAdapter.setAdapterStatus$default(this.getDslAdapter(), 0, null, 2, null);
                this.getRecyclerView().setVisibility(0);
                for (final BleSMSQuickReplyContent bleSMSQuickReplyContent : list) {
                    DslAdapter dslAdapter = this.getDslAdapter();
                    final SMSQuickReplyActivity sMSQuickReplyActivity = this;
                    DslAdapterExKt.oO(dslAdapter, R.layout.item_sms_quick_reply, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1.1

                        /* renamed from: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes12.dex */
                        public static final class C09571 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                            final /* synthetic */ BleSMSQuickReplyContent $item;
                            final /* synthetic */ SMSQuickReplyActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C09571(BleSMSQuickReplyContent bleSMSQuickReplyContent, SMSQuickReplyActivity sMSQuickReplyActivity) {
                                super(4);
                                this.$item = bleSMSQuickReplyContent;
                                this.this$0 = sMSQuickReplyActivity;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$1(final SMSQuickReplyActivity this$0, final int i, View view) {
                                Activity mContext;
                                kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                mContext = this$0.getMContext();
                                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(mContext, 0, 2, null);
                                xoI0Ixx0.IoOoX(R.string.delete_record_remind);
                                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), SMSQuickReplyActivity$showList$1$1$1$1$1$1.INSTANCE);
                                xoI0Ixx0.x0o(R.string.delete, 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: INVOKE 
                                      (r6v2 'xoI0Ixx0' com.sma.smartv3.pop.XoI0Ixx0)
                                      (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.string.delete int)
                                      (wrap:Oox.oIX0oI<java.lang.Boolean>:0x0025: CONSTRUCTOR (r4v0 'this$0' com.sma.smartv3.ui.device.SMSQuickReplyActivity A[DONT_INLINE]), (r5v0 'i' int A[DONT_INLINE]) A[MD:(com.sma.smartv3.ui.device.SMSQuickReplyActivity, int):void (m), WRAPPED] (LINE:38) call: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1$1$1$2.<init>(com.sma.smartv3.ui.device.SMSQuickReplyActivity, int):void type: CONSTRUCTOR)
                                     VIRTUAL call: com.sma.smartv3.pop.XoI0Ixx0.x0o(int, Oox.oIX0oI):void A[MD:(int, Oox.oIX0oI<java.lang.Boolean>):void (m)] (LINE:44) in method: com.sma.smartv3.ui.device.SMSQuickReplyActivity.showList.1.1.1.invoke$lambda$1(com.sma.smartv3.ui.device.SMSQuickReplyActivity, int, android.view.View):void, file: classes12.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1$1$1$2, state: NOT_LOADED
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
                                    java.lang.String r6 = "this$0"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r6)
                                    com.sma.smartv3.pop.XoI0Ixx0 r6 = new com.sma.smartv3.pop.XoI0Ixx0
                                    android.app.Activity r0 = com.sma.smartv3.ui.device.SMSQuickReplyActivity.access$getMContext(r4)
                                    r1 = 2
                                    r2 = 0
                                    r3 = 0
                                    r6.<init>(r0, r3, r1, r2)
                                    r0 = 2132018207(0x7f14041f, float:1.9674714E38)
                                    r6.IoOoX(r0)
                                    r0 = 2132017863(0x7f1402c7, float:1.9674016E38)
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                                    com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1$1$1$1 r1 = com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1$1$1$1.INSTANCE
                                    r6.X00IoxXI(r0, r1)
                                    com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1$1$1$2 r0 = new com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1$1$1$1$1$2
                                    r0.<init>(r4, r5)
                                    r4 = 2132018200(0x7f140418, float:1.96747E38)
                                    r6.x0o(r4, r0)
                                    r4 = 2131367089(0x7f0a14b1, float:1.835409E38)
                                    r6.oI0IIXIo(r4)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1.AnonymousClass1.C09571.invoke$lambda$1(com.sma.smartv3.ui.device.SMSQuickReplyActivity, int, android.view.View):void");
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, final int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                TextView tv = itemHolder.tv(R.id.tv);
                                if (tv != null) {
                                    tv.setText(this.$item.getMContent());
                                }
                                ImageView img = itemHolder.img(R.id.btn_delete);
                                if (img != null) {
                                    final SMSQuickReplyActivity sMSQuickReplyActivity = this.this$0;
                                    img.setOnClickListener(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE 
                                          (r2v1 'img' android.widget.ImageView)
                                          (wrap:android.view.View$OnClickListener:0x002f: CONSTRUCTOR 
                                          (r4v5 'sMSQuickReplyActivity' com.sma.smartv3.ui.device.SMSQuickReplyActivity A[DONT_INLINE])
                                          (r3v0 'i' int A[DONT_INLINE])
                                         A[MD:(com.sma.smartv3.ui.device.SMSQuickReplyActivity, int):void (m), WRAPPED] call: com.sma.smartv3.ui.device.xIxooxXX.<init>(com.sma.smartv3.ui.device.SMSQuickReplyActivity, int):void type: CONSTRUCTOR)
                                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.SMSQuickReplyActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.xIxooxXX, state: NOT_LOADED
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
                                        java.lang.String r0 = "itemHolder"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                                        java.lang.String r0 = "adapterItem"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                                        java.lang.String r4 = "<anonymous parameter 3>"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                                        r4 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                        android.widget.TextView r4 = r2.tv(r4)
                                        if (r4 != 0) goto L19
                                        goto L22
                                    L19:
                                        com.szabh.smable3.entity.BleSMSQuickReplyContent r5 = r1.$item
                                        java.lang.String r5 = r5.getMContent()
                                        r4.setText(r5)
                                    L22:
                                        r4 = 2131363436(0x7f0a066c, float:1.834668E38)
                                        android.widget.ImageView r2 = r2.img(r4)
                                        if (r2 == 0) goto L35
                                        com.sma.smartv3.ui.device.SMSQuickReplyActivity r4 = r1.this$0
                                        com.sma.smartv3.ui.device.xIxooxXX r5 = new com.sma.smartv3.ui.device.xIxooxXX
                                        r5.<init>(r4, r3)
                                        r2.setOnClickListener(r5)
                                    L35:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.SMSQuickReplyActivity$showList$1.AnonymousClass1.C09571.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                dslItem.setItemBindOverride(new C09571(BleSMSQuickReplyContent.this, sMSQuickReplyActivity));
                            }
                        });
                    }
                }
            });
            syncList(list);
            checkCount(list);
        }

        private final void syncList(List<BleSMSQuickReplyContent> list) {
            BleConnector.sendList$default(BleConnector.INSTANCE, BleKey.SMS_QUICK_REPLY_CONTENT, BleKeyFlag.RESET, list, false, false, 24, null);
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        @OXOo.OOXIXo
        public DslAdapterStatusItem adapterStatusItem() {
            setAdapterStatus(new AdapterStatusItem());
            return getAdapterStatus();
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public void init(@OXOo.oOoXoXO Bundle bundle) {
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
        public void initView() {
            super.initView();
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.sms_quick_reply);
            getDslAdapter().getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_sms_empty));
            List<BleSMSQuickReplyContent> list$default = BleCache.getList$default(BleCache.INSTANCE, BleKey.SMS_QUICK_REPLY_CONTENT, BleSMSQuickReplyContent.class, null, 4, null);
            this.mList = list$default;
            if (list$default == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                list$default = null;
            }
            showList(list$default);
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public int layoutId() {
            return R.layout.activity_sms_quick_reply;
        }

        public final void onBottomClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            if (this.mEditPop == null) {
                com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(getMContext(), 0, 2, null);
                iIX0o.xII(R.string.sms_quick_reply);
                iIX0o.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$onBottomClick$1$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    @OXOo.OOXIXo
                    public final Boolean invoke(@OXOo.OOXIXo String text) {
                        boolean z;
                        List list;
                        List list2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                        if (text.length() > 0) {
                            list = SMSQuickReplyActivity.this.mList;
                            List list3 = null;
                            if (list == null) {
                                kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                                list = null;
                            }
                            list.add(new BleSMSQuickReplyContent(text));
                            SMSQuickReplyActivity sMSQuickReplyActivity = SMSQuickReplyActivity.this;
                            list2 = sMSQuickReplyActivity.mList;
                            if (list2 == null) {
                                kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                            } else {
                                list3 = list2;
                            }
                            sMSQuickReplyActivity.showList(list3);
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                });
                this.mEditPop = iIX0o;
            }
            com.sma.smartv3.pop.IIX0o iIX0o2 = this.mEditPop;
            if (iIX0o2 != null) {
                iIX0o2.xXxxox0I().setTextColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.line_color));
                iIX0o2.oI0IIXIo(R.id.root_view);
            }
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public void onInitBaseLayoutAfter() {
            super.onInitBaseLayoutAfter();
            getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(1, 1));
            final DragCallbackHelper dragCallbackHelper = new DragCallbackHelper();
            dragCallbackHelper.attachToRecyclerView(getRecyclerView());
            dragCallbackHelper.setOnClearView(new Oox.x0xO0oo<RecyclerView, RecyclerView.ViewHolder, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$onInitBaseLayoutAfter$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    invoke2(recyclerView, viewHolder);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
                    List list;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "<anonymous parameter 1>");
                    if (DragCallbackHelper.this.get_dragHappened()) {
                        SMSQuickReplyActivity sMSQuickReplyActivity = this;
                        list = sMSQuickReplyActivity.mList;
                        if (list == null) {
                            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                            list = null;
                        }
                        sMSQuickReplyActivity.showList(list);
                    }
                }
            });
            dragCallbackHelper.setOnItemMoveChanged(new Oox.Oxx0xo<List<? extends DslAdapterItem>, List<? extends DslAdapterItem>, Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.SMSQuickReplyActivity$onInitBaseLayoutAfter$1$2
                {
                    super(4);
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends DslAdapterItem> list, List<? extends DslAdapterItem> list2, Integer num, Integer num2) {
                    invoke(list, list2, num.intValue(), num2.intValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(@OXOo.OOXIXo List<? extends DslAdapterItem> fromList, @OXOo.OOXIXo List<? extends DslAdapterItem> toList, int i, int i2) {
                    List list;
                    List list2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(fromList, "fromList");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(toList, "toList");
                    list = SMSQuickReplyActivity.this.mList;
                    List list3 = null;
                    if (list == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list = null;
                    }
                    Collections.swap(list, i, i2);
                    list2 = SMSQuickReplyActivity.this.mList;
                    if (list2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                    } else {
                        list3 = list2;
                    }
                    List list4 = list3;
                    ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list4, 10));
                    Iterator it = list4.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BleSMSQuickReplyContent) it.next()).getMContent());
                    }
                    LogUtils.d(String.valueOf(arrayList));
                }
            });
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
