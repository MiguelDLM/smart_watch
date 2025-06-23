package com.sma.smartv3.ui.device.dial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.baidu.mobads.sdk.internal.an;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.JobDetail;
import com.sma.smartv3.model.JobDetailV2;
import com.sma.smartv3.model.JobInfo;
import com.sma.smartv3.model.JobV2Extra;
import com.sma.smartv3.network.AICreateJobV2;
import com.sma.smartv3.network.AigcCreateJob;
import com.sma.smartv3.network.AigcFindJob;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.BleInfo;
import com.sma.smartv3.network.GetAIChat;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.AbhSettingsItem;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.Languages;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.jvm.internal.XX({"SMAP\nAIGCFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIGCFragment.kt\ncom/sma/smartv3/ui/device/dial/AIGCFragment\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,718:1\n151#2,11:719\n171#2:738\n218#2,12:739\n240#2:769\n151#2,11:770\n171#2:789\n208#3,7:730\n226#3:737\n285#3,18:751\n208#3,7:781\n226#3:788\n11065#4:790\n11400#4,3:791\n35#5,2:794\n35#5,2:800\n19#5:802\n15#5:803\n19#5:804\n15#5:805\n1549#6:796\n1620#6,3:797\n*S KotlinDebug\n*F\n+ 1 AIGCFragment.kt\ncom/sma/smartv3/ui/device/dial/AIGCFragment\n*L\n218#1:719,11\n218#1:738\n281#1:739,12\n281#1:769\n349#1:770,11\n349#1:789\n218#1:730,7\n218#1:737\n281#1:751,18\n349#1:781,7\n349#1:788\n533#1:790\n533#1:791,3\n532#1:794,2\n545#1:800,2\n647#1:802\n647#1:803\n660#1:804\n660#1:805\n546#1:796\n546#1:797,3\n*E\n"})
/* loaded from: classes12.dex */
public class AIGCFragment extends BaseFragment {

    @OXOo.OOXIXo
    private String bgFile;
    private int findJobNumber;
    private int mCurStyle;
    private String mJobId;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPayTipPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoO0xx0 mStyleSetPopup;

    @OXOo.oOoXoXO
    private String[] picUrls;

    @OXOo.oOoXoXO
    private List<Bitmap> picUrlsBitmap;

