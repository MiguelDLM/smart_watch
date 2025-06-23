package com.jd.ad.sdk.jad_xi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.text.ooOOo0oXI;

@Deprecated
/* loaded from: classes10.dex */
public class jad_ob extends Fragment {
    public final com.jd.ad.sdk.jad_xi.jad_an jad_an;
    public final jad_qd jad_bo;
    public final Set<jad_ob> jad_cp;

    @Nullable
    public com.jd.ad.sdk.jad_ep.jad_jw jad_dq;

    @Nullable
    public jad_ob jad_er;

    @Nullable
    public Fragment jad_fs;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_qd {
        public jad_an() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + jad_ob.this + ooOOo0oXI.f33074oOoXoXO;
        }
    }

    public jad_ob() {
        this(new com.jd.ad.sdk.jad_xi.jad_an());
    }

    public final void jad_an(@NonNull Activity activity) {
        jad_an();
        jad_pc jad_pcVar = com.jd.ad.sdk.jad_ep.jad_cp.jad_an(activity).jad_fs;
        jad_pcVar.getClass();
        jad_ob jad_an2 = jad_pcVar.jad_an(activity.getFragmentManager(), (Fragment) null);
        this.jad_er = jad_an2;
        if (equals(jad_an2)) {
            return;
        }
        this.jad_er.jad_cp.add(this);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            jad_an(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Logger.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.jad_fs;
        }
        sb.append(parentFragment);
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public jad_ob(@NonNull com.jd.ad.sdk.jad_xi.jad_an jad_anVar) {
        this.jad_bo = new jad_an();
        this.jad_cp = new HashSet();
        this.jad_an = jad_anVar;
    }

    public final void jad_an() {
        jad_ob jad_obVar = this.jad_er;
        if (jad_obVar != null) {
            jad_obVar.jad_cp.remove(this);
            this.jad_er = null;
        }
    }
}
