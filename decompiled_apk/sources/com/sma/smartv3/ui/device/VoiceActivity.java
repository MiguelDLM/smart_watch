package com.sma.smartv3.ui.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.biz.voice.VoiceMessage;
import com.sma.smartv3.biz.voice.VoicePlayer;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.me.AiKeySetActivity;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nVoiceActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceActivity.kt\ncom/sma/smartv3/ui/device/VoiceActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,443:1\n39#2,3:444\n42#2:450\n44#2,2:452\n31#2,2:463\n39#2,3:465\n42#2:471\n44#2,2:473\n31#2,2:477\n1549#3:447\n1620#3,2:448\n1622#3:451\n1549#3:468\n1620#3,2:469\n1622#3:472\n1855#3,2:475\n69#4,3:454\n72#4,5:458\n1#5:457\n*S KotlinDebug\n*F\n+ 1 VoiceActivity.kt\ncom/sma/smartv3/ui/device/VoiceActivity\n*L\n289#1:444,3\n289#1:450\n289#1:452,2\n311#1:463,2\n354#1:465,3\n354#1:471\n354#1:473,2\n438#1:477,2\n289#1:447\n289#1:448,2\n289#1:451\n354#1:468\n354#1:469,2\n354#1:472\n426#1:475,2\n298#1:454,3\n298#1:458,5\n298#1:457\n*E\n"})
/* loaded from: classes12.dex */
public final class VoiceActivity extends BaseActivity {
    private MultiItemTypeAdapter<VoiceMessage> mAdapter;
    private int mClicked;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeletePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XX0 mListPop;

