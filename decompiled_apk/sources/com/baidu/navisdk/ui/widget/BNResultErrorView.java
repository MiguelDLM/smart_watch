package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class BNResultErrorView extends RelativeLayout {
    private final TextView errorText;
    private final TextView getmRepeatText;
    private final View mRepeatButton;

    public BNResultErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_rr_route_error_view, this);
        this.mRepeatButton = findViewById(R.id.route_error_repeat_button);
        this.errorText = (TextView) findViewById(R.id.route_error_text_button);
        this.getmRepeatText = (TextView) findViewById(R.id.route_error_repeat_text);
    }

    public void setRepeatButtonListener(View.OnClickListener onClickListener) {
        this.mRepeatButton.setOnClickListener(onClickListener);
    }

    public void setRepeatText(String str) {
        this.getmRepeatText.setText(str);
    }

    public void setText(String str) {
        this.errorText.setText(str);
    }

    public void setmRepeatButtonGone() {
        TextView textView = this.getmRepeatText;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setmRepeatButtonVisible() {
        TextView textView = this.getmRepeatText;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
