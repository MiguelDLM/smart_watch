package com.github.appintro.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.annotation.FontRes;
import androidx.core.content.res.ResourcesCompat;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class TypefaceContainer {
    private int typeFaceResource;

    @oOoXoXO
    private String typeFaceUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public TypefaceContainer() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TypefaceContainer copy$default(TypefaceContainer typefaceContainer, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = typefaceContainer.typeFaceUrl;
        }
        if ((i2 & 2) != 0) {
            i = typefaceContainer.typeFaceResource;
        }
        return typefaceContainer.copy(str, i);
    }

    public final void applyTo(@oOoXoXO final TextView textView) {
        if (textView != null && textView.getContext() != null) {
            if (this.typeFaceUrl == null && this.typeFaceResource == 0) {
                return;
            }
            ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() { // from class: com.github.appintro.internal.TypefaceContainer$applyTo$callback$1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                /* renamed from: onFontRetrievalFailed */
                public void lambda$callbackFailAsync$1(int i) {
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                /* renamed from: onFontRetrieved */
                public void lambda$callbackSuccessAsync$0(@OOXIXo Typeface typeface) {
                    IIX0o.x0xO0oo(typeface, "typeface");
                    textView.setTypeface(typeface);
                }
            };
            if (this.typeFaceResource != 0) {
                ResourcesCompat.getFont(textView.getContext(), this.typeFaceResource, fontCallback, null);
                return;
            }
            CustomFontCache customFontCache = CustomFontCache.INSTANCE;
            Context context = textView.getContext();
            IIX0o.oO(context, "textView.context");
            customFontCache.getFont(context, this.typeFaceUrl, fontCallback);
        }
    }

    @oOoXoXO
    public final String component1() {
        return this.typeFaceUrl;
    }

    public final int component2() {
        return this.typeFaceResource;
    }

    @OOXIXo
    public final TypefaceContainer copy(@oOoXoXO String str, @FontRes int i) {
        return new TypefaceContainer(str, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceContainer)) {
            return false;
        }
        TypefaceContainer typefaceContainer = (TypefaceContainer) obj;
        return IIX0o.Oxx0IOOO(this.typeFaceUrl, typefaceContainer.typeFaceUrl) && this.typeFaceResource == typefaceContainer.typeFaceResource;
    }

    public final int getTypeFaceResource() {
        return this.typeFaceResource;
    }

    @oOoXoXO
    public final String getTypeFaceUrl() {
        return this.typeFaceUrl;
    }

    public int hashCode() {
        String str = this.typeFaceUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.typeFaceResource;
    }

    public final void setTypeFaceResource(int i) {
        this.typeFaceResource = i;
    }

    public final void setTypeFaceUrl(@oOoXoXO String str) {
        this.typeFaceUrl = str;
    }

    @OOXIXo
    public String toString() {
        return "TypefaceContainer(typeFaceUrl=" + ((Object) this.typeFaceUrl) + ", typeFaceResource=" + this.typeFaceResource + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TypefaceContainer(@oOoXoXO String str, @FontRes int i) {
        this.typeFaceUrl = str;
        this.typeFaceResource = i;
    }

    public /* synthetic */ TypefaceContainer(String str, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i);
    }
}
