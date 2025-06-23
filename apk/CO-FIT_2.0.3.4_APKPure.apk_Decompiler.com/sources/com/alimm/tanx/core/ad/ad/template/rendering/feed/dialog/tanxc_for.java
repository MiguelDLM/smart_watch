package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.MediaRenderingMode;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.SysUtils;
import java.util.Arrays;
import java.util.List;

public class tanxc_for {
    private final View tanxc_byte;
    private final TextView tanxc_case;
    private final TextView tanxc_char;
    private final Context tanxc_do;
    private final ImageView tanxc_else;
    private final LinearLayout tanxc_for;
    private final ImageView tanxc_goto;
    private PopupWindow tanxc_if;
    private final LinearLayout tanxc_int;
    private final int tanxc_long = 60;
    private final LinearLayout tanxc_new;
    private final MediaRenderingMode tanxc_this;
    private final View tanxc_try;

    public tanxc_for(Context context, MediaRenderingMode mediaRenderingMode) {
        this.tanxc_do = context;
        this.tanxc_this = mediaRenderingMode;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tips_popup, (ViewGroup) null);
        this.tanxc_try = inflate;
        this.tanxc_for = (LinearLayout) inflate.findViewById(R.id.ll_uninterested);
        this.tanxc_int = (LinearLayout) inflate.findViewById(R.id.ll_poor_content);
        this.tanxc_new = (LinearLayout) inflate.findViewById(R.id.ll_background);
        this.tanxc_case = (TextView) inflate.findViewById(R.id.tv_uninterested);
        this.tanxc_char = (TextView) inflate.findViewById(R.id.tv_poor_content);
        this.tanxc_else = (ImageView) inflate.findViewById(R.id.iv_uninterested);
        this.tanxc_goto = (ImageView) inflate.findViewById(R.id.iv_poor_content);
        this.tanxc_byte = inflate.findViewById(R.id.view_line);
    }

    public List<View> tanxc_do() {
        return Arrays.asList(new View[]{this.tanxc_for, this.tanxc_int});
    }

    public void tanxc_for() {
        PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public boolean tanxc_if() {
        PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void tanxc_int() {
        if (TanxCoreSdk.getConfig() == null) {
            return;
        }
        if (TanxCoreSdk.getConfig().getSettingConfig().isNightSwitch()) {
            LinearLayout linearLayout = this.tanxc_new;
            linearLayout.setBackground(linearLayout.getContext().getDrawable(R.drawable.tanx_shape_close_pop_night));
            ImageView imageView = this.tanxc_else;
            imageView.setImageDrawable(imageView.getContext().getDrawable(R.mipmap.uninterested_night));
            ImageView imageView2 = this.tanxc_goto;
            imageView2.setImageDrawable(imageView2.getContext().getDrawable(R.mipmap.poor_content_night));
            this.tanxc_byte.setBackgroundResource(R.color.close_pop_line_color_night);
            this.tanxc_case.setTextColor(Color.parseColor("#EDEDED"));
            this.tanxc_char.setTextColor(Color.parseColor("#EDEDED"));
            return;
        }
        LinearLayout linearLayout2 = this.tanxc_new;
        linearLayout2.setBackground(linearLayout2.getContext().getDrawable(R.drawable.tanx_shape_close_pop_write));
        ImageView imageView3 = this.tanxc_else;
        imageView3.setImageDrawable(imageView3.getContext().getDrawable(R.mipmap.uninterested_write));
        ImageView imageView4 = this.tanxc_goto;
        imageView4.setImageDrawable(imageView4.getContext().getDrawable(R.mipmap.poor_content_write));
        this.tanxc_byte.setBackgroundResource(R.color.close_pop_line_color_write);
        this.tanxc_case.setTextColor(Color.parseColor("#1C1C1C"));
        this.tanxc_char.setTextColor(Color.parseColor("#1C1C1C"));
    }

    public void tanxc_do(View view, ErrorInterface errorInterface) {
        try {
            if (!tanxc_if()) {
                PopupWindow popupWindow = new PopupWindow(this.tanxc_do, (AttributeSet) null, R.style.Transparent_Dialog);
                this.tanxc_if = popupWindow;
                popupWindow.setFocusable(true);
                this.tanxc_if.setOutsideTouchable(true);
                this.tanxc_if.setContentView(this.tanxc_try);
                this.tanxc_if.setWidth(SysUtils.getScreenWidth(this.tanxc_try.getContext()) / 3);
                this.tanxc_if.setHeight(DimenUtil.dp2px(this.tanxc_try.getContext(), 60.0f));
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int tanxc_do2 = tanxc_do(iArr[0] + view.getMeasuredWidth());
                int tanxc_do3 = tanxc_do(view, iArr[1]);
                Context context = this.tanxc_do;
                if (context instanceof Activity) {
                    this.tanxc_if.showAtLocation(((Activity) context).getWindow().getDecorView().getRootView(), 53, tanxc_do2, tanxc_do3);
                } else {
                    this.tanxc_if.showAtLocation(view, 53, tanxc_do2, tanxc_do3);
                }
                tanxc_int();
            }
        } catch (Exception e) {
            LogUtils.e("TipsPopUp", e);
            errorInterface.error(LogUtils.getStackTraceMessage(e));
        }
    }

    private int tanxc_do(View view, int i) {
        if (SysUtils.getScreenHeight(this.tanxc_try.getContext()) / 2 > i) {
            return i + view.getMeasuredHeight();
        }
        return i - DimenUtil.dp2px(this.tanxc_try.getContext(), 60.0f);
    }

    private int tanxc_do(int i) {
        return SysUtils.getScreenWidth(this.tanxc_try.getContext()) - i;
    }
}
