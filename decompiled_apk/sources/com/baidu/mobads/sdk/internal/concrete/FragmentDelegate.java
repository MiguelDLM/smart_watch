package com.baidu.mobads.sdk.internal.concrete;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.e;
import java.util.Map;

/* loaded from: classes7.dex */
public class FragmentDelegate extends Fragment implements a {

    /* renamed from: a, reason: collision with root package name */
    private e f6279a;
    private IAdInterListener b;

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.getCode();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.getData();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.getDelegator();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.getMessage();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.getTarget();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.getType();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.b(bundle);
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.a(context);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.a(bundle);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        e eVar = this.f6279a;
        if (eVar != null) {
            return eVar.a(layoutInflater, viewGroup, bundle);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public FragmentDelegate setDispatcher(IAdInterListener iAdInterListener) {
        this.b = iAdInterListener;
        return this;
    }

    public void setProxy(@NonNull e eVar) {
        this.f6279a = eVar;
        eVar.a(this.b);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        e eVar = this.f6279a;
        if (eVar != null) {
            eVar.setTarget(obj);
        }
    }
}
