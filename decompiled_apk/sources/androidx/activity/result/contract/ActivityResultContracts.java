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

/* loaded from: classes.dex */
public final class ActivityResultContracts {

    /* loaded from: classes.dex */
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@OOXIXo Context context, @OOXIXo Uri input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Uri input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            IIX0o.oO(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public final Boolean parseResult(int i, @oOoXoXO Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$CreateDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    /* loaded from: classes.dex */
    public static class CreateDocument extends ActivityResultContract<String, Uri> {

        @OOXIXo
        private final String mimeType;

        public CreateDocument(@OOXIXo String mimeType) {
            IIX0o.x0xO0oo(mimeType, "mimeType");
            this.mimeType = mimeType;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", input);
            IIX0o.oO(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
    /* loaded from: classes.dex */
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            IIX0o.oO(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
    /* loaded from: classes.dex */
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
        /* loaded from: classes.dex */
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

        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            IIX0o.oO(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public final List<Uri> parseResult(int i, @oOoXoXO Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = Companion.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt__CollectionsKt.ooXIXxIX() : clipDataUris$activity_release;
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    /* loaded from: classes.dex */
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo String[] input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String[] input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            IIX0o.oO(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @oOoXoXO Uri uri) {
            IIX0o.x0xO0oo(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @oOoXoXO Uri uri) {
            IIX0o.x0xO0oo(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
    /* loaded from: classes.dex */
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@OOXIXo Context context, @OOXIXo String[] input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String[] input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            IIX0o.oO(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public final List<Uri> parseResult(int i, @oOoXoXO Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt__CollectionsKt.ooXIXxIX() : clipDataUris$activity_release;
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickContact\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    /* loaded from: classes.dex */
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @oOoXoXO Void r2) {
            IIX0o.x0xO0oo(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            IIX0o.oO(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
    /* loaded from: classes.dex */
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int maxItems;

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int getMaxItems$activity_release() {
                int pickImagesMaxLimit;
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                    pickImagesMaxLimit = MediaStore.getPickImagesMaxLimit();
                    return pickImagesMaxLimit;
                }
                return Integer.MAX_VALUE;
            }

            private Companion() {
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        public /* synthetic */ PickMultipleVisualMedia(int i, int i2, IIXOooo iIXOooo) {
            this((i2 & 1) != 0 ? Companion.getMaxItems$activity_release() : i);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest input) {
            int pickImagesMaxLimit;
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                int min = Math.min(this.maxItems, input.getMaxItems());
                if (min > 1) {
                    pickImagesMaxLimit = MediaStore.getPickImagesMaxLimit();
                    if (min <= pickImagesMaxLimit) {
                        intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", min);
                        intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
                        intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", input.isOrderedSelection());
                        if (!input.isCustomAccentColorApplied()) {
                            return intent;
                        }
                        intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
                        return intent;
                    }
                }
                throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
            }
            if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                    int min2 = Math.min(this.maxItems, input.getMaxItems());
                    if (min2 > 1) {
                        intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX, min2);
                        intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB, input.getDefaultTab().getValue());
                        intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER, input.isOrderedSelection());
                        if (input.isCustomAccentColorApplied()) {
                            intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR, input.getAccentColor());
                        }
                        return intent2;
                    }
                    throw new IllegalArgumentException("Max items must be greater than 1");
                }
                throw new IllegalStateException("Required value was null.");
            }
            Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent3.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
            intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent3.getType() != null) {
                return intent3;
            }
            intent3.setType("*/*");
            intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent3;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public final List<Uri> parseResult(int i, @oOoXoXO Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (i != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt__CollectionsKt.ooXIXxIX() : clipDataUris$activity_release;
        }

        public PickMultipleVisualMedia(int i) {
            this.maxItems = i;
            if (i <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1");
            }
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    /* loaded from: classes.dex */
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {

        @OOXIXo
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";

        @OOXIXo
        public static final Companion Companion = new Companion(null);

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

        /* loaded from: classes.dex */
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
                IIX0o.x0xO0oo(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            @oOoXoXO
            public final String getVisualMimeType$activity_release(@OOXIXo VisualMediaType input) {
                IIX0o.x0xO0oo(input, "input");
                if (input instanceof ImageOnly) {
                    return "image/*";
                }
                if (input instanceof VideoOnly) {
                    return "video/*";
                }
                if (input instanceof SingleMimeType) {
                    return ((SingleMimeType) input).getMimeType();
                }
                if (input instanceof ImageAndVideo) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }

            @x0XOIxOo
            @kotlin.OOXIXo(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @kotlin.XX(expression = "isPhotoPickerAvailable(context)", imports = {}))
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            @x0XOIxOo
            public final boolean isSystemFallbackPickerAvailable$activity_release(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, "context");
                if (getSystemFallbackPicker$activity_release(context) != null) {
                    return true;
                }
                return false;
            }

            @x0XOIxOo
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isSystemPickerAvailable$activity_release() {
                int extensionVersion;
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    return true;
                }
                if (i >= 30) {
                    extensionVersion = SdkExtensions.getExtensionVersion(30);
                    if (extensionVersion >= 2) {
                        return true;
                    }
                }
                return false;
            }

            private Companion() {
            }

            @x0XOIxOo
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, "context");
                return isSystemPickerAvailable$activity_release() || isSystemFallbackPickerAvailable$activity_release(context);
            }
        }

        /* loaded from: classes.dex */
        public static abstract class DefaultTab {

            /* loaded from: classes.dex */
            public static final class AlbumsTab extends DefaultTab {

                @OOXIXo
                public static final AlbumsTab INSTANCE = new AlbumsTab();
                private static final int value = 0;

                private AlbumsTab() {
                    super(null);
                }

                @Override // androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab
                public int getValue() {
                    return value;
                }
            }

            /* loaded from: classes.dex */
            public static final class PhotosTab extends DefaultTab {

                @OOXIXo
                public static final PhotosTab INSTANCE = new PhotosTab();
                private static final int value = 1;

                private PhotosTab() {
                    super(null);
                }

                @Override // androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab
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

        /* loaded from: classes.dex */
        public static final class ImageAndVideo implements VisualMediaType {

            @OOXIXo
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        /* loaded from: classes.dex */
        public static final class ImageOnly implements VisualMediaType {

            @OOXIXo
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        /* loaded from: classes.dex */
        public static final class SingleMimeType implements VisualMediaType {

            @OOXIXo
            private final String mimeType;

            public SingleMimeType(@OOXIXo String mimeType) {
                IIX0o.x0xO0oo(mimeType, "mimeType");
                this.mimeType = mimeType;
            }

            @OOXIXo
            public final String getMimeType() {
                return this.mimeType;
            }
        }

        /* loaded from: classes.dex */
        public static final class VideoOnly implements VisualMediaType {

            @OOXIXo
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        /* loaded from: classes.dex */
        public interface VisualMediaType {
        }

        @x0XOIxOo
        @kotlin.OOXIXo(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @kotlin.XX(expression = "isPhotoPickerAvailable(context)", imports = {}))
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @x0XOIxOo
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable(@OOXIXo Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo PickVisualMediaRequest input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Companion companion = Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
                if (!input.isCustomAccentColorApplied()) {
                    return intent;
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
                return intent;
            }
            if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                    intent2.putExtra(EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB, input.getDefaultTab().getValue());
                    if (input.isCustomAccentColorApplied()) {
                        intent2.putExtra(EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR, input.getAccentColor());
                    }
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.");
            }
            Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent3.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
            if (intent3.getType() != null) {
                return intent3;
            }
            intent3.setType("*/*");
            intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
    /* loaded from: classes.dex */
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

        @OOXIXo
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";

        @OOXIXo
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Intent createIntent$activity_release(@OOXIXo String[] input) {
                IIX0o.x0xO0oo(input, "input");
                Intent putExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, input);
                IIX0o.oO(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String[] input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return Companion.createIntent$activity_release(input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@OOXIXo Context context, @OOXIXo String[] input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            if (input.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(o0.O0xOxO());
            }
            for (String str : input) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(input.length), 16));
            for (String str2 : input) {
                Pair oIX0oI2 = Xo0.oIX0oI(str2, Boolean.TRUE);
                linkedHashMap.put(oIX0oI2.getFirst(), oIX0oI2.getSecond());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
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
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i2 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i2 == 0));
                }
                return o0.ooOx(CollectionsKt___CollectionsKt.XOx0xX(ArraysKt___ArraysKt.OIOIxOO(stringArrayExtra), arrayList));
            }
            return o0.O0xOxO();
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,962:1\n12774#2,2:963\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n*L\n212#1:963,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{input});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@OOXIXo Context context, @OOXIXo String input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            if (ContextCompat.checkSelfPermission(context, input) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public Boolean parseResult(int i, @oOoXoXO Intent intent) {
            if (intent != null && i == -1) {
                int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
                boolean z = false;
                if (intArrayExtra != null) {
                    int length = intArrayExtra.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        if (intArrayExtra[i2] == 0) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                return Boolean.valueOf(z);
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes.dex */
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Intent input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return input;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public ActivityResult parseResult(int i, @oOoXoXO Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    /* loaded from: classes.dex */
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {

        @OOXIXo
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";

        @OOXIXo
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public Intent createIntent(@OOXIXo Context context, @OOXIXo IntentSenderRequest input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent putExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, input);
            IIX0o.oO(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public ActivityResult parseResult(int i, @oOoXoXO Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    /* loaded from: classes.dex */
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@OOXIXo Context context, @OOXIXo Uri input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Uri input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            IIX0o.oO(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        public final Boolean parseResult(int i, @oOoXoXO Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    @XX({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n1#2:963\n*E\n"})
    /* loaded from: classes.dex */
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@OOXIXo Context context, @oOoXoXO Void r2) {
            IIX0o.x0xO0oo(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @oOoXoXO Void r2) {
            IIX0o.x0xO0oo(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
    /* loaded from: classes.dex */
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @oOoXoXO
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@OOXIXo Context context, @OOXIXo Uri input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @OOXIXo
        @CallSuper
        public Intent createIntent(@OOXIXo Context context, @OOXIXo Uri input) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(input, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            IIX0o.oO(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
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
