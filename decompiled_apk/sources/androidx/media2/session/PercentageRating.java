package androidx.media2.session;

import androidx.core.util.ObjectsCompat;
import androidx.media2.common.Rating;

/* loaded from: classes.dex */
public final class PercentageRating implements Rating {
    private static final float RATING_NOT_RATED = -1.0f;
    float mPercent;

    public PercentageRating() {
        this.mPercent = -1.0f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PercentageRating) || this.mPercent != ((PercentageRating) obj).mPercent) {
            return false;
        }
        return true;
    }

    public float getPercentRating() {
        return this.mPercent;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Float.valueOf(this.mPercent));
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        if (this.mPercent != -1.0f) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("PercentageRating: ");
        if (isRated()) {
            str = "percentage=" + this.mPercent;
        } else {
            str = "unrated";
        }
        sb.append(str);
        return sb.toString();
    }

    public PercentageRating(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            this.mPercent = f;
            return;
        }
        throw new IllegalArgumentException("percent should be in the rage of [0, 100]");
    }
}
