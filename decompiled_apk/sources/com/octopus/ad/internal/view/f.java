package com.octopus.ad.internal.view;

import XXO0.oIX0oI;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.view.AdWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.spi.LocationInfo;
import x0.I0oOoX;
import x0.oxxXoxO;
import x0.x0o;

@SuppressLint({"InlinedApi"})
/* loaded from: classes11.dex */
public class f {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String[] f19012Oxx0xo = {"default", XXooOOI.oIX0oI.f4116Oxx0IOOO};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f19014II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f19019Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f19020X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f19021XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final AdWebView f19022oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Activity f19024oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public ViewGroup f19025ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f19027x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f19028x0xO0oo;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f19030xxIXOIIO;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f19015II0xO0 = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f19013I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f19026oxoX = false;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f19029xoIox = false;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f19017OOXIXo = false;

    /* renamed from: oO, reason: collision with root package name */
    public int[] f19023oO = new int[4];

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f19018Oo = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public XO f19016IXxxXO = null;

    /* loaded from: classes11.dex */
    public class I0Io implements DialogInterface.OnClickListener {
        public I0Io() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements DialogInterface.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f19033XO;

        public II0xO0(String str) {
            this.f19033XO = str;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x00ca
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
            */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v31 */
        /* JADX WARN: Type inference failed for: r7v34, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v35 */
        /* JADX WARN: Type inference failed for: r7v36 */
        /* JADX WARN: Type inference failed for: r7v37, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r7v38 */
        /* JADX WARN: Type inference failed for: r7v39 */
        /* JADX WARN: Type inference failed for: r7v40 */
        /* JADX WARN: Type inference failed for: r7v41 */
        /* JADX WARN: Type inference failed for: r7v42, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v44 */
        /* JADX WARN: Type inference failed for: r7v45 */
        /* JADX WARN: Type inference failed for: r7v46 */
        /* JADX WARN: Type inference failed for: r7v48 */
        /* JADX WARN: Type inference failed for: r7v60 */
        /* JADX WARN: Type inference failed for: r7v61 */
        /* JADX WARN: Type inference failed for: r7v62 */
        /* JADX WARN: Type inference failed for: r7v65 */
        /* JADX WARN: Type inference failed for: r7v66 */
        /* JADX WARN: Type inference failed for: r7v67 */
        /* JADX WARN: Type inference failed for: r7v68 */
        /* JADX WARN: Type inference failed for: r7v69 */
        @Override // android.content.DialogInterface.OnClickListener
        @android.annotation.SuppressLint({"NewApi"})
        public void onClick(android.content.DialogInterface r7, int r8) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.view.f.II0xO0.onClick(android.content.DialogInterface, int):void");
        }
    }

    /* loaded from: classes11.dex */
    public enum a {
        top_left,
        top_right,
        center,
        bottom_left,
        bottom_right,
        top_center,
        bottom_center
    }