    @OXOo.OOXIXo
    private final String TAG = "AIGC";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO genPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$genPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return mView.findViewById(R.id.gen_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$etContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return (EditText) mView.findViewById(R.id.edt_content);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO previewPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$previewPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return mView.findViewById(R.id.preview_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemStyle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$itemStyle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return (AbhSettingsItem) mView.findViewById(R.id.item_style);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnSearch$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$btnSearch$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return mView.findViewById(R.id.btn_search);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnGen$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$btnGen$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return mView.findViewById(R.id.btn_gen);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnNextStep$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$btnNextStep$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return mView.findViewById(R.id.btn_gen_next_step);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnAgain$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$btnAgain$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return mView.findViewById(R.id.btn_again);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = AIGCFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.rv);
        }
    });

    public AIGCFragment() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        this.mJobId = xo0.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24425XX0xXo);
        this.mCurStyle = xo0.XO().getInt(com.sma.smartv3.util.XoI0Ixx0.f24439o0xxxXXxX, 0);
        this.bgFile = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoadPopup() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.dial.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                AIGCFragment.dismissLoadPopup$lambda$13(AIGCFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissLoadPopup$lambda$13(AIGCFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    private final View getBtnGen() {
        return (View) this.btnGen$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(AIGCFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
        this$0.onSetStyle(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AIGCFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (!ProductManager.f20544oIX0oI.XOx()) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
            this$0.onSearch(view);
        } else {
            ToastUtils.showLong(R.string.parameter_check_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(AIGCFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
        this$0.onGen(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3(AIGCFragment this$0, View view, int i, KeyEvent keyEvent) {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4 || (i0X0x0oIo = this$0.mLoadingPopup) == null || !i0X0x0oIo.isShowing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(AIGCFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
        this$0.onAgain(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(AIGCFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onNextStep();
    }

    private final void showLoadPopup() {
        if (this.mLoadingPopup == null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(requireActivity);
            String string = getString(R.string.working_generate_tip);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            i0X0x0oIo.IIX0o(string);
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null && i0X0x0oIo2.isShowing()) {
            return;
        }
        if (ProductManager.f20544oIX0oI.XOx()) {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (!projectManager.IxIo() && projectManager.XooIO0oo0()) {
                return;
            }
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = this.mLoadingPopup;
        if (i0X0x0oIo3 != null) {
            i0X0x0oIo3.IIXOooo();
        }
    }

    public static /* synthetic */ void showPayTipPopup$default(AIGCFragment aIGCFragment, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = R.string.points_insufficient_tip;
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            aIGCFragment.showPayTipPopup(i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPayTipPopup");
    }

    public final void AIGC_AIChat(@OXOo.OOXIXo final AIQuestion question, @OXOo.OOXIXo final String style) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(question, "question");
        kotlin.jvm.internal.IIX0o.x0xO0oo(style, "style");
        question.setStream(true);
        question.setModel("baiduAIService");
        question.setText(AIManager.f19833oIX0oI.XI0IXoo(question.getText()));
        final StringBuilder sb = new StringBuilder();
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String json = new Gson().toJson(question);
        Map<String, String> headersMap = getHeadersMap();
        xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$AIGC_AIChat$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                String str;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb2 = new StringBuilder();
                str = AIGCFragment.this.TAG;
                sb2.append(str);
                sb2.append(" AIChat -> error:");
                sb2.append(error);
                oix0oi.oIX0oI(sb2.toString());
                AIGCFragment.this.createJobV2(question.getText(), style);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                String str2;
                String str3;
                String str4;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb2 = new StringBuilder();
                str2 = AIGCFragment.this.TAG;
                sb2.append(str2);
                sb2.append(" AIChat line -> ");
                sb2.append(str);
                oix0oi.oIX0oI(sb2.toString());
                try {
                    Object fromJson = new Gson().fromJson(str, TypeToken.getParameterized(Response.class, AIAnswer.class));
                    kotlin.jvm.internal.IIX0o.x0XOIxOo(fromJson, "null cannot be cast to non-null type com.sma.androidnetworklib.model.Response<com.sma.smartv3.model.AIAnswer>");
                    Response response = (Response) fromJson;
                    if (response.getData() == null) {
                        AIGCFragment.this.createJobV2(question.getText(), style);
                    } else {
                        AIAnswer aIAnswer = (AIAnswer) response.getData();
                        if (aIAnswer != null) {
                            StringBuilder sb3 = sb;
                            AIGCFragment aIGCFragment = AIGCFragment.this;
                            String str5 = style;
                            sb3.append(aIAnswer.getText());
                            if (aIAnswer.getEnded() == 1) {
                                StringBuilder sb4 = new StringBuilder();
                                str4 = aIGCFragment.TAG;
                                sb4.append(str4);
                                sb4.append(" AIGC_AIChat -> answer.toString() = ");
                                sb4.append((Object) sb3);
                                oix0oi.oIX0oI(sb4.toString());
                                String sb5 = sb3.toString();
                                kotlin.jvm.internal.IIX0o.oO(sb5, "toString(...)");
                                aIGCFragment.createJobV2(sb5, str5);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                    StringBuilder sb6 = new StringBuilder();
                    str3 = AIGCFragment.this.TAG;
                    sb6.append(str3);
                    sb6.append(" AIChat -> error: empty  e = ");
                    sb6.append(e);
                    oix0oi2.oIX0oI(sb6.toString());
                    AIGCFragment.this.createJobV2(question.getText(), style);
                }
            }
        };
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(json);
        netWorkUtils.postStreamRequest(GetAIChat.URL, headersMap, json, iI0xO0);
    }

    public final boolean containsChineseCharacter(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
        Pattern compile = Pattern.compile("[\\u4E00-\\u9FA5]+");
        kotlin.jvm.internal.IIX0o.oO(compile, "compile(...)");
        Matcher matcher = compile.matcher(str);
        kotlin.jvm.internal.IIX0o.oO(matcher, "matcher(...)");
        return matcher.find();
    }

    public final void createJob(@OXOo.OOXIXo String query, @OXOo.OOXIXo String style) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(query, "query");
        kotlin.jvm.internal.IIX0o.x0xO0oo(style, "style");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.oO0OX0()) {
            generateAIGC(query);
            return;
        }
        int X0o0xo2 = productManager.X0o0xo();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " createJob -> " + query + ", " + style + ", " + X0o0xo2);
        StatManager.f20200oIX0oI.II0xO0(1);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> aigcCreateJobBody = RequestBodyKt.aigcCreateJobBody(query, style, X0o0xo2);
        final xxxI.II0xO0<JobInfo> iI0xO0 = new xxxI.II0xO0<JobInfo>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$createJob$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                LogUtils.d("createJob -> error = " + error);
                AIGCFragment.this.dismissLoadPopup();
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO JobInfo jobInfo) {
                LogUtils.d("createJob -> " + jobInfo);
                if (jobInfo != null) {
                    AIGCFragment.this.setMJobId(jobInfo.getJobId());
                    if (!TextUtils.isEmpty(AIGCFragment.this.getMJobId())) {
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24425XX0xXo, AIGCFragment.this.getMJobId());
                        AIGCFragment.this.setFindJobNumber(0);
                        AIGCFragment aIGCFragment = AIGCFragment.this;
                        String mJobId = aIGCFragment.getMJobId();
                        kotlin.jvm.internal.IIX0o.oO(mJobId, "<get-mJobId>(...)");
                        aIGCFragment.findJob(mJobId);
                        return;
                    }
                    LogUtils.d("createJob -> error: jobId = null ");
                    AIGCFragment.this.dismissLoadPopup();
                    ToastUtils.showLong("error: jobId = null", new Object[0]);
                }
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AigcCreateJob.URL);
        netWorkUtils.printParam(convertBaseUrl + AigcCreateJob.URL, aigcCreateJobBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AigcCreateJob.URL;
        final xxxI.II0xO0<Response<JobInfo>> iI0xO02 = new xxxI.II0xO0<Response<JobInfo>>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$createJob$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<JobInfo> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) aigcCreateJobBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, JobInfo.class), new ParsedRequestListener<Response<JobInfo>>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$createJob$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<JobInfo> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void createJobV2(@OXOo.OOXIXo String query, @OXOo.OOXIXo String style) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(query, "query");
        kotlin.jvm.internal.IIX0o.x0xO0oo(style, "style");
        if (ProductManager.f20544oIX0oI.oO0OX0()) {
            generateAIGC(query);
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " createJobV2 -> " + query + ", " + style);
        final Activity activity = null;
        String xoIox2 = AIManager.xoIox(AIManager.f19833oIX0oI, 0, 1, null);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, Object> aigcCreateJobBodyV2 = RequestBodyKt.aigcCreateJobBodyV2(query, xoIox2, new JobV2Extra(style, "1"));
        final xxxI.II0xO0<JobDetailV2> iI0xO0 = new xxxI.II0xO0<JobDetailV2>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$createJobV2$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("createJobV2 -> error = " + error);
                AIGCFragment.this.dismissLoadPopup();
                AIGCFragment.this.errorEvent(error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO JobDetailV2 jobDetailV2) {
                boolean z;
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("createJobV2 -> " + jobDetailV2);
                if (jobDetailV2 != null) {
                    if (jobDetailV2.getImages().length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        AIGCFragment.this.showPics(jobDetailV2.getImages(), jobDetailV2.getImageSign());
                        return;
                    }
                    LogUtils.d("createJobV2 -> error: jobId = null ");
                    AIGCFragment.this.dismissLoadPopup();
                    ToastUtils.showLong("createJobV2 error: jobId = null", new Object[0]);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AICreateJobV2.URL);
        netWorkUtils.printParam(convertBaseUrl + AICreateJobV2.URL, kotlin.collections.o0.xoIxX(aigcCreateJobBodyV2, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AICreateJobV2.URL;
        final xxxI.II0xO0<Response<JobDetailV2>> iI0xO02 = new xxxI.II0xO0<Response<JobDetailV2>>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$createJobV2$$inlined$postJsonV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<JobDetailV2> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addApplicationJsonBody(aigcCreateJobBodyV2).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, JobDetailV2.class), new ParsedRequestListener<Response<JobDetailV2>>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$createJobV2$$inlined$postJsonV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<JobDetailV2> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    public final void errorEvent(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        if (StringsKt__StringsKt.o00xOoIO(error, "4006", false, 2, null)) {
            showPayTipPopup$default(this, R.string.points_insufficient_tip, false, 2, null);
            return;
        }
        if (StringsKt__StringsKt.o00xOoIO(error, "5001", false, 2, null)) {
            showPayTipPopup$default(this, R.string.ai_benefit_buy_tip, false, 2, null);
            return;
        }
        if (StringsKt__StringsKt.o00xOoIO(error, "5002", false, 2, null)) {
            showPayTipPopup$default(this, R.string.ai_benefit_expired_tip, false, 2, null);
        } else if (StringsKt__StringsKt.o00xOoIO(error, "2004", false, 2, null)) {
            showPayTipPopup(R.string.login_user_tip_error, true);
        } else {
            ToastUtils.showLong(error, new Object[0]);
        }
    }

    public final void findJob(@OXOo.OOXIXo String jobId) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jobId, "jobId");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " findJob -> " + jobId);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> aigcFindJobBody = RequestBodyKt.aigcFindJobBody(jobId);
        final AIGCFragment$findJob$1 aIGCFragment$findJob$1 = new AIGCFragment$findJob$1(this);
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AigcFindJob.URL);
        netWorkUtils.printParam(convertBaseUrl + AigcFindJob.URL, aigcFindJobBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AigcFindJob.URL;
        final xxxI.II0xO0<Response<JobDetail>> iI0xO0 = new xxxI.II0xO0<Response<JobDetail>>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$findJob$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, aIGCFragment$findJob$1, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<JobDetail> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO02 = aIGCFragment$findJob$1;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO02);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) aigcFindJobBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, JobDetail.class), new ParsedRequestListener<Response<JobDetail>>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$findJob$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<JobDetail> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void generateAIGC(@OXOo.OOXIXo String query) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(query, "query");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " SparkChain generateAIGC -> " + query);
        AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
        if (!aISparkChainManager.oOoXoXO()) {
            ToastUtils.showLong(R.string.spark_exist_fail);
            dismissLoadPopup();
        } else {
            aISparkChainManager.oxoX(query, new AIGCFragment$generateAIGC$1(this));
        }
    }

    @OXOo.OOXIXo
    public final String getBgFile() {
        return this.bgFile;
    }

    public final View getBtnAgain() {
        return (View) this.btnAgain$delegate.getValue();
    }

    public final View getBtnNextStep() {
        return (View) this.btnNextStep$delegate.getValue();
    }

    public final View getBtnSearch() {
        return (View) this.btnSearch$delegate.getValue();
    }

    public final EditText getEtContent() {
        return (EditText) this.etContent$delegate.getValue();
    }

    public final int getFindJobNumber() {
        return this.findJobNumber;
    }

    public final View getGenPanel() {
        return (View) this.genPanel$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final Map<String, String> getHeadersMap() {
        Gson gson = new Gson();
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        String mFirmwareFlag = bleCache.getMFirmwareFlag();
        String string$default = BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        String appVersionName = AppUtils.getAppVersionName();
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        String identity = ((AppUser) appUser).getIdentity();
        String IIOIX2 = kotlin.text.OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(appVersionName);
        String json = gson.toJson(new BleInfo(identity, mBleName, mFirmwareFlag, "2", string$default, appVersionName, IIOIX2, 0));
        HashMap hashMap = new HashMap();
        hashMap.put("accept-language", Languages.DEFAULT_LANGUAGE_ZH);
        SPUtils XO3 = xo0.XO();
        Object appUser2 = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson2 = new Gson().fromJson(XO3.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson2 != null) {
            appUser2 = fromJson2;
        }
        hashMap.put("APP-UID", ((AppUser) appUser2).getIdentity());
        hashMap.put("BleInfo", json);
        return hashMap;
    }

    public final AbhSettingsItem getItemStyle() {
        return (AbhSettingsItem) this.itemStyle$delegate.getValue();
    }

    public final int getMCurStyle() {
        return this.mCurStyle;
    }

    public final String getMJobId() {
        return this.mJobId;
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.I0X0x0oIo getMLoadingPopup() {
        return this.mLoadingPopup;
    }

    public final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.xoO0xx0 getMStyleSetPopup() {
        return this.mStyleSetPopup;
    }

    @OXOo.oOoXoXO
    public final String[] getPicUrls() {
        return this.picUrls;
    }

    @OXOo.oOoXoXO
    public final List<Bitmap> getPicUrlsBitmap() {
        return this.picUrlsBitmap;
    }

    public final View getPreviewPanel() {
        return (View) this.previewPanel$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        AbhSettingsItem itemStyle = getItemStyle();
        String str = getResources().getStringArray(R.array.aigc_styles)[this.mCurStyle];
        kotlin.jvm.internal.IIX0o.oO(str, "get(...)");
        itemStyle.setMRightText(str);
        getItemStyle().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCFragment.initView$lambda$0(AIGCFragment.this, view);
            }
        });
        AbhSettingsItem itemStyle2 = getItemStyle();
        if (ProductManager.f20544oIX0oI.OOIXx0x()) {
            i = 0;
        } else {
            i = 8;
        }
        itemStyle2.setVisibility(i);
        getBtnSearch().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCFragment.initView$lambda$1(AIGCFragment.this, view);
            }
        });
        getBtnGen().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCFragment.initView$lambda$2(AIGCFragment.this, view);
            }
        });
        getBtnGen().setOnKeyListener(new View.OnKeyListener() { // from class: com.sma.smartv3.ui.device.dial.X0o0xo
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                boolean initView$lambda$3;
                initView$lambda$3 = AIGCFragment.initView$lambda$3(AIGCFragment.this, view, i2, keyEvent);
                return initView$lambda$3;
            }
        });
        getBtnAgain().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCFragment.initView$lambda$4(AIGCFragment.this, view);
            }
        });
        getBtnNextStep().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCFragment.initView$lambda$5(AIGCFragment.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_aigc;
    }

    public final void onAgain(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        getGenPanel().setVisibility(0);
        getPreviewPanel().setVisibility(8);
        getBtnGen().setFocusableInTouchMode(true);
        getBtnGen().requestFocus();
    }

    public final void onGen(@OXOo.OOXIXo View view) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Editable text = getEtContent().getText();
        if (text != null) {
            str = text.toString();
        } else {
            str = null;
        }
        String str2 = str;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XOx()) {
            showLoadPopup();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
            if (containsChineseCharacter(str2)) {
                createJobV2(str2, com.sma.smartv3.biz.Oxx0IOOO.oIX0oI().get(this.mCurStyle));
                return;
            } else {
                AIGC_AIChat(new AIQuestion(AIFunctionType.AI, str2, null, null, false, 28, null), com.sma.smartv3.biz.Oxx0IOOO.oIX0oI().get(this.mCurStyle));
                return;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (productManager.OOIXx0x()) {
                showLoadPopup();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
                createJob(str2, com.sma.smartv3.biz.Oxx0IOOO.oIX0oI().get(this.mCurStyle));
            } else if (TextUtils.isEmpty(productManager.I0Io())) {
                KeyboardUtils.hideSoftInput(getMActivity());
                UtilsKt.XOxIOxOx(getMActivity());
                return;
            } else {
                showLoadPopup();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
                openAiImagesGen(str2);
            }
            getBtnGen().setFocusableInTouchMode(true);
            getBtnGen().requestFocus();
        }
    }

    public final void onNextStep() {
        if (this.picUrls != null) {
            SPUtils oxoX2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX();
            String[] strArr = this.picUrls;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(strArr);
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(new File(com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI), UtilsKt.x0XOIxOo(str)).getPath());
            }
            String path = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI).getPath();
            kotlin.jvm.internal.IIX0o.oO(path, "getPath(...)");
            oxoX2.put(path, new Gson().toJson(arrayList));
            ProductManager productManager = ProductManager.f20544oIX0oI;
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
            Bundle bundle = new Bundle();
            bundle.putString("bgFile", this.bgFile);
            kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
            productManager.oO0(requireActivity, bundle);
        }
        if (this.picUrlsBitmap != null) {
            SPUtils oxoX3 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX();
            List<Bitmap> list = this.picUrlsBitmap;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
            List<Bitmap> list2 = list;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
            for (Bitmap bitmap : list2) {
                arrayList2.add(new File(com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI), "aigc_kdxf.png").getPath());
            }
            String path2 = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI).getPath();
            kotlin.jvm.internal.IIX0o.oO(path2, "getPath(...)");
            oxoX3.put(path2, new Gson().toJson(arrayList2));
            ProductManager productManager2 = ProductManager.f20544oIX0oI;
            FragmentActivity requireActivity2 = requireActivity();
            kotlin.jvm.internal.IIX0o.oO(requireActivity2, "requireActivity(...)");
            Bundle bundle2 = new Bundle();
            bundle2.putString("bgFile", this.bgFile);
            kotlin.oXIO0o0XI oxio0o0xi2 = kotlin.oXIO0o0XI.f29392oIX0oI;
            productManager2.oO0(requireActivity2, bundle2);
        }
    }

    public final void onSearch(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showLoadPopup();
        this.findJobNumber = 0;
        String str = this.mJobId;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
        findJob(str);
    }

    public final void onSetStyle(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mStyleSetPopup == null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
            com.sma.smartv3.pop.xoO0xx0 xoo0xx0 = new com.sma.smartv3.pop.xoO0xx0(requireActivity, R.array.aigc_styles);
            xoo0xx0.oo0xXOI0I(R.string.style);
            xoo0xx0.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$onSetStyle$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    AIGCFragment.this.setMCurStyle(i);
                    AbhSettingsItem itemStyle = AIGCFragment.this.getItemStyle();
                    String str = AIGCFragment.this.getResources().getStringArray(R.array.aigc_styles)[AIGCFragment.this.getMCurStyle()];
                    kotlin.jvm.internal.IIX0o.oO(str, "get(...)");
                    itemStyle.setMRightText(str);
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24439o0xxxXXxX, AIGCFragment.this.getMCurStyle());
                    return Boolean.TRUE;
                }
            });
            this.mStyleSetPopup = xoo0xx0;
        }
        com.sma.smartv3.pop.xoO0xx0 xoo0xx02 = this.mStyleSetPopup;
        if (xoo0xx02 != null) {
            xoo0xx02.IoOoX(this.mCurStyle);
            xoo0xx02.IIXOooo();
        }
    }

    public final void openAiImagesGen(@OXOo.OOXIXo String query) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(query, "query");
        LogUtils.d(this.TAG + " openAiImagesGen -> " + query);
        ANRequest.PostRequestBuilder addHeaders = AndroidNetworking.post("https://api.openai.com/v1/images/generations").setContentType(an.d).addHeaders("Authorization", "Bearer " + ProductManager.f20544oIX0oI.I0Io());
        byte[] bytes = ("{    \"prompt\": \"" + query + "\",    \"n\": 4,    \"size\": \"512x512\"\n  }").getBytes(kotlin.text.oxoX.f29581II0xO0);
        kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
        addHeaders.addByteBody(bytes).setPriority(Priority.LOW).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$openAiImagesGen$1
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append("onError -> error = ");
                String str2 = null;
                if (aNError != null) {
                    str = aNError.getErrorBody();
                } else {
                    str = null;
                }
                sb.append(str);
                LogUtils.d(sb.toString());
                AIGCFragment.this.dismissLoadPopup();
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                }
                ToastUtils.showLong(str2, new Object[0]);
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                LogUtils.d("onResponse -> " + jSONObject);
                if (jSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        if (jSONArray != null) {
                            AIGCFragment aIGCFragment = AIGCFragment.this;
                            ArrayList arrayList = new ArrayList();
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                String string = jSONArray.getJSONObject(i).getString("url");
                                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                                arrayList.add(string);
                            }
                            aIGCFragment.showPics((String[]) arrayList.toArray(new String[0]), "");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public final void setBgFile(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.bgFile = str;
    }

    public final void setFindJobNumber(int i) {
        this.findJobNumber = i;
    }

    public final void setMCurStyle(int i) {
        this.mCurStyle = i;
    }

    public final void setMJobId(String str) {
        this.mJobId = str;
    }

    public final void setMLoadingPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo) {
        this.mLoadingPopup = i0X0x0oIo;
    }

    public final void setMStyleSetPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.xoO0xx0 xoo0xx0) {
        this.mStyleSetPopup = xoo0xx0;
    }

    public final void setPicUrls(@OXOo.oOoXoXO String[] strArr) {
        this.picUrls = strArr;
    }

    public final void setPicUrlsBitmap(@OXOo.oOoXoXO List<Bitmap> list) {
        this.picUrlsBitmap = list;
    }

    public final void showPayTipPopup(int i, final boolean z) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (this.mPayTipPopup == null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
            final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(requireActivity, 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.tip);
            xoI0Ixx02.xI(Integer.valueOf(i));
            xoI0Ixx02.oo0xXOI0I(1);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$showPayTipPopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    if (z) {
                        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                        SPUtils XO2 = xo0.XO();
                        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                        if (fromJson != null) {
                            appUser = fromJson;
                        }
                        xo0.oxoX().put(AppUser.class.getName(), new Gson().toJson((AppUser) appUser));
                        ProjectManager.f19822oIX0oI.OooO0XOx(xoI0Ixx02.Oxx0IOOO());
                    } else {
                        AIGCFragment aIGCFragment = this;
                        String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
                        Bundle bundle = new Bundle();
                        bundle.putString("mArg0", IIX0o2);
                        bundle.putInt("mArg1", 2);
                        bundle.putParcelable("mArg2", null);
                        bundle.putSerializable("mArg3", null);
                        Intent intent = new Intent(aIGCFragment.getActivity(), (Class<?>) GoogleWebViewActivity.class);
                        intent.putExtras(bundle);
                        aIGCFragment.startActivity(intent);
                    }
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

    public final void showPics(@OXOo.OOXIXo final String[] urls, @OXOo.OOXIXo final String imageSign) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(urls, "urls");
        kotlin.jvm.internal.IIX0o.x0xO0oo(imageSign, "imageSign");
        int i = 1;
        if (urls.length > 1) {
            i = 2;
        }
        if (urls.length == 0) {
            dismissLoadPopup();
            ToastUtils.showLong(R.string.request_error);
            return;
        }
        final Activity mActivity = getMActivity();
        final List X0XOOO = ArraysKt___ArraysKt.X0XOOO(urls);
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(mActivity, X0XOOO) { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$showPics$adapter$1

            @kotlin.jvm.internal.XX({"SMAP\nAIGCFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIGCFragment.kt\ncom/sma/smartv3/ui/device/dial/AIGCFragment$showPics$adapter$1$convert$1$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,718:1\n11065#2:719\n11400#2,3:720\n35#3,2:723\n*S KotlinDebug\n*F\n+ 1 AIGCFragment.kt\ncom/sma/smartv3/ui/device/dial/AIGCFragment$showPics$adapter$1$convert$1$2\n*L\n442#1:719\n442#1:720,3\n441#1:723,2\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class oIX0oI extends SimpleTarget<Bitmap> {

                /* renamed from: IXxxXO, reason: collision with root package name */
                public final /* synthetic */ int f22138IXxxXO;

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ String f22139Oo;

                /* renamed from: Oxx0xo, reason: collision with root package name */
                public final /* synthetic */ String[] f22140Oxx0xo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ ImageView f22141XO;

                /* renamed from: oI0IIXIo, reason: collision with root package name */
                public final /* synthetic */ AIGCFragment f22142oI0IIXIo;

                public oIX0oI(ImageView imageView, String str, int i, String[] strArr, AIGCFragment aIGCFragment) {
                    this.f22141XO = imageView;
                    this.f22139Oo = str;
                    this.f22138IXxxXO = i;
                    this.f22140Oxx0xo = strArr;
                    this.f22142oI0IIXIo = aIGCFragment;
                }

                public static final void II0xO0(String[] urls, File picFile, AIGCFragment this$0, View view) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(urls, "$urls");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(picFile, "$picFile");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    SPUtils oxoX2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX();
                    ArrayList arrayList = new ArrayList(urls.length);
                    for (String str : urls) {
                        arrayList.add(new File(com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI), UtilsKt.x0XOIxOo(str)).getPath());
                    }
                    String path = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI).getPath();
                    kotlin.jvm.internal.IIX0o.oO(path, "getPath(...)");
                    oxoX2.put(path, new Gson().toJson(arrayList));
                    LogUtils.d("confirm -> " + picFile);
                    ProductManager productManager = ProductManager.f20544oIX0oI;
                    FragmentActivity requireActivity = this$0.requireActivity();
                    kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
                    Bundle bundle = new Bundle();
                    bundle.putString("bgFile", picFile.getPath());
                    kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                    productManager.oO0(requireActivity, bundle);
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
                    String[] strArr;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(resource, "resource");
                    this.f22141XO.setImageBitmap(resource);
                    final File file = new File(com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI), UtilsKt.x0XOIxOo(this.f22139Oo));
                    ImageUtils.save(resource, file, Bitmap.CompressFormat.JPEG);
                    if (this.f22138IXxxXO == 0 && (strArr = this.f22140Oxx0xo) != null && strArr.length > 0) {
                        this.f22142oI0IIXIo.setPicUrls(strArr);
                        AIGCFragment aIGCFragment = this.f22142oI0IIXIo;
                        String path = file.getPath();
                        kotlin.jvm.internal.IIX0o.oO(path, "getPath(...)");
                        aIGCFragment.setBgFile(path);
                    }
                    ImageView imageView = this.f22141XO;
                    final String[] strArr2 = this.f22140Oxx0xo;
                    final AIGCFragment aIGCFragment2 = this.f22142oI0IIXIo;
                    imageView.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: INVOKE 
                          (r4v2 'imageView' android.widget.ImageView)
                          (wrap:android.view.View$OnClickListener:0x0046: CONSTRUCTOR 
                          (r5v6 'strArr2' java.lang.String[] A[DONT_INLINE])
                          (r0v0 'file' java.io.File A[DONT_INLINE])
                          (r1v2 'aIGCFragment2' com.sma.smartv3.ui.device.dial.AIGCFragment A[DONT_INLINE])
                         A[MD:(java.lang.String[], java.io.File, com.sma.smartv3.ui.device.dial.AIGCFragment):void (m), WRAPPED] call: com.sma.smartv3.ui.device.dial.xoIox.<init>(java.lang.String[], java.io.File, com.sma.smartv3.ui.device.dial.AIGCFragment):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.dial.AIGCFragment$showPics$adapter$1.oIX0oI.onResourceReady(android.graphics.Bitmap, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.dial.xoIox, state: NOT_LOADED
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
                        java.lang.String r5 = "resource"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                        android.widget.ImageView r5 = r3.f22141XO
                        r5.setImageBitmap(r4)
                        java.lang.String r5 = r3.f22139Oo
                        java.lang.String r5 = com.sma.smartv3.util.UtilsKt.x0XOIxOo(r5)
                        java.io.File r0 = new java.io.File
                        X00IoxXI.oIX0oI r1 = X00IoxXI.oIX0oI.f3233oIX0oI
                        java.io.File r1 = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(r1)
                        r0.<init>(r1, r5)
                        android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG
                        com.blankj.utilcode.util.ImageUtils.save(r4, r0, r5)
                        int r4 = r3.f22138IXxxXO
                        if (r4 != 0) goto L3e
                        java.lang.String[] r4 = r3.f22140Oxx0xo
                        if (r4 == 0) goto L3e
                        int r5 = r4.length
                        if (r5 <= 0) goto L3e
                        com.sma.smartv3.ui.device.dial.AIGCFragment r5 = r3.f22142oI0IIXIo
                        r5.setPicUrls(r4)
                        com.sma.smartv3.ui.device.dial.AIGCFragment r4 = r3.f22142oI0IIXIo
                        java.lang.String r5 = r0.getPath()
                        java.lang.String r1 = "getPath(...)"
                        kotlin.jvm.internal.IIX0o.oO(r5, r1)
                        r4.setBgFile(r5)
                    L3e:
                        android.widget.ImageView r4 = r3.f22141XO
                        java.lang.String[] r5 = r3.f22140Oxx0xo
                        com.sma.smartv3.ui.device.dial.AIGCFragment r1 = r3.f22142oI0IIXIo
                        com.sma.smartv3.ui.device.dial.xoIox r2 = new com.sma.smartv3.ui.device.dial.xoIox
                        r2.<init>(r5, r0, r1)
                        r4.setOnClickListener(r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.dial.AIGCFragment$showPics$adapter$1.oIX0oI.onResourceReady(android.graphics.Bitmap, com.bumptech.glide.request.transition.Transition):void");
                }
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            @SuppressLint({"CheckResult"})
            public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo String url, int i2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
                View view = holder.getView(R.id.iv);
                String str = imageSign;
                String[] strArr = urls;
                AIGCFragment aIGCFragment = this;
                ImageView imageView = (ImageView) view;
                RequestBuilder<Bitmap> asBitmap = Glide.with(imageView).asBitmap();
                if (TextUtils.isEmpty(str)) {
                    asBitmap.load(url);
                } else {
                    if (!ProductManager.f20544oIX0oI.XOx()) {
                        str = "Bearer " + str;
                    }
                    asBitmap.load((Object) new GlideUrl(url, new LazyHeaders.Builder().addHeader("Authorization", str).build()));
                }
                asBitmap.into((RequestBuilder<Bitmap>) new oIX0oI(imageView, url, i2, strArr, aIGCFragment));
            }
        };
        getMRecyclerView().setLayoutManager(new GridLayoutManager(getMActivity(), i));
        getMRecyclerView().setAdapter(commonAdapter);
        getGenPanel().setVisibility(8);
        getPreviewPanel().setVisibility(0);
        dismissLoadPopup();
    }

    public final void showPicsSparkChain(@OXOo.OOXIXo final List<Bitmap> urls) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(urls, "urls");
        if (urls.isEmpty()) {
            dismissLoadPopup();
            ToastUtils.showLong(R.string.request_error);
            return;
        }
        final Activity mActivity = getMActivity();
        CommonAdapter<Bitmap> commonAdapter = new CommonAdapter<Bitmap>(urls, this, mActivity) { // from class: com.sma.smartv3.ui.device.dial.AIGCFragment$showPicsSparkChain$adapter$1
            final /* synthetic */ List<Bitmap> $urls;
            final /* synthetic */ AIGCFragment this$0;

            @kotlin.jvm.internal.XX({"SMAP\nAIGCFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIGCFragment.kt\ncom/sma/smartv3/ui/device/dial/AIGCFragment$showPicsSparkChain$adapter$1$convert$1$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,718:1\n1549#2:719\n1620#2,3:720\n35#3,2:723\n*S KotlinDebug\n*F\n+ 1 AIGCFragment.kt\ncom/sma/smartv3/ui/device/dial/AIGCFragment$showPicsSparkChain$adapter$1$convert$1$2\n*L\n505#1:719\n505#1:720,3\n504#1:723,2\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class oIX0oI extends SimpleTarget<Bitmap> {

                /* renamed from: IXxxXO, reason: collision with root package name */
                public final /* synthetic */ List<Bitmap> f22143IXxxXO;

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ int f22144Oo;

                /* renamed from: Oxx0xo, reason: collision with root package name */
                public final /* synthetic */ AIGCFragment f22145Oxx0xo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ ImageView f22146XO;

                public oIX0oI(ImageView imageView, int i, List<Bitmap> list, AIGCFragment aIGCFragment) {
                    this.f22146XO = imageView;
                    this.f22144Oo = i;
                    this.f22143IXxxXO = list;
                    this.f22145Oxx0xo = aIGCFragment;
                }

                public static final void II0xO0(List urls, File picFile, AIGCFragment this$0, String fileName, View view) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(urls, "$urls");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(picFile, "$picFile");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(fileName, "$fileName");
                    SPUtils oxoX2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX();
                    List<Bitmap> list = urls;
                    ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                    for (Bitmap bitmap : list) {
                        arrayList.add(new File(com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI), fileName).getPath());
                    }
                    String path = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI).getPath();
                    kotlin.jvm.internal.IIX0o.oO(path, "getPath(...)");
                    oxoX2.put(path, new Gson().toJson(arrayList));
                    LogUtils.d("confirm -> " + picFile);
                    ProductManager productManager = ProductManager.f20544oIX0oI;
                    FragmentActivity requireActivity = this$0.requireActivity();
                    kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
                    Bundle bundle = new Bundle();
                    bundle.putString("bgFile", picFile.getPath());
                    kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                    productManager.oO0(requireActivity, bundle);
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
                    List<Bitmap> list;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(resource, "resource");
                    this.f22146XO.setImageBitmap(resource);
                    final String str = "aigc_kdxf.png";
                    final File file = new File(com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI), "aigc_kdxf.png");
                    ImageUtils.save(resource, file, Bitmap.CompressFormat.JPEG);
                    if (this.f22144Oo == 0 && (list = this.f22143IXxxXO) != null && list.size() > 0) {
                        this.f22145Oxx0xo.setPicUrlsBitmap(this.f22143IXxxXO);
                        AIGCFragment aIGCFragment = this.f22145Oxx0xo;
                        String path = file.getPath();
                        kotlin.jvm.internal.IIX0o.oO(path, "getPath(...)");
                        aIGCFragment.setBgFile(path);
                    }
                    ImageView imageView = this.f22146XO;
                    final List<Bitmap> list2 = this.f22143IXxxXO;
                    final AIGCFragment aIGCFragment2 = this.f22145Oxx0xo;
                    imageView.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: INVOKE 
                          (r5v2 'imageView' android.widget.ImageView)
                          (wrap:android.view.View$OnClickListener:0x0047: CONSTRUCTOR 
                          (r0v3 'list2' java.util.List<android.graphics.Bitmap> A[DONT_INLINE])
                          (r6v3 'file' java.io.File A[DONT_INLINE])
                          (r2v0 'aIGCFragment2' com.sma.smartv3.ui.device.dial.AIGCFragment A[DONT_INLINE])
                          (r1v0 'str' java.lang.String A[DONT_INLINE])
                         A[MD:(java.util.List, java.io.File, com.sma.smartv3.ui.device.dial.AIGCFragment, java.lang.String):void (m), WRAPPED] call: com.sma.smartv3.ui.device.dial.OOXIXo.<init>(java.util.List, java.io.File, com.sma.smartv3.ui.device.dial.AIGCFragment, java.lang.String):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.dial.AIGCFragment$showPicsSparkChain$adapter$1.oIX0oI.onResourceReady(android.graphics.Bitmap, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>):void, file: classes12.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.dial.OOXIXo, state: NOT_LOADED
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
                        java.lang.String r6 = "resource"
                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r6)
                        android.widget.ImageView r6 = r4.f22146XO
                        r6.setImageBitmap(r5)
                        java.io.File r6 = new java.io.File
                        X00IoxXI.oIX0oI r0 = X00IoxXI.oIX0oI.f3233oIX0oI
                        java.io.File r0 = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(r0)
                        java.lang.String r1 = "aigc_kdxf.png"
                        r6.<init>(r0, r1)
                        android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
                        com.blankj.utilcode.util.ImageUtils.save(r5, r6, r0)
                        int r5 = r4.f22144Oo
                        if (r5 != 0) goto L3f
                        java.util.List<android.graphics.Bitmap> r5 = r4.f22143IXxxXO
                        if (r5 == 0) goto L3f
                        int r5 = r5.size()
                        if (r5 <= 0) goto L3f
                        com.sma.smartv3.ui.device.dial.AIGCFragment r5 = r4.f22145Oxx0xo
                        java.util.List<android.graphics.Bitmap> r0 = r4.f22143IXxxXO
                        r5.setPicUrlsBitmap(r0)
                        com.sma.smartv3.ui.device.dial.AIGCFragment r5 = r4.f22145Oxx0xo
                        java.lang.String r0 = r6.getPath()
                        java.lang.String r2 = "getPath(...)"
                        kotlin.jvm.internal.IIX0o.oO(r0, r2)
                        r5.setBgFile(r0)
                    L3f:
                        android.widget.ImageView r5 = r4.f22146XO
                        java.util.List<android.graphics.Bitmap> r0 = r4.f22143IXxxXO
                        com.sma.smartv3.ui.device.dial.AIGCFragment r2 = r4.f22145Oxx0xo
                        com.sma.smartv3.ui.device.dial.OOXIXo r3 = new com.sma.smartv3.ui.device.dial.OOXIXo
                        r3.<init>(r0, r6, r2, r1)
                        r5.setOnClickListener(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.dial.AIGCFragment$showPicsSparkChain$adapter$1.oIX0oI.onResourceReady(android.graphics.Bitmap, com.bumptech.glide.request.transition.Transition):void");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(mActivity, R.layout.item_aigc_img, urls);
                this.$urls = urls;
                this.this$0 = this;
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            @SuppressLint({"CheckResult"})
            public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo Bitmap url, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
                View view = holder.getView(R.id.iv);
                List<Bitmap> list = this.$urls;
                AIGCFragment aIGCFragment = this.this$0;
                ImageView imageView = (ImageView) view;
                RequestBuilder<Bitmap> asBitmap = Glide.with(imageView).asBitmap();
                asBitmap.load(url);
                asBitmap.into((RequestBuilder<Bitmap>) new oIX0oI(imageView, i, list, aIGCFragment));
            }
        };
        getMRecyclerView().setLayoutManager(new GridLayoutManager(getMActivity(), 1));
        getMRecyclerView().setAdapter(commonAdapter);
        getGenPanel().setVisibility(8);
        getPreviewPanel().setVisibility(0);
        dismissLoadPopup();
    }
}
