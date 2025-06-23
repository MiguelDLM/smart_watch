package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public class Presenter {
    private Object aKU;
    private View mRootView;
    private final List<Presenter> aKT = new CopyOnWriteArrayList();
    private PresenterState aKV = PresenterState.INIT;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INIT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static abstract class PresenterState {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        static {
            int i = 0;
            PresenterState presenterState = new PresenterState("INIT", i, i) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = presenterState;
            int i2 = 1;
            PresenterState presenterState2 = new PresenterState("CREATE", i2, i2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aKT.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).G(presenter.mRootView);
                        } catch (Exception e) {
                            c.gatherException(e);
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                        }
                    }
                }
            };
            CREATE = presenterState2;
            int i3 = 2;
            PresenterState presenterState3 = new PresenterState("BIND", i3, i3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aKT.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).k(presenter.aKU);
                        } catch (Throwable th) {
                            c.gatherException(th);
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                        }
                    }
                }
            };
            BIND = presenterState3;
            int i4 = 3;
            PresenterState presenterState4 = new PresenterState("UNBIND", i4, i4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aKT.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).mw();
                        } catch (Exception e) {
                            c.gatherException(e);
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                        }
                    }
                }
            };
            UNBIND = presenterState4;
            int i5 = 4;
            PresenterState presenterState5 = new PresenterState("DESTROY", i5, i5) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aKT.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e) {
                            c.gatherException(e);
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                        }
                    }
                }
            };
            DESTROY = presenterState5;
            $VALUES = new PresenterState[]{presenterState, presenterState2, presenterState3, presenterState4, presenterState5};
        }

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);

        private PresenterState(String str, int i, int i2) {
            this.mIndex = i2;
        }
    }

    private boolean Kd() {
        if (this.aKV.index() >= PresenterState.CREATE.index()) {
            return true;
        }
        return false;
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aKV.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index < presenterState.index() && presenter.aKV.index() < presenterState.index()) {
            if (Kd() && !presenter.Kd() && (view = this.mRootView) != null) {
                presenter.G(view);
            }
            if (isBound() && presenter.Kd() && !presenter.isBound() && (obj = this.aKU) != null) {
                presenter.k(obj);
            }
        }
    }

    private boolean isBound() {
        if (this.aKV == PresenterState.BIND) {
            return true;
        }
        return false;
    }

    @UiThread
    public final void G(View view) {
        try {
            this.aKV = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aKV.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final List<Presenter> Ke() {
        return this.aKT;
    }

    public final Object Kf() {
        return this.aKU;
    }

    public final void a(Presenter presenter) {
        this.aKT.add(presenter);
        if (!Kd() || presenter.Kd()) {
            return;
        }
        G(this.mRootView);
    }

    public void aj() {
    }

    @UiThread
    public final void destroy() {
        try {
            if (this.aKV == PresenterState.BIND) {
                mw();
            }
            this.aKV = PresenterState.DESTROY;
            onDestroy();
            this.aKV.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final <T extends View> T findViewById(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return l.dB(getContext());
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void k(@NonNull Object obj) {
        try {
            PresenterState presenterState = this.aKV;
            if (presenterState != PresenterState.INIT) {
                PresenterState presenterState2 = PresenterState.DESTROY;
            }
            PresenterState presenterState3 = PresenterState.BIND;
            if (presenterState == presenterState3) {
                mw();
            }
            this.aKV = presenterState3;
            this.aKU = obj;
            aj();
            this.aKV.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @UiThread
    public final void mw() {
        try {
            this.aKV = PresenterState.UNBIND;
            onUnbind();
            this.aKV.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }

    public final void a(Presenter presenter, boolean z) {
        this.aKT.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            c.gatherException(th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }
}
