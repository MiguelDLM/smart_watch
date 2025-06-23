package com.sma.smartv3.ui.ai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.model.DeductionConfig;
import com.sma.smartv3.model.EvaluationKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.pop.oOXoIIIo;
import com.sma.smartv3.pop.xxOXOOoIX;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.Xo0;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public abstract class BaseAIActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private oIX0oI<AIAnswer> mAIAnswerCallback;

    @OXOo.oOoXoXO
    private AIFunction mAIFunction;

    @OXOo.oOoXoXO
    private oOXoIIIo mEvaluationPopup;

    @OXOo.oOoXoXO
    private I0X0x0oIo mLoadingPopup;

    @OXOo.oOoXoXO
    private xxOXOOoIX mModleSetPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mPayTipPopup;

    @OXOo.oOoXoXO
    private AIRecords mReceivedRecords;
    private int openAIDeductionPoints;
    private boolean isPlayResult = true;

    @OXOo.OOXIXo
    private final AIRecordsDao mRecordsDao = MyDb.INSTANCE.getMDatabase().aiRecordsDao();

    /* loaded from: classes12.dex */
    public interface oIX0oI<T> {
        void error(@OXOo.OOXIXo String str);

        void oIX0oI(T t);
    }

    public static final void dismissLoading$lambda$3(BaseAIActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    private final void getDeductionConfig() {
        OrderManager.f20130oIX0oI.xoIox(new Oox.oOoXoXO<DeductionConfig, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.BaseAIActivity$getDeductionConfig$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DeductionConfig deductionConfig) {
                invoke2(deductionConfig);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO DeductionConfig deductionConfig) {
                if (deductionConfig != null) {
                    BaseAIActivity.this.setOpenAIDeductionPoints(deductionConfig.getOpenAI_ImgPoints());
                    BaseAIActivity.this.showAIDeductionPoints();
                }
            }
        });
    }

    public static /* synthetic */ void send$default(BaseAIActivity baseAIActivity, AIQuestion aIQuestion, oIX0oI oix0oi, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        if (obj == null) {
            if ((i & 2) != 0) {
                oix0oi = null;
            }
            oIX0oI oix0oi2 = oix0oi;
            if ((i & 4) != 0) {
                z = baseAIActivity.isPlayResult;
            }
            boolean z6 = z;
            if ((i & 8) != 0) {
                z4 = true;
            } else {
                z4 = z2;
            }
            if ((i & 16) != 0) {
                z5 = true;
            } else {
                z5 = z3;
            }
            baseAIActivity.send(aIQuestion, oix0oi2, z6, z4, z5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
    }

    public static /* synthetic */ void showLoading$default(BaseAIActivity baseAIActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseAIActivity.showLoading(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
    }

    public static final void showLoading$lambda$2(BaseAIActivity this$0, boolean z) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.mLoadingPopup == null) {
            I0X0x0oIo i0X0x0oIo = new I0X0x0oIo(this$0.getMContext());
            if (z) {
                i0X0x0oIo.xxX(Integer.valueOf(R.string.generating));
            }
            this$0.mLoadingPopup = i0X0x0oIo;
        }
        I0X0x0oIo i0X0x0oIo2 = this$0.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
    }

    public static /* synthetic */ void showPayTipPopup$default(BaseAIActivity baseAIActivity, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = R.string.points_insufficient_tip;
            }
            baseAIActivity.showPayTipPopup(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPayTipPopup");
    }

    @OXOo.OOXIXo
    public final AIRecords addReceivedRecord() {
        AIFunction aIFunction = this.mAIFunction;
        IIX0o.ooOOo0oXI(aIFunction);
        return addReceivedRecord(new AIRecords(0, 0L, null, aIFunction.getType().getType(), 2, null, null, 1, 0, 0, null, null, null, null, null, 0, null, 130919, null));
    }

    public final void addSendRecord(@OXOo.OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        AIFunction aIFunction = this.mAIFunction;
        IIX0o.ooOOo0oXI(aIFunction);
        addSendRecord(new AIRecords(0, 0L, null, aIFunction.getType().getType(), 1, text, null, 0, 0, 0, null, null, null, null, null, 0, null, 131015, null));
    }

    public void changeAiModel() {
    }

    public final void dismissLoading() {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.ai.oO
            @Override // java.lang.Runnable
            public final void run() {
                BaseAIActivity.dismissLoading$lambda$3(BaseAIActivity.this);
            }
        });
    }

    @OXOo.oOoXoXO
    public final AIFunction getMAIFunction() {
        return this.mAIFunction;
    }

    @OXOo.oOoXoXO
    public final I0X0x0oIo getMLoadingPopup() {
        return this.mLoadingPopup;
    }

    @OXOo.oOoXoXO
    public final AIRecords getMReceivedRecords() {
        return this.mReceivedRecords;
    }

    @OXOo.OOXIXo
    public final AIRecordsDao getMRecordsDao() {
        return this.mRecordsDao;
    }

    public final int getOpenAIDeductionPoints() {
        return this.openAIDeductionPoints;
    }

    public void init(@OXOo.oOoXoXO Bundle bundle) {
        LogUtils.d("intent -> " + getMArg3());
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.AIFunction");
        this.mAIFunction = (AIFunction) mArg3;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public void initView() {
        TextView textView;
        getDeductionConfig();
        AIFunction aIFunction = this.mAIFunction;
        if (aIFunction != null && (textView = (TextView) findViewById(R.id.abh_title_center)) != null) {
            textView.setText(aIFunction.getTitle());
        }
    }

    public final boolean isPlayResult() {
        return this.isPlayResult;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AIManager.f19833oIX0oI.XX();
    }

    public final void onSetModel() {
        if (this.mModleSetPopup == null) {
            xxOXOOoIX xxoxoooix = new xxOXOOoIX(this, R.array.ai_models, 0, 4, (IIXOooo) null);
            xxoxoooix.xI(R.string.pay_dail_aigc_modle);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.ai.BaseAIActivity$onSetModel$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24379O00XxXI, i);
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24618Xo0, null, 2, null);
                    BaseAIActivity.this.changeAiModel();
                    return Boolean.TRUE;
                }
            });
            this.mModleSetPopup = xxoxoooix;
        }
        xxOXOOoIX xxoxoooix2 = this.mModleSetPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(AIManager.oOoXoXO(AIManager.f19833oIX0oI, false, 1, null));
            xxoxoooix2.IIXOooo();
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24653xI0oxI00)
    public final void onShowEvaluationStatus(@OXOo.OOXIXo Object data) {
        oOXoIIIo ooxoiiio;
        IIX0o.x0xO0oo(data, "data");
        if (EvaluationKt.isShowEvaluationDialog() && ProjectManager.f19822oIX0oI.xIOXX()) {
            if (this.mEvaluationPopup == null) {
                this.mEvaluationPopup = new oOXoIIIo(this, 0, 2, null);
            }
            oOXoIIIo ooxoiiio2 = this.mEvaluationPopup;
            if ((ooxoiiio2 == null || !ooxoiiio2.isShowing()) && (ooxoiiio = this.mEvaluationPopup) != null) {
                ooxoiiio.IIXOooo();
            }
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void send(@OXOo.OOXIXo AIQuestion question, @OXOo.oOoXoXO oIX0oI<AIAnswer> oix0oi, boolean z, boolean z2, boolean z3) {
        IIX0o.x0xO0oo(question, "question");
        this.mAIAnswerCallback = oix0oi;
        AIManager.oo0xXOI0I(AIManager.f19833oIX0oI, question, new BaseAIActivity$send$1(z2, this), z, z3, 0, 0, 48, null);
    }

    public final void setMAIFunction(@OXOo.oOoXoXO AIFunction aIFunction) {
        this.mAIFunction = aIFunction;
    }

    public final void setMLoadingPopup(@OXOo.oOoXoXO I0X0x0oIo i0X0x0oIo) {
        this.mLoadingPopup = i0X0x0oIo;
    }

    public final void setMReceivedRecords(@OXOo.oOoXoXO AIRecords aIRecords) {
        this.mReceivedRecords = aIRecords;
    }

    public final void setOpenAIDeductionPoints(int i) {
        this.openAIDeductionPoints = i;
    }

    public final void setPlayResult(boolean z) {
        this.isPlayResult = z;
    }

    public void showAIDeductionPoints() {
    }

    public final void showLoading(final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.ai.x0xO0oo
            @Override // java.lang.Runnable
            public final void run() {
                BaseAIActivity.showLoading$lambda$2(BaseAIActivity.this, z);
            }
        });
    }

    public final void showPayTipPopup(int i) {
        XoI0Ixx0 xoI0Ixx0;
        if (this.mPayTipPopup == null) {
            XoI0Ixx0 xoI0Ixx02 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.tip);
            xoI0Ixx02.xI(Integer.valueOf(i));
            xoI0Ixx02.oo0xXOI0I(1);
            XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.BaseAIActivity$showPayTipPopup$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BaseAIActivity baseAIActivity = BaseAIActivity.this;
                    String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", IIX0o2);
                    bundle.putInt("mArg1", 2);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(baseAIActivity, (Class<?>) GoogleWebViewActivity.class);
                    intent.putExtras(bundle);
                    baseAIActivity.startActivity(intent);
                    return Boolean.TRUE;
                }
            });
            this.mPayTipPopup = xoI0Ixx02;
        }
        XoI0Ixx0 xoI0Ixx03 = this.mPayTipPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mPayTipPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24646oxxXoxO)
    public final void stopPlayer(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        AIManager.f19833oIX0oI.I0oOoX();
    }

    @OXOo.OOXIXo
    public final AIRecords addReceivedRecord(@OXOo.OOXIXo AIRecords mAIRecords) {
        IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
        AIRecords aIRecord = this.mRecordsDao.getAIRecord(this.mRecordsDao.insert(mAIRecords));
        this.mReceivedRecords = aIRecord;
        IIX0o.ooOOo0oXI(aIRecord);
        return aIRecord;
    }

    public final void addSendRecord(@OXOo.OOXIXo AIRecords mAIRecords) {
        IIX0o.x0xO0oo(mAIRecords, "mAIRecords");
        this.mRecordsDao.insert(mAIRecords);
    }
}
