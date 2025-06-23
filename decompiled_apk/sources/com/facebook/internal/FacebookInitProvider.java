package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FacebookInitProvider extends ContentProvider {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String TAG;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = FacebookInitProvider.class.getSimpleName();
        IIX0o.oO(simpleName, "FacebookInitProvider::class.java.simpleName");
        TAG = simpleName;
    }

    @Override // android.content.ContentProvider
    public int delete(@OXOo.OOXIXo Uri uri, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String[] strArr) {
        IIX0o.x0xO0oo(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @OXOo.oOoXoXO
    public String getType(@OXOo.OOXIXo Uri uri) {
        IIX0o.x0xO0oo(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @OXOo.oOoXoXO
    public Uri insert(@OXOo.OOXIXo Uri uri, @OXOo.oOoXoXO ContentValues contentValues) {
        IIX0o.x0xO0oo(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            if (context != null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.sdkInitialize(context);
                return false;
            }
            throw new IllegalArgumentException("Required value was null.");
        } catch (Exception e) {
            Log.i(TAG, "Failed to auto initialize the Facebook SDK", e);
            return false;
        }
    }

    @Override // android.content.ContentProvider
    @OXOo.oOoXoXO
    public Cursor query(@OXOo.OOXIXo Uri uri, @OXOo.oOoXoXO String[] strArr, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String[] strArr2, @OXOo.oOoXoXO String str2) {
        IIX0o.x0xO0oo(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@OXOo.OOXIXo Uri uri, @OXOo.oOoXoXO ContentValues contentValues, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String[] strArr) {
        IIX0o.x0xO0oo(uri, "uri");
        return 0;
    }
}
