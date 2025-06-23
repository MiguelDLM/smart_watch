package com.sma.smartv3.ui.device.guide;

import OXOo.OOXIXo;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseGuideFragment extends BaseFragment implements SlideSelectionListener {
    public Button btnSet;
    public ImageView ivPic;
    public TextView tvTip;
    public TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BaseGuideFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onSetClick();
    }

    @OOXIXo
    public final Button getBtnSet() {
        Button button = this.btnSet;
        if (button != null) {
            return button;
        }
        IIX0o.XOxIOxOx("btnSet");
        return null;
    }

    @OOXIXo
    public final ImageView getIvPic() {
        ImageView imageView = this.ivPic;
        if (imageView != null) {
            return imageView;
        }
        IIX0o.XOxIOxOx("ivPic");
        return null;
    }

    @OOXIXo
    public final TextView getTvTip() {
        TextView textView = this.tvTip;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tvTip");
        return null;
    }

    @OOXIXo
    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView != null) {
            return textView;
        }
        IIX0o.XOxIOxOx("tvTitle");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        View findViewById = getMView().findViewById(R.id.iv);
        IIX0o.oO(findViewById, "findViewById(...)");
        setIvPic((ImageView) findViewById);
        View findViewById2 = getMView().findViewById(R.id.tv_title);
        IIX0o.oO(findViewById2, "findViewById(...)");
        setTvTitle((TextView) findViewById2);
        View findViewById3 = getMView().findViewById(R.id.tv_tip);
        IIX0o.oO(findViewById3, "findViewById(...)");
        setTvTip((TextView) findViewById3);
        getTvTip().setMovementMethod(new ScrollingMovementMethod());
        View findViewById4 = getMView().findViewById(R.id.btn_set);
        IIX0o.oO(findViewById4, "findViewById(...)");
        setBtnSet((Button) findViewById4);
        getBtnSet().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.guide.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseGuideFragment.initView$lambda$0(BaseGuideFragment.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_app_guide;
    }

    public void onSetClick() {
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
    }

    public final void setBtnSet(@OOXIXo Button button) {
        IIX0o.x0xO0oo(button, "<set-?>");
        this.btnSet = button;
    }

    public final void setIvPic(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.ivPic = imageView;
    }

    public final void setTvTip(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tvTip = textView;
    }

    public final void setTvTitle(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.tvTitle = textView;
    }
}
