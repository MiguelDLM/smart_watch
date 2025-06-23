package com.github.appintro;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class AppIntroCustomLayoutFragment extends Fragment {

    @OOXIXo
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private int layoutResId;

    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final AppIntroCustomLayoutFragment newInstance(int i) {
            AppIntroCustomLayoutFragment appIntroCustomLayoutFragment = new AppIntroCustomLayoutFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AppIntroCustomLayoutFragment.ARG_LAYOUT_RES_ID, i);
            appIntroCustomLayoutFragment.setArguments(bundle);
            return appIntroCustomLayoutFragment;
        }

        private Companion() {
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final AppIntroCustomLayoutFragment newInstance(int i) {
        return Companion.newInstance(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@oOoXoXO Bundle bundle) {
        int i;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            i = 0;
        } else {
            i = arguments.getInt(ARG_LAYOUT_RES_ID);
        }
        this.layoutResId = i;
    }

    @Override // androidx.fragment.app.Fragment
    @oOoXoXO
    public View onCreateView(@OOXIXo LayoutInflater inflater, @oOoXoXO ViewGroup viewGroup, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(inflater, "inflater");
        return inflater.inflate(this.layoutResId, viewGroup, false);
    }
}
