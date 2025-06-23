package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.FeedBackItemBean;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.ToastUtil;

/* loaded from: classes.dex */
public class FeedBackDialog extends tanxc_do implements View.OnClickListener, NotConfused {
    private static final String TAG = "FeedBackDialog";
    private ITanxAd iTanxAd;
    ImageView ivClose;
    TextView tvMsg1;
    TextView tvMsg2;
    TextView tvMsg3;
    TextView tvMsg4;
    TextView tvMsg5;
    TextView tvMsg6;
    TextView tvMsg7;
    TextView tvMsg8;

    public FeedBackDialog(@NonNull Context context, int i, ITanxAd iTanxAd) {
        super(context, i);
        setContentView(R.layout.dialog_feed_back);
        this.iTanxAd = iTanxAd;
        initView();
        initClick();
    }

    private void initClick() {
        this.tvMsg1.setOnClickListener(this);
        this.tvMsg2.setOnClickListener(this);
        this.tvMsg3.setOnClickListener(this);
        this.tvMsg4.setOnClickListener(this);
        this.tvMsg5.setOnClickListener(this);
        this.tvMsg6.setOnClickListener(this);
        this.tvMsg7.setOnClickListener(this);
        this.tvMsg8.setOnClickListener(this);
        this.ivClose.setOnClickListener(this);
    }

    private void initView() {
        this.tvMsg1 = (TextView) findViewById(R.id.tv_msg1);
        this.tvMsg2 = (TextView) findViewById(R.id.tv_msg2);
        this.tvMsg3 = (TextView) findViewById(R.id.tv_msg3);
        this.tvMsg4 = (TextView) findViewById(R.id.tv_msg4);
        this.tvMsg5 = (TextView) findViewById(R.id.tv_msg5);
        this.tvMsg6 = (TextView) findViewById(R.id.tv_msg6);
        this.tvMsg7 = (TextView) findViewById(R.id.tv_msg7);
        this.tvMsg8 = (TextView) findViewById(R.id.tv_msg8);
        this.ivClose = (ImageView) findViewById(R.id.iv_close);
    }

    private void submit(FeedBackItemBean feedBackItemBean) {
        ITanxAd iTanxAd;
        LogUtils.d(TAG, "submit");
        if (feedBackItemBean != null && (iTanxAd = this.iTanxAd) != null && iTanxAd.getBidInfo() != null && this.iTanxAd.getBidInfo().getEventTrack() != null) {
            InteractionUpload.getInstance().uploadInteraction(this.iTanxAd.getBidInfo().getEventTrack(), feedBackItemBean.getInteractType(), feedBackItemBean.getInteractDesc());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedBackItemBean feedBackItemBean;
        int id = view.getId();
        if (id == R.id.tv_msg1) {
            feedBackItemBean = new FeedBackItemBean().build4();
        } else if (id == R.id.tv_msg2) {
            feedBackItemBean = new FeedBackItemBean().build6();
        } else if (id == R.id.tv_msg3) {
            feedBackItemBean = new FeedBackItemBean().build501();
        } else if (id == R.id.tv_msg4) {
            feedBackItemBean = new FeedBackItemBean().build502();
        } else if (id == R.id.tv_msg5) {
            feedBackItemBean = new FeedBackItemBean().build503();
        } else if (id == R.id.tv_msg6) {
            feedBackItemBean = new FeedBackItemBean().build504();
        } else if (id == R.id.tv_msg7) {
            feedBackItemBean = new FeedBackItemBean().build505();
        } else if (id == R.id.tv_msg8) {
            feedBackItemBean = new FeedBackItemBean().build506();
        } else {
            if (id == R.id.iv_close) {
                dismiss();
                return;
            }
            feedBackItemBean = null;
        }
        submit(feedBackItemBean);
        ToastUtil.showToastImg("感谢您的反馈", R.mipmap.ic_star);
        dismiss();
    }
}
