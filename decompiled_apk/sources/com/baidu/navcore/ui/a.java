package com.baidu.navcore.ui;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.navisdk.framework.interfaces.l;
import com.baidu.navisdk.framework.interfaces.pronavi.d;

/* loaded from: classes7.dex */
public class a extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private d f6469a = null;

    /* renamed from: com.baidu.navcore.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0153a implements l {
        public C0153a(a aVar) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.l
        public void a() {
            com.baidu.navisdk.ui.routeguide.navicenter.b.b().a();
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d f = com.baidu.navisdk.framework.interfaces.c.p().f();
        this.f6469a = f;
        if (f != null) {
            f.a(new C0153a(this));
            this.f6469a.a(getActivity(), bundle);
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        d dVar = this.f6469a;
        if (dVar != null) {
            return dVar.a(getActivity(), bundle, viewGroup);
        }
        return new LinearLayout(getActivity());
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        d dVar = this.f6469a;
        if (dVar != null) {
            dVar.onStop();
        }
    }
}
