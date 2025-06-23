package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;

/* loaded from: classes9.dex */
public final class PercentageRating extends Rating {
    private static final int TYPE = 1;
    private final float percent;
    private static final String FIELD_PERCENT = Util.intToStringMaxRadix(1);
    public static final Bundleable.Creator<PercentageRating> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.oOoIIO0
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            PercentageRating fromBundle;
            fromBundle = PercentageRating.fromBundle(bundle);
            return fromBundle;
        }
    };

    public PercentageRating() {
        this.percent = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PercentageRating fromBundle(Bundle bundle) {
        boolean z = true;
        if (bundle.getInt(Rating.FIELD_RATING_TYPE, -1) != 1) {
            z = false;
        }
        Assertions.checkArgument(z);
        float f = bundle.getFloat(FIELD_PERCENT, -1.0f);
        if (f == -1.0f) {
            return new PercentageRating();
        }
        return new PercentageRating(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PercentageRating) || this.percent != ((PercentageRating) obj).percent) {
            return false;
        }
        return true;
    }

    public float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.percent));
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean isRated() {
        if (this.percent != -1.0f) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 1);
        bundle.putFloat(FIELD_PERCENT, this.percent);
        return bundle;
    }

    public PercentageRating(@FloatRange(from = 0.0d, to = 100.0d) float f) {
        Assertions.checkArgument(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.percent = f;
    }
}
