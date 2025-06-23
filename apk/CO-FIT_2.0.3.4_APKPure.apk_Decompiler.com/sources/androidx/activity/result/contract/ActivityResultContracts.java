package androidx.activity.result.contract;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

public final class ActivityResultContracts {

    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@OOXIXo Context context, @OOXIXo Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(uri, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(uri, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            IIX0o.oO(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @OOXIXo
        public final Boolean parseResult(int i, @oOoXoXO Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$CreateDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        @OOXIXo
        private final String mimeType;

        public CreateDocument(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
            this.mimeType = str;
        }

        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", str);
            IIX0o.oO(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        @oOoXoXO
        public final Uri parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @kotlin.OOXIXo(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @kotlin.XX(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$GetContent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
            IIX0o.oO(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @oOoXoXO
        public final Uri parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);

        @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final List<Uri> getClipDataUris$activity_release(@OOXIXo Intent intent) {
                IIX0o.x0xO0oo(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i = 0; i < itemCount; i++) {
                        Uri uri = clipData.getItemAt(i).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private Companion() {
            }
        }

        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            IIX0o.oO(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = Companion.getClipDataUris$activity_release(r3);
         */
        @OXOo.OOXIXo
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, @OXOo.oOoXoXO android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x000f
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 != 0) goto L_0x0013
            L_0x000f:
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            L_0x0013:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.parseResult(int, android.content.Intent):java.util.List");
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(strArr, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
            IIX0o.oO(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @oOoXoXO
        public final Uri parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(21)
    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @oOoXoXO Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @oOoXoXO Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @oOoXoXO
        public final Uri parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@OOXIXo Context context, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(strArr, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            IIX0o.oO(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(r3);
         */
        @OXOo.OOXIXo
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, @OXOo.oOoXoXO android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x000f
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 != 0) goto L_0x0013
            L_0x000f:
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            L_0x0013:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.OpenMultipleDocuments.parseResult(int, android.content.Intent):java.util.List");
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickContact\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @oOoXoXO Void voidR) {
            IIX0o.x0xO0oo(context, bn.f.o);
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            IIX0o.oO(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @oOoXoXO
        public Uri parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        private final int maxItems;

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }

            private Companion() {
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, (IIXOooo) null);
        }

        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest pickVisualMediaRequest) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(pickVisualMediaRequest, "input");
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickMultipleVisualMedia(int i, int i2, IIXOooo iIXOooo) {
            this((i2 & 1) != 0 ? Companion.getMaxItems$activity_release() : i);
        }

        @CallSuper
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest pickVisualMediaRequest) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(pickVisualMediaRequest, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                int min = Math.min(this.maxItems, pickVisualMediaRequest.getMaxItems());
                if (min <= 1 || min > MediaStore.getPickImagesMaxLimit()) {
                    throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", min);
                intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", pickVisualMediaRequest.getDefaultTab().getValue());
                intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", pickVisualMediaRequest.isOrderedSelection());
                if (!pickVisualMediaRequest.isCustomAccentColorApplied()) {
                    return intent;
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", pickVisualMediaRequest.getAccentColor());
                return intent;
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                    int min2 = Math.min(this.maxItems, pickVisualMediaRequest.getMaxItems());
                    if (min2 > 1) {
                        intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX, min2);
                        intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB, pickVisualMediaRequest.getDefaultTab().getValue());
                        intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER, pickVisualMediaRequest.isOrderedSelection());
                        if (pickVisualMediaRequest.isCustomAccentColorApplied()) {
                            intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR, pickVisualMediaRequest.getAccentColor());
                        }
                        return intent2;
                    }
                    throw new IllegalArgumentException("Max items must be greater than 1");
                }
                throw new IllegalStateException("Required value was null.");
            } else {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(r3);
         */
        @OXOo.OOXIXo
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, @OXOo.oOoXoXO android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x000f
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 != 0) goto L_0x0013
            L_0x000f:
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            L_0x0013:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.parseResult(int, android.content.Intent):java.util.List");
        }

        public PickMultipleVisualMedia(int i) {
            this.maxItems = i;
            if (i <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1");
            }
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        @OOXIXo
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR = "androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR";
        @OOXIXo
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER = "androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER";
        @OOXIXo
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB = "androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB";
        @OOXIXo
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        @OOXIXo
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        @OOXIXo
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            @x0XOIxOo
            @oOoXoXO
            public final ResolveInfo getSystemFallbackPicker$activity_release(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, bn.f.o);
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            @oOoXoXO
            public final String getVisualMimeType$activity_release(@OOXIXo VisualMediaType visualMediaType) {
                IIX0o.x0xO0oo(visualMediaType, "input");
                if (visualMediaType instanceof ImageOnly) {
                    return "image/*";
                }
                if (visualMediaType instanceof VideoOnly) {
                    return "video/*";
                }
                if (visualMediaType instanceof SingleMimeType) {
                    return ((SingleMimeType) visualMediaType).getMimeType();
                }
                if (visualMediaType instanceof ImageAndVideo) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }

            @kotlin.OOXIXo(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @kotlin.XX(expression = "isPhotoPickerAvailable(context)", imports = {}))
            @x0XOIxOo
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            @x0XOIxOo
            public final boolean isSystemFallbackPickerAvailable$activity_release(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, bn.f.o);
                if (getSystemFallbackPicker$activity_release(context) != null) {
                    return true;
                }
                return false;
            }

            @x0XOIxOo
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isSystemPickerAvailable$activity_release() {
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    return true;
                }
                if (i < 30 || SdkExtensions.getExtensionVersion(30) < 2) {
                    return false;
                }
                return true;
            }

            private Companion() {
            }

            @x0XOIxOo
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, bn.f.o);
                return isSystemPickerAvailable$activity_release() || isSystemFallbackPickerAvailable$activity_release(context);
            }
        }

