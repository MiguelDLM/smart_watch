package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.skyeye.a;
import com.baidu.navisdk.skyeye.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.p0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNUserKeyLogDialog extends Dialog implements View.OnClickListener, p0.b {
    private static final String TAG = "BNUserKeyLogDialog";
    private ImageView mAddTestPlanCb;
    private View mCancleView;
    private EditText mDespEText;
    private View mIssueIdCopyBtn;
    private TextView mIssueIdTv;
    private ImageView mLogSwitchCb;
    private c mModel;
    private View mTakePhotoBtn;
    private p0 mTimerUtil;
    private Button mUploadBtn;

    public BNUserKeyLogDialog(Activity activity) {
        super(activity, R.style.BNDialog);
        this.mModel = null;
        this.mTimerUtil = null;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_user_key_log, null);
        setContentView(inflate);
        this.mCancleView = inflate.findViewById(R.id.eye_spy_paper_cancle);
        this.mUploadBtn = (Button) inflate.findViewById(R.id.eye_spy_paper_upload);
        this.mLogSwitchCb = (ImageView) inflate.findViewById(R.id.eye_spy_paper_open_normal_log_checkbox);
        this.mAddTestPlanCb = (ImageView) inflate.findViewById(R.id.eye_spy_paper_add_to_testplan_checkbox);
        this.mDespEText = (EditText) inflate.findViewById(R.id.eye_spy_paper_desp_et);
        this.mIssueIdTv = (TextView) inflate.findViewById(R.id.eye_spy_paper_issue_id);
        this.mIssueIdCopyBtn = inflate.findViewById(R.id.eye_spy_paper_issue_id_copy);
        this.mTakePhotoBtn = inflate.findViewById(R.id.eye_spy_paper_take_picure);
        this.mModel = a.n().d();
        initListener();
        initCheckBox();
    }

    private void initCheckBox() {
        this.mModel.a();
        updateAddTestPlanCheckBox(this.mModel.e());
        updateLogSwitchCheckBox(LogUtil.LOGWRITE);
        this.mIssueIdTv.setText(a0.e());
    }

    private void initListener() {
        p0 p0Var = new p0();
        this.mTimerUtil = p0Var;
        p0Var.a(this);
        this.mLogSwitchCb.setOnClickListener(this);
        this.mAddTestPlanCb.setOnClickListener(this);
        this.mUploadBtn.setOnClickListener(this);
        this.mCancleView.setOnClickListener(this);
        this.mIssueIdCopyBtn.setOnClickListener(this);
        this.mDespEText.setOnClickListener(this);
        this.mTakePhotoBtn.setOnClickListener(this);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.navisdk.ui.widget.BNUserKeyLogDialog.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                BNUserKeyLogDialog.this.mTimerUtil.a(10);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.navisdk.ui.widget.BNUserKeyLogDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.n().h();
                BNUserKeyLogDialog.this.mTimerUtil.a();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mTimerUtil.a();
        Button button = this.mUploadBtn;
        if (button != null) {
            button.setText("上报");
        }
        int id = view.getId();
        if (id == R.id.eye_spy_paper_issue_id_copy) {
            ((ClipboardManager) view.getContext().getSystemService("clipboard")).setText(this.mIssueIdTv.getText());
            TipTool.onCreateToastDialog(view.getContext(), "复制成功");
            return;
        }
        if (id == R.id.eye_spy_paper_cancle) {
            dismiss();
            return;
        }
        if (id == R.id.eye_spy_paper_open_normal_log_checkbox) {
            if (LogUtil.LOGWRITE) {
                LogUtil.LOGWRITE = false;
            } else {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "普通日志开关已打开,请复现问题后点击右侧按钮上传日志");
                LogUtil.LOGWRITE = true;
            }
            updateLogSwitchCheckBox(LogUtil.LOGWRITE);
            return;
        }
        if (id == R.id.eye_spy_paper_add_to_testplan_checkbox) {
            if (this.mModel.e()) {
                a.n().a(false);
            } else {
                a.n().a(true);
            }
            updateAddTestPlanCheckBox(this.mModel.e());
            return;
        }
        if (id == R.id.eye_spy_paper_upload) {
            a.n().a(2, 255, this.mDespEText.getText().toString());
            dismiss();
        }
    }

    @Override // com.baidu.navisdk.util.common.p0.b
    public void onTick(int i) {
        if (i == 0) {
            a.n().a(2, 255, this.mDespEText.getText().toString());
            dismiss();
            return;
        }
        Button button = this.mUploadBtn;
        if (button != null) {
            button.setText("上报(" + i + "s)");
        }
    }

    public void updateAddTestPlanCheckBox(boolean z) {
        try {
            if (!z) {
                this.mAddTestPlanCb.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkin_icon));
            } else {
                this.mAddTestPlanCb.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkout_icon));
            }
        } catch (Exception e) {
            LogUtil.e(TAG, "Exception updateLogCheckBoxDrawable:" + e.getMessage());
        }
    }

    public void updateLogSwitchCheckBox(boolean z) {
        try {
            if (z) {
                this.mLogSwitchCb.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkin_icon));
            } else {
                this.mLogSwitchCb.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkout_icon));
            }
        } catch (Exception e) {
            LogUtil.e(TAG, "Exception updateLogCheckBoxDrawable:" + e.getMessage());
        }
    }
}
