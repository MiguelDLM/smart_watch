package com.baidu.navcore.ui;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.framework.interfaces.h;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.g;

/* loaded from: classes7.dex */
public class c extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    com.baidu.navisdk.framework.interfaces.diyspeak.c f6471a = null;
    private final a.InterfaceC0201a b = new a(this);

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0201a {
        public a(c cVar) {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if ((obj instanceof g) && "com.baidu.navisdk.BNDiySpeakView".equals(((g) obj).f6829a)) {
                com.baidu.navisdk.ui.routeguide.navicenter.b.b().a();
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f6471a.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f6471a.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h a2 = com.baidu.navisdk.framework.interfaces.c.p().a("DiySpeak");
        if (a2 != null && (a2 instanceof com.baidu.navisdk.framework.interfaces.diyspeak.a)) {
            this.f6471a = ((com.baidu.navisdk.framework.interfaces.diyspeak.a) a2).b0();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f6471a.a(getActivity(), bundle, viewGroup);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f6471a.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.f6471a.onPause();
        com.baidu.navisdk.framework.message.a.a().a(this.b);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f6471a.onResume();
        com.baidu.navisdk.framework.message.a.a().a(this.b, g.class, new Class[0]);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f6471a.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f6471a.onStop();
    }
}