        public static abstract class DefaultTab {

            public static final class AlbumsTab extends DefaultTab {
                @OOXIXo
                public static final AlbumsTab INSTANCE = new AlbumsTab();
                private static final int value = 0;

                private AlbumsTab() {
                    super((IIXOooo) null);
                }

                public int getValue() {
                    return value;
                }
            }

            public static final class PhotosTab extends DefaultTab {
                @OOXIXo
                public static final PhotosTab INSTANCE = new PhotosTab();
                private static final int value = 1;

                private PhotosTab() {
                    super((IIXOooo) null);
                }

                public int getValue() {
                    return value;
                }
            }

            public /* synthetic */ DefaultTab(IIXOooo iIXOooo) {
                this();
            }

            public abstract int getValue();

            private DefaultTab() {
            }
        }

        public static final class ImageAndVideo implements VisualMediaType {
            @OOXIXo
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        public static final class ImageOnly implements VisualMediaType {
            @OOXIXo
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        public static final class SingleMimeType implements VisualMediaType {
            @OOXIXo
            private final String mimeType;

            public SingleMimeType(@OOXIXo String str) {
                IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
                this.mimeType = str;
            }

            @OOXIXo
            public final String getMimeType() {
                return this.mimeType;
            }
        }

        public static final class VideoOnly implements VisualMediaType {
            @OOXIXo
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        public interface VisualMediaType {
        }

        @x0XOIxOo
        @oOoXoXO
        public static final ResolveInfo getSystemFallbackPicker$activity_release(@OOXIXo Context context) {
            return Companion.getSystemFallbackPicker$activity_release(context);
        }

        @kotlin.OOXIXo(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @kotlin.XX(expression = "isPhotoPickerAvailable(context)", imports = {}))
        @x0XOIxOo
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @x0XOIxOo
        public static final boolean isSystemFallbackPickerAvailable$activity_release(@OOXIXo Context context) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(context);
        }

        @x0XOIxOo
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest pickVisualMediaRequest) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(pickVisualMediaRequest, "input");
            return null;
        }

