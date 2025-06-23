package com.kwad.components.core.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T MW;
    protected ViewGroup lD;
    protected Presenter mPresenter;

    public c(Context context) {
        this(context, null);
    }

    private void initMVP() {
        this.MW = ku();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.lD);
        }
        this.mPresenter.k(this.MW);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        T t = this.MW;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initData();

    public boolean kq() {
        return false;
    }

    public abstract void ks();

    public abstract T ku();

    @NonNull
    public abstract Presenter onCreatePresenter();

    public final void pi() {
        initData();
        this.lD = (ViewGroup) l.inflate(getContext(), getLayoutId(), this);
        ks();
    }

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        if (kq()) {
            return;
        }
        pi();
    }
}
