package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.sma.smartv3.ble.ProductManager;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class OnlineWatchFaceKt {
    public static final int getWatchFaceCategoryName(@OOXIXo Context mContext, int i) {
        IIX0o.x0xO0oo(mContext, "mContext");
        try {
            int identifier = mContext.getResources().getIdentifier("watch_face_category" + i, TypedValues.Custom.S_STRING, mContext.getPackageName());
            if (identifier == 0) {
                return ProductManager.f20544oIX0oI.x0();
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return ProductManager.f20544oIX0oI.x0();
        }
    }
}