    @OXOo.oOoXoXO
    private CommonAdapter<String> mListPopupAdapter;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPayTipPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.VoiceActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) VoiceActivity.this.findViewById(R.id.recycler_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.VoiceActivity$etContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) VoiceActivity.this.findViewById(R.id.et_chat_content);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.VoiceActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) VoiceActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private String mTitle = ProductManager.f20544oIX0oI.x0OxxIOxX();
    private boolean mRecyclerViewAutoRefresh = true;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.VoiceActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) VoiceActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private List<String> mListPopData = CollectionsKt__CollectionsKt.XOxIOxOx("准备就绪");

    private final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final EditText getEtContent() {
        return (EditText) this.etContent$delegate.getValue();
    }

    private final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private static final void initView$lambda$0(VoiceActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        int i = this$0.mClicked + 1;
        this$0.mClicked = i;
        if (i == 10) {
            this$0.mClicked = 0;
            this$0.showListPoP();
        }
    }

    private final void refreshView() {
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter = this.mAdapter;
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter2 = null;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        multiItemTypeAdapter.notifyDataSetChanged();
        if (this.mRecyclerViewAutoRefresh) {
            RecyclerView.ItemAnimator itemAnimator = getMRecyclerView().getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            RecyclerView mRecyclerView = getMRecyclerView();
            MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter3 = this.mAdapter;
            if (multiItemTypeAdapter3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            } else {
                multiItemTypeAdapter2 = multiItemTypeAdapter3;
            }
            mRecyclerView.scrollToPosition(multiItemTypeAdapter2.getDatas().size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetPlayStatus() {
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter = this.mAdapter;
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter2 = null;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        List<VoiceMessage> datas = multiItemTypeAdapter.getDatas();
        kotlin.jvm.internal.IIX0o.oO(datas, "getDatas(...)");
        for (VoiceMessage voiceMessage : datas) {
            if (voiceMessage.getMType() == 3) {
                voiceMessage.setMStatus(0);
            }
        }
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter3 = this.mAdapter;
        if (multiItemTypeAdapter3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
        } else {
            multiItemTypeAdapter2 = multiItemTypeAdapter3;
        }
        multiItemTypeAdapter2.notifyDataSetChanged();
    }

    public static /* synthetic */ void showPayTipPopup$default(VoiceActivity voiceActivity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.string.points_insufficient_tip;
        }
        voiceActivity.showPayTipPopup(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$1(VoiceActivity this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (motionEvent.getAction() == 2) {
            this$0.mRecyclerViewAutoRefresh = false;
        }
        return false;
    }

    public final boolean getMRecyclerViewAutoRefresh() {
        return this.mRecyclerViewAutoRefresh;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @OXOo.OOXIXo
    public final List<VoiceMessage> initList() {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbhTitleCenter().setText(this.mTitle);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_delete);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getMRecyclerView().setLayoutManager(new GridLayoutManager(getMContext(), 3));
        touchListener();
        final List<VoiceMessage> initList = initList();
        this.mAdapter = new MultiItemTypeAdapter<VoiceMessage>(this, initList) { // from class: com.sma.smartv3.ui.device.VoiceActivity$initView$1

            /* renamed from: com.sma.smartv3.ui.device.VoiceActivity$initView$1$3, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass3 implements oo.xoXoI<VoiceMessage> {

                /* renamed from: II0xO0, reason: collision with root package name */
                public final /* synthetic */ VoiceActivity$initView$1 f22053II0xO0;

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ VoiceActivity f22054oIX0oI;

                public AnonymousClass3(VoiceActivity voiceActivity, VoiceActivity$initView$1 voiceActivity$initView$1) {
                    this.f22054oIX0oI = voiceActivity;
                    this.f22053II0xO0 = voiceActivity$initView$1;
                }

                public static final void XO(VoiceMessage t, final VoiceActivity this$0, ImageView imageView, int i, View view) {
                    MultiItemTypeAdapter multiItemTypeAdapter;
                    MultiItemTypeAdapter multiItemTypeAdapter2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(t, "$t");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    VoicePlayer voicePlayer = VoicePlayer.INSTANCE;
                    if (voicePlayer.isPlay()) {
                        int mStatus = t.getMStatus();
                        voicePlayer.stop();
                        this$0.resetPlayStatus();
                        if (mStatus == 3) {
                            imageView.setImageResource(R.drawable.icon_play);
                            return;
                        }
                    }
                    multiItemTypeAdapter = this$0.mAdapter;
                    MultiItemTypeAdapter multiItemTypeAdapter3 = null;
                    if (multiItemTypeAdapter == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                        multiItemTypeAdapter = null;
                    }
                    ((VoiceMessage) multiItemTypeAdapter.getDatas().get(i)).setMStatus(3);
                    voicePlayer.play(t.getMExtraInfo(), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: INVOKE 
                          (r7v3 'voicePlayer' com.sma.smartv3.biz.voice.VoicePlayer)
                          (wrap:java.lang.String:0x0040: INVOKE (r3v0 't' com.sma.smartv3.biz.voice.VoiceMessage) VIRTUAL call: com.sma.smartv3.biz.voice.VoiceMessage.getMExtraInfo():java.lang.String A[MD:():java.lang.String (m), WRAPPED] (LINE:65))
                          (wrap:Oox.oOoXoXO<java.lang.Boolean, kotlin.oXIO0o0XI>:0x0046: CONSTRUCTOR (r4v0 'this$0' com.sma.smartv3.ui.device.VoiceActivity A[DONT_INLINE]) A[MD:(com.sma.smartv3.ui.device.VoiceActivity):void (m), WRAPPED] (LINE:71) call: com.sma.smartv3.ui.device.VoiceActivity$initView$1$3$convert$2$1.<init>(com.sma.smartv3.ui.device.VoiceActivity):void type: CONSTRUCTOR)
                         VIRTUAL call: com.sma.smartv3.biz.voice.VoicePlayer.play(java.lang.String, Oox.oOoXoXO):void A[MD:(java.lang.String, Oox.oOoXoXO<? super java.lang.Boolean, kotlin.oXIO0o0XI>):void (m)] (LINE:74) in method: com.sma.smartv3.ui.device.VoiceActivity$initView$1.3.XO(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int, android.view.View):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.VoiceActivity$initView$1$3$convert$2$1, state: NOT_LOADED
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
                        java.lang.String r7 = "$t"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r7)
                        java.lang.String r7 = "this$0"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r7)
                        com.sma.smartv3.biz.voice.VoicePlayer r7 = com.sma.smartv3.biz.voice.VoicePlayer.INSTANCE
                        boolean r0 = r7.isPlay()
                        r1 = 3
                        if (r0 == 0) goto L26
                        int r0 = r3.getMStatus()
                        r7.stop()
                        com.sma.smartv3.ui.device.VoiceActivity.access$resetPlayStatus(r4)
                        if (r0 != r1) goto L26
                        r3 = 2131234272(0x7f080de0, float:1.8084705E38)
                        r5.setImageResource(r3)
                        return
                    L26:
                        com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter r5 = com.sma.smartv3.ui.device.VoiceActivity.access$getMAdapter$p(r4)
                        r0 = 0
                        java.lang.String r2 = "mAdapter"
                        if (r5 != 0) goto L33
                        kotlin.jvm.internal.IIX0o.XOxIOxOx(r2)
                        r5 = r0
                    L33:
                        java.util.List r5 = r5.getDatas()
                        java.lang.Object r5 = r5.get(r6)
                        com.sma.smartv3.biz.voice.VoiceMessage r5 = (com.sma.smartv3.biz.voice.VoiceMessage) r5
                        r5.setMStatus(r1)
                        java.lang.String r3 = r3.getMExtraInfo()
                        com.sma.smartv3.ui.device.VoiceActivity$initView$1$3$convert$2$1 r5 = new com.sma.smartv3.ui.device.VoiceActivity$initView$1$3$convert$2$1
                        r5.<init>(r4)
                        r7.play(r3, r5)
                        com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter r3 = com.sma.smartv3.ui.device.VoiceActivity.access$getMAdapter$p(r4)
                        if (r3 != 0) goto L56
                        kotlin.jvm.internal.IIX0o.XOxIOxOx(r2)
                        goto L57
                    L56:
                        r0 = r3
                    L57:
                        r0.notifyDataSetChanged()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.VoiceActivity$initView$1.AnonymousClass3.XO(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int, android.view.View):void");
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_voice_chat_receive_audio;
                }

                @Override // oo.xoXoI
                /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO VoiceMessage voiceMessage, int i) {
                    if (voiceMessage == null || voiceMessage.getMType() != 3) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final VoiceMessage t, final int i) {
                    String mContent;
                    String str;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(t, "t");
                    if (TextUtils.isEmpty(t.getMContent())) {
                        mContent = this.f22054oIX0oI.getString(R.string.waiting);
                    } else {
                        mContent = t.getMContent();
                    }
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mContent);
                    View view = holder.getView(R.id.tv_receive_content);
                    VoiceActivity$initView$1 voiceActivity$initView$1 = this.f22053II0xO0;
                    TextView textView = (TextView) view;
                    textView.setText(mContent);
                    textView.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(((MultiItemTypeAdapter) voiceActivity$initView$1).mContext, R.color.voice_receive_bg_color)));
                    TextView textView2 = (TextView) holder.getView(R.id.tv_receive_nick);
                    str = this.f22054oIX0oI.mTitle;
                    textView2.setText(str);
                    final ImageView imageView = (ImageView) holder.getView(R.id.btn_play);
                    if (t.getMStatus() == 3) {
                        imageView.setImageResource(R.drawable.icon_playing);
                    } else {
                        imageView.setImageResource(R.drawable.icon_play);
                    }
                    final VoiceActivity voiceActivity = this.f22054oIX0oI;
                    imageView.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007b: INVOKE 
                          (r4v2 'imageView' android.widget.ImageView)
                          (wrap:android.view.View$OnClickListener:0x0078: CONSTRUCTOR 
                          (r5v0 't' com.sma.smartv3.biz.voice.VoiceMessage A[DONT_INLINE])
                          (r0v15 'voiceActivity' com.sma.smartv3.ui.device.VoiceActivity A[DONT_INLINE])
                          (r4v2 'imageView' android.widget.ImageView A[DONT_INLINE])
                          (r6v0 'i' int A[DONT_INLINE])
                         A[MD:(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int):void (m), WRAPPED] (LINE:121) call: com.sma.smartv3.ui.device.x00X0xoXO.<init>(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:124) in method: com.sma.smartv3.ui.device.VoiceActivity$initView$1.3.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.biz.voice.VoiceMessage, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.x00X0xoXO, state: NOT_LOADED
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
                        java.lang.String r0 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                        java.lang.String r0 = "t"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
                        java.lang.String r0 = r5.getMContent()
                        boolean r0 = android.text.TextUtils.isEmpty(r0)
                        if (r0 == 0) goto L1e
                        com.sma.smartv3.ui.device.VoiceActivity r0 = r3.f22054oIX0oI
                        r1 = 2132022131(0x7f141373, float:1.9682673E38)
                        java.lang.String r0 = r0.getString(r1)
                        goto L22
                    L1e:
                        java.lang.String r0 = r5.getMContent()
                    L22:
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                        r1 = 2131368439(0x7f0a19f7, float:1.8356828E38)
                        android.view.View r1 = r4.getView(r1)
                        com.sma.smartv3.ui.device.VoiceActivity$initView$1 r2 = r3.f22053II0xO0
                        android.widget.TextView r1 = (android.widget.TextView) r1
                        r1.setText(r0)
                        android.content.Context r0 = com.sma.smartv3.ui.device.VoiceActivity$initView$1.m284access$getMContext$p$s1623866647(r2)
                        r2 = 2131101801(0x7f060869, float:1.7816022E38)
                        int r0 = oIxOXo.oxoX.I0Io(r0, r2)
                        android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
                        r1.setBackgroundTintList(r0)
                        r0 = 2131368440(0x7f0a19f8, float:1.835683E38)
                        android.view.View r0 = r4.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        com.sma.smartv3.ui.device.VoiceActivity r1 = r3.f22054oIX0oI
                        java.lang.String r1 = com.sma.smartv3.ui.device.VoiceActivity.access$getMTitle$p(r1)
                        r0.setText(r1)
                        r0 = 2131363461(0x7f0a0685, float:1.8346731E38)
                        android.view.View r4 = r4.getView(r0)
                        android.widget.ImageView r4 = (android.widget.ImageView) r4
                        int r0 = r5.getMStatus()
                        r1 = 3
                        if (r0 != r1) goto L6e
                        r0 = 2131234273(0x7f080de1, float:1.8084707E38)
                        r4.setImageResource(r0)
                        goto L74
                    L6e:
                        r0 = 2131234272(0x7f080de0, float:1.8084705E38)
                        r4.setImageResource(r0)
                    L74:
                        com.sma.smartv3.ui.device.VoiceActivity r0 = r3.f22054oIX0oI
                        com.sma.smartv3.ui.device.x00X0xoXO r1 = new com.sma.smartv3.ui.device.x00X0xoXO
                        r1.<init>(r5, r0, r4, r6)
                        r4.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.VoiceActivity$initView$1.AnonymousClass3.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.biz.voice.VoiceMessage, int):void");
                }
            }

            /* loaded from: classes12.dex */
            public static final class I0Io implements oo.xoXoI<VoiceMessage> {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ VoiceActivity f22055oIX0oI;

                public I0Io(VoiceActivity voiceActivity) {
                    this.f22055oIX0oI = voiceActivity;
                }

                public static final void II0XooXoX(VoiceActivity this$0) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    this$0.resetPlayStatus();
                }

                public static final void Oxx0IOOO(VoiceMessage t, final VoiceActivity this$0, ImageView imageView, int i, View view) {
                    MultiItemTypeAdapter multiItemTypeAdapter;
                    MultiItemTypeAdapter multiItemTypeAdapter2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(t, "$t");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    com.sma.smartv3.util.xoxXI xoxxi = com.sma.smartv3.util.xoxXI.f24733oIX0oI;
                    xoxxi.xxIXOIIO();
                    if (xoxxi.II0xO0()) {
                        int mStatus = t.getMStatus();
                        xoxxi.xxIXOIIO();
                        this$0.resetPlayStatus();
                        if (mStatus == 3) {
                            imageView.setImageResource(R.drawable.icon_play);
                            return;
                        }
                    }
                    multiItemTypeAdapter = this$0.mAdapter;
                    MultiItemTypeAdapter multiItemTypeAdapter3 = null;
                    if (multiItemTypeAdapter == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                        multiItemTypeAdapter = null;
                    }
                    ((VoiceMessage) multiItemTypeAdapter.getDatas().get(i)).setMStatus(3);
                    com.sma.smartv3.util.xoxXI.X0o0xo(xoxxi, t.getMExtraInfo(), 0, 2, null);
                    com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI, "点击播放  播放传输的pcm音频");
                    multiItemTypeAdapter2 = this$0.mAdapter;
                    if (multiItemTypeAdapter2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                    } else {
                        multiItemTypeAdapter3 = multiItemTypeAdapter2;
                    }
                    multiItemTypeAdapter3.notifyDataSetChanged();
                    new Handler(Looper.getMainLooper()).postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0072: INVOKE 
                          (wrap:android.os.Handler:0x0068: CONSTRUCTOR 
                          (wrap:android.os.Looper:0x0064: INVOKE  STATIC call: android.os.Looper.getMainLooper():android.os.Looper A[MD:():android.os.Looper (c), WRAPPED] (LINE:101))
                         A[MD:(android.os.Looper):void (c), WRAPPED] (LINE:105) call: android.os.Handler.<init>(android.os.Looper):void type: CONSTRUCTOR)
                          (wrap:java.lang.Runnable:0x006d: CONSTRUCTOR (r4v0 'this$0' com.sma.smartv3.ui.device.VoiceActivity A[DONT_INLINE]) A[MD:(com.sma.smartv3.ui.device.VoiceActivity):void (m), WRAPPED] (LINE:110) call: com.sma.smartv3.ui.device.IoX.<init>(com.sma.smartv3.ui.device.VoiceActivity):void type: CONSTRUCTOR)
                          (4000 long)
                         VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:115) in method: com.sma.smartv3.ui.device.VoiceActivity$initView$1.I0Io.Oxx0IOOO(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int, android.view.View):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.IoX, state: NOT_LOADED
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
                        java.lang.String r7 = "$t"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r7)
                        java.lang.String r7 = "this$0"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r7)
                        com.sma.smartv3.util.xoxXI r7 = com.sma.smartv3.util.xoxXI.f24733oIX0oI
                        r7.xxIXOIIO()
                        boolean r0 = r7.II0xO0()
                        r1 = 3
                        if (r0 == 0) goto L29
                        int r0 = r3.getMStatus()
                        r7.xxIXOIIO()
                        com.sma.smartv3.ui.device.VoiceActivity.access$resetPlayStatus(r4)
                        if (r0 != r1) goto L29
                        r3 = 2131234272(0x7f080de0, float:1.8084705E38)
                        r5.setImageResource(r3)
                        return
                    L29:
                        com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter r5 = com.sma.smartv3.ui.device.VoiceActivity.access$getMAdapter$p(r4)
                        java.lang.String r0 = "mAdapter"
                        r2 = 0
                        if (r5 != 0) goto L36
                        kotlin.jvm.internal.IIX0o.XOxIOxOx(r0)
                        r5 = r2
                    L36:
                        java.util.List r5 = r5.getDatas()
                        java.lang.Object r5 = r5.get(r6)
                        com.sma.smartv3.biz.voice.VoiceMessage r5 = (com.sma.smartv3.biz.voice.VoiceMessage) r5
                        r5.setMStatus(r1)
                        java.lang.String r3 = r3.getMExtraInfo()
                        r5 = 0
                        r6 = 2
                        com.sma.smartv3.util.xoxXI.X0o0xo(r7, r3, r5, r6, r2)
                        java.lang.String r3 = "AI_VOICE_TEST_LOG"
                        java.lang.String r5 = "点击播放  播放传输的pcm音频"
                        com.sma.smartv3.util.x0xO0oo.oIX0oI(r3, r5)
                        com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter r3 = com.sma.smartv3.ui.device.VoiceActivity.access$getMAdapter$p(r4)
                        if (r3 != 0) goto L5e
                        kotlin.jvm.internal.IIX0o.XOxIOxOx(r0)
                        goto L5f
                    L5e:
                        r2 = r3
                    L5f:
                        r2.notifyDataSetChanged()
                        android.os.Handler r3 = new android.os.Handler
                        android.os.Looper r5 = android.os.Looper.getMainLooper()
                        r3.<init>(r5)
                        com.sma.smartv3.ui.device.IoX r5 = new com.sma.smartv3.ui.device.IoX
                        r5.<init>(r4)
                        r6 = 4000(0xfa0, double:1.9763E-320)
                        r3.postDelayed(r5, r6)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.VoiceActivity$initView$1.I0Io.Oxx0IOOO(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int, android.view.View):void");
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_voice_chat_audio_send;
                }

                @Override // oo.xoXoI
                /* renamed from: XO, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final VoiceMessage t, final int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(t, "t");
                    ((TextView) holder.getView(R.id.tv_send_content)).setText(t.getMContent());
                    ImageView imageView = (ImageView) holder.getView(R.id.iv_send_picture);
                    imageView.setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(this.f22055oIX0oI, R.drawable.icon_voice_chat_gpt));
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
                        imageView.setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
                    }
                    final ImageView imageView2 = (ImageView) holder.getView(R.id.btn_play);
                    t.getMExtraInfo().length();
                    imageView2.setVisibility(8);
                    final VoiceActivity voiceActivity = this.f22055oIX0oI;
                    imageView2.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: INVOKE 
                          (r4v2 'imageView2' android.widget.ImageView)
                          (wrap:android.view.View$OnClickListener:0x005f: CONSTRUCTOR 
                          (r5v0 't' com.sma.smartv3.biz.voice.VoiceMessage A[DONT_INLINE])
                          (r0v11 'voiceActivity' com.sma.smartv3.ui.device.VoiceActivity A[DONT_INLINE])
                          (r4v2 'imageView2' android.widget.ImageView A[DONT_INLINE])
                          (r6v0 'i' int A[DONT_INLINE])
                         A[MD:(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int):void (m), WRAPPED] (LINE:96) call: com.sma.smartv3.ui.device.XOo0.<init>(com.sma.smartv3.biz.voice.VoiceMessage, com.sma.smartv3.ui.device.VoiceActivity, android.widget.ImageView, int):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:99) in method: com.sma.smartv3.ui.device.VoiceActivity$initView$1.I0Io.XO(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.biz.voice.VoiceMessage, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.XOo0, state: NOT_LOADED
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
                        java.lang.String r0 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                        java.lang.String r0 = "t"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
                        r0 = 2131368470(0x7f0a1a16, float:1.835689E38)
                        android.view.View r0 = r4.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        java.lang.String r1 = r5.getMContent()
                        r0.setText(r1)
                        r0 = 2131365064(0x7f0a0cc8, float:1.8349983E38)
                        android.view.View r0 = r4.getView(r0)
                        com.sma.smartv3.ui.device.VoiceActivity r1 = r3.f22055oIX0oI
                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                        r2 = 2131234435(0x7f080e83, float:1.8085036E38)
                        android.graphics.drawable.Drawable r1 = oIxOXo.oxoX.Oxx0IOOO(r1, r2)
                        r0.setImageDrawable(r1)
                        X00IoxXI.oIX0oI r1 = X00IoxXI.oIX0oI.f3233oIX0oI
                        java.io.File r2 = com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(r1)
                        boolean r2 = r2.exists()
                        if (r2 == 0) goto L46
                        java.io.File r1 = com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(r1)
                        android.net.Uri r1 = android.net.Uri.fromFile(r1)
                        r0.setImageURI(r1)
                    L46:
                        r0 = 2131363461(0x7f0a0685, float:1.8346731E38)
                        android.view.View r4 = r4.getView(r0)
                        android.widget.ImageView r4 = (android.widget.ImageView) r4
                        java.lang.String r0 = r5.getMExtraInfo()
                        r0.length()
                        r0 = 8
                        r4.setVisibility(r0)
                        com.sma.smartv3.ui.device.VoiceActivity r0 = r3.f22055oIX0oI
                        com.sma.smartv3.ui.device.XOo0 r1 = new com.sma.smartv3.ui.device.XOo0
                        r1.<init>(r5, r0, r4, r6)
                        r4.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.VoiceActivity$initView$1.I0Io.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.biz.voice.VoiceMessage, int):void");
                }

                @Override // oo.xoXoI
                /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO VoiceMessage voiceMessage, int i) {
                    if (voiceMessage == null || voiceMessage.getMType() != 4) {
                        return false;
                    }
                    return true;
                }
            }

            /* loaded from: classes12.dex */
            public static final class II0xO0 implements oo.xoXoI<VoiceMessage> {

                /* renamed from: II0xO0, reason: collision with root package name */
                public final /* synthetic */ VoiceActivity$initView$1 f22056II0xO0;

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ VoiceActivity f22057oIX0oI;

                public II0xO0(VoiceActivity voiceActivity, VoiceActivity$initView$1 voiceActivity$initView$1) {
                    this.f22057oIX0oI = voiceActivity;
                    this.f22056II0xO0 = voiceActivity$initView$1;
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_voice_chat_receive;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO VoiceMessage voiceMessage, int i) {
                    if (voiceMessage == null || voiceMessage.getMType() != 2) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo VoiceMessage t, int i) {
                    String mContent;
                    String str;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(t, "t");
                    if (TextUtils.isEmpty(t.getMContent())) {
                        mContent = this.f22057oIX0oI.getString(R.string.waiting);
                    } else {
                        mContent = t.getMContent();
                    }
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mContent);
                    View view = holder.getView(R.id.tv_receive_content);
                    VoiceActivity$initView$1 voiceActivity$initView$1 = this.f22056II0xO0;
                    TextView textView = (TextView) view;
                    textView.setText(mContent);
                    textView.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(((MultiItemTypeAdapter) voiceActivity$initView$1).mContext, R.color.voice_receive_bg_color)));
                    TextView textView2 = (TextView) holder.getView(R.id.tv_receive_nick);
                    str = this.f22057oIX0oI.mTitle;
                    textView2.setText(str);
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oo.xoXoI<VoiceMessage> {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ VoiceActivity f22058oIX0oI;

                public oIX0oI(VoiceActivity voiceActivity) {
                    this.f22058oIX0oI = voiceActivity;
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_voice_chat_send;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO VoiceMessage voiceMessage, int i) {
                    if (voiceMessage == null || voiceMessage.getMType() != 1) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo VoiceMessage t, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(t, "t");
                    ((TextView) holder.getView(R.id.tv_send_content)).setText(t.getMContent());
                    ImageView imageView = (ImageView) holder.getView(R.id.iv_send_picture);
                    imageView.setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(this.f22058oIX0oI, R.drawable.icon_voice_default_icon));
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
                        imageView.setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
                    }
                }
            }

            {
                addItemViewDelegate(1, new oIX0oI(this));
                addItemViewDelegate(2, new II0xO0(this, this));
                addItemViewDelegate(3, new AnonymousClass3(this, this));
                addItemViewDelegate(4, new I0Io(this));
            }
        };
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView mRecyclerView = getMRecyclerView();
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter = this.mAdapter;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        mRecyclerView.setAdapter(multiItemTypeAdapter);
        refreshView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_voice;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        resetPlayStatus();
        com.sma.smartv3.pop.XX0 xx02 = this.mListPop;
        if (xx02 != null) {
            xx02.dismiss();
        }
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter = this.mAdapter;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        List<VoiceMessage> datas = multiItemTypeAdapter.getDatas();
        kotlin.jvm.internal.IIX0o.oO(datas, "getDatas(...)");
        XO2.put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(datas));
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24632oOo, null, 2, null);
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
        Editable text = getEtContent().getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            if (VoiceManager.INSTANCE.isTaskRunning()) {
                ToastUtils.showLong(R.string.task_running_wait_tip);
                return;
            }
            KeyboardUtils.hideSoftInput(this);
            MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter = this.mAdapter;
            MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter2 = null;
            if (multiItemTypeAdapter == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            multiItemTypeAdapter.getDatas().add(new VoiceMessage(0, null, 1, str, null, 0, 51, null));
            MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter3 = this.mAdapter;
            if (multiItemTypeAdapter3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter3 = null;
            }
            multiItemTypeAdapter3.getDatas().add(new VoiceMessage(0, null, 2, "", null, 1, 19, null));
            SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
            MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter4 = this.mAdapter;
            if (multiItemTypeAdapter4 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            } else {
                multiItemTypeAdapter2 = multiItemTypeAdapter4;
            }
            List<VoiceMessage> datas = multiItemTypeAdapter2.getDatas();
            kotlin.jvm.internal.IIX0o.oO(datas, "getDatas(...)");
            XO2.put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(datas));
            refreshView();
            this.mRecyclerViewAutoRefresh = true;
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24636oXIO0o0XI, str);
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI, "发送问题 : " + str);
            getEtContent().setText("");
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24655xOOOX)
    public final void onSendVoice(@OXOo.OOXIXo Object data) {
        Collection<? extends VoiceMessage> ooXIXxIX2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter = this.mAdapter;
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter2 = null;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        multiItemTypeAdapter.getDatas().clear();
        MultiItemTypeAdapter<VoiceMessage> multiItemTypeAdapter3 = this.mAdapter;
        if (multiItemTypeAdapter3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
        } else {
            multiItemTypeAdapter2 = multiItemTypeAdapter3;
        }
        List<VoiceMessage> datas = multiItemTypeAdapter2.getDatas();
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList<>(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        datas.addAll(ooXIXxIX2);
        refreshView();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24608XIXIX)
    public final void onSendVoiceAutoRefresh(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        this.mRecyclerViewAutoRefresh = true;
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24422XOxxooXI)
    public final void onTakeOverVoiceLog(@OXOo.OOXIXo String data) {
        List<String> datas;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        com.sma.smartv3.pop.XX0 xx02 = this.mListPop;
        if (xx02 != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(xx02);
            if (xx02.isShowing() && this.mListPopupAdapter != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
                CommonAdapter<String> commonAdapter = this.mListPopupAdapter;
                if (commonAdapter != null && (datas = commonAdapter.getDatas()) != null) {
                    datas.add(0, simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + "  " + data);
                }
                CommonAdapter<String> commonAdapter2 = this.mListPopupAdapter;
                if (commonAdapter2 != null) {
                    commonAdapter2.notifyDataSetChanged();
                }
            }
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDeletePopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.delete_record_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.VoiceActivity$onTitleRightClick$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    MultiItemTypeAdapter multiItemTypeAdapter;
                    MultiItemTypeAdapter multiItemTypeAdapter2;
                    MultiItemTypeAdapter multiItemTypeAdapter3;
                    MultiItemTypeAdapter multiItemTypeAdapter4;
                    multiItemTypeAdapter = VoiceActivity.this.mAdapter;
                    MultiItemTypeAdapter multiItemTypeAdapter5 = null;
                    if (multiItemTypeAdapter == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                        multiItemTypeAdapter = null;
                    }
                    List<VoiceMessage> datas = multiItemTypeAdapter.getDatas();
                    kotlin.jvm.internal.IIX0o.oO(datas, "getDatas(...)");
                    for (VoiceMessage voiceMessage : datas) {
                        if (voiceMessage.getMExtraInfo().length() > 0) {
                            FileUtils.delete(voiceMessage.getMExtraInfo());
                        }
                    }
                    multiItemTypeAdapter2 = VoiceActivity.this.mAdapter;
                    if (multiItemTypeAdapter2 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                        multiItemTypeAdapter2 = null;
                    }
                    multiItemTypeAdapter2.getDatas().clear();
                    multiItemTypeAdapter3 = VoiceActivity.this.mAdapter;
                    if (multiItemTypeAdapter3 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                        multiItemTypeAdapter3 = null;
                    }
                    multiItemTypeAdapter3.notifyDataSetChanged();
                    SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                    multiItemTypeAdapter4 = VoiceActivity.this.mAdapter;
                    if (multiItemTypeAdapter4 == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                    } else {
                        multiItemTypeAdapter5 = multiItemTypeAdapter4;
                    }
                    List datas2 = multiItemTypeAdapter5.getDatas();
                    kotlin.jvm.internal.IIX0o.oO(datas2, "getDatas(...)");
                    XO2.put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(datas2));
                    return Boolean.TRUE;
                }
            });
            this.mDeletePopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mDeletePopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24412XI)
    public final void onVoiceMember(@OXOo.OOXIXo String data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        switch (data.hashCode()) {
            case 1596802:
                if (data.equals("4006")) {
                    showPayTipPopup(R.string.points_insufficient_tip);
                    return;
                }
                return;
            case 1626588:
                if (data.equals("5001")) {
                    showPayTipPopup(R.string.ai_benefit_buy_tip);
                    return;
                }
                return;
            case 1626589:
                if (data.equals("5002")) {
                    showPayTipPopup(R.string.ai_benefit_expired_tip);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setMRecyclerViewAutoRefresh(boolean z) {
        this.mRecyclerViewAutoRefresh = z;
    }

    public final void showListPoP() {
        if (this.mListPopupAdapter == null) {
            final Activity mContext = getMContext();
            final List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.mListPopData);
            this.mListPopupAdapter = new CommonAdapter<String>(mContext, o0Xo0XII) { // from class: com.sma.smartv3.ui.device.VoiceActivity$showListPoP$1
                @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
                public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo String item, int i) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                    viewHolder.setText(R.id.course_type_tv, item);
                }
            };
        }
        if (this.mListPop == null) {
            com.sma.smartv3.pop.XX0 xx02 = new com.sma.smartv3.pop.XX0(this, R.layout.pop_list2);
            xx02.IO(this.mListPopupAdapter);
            this.mListPop = xx02;
            xx02.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#66000000")));
            com.sma.smartv3.pop.XX0 xx03 = this.mListPop;
            if (xx03 != null) {
                xx03.x0xO0oo(false);
            }
        }
        com.sma.smartv3.pop.XX0 xx04 = this.mListPop;
        if (xx04 != null) {
            TextView abhTitleCenter = getAbhTitleCenter();
            kotlin.jvm.internal.IIX0o.oO(abhTitleCenter, "<get-abhTitleCenter>(...)");
            xx04.xoXoI(abhTitleCenter);
        }
    }

    public final void showPayTipPopup(int i) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (this.mPayTipPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.tip);
            xoI0Ixx02.xI(Integer.valueOf(i));
            xoI0Ixx02.oo0xXOI0I(1);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.VoiceActivity$showPayTipPopup$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    VoiceActivity voiceActivity = VoiceActivity.this;
                    String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", IIX0o2);
                    bundle.putInt("mArg1", 2);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(voiceActivity, (Class<?>) GoogleWebViewActivity.class);
                    intent.putExtras(bundle);
                    voiceActivity.startActivity(intent);
                    return Boolean.TRUE;
                }
            });
            this.mPayTipPopup = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mPayTipPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mPayTipPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void touchListener() {
        getMRecyclerView().setOnTouchListener(new View.OnTouchListener() { // from class: com.sma.smartv3.ui.device.IXX
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = VoiceActivity.touchListener$lambda$1(VoiceActivity.this, view, motionEvent);
                return z;
            }
        });
    }
}
