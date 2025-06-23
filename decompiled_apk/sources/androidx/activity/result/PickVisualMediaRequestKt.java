package androidx.activity.result;

import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import kotlin.DeprecationLevel;
import kotlin.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class PickVisualMediaRequestKt {
    @OOXIXo(level = DeprecationLevel.HIDDEN, message = "Superseded by PickVisualMediaRequest that takes an optional maxItems")
    public static final /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
        IIX0o.x0xO0oo(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType);
    }

    @OOXIXo(level = DeprecationLevel.HIDDEN, message = "Superseded by PickVisualMediaRequest that take optional isOrderedSelection and defaultTab")
    public static final /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i) {
        IIX0o.x0xO0oo(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        return PickVisualMediaRequest(visualMediaType, i);
    }

    @OXOo.OOXIXo
    public static final PickVisualMediaRequest PickVisualMediaRequest(@OXOo.OOXIXo ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i, boolean z, @OXOo.OOXIXo ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        IIX0o.x0xO0oo(mediaType, "mediaType");
        IIX0o.x0xO0oo(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).setOrderedSelection(z).setDefaultTab(defaultTab).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, boolean z, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType, i, z, defaultTab);
    }

    @OXOo.OOXIXo
    public static final PickVisualMediaRequest PickVisualMediaRequest(long j, @OXOo.OOXIXo ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i, boolean z, @OXOo.OOXIXo ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        IIX0o.x0xO0oo(mediaType, "mediaType");
        IIX0o.x0xO0oo(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).setOrderedSelection(z).setDefaultTab(defaultTab).setAccentColor(j).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(long j, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, boolean z, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType2 = visualMediaType;
        if ((i2 & 4) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        int i3 = i;
        boolean z2 = (i2 & 8) != 0 ? false : z;
        if ((i2 & 16) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(j, visualMediaType2, i3, z2, defaultTab);
    }
}
