package com.sma.smartv3.ui.ai;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.ui.ai.BaseAIActivity;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BaseAIActivity$send$1 implements xxxI.II0xO0<AIAnswer> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ BaseAIActivity f21633II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ boolean f21634oIX0oI;

    public BaseAIActivity$send$1(boolean z, BaseAIActivity baseAIActivity) {
        this.f21634oIX0oI = z;
        this.f21633II0xO0 = baseAIActivity;
    }

    public static final void I0Io(String error, BaseAIActivity this$0) {
        BaseAIActivity.oIX0oI oix0oi;
        IIX0o.x0xO0oo(error, "$error");
        IIX0o.x0xO0oo(this$0, "this$0");
        switch (error.hashCode()) {
            case 1537218:
                if (error.equals("2004")) {
                    ToastUtils.showLong(R.string.login_user_info_error);
                    break;
                }
                break;
            case 1596802:
                if (error.equals("4006")) {
                    this$0.showPayTipPopup(R.string.points_insufficient_tip);
                    break;
                }
                break;
            case 1626588:
                if (error.equals("5001")) {
                    this$0.showPayTipPopup(R.string.ai_benefit_buy_tip);
                    break;
                }
                break;
            case 1626589:
                if (error.equals("5002")) {
                    this$0.showPayTipPopup(R.string.ai_benefit_expired_tip);
                    break;
                }
                break;
        }
        oix0oi = this$0.mAIAnswerCallback;
        if (oix0oi != null) {
            oix0oi.error(error);
        }
    }

    public static final void X0o0xo(BaseAIActivity this$0, AIAnswer it) {
        BaseAIActivity.oIX0oI oix0oi;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(it, "$it");
        oix0oi = this$0.mAIAnswerCallback;
        if (oix0oi != null) {
            oix0oi.oIX0oI(it);
        }
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo final String error) {
        IIX0o.x0xO0oo(error, "error");
        LogUtils.d("handleResponse error = " + error);
        AIRecords mReceivedRecords = this.f21633II0xO0.getMReceivedRecords();
        if (mReceivedRecords != null) {
            BaseAIActivity baseAIActivity = this.f21633II0xO0;
            mReceivedRecords.setMStatus(2);
            String string = baseAIActivity.getString(R.string.generate_failed);
            IIX0o.oO(string, "getString(...)");
            mReceivedRecords.setMContent(string);
            baseAIActivity.getMRecordsDao().update(mReceivedRecords);
        }
        final BaseAIActivity baseAIActivity2 = this.f21633II0xO0;
        baseAIActivity2.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.ai.Oxx0xo
            @Override // java.lang.Runnable
            public final void run() {
                BaseAIActivity$send$1.I0Io(error, baseAIActivity2);
            }
        });
    }

    @Override // xxxI.II0xO0
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO final AIAnswer aIAnswer) {
        AIRecords mReceivedRecords;
        if (aIAnswer != null) {
            boolean z = this.f21634oIX0oI;
            final BaseAIActivity baseAIActivity = this.f21633II0xO0;
            LogUtils.d("handleResponse AIAnswer = " + aIAnswer);
            if (z && (mReceivedRecords = baseAIActivity.getMReceivedRecords()) != null) {
                mReceivedRecords.setMStatus(0);
                mReceivedRecords.setMContent(aIAnswer.getText());
                baseAIActivity.getMRecordsDao().update(mReceivedRecords);
            }
            baseAIActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.ai.IXxxXO
                @Override // java.lang.Runnable
                public final void run() {
                    BaseAIActivity$send$1.X0o0xo(BaseAIActivity.this, aIAnswer);
                }
            });
        }
    }
}
