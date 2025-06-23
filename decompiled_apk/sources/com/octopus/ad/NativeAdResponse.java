package com.octopus.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import x0OxxIOxX.oIX0oI;

/* loaded from: classes11.dex */
public interface NativeAdResponse {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f18585I0Io = 4;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f18586II0xO0 = 2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f18587oIX0oI = 1;

    /* loaded from: classes11.dex */
    public enum a {
        OCTOPUS
    }

    /* loaded from: classes11.dex */
    public enum b {
        CONTENT,
        APP_INSTALL
    }

    String I0Io();

    String II0XooXoX();

    ArrayList<String> II0xO0();

    oIX0oI.oxoX IIXOooo();

    ArrayList<String> IXxxXO();

    oIX0oI.oxoX OOXIXo();

    List<? extends View> Oo();

    void OxI(ViewGroup viewGroup, int i, float f);

    View Oxx0IOOO(Context context, int i);

    String Oxx0xo();

    void OxxIIOOXO(ViewGroup viewGroup, xXoOI00O.oIX0oI oix0oi);

    Bitmap X0o0xo(Context context);

    a XO();

    void destroy();

    String getButtonText();

    X0xII0I.oIX0oI getComplianceInfo();

    String getDescription();

    Bitmap getIcon();

    String getIconUrl();

    Bitmap getImage();

    String getImageUrl();

    ArrayList<String> getImageUrls();

    int getInteractionType();

    String getLogoUrl();

    int getMaterialType();

    int getPictureHeight();

    int getPictureWidth();

    int getPrice();

    double getStarRating();

    String getTitle();

    boolean isVideo();

    HashMap<String, Object> o00();

    String oI0IIXIo();

    void oIX0oI(ViewGroup viewGroup, List<View> list, xXoOI00O.oIX0oI oix0oi);

    void oO(Bitmap bitmap);

    b oOoXoXO();

    void ooOOo0oXI(List<? extends View> list);

    void oxoX();

    void setIcon(Bitmap bitmap);

    Bitmap x0XOIxOo(Context context);

    void x0xO0oo(ViewGroup viewGroup, List<View> list, List<View> list2, xXoOI00O.oIX0oI oix0oi);

    View xoIox(Context context);

    boolean xoXoI();

    View xxIXOIIO(Context context);
}