    /* loaded from: classes11.dex */
    public enum b {
        STARTING_DEFAULT,
        STARTING_EXPANDED
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements AdWebView.II0XooXoX {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ AdActivity.b f19037II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ boolean f19038oIX0oI;

        public oIX0oI(boolean z, AdActivity.b bVar) {
            this.f19038oIX0oI = z;
            this.f19037II0xO0 = bVar;
        }

        @Override // com.octopus.ad.internal.view.AdWebView.II0XooXoX
        public void a() {
            if (f.this.Oo() != null) {
                f.this.f19016IXxxXO.xxIXOIIO(f.this.Oo(), this.f19038oIX0oI, this.f19037II0xO0);
                AdViewImpl.setMRAIDFullscreenListener(null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f19039oIX0oI;

        static {
            int[] iArr = new int[AdActivity.b.values().length];
            f19039oIX0oI = iArr;
            try {
                iArr[AdActivity.b.landscape.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19039oIX0oI[AdActivity.b.portrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19039oIX0oI[AdActivity.b.none.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(AdWebView adWebView) {
        this.f19022oIX0oI = adWebView;
    }

    public void I0Io() {
        if (!this.f19013I0Io && !this.f19026oxoX && !this.f19018Oo) {
            if (this.f19022oIX0oI.f18916Oo.xoxXI()) {
                this.f19022oIX0oI.f18916Oo.getAdDispatcher().a();
                Activity activity = (Activity) this.f19022oIX0oI.getContextFromMutableContext();
                if (activity != null && !activity.isFinishing() && (activity instanceof AdActivity)) {
                    activity.finish();
                    return;
                }
                return;
            }
            this.f19022oIX0oI.O0xOxO();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f19022oIX0oI.getLayoutParams());
        layoutParams.height = this.f19021XO;
        layoutParams.width = this.f19020X0o0xo;
        if (this.f19022oIX0oI.f18916Oo.getMediaType().equals(l.BANNER)) {
            layoutParams.gravity = this.f19019Oxx0IOOO;
        } else {
            layoutParams.gravity = 17;
        }
        this.f19022oIX0oI.setLayoutParams(layoutParams);
        this.f19022oIX0oI.XxX0x0xxx();
        this.f19022oIX0oI.xoXoI("javascript:window.mraid.util.stateChangeEvent('default');");
        if (!this.f19022oIX0oI.f18916Oo.xoxXI() && !this.f19018Oo) {
            this.f19022oIX0oI.f18916Oo.getAdDispatcher().a();
        }
        Activity activity2 = (Activity) this.f19022oIX0oI.getContextFromMutableContext();
        if (activity2 != null) {
            activity2.setRequestedOrientation(-1);
        }
        this.f19013I0Io = false;
        this.f19026oxoX = false;
        this.f19016IXxxXO = null;
    }

    @SuppressLint({"NewApi"})
    public final void II0XooXoX(AdWebView adWebView) {
        if (x0XOIxOo(new Intent("android.intent.action.VIEW", Uri.parse("sms:5555555555")))) {
            xoIox(adWebView, "sms", true);
        }
        if (x0XOIxOo(new Intent("android.intent.action.VIEW", Uri.parse("tel:5555555555")))) {
            xoIox(adWebView, "tel", true);
        }
        if (x0XOIxOo(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI))) {
            xoIox(adWebView, "calendar", true);
            this.f19017OOXIXo = true;
        } else if (x0XOIxOo(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))) {
            xoIox(adWebView, "calendar", true);
            this.f19017OOXIXo = true;
            oxxXoxO.f33767OOXIXo = true;
        }
        if (this.f19022oIX0oI.getContext().getPackageManager().checkPermission(g.j, this.f19022oIX0oI.getContext().getPackageName()) == 0) {
            xoIox(adWebView, "storePicture", true);
            this.f19029xoIox = true;
        }
        xoIox(adWebView, "inlineVideo", true);
    }

    public final void IIXOooo(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.play_vide_no_uri));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        try {
            intent.setDataAndType(Uri.parse(URLDecoder.decode(str, "UTF-8")), "video/mp4");
            try {
                this.f19022oIX0oI.getContext().startActivity(intent);
                this.f19022oIX0oI.IIXOooo();
            } catch (ActivityNotFoundException unused) {
            }
        } catch (UnsupportedEncodingException unused2) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.unsupported_encoding));
        }
    }

    public final void IXxxXO(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = Uri.decode((String) next.second);
            }
        }
        if (!x0o.II0XooXoX(str)) {
            this.f19022oIX0oI.oI0IIXIo(str);
            this.f19022oIX0oI.IIXOooo();
        }
    }