        @x0XOIxOo
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable(@OOXIXo Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest pickVisualMediaRequest) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(pickVisualMediaRequest, "input");
            Companion companion = Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", pickVisualMediaRequest.getDefaultTab().getValue());
                if (!pickVisualMediaRequest.isCustomAccentColorApplied()) {
                    return intent;
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", pickVisualMediaRequest.getAccentColor());
                return intent;
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                    intent2.putExtra(EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB, pickVisualMediaRequest.getDefaultTab().getValue());
                    if (pickVisualMediaRequest.isCustomAccentColorApplied()) {
                        intent2.putExtra(EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR, pickVisualMediaRequest.getAccentColor());
                    }
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.");
            } else {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
        }

        @oOoXoXO
        public final Uri parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            if (data == null) {
                data = (Uri) CollectionsKt___CollectionsKt.XxXX(GetMultipleContents.Companion.getClipDataUris$activity_release(intent));
            }
            return data;
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,962:1\n12541#2,2:963\n8676#2,2:965\n9358#2,4:967\n11365#2:971\n11700#2,3:972\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions\n*L\n180#1:963,2\n185#1:965,2\n185#1:967,4\n196#1:971\n196#1:972,3\n*E\n"})
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        @OOXIXo
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        @OOXIXo
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Intent createIntent$activity_release(@OOXIXo String[] strArr) {
                IIX0o.x0xO0oo(strArr, "input");
                Intent putExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr);
                IIX0o.oO(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }

            private Companion() {
            }
        }

        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(strArr, "input");
            return Companion.createIntent$activity_release(strArr);
        }

        @oOoXoXO
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@OOXIXo Context context, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(strArr, "input");
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(o0.O0xOxO());
            }
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(strArr.length), 16));
            for (String oIX0oI2 : strArr) {
                Pair oIX0oI3 = Xo0.oIX0oI(oIX0oI2, Boolean.TRUE);
                linkedHashMap.put(oIX0oI3.getFirst(), oIX0oI3.getSecond());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        @OOXIXo
        public Map<String, Boolean> parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                return o0.O0xOxO();
            }
            if (intent == null) {
                return o0.O0xOxO();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return o0.O0xOxO();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            int length = intArrayExtra.length;
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(Boolean.valueOf(intArrayExtra[i2] == 0));
            }
            return o0.ooOx(CollectionsKt___CollectionsKt.XOx0xX(ArraysKt___ArraysKt.OIOIxOO(stringArrayExtra), arrayList));
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,962:1\n12774#2,2:963\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n*L\n212#1:963,2\n*E\n"})
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{str});
        }

        @oOoXoXO
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@OOXIXo Context context, @OOXIXo String str) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "input");
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        @OOXIXo
        public Boolean parseResult(int i, @oOoXoXO Intent intent) {
            if (intent == null || i != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean z = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (intArrayExtra[i2] == 0) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Intent intent) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(intent, "input");
            return intent;
        }

        @OOXIXo
        public ActivityResult parseResult(int i, @oOoXoXO Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        @OOXIXo
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        @OOXIXo
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo IntentSenderRequest intentSenderRequest) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(intentSenderRequest, "input");
            Intent putExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            IIX0o.oO(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        @OOXIXo
        public ActivityResult parseResult(int i, @oOoXoXO Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@OOXIXo Context context, @OOXIXo Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(uri, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(uri, "input");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
            IIX0o.oO(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @OOXIXo
        public final Boolean parseResult(int i, @oOoXoXO Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@OOXIXo Context context, @oOoXoXO Void voidR) {
            IIX0o.x0xO0oo(context, bn.f.o);
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @oOoXoXO Void voidR) {
            IIX0o.x0xO0oo(context, bn.f.o);
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @oOoXoXO
        public final Bitmap parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @kotlin.OOXIXo(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakeVideo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@OOXIXo Context context, @OOXIXo Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(uri, "input");
            return null;
        }

        @CallSuper
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Uri uri) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(uri, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            IIX0o.oO(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @oOoXoXO
        public final Bitmap parseResult(int i, @oOoXoXO Intent intent) {
            if (i != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }
}
