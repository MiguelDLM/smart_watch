package com.alimm.tanx.ui.image.glide.load.engine.prefill;

import android.graphics.Bitmap;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    /* loaded from: classes.dex */
    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i) {
            this(i, i);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public Builder setWeight(int i) {
            if (i > 0) {
                this.weight = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 > 0) {
                this.width = i;
                this.height = i2;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    public PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        if (config != null) {
            this.width = i;
            this.height = i2;
            this.config = config;
            this.weight = i3;
            return;
        }
        throw new NullPointerException("Config must not be null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.height != preFillType.height || this.width != preFillType.width || this.weight != preFillType.weight || this.config != preFillType.config) {
            return false;
        }
        return true;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.config.hashCode() + (((this.width * 31) + this.height) * 31)) * 31) + this.weight;
    }

    public String toString() {
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("PreFillSize{width=");
        oIX0oI2.append(this.width);
        oIX0oI2.append(", height=");
        oIX0oI2.append(this.height);
        oIX0oI2.append(", config=");
        oIX0oI2.append(this.config);
        oIX0oI2.append(", weight=");
        oIX0oI2.append(this.weight);
        oIX0oI2.append('}');
        return oIX0oI2.toString();
    }
}