    public final void O0xOxO(ArrayList<Pair<String, String>> arrayList) {
        Activity activity;
        AdActivity.b bVar = AdActivity.b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i = 1;
        boolean z = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("allow_orientation_change")) {
                z = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                bVar = oIX0oI((String) next.second);
            }
        }
        if (this.f19013I0Io || this.f19022oIX0oI.f18916Oo.xoxXI()) {
            AdWebView adWebView = this.f19022oIX0oI;
            if (adWebView.f18917OxI) {
                activity = Oo();
            } else {
                activity = (Activity) I0oOoX.OxxIIOOXO(adWebView);
            }
            if (z) {
                AdActivity.X0o0xo(activity);
                return;
            }
            int i2 = oxoX.f19039oIX0oI[bVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    i = 0;
                }
            } else {
                i = 2;
            }
            AdActivity.I0Io(activity, i);
        }
    }

    public void OOXIXo(String str, boolean z) {
        String replaceFirst = str.replaceFirst("mraid://", "");
        String[] split = replaceFirst.split("\\?");
        String replaceAll = split[0].replaceAll("/", "");
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (split.length > 1) {
            for (String str2 : replaceFirst.substring(replaceFirst.indexOf(LocationInfo.NA) + 1).split("&")) {
                String[] split2 = str2.split("=");
                if (split2.length >= 2 && !x0o.II0XooXoX(split2[1]) && !"undefined".equals(split2[1])) {
                    arrayList.add(new Pair<>(split2[0], split2[1]));
                }
            }
        }
        if (replaceAll.equals("expand")) {
            if (z) {
                x0xO0oo(arrayList);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, replaceFirst));
                return;
            }
        }
        if (replaceAll.equals("close")) {
            I0Io();
            return;
        }
        if (replaceAll.equals("resize")) {
            if (z) {
                X0IIOO(arrayList);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, replaceFirst));
                return;
            }
        }
        if (replaceAll.equals("setOrientationProperties")) {
            O0xOxO(arrayList);
            return;
        }
        if (this.f19017OOXIXo && replaceAll.equals("createCalendarEvent")) {
            if (z) {
                o00(arrayList);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, replaceFirst));
                return;
            }
        }
        if (replaceAll.equals("playVideo")) {
            if (z) {
                IIXOooo(arrayList);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, replaceFirst));
                return;
            }
        }
        if (this.f19029xoIox && replaceAll.equals("storePicture")) {
            if (z) {
                oI0IIXIo(arrayList);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, replaceFirst));
                return;
            }
        }
        if (replaceAll.equals("open")) {
            if (z) {
                IXxxXO(arrayList);
                return;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.no_user_interaction, replaceFirst));
                return;
            }
        }
        if (replaceAll.equals("setUseCustomClose")) {
            oOoXoXO(arrayList);
        } else {
            if (replaceAll.equals("enable")) {
                return;
            }
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.unsupported_mraid, replaceAll));
        }
    }

    public Activity Oo() {
        return this.f19024oOoXoXO;
    }

    public final void OxI() {
        if (this.f19022oIX0oI.getContextFromMutableContext() instanceof Activity) {
            int[] Oo2 = I0oOoX.Oo((Activity) this.f19022oIX0oI.getContextFromMutableContext());
            this.f19014II0XooXoX = Oo2[0];
            this.f19030xxIXOIIO = Oo2[1];
            this.f19022oIX0oI.xoXoI("javascript:window.mraid.util.setScreenSize(" + this.f19014II0XooXoX + ", " + this.f19030xxIXOIIO + oIX0oI.I0Io.f4095I0Io);
        }
    }

    public void Oxx0IOOO(ViewGroup viewGroup) {
        this.f19025ooOOo0oXI = viewGroup;
    }

    public ViewGroup Oxx0xo() {
        return this.f19025ooOOo0oXI;
    }

    public final void OxxIIOOXO() {
        Activity activity = (Activity) this.f19022oIX0oI.getContextFromMutableContext();
        this.f19022oIX0oI.getLocationOnScreen(r2);
        int[] iArr = {0, iArr[1] - activity.getWindow().findViewById(android.R.id.content).getTop()};
        this.f19022oIX0oI.measure(0, 0);
        int[] iArr2 = {this.f19022oIX0oI.getMeasuredWidth(), this.f19022oIX0oI.getMeasuredHeight()};
        I0oOoX.II0xO0(activity, iArr2);
        this.f19022oIX0oI.xoXoI(String.format("javascript:window.mraid.util.setDefaultPosition(%d, %d, %d, %d)", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1])));
    }

    public final void X0IIOO(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i = -1;
        String str = "top-right";
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                if (((String) next.first).equals(IAdInterListener.AdReqParam.WIDTH)) {
                    i = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals(IAdInterListener.AdReqParam.HEIGHT)) {
                    i2 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_x")) {
                    i3 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_y")) {
                    i4 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("custom_close_position")) {
                    str = (String) next.second;
                } else if (((String) next.first).equals("allow_offscreen")) {
                    z = Boolean.parseBoolean((String) next.second);
                }
            } catch (NumberFormatException unused) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.number_format));
                return;
            }
        }
        if (i > this.f19014II0XooXoX && i2 > this.f19030xxIXOIIO) {
            this.f19022oIX0oI.xoXoI("javascript:mraid.util.errorEvent('Resize called with resizeProperties larger than the screen.', 'mraid.resize()')");
            return;
        }
        a aVar = a.top_right;
        try {
            aVar = a.valueOf(str.replace('-', '_'));
        } catch (IllegalArgumentException unused2) {
        }
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        boolean z2 = z;
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.oOoXoXO(R.string.resize, i5, i6, i7, i8, str, z2));
        this.f19022oIX0oI.Xo0(i5, i6, i7, i8, aVar, z2);
        this.f19022oIX0oI.IIXOooo();
        this.f19022oIX0oI.xoXoI("javascript:window.mraid.util.stateChangeEvent('resized');");
        this.f19026oxoX = true;
    }

    public void X0o0xo(int i, int i2, int i3, int i4) {
        int[] iArr = this.f19023oO;
        if (iArr[0] == i && iArr[1] == i2 && iArr[2] == i3 && iArr[3] == i4) {
            return;
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        Activity activity = (Activity) this.f19022oIX0oI.getContextFromMutableContext();
        int[] iArr2 = {i, i2 - activity.getWindow().findViewById(android.R.id.content).getTop(), i3, i4};
        I0oOoX.II0xO0(activity, iArr2);
        int i5 = iArr2[0];
        int i6 = iArr2[1];
        int i7 = iArr2[2];
        int i8 = iArr2[3];
        this.f19022oIX0oI.xoXoI(String.format("javascript:window.mraid.util.setCurrentPosition(%d, %d, %d, %d)", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)));
        this.f19022oIX0oI.xoXoI(String.format("javascript:window.mraid.util.sizeChangeEvent(%d, %d)", Integer.valueOf(i7), Integer.valueOf(i8)));
    }

    public void XO(Activity activity) {
        this.f19024oOoXoXO = activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o00(java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1f
            int r0 = r2.size()     // Catch: java.io.UnsupportedEncodingException -> L1e
            if (r0 <= 0) goto L1f
            r0 = 0
            java.lang.Object r2 = r2.get(r0)     // Catch: java.io.UnsupportedEncodingException -> L1e
            android.util.Pair r2 = (android.util.Pair) r2     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.Object r2 = r2.second     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r0)     // Catch: java.io.UnsupportedEncodingException -> L1e
            x0.oxxXoxO r2 = x0.oxxXoxO.oIX0oI(r2)     // Catch: java.io.UnsupportedEncodingException -> L1e
            goto L20
        L1e:
            return
        L1f:
            r2 = 0
        L20:
            if (r2 == 0) goto L44
            android.content.Intent r2 = r2.X0o0xo()     // Catch: android.content.ActivityNotFoundException -> L44
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r2.setFlags(r0)     // Catch: android.content.ActivityNotFoundException -> L44
            com.octopus.ad.internal.view.AdWebView r0 = r1.f19022oIX0oI     // Catch: android.content.ActivityNotFoundException -> L44
            android.content.Context r0 = r0.getContext()     // Catch: android.content.ActivityNotFoundException -> L44
            r0.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L44
            com.octopus.ad.internal.view.AdWebView r2 = r1.f19022oIX0oI     // Catch: android.content.ActivityNotFoundException -> L44
            r2.IIXOooo()     // Catch: android.content.ActivityNotFoundException -> L44
            java.lang.String r2 = com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo     // Catch: android.content.ActivityNotFoundException -> L44
            int r0 = com.octopus.ad.R.string.create_calendar_event     // Catch: android.content.ActivityNotFoundException -> L44
            java.lang.String r0 = com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(r0)     // Catch: android.content.ActivityNotFoundException -> L44
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(r2, r0)     // Catch: android.content.ActivityNotFoundException -> L44
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.view.f.o00(java.util.ArrayList):void");
    }

    public final void oI0IIXIo(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.store_picture_error));
            return;
        }
        String decode = Uri.decode(str);
        AlertDialog.Builder builder = new AlertDialog.Builder(I0oOoX.OxxIIOOXO(this.f19022oIX0oI));
        builder.setTitle(R.string.store_picture_title);
        builder.setMessage(R.string.store_picture_message);
        builder.setPositiveButton(R.string.store_picture_accept, new II0xO0(decode));
        builder.setNegativeButton(R.string.store_picture_decline, new I0Io());
        builder.create().show();
    }

    public final AdActivity.b oIX0oI(String str) {
        AdActivity.b bVar = AdActivity.b.none;
        if (str.equals("landscape")) {
            return AdActivity.b.landscape;
        }
        if (str.equals("portrait")) {
            return AdActivity.b.portrait;
        }
        return bVar;
    }

    public void oO() {
        boolean oo2 = this.f19022oIX0oI.oo();
        if (this.f19027x0XOIxOo != oo2) {
            ooOOo0oXI(oo2);
        }
    }

    public void oOoXoXO(ArrayList<Pair<String, String>> arrayList) {
        this.f19022oIX0oI.setMRAIDUseCustomClose(Boolean.parseBoolean((String) arrayList.get(0).second));
    }

    public void ooOOo0oXI(boolean z) {
        if (!this.f19015II0xO0) {
            return;
        }
        this.f19027x0XOIxOo = z;
        this.f19022oIX0oI.xoXoI("javascript:window.mraid.util.setIsViewable(" + z + oIX0oI.I0Io.f4095I0Io);
    }

    public void oxoX(int i) {
        if (this.f19028x0xO0oo != i) {
            this.f19028x0xO0oo = i;
            xoXoI();
            OxI();
        }
    }

    public boolean x0XOIxOo(Intent intent) {
        if (this.f19022oIX0oI.getContext().getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            return false;
        }
        return true;
    }

    public void x0xO0oo(ArrayList<Pair<String, String>> arrayList) {
        AdActivity.b bVar = AdActivity.b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        AdActivity.b bVar2 = bVar;
        int i = -1;
        int i2 = -1;
        boolean z = false;
        boolean z2 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals(IAdInterListener.AdReqParam.WIDTH)) {
                try {
                    i = Integer.parseInt((String) next.second);
                } catch (NumberFormatException unused) {
                }
            } else if (((String) next.first).equals(IAdInterListener.AdReqParam.HEIGHT)) {
                i2 = Integer.parseInt((String) next.second);
            } else if (((String) next.first).equals("useCustomClose")) {
                z = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("url")) {
                str = Uri.decode((String) next.second);
            } else if (((String) next.first).equals("allow_orientation_change")) {
                z2 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                bVar2 = oIX0oI((String) next.second);
            }
        }
        if (!x0o.II0XooXoX(str)) {
            try {
                XO xo2 = new XO(this.f19022oIX0oI.f18916Oo, this);
                this.f19016IXxxXO = xo2;
                xo2.ooOOo0oXI(str);
                this.f19022oIX0oI.f18916Oo.OxI(this.f19016IXxxXO.getMRAIDImplementation(), z, new oIX0oI(z2, bVar2));
            } catch (Exception e) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Exception initializing the redirect webview: " + e.getMessage());
            }
        } else {
            this.f19022oIX0oI.II0XooXoX(i, i2, z, this, z2, bVar2);
        }
        this.f19022oIX0oI.xoXoI("javascript:window.mraid.util.stateChangeEvent('expanded');");
        this.f19013I0Io = true;
        if (!this.f19022oIX0oI.f18916Oo.xoxXI()) {
            this.f19022oIX0oI.f18916Oo.getAdDispatcher().b();
        }
    }

    public final void xoIox(AdWebView adWebView, String str, boolean z) {
        adWebView.xoXoI(String.format("javascript:window.mraid.util.setSupports('%s', %s)", str, String.valueOf(z)));
    }

    public final void xoXoI() {
        if (this.f19022oIX0oI.getContextFromMutableContext() instanceof Activity) {
            Activity activity = (Activity) this.f19022oIX0oI.getContextFromMutableContext();
            int[] IXxxXO2 = I0oOoX.IXxxXO(activity);
            int i = IXxxXO2[0];
            int top = IXxxXO2[1] - activity.getWindow().findViewById(android.R.id.content).getTop();
            float f = activity.getResources().getDisplayMetrics().density;
            int i2 = (int) ((top / f) + 0.5f);
            int i3 = (int) ((i / f) + 0.5f);
            this.f19022oIX0oI.xoXoI("javascript:window.mraid.util.setMaxSize(" + i3 + ", " + i2 + oIX0oI.I0Io.f4095I0Io);
        }
    }

    public void xxIXOIIO(AdWebView adWebView, String str) {
        String str2;
        if (!this.f19015II0xO0) {
            if (this.f19022oIX0oI.f18916Oo.O0Xx()) {
                str2 = "inline";
            } else {
                str2 = MediationConstant.RIT_TYPE_INTERSTITIAL;
            }
            boolean equals = str.equals(f19012Oxx0xo[b.STARTING_EXPANDED.ordinal()]);
            this.f19018Oo = equals;
            this.f19022oIX0oI.f18917OxI = equals;
            adWebView.xoXoI("javascript:window.mraid.util.setPlacementType('" + str2 + "')");
            if (!this.f19018Oo) {
                II0XooXoX(adWebView);
                OxI();
                xoXoI();
                OxxIIOOXO();
            }
            this.f19022oIX0oI.IIX0o();
            adWebView.xoXoI("javascript:window.mraid.util.stateChangeEvent('" + str + "')");
            adWebView.xoXoI("javascript:window.mraid.util.readyEvent();");
            this.f19020X0o0xo = this.f19022oIX0oI.getLayoutParams().width;
            this.f19021XO = this.f19022oIX0oI.getLayoutParams().height;
            if (this.f19022oIX0oI.f18916Oo.getMediaType().equals(l.BANNER)) {
                this.f19019Oxx0IOOO = ((FrameLayout.LayoutParams) this.f19022oIX0oI.getLayoutParams()).gravity;
            }
            this.f19015II0xO0 = true;
            ooOOo0oXI(this.f19022oIX0oI.oo());
        }
    }
}
