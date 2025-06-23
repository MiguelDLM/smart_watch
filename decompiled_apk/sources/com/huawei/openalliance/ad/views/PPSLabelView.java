package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fw;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.ca;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class PPSLabelView extends TextView {
    public static final String Code = " ";
    private static final String F = "PPSLabelView";
    public static final int V = 4;
    protected boolean B;
    protected boolean C;
    private boolean D;
    protected WeakReference<fw> I;
    private AdContentData L;
    protected a S;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17424a;
    private Drawable b;
    private View.OnClickListener c;

    /* loaded from: classes10.dex */
    public interface a {
        void Code(fw fwVar, int[] iArr, int[] iArr2);
    }

    /* loaded from: classes10.dex */
    public static class b implements an {
        private final WeakReference<PPSLabelView> Code;
        private String V;

        public b(PPSLabelView pPSLabelView, String str) {
            this.Code = new WeakReference<>(pPSLabelView);
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.utils.an
        public void Code() {
            fb.V(PPSLabelView.F, "start - dspLogo load failed");
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSLabelView pPSLabelView = (PPSLabelView) b.this.Code.get();
                    if (pPSLabelView != null) {
                        pPSLabelView.setTextWhenImgLoadFail(b.this.V);
                    }
                }
            });
        }

        @Override // com.huawei.openalliance.ad.utils.an
        public void Code(String str, final Drawable drawable) {
            fb.V(PPSLabelView.F, "start - dspLogo load onSuccess");
            if (drawable != null) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSLabelView pPSLabelView = (PPSLabelView) b.this.Code.get();
                        if (pPSLabelView != null) {
                            pPSLabelView.Code(b.this.V, drawable);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements RemoteCallResultCallback<String> {
        private final WeakReference<PPSLabelView> Code;
        private String V;

        public c(PPSLabelView pPSLabelView, String str) {
            this.Code = new WeakReference<>(pPSLabelView);
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            PPSLabelView pPSLabelView = this.Code.get();
            if (pPSLabelView != null) {
                if (TextUtils.isEmpty(data) || !data.startsWith(ca.CONTENT.toString())) {
                    bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLabelView pPSLabelView2 = (PPSLabelView) c.this.Code.get();
                            if (pPSLabelView2 != null) {
                                pPSLabelView2.setTextWhenImgLoadFail(c.this.V);
                            }
                        }
                    });
                    return;
                }
                SourceParam sourceParam = new SourceParam();
                sourceParam.V(false);
                sourceParam.I(true);
                sourceParam.I(data);
                z.Code(pPSLabelView.getContext(), sourceParam, new b(pPSLabelView, this.V));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface d {
        void Code(View view);
    }

    public PPSLabelView(Context context) {
        super(context);
        this.D = true;
        this.B = false;
        this.C = false;
        this.f17424a = true;
        this.c = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar;
                WeakReference<fw> weakReference = PPSLabelView.this.I;
                if (weakReference != null) {
                    final fw fwVar = weakReference.get();
                    if (fwVar == null) {
                        fb.I(PPSLabelView.F, "adView is null");
                        return;
                    }
                    final int[] Z = bc.Z(view);
                    final int[] B = bc.B(view);
                    if (w.Code(Z, 2) && w.Code(B, 2) && (aVar = PPSLabelView.this.S) != null) {
                        fb.V(PPSLabelView.F, "adLabelClickListener %s", aVar);
                        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PPSLabelView.this.S.Code(fwVar, Z, B);
                            }
                        });
                    }
                }
            }
        };
        Code(context);
    }

    private SpannableStringBuilder Code(SpannableString spannableString) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        ImageSpan clickImageSpanRight = getClickImageSpanRight();
        if (clickImageSpanRight != null) {
            spannableStringBuilder.setSpan(clickImageSpanRight, spannableString.length() - 1, spannableString.length(), 33);
        }
        return spannableStringBuilder;
    }

    private ImageSpan getClickImageSpanRight() {
        try {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_chevron_right);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (!bc.I()) {
                return new com.huawei.openalliance.ad.views.b(drawable, 2, w.V(getContext(), 4.0f), 0);
            }
            return new com.huawei.openalliance.ad.views.b(getContext(), z.V(drawable), 2, w.V(getContext(), 4.0f), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String getDefaultAdSign() {
        return this.f17424a ? getResources().getString(R.string.hiad_ad_label_new) : "";
    }

    public void V(AdSource adSource, String str) {
        if (adSource != null && !TextUtils.isEmpty(str)) {
            Code(adSource, str);
        } else {
            fb.V(F, "setTextWithDspInfo, use default adSign");
            setClick(new SpannableStringBuilder(getText()));
        }
    }

    public void setAdLabelClickListener(a aVar) {
        fb.V(F, "setAdLabelClickListener %s", aVar);
        this.S = aVar;
    }

    public void setClick(SpannableStringBuilder spannableStringBuilder) {
        if (!this.C && !this.B) {
            setText(spannableStringBuilder);
            return;
        }
        spannableStringBuilder.append(" ");
        setText(Code(new SpannableString(spannableStringBuilder)));
        setOnClickListener(this.c);
    }

    public void setDataAndRefreshUi(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.L = adContentData;
        if (adContentData.S() != null) {
            this.D = "2".equalsIgnoreCase(adContentData.S().g());
        }
        if (this.D) {
            return;
        }
        setVisibility(8);
    }

    public void setTextForAppDetailView(AdSource adSource) {
        if (adSource == null) {
            fb.V(F, "setTextWithDspInfo, use default adSign");
        } else {
            this.f17424a = false;
            Code(adSource, "");
        }
    }

    public void setTextWhenImgLoadFail(String str) {
        String defaultAdSign = getDefaultAdSign();
        if (TextUtils.isEmpty(str)) {
            str = defaultAdSign;
        }
        if (TextUtils.isEmpty(str) && !this.f17424a) {
            setVisibility(8);
        }
        setText(str);
        setClick(new SpannableStringBuilder(getText()));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.D) {
            i = 8;
        }
        super.setVisibility(i);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = true;
        this.B = false;
        this.C = false;
        this.f17424a = true;
        this.c = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar;
                WeakReference<fw> weakReference = PPSLabelView.this.I;
                if (weakReference != null) {
                    final fw fwVar = weakReference.get();
                    if (fwVar == null) {
                        fb.I(PPSLabelView.F, "adView is null");
                        return;
                    }
                    final int[] Z = bc.Z(view);
                    final int[] B = bc.B(view);
                    if (w.Code(Z, 2) && w.Code(B, 2) && (aVar = PPSLabelView.this.S) != null) {
                        fb.V(PPSLabelView.F, "adLabelClickListener %s", aVar);
                        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PPSLabelView.this.S.Code(fwVar, Z, B);
                            }
                        });
                    }
                }
            }
        };
        Code(context);
    }

    public ImageSpan Code(Drawable drawable, boolean z) {
        Bitmap Code2 = z.Code(drawable);
        if (Code2 == null) {
            fb.V(F, "originImage bitmap is null");
            return null;
        }
        float textSize = getTextSize();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(Code2, Math.round(textSize), Math.round(textSize), false));
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        return new com.huawei.openalliance.ad.views.b(bitmapDrawable, 2, 0, z ? w.V(getContext(), 4.0f) : 0);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = true;
        this.B = false;
        this.C = false;
        this.f17424a = true;
        this.c = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar;
                WeakReference<fw> weakReference = PPSLabelView.this.I;
                if (weakReference != null) {
                    final fw fwVar = weakReference.get();
                    if (fwVar == null) {
                        fb.I(PPSLabelView.F, "adView is null");
                        return;
                    }
                    final int[] Z = bc.Z(view);
                    final int[] B = bc.B(view);
                    if (w.Code(Z, 2) && w.Code(B, 2) && (aVar = PPSLabelView.this.S) != null) {
                        fb.V(PPSLabelView.F, "adLabelClickListener %s", aVar);
                        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PPSLabelView.this.S.Code(fwVar, Z, B);
                            }
                        });
                    }
                }
            }
        };
        Code(context);
    }

    private void Code(Context context) {
        try {
            this.b = context.getResources().getDrawable(R.drawable.hiad_default_dsp_logo);
        } catch (Throwable unused) {
            fb.I(F, "init error");
        }
    }

    public void Code(AdSource adSource, String str) {
        if (adSource == null) {
            return;
        }
        String V2 = ay.V(adSource.Code()) == null ? "" : ay.V(adSource.Code());
        if (str == null) {
            str = "";
        }
        String str2 = V2 + str;
        String V3 = adSource.V();
        if (TextUtils.isEmpty(V2) && TextUtils.isEmpty(V3)) {
            fb.V(F, "displayTextWithDspInfo, use default adSign");
        } else if (TextUtils.isEmpty(V2) || !TextUtils.isEmpty(V3)) {
            Code(str2, V3);
        } else {
            fb.V(F, "displayTextWithDspInfo, use dspNameWithAdSign");
            setText(str2);
        }
    }

    public void Code(a aVar, fw fwVar, AdContentData adContentData, boolean z) {
        this.S = aVar;
        this.L = adContentData;
        this.C = z;
        this.I = new WeakReference<>(fwVar);
    }

    public void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            String defaultAdSign = getDefaultAdSign();
            if (TextUtils.isEmpty(str)) {
                str = defaultAdSign;
            }
            boolean z = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan Code2 = Code(drawable, z);
            if (Code2 != null) {
                spannableStringBuilder.setSpan(Code2, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            fb.I(F, "setTextWhenImgLoaded error");
        }
    }

    public void Code(String str, String str2) {
        fb.V(F, "loadAndSetDspInfo, start");
        Code(str, this.b);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bb.E, str2);
            com.huawei.openalliance.ad.ipc.g.V(getContext()).Code(s.i, jSONObject.toString(), new c(this, str), String.class);
        } catch (Throwable unused) {
            fb.I(F, "loadAndSetDspInfo error");
        }
    }

    public void Code(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            fb.V(F, "dspInfo all empty or logo2Text is empty");
            fb.V(F, "setTextWithDspInfo, use default adSign");
            spannableStringBuilder = new SpannableStringBuilder(getText());
        } else {
            if (str == null) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            String str4 = str + str3;
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str2)) {
                fb.V(F, "setTextWithDspInfo, use default adSign");
                spannableStringBuilder = new SpannableStringBuilder(getText());
            } else if (TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str2)) {
                Code(str4, str2);
                return;
            } else {
                fb.V(F, "setTextWithDspInfo, use dspNameWithAdSign");
                setText(str4);
                spannableStringBuilder = new SpannableStringBuilder(getText());
            }
        }
        setClick(spannableStringBuilder);
    }

    public boolean Code() {
        return this.D;
    }
}
