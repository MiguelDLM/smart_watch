package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class NativeAppCallAttachmentStore {

    @OXOo.OOXIXo
    public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";

    @OXOo.OOXIXo
    public static final NativeAppCallAttachmentStore INSTANCE = new NativeAppCallAttachmentStore();

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.oOoXoXO
    private static File attachmentsDirectory;

    /* loaded from: classes8.dex */
    public static final class Attachment {

        @OXOo.oOoXoXO
        private final String attachmentName;

        @OXOo.OOXIXo
        private final String attachmentUrl;

        @OXOo.oOoXoXO
        private final Bitmap bitmap;

        @OXOo.OOXIXo
        private final UUID callId;
        private boolean isContentUri;

        @OXOo.oOoXoXO
        private final Uri originalUri;
        private boolean shouldCreateFile;

        public Attachment(@OXOo.OOXIXo UUID callId, @OXOo.oOoXoXO Bitmap bitmap, @OXOo.oOoXoXO Uri uri) {
            String attachmentUrl;
            IIX0o.x0xO0oo(callId, "callId");
            this.callId = callId;
            this.bitmap = bitmap;
            this.originalUri = uri;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (kotlin.text.OxI.oX0I0O("content", scheme, true)) {
                    this.isContentUri = true;
                    String authority = uri.getAuthority();
                    this.shouldCreateFile = (authority == null || kotlin.text.OxI.IOOoXo0Ix(authority, ShareConstants.WEB_DIALOG_PARAM_MEDIA, false, 2, null)) ? false : true;
                } else if (kotlin.text.OxI.oX0I0O("file", uri.getScheme(), true)) {
                    this.shouldCreateFile = true;
                } else {
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isWebUri(uri)) {
                        throw new FacebookException(IIX0o.XIxXXX0x0("Unsupported scheme for media Uri : ", scheme));
                    }
                }
            } else if (bitmap != null) {
                this.shouldCreateFile = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            String uuid = this.shouldCreateFile ? UUID.randomUUID().toString() : null;
            this.attachmentName = uuid;
            if (!this.shouldCreateFile) {
                attachmentUrl = String.valueOf(uri);
            } else {
                FacebookContentProvider.Companion companion = FacebookContentProvider.Companion;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                attachmentUrl = companion.getAttachmentUrl(FacebookSdk.getApplicationId(), callId, uuid);
            }
            this.attachmentUrl = attachmentUrl;
        }

        @OXOo.oOoXoXO
        public final String getAttachmentName() {
            return this.attachmentName;
        }

        @OXOo.OOXIXo
        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        @OXOo.oOoXoXO
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @OXOo.OOXIXo
        public final UUID getCallId() {
            return this.callId;
        }

        @OXOo.oOoXoXO
        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final boolean getShouldCreateFile() {
            return this.shouldCreateFile;
        }

        public final boolean isContentUri() {
            return this.isContentUri;
        }

        public final void setContentUri(boolean z) {
            this.isContentUri = z;
        }

        public final void setShouldCreateFile(boolean z) {
            this.shouldCreateFile = z;
        }
    }

    static {
        String name = NativeAppCallAttachmentStore.class.getName();
        IIX0o.oO(name, "NativeAppCallAttachmentStore::class.java.name");
        TAG = name;
    }

    private NativeAppCallAttachmentStore() {
    }

    @XO0OX.x0XOIxOo
    public static final void addAttachments(@OXOo.oOoXoXO Collection<Attachment> collection) throws FacebookException {
        File attachmentFile;
        if (collection != null && !collection.isEmpty()) {
            if (attachmentsDirectory == null) {
                cleanupAllAttachments();
            }
            ensureAttachmentsDirectoryExists();
            ArrayList<File> arrayList = new ArrayList();
            try {
                for (Attachment attachment : collection) {
                    if (attachment.getShouldCreateFile() && (attachmentFile = getAttachmentFile(attachment.getCallId(), attachment.getAttachmentName(), true)) != null) {
                        arrayList.add(attachmentFile);
                        if (attachment.getBitmap() != null) {
                            INSTANCE.processAttachmentBitmap(attachment.getBitmap(), attachmentFile);
                        } else if (attachment.getOriginalUri() != null) {
                            INSTANCE.processAttachmentFile(attachment.getOriginalUri(), attachment.isContentUri(), attachmentFile);
                        }
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, IIX0o.XIxXXX0x0("Got unexpected exception:", e));
                for (File file : arrayList) {
                    if (file != null) {
                        try {
                            file.delete();
                        } catch (Exception unused) {
                        }
                    }
                }
                throw new FacebookException(e);
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final void cleanupAllAttachments() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            FilesKt__UtilsKt.o0(attachmentsDirectory2);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void cleanupAttachmentsForCall(@OXOo.OOXIXo UUID callId) {
        IIX0o.x0xO0oo(callId, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(callId, false);
        if (attachmentsDirectoryForCall != null) {
            FilesKt__UtilsKt.o0(attachmentsDirectoryForCall);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Attachment createAttachment(@OXOo.OOXIXo UUID callId, @OXOo.OOXIXo Bitmap attachmentBitmap) {
        IIX0o.x0xO0oo(callId, "callId");
        IIX0o.x0xO0oo(attachmentBitmap, "attachmentBitmap");
        return new Attachment(callId, attachmentBitmap, null);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final File ensureAttachmentsDirectoryExists() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            attachmentsDirectory2.mkdirs();
        }
        return attachmentsDirectory2;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final File getAttachmentFile(@OXOo.OOXIXo UUID callId, @OXOo.oOoXoXO String str, boolean z) throws IOException {
        IIX0o.x0xO0oo(callId, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(callId, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            try {
                if (attachmentsDirectory == null) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), ATTACHMENTS_DIR_NAME);
                }
                file = attachmentsDirectory;
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final File getAttachmentsDirectoryForCall(@OXOo.OOXIXo UUID callId, boolean z) {
        IIX0o.x0xO0oo(callId, "callId");
        if (attachmentsDirectory == null) {
            return null;
        }
        File file = new File(attachmentsDirectory, callId.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final File openAttachment(@OXOo.oOoXoXO UUID uuid, @OXOo.oOoXoXO String str) throws FileNotFoundException {
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(str) && uuid != null) {
            try {
                return getAttachmentFile(uuid, str, false);
            } catch (IOException unused) {
                throw new FileNotFoundException();
            }
        }
        throw new FileNotFoundException();
    }

    private final void processAttachmentBitmap(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility utility = Utility.INSTANCE;
            Utility.closeQuietly(fileOutputStream);
        }
    }

    private final void processAttachmentFile(Uri uri, boolean z, File file) throws IOException {
        InputStream openInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            if (!z) {
                openInputStream = new FileInputStream(uri.getPath());
            } else {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
            }
            Utility utility = Utility.INSTANCE;
            Utility.copyAndCloseInputStream(openInputStream, fileOutputStream);
            Utility.closeQuietly(fileOutputStream);
        } catch (Throwable th) {
            Utility utility2 = Utility.INSTANCE;
            Utility.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Attachment createAttachment(@OXOo.OOXIXo UUID callId, @OXOo.OOXIXo Uri attachmentUri) {
        IIX0o.x0xO0oo(callId, "callId");
        IIX0o.x0xO0oo(attachmentUri, "attachmentUri");
        return new Attachment(callId, null, attachmentUri);
    }
}
