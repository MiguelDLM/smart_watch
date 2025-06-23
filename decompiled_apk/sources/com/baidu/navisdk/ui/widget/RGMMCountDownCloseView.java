package com.baidu.navisdk.ui.widget;

import OXOo.OOXIXo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public final class RGMMCountDownCloseView extends ConstraintLayout {

    @OOXIXo
    private final TextView countDownText;

    @OOXIXo
    private final View mLayout;

    public RGMMCountDownCloseView(@OOXIXo Context context, @OOXIXo AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.nsdk_layout_count_down_close_view, this);
        this.mLayout = inflate;
        this.countDownText = (TextView) inflate.findViewById(R.id.count_down_time_text);
    }

    @OOXIXo
    public final TextView getCountDownText() {
        return this.countDownText;
    }

    @OOXIXo
    public final View getMLayout() {
        return this.mLayout;
    }

    public final void setClickListener(@OOXIXo View.OnClickListener onClickListener) {
        this.mLayout.setOnClickListener(onClickListener);
    }

    public final void updateCountDownTime(int i) {
        TextView textView = this.countDownText;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('s');
        textView.setText(sb.toString());
    }
}
