package com.sma.smartv3.otherdevice.charge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LeftAndRightPlayControl;
import com.sma.smartv3.pop.xOOxIO;
import com.sma.smartv3.ui.me.AiKeySetActivity;
import com.sma.smartv3.util.MicrosoftSDKManage;
import java.io.Serializable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nDialogueTranslationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogueTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/DialogueTranslationActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,572:1\n86#2,2:573\n86#2,2:575\n86#2,2:624\n86#2,2:626\n69#3,3:577\n72#3,5:581\n173#3,7:586\n180#3,3:594\n143#3,7:597\n183#3:604\n173#3,7:605\n180#3,3:613\n143#3,7:616\n183#3:623\n1#4:580\n1#4:593\n1#4:612\n*S KotlinDebug\n*F\n+ 1 DialogueTranslationActivity.kt\ncom/sma/smartv3/otherdevice/charge/DialogueTranslationActivity\n*L\n204#1:573,2\n205#1:575,2\n541#1:624,2\n556#1:626,2\n273#1:577,3\n273#1:581,5\n521#1:586,7\n521#1:594,3\n521#1:597,7\n521#1:604\n526#1:605,7\n526#1:613,3\n526#1:616,7\n526#1:623\n273#1:580\n521#1:593\n526#1:612\n*E\n"})
/* loaded from: classes12.dex */
public final class DialogueTranslationActivity extends BaseTranslationActivity {
    private long lastScrollTime;
    private MultiItemTypeAdapter<AIRecords> mAdapter;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mAllDeleteTipPopup;
    private List<AIRecords> mList;

