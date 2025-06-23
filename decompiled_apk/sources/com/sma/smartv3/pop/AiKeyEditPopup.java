package com.sma.smartv3.pop;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class AiKeyEditPopup extends DialogFragment {

    @OXOo.oOoXoXO
    private EditText edt;

    @OXOo.oOoXoXO
    private FrameLayout mLayout;

    @OXOo.oOoXoXO
    private Oox.oOoXoXO<? super String, Boolean> mListener;

    @OXOo.oOoXoXO
    private FrameLayout mRoot;
    private int mTitle;

    @OXOo.OOXIXo
    private String mTitleText = "";

    @OXOo.oOoXoXO
    private TextView tvTitle;

    private final void inputComplete() {
        String str;
        Editable text;
        Oox.oOoXoXO<? super String, Boolean> oooxoxo = this.mListener;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            EditText editText = this.edt;
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            if (!oooxoxo.invoke(str).booleanValue()) {
                return;
            }
        }
        EditText editText2 = this.edt;
        if (editText2 != null) {
            editText2.setText((CharSequence) null);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$2(AiKeyEditPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$4(AiKeyEditPopup this$0, TextView textView, int i, KeyEvent keyEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (i == 6) {
            this$0.inputComplete();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(AiKeyEditPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(AiKeyEditPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.inputComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$7(AiKeyEditPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            oOXoIIIo.oIX0oI.xxX(activity, ProjectManager.f19822oIX0oI.xxX());
        }
    }

    @OXOo.oOoXoXO
    public final EditText getEdt() {
        return this.edt;
    }

    @OXOo.oOoXoXO
    public final FrameLayout getMLayout() {
        return this.mLayout;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<String, Boolean> getMListener() {
        return this.mListener;
    }

    @OXOo.oOoXoXO
    public final FrameLayout getMRoot() {
        return this.mRoot;
    }

    public final int getMTitle() {
        return this.mTitle;
    }

    @OXOo.OOXIXo
    public final String getMTitleText() {
        return this.mTitleText;
    }

    @OXOo.oOoXoXO
    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    @Override // androidx.fragment.app.Fragment
    @OXOo.OOXIXo
    public View onCreateView(@OXOo.OOXIXo LayoutInflater inflater, @OXOo.oOoXoXO ViewGroup viewGroup, @OXOo.oOoXoXO Bundle bundle) {
        TextView textView;
        TextView textView2;
        View findViewById;
        View findViewById2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(inflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        this.mRoot = frameLayout;
        frameLayout.setBackgroundResource(R.color.popup_root_bg_color);
        this.mLayout = new FrameLayout(requireActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        FrameLayout frameLayout2 = this.mRoot;
        if (frameLayout2 != null) {
            frameLayout2.addView(this.mLayout, layoutParams);
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oIX0oI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AiKeyEditPopup.onCreateView$lambda$3$lambda$2(AiKeyEditPopup.this, view);
                }
            });
            FrameLayout frameLayout3 = this.mLayout;
            if (frameLayout3 != null) {
                frameLayout3.setClickable(true);
            }
        }
        LayoutInflater.from(requireActivity()).inflate(R.layout.pop_aikey_edit, this.mLayout);
        FrameLayout frameLayout4 = this.mLayout;
        EditText editText = null;
        if (frameLayout4 != null) {
            textView = (TextView) frameLayout4.findViewById(R.id.tv_title);
        } else {
            textView = null;
        }
        this.tvTitle = textView;
        if (textView != null) {
            textView.setText(R.string.ai_key_set);
        }
        FrameLayout frameLayout5 = this.mLayout;
        if (frameLayout5 != null) {
            editText = (EditText) frameLayout5.findViewById(R.id.edt);
        }
        this.edt = editText;
        if (editText != null) {
            editText.setHint(R.string.ai_key_input_tip);
        }
        EditText editText2 = this.edt;
        if (editText2 != null) {
            editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sma.smartv3.pop.II0xO0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                    boolean onCreateView$lambda$4;
                    onCreateView$lambda$4 = AiKeyEditPopup.onCreateView$lambda$4(AiKeyEditPopup.this, textView3, i, keyEvent);
                    return onCreateView$lambda$4;
                }
            });
        }
        FrameLayout frameLayout6 = this.mLayout;
        if (frameLayout6 != null && (findViewById2 = frameLayout6.findViewById(R.id.action1)) != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.I0Io
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AiKeyEditPopup.onCreateView$lambda$5(AiKeyEditPopup.this, view);
                }
            });
        }
        FrameLayout frameLayout7 = this.mLayout;
        if (frameLayout7 != null && (findViewById = frameLayout7.findViewById(R.id.action2)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oxoX
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AiKeyEditPopup.onCreateView$lambda$6(AiKeyEditPopup.this, view);
                }
            });
        }
        FrameLayout frameLayout8 = this.mLayout;
        if (frameLayout8 != null && (textView2 = (TextView) frameLayout8.findViewById(R.id.tv_right_top)) != null) {
            textView2.setText(R.string.help);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.X0o0xo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AiKeyEditPopup.onCreateView$lambda$8$lambda$7(AiKeyEditPopup.this, view);
                }
            });
        }
        FrameLayout frameLayout9 = this.mRoot;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(frameLayout9);
        return frameLayout9;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            window.setLayout(-1, -1);
            FrameLayout frameLayout = this.mLayout;
            if (frameLayout != null) {
                frameLayout.startAnimation(AnimationUtils.loadAnimation(requireActivity(), R.anim.pop_bottom_show_2));
            }
        }
    }

    public final void setEdt(@OXOo.oOoXoXO EditText editText) {
        this.edt = editText;
    }

    public final void setMLayout(@OXOo.oOoXoXO FrameLayout frameLayout) {
        this.mLayout = frameLayout;
    }

    public final void setMListener(@OXOo.oOoXoXO Oox.oOoXoXO<? super String, Boolean> oooxoxo) {
        this.mListener = oooxoxo;
    }

    public final void setMRoot(@OXOo.oOoXoXO FrameLayout frameLayout) {
        this.mRoot = frameLayout;
    }

    public final void setMTitle(int i) {
        this.mTitle = i;
    }

    public final void setMTitleText(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.mTitleText = str;
    }

    public final void setTvTitle(@OXOo.oOoXoXO TextView textView) {
        this.tvTitle = textView;
    }

    public final void show(@OXOo.OOXIXo AppCompatActivity activity) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        show(activity.getSupportFragmentManager(), "showAiKeyPopup");
    }
}
