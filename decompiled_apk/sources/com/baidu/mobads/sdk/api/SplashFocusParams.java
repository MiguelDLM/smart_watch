package com.baidu.mobads.sdk.api;

import XIXIX.OOXIXo;
import com.baidu.mobads.sdk.internal.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SplashFocusParams {
    private final Builder mBuilder;

    /* loaded from: classes7.dex */
    public static class Builder {
        private int iconRightMarginDp = 15;
        private int iconBottomMarginDp = 95;
        private int iconSizeDp = 44;
        private boolean autoAnimOffset = true;
        private int animOffsetPx = 0;
        private double darkAlpha = OOXIXo.f3760XO;

        public SplashFocusParams build() {
            return new SplashFocusParams(this);
        }

        @Deprecated
        public Builder setAnimOffsetPx(int i) {
            this.autoAnimOffset = false;
            this.animOffsetPx = i;
            return this;
        }

        public Builder setDarkAlpha(double d) {
            this.darkAlpha = d;
            return this;
        }

        public Builder setIconBottomMarginDp(int i) {
            this.iconBottomMarginDp = i;
            return this;
        }

        public Builder setIconRightMarginDp(int i) {
            this.iconRightMarginDp = i;
            return this;
        }

        public Builder setIconSizeDp(int i) {
            this.iconSizeDp = i;
            return this;
        }
    }

    public SplashFocusParams(Builder builder) {
        this.mBuilder = builder;
    }

    public JSONObject getFocusParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
            jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
            jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
            if (!this.mBuilder.autoAnimOffset) {
                jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
            }
            jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        return jSONObject;
    }
}