    @OXOo.oOoXoXO
    private xOOxIO popTip;
    private long showChatTime;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return DialogueTranslationActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) DialogueTranslationActivity.this.findViewById(R.id.recycler_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mChatContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$mChatContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DialogueTranslationActivity.this.findViewById(R.id.et_chat_content);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLeftRecording$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$mLeftRecording$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) DialogueTranslationActivity.this.findViewById(R.id.left_recording_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRightRecording$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$mRightRecording$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) DialogueTranslationActivity.this.findViewById(R.id.right_recording_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLeftRecordDetail$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$mLeftRecordDetail$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DialogueTranslationActivity.this.findViewById(R.id.left_record_detail);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRightRecordDetail$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$mRightRecordDetail$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DialogueTranslationActivity.this.findViewById(R.id.right_record_detail);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gifImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$gifImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) DialogueTranslationActivity.this.findViewById(R.id.pop_recording_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll_top_select_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$ll_top_select_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DialogueTranslationActivity.this.findViewById(R.id.ll_top_select_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO img_change_big$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$img_change_big$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) DialogueTranslationActivity.this.findViewById(R.id.img_change_big);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll_left_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$ll_left_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DialogueTranslationActivity.this.findViewById(R.id.ll_left_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll_right_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$ll_right_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DialogueTranslationActivity.this.findViewById(R.id.ll_right_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_left_select_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$tv_left_select_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DialogueTranslationActivity.this.findViewById(R.id.tv_left_select_language);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_right_select_language$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$tv_right_select_language$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DialogueTranslationActivity.this.findViewById(R.id.tv_right_select_language);
        }
    });

    public DialogueTranslationActivity() {
        setMAIFunctionType(AIFunctionType.AI_TRANSLATION.getType());
    }

    private final void addQuestion(String str) {
        setMAIRecords(new AIRecords(0, 0L, null, AIFunctionType.AI_TRANSLATION.getType(), getMAIRecordsType(), str, null, 0, 0, 0, null, null, null, null, null, 0, getTtsVoiceName(), 65479, null));
        List<AIRecords> list = this.mList;
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter = null;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
            list = null;
        }
        AIRecords mAIRecords = getMAIRecords();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
        list.add(mAIRecords);
        setMRecyclerViewAutoRefresh(true);
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter2 = this.mAdapter;
        if (multiItemTypeAdapter2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
        } else {
            multiItemTypeAdapter = multiItemTypeAdapter2;
        }
        multiItemTypeAdapter.notifyDataSetChanged();
        scrollView();
        sendTranslate(str);
    }

    private final ImageView getGifImg() {
        return (ImageView) this.gifImg$delegate.getValue();
    }

    private final ImageView getImg_change_big() {
        return (ImageView) this.img_change_big$delegate.getValue();
    }

    private final LinearLayout getLl_left_language() {
        return (LinearLayout) this.ll_left_language$delegate.getValue();
    }

    private final LinearLayout getLl_right_language() {
        return (LinearLayout) this.ll_right_language$delegate.getValue();
    }

    private final LinearLayout getLl_top_select_language() {
        return (LinearLayout) this.ll_top_select_language$delegate.getValue();
    }

    private final EditText getMChatContent() {
        return (EditText) this.mChatContent$delegate.getValue();
    }

    private final TextView getMLeftRecordDetail() {
        return (TextView) this.mLeftRecordDetail$delegate.getValue();
    }

    private final ImageView getMLeftRecording() {
        return (ImageView) this.mLeftRecording$delegate.getValue();
    }

    private final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private final TextView getMRightRecordDetail() {
        return (TextView) this.mRightRecordDetail$delegate.getValue();
    }

    private final ImageView getMRightRecording() {
        return (ImageView) this.mRightRecording$delegate.getValue();
    }

    private final TextView getTv_left_select_language() {
        return (TextView) this.tv_left_select_language$delegate.getValue();
    }

    private final TextView getTv_right_select_language() {
        return (TextView) this.tv_right_select_language$delegate.getValue();
    }

    private final void initAdapter() {
        final List<AIRecords> list = this.mList;
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter = null;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
            list = null;
        }
        this.mAdapter = new MultiItemTypeAdapter<AIRecords>(this, list) { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$initAdapter$1

            /* loaded from: classes12.dex */
            public static final class II0xO0 implements oo.xoXoI<AIRecords> {
                /* JADX INFO: Access modifiers changed from: private */
                public static final void XO(AIRecords mAIRecords, View view) {
                    int i;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAIRecords, "$mAIRecords");
                    MicrosoftSDKManage oIX0oI2 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI();
                    String mExtraInfo = mAIRecords.getMExtraInfo();
                    String ttsVoiceName = mAIRecords.getTtsVoiceName();
                    LeftAndRightPlayControl leftAndRightPlayControl = LeftAndRightPlayControl.LEFT_AND_RIGHT;
                    if (mAIRecords.getMType() == 1) {
                        i = 8;
                    } else {
                        i = 2;
                    }
                    oIX0oI2.oo(mExtraInfo, ttsVoiceName, leftAndRightPlayControl, i);
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_binaural_left;
                }

                @Override // oo.xoXoI
                /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AIRecords aIRecords, int i) {
                    if (aIRecords == null || aIRecords.getMType() != 2) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final AIRecords mAIRecords, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                    TextView textView = (TextView) holder.getView(R.id.tv_original);
                    TextView textView2 = (TextView) holder.getView(R.id.tv_translated);
                    textView.setText(mAIRecords.getMContent());
                    textView2.setText(mAIRecords.getMExtraInfo());
                    if (mAIRecords.getMExtraInfo().length() > 0) {
                        holder.setVisible(R.id.iv_play, true);
                    } else {
                        holder.setVisible(R.id.iv_play, false);
                    }
                    holder.setOnClickListener(R.id.iv_play, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                          (r3v0 'holder' com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder)
                          (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.iv_play int)
                          (wrap:android.view.View$OnClickListener:0x0042: CONSTRUCTOR (r4v0 'mAIRecords' com.sma.smartv3.db.entity.AIRecords A[DONT_INLINE]) A[MD:(com.sma.smartv3.db.entity.AIRecords):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.otherdevice.charge.xo0x.<init>(com.sma.smartv3.db.entity.AIRecords):void type: CONSTRUCTOR)
                         VIRTUAL call: com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder.setOnClickListener(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder A[MD:(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder (m)] (LINE:70) in method: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$initAdapter$1.II0xO0.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.xo0x, state: NOT_LOADED
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
                        java.lang.String r5 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                        java.lang.String r5 = "mAIRecords"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                        r5 = 2131368401(0x7f0a19d1, float:1.835675E38)
                        android.view.View r5 = r3.getView(r5)
                        android.widget.TextView r5 = (android.widget.TextView) r5
                        r0 = 2131371607(0x7f0a2657, float:1.8363254E38)
                        android.view.View r0 = r3.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        java.lang.String r1 = r4.getMContent()
                        r5.setText(r1)
                        java.lang.String r5 = r4.getMExtraInfo()
                        r0.setText(r5)
                        java.lang.String r5 = r4.getMExtraInfo()
                        int r5 = r5.length()
                        r0 = 2131365043(0x7f0a0cb3, float:1.834994E38)
                        if (r5 <= 0) goto L3c
                        r5 = 1
                        r3.setVisible(r0, r5)
                        goto L40
                    L3c:
                        r5 = 0
                        r3.setVisible(r0, r5)
                    L40:
                        com.sma.smartv3.otherdevice.charge.xo0x r5 = new com.sma.smartv3.otherdevice.charge.xo0x
                        r5.<init>(r4)
                        r3.setOnClickListener(r0, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$initAdapter$1.II0xO0.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void");
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oo.xoXoI<AIRecords> {
                public static final void XO(AIRecords mAIRecords, View view) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAIRecords, "$mAIRecords");
                    MicrosoftSDKManage.IoOoX(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), mAIRecords.getMExtraInfo(), mAIRecords.getTtsVoiceName(), LeftAndRightPlayControl.LEFT_AND_RIGHT, 0, 8, null);
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_binaural_right;
                }

                @Override // oo.xoXoI
                /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AIRecords aIRecords, int i) {
                    if (aIRecords == null || aIRecords.getMType() != 1) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final AIRecords mAIRecords, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                    TextView textView = (TextView) holder.getView(R.id.tv_original);
                    TextView textView2 = (TextView) holder.getView(R.id.tv_translated);
                    textView.setText(mAIRecords.getMContent());
                    textView2.setText(mAIRecords.getMExtraInfo());
                    if (mAIRecords.getMExtraInfo().length() > 0) {
                        holder.setVisible(R.id.iv_play, true);
                    } else {
                        holder.setVisible(R.id.iv_play, false);
                    }
                    holder.setOnClickListener(R.id.iv_play, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                          (r3v0 'holder' com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder)
                          (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.iv_play int)
                          (wrap:android.view.View$OnClickListener:0x0042: CONSTRUCTOR (r4v0 'mAIRecords' com.sma.smartv3.db.entity.AIRecords A[DONT_INLINE]) A[MD:(com.sma.smartv3.db.entity.AIRecords):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.otherdevice.charge.oxXx0IX.<init>(com.sma.smartv3.db.entity.AIRecords):void type: CONSTRUCTOR)
                         VIRTUAL call: com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder.setOnClickListener(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder A[MD:(int, android.view.View$OnClickListener):com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder (m)] (LINE:70) in method: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$initAdapter$1.oIX0oI.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.otherdevice.charge.oxXx0IX, state: NOT_LOADED
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
                        java.lang.String r5 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                        java.lang.String r5 = "mAIRecords"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                        r5 = 2131368401(0x7f0a19d1, float:1.835675E38)
                        android.view.View r5 = r3.getView(r5)
                        android.widget.TextView r5 = (android.widget.TextView) r5
                        r0 = 2131371607(0x7f0a2657, float:1.8363254E38)
                        android.view.View r0 = r3.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        java.lang.String r1 = r4.getMContent()
                        r5.setText(r1)
                        java.lang.String r5 = r4.getMExtraInfo()
                        r0.setText(r5)
                        java.lang.String r5 = r4.getMExtraInfo()
                        int r5 = r5.length()
                        r0 = 2131365043(0x7f0a0cb3, float:1.834994E38)
                        if (r5 <= 0) goto L3c
                        r5 = 1
                        r3.setVisible(r0, r5)
                        goto L40
                    L3c:
                        r5 = 0
                        r3.setVisible(r0, r5)
                    L40:
                        com.sma.smartv3.otherdevice.charge.oxXx0IX r5 = new com.sma.smartv3.otherdevice.charge.oxXx0IX
                        r5.<init>(r4)
                        r3.setOnClickListener(r0, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$initAdapter$1.oIX0oI.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void");
                }
            }

            {
                addItemViewDelegate(1, new oIX0oI());
                addItemViewDelegate(2, new II0xO0());
            }
        };
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView mRecyclerView = getMRecyclerView();
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter2 = this.mAdapter;
        if (multiItemTypeAdapter2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
        } else {
            multiItemTypeAdapter = multiItemTypeAdapter2;
        }
        mRecyclerView.setAdapter(multiItemTypeAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewTranslate$lambda$2(DialogueTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.popTip == null) {
            xOOxIO xooxio = new xOOxIO(this$0);
            xooxio.ooXIXxIX(this$0.getString(R.string.dialogue_tip_1));
            xooxio.xI(this$0.getString(R.string.dialogue_tip_2));
            xooxio.IIX0o(Integer.valueOf(R.drawable.ic_dialogue_tip));
            xooxio.oo0xXOI0I(Boolean.valueOf(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24450oX0I0O, false)));
            xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.XX
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DialogueTranslationActivity.initViewTranslate$lambda$2$lambda$1$lambda$0(compoundButton, z);
                }
            });
            this$0.popTip = xooxio;
        }
        xOOxIO xooxio2 = this$0.popTip;
        if (xooxio2 != null) {
            View rootView = this$0.getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xooxio2.xoXoI(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewTranslate$lambda$2$lambda$1$lambda$0(CompoundButton compoundButton, boolean z) {
        LogUtils.d("isChecked = " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24450oX0I0O, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewTranslate$lambda$5(DialogueTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.popTip == null) {
            xOOxIO xooxio = new xOOxIO(this$0);
            xooxio.ooXIXxIX(this$0.getString(R.string.dialogue_tip_1));
            xooxio.xI(this$0.getString(R.string.dialogue_tip_2));
            xooxio.IIX0o(Integer.valueOf(R.drawable.ic_dialogue_tip));
            xooxio.oo0xXOI0I(Boolean.valueOf(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24450oX0I0O, false)));
            xooxio.xXxxox0I().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.xII
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DialogueTranslationActivity.initViewTranslate$lambda$5$lambda$4$lambda$3(compoundButton, z);
                }
            });
            this$0.popTip = xooxio;
        }
        xOOxIO xooxio2 = this$0.popTip;
        if (xooxio2 != null) {
            View rootView = this$0.getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xooxio2.xoXoI(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewTranslate$lambda$5$lambda$4$lambda$3(CompoundButton compoundButton, boolean z) {
        LogUtils.d("isChecked = " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24450oX0I0O, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewTranslate$lambda$6(DialogueTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startRotateAnimation();
    }

    private final void scrollView() {
        RecyclerView.ItemAnimator itemAnimator = getMRecyclerView().getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        this.lastScrollTime = System.currentTimeMillis();
        if (getMRecyclerViewAutoRefresh()) {
            RecyclerView.LayoutManager layoutManager = getMRecyclerView().getLayoutManager();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            List<AIRecords> list = this.mList;
            if (list == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                list = null;
            }
            linearLayoutManager.scrollToPositionWithOffset(CollectionsKt__CollectionsKt.oo0xXOI0I(list), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRotateAnimation$lambda$7(RotateAnimation rotateAnimation, DialogueTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rotateAnimation, "$rotateAnimation");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        rotateAnimation.cancel();
        this$0.getMTransformLanguageImg().clearAnimation();
        this$0.setSwitchRotateAnimation(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$10(DialogueTranslationActivity this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (motionEvent.getAction() == 2) {
            this$0.setMRecyclerViewAutoRefresh(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchListener$lambda$8(DialogueTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getLl_top_select_language().setVisibility(8);
        if (RecordingManager.Companion.getInstance().isRecording()) {
            this$0.stopRecording(true);
            DcsTtsPlayer.INSTANCE.stop();
            this$0.getMLeftRecording().setImageResource(R.drawable.ic_earphone_record);
            this$0.getGifImg().setVisibility(8);
            this$0.getMLeftRecordDetail().setText(this$0.getString(R.string.click_ear_phone_record));
            return;
        }
        VoiceManager.INSTANCE.setRecordBluetooth(false);
        this$0.getMLeftRecording().setImageResource(R.drawable.ic_earphone_recording);
        this$0.getMRightRecording().setImageResource(R.drawable.ic_mobile_phone_record);
        this$0.clickDownRecording(2);
        this$0.getMLeftRecordDetail().setText(this$0.getString(R.string.click_close_record));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchListener$lambda$9(DialogueTranslationActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getLl_top_select_language().setVisibility(8);
        if (RecordingManager.Companion.getInstance().isRecording()) {
            this$0.stopRecording(true);
            DcsTtsPlayer.INSTANCE.stop();
            this$0.getMRightRecording().setImageResource(R.drawable.ic_mobile_phone_record);
            this$0.getGifImg().setVisibility(8);
            this$0.getMRightRecordDetail().setText(this$0.getString(R.string.click_mobile_phone_record));
            return;
        }
        VoiceManager.INSTANCE.setRecordBluetooth(false);
        this$0.getMLeftRecording().setImageResource(R.drawable.ic_earphone_record);
        this$0.getMRightRecording().setImageResource(R.drawable.ic_mobile_phone_recording);
        this$0.clickDownRecording(1);
        this$0.getMRightRecordDetail().setText(this$0.getString(R.string.click_close_record));
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void addList() {
        AIRecords mAIRecords = getMAIRecords();
        if (mAIRecords != null) {
            List<AIRecords> list = this.mList;
            if (list == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                list = null;
            }
            list.add(mAIRecords);
        }
    }

    public final void clickDownRecording(int i) {
        if (getMAIRecordsType() != i) {
            stopRecording(true);
        }
        setMAIRecordsType(i);
        if (PermissionUtils.isGranted(PermissionConstants.MICROPHONE)) {
            setLangAndVoice();
            startRecording();
        } else {
            permission();
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void disRecordingPopup() {
        getGifImg().setVisibility(8);
        getMLeftRecording().setImageResource(R.drawable.ic_earphone_record);
        getMRightRecording().setImageResource(R.drawable.ic_mobile_phone_record);
        getMLeftRecordDetail().setText(getString(R.string.click_ear_phone_record));
        getMRightRecordDetail().setText(getString(R.string.click_mobile_phone_record));
    }

    @OXOo.oOoXoXO
    public final xOOxIO getPopTip() {
        return this.popTip;
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        super.init(bundle);
    }

    @OXOo.OOXIXo
    public final List<AIRecords> initList() {
        List<AIRecords> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(getMRecordsDao().getListASC(getMAIFunctionType()));
        this.mList = o0Xo0XII;
        if (o0Xo0XII == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
            return null;
        }
        return o0Xo0XII;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(getString(R.string.dialogue_translation));
        initList();
        initViewTranslate();
        initAdapter();
        touchListener();
        scrollView();
    }

    public final void initViewTranslate() {
        getTv_left_select_language().setText(getMLeftLanguage().getName());
        getTv_right_select_language().setText(getMRightLanguage().getName());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleCenter().setVisibility(8);
        getAbhTitleRight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.x0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogueTranslationActivity.initViewTranslate$lambda$2(DialogueTranslationActivity.this, view);
            }
        });
        if (!com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24450oX0I0O, false)) {
            getRootView().post(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.XOxIOxOx
                @Override // java.lang.Runnable
                public final void run() {
                    DialogueTranslationActivity.initViewTranslate$lambda$5(DialogueTranslationActivity.this);
                }
            });
        }
        getImg_change_big().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.OI0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogueTranslationActivity.initViewTranslate$lambda$6(DialogueTranslationActivity.this, view);
            }
        });
    }

    public final void isShowTime(@OXOo.OOXIXo TextView tvTime, long j) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(tvTime, "tvTime");
        long j2 = this.showChatTime;
        if (j2 != 0 && j - j2 <= 300000) {
            i = 8;
        } else {
            this.showChatTime = j;
            tvTime.setText(com.sma.smartv3.util.xoIox.xXxxox0I().format(Long.valueOf(j)));
            i = 0;
        }
        tvTime.setVisibility(i);
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_dialogue_translation;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void notifyViewData() {
        super.notifyViewData();
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter = this.mAdapter;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        multiItemTypeAdapter.notifyDataSetChanged();
        scrollView();
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Serializable serializable;
        Serializable serializable2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 0) {
                if (i == 1) {
                    if (intent != null) {
                        serializable2 = intent.getSerializableExtra("language");
                    } else {
                        serializable2 = null;
                    }
                    kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable2, "null cannot be cast to non-null type com.sma.smartv3.model.LanguageTranslationData");
                    LanguageTranslationData languageTranslationData = (LanguageTranslationData) serializable2;
                    if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMLeftLanguage().getName(), languageTranslationData.getName())) {
                        setMRightLanguage(languageTranslationData);
                        getMTransformLanguageRightTv().setText(getMRightLanguage().getName());
                        getTv_right_select_language().setText(getMRightLanguage().getName());
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMRightLanguage()));
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
                        return;
                    }
                    setSwitchRotateAnimation(true);
                    startRotateAnimation();
                    return;
                }
                return;
            }
            if (intent != null) {
                serializable = intent.getSerializableExtra("language");
            } else {
                serializable = null;
            }
            kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable, "null cannot be cast to non-null type com.sma.smartv3.model.LanguageTranslationData");
            LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) serializable;
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(languageTranslationData2.getName(), getMRightLanguage().getName())) {
                setMLeftLanguage(languageTranslationData2);
                getMTransformLanguageLeftTv().setText(getMLeftLanguage().getName());
                getTv_left_select_language().setText(getMLeftLanguage().getName());
                com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMLeftLanguage()));
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
                return;
            }
            setSwitchRotateAnimation(true);
            startRotateAnimation();
        }
    }

    public final void onSend(@OXOo.OOXIXo View view) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.xIx0XO() && !productManager.oO0OX0() && TextUtils.isEmpty(productManager.I0Io()) && !productManager.XOx()) {
            ToastUtils.showLong(R.string.no_ai_key);
            startActivity(new Intent(this, (Class<?>) AiKeySetActivity.class));
            return;
        }
        Editable text = getMChatContent().getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            ToastUtils.showLong(getString(R.string.enter_content), new Object[0]);
            return;
        }
        KeyboardUtils.hideSoftInput(this);
        getMChatContent().getText().clear();
        setLangAndVoice();
        addQuestion(str);
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showDeleteTipPopup();
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void onTranslationLanguage(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        switch (view.getId()) {
            case R.id.dialogue_translation_left_tv /* 2131364027 */:
            case R.id.ll_left_language /* 2131365908 */:
                LanguageTranslationData mLeftLanguage = getMLeftLanguage();
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", mLeftLanguage);
                Intent intent = new Intent(this, (Class<?>) ChooseLanguageActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
                return;
            case R.id.dialogue_translation_right_tv /* 2131364028 */:
            case R.id.ll_right_language /* 2131365943 */:
                LanguageTranslationData mRightLanguage = getMRightLanguage();
                Bundle bundle2 = new Bundle();
                bundle2.putString("mArg0", null);
                bundle2.putParcelable("mArg2", null);
                bundle2.putSerializable("mArg3", mRightLanguage);
                Intent intent2 = new Intent(this, (Class<?>) ChooseLanguageActivity.class);
                intent2.putExtras(bundle2);
                startActivityForResult(intent2, 1);
                return;
            default:
                return;
        }
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void saveDBRecord() {
        super.saveDBRecord();
        AIRecords mAIRecords = getMAIRecords();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
        addSendRecord(mAIRecords);
    }

    public final void setPopTip(@OXOo.oOoXoXO xOOxIO xooxio) {
        this.popTip = xooxio;
    }

    public final void showDeleteTipPopup() {
        if (this.mAllDeleteTipPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.clear_ai_chat_list));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$showDeleteTipPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity$showDeleteTipPopup$1$2
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
                    MultiItemTypeAdapter multiItemTypeAdapter;
                    list = DialogueTranslationActivity.this.mList;
                    if (list == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list = null;
                    }
                    for (AIRecords aIRecords : list) {
                        aIRecords.setMIsDelete(1);
                        aIRecords.setMIsSync(0);
                    }
                    AIRecordsDao mRecordsDao = DialogueTranslationActivity.this.getMRecordsDao();
                    list2 = DialogueTranslationActivity.this.mList;
                    if (list2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list2 = null;
                    }
                    mRecordsDao.update(list2);
                    list3 = DialogueTranslationActivity.this.mList;
                    if (list3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
                        list3 = null;
                    }
                    list3.clear();
                    multiItemTypeAdapter = DialogueTranslationActivity.this.mAdapter;
                    if (multiItemTypeAdapter == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                        multiItemTypeAdapter = null;
                    }
                    multiItemTypeAdapter.notifyDataSetChanged();
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

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void showRecordingPopup() {
        Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf(R.drawable.pop_recording_animation_img)).into(getGifImg());
        getGifImg().setVisibility(0);
        getLl_top_select_language().setVisibility(8);
        RecordingManager.Companion.getInstance().setRecording(true);
        if (getMAIRecordsType() == 2) {
            getMLeftRecording().setImageResource(R.drawable.ic_earphone_recording);
            getMRightRecording().setImageResource(R.drawable.ic_mobile_phone_record);
            getMLeftRecordDetail().setText(getString(R.string.click_close_record));
            getMRightRecordDetail().setText(getString(R.string.click_mobile_phone_record));
            return;
        }
        getMLeftRecording().setImageResource(R.drawable.ic_earphone_record);
        getMRightRecording().setImageResource(R.drawable.ic_mobile_phone_recording);
        getMLeftRecordDetail().setText(getString(R.string.click_ear_phone_record));
        getMRightRecordDetail().setText(getString(R.string.click_close_record));
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void startRotateAnimation() {
        if (getSwitchRotateAnimation()) {
            getMTransformLanguageImg().clearAnimation();
            CharSequence text = getMTransformLanguageLeftTv().getText();
            CharSequence text2 = getMTransformLanguageRightTv().getText();
            final RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(500L);
            rotateAnimation.setRepeatCount(-1);
            setSwitchRotateAnimation(false);
            getMTransformLanguageImg().startAnimation(rotateAnimation);
            getImg_change_big().startAnimation(rotateAnimation);
            getMTransformLanguageLeftTv().setText(text2);
            getMTransformLanguageRightTv().setText(text);
            getTv_left_select_language().setText(text2);
            getTv_right_select_language().setText(text);
            setMCacheLanguage(getMLeftLanguage());
            setMLeftLanguage(getMRightLanguage());
            LanguageTranslationData mCacheLanguage = getMCacheLanguage();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mCacheLanguage);
            setMRightLanguage(mCacheLanguage);
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMLeftLanguage()));
            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName(), new Gson().toJson(getMRightLanguage()));
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24627oI, null, 2, null);
            getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.o0
                @Override // java.lang.Runnable
                public final void run() {
                    DialogueTranslationActivity.startRotateAnimation$lambda$7(rotateAnimation, this);
                }
            }, 500L);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void touchListener() {
        getMLeftRecording().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.I0oOoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogueTranslationActivity.touchListener$lambda$8(DialogueTranslationActivity.this, view);
            }
        });
        getMRightRecording().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.oxxXoxO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogueTranslationActivity.touchListener$lambda$9(DialogueTranslationActivity.this, view);
            }
        });
        getMRecyclerView().setOnTouchListener(new View.OnTouchListener() { // from class: com.sma.smartv3.otherdevice.charge.XoX
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = DialogueTranslationActivity.touchListener$lambda$10(DialogueTranslationActivity.this, view, motionEvent);
                return z;
            }
        });
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseTranslationActivity
    public void upDataLastList() {
        super.upDataLastList();
        List<AIRecords> list = this.mList;
        List<AIRecords> list2 = null;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
            list = null;
        }
        List<AIRecords> list3 = this.mList;
        if (list3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mList");
        } else {
            list2 = list3;
        }
        int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(list2);
        AIRecords mAIRecords = getMAIRecords();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAIRecords);
        list.set(oo0xXOI0I2, mAIRecords);
    }
}
