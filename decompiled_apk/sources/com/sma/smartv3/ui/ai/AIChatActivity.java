package com.sma.smartv3.ui.ai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.ai.speech.realtime.full.connection.Runner;
import com.baidu.ai.speech.realtime.full.download.Result;
import com.baidu.ai.speech.realtime.full.download.SimpleDownloader;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.pop.XIXIX;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.ai.AIChatActivity;
import com.sma.smartv3.ui.ai.BaseAIActivity;
import com.sma.smartv3.ui.me.AiKeySetActivity;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.text.PFMedium;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import oo.xoXoI;
import org.json.JSONArray;

@XX({"SMAP\nAIChatActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIChatActivity.kt\ncom/sma/smartv3/ui/ai/AIChatActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,803:1\n69#2,3:804\n72#2,5:808\n1#3:807\n*S KotlinDebug\n*F\n+ 1 AIChatActivity.kt\ncom/sma/smartv3/ui/ai/AIChatActivity\n*L\n680#1:804,3\n680#1:808,5\n680#1:807\n*E\n"})
/* loaded from: classes12.dex */
public class AIChatActivity extends BaseAIActivity {
    private float downY;
    private boolean isRecording;
    private long lastScrollTime;
    private long longPressStartTime;
    private MultiItemTypeAdapter<AIRecords> mAdapter;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mAllDeleteTipPopup;

    @OXOo.oOoXoXO
    private AudioRecord mAudioRecord;
    private int mBufferSize;
    public List<AIRecords> mList;

    @OXOo.oOoXoXO
    private PopupWindow mPopupWindow;

    @OXOo.oOoXoXO
    private XIXIX mRecordingPopup;

