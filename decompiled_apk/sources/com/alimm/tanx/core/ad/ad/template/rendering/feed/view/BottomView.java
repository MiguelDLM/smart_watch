package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.CreativeItem;
import com.alimm.tanx.core.ad.bean.MediaRenderingMode;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class BottomView extends FrameLayout implements NotConfused {
    private ITanxFeedAd iTanxFeedAd;
    private ImageView ivClose;
    private LinearLayout llClose;
    private RelativeLayout rlRoot;
    private tanxc_for tipsPopUp;
    private TextView tvAd;
    private TextView tvAdName;

    public BottomView(@NonNull Context context) {
        super(context);
    }

    private void initClick() {
        this.llClose.setOnClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.BottomView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initView() {
        BidInfo bidInfo;
        CreativeItem creativeItem;
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && (bidInfo = iTanxFeedAd.getBidInfo()) != null && (creativeItem = bidInfo.getCreativeItem()) != null && creativeItem.getAdvName() != null) {
            this.tvAdName.setText(creativeItem.getAdvName());
        }
    }

    public View getCloseView() {
        return this.llClose;
    }

    public ITanxFeedAd getiTanxFeedAd() {
        return this.iTanxFeedAd;
    }

    public void setTanxFeedAd(ITanxFeedAd iTanxFeedAd) {
        this.iTanxFeedAd = iTanxFeedAd;
        initView();
    }

    public void setViewStyle(MediaRenderingMode mediaRenderingMode) {
        this.rlRoot.setBackgroundColor(Color.parseColor(mediaRenderingMode.getBgColor()));
        this.tvAdName.setTextColor(Color.parseColor(mediaRenderingMode.getAdvColor()));
        this.tvAd.setTextColor(Color.parseColor(mediaRenderingMode.getAdColor()));
        if (TanxCoreSdk.getConfig().getSettingConfig().isCustomTextSizeDpSwitch()) {
            this.tvAdName.setTextSize(1, mediaRenderingMode.getAdvSize2Int());
            this.tvAd.setTextSize(1, mediaRenderingMode.getAdSize2Int());
        } else {
            this.tvAdName.setTextSize(0, DimenUtil.dp2px(r0.getContext(), mediaRenderingMode.getAdvSize2Int()));
            this.tvAd.setTextSize(0, DimenUtil.dp2px(r0.getContext(), mediaRenderingMode.getAdSize2Int()));
        }
    }

    public BottomView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_ad_bottom, (ViewGroup) this, true);
        if (this.iTanxFeedAd != null) {
            return;
        }
        this.rlRoot = (RelativeLayout) inflate.findViewById(R.id.rl_root);
        this.tvAd = (TextView) inflate.findViewById(R.id.tv_ad);
        this.tvAdName = (TextView) inflate.findViewById(R.id.tv_ad_name);
        this.llClose = (LinearLayout) inflate.findViewById(R.id.ll_close);
        this.ivClose = (ImageView) inflate.findViewById(R.id.iv_close);
        initClick();
    }
}
