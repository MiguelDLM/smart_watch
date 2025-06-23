package androidx.activity.result;

import OXOo.OOXIXo;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.IIX0o;

public final class PickVisualMediaRequestKt {
    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return IIX0o.x0xO0oo(visualMediaType, "mediaType");
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        return IIX0o.x0xO0oo(visualMediaType, "mediaType");
    }

    @OOXIXo
    public static final PickVisualMediaRequest PickVisualMediaRequest(@OOXIXo ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, @IntRange(from = 2) int i, boolean z, @OOXIXo ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        IIX0o.x0xO0oo(visualMediaType, "mediaType");
        IIX0o.x0xO0oo(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(visualMediaType).setMaxItems(i).setOrderedSelection(z).setDefaultTab(defaultTab).build();
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

    @OOXIXo
    public static final PickVisualMediaRequest PickVisualMediaRequest(long j, @OOXIXo ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, @IntRange(from = 2) int i, boolean z, @OOXIXo ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        IIX0o.x0xO0oo(visualMediaType, "mediaType");
        IIX0o.x0xO0oo(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(visualMediaType).setMaxItems(i).setOrderedSelection(z).setDefaultTab(defaultTab).setAccentColor(j).build();
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
