package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class FacebookContentProvider extends ContentProvider {

    @OXOo.OOXIXo
    private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String INVALID_FILE_NAME = "..";

    @OXOo.OOXIXo
    private static final String TAG;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final String getAttachmentUrl(@OXOo.oOoXoXO String str, @OXOo.OOXIXo UUID callId, @OXOo.oOoXoXO String str2) {
            IIX0o.x0xO0oo(callId, "callId");
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%s%s/%s/%s", Arrays.copyOf(new Object[]{FacebookContentProvider.ATTACHMENT_URL_BASE, str, callId.toString(), str2}, 4));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            return format;
        }

        private Companion() {
        }
    }

    static {
        String name = FacebookContentProvider.class.getName();
        IIX0o.oO(name, "FacebookContentProvider::class.java.name");
        TAG = name;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getAttachmentUrl(@OXOo.oOoXoXO String str, @OXOo.OOXIXo UUID uuid, @OXOo.oOoXoXO String str2) {
        return Companion.getAttachmentUrl(str, uuid, str2);
    }

    private final Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri) {
        try {
            String path = uri.getPath();
            if (path != null) {
                String substring = path.substring(1);
                IIX0o.oO(substring, "(this as java.lang.String).substring(startIndex)");
                Object[] array = StringsKt__StringsKt.XXoO0oX(substring, new String[]{"/"}, false, 0, 6, null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    String str = strArr[0];
                    String str2 = strArr[1];
                    if (!INVALID_FILE_NAME.contentEquals(str) && !INVALID_FILE_NAME.contentEquals(str2)) {
                        return new Pair<>(UUID.fromString(str), str2);
                    }
                    throw new Exception();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Exception unused) {
            return null;
        }
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
        return true;
    }

    @Override // android.content.ContentProvider
    @OXOo.oOoXoXO
    public ParcelFileDescriptor openFile(@OXOo.OOXIXo Uri uri, @OXOo.OOXIXo String mode) throws FileNotFoundException {
        IIX0o.x0xO0oo(uri, "uri");
        IIX0o.x0xO0oo(mode, "mode");
        Pair<UUID, String> parseCallIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
        if (parseCallIdAndAttachmentName != null) {
            try {
                NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
                File openAttachment = NativeAppCallAttachmentStore.openAttachment((UUID) parseCallIdAndAttachmentName.first, (String) parseCallIdAndAttachmentName.second);
                if (openAttachment != null) {
                    return ParcelFileDescriptor.open(openAttachment, 268435456);
                }
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                Log.e(TAG, IIX0o.XIxXXX0x0("Got unexpected exception:", e));
                throw e;
            }
        }
        throw new FileNotFoundException();
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
