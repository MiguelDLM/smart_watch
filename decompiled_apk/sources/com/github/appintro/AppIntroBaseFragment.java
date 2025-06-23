package com.github.appintro;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.TypefaceContainer;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public abstract class AppIntroBaseFragment extends Fragment implements SlideSelectionListener, SlideBackgroundColorHolder {
    private int bgDrawable;

    @ColorInt
    private int defaultBackgroundColor;

    @ColorRes
    private int defaultBackgroundColorRes;

    @ColorInt
    private int descColor;

    @ColorRes
    private int descColorRes;

    @oOoXoXO
    private TypefaceContainer descTypeface;

    @oOoXoXO
    private String description;
    private int drawable;

    @OOXIXo
    private final String logTAG = LogHelper.makeLogTag((Class<?>) AppIntroBaseFragment.class);

    @oOoXoXO
    private String title;

    @ColorInt
    private int titleColor;

    @ColorRes
    private int titleColorRes;

    @oOoXoXO
    private TypefaceContainer titleTypeface;

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public final int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public final int getDefaultBackgroundColorRes() {
        return this.defaultBackgroundColorRes;
    }

    @LayoutRes
    public abstract int getLayoutId();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@oOoXoXO Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.drawable = bundle.getInt("drawable");
            this.title = bundle.getString("title");
            this.description = bundle.getString("desc");
            this.titleTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, 0));
            this.descTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, 0));
            this.defaultBackgroundColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.defaultBackgroundColorRes = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES);
            this.bgDrawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            this.titleColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR);
            this.titleColorRes = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES);
            this.descColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR);
            this.descColorRes = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() != 0) {
            this.drawable = arguments.getInt("drawable");
            this.title = arguments.getString("title");
            this.description = arguments.getString("desc");
            this.bgDrawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            String string = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE);
            String string2 = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE);
            int i = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES);
            int i2 = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES);
            this.titleTypeface = new TypefaceContainer(string, i);
            this.descTypeface = new TypefaceContainer(string2, i2);
            this.defaultBackgroundColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.defaultBackgroundColorRes = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES);
            this.titleColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, 0);
            this.titleColorRes = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES, 0);
            this.descColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, 0);
            this.descColorRes = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @oOoXoXO
    public View onCreateView(@OOXIXo LayoutInflater inflater, @oOoXoXO ViewGroup viewGroup, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(inflater, "inflater");
        View inflate = inflater.inflate(getLayoutId(), viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.description);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.main);
        textView.setText(this.title);
        textView2.setText(this.description);
        if (this.titleColorRes != 0) {
            textView.setTextColor(ContextCompat.getColor(requireContext(), this.titleColorRes));
        } else {
            int i = this.titleColor;
            if (i != 0) {
                textView.setTextColor(i);
            }
        }
        if (this.descColorRes != 0) {
            textView2.setTextColor(ContextCompat.getColor(requireContext(), this.descColorRes));
        } else {
            int i2 = this.descColor;
            if (i2 != 0) {
                textView2.setTextColor(i2);
            }
        }
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            typefaceContainer.applyTo(textView);
        }
        TypefaceContainer typefaceContainer2 = this.descTypeface;
        if (typefaceContainer2 != null) {
            typefaceContainer2.applyTo(textView2);
        }
        imageView.setImageResource(this.drawable);
        int i3 = this.bgDrawable;
        if (i3 != 0) {
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(i3);
            }
        } else if (this.defaultBackgroundColorRes != 0) {
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), this.defaultBackgroundColorRes));
            }
        } else if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(this.defaultBackgroundColor);
        }
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView2.setMovementMethod(new ScrollingMovementMethod());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        KeyEvent.Callback callback;
        super.onPause();
        View view = getView();
        if (view == null) {
            callback = null;
        } else {
            callback = (ImageView) view.findViewById(R.id.image);
        }
        if (callback instanceof Animatable) {
            ((Animatable) callback).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        KeyEvent.Callback callback;
        super.onResume();
        View view = getView();
        if (view == null) {
            callback = null;
        } else {
            callback = (ImageView) view.findViewById(R.id.image);
        }
        if (callback instanceof Animatable) {
            ((Animatable) callback).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@OOXIXo Bundle outState) {
        String typeFaceUrl;
        int typeFaceResource;
        IIX0o.x0xO0oo(outState, "outState");
        outState.putInt("drawable", this.drawable);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.bgDrawable);
        outState.putString("title", this.title);
        outState.putString("desc", this.description);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.defaultBackgroundColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES, this.defaultBackgroundColorRes);
        outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES, this.titleColorRes);
        outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES, this.descColorRes);
        TypefaceContainer typefaceContainer = this.titleTypeface;
        int i = 0;
        String str = null;
        if (typefaceContainer != null) {
            if (typefaceContainer == null) {
                typeFaceUrl = null;
            } else {
                typeFaceUrl = typefaceContainer.getTypeFaceUrl();
            }
            outState.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, typeFaceUrl);
            TypefaceContainer typefaceContainer2 = this.titleTypeface;
            if (typefaceContainer2 == null) {
                typeFaceResource = 0;
            } else {
                typeFaceResource = typefaceContainer2.getTypeFaceResource();
            }
            outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, typeFaceResource);
        }
        TypefaceContainer typefaceContainer3 = this.descTypeface;
        if (typefaceContainer3 != null) {
            if (typefaceContainer3 != null) {
                str = typefaceContainer3.getTypeFaceUrl();
            }
            outState.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, str);
            TypefaceContainer typefaceContainer4 = this.descTypeface;
            if (typefaceContainer4 != null) {
                i = typefaceContainer4.getTypeFaceResource();
            }
            outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, i);
        }
        super.onSaveInstanceState(outState);
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        LogHelper.d(this.logTAG, "Slide " + ((Object) this.title) + " has been deselected.");
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        LogHelper.d(this.logTAG, "Slide " + ((Object) this.title) + " has been selected.");
    }

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public void setBackgroundColor(@ColorInt int i) {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view != null && (constraintLayout = (ConstraintLayout) view.findViewById(R.id.main)) != null) {
            constraintLayout.setBackgroundColor(i);
        }
    }
}
