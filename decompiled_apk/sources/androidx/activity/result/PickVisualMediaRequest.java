package androidx.activity.result;

import OXOo.OOXIXo;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class PickVisualMediaRequest {
    private long accentColor;
    private boolean isCustomAccentColorApplied;
    private boolean isOrderedSelection;

    @OOXIXo
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
    private int maxItems = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();

    @OOXIXo
    private ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;

    /* loaded from: classes.dex */
    public static final class Builder {
        private long accentColor;
        private boolean isCustomAccentColorApplied;
        private boolean isOrderedSelection;

        @OOXIXo
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        private int maxItems = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();

        @OOXIXo
        private ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;

        @OOXIXo
        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
            pickVisualMediaRequest.setMaxItems$activity_release(this.maxItems);
            pickVisualMediaRequest.setOrderedSelection$activity_release(this.isOrderedSelection);
            pickVisualMediaRequest.setDefaultTab$activity_release(this.defaultTab);
            pickVisualMediaRequest.setCustomAccentColorApplied$activity_release(this.isCustomAccentColorApplied);
            pickVisualMediaRequest.setAccentColor$activity_release(this.accentColor);
            return pickVisualMediaRequest;
        }

        @OOXIXo
        public final Builder setAccentColor(long j) {
            this.accentColor = j;
            this.isCustomAccentColorApplied = true;
            return this;
        }

        @OOXIXo
        public final Builder setDefaultTab(@OOXIXo ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
            IIX0o.x0xO0oo(defaultTab, "defaultTab");
            this.defaultTab = defaultTab;
            return this;
        }

        @OOXIXo
        public final Builder setMaxItems(@IntRange(from = 2) int i) {
            this.maxItems = i;
            return this;
        }

        @OOXIXo
        public final Builder setMediaType(@OOXIXo ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
            IIX0o.x0xO0oo(mediaType, "mediaType");
            this.mediaType = mediaType;
            return this;
        }

        @OOXIXo
        public final Builder setOrderedSelection(boolean z) {
            this.isOrderedSelection = z;
            return this;
        }
    }

    public final long getAccentColor() {
        return this.accentColor;
    }

    @OOXIXo
    public final ActivityResultContracts.PickVisualMedia.DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    @OOXIXo
    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final boolean isCustomAccentColorApplied() {
        return this.isCustomAccentColorApplied;
    }

    public final boolean isOrderedSelection() {
        return this.isOrderedSelection;
    }

    public final void setAccentColor$activity_release(long j) {
        this.accentColor = j;
    }

    public final void setCustomAccentColorApplied$activity_release(boolean z) {
        this.isCustomAccentColorApplied = z;
    }

    public final void setDefaultTab$activity_release(@OOXIXo ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        IIX0o.x0xO0oo(defaultTab, "<set-?>");
        this.defaultTab = defaultTab;
    }

    public final void setMaxItems$activity_release(int i) {
        this.maxItems = i;
    }

    public final void setMediaType$activity_release(@OOXIXo ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        IIX0o.x0xO0oo(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }

    public final void setOrderedSelection$activity_release(boolean z) {
        this.isOrderedSelection = z;
    }
}
