package com.baidu.navcore.ui;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.navisdk.framework.interfaces.pronavi.l;

/* loaded from: classes7.dex */
public class b extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    l f6470a = null;

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.framework.interfaces.l {
        public a(b bVar) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.l
        public void a() {
            com.baidu.navisdk.ui.routeguide.navicenter.b.b().a();
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l n = com.baidu.navisdk.framework.interfaces.c.p().n();
        this.f6470a = n;
        if (n != null) {
            n.a(new a(this));
            this.f6470a.a(getActivity(), bundle);
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        l lVar = this.f6470a;
        if (lVar != null) {
            return lVar.a(getActivity(), bundle, viewGroup);
        }
        return new LinearLayout(getActivity());
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onPause();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onResume();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        l lVar = this.f6470a;
        if (lVar != null) {
            lVar.onStop();
        }
    }
}