    @OXOo.oOoXoXO
    private AIRecords received;
    private boolean recordingIsClear;
    private long showChatTime;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIChatActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleOtherRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIChatActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) AIChatActivity.this.findViewById(R.id.recycler_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mChatContent$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$mChatContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) AIChatActivity.this.findViewById(R.id.et_chat_content);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnAudio$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$btnAudio$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) AIChatActivity.this.findViewById(R.id.btn_chat_audio);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivChatVoice$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$ivChatVoice$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIChatActivity.this.findViewById(R.id.iv_chat_voice);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnChatSend$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$btnChatSend$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) AIChatActivity.this.findViewById(R.id.btn_chat_send);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvOpenAiDeduction$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$tvOpenAiDeduction$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) AIChatActivity.this.findViewById(R.id.ai_chat_open_deduction_config_tv);
        }
    });
    private boolean inputMethod = true;
    private long longPressThreshold = 300;
    private boolean mRecyclerViewAutoRefresh = true;

    @OXOo.OOXIXo
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @OXOo.OOXIXo
    private String mTipContent = "";

    /* loaded from: classes12.dex */
    public static final class I0Io implements BaseAIActivity.oIX0oI<AIAnswer> {
        public I0Io() {
        }

        @Override // com.sma.smartv3.ui.ai.BaseAIActivity.oIX0oI
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void oIX0oI(@OXOo.OOXIXo AIAnswer result) {
            int i;
            IIX0o.x0xO0oo(result, "result");
            if (result.getText().length() > 0) {
                AIRecords received = AIChatActivity.this.getReceived();
                if (received != null) {
                    received.setMContent(result.getText());
                }
                AIRecords received2 = AIChatActivity.this.getReceived();
                if (received2 != null) {
                    if (result.getEnded() == 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    received2.setMStatus(i);
                }
                MultiItemTypeAdapter multiItemTypeAdapter = null;
                if (result.getEnded() == 1) {
                    MultiItemTypeAdapter multiItemTypeAdapter2 = AIChatActivity.this.mAdapter;
                    if (multiItemTypeAdapter2 == null) {
                        IIX0o.XOxIOxOx("mAdapter");
                    } else {
                        multiItemTypeAdapter = multiItemTypeAdapter2;
                    }
                    multiItemTypeAdapter.notifyItemChanged(CollectionsKt__CollectionsKt.oo0xXOI0I(AIChatActivity.this.getMList()));
                    AIChatActivity.this.scrollView();
                    return;
                }
                if (System.currentTimeMillis() - AIChatActivity.this.getLastScrollTime() > 1000) {
                    MultiItemTypeAdapter multiItemTypeAdapter3 = AIChatActivity.this.mAdapter;
                    if (multiItemTypeAdapter3 == null) {
                        IIX0o.XOxIOxOx("mAdapter");
                    } else {
                        multiItemTypeAdapter = multiItemTypeAdapter3;
                    }
                    multiItemTypeAdapter.notifyItemChanged(CollectionsKt__CollectionsKt.oo0xXOI0I(AIChatActivity.this.getMList()));
                    AIChatActivity.this.scrollView();
                }
            }
        }

        @Override // com.sma.smartv3.ui.ai.BaseAIActivity.oIX0oI
        public void error(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            AIRecords received = AIChatActivity.this.getReceived();
            if (received != null) {
                String string = AIChatActivity.this.getString(R.string.request_error);
                IIX0o.oO(string, "getString(...)");
                received.setMContent(string);
            }
            MultiItemTypeAdapter multiItemTypeAdapter = AIChatActivity.this.mAdapter;
            if (multiItemTypeAdapter == null) {
                IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            multiItemTypeAdapter.notifyItemChanged(CollectionsKt__CollectionsKt.oo0xXOI0I(AIChatActivity.this.getMList()));
            AIChatActivity.this.scrollView();
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends SimpleDownloader {
        public II0xO0() {
        }

        public static final void II0xO0(AIChatActivity this$0, Result result) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(result, "$result");
            String result2 = result.getResult();
            IIX0o.oO(result2, "getResult(...)");
            this$0.addQuestion(result2);
        }

        @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
        public void onFailure(@OXOo.oOoXoXO String str) {
            AIChatActivity.this.dismissLoading();
            super.onFailure(str);
        }

        @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
        public void onMessage(@OXOo.OOXIXo final Result result) {
            IIX0o.x0xO0oo(result, "result");
            super.onMessage(result);
            AIChatActivity.this.dismissLoading();
            if (result.isFin()) {
                final AIChatActivity aIChatActivity = AIChatActivity.this;
                aIChatActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.ai.xoIox
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIChatActivity.II0xO0.II0xO0(AIChatActivity.this, result);
                    }
                });
            } else {
                result.isError();
            }
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21628oIX0oI;

        static {
            int[] iArr = new int[AIFunctionType.values().length];
            try {
                iArr[AIFunctionType.HEALTH_QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIFunctionType.PERSONAL_TRAINER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f21628oIX0oI = iArr;
        }
    }

    public static /* synthetic */ void addMoveQuestions$default(AIChatActivity aIChatActivity, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            aIChatActivity.addMoveQuestions(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMoveQuestions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addQuestion(String str) {
        AIFunction mAIFunction = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction);
        AIRecords aIRecords = new AIRecords(0, 0L, null, mAIFunction.getType().getType(), 1, str, null, 0, 0, 0, null, null, null, null, null, 0, null, 131015, null);
        getMList().add(aIRecords);
        addSendRecord(aIRecords);
        AIFunction mAIFunction2 = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction2);
        AIRecords aIRecords2 = new AIRecords(0, 0L, null, mAIFunction2.getType().getType(), 2, "", null, 1, 0, 0, null, null, null, null, null, 0, null, 130887, null);
        this.received = aIRecords2;
        getMList().add(aIRecords2);
        addReceivedRecord(aIRecords2);
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter = this.mAdapter;
        if (multiItemTypeAdapter == null) {
            IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        multiItemTypeAdapter.notifyDataSetChanged();
        scrollView();
        sendCurrent(str);
    }

    public static /* synthetic */ void addWelcomeQuestions$default(AIChatActivity aIChatActivity, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            aIChatActivity.addWelcomeQuestions(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addWelcomeQuestions");
    }

    private final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final Button getBtnAudio() {
        return (Button) this.btnAudio$delegate.getValue();
    }

    private final Button getBtnChatSend() {
        return (Button) this.btnChatSend$delegate.getValue();
    }

    private final ImageView getIvChatVoice() {
        return (ImageView) this.ivChatVoice$delegate.getValue();
    }

    private final EditText getMChatContent() {
        return (EditText) this.mChatContent$delegate.getValue();
    }

    private final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private final PFMedium getTvOpenAiDeduction() {
        return (PFMedium) this.tvOpenAiDeduction$delegate.getValue();
    }

    private final void initAdapter() {
        final List<AIRecords> mList = getMList();
        this.mAdapter = new MultiItemTypeAdapter<AIRecords>(this, mList) { // from class: com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1

            /* loaded from: classes12.dex */
            public static final class I0Io implements xoXoI<AIRecords> {
                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_ai_chat_receive_welcome;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AIRecords aIRecords, int i) {
                    if (aIRecords == null || aIRecords.getMType() != 4) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AIRecords mAIRecords, int i) {
                    IIX0o.x0xO0oo(holder, "holder");
                    IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                }
            }

            /* loaded from: classes12.dex */
            public static final class II0xO0 implements xoXoI<AIRecords> {

                /* renamed from: II0xO0, reason: collision with root package name */
                public final /* synthetic */ AIChatActivity$initAdapter$1 f21622II0xO0;

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ AIChatActivity f21623oIX0oI;

                public II0xO0(AIChatActivity aIChatActivity, AIChatActivity$initAdapter$1 aIChatActivity$initAdapter$1) {
                    this.f21623oIX0oI = aIChatActivity;
                    this.f21622II0xO0 = aIChatActivity$initAdapter$1;
                }

                public static final void XO(AIChatActivity this$0, String content, View view) {
                    IIX0o.x0xO0oo(this$0, "this$0");
                    IIX0o.x0xO0oo(content, "$content");
                    this$0.share(content);
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_ai_chat_receive;
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
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AIRecords mAIRecords, int i) {
                    int i2;
                    IIX0o.x0xO0oo(holder, "holder");
                    IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                    TextView textView = (TextView) holder.getView(R.id.chat_receive_time);
                    AIChatActivity aIChatActivity = this.f21623oIX0oI;
                    IIX0o.ooOOo0oXI(textView);
                    aIChatActivity.isShowTime(textView, mAIRecords.getMTime());
                    final String mContent = mAIRecords.getMContent();
                    AIChatActivity aIChatActivity2 = this.f21623oIX0oI;
                    if (mContent.length() == 0) {
                        mContent = aIChatActivity2.getString(R.string.waiting);
                        IIX0o.oO(mContent, "getString(...)");
                    }
                    TextView textView2 = (TextView) holder.getView(R.id.tv_receive_content);
                    textView2.setText(mContent);
                    textView2.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(((MultiItemTypeAdapter) this.f21622II0xO0).mContext, R.color.voice_receive_bg_color)));
                    ((TextView) holder.getView(R.id.tv_receive_nick)).setVisibility(8);
                    ImageView imageView = (ImageView) holder.getView(R.id.img_copy_content);
                    if (mAIRecords.getMStatus() == 0) {
                        i2 = 0;
                    } else {
                        i2 = 4;
                    }
                    imageView.setVisibility(i2);
                    final AIChatActivity aIChatActivity3 = this.f21623oIX0oI;
                    imageView.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0081: INVOKE 
                          (r4v2 'imageView' android.widget.ImageView)
                          (wrap:android.view.View$OnClickListener:0x007e: CONSTRUCTOR 
                          (r5v4 'aIChatActivity3' com.sma.smartv3.ui.ai.AIChatActivity A[DONT_INLINE])
                          (r6v7 'mContent' java.lang.String A[DONT_INLINE])
                         A[MD:(com.sma.smartv3.ui.ai.AIChatActivity, java.lang.String):void (m), WRAPPED] (LINE:127) call: com.sma.smartv3.ui.ai.II0XooXoX.<init>(com.sma.smartv3.ui.ai.AIChatActivity, java.lang.String):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:130) in method: com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.II0xO0.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.ai.II0XooXoX, state: NOT_LOADED
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
                        java.lang.String r6 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r6)
                        java.lang.String r6 = "mAIRecords"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r6)
                        r6 = 2131363660(0x7f0a074c, float:1.8347135E38)
                        android.view.View r6 = r4.getView(r6)
                        android.widget.TextView r6 = (android.widget.TextView) r6
                        com.sma.smartv3.ui.ai.AIChatActivity r0 = r3.f21623oIX0oI
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r6)
                        long r1 = r5.getMTime()
                        r0.isShowTime(r6, r1)
                        java.lang.String r6 = r5.getMContent()
                        com.sma.smartv3.ui.ai.AIChatActivity r0 = r3.f21623oIX0oI
                        int r1 = r6.length()
                        if (r1 != 0) goto L37
                        r6 = 2132022131(0x7f141373, float:1.9682673E38)
                        java.lang.String r6 = r0.getString(r6)
                        java.lang.String r0 = "getString(...)"
                        kotlin.jvm.internal.IIX0o.oO(r6, r0)
                    L37:
                        r0 = 2131368439(0x7f0a19f7, float:1.8356828E38)
                        android.view.View r0 = r4.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        r0.setText(r6)
                        com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1 r1 = r3.f21622II0xO0
                        android.content.Context r1 = com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.m281access$getMContext$p$s1623866647(r1)
                        r2 = 2131101801(0x7f060869, float:1.7816022E38)
                        int r1 = oIxOXo.oxoX.I0Io(r1, r2)
                        android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
                        r0.setBackgroundTintList(r1)
                        r0 = 2131368440(0x7f0a19f8, float:1.835683E38)
                        android.view.View r0 = r4.getView(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        r1 = 8
                        r0.setVisibility(r1)
                        r0 = 2131364711(0x7f0a0b67, float:1.8349267E38)
                        android.view.View r4 = r4.getView(r0)
                        android.widget.ImageView r4 = (android.widget.ImageView) r4
                        int r5 = r5.getMStatus()
                        if (r5 != 0) goto L76
                        r5 = 0
                        goto L77
                    L76:
                        r5 = 4
                    L77:
                        r4.setVisibility(r5)
                        com.sma.smartv3.ui.ai.AIChatActivity r5 = r3.f21623oIX0oI
                        com.sma.smartv3.ui.ai.II0XooXoX r0 = new com.sma.smartv3.ui.ai.II0XooXoX
                        r0.<init>(r5, r6)
                        r4.setOnClickListener(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.II0xO0.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void");
                }
            }

            /* loaded from: classes12.dex */
            public static final class X0o0xo implements xoXoI<AIRecords> {
                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_ai_chat_question_tip;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AIRecords aIRecords, int i) {
                    if (aIRecords == null || aIRecords.getMType() != 6) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AIRecords mAIRecords, int i) {
                    IIX0o.x0xO0oo(holder, "holder");
                    IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements xoXoI<AIRecords> {

                /* renamed from: II0xO0, reason: collision with root package name */
                public final /* synthetic */ AIChatActivity$initAdapter$1 f21624II0xO0;

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ AIChatActivity f21625oIX0oI;

                public oIX0oI(AIChatActivity aIChatActivity, AIChatActivity$initAdapter$1 aIChatActivity$initAdapter$1) {
                    this.f21625oIX0oI = aIChatActivity;
                    this.f21624II0xO0 = aIChatActivity$initAdapter$1;
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_ai_chat_send;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AIRecords aIRecords, int i) {
                    if (aIRecords == null || aIRecords.getMType() != 1) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AIRecords mAIRecords, int i) {
                    IIX0o.x0xO0oo(holder, "holder");
                    IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                    TextView textView = (TextView) holder.getView(R.id.chat_send_time);
                    AIChatActivity aIChatActivity = this.f21625oIX0oI;
                    IIX0o.ooOOo0oXI(textView);
                    aIChatActivity.isShowTime(textView, mAIRecords.getMTime());
                    TextView textView2 = (TextView) holder.getView(R.id.tv_send_content);
                    textView2.setText(mAIRecords.getMContent());
                    textView2.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(((MultiItemTypeAdapter) this.f21624II0xO0).mContext, R.color.voice_send_bg_color)));
                    ImageViewRound imageViewRound = (ImageViewRound) holder.getView(R.id.iv_send_picture);
                    imageViewRound.setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(this.f21625oIX0oI, R.drawable.icon_voice_default_icon));
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
                        imageViewRound.setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
                    }
                }
            }

            /* loaded from: classes12.dex */
            public static final class oxoX implements xoXoI<AIRecords> {

                /* renamed from: II0xO0, reason: collision with root package name */
                public final /* synthetic */ AIChatActivity f21626II0xO0;

                public oxoX(AIChatActivity aIChatActivity) {
                    this.f21626II0xO0 = aIChatActivity;
                }

                public static final void XO(AIChatActivity this$0, TextView textView, View view) {
                    IIX0o.x0xO0oo(this$0, "this$0");
                    this$0.addQuestion(textView.getText().toString());
                }

                @Override // oo.xoXoI
                public int II0xO0() {
                    return R.layout.item_ai_chat_receive_welcome_more;
                }

                @Override // oo.xoXoI
                /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                public boolean oIX0oI(@OXOo.oOoXoXO AIRecords aIRecords, int i) {
                    if (aIRecords == null || aIRecords.getMType() != 5) {
                        return false;
                    }
                    return true;
                }

                @Override // oo.xoXoI
                /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo AIRecords mAIRecords, int i) {
                    IIX0o.x0xO0oo(holder, "holder");
                    IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
                    final TextView textView = (TextView) holder.getView(R.id.welcome_tv);
                    textView.setText(mAIRecords.getMContent());
                    textView.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(((MultiItemTypeAdapter) AIChatActivity$initAdapter$1.this).mContext, R.color.voice_receive_bg_color)));
                    final AIChatActivity aIChatActivity = this.f21626II0xO0;
                    textView.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INVOKE 
                          (r1v2 'textView' android.widget.TextView)
                          (wrap:android.view.View$OnClickListener:0x0032: CONSTRUCTOR 
                          (r2v6 'aIChatActivity' com.sma.smartv3.ui.ai.AIChatActivity A[DONT_INLINE])
                          (r1v2 'textView' android.widget.TextView A[DONT_INLINE])
                         A[MD:(com.sma.smartv3.ui.ai.AIChatActivity, android.widget.TextView):void (m), WRAPPED] (LINE:51) call: com.sma.smartv3.ui.ai.xxIXOIIO.<init>(com.sma.smartv3.ui.ai.AIChatActivity, android.widget.TextView):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:54) in method: com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.oxoX.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.ai.xxIXOIIO, state: NOT_LOADED
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
                        java.lang.String r3 = "holder"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r3)
                        java.lang.String r3 = "mAIRecords"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r3)
                        r3 = 2131371949(0x7f0a27ad, float:1.8363947E38)
                        android.view.View r1 = r1.getView(r3)
                        android.widget.TextView r1 = (android.widget.TextView) r1
                        java.lang.String r2 = r2.getMContent()
                        r1.setText(r2)
                        com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1 r2 = com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.this
                        android.content.Context r2 = com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.m281access$getMContext$p$s1623866647(r2)
                        r3 = 2131101801(0x7f060869, float:1.7816022E38)
                        int r2 = oIxOXo.oxoX.I0Io(r2, r3)
                        android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
                        r1.setBackgroundTintList(r2)
                        com.sma.smartv3.ui.ai.AIChatActivity r2 = r0.f21626II0xO0
                        com.sma.smartv3.ui.ai.xxIXOIIO r3 = new com.sma.smartv3.ui.ai.xxIXOIIO
                        r3.<init>(r2, r1)
                        r1.setOnClickListener(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.ai.AIChatActivity$initAdapter$1.oxoX.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.db.entity.AIRecords, int):void");
                }
            }

            {
                addItemViewDelegate(1, new oIX0oI(this, this));
                addItemViewDelegate(2, new II0xO0(this, this));
                addItemViewDelegate(4, new I0Io());
                addItemViewDelegate(5, new oxoX(this));
                addItemViewDelegate(6, new X0o0xo());
            }
        };
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView mRecyclerView = getMRecyclerView();
        MultiItemTypeAdapter<AIRecords> multiItemTypeAdapter = this.mAdapter;
        if (multiItemTypeAdapter == null) {
            IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        mRecyclerView.setAdapter(multiItemTypeAdapter);
    }

    private final void initialRecorder() {
        this.mBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
        this.mAudioRecord = new AudioRecord(1, 16000, 16, 2, this.mBufferSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void longClickDown$lambda$1(AIChatActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (!this$0.isRecording && this$0.longPressStartTime != 0 && System.currentTimeMillis() - this$0.longPressStartTime > this$0.longPressThreshold) {
            if (PermissionUtils.isGranted(PermissionConstants.MICROPHONE)) {
                this$0.startRecording();
            } else {
                this$0.permission();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTitleRightClick$lambda$6(AIChatActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onSetModel();
        PopupWindow popupWindow = this$0.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTitleRightClick$lambda$7(AIChatActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showDeleteTipPopup();
        PopupWindow popupWindow = this$0.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollView() {
        RecyclerView.ItemAnimator itemAnimator = getMRecyclerView().getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        this.lastScrollTime = System.currentTimeMillis();
        if (this.mRecyclerViewAutoRefresh) {
            getMRecyclerView().scrollToPosition(CollectionsKt__CollectionsKt.oo0xXOI0I(getMList()));
        }
    }

    private final void setTitle(String str) {
        switch (str.hashCode()) {
            case -1671190941:
                if (str.equals("openAIService")) {
                    TextView textView = (TextView) findViewById(R.id.abh_title_center);
                    if (textView != null) {
                        textView.setText(getString(R.string.chatgpt));
                    }
                    String string = getString(R.string.ai_welcome_gpt);
                    IIX0o.oO(string, "getString(...)");
                    addWelcomeQuestions(string);
                    return;
                }
                break;
            case -361646967:
                if (str.equals("deepseekAIService")) {
                    TextView textView2 = (TextView) findViewById(R.id.abh_title_center);
                    if (textView2 != null) {
                        textView2.setText(getString(R.string.pay_dail_aigc_deep_seek));
                    }
                    String string2 = getString(R.string.ai_welcome_gpt);
                    IIX0o.oO(string2, "getString(...)");
                    addWelcomeQuestions(string2);
                    return;
                }
                break;
            case -345876046:
                if (str.equals("baiduAIService")) {
                    TextView textView3 = (TextView) findViewById(R.id.abh_title_center);
                    if (textView3 != null) {
                        textView3.setText(getString(R.string.wenxinyiyan));
                    }
                    String string3 = getString(R.string.ai_welcome);
                    IIX0o.oO(string3, "getString(...)");
                    addWelcomeQuestions(string3);
                    return;
                }
                break;
            case 1088442160:
                if (str.equals("sparkAIService")) {
                    TextView textView4 = (TextView) findViewById(R.id.abh_title_center);
                    if (textView4 != null) {
                        textView4.setText(getString(R.string.ai_model_spark_desk));
                    }
                    String string4 = getString(R.string.ai_welcome_spark_desk);
                    IIX0o.oO(string4, "getString(...)");
                    addWelcomeQuestions(string4);
                    return;
                }
                break;
        }
        if (str.length() > 0) {
            TextView textView5 = (TextView) findViewById(R.id.abh_title_center);
            if (textView5 != null) {
                textView5.setText(str);
            }
            String string5 = getString(R.string.ai_welcome_gpt);
            IIX0o.oO(string5, "getString(...)");
            addWelcomeQuestions(string5);
        }
    }

    private final void startRecording() {
        if (!this.isRecording) {
            this.isRecording = true;
            showRecordingPopup();
            initialRecorder();
            xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new AIChatActivity$startRecording$1(this), 30, null);
        }
    }

    private final void stopRecording() {
        if (this.isRecording) {
            this.isRecording = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$2(AIChatActivity this$0, View view, MotionEvent motionEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                boolean z = false;
                if (action != 2) {
                    return false;
                }
                if (this$0.downY - motionEvent.getY() > 100.0f) {
                    z = true;
                }
                this$0.recordingIsClear = z;
                XIXIX xixix = this$0.mRecordingPopup;
                if (xixix == null) {
                    return true;
                }
                xixix.XIxXXX0x0(z);
                return true;
            }
            this$0.mHandler.removeCallbacksAndMessages(null);
            if (this$0.isRecording) {
                this$0.stopRecording();
            }
            this$0.longPressStartTime = 0L;
            return true;
        }
        this$0.downY = motionEvent.getY();
        this$0.longPressStartTime = System.currentTimeMillis();
        this$0.longClickDown();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$3(AIChatActivity this$0, View view, MotionEvent motionEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (motionEvent.getAction() == 2) {
            this$0.mRecyclerViewAutoRefresh = false;
        }
        return false;
    }

    public final void addListWelcome() {
        AIFunctionType aIFunctionType;
        int i;
        AIFunction mAIFunction = getMAIFunction();
        if (mAIFunction != null) {
            aIFunctionType = mAIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        if (aIFunctionType == null) {
            i = -1;
        } else {
            i = oIX0oI.f21628oIX0oI[aIFunctionType.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (productManager.xox().length() > 0) {
                    setTitle(productManager.xox());
                } else {
                    setTitle(AIManager.x0XOIxOo(AIManager.f19833oIX0oI, 0, 1, null));
                }
                String string = getString(R.string.ai_welcome_aichat_1);
                IIX0o.oO(string, "getString(...)");
                addMoveQuestions(string);
                String string2 = getString(R.string.ai_welcome_aichat_2);
                IIX0o.oO(string2, "getString(...)");
                addMoveQuestions(string2);
                String string3 = getString(R.string.ai_welcome_aichat_3);
                IIX0o.oO(string3, "getString(...)");
                addMoveQuestions(string3);
                return;
            }
            String string4 = getString(R.string.ai_welcome_personal_trainer);
            IIX0o.oO(string4, "getString(...)");
            addWelcomeQuestions(string4);
            String string5 = getString(R.string.ai_welcome_personal_trainer_1);
            IIX0o.oO(string5, "getString(...)");
            addMoveQuestions(string5);
            String string6 = getString(R.string.ai_welcome_personal_trainer_2);
            IIX0o.oO(string6, "getString(...)");
            addMoveQuestions(string6);
            String string7 = getString(R.string.ai_welcome_personal_trainer_3);
            IIX0o.oO(string7, "getString(...)");
            addMoveQuestions(string7);
            return;
        }
        String string8 = getString(R.string.ai_welcome_health_qa);
        IIX0o.oO(string8, "getString(...)");
        addWelcomeQuestions(string8);
        String string9 = getString(R.string.ai_welcome_health_qa_1);
        IIX0o.oO(string9, "getString(...)");
        addMoveQuestions(string9);
        String string10 = getString(R.string.ai_welcome_health_qa_2);
        IIX0o.oO(string10, "getString(...)");
        addMoveQuestions(string10);
        String string11 = getString(R.string.ai_welcome_health_qa_3);
        IIX0o.oO(string11, "getString(...)");
        addMoveQuestions(string11);
    }

    public final void addMoveQuestions(@OXOo.OOXIXo String content) {
        int i;
        IIX0o.x0xO0oo(content, "content");
        AIFunction mAIFunction = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction);
        int type = mAIFunction.getType().getType();
        if (content.length() == 0) {
            i = 4;
        } else {
            i = 5;
        }
        getMList().add(new AIRecords(0, 0L, null, type, i, content, null, 0, 0, 0, null, null, null, null, null, 0, null, 130887, null));
    }

    public final void addWelcomeQuestions(@OXOo.OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        AIFunction mAIFunction = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction);
        getMList().add(new AIRecords(0, 0L, null, mAIFunction.getType().getType(), 2, content, null, 1, 0, 0, null, null, null, null, null, 0, null, 130887, null));
        addMoveQuestions$default(this, null, 1, null);
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity
    public void changeAiModel() {
        showOpenAiDeduction();
    }

    public final void disRecordingPopup() {
        XIXIX xixix = this.mRecordingPopup;
        if (xixix != null) {
            xixix.dismiss();
        }
    }

    public final float getDownY() {
        return this.downY;
    }

    public final boolean getInputMethod() {
        return this.inputMethod;
    }

    public final long getLastScrollTime() {
        return this.lastScrollTime;
    }

    public final int getMBufferSize() {
        return this.mBufferSize;
    }

    @OXOo.OOXIXo
    public final Handler getMHandler() {
        return this.mHandler;
    }

    @OXOo.OOXIXo
    public final List<AIRecords> getMList() {
        List<AIRecords> list = this.mList;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("mList");
        return null;
    }

    @OXOo.oOoXoXO
    public final PopupWindow getMPopupWindow() {
        return this.mPopupWindow;
    }

    public final boolean getMRecyclerViewAutoRefresh() {
        return this.mRecyclerViewAutoRefresh;
    }

    @OXOo.OOXIXo
    public final String getMTipContent() {
        return this.mTipContent;
    }

    @OXOo.oOoXoXO
    public final AIRecords getReceived() {
        return this.received;
    }

    public final boolean getRecordingIsClear() {
        return this.recordingIsClear;
    }

    public final long getShowChatTime() {
        return this.showChatTime;
    }

    @OXOo.OOXIXo
    public final List<AIRecords> initList() {
        AIFunctionType aIFunctionType;
        AIRecordsDao mRecordsDao = getMRecordsDao();
        AIFunction mAIFunction = getMAIFunction();
        if (mAIFunction != null) {
            aIFunctionType = mAIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        IIX0o.ooOOo0oXI(aIFunctionType);
        setMList(CollectionsKt___CollectionsKt.o0Xo0XII(mRecordsDao.getListASC(aIFunctionType.getType())));
        addListWelcome();
        return getMList();
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        if (AIManager.f19833oIX0oI.XxX0x0xxx()) {
            getAbhTitleOtherRight().setVisibility(0);
        } else {
            getAbhTitleOtherRight().setVisibility(8);
        }
        getAbhTitleOtherRight().setImageResource(R.drawable.ai_answer_speech_icon);
        getAbhTitleOtherRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getAbhTitleRight().setVisibility(0);
        if (ProductManager.f20544oIX0oI.xXo()) {
            getAbhTitleRight().setImageResource(R.drawable.ai_answer_more_icon);
        } else {
            getAbhTitleRight().setImageResource(R.drawable.ai_answer_clean_icon);
        }
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        permission();
        initList();
        initAdapter();
        scrollView();
        touchListener();
    }

    public final void isShowTime(@OXOo.OOXIXo TextView tvTime, long j) {
        int i;
        IIX0o.x0xO0oo(tvTime, "tvTime");
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

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_chat;
    }

    public final void longClickDown() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.ai.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                AIChatActivity.longClickDown$lambda$1(AIChatActivity.this);
            }
        }, this.longPressThreshold + 100);
    }

    public final void onSend(@OXOo.OOXIXo View view) {
        String str;
        IIX0o.x0xO0oo(view, "view");
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
        addQuestion(str);
    }

    public final void onSwitchInputMethod(@OXOo.OOXIXo View view) {
        int i;
        IIX0o.x0xO0oo(view, "view");
        this.inputMethod = !this.inputMethod;
        ImageView ivChatVoice = getIvChatVoice();
        if (this.inputMethod) {
            getMChatContent().setVisibility(8);
            getBtnChatSend().setVisibility(8);
            getBtnAudio().setVisibility(0);
            i = R.drawable.icon_chat_textbox;
        } else {
            getMChatContent().setVisibility(0);
            getBtnChatSend().setVisibility(0);
            getBtnAudio().setVisibility(8);
            i = R.drawable.icon_chat_audio;
        }
        ivChatVoice.setImageResource(i);
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (ProductManager.f20544oIX0oI.xXo()) {
            Object systemService = getSystemService("layout_inflater");
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.popup_chat_layout, (ViewGroup) null);
            IIX0o.oO(inflate, "inflate(...)");
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow == null) {
                this.mPopupWindow = new PopupWindow(inflate, -2, -2);
            } else if (popupWindow != null) {
                popupWindow.dismiss();
            }
            PopupWindow popupWindow2 = this.mPopupWindow;
            if (popupWindow2 != null) {
                popupWindow2.setFocusable(true);
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int width = i + (i - view.getWidth()) + oI00o.II0xO0.II0xO0(this, 20.0f);
            int height = iArr[1] + view.getHeight();
            PopupWindow popupWindow3 = this.mPopupWindow;
            if (popupWindow3 != null) {
                popupWindow3.showAtLocation(view, 0, width, height);
            }
            inflate.findViewById(R.id.popup_switch_ai_model).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.ai.XO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AIChatActivity.onTitleRightClick$lambda$6(AIChatActivity.this, view2);
                }
            });
            inflate.findViewById(R.id.popup_clear_chats).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.ai.Oxx0IOOO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AIChatActivity.onTitleRightClick$lambda$7(AIChatActivity.this, view2);
                }
            });
            return;
        }
        showDeleteTipPopup();
    }

    public final void onTitleRightOtherClick(@OXOo.OOXIXo View view) {
        int i;
        IIX0o.x0xO0oo(view, "view");
        setPlayResult(!isPlayResult());
        ImageView abhTitleOtherRight = getAbhTitleOtherRight();
        if (isPlayResult()) {
            i = R.drawable.ai_answer_speech_icon;
        } else {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24646oxxXoxO, null, 2, null);
            i = R.drawable.ai_answer_speech_close_icon;
        }
        abhTitleOtherRight.setImageResource(i);
    }

    public final void permission() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.MICROPHONE);
        IIX0o.oO(permission, "permission(...)");
        String string = getString(R.string.microphone_explain_title);
        IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.microphone_explain_content);
        IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$permission$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                PermissionStatus permissionStatus = PermissionStatus.GRANTED;
            }
        });
    }

    public final void questionAssistant(@OXOo.OOXIXo final String content) {
        IIX0o.x0xO0oo(content, "content");
        this.mTipContent = content;
        String string = getString(R.string.ai_question_more, content);
        IIX0o.oO(string, "getString(...)");
        AIFunction mAIFunction = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction);
        send(new AIQuestion(mAIFunction.getType(), string, null, null, false, 28, null), new BaseAIActivity.oIX0oI<AIAnswer>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$questionAssistant$1
            @Override // com.sma.smartv3.ui.ai.BaseAIActivity.oIX0oI
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public void oIX0oI(@OXOo.OOXIXo AIAnswer result) {
                IIX0o.x0xO0oo(result, "result");
                if (result.getText().length() > 0 && result.getEnded() == 1) {
                    String text = result.getText();
                    MultiItemTypeAdapter multiItemTypeAdapter = null;
                    if (OxI.IOOoXo0Ix(text, "```json", false, 2, null) && StringsKt__StringsKt.o00xOoIO(text, "[", false, 2, null) && StringsKt__StringsKt.o00xOoIO(text, "]", false, 2, null)) {
                        String substring = text.substring(StringsKt__StringsKt.O0O0Io00X(text, "[", 0, false, 6, null), StringsKt__StringsKt.O0O0Io00X(text, "]", 0, false, 6, null) + 1);
                        IIX0o.oO(substring, "substring(...)");
                        JSONArray jSONArray = new JSONArray(substring);
                        int length = jSONArray.length();
                        String[] strArr = new String[length];
                        int length2 = jSONArray.length();
                        for (int i = 0; i < length2; i++) {
                            strArr[i] = jSONArray.getString(i);
                        }
                        kotlin.collections.OxI.xOoOIoI(AIChatActivity.this.getMList(), new Oox.oOoXoXO<AIRecords, Boolean>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$questionAssistant$1$response$1
                            @Override // Oox.oOoXoXO
                            @OXOo.OOXIXo
                            public final Boolean invoke(@OXOo.OOXIXo AIRecords it) {
                                IIX0o.x0xO0oo(it, "it");
                                return Boolean.valueOf((it.getMType() == 1 || it.getMType() == 2) ? false : true);
                            }
                        });
                        List<AIRecords> mList = AIChatActivity.this.getMList();
                        AIFunction mAIFunction2 = AIChatActivity.this.getMAIFunction();
                        IIX0o.ooOOo0oXI(mAIFunction2);
                        mList.add(new AIRecords(0, 0L, null, mAIFunction2.getType().getType(), 6, content, null, 0, 0, 0, null, null, null, null, null, 0, null, 130887, null));
                        AIChatActivity.addMoveQuestions$default(AIChatActivity.this, null, 1, null);
                        AIChatActivity aIChatActivity = AIChatActivity.this;
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            String str = strArr[i2];
                            IIX0o.ooOOo0oXI(str);
                            aIChatActivity.addMoveQuestions(str);
                            arrayList.add(oXIO0o0XI.f29392oIX0oI);
                        }
                        MultiItemTypeAdapter multiItemTypeAdapter2 = AIChatActivity.this.mAdapter;
                        if (multiItemTypeAdapter2 == null) {
                            IIX0o.XOxIOxOx("mAdapter");
                        } else {
                            multiItemTypeAdapter = multiItemTypeAdapter2;
                        }
                        multiItemTypeAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override // com.sma.smartv3.ui.ai.BaseAIActivity.oIX0oI
            public void error(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }
        }, false, false, false);
    }

    public final void recognition() {
        showLoading(true);
        try {
            new Runner(new FileInputStream(com.sma.smartv3.initializer.IXxxXO.o0(X00IoxXI.oIX0oI.f3233oIX0oI)), 1).run(new II0xO0());
        } catch (IOException unused) {
            dismissLoading();
        }
    }

    public final void sendCurrent(@OXOo.OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        this.mRecyclerViewAutoRefresh = true;
        scrollView();
        AIFunction mAIFunction = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction);
        BaseAIActivity.send$default(this, new AIQuestion(mAIFunction.getType(), content, null, null, false, 28, null), new I0Io(), false, false, false, 28, null);
    }

    public final void setDownY(float f) {
        this.downY = f;
    }

    public final void setInputMethod(boolean z) {
        this.inputMethod = z;
    }

    public final void setLastScrollTime(long j) {
        this.lastScrollTime = j;
    }

    public final void setMBufferSize(int i) {
        this.mBufferSize = i;
    }

    public final void setMList(@OXOo.OOXIXo List<AIRecords> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mList = list;
    }

    public final void setMPopupWindow(@OXOo.oOoXoXO PopupWindow popupWindow) {
        this.mPopupWindow = popupWindow;
    }

    public final void setMRecyclerViewAutoRefresh(boolean z) {
        this.mRecyclerViewAutoRefresh = z;
    }

    public final void setMTipContent(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTipContent = str;
    }

    public final void setReceived(@OXOo.oOoXoXO AIRecords aIRecords) {
        this.received = aIRecords;
    }

    public final void setRecordingIsClear(boolean z) {
        this.recordingIsClear = z;
    }

    public final void setShowChatTime(long j) {
        this.showChatTime = j;
    }

    public final void share(@OXOo.OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        startActivity(IntentUtils.getShareTextIntent(content));
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity
    public void showAIDeductionPoints() {
        showOpenAiDeduction();
    }

    public final void showDeleteTipPopup() {
        if (this.mAllDeleteTipPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.clear_ai_chat_list));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$showDeleteTipPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.AIChatActivity$showDeleteTipPopup$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    List<AIRecords> mList = AIChatActivity.this.getMList();
                    if (mList != null) {
                        for (AIRecords aIRecords : mList) {
                            aIRecords.setMIsDelete(1);
                            aIRecords.setMIsSync(0);
                        }
                    }
                    AIChatActivity.this.getMRecordsDao().update(AIChatActivity.this.getMList());
                    AIChatActivity.this.getMList().clear();
                    AIChatActivity.this.addListWelcome();
                    MultiItemTypeAdapter multiItemTypeAdapter = AIChatActivity.this.mAdapter;
                    if (multiItemTypeAdapter == null) {
                        IIX0o.XOxIOxOx("mAdapter");
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
        XoI0Ixx0 xoI0Ixx02 = this.mAllDeleteTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    public final void showOpenAiDeduction() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIChatActivity showOpenAiDeduction openAIDeductionPoints = " + getOpenAIDeductionPoints());
        getTvOpenAiDeduction().setVisibility(8);
    }

    public final void showRecordingPopup() {
        if (this.mRecordingPopup == null) {
            XIXIX xixix = new XIXIX(this, 0, 2, null);
            xixix.XIxXXX0x0(this.recordingIsClear);
            this.mRecordingPopup = xixix;
        }
        XIXIX xixix2 = this.mRecordingPopup;
        if (xixix2 != null) {
            xixix2.IIXOooo();
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24618Xo0)
    public final void switchAIServe(@OXOo.OOXIXo Object data) {
        AIFunctionType aIFunctionType;
        IIX0o.x0xO0oo(data, "data");
        AIFunction mAIFunction = getMAIFunction();
        if (mAIFunction != null) {
            aIFunctionType = mAIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        if (aIFunctionType == AIFunctionType.AI) {
            initView();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void touchListener() {
        getBtnAudio().setOnTouchListener(new View.OnTouchListener() { // from class: com.sma.smartv3.ui.ai.I0Io
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = AIChatActivity.touchListener$lambda$2(AIChatActivity.this, view, motionEvent);
                return z;
            }
        });
        getMRecyclerView().setOnTouchListener(new View.OnTouchListener() { // from class: com.sma.smartv3.ui.ai.oxoX
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = AIChatActivity.touchListener$lambda$3(AIChatActivity.this, view, motionEvent);
                return z;
            }
        });
    }
}
