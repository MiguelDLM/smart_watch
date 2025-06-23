package com.sma.smartv3.ui.ai;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.ui.ai.BaseAIActivity;
import com.sma.smartv3.view.text.PFMedium;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAIAnswerBaseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnswerBaseActivity.kt\ncom/sma/smartv3/ui/ai/AIAnswerBaseActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,181:1\n87#2,7:182\n94#2,3:190\n70#2,7:193\n97#2:200\n1#3:189\n*S KotlinDebug\n*F\n+ 1 AIAnswerBaseActivity.kt\ncom/sma/smartv3/ui/ai/AIAnswerBaseActivity\n*L\n178#1:182,7\n178#1:190,3\n178#1:193,7\n178#1:200\n178#1:189\n*E\n"})
/* loaded from: classes12.dex */
public class AIAnswerBaseActivity extends BaseAIActivity {

    @OXOo.OOXIXo
    private final String TAG = "AIAnswerActivity";

    @OXOo.OOXIXo
    private final X0IIOO aiActivityBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FrameLayout>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$aiActivityBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FrameLayout invoke() {
            return (FrameLayout) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_fl_bg);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return AIAnswerBaseActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIAnswerBaseActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleOtherRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIAnswerBaseActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });
    private final int bytesLimit = 500;

    @OXOo.OOXIXo
    private final X0IIOO etContent$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$etContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_ed_content);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvCount$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$tvCount$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_et_count);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvDescribe$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$tvDescribe$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_et_describe);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvExample$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$tvExample$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_tv_example);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO centerLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$centerLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO resultsLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FrameLayout>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$resultsLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FrameLayout invoke() {
            return (FrameLayout) AIAnswerBaseActivity.this.findViewById(R.id.generate_results_frameLayout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvContent$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$tvContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) AIAnswerBaseActivity.this.findViewById(R.id.ai_answer_tv_results);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnGenerate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.ai.AIAnswerBaseActivity$btnGenerate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) AIAnswerBaseActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BaseAIActivity.oIX0oI<AIAnswer> {
        public II0xO0() {
        }

        @Override // com.sma.smartv3.ui.ai.BaseAIActivity.oIX0oI
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void oIX0oI(@OXOo.OOXIXo AIAnswer result) {
            IIX0o.x0xO0oo(result, "result");
            AIAnswerBaseActivity.this.dismissLoading();
            if (result.getText().length() > 0) {
                AIAnswerBaseActivity.this.getResultsLayout().setVisibility(0);
                AIAnswerBaseActivity.this.getTvContent().setText(result.getText());
                AIAnswerBaseActivity aIAnswerBaseActivity = AIAnswerBaseActivity.this;
                String string = aIAnswerBaseActivity.getString(R.string.regeneration);
                IIX0o.oO(string, "getString(...)");
                aIAnswerBaseActivity.setBtnGenText(string);
            }
        }

        @Override // com.sma.smartv3.ui.ai.BaseAIActivity.oIX0oI
        public void error(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            AIAnswerBaseActivity.this.dismissLoading();
            AIAnswerBaseActivity aIAnswerBaseActivity = AIAnswerBaseActivity.this;
            String string = aIAnswerBaseActivity.getString(R.string.regeneration);
            IIX0o.oO(string, "getString(...)");
            aIAnswerBaseActivity.setBtnGenText(string);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            while (String.valueOf(editable).length() > AIAnswerBaseActivity.this.bytesLimit) {
                if (editable != null) {
                    editable.delete(editable.length() - 1, editable.length());
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            PFMedium tvCount = AIAnswerBaseActivity.this.getTvCount();
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(charSequence).length());
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(AIAnswerBaseActivity.this.bytesLimit);
            tvCount.setText(sb.toString());
        }
    }

    private final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final FrameLayout getAiActivityBg() {
        return (FrameLayout) this.aiActivityBg$delegate.getValue();
    }

    private final Button getBtnGenerate() {
        return (Button) this.btnGenerate$delegate.getValue();
    }

    private final LinearLayout getCenterLayout() {
        return (LinearLayout) this.centerLayout$delegate.getValue();
    }

    private final EditText getEtContent() {
        return (EditText) this.etContent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout getResultsLayout() {
        return (FrameLayout) this.resultsLayout$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvContent() {
        return (PFMedium) this.tvContent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvCount() {
        return (PFMedium) this.tvCount$delegate.getValue();
    }

    private final PFMedium getTvDescribe() {
        return (PFMedium) this.tvDescribe$delegate.getValue();
    }

    private final PFMedium getTvExample() {
        return (PFMedium) this.tvExample$delegate.getValue();
    }

    private final void initEditText() {
        String str;
        String str2;
        PFMedium tvDescribe = getTvDescribe();
        AIFunction mAIFunction = getMAIFunction();
        String str3 = null;
        if (mAIFunction != null) {
            str = mAIFunction.getDetailsDescribe();
        } else {
            str = null;
        }
        tvDescribe.setText(str);
        EditText etContent = getEtContent();
        AIFunction mAIFunction2 = getMAIFunction();
        if (mAIFunction2 != null) {
            str2 = mAIFunction2.getDetailsHint();
        } else {
            str2 = null;
        }
        etContent.setHint(str2);
        PFMedium tvExample = getTvExample();
        AIFunction mAIFunction3 = getMAIFunction();
        if (mAIFunction3 != null) {
            str3 = mAIFunction3.getDetailsExample();
        }
        tvExample.setText(str3);
        getEtContent().addTextChangedListener(new oIX0oI());
    }

    public final void addView(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        getCenterLayout().addView(view);
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity
    public void changeAiModel() {
        String string = getString(R.string.generate);
        IIX0o.oO(string, "getString(...)");
        setBtnGenText(string);
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        super.init(bundle);
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int detailsBg;
        super.initView();
        int i = 0;
        setPlayResult(false);
        BarUtils.transparentStatusBar(this);
        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.root_view));
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ai_history_icon);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        ImageView abhTitleOtherRight = getAbhTitleOtherRight();
        if (!ProductManager.f20544oIX0oI.xXo()) {
            i = 8;
        }
        abhTitleOtherRight.setVisibility(i);
        getAbhTitleOtherRight().setImageResource(R.drawable.ai_switch_modle_icon);
        getAbhTitleOtherRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        AIFunction mAIFunction = getMAIFunction();
        if (mAIFunction != null && (detailsBg = mAIFunction.getDetailsBg()) != 0) {
            getAiActivityBg().setBackgroundResource(detailsBg);
        }
        initEditText();
    }

    public void inputContent(@OXOo.OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        if (content.length() == 0) {
            ToastUtils.showLong(getString(R.string.enter_content), new Object[0]);
            return;
        }
        showLoading(true);
        String string = getString(R.string.generating);
        IIX0o.oO(string, "getString(...)");
        setBtnGenText(string);
        sendAIQuestion(content);
    }

    public int layoutId() {
        return R.layout.activity_ai_answer;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        String str;
        IIX0o.x0xO0oo(view, "view");
        Editable text = getEtContent().getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        inputContent(str);
    }

    public final void onClear(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        getEtContent().getText().clear();
        String string = getString(R.string.generate);
        IIX0o.oO(string, "getString(...)");
        setBtnGenText(string);
    }

    public final void onCopy(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ClipboardUtils.copyText(getTvContent().getText());
        ToastUtils.showLong(R.string.copied);
    }

    public final void onTitleOtherRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        onSetModel();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        AIFunction mAIFunction = getMAIFunction();
        if (mAIFunction != null) {
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", null);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", mAIFunction);
            Intent intent = new Intent(this, (Class<?>) AIRecordsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void sendAIQuestion(@OXOo.OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        AIFunction mAIFunction = getMAIFunction();
        IIX0o.ooOOo0oXI(mAIFunction);
        BaseAIActivity.send$default(this, new AIQuestion(mAIFunction.getType(), text, null, null, false, 28, null), new II0xO0(), false, false, false, 28, null);
    }

    public final void setBtnGenText(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "str");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " setBtnGenText openAIDeductionPoints = " + getOpenAIDeductionPoints());
        Button btnGenerate = getBtnGenerate();
        if (ProjectManager.f19822oIX0oI.XooIO0oo0() && ProductManager.f20544oIX0oI.XOx() && AIManager.f19833oIX0oI.OOXIXo(false) == 0 && getOpenAIDeductionPoints() != 0) {
            str = str + " (-" + getOpenAIDeductionPoints() + getString(R.string.points) + HexStringBuilder.COMMENT_END_CHAR;
        }
        btnGenerate.setText(str);
    }

    @Override // com.sma.smartv3.ui.ai.BaseAIActivity
    public void showAIDeductionPoints() {
        String string = getString(R.string.generate);
        IIX0o.oO(string, "getString(...)");
        setBtnGenText(string);
    }
}
