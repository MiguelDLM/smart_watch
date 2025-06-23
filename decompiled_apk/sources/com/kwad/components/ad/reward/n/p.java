package com.kwad.components.ad.reward.n;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class p extends s implements View.OnClickListener {
    private TextView Aa;
    private com.kwad.components.ad.reward.g qp;
    private ImageView zT;
    private TextView zU;
    private TextView zV;
    private TextView zW;
    private TextView zX;
    private TextView zY;
    private TextView zZ;

    public p(com.kwad.components.ad.reward.g gVar) {
        this.qp = gVar;
    }

    private void b(AdTemplate adTemplate) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        KSImageLoader.loadCircleIcon(this.zT, com.kwad.sdk.core.response.b.a.cg(dS), this.zT.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.zU.setText(com.kwad.sdk.core.response.b.a.cd(dS));
    }

    private void initView() {
        if (this.sA == null) {
            return;
        }
        if (this.qp.mContext.getResources().getConfiguration().orientation == 2) {
            this.zT = (ImageView) this.sA.findViewById(R.id.ksad_live_end_page_author_icon_landscape);
            this.zU = (TextView) this.sA.findViewById(R.id.ksad_author_name_txt_landscape);
            this.zV = (TextView) this.sA.findViewById(R.id.ksad_live_end_detail_watch_person_count_landscape);
            this.zW = (TextView) this.sA.findViewById(R.id.ksad_live_end_detail_like_person_count_landscape);
            this.zX = (TextView) this.sA.findViewById(R.id.ksad_live_end_detail_watch_time_landscape);
            this.zY = (TextView) this.sA.findViewById(R.id.ksad_live_end_bottom_title_landscape);
            this.zZ = (TextView) this.sA.findViewById(R.id.ksad_live_end_bottom_action_btn_landscape);
            this.Aa = (TextView) this.sA.findViewById(R.id.ksad_live_end_bottom_des_btn_landscape);
        } else {
            this.zT = (ImageView) this.sA.findViewById(R.id.ksad_live_end_page_author_icon);
            this.zU = (TextView) this.sA.findViewById(R.id.ksad_author_name_txt);
            this.zV = (TextView) this.sA.findViewById(R.id.ksad_live_end_detail_watch_person_count);
            this.zW = (TextView) this.sA.findViewById(R.id.ksad_live_end_detail_like_person_count);
            this.zX = (TextView) this.sA.findViewById(R.id.ksad_live_end_detail_watch_time);
            this.zY = (TextView) this.sA.findViewById(R.id.ksad_live_end_bottom_title);
            this.zZ = (TextView) this.sA.findViewById(R.id.ksad_live_end_bottom_action_btn);
            this.Aa = (TextView) this.sA.findViewById(R.id.ksad_live_end_bottom_des_btn);
        }
        this.zZ.setOnClickListener(this);
        this.Aa.setOnClickListener(this);
    }

    private static String m(long j) {
        long j2 = (j / 3600000) % 24;
        long j3 = (j / 60000) % 60;
        long j4 = (j / 1000) % 60;
        if (j2 > 0) {
            return String.format("%02d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
        return String.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j4));
    }

    public final void T(int i) {
        TextView textView = this.zY;
        if (textView != null) {
            if (i > 0) {
                if (this.qp.oZ) {
                    String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i));
                    SpannableString spannableString = new SpannableString(format);
                    int color = gG().getResources().getColor(R.color.ksad_reward_main_color);
                    spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                    int length = format.length();
                    spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
                    this.zY.setText(spannableString);
                    return;
                }
                textView.setText("已获得奖励");
                return;
            }
            textView.setText("已获得奖励");
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        b(rVar.getAdTemplate());
    }

    public final void h(ViewGroup viewGroup) {
        if (this.qp.mContext.getResources().getConfiguration().orientation == 2) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub_landscape, R.id.ksad_live_end_page_layout_root_landscape);
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        }
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.cT(24);
        if (view.equals(this.zZ)) {
            this.qp.a(2, view.getContext(), 38, 1, 0L, false, bVar);
        } else if (view.equals(this.Aa)) {
            this.qp.a(2, view.getContext(), 37, 1, 0L, false, bVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.g gVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j) {
        this.zW.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.zX.setText(m(adLivePushEndInfo.mLiveDuration));
        this.zV.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (gVar.oZ) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.b.a.af(com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate)) - j, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = gG().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.zY.setText(spannableString);
            return;
        }
        this.zY.setText("内容很精彩，不要错过哦");
    }
}
