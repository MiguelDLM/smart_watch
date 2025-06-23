package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import com.baidu.mobads.sdk.api.CPUComponent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;

/* loaded from: classes7.dex */
public class da extends com.baidu.mobads.sdk.internal.a.e implements CPUComponent {

    /* renamed from: a, reason: collision with root package name */
    private final db f6301a;
    private Fragment b;
    private androidx.fragment.app.Fragment c;

    public da(db dbVar) {
        this.f6301a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void destroy() {
        db dbVar = this.f6301a;
        if (dbVar != null) {
            dbVar.e();
        }
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public Fragment getFragment() {
        Fragment fragment = this.b;
        if (fragment != null) {
            if (fragment instanceof FragmentDelegate) {
                ((FragmentDelegate) fragment).setProxy(this);
            }
            return this.b;
        }
        db dbVar = this.f6301a;
        if (dbVar != null) {
            Fragment a2 = dbVar.a((com.baidu.mobads.sdk.internal.a.e) this);
            this.b = a2;
            return a2;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public androidx.fragment.app.Fragment getSupportFragment() {
        androidx.fragment.app.Fragment fragment = this.c;
        if (fragment != null) {
            if (fragment instanceof FragmentV4Delegate) {
                ((FragmentV4Delegate) fragment).setProxy(this);
            }
            return this.c;
        }
        db dbVar = this.f6301a;
        if (dbVar != null) {
            androidx.fragment.app.Fragment b = dbVar.b((com.baidu.mobads.sdk.internal.a.e) this);
            this.c = b;
            return b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void refresh() {
        db dbVar = this.f6301a;
        if (dbVar != null) {
            dbVar.f();
        }
    }
}
