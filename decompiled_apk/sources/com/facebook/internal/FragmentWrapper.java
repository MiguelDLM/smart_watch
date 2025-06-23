package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FragmentWrapper {

    @OXOo.oOoXoXO
    private Fragment nativeFragment;

    @OXOo.oOoXoXO
    private androidx.fragment.app.Fragment supportFragment;

    public FragmentWrapper(@OXOo.OOXIXo androidx.fragment.app.Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        this.supportFragment = fragment;
    }

    @OXOo.oOoXoXO
    public final Activity getActivity() {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }
        Fragment fragment2 = this.nativeFragment;
        if (fragment2 == null) {
            return null;
        }
        return fragment2.getActivity();
    }

    @OXOo.oOoXoXO
    public final Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    @OXOo.oOoXoXO
    public final androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public final void startActivityForResult(@OXOo.oOoXoXO Intent intent, int i) {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            if (fragment != null) {
                fragment.startActivityForResult(intent, i);
            }
        } else {
            Fragment fragment2 = this.nativeFragment;
            if (fragment2 != null) {
                fragment2.startActivityForResult(intent, i);
            }
        }
    }

    public FragmentWrapper(@OXOo.OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        this.nativeFragment = fragment;
    }
}
