package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import androidx.navigation.common.R;
import com.huawei.openalliance.ad.constant.bn;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import org.xmlpull.v1.XmlPullParserException;

@XX({"SMAP\nNavInflater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavInflater.kt\nandroidx/navigation/NavInflater\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TypedArray.kt\nandroidx/core/content/res/TypedArrayKt\n+ 4 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,365:1\n1#2:366\n232#3,3:367\n232#3,3:370\n232#3,3:373\n232#3,3:376\n55#4,6:379\n*S KotlinDebug\n*F\n+ 1 NavInflater.kt\nandroidx/navigation/NavInflater\n*L\n110#1:367,3\n128#1:370,3\n144#1:373,3\n261#1:376,3\n295#1:379,6\n*E\n"})
public final class NavInflater {
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String TAG_ACTION = "action";
    @OOXIXo
    private static final String TAG_ARGUMENT = "argument";
    @OOXIXo
    private static final String TAG_DEEP_LINK = "deepLink";
    @OOXIXo
    private static final String TAG_INCLUDE = "include";
    @OOXIXo
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    @OOXIXo
    private final Context context;
    @OOXIXo
    private final NavigatorProvider navigatorProvider;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final NavType<?> checkNavType$navigation_runtime_release(@OOXIXo TypedValue typedValue, @oOoXoXO NavType<?> navType, @OOXIXo NavType<?> navType2, @oOoXoXO String str, @OOXIXo String str2) throws XmlPullParserException {
            IIX0o.x0xO0oo(typedValue, "value");
            IIX0o.x0xO0oo(navType2, "expectedNavType");
            IIX0o.x0xO0oo(str2, "foundType");
            if (navType != null && navType != navType2) {
                throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
            } else if (navType == null) {
                return navType2;
            } else {
                return navType;
            }
        }

        private Companion() {
        }
    }

    public NavInflater(@OOXIXo Context context2, @OOXIXo NavigatorProvider navigatorProvider2) {
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(navigatorProvider2, "navigatorProvider");
        this.context = context2;
        this.navigatorProvider = navigatorProvider2;
    }

    private final void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        int depth;
        Context context2 = this.context;
        int[] iArr = R.styleable.NavAction;
        IIX0o.oO(iArr, "NavAction");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainStyledAttributes.getResourceId(R.styleable.NavAction_destination, 0), (NavOptions) null, (Bundle) null, 6, (IIXOooo) null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainStyledAttributes.getBoolean(R.styleable.NavAction_launchSingleTop, false));
        builder.setRestoreState(obtainStyledAttributes.getBoolean(R.styleable.NavAction_restoreState, false));
        builder.setPopUpTo(obtainStyledAttributes.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(R.styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(R.styleable.NavAction_popUpToSaveState, false));
        builder.setEnterAnim(obtainStyledAttributes.getResourceId(R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainStyledAttributes.getResourceId(R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainStyledAttributes.getResourceId(R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainStyledAttributes.getResourceId(R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && IIX0o.Oxx0IOOO(TAG_ARGUMENT, xmlResourceParser.getName())) {
                    inflateArgumentForBundle(resources, bundle, attributeSet, i);
                }
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.navigation.NavArgument inflateArgument(android.content.res.TypedArray r11, android.content.res.Resources r12, int r13) throws org.xmlpull.v1.XmlPullParserException {
        /*
            r10 = this;
            androidx.navigation.NavArgument$Builder r0 = new androidx.navigation.NavArgument$Builder
            r0.<init>()
            int r1 = androidx.navigation.common.R.styleable.NavArgument_nullable
            r2 = 0
            boolean r1 = r11.getBoolean(r1, r2)
            r0.setIsNullable(r1)
            java.lang.ThreadLocal<android.util.TypedValue> r1 = sTmpValue
            java.lang.Object r3 = r1.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L_0x0021
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r1.set(r3)
        L_0x0021:
            int r1 = androidx.navigation.common.R.styleable.NavArgument_argType
            java.lang.String r8 = r11.getString(r1)
            r1 = 0
            if (r8 == 0) goto L_0x0036
            androidx.navigation.NavType$Companion r4 = androidx.navigation.NavType.Companion
            java.lang.String r13 = r12.getResourcePackageName(r13)
            androidx.navigation.NavType r13 = r4.fromArgType(r8, r13)
            r6 = r13
            goto L_0x0037
        L_0x0036:
            r6 = r1
        L_0x0037:
            int r13 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue
            boolean r4 = r11.getValue(r13, r3)
            if (r4 == 0) goto L_0x0177
            androidx.navigation.NavType<java.lang.Integer> r1 = androidx.navigation.NavType.ReferenceType
            java.lang.String r4 = "' for "
            java.lang.String r5 = "unsupported value '"
            r7 = 16
            if (r6 != r1) goto L_0x0083
            int r11 = r3.resourceId
            if (r11 == 0) goto L_0x004f
            r2 = r11
            goto L_0x0057
        L_0x004f:
            int r11 = r3.type
            if (r11 != r7) goto L_0x005d
            int r11 = r3.data
            if (r11 != 0) goto L_0x005d
        L_0x0057:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x0177
        L_0x005d:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.CharSequence r13 = r3.string
            r12.append(r13)
            r12.append(r4)
            java.lang.String r13 = r6.getName()
            r12.append(r13)
            java.lang.String r13 = ". Must be a reference to a resource."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0083:
            int r9 = r3.resourceId
            if (r9 == 0) goto L_0x00c3
            if (r6 != 0) goto L_0x0091
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r6 = r1
            r1 = r11
            goto L_0x0177
        L_0x0091:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.CharSequence r13 = r3.string
            r12.append(r13)
            r12.append(r4)
            java.lang.String r13 = r6.getName()
            r12.append(r13)
            java.lang.String r13 = ". You must use a \""
            r12.append(r13)
            java.lang.String r13 = r1.getName()
            r12.append(r13)
            java.lang.String r13 = "\" type to reference other resources."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00c3:
            androidx.navigation.NavType<java.lang.String> r1 = androidx.navigation.NavType.StringType
            if (r6 != r1) goto L_0x00cd
            java.lang.String r1 = r11.getString(r13)
            goto L_0x0177
        L_0x00cd:
            int r11 = r3.type
            r13 = 3
            if (r11 == r13) goto L_0x0165
            r13 = 4
            if (r11 == r13) goto L_0x0151
            r13 = 5
            if (r11 == r13) goto L_0x0138
            r12 = 18
            if (r11 == r12) goto L_0x0123
            if (r11 < r7) goto L_0x010a
            r12 = 31
            if (r11 > r12) goto L_0x010a
            androidx.navigation.NavType<java.lang.Float> r7 = androidx.navigation.NavType.FloatType
            if (r6 != r7) goto L_0x00f8
            androidx.navigation.NavInflater$Companion r4 = Companion
            java.lang.String r9 = "float"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            int r11 = r3.data
            float r11 = (float) r11
            java.lang.Float r1 = java.lang.Float.valueOf(r11)
            goto L_0x0177
        L_0x00f8:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Integer> r7 = androidx.navigation.NavType.IntType
            java.lang.String r9 = "integer"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            int r11 = r3.data
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0177
        L_0x010a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "unsupported argument type "
            r12.append(r13)
            int r13 = r3.type
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0123:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Boolean> r7 = androidx.navigation.NavType.BoolType
            java.lang.String r9 = "boolean"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            int r11 = r3.data
            if (r11 == 0) goto L_0x0133
            r2 = 1
        L_0x0133:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            goto L_0x0177
        L_0x0138:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Integer> r7 = androidx.navigation.NavType.IntType
            java.lang.String r9 = "dimension"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            android.util.DisplayMetrics r11 = r12.getDisplayMetrics()
            float r11 = r3.getDimension(r11)
            int r11 = (int) r11
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0177
        L_0x0151:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Float> r7 = androidx.navigation.NavType.FloatType
            java.lang.String r9 = "float"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            float r11 = r3.getFloat()
            java.lang.Float r1 = java.lang.Float.valueOf(r11)
            goto L_0x0177
        L_0x0165:
            java.lang.CharSequence r11 = r3.string
            java.lang.String r11 = r11.toString()
            if (r6 != 0) goto L_0x0173
            androidx.navigation.NavType$Companion r12 = androidx.navigation.NavType.Companion
            androidx.navigation.NavType r6 = r12.inferFromValue(r11)
        L_0x0173:
            java.lang.Object r1 = r6.parseValue(r11)
        L_0x0177:
            if (r1 == 0) goto L_0x017c
            r0.setDefaultValue(r1)
        L_0x017c:
            if (r6 == 0) goto L_0x0181
            r0.setType(r6)
        L_0x0181:
            androidx.navigation.NavArgument r11 = r0.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflateArgument(android.content.res.TypedArray, android.content.res.Resources, int):androidx.navigation.NavArgument");
    }

    private final void inflateArgumentForBundle(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        IIX0o.oO(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string != null) {
            IIX0o.oO(string, "array.getString(R.stylea…uments must have a name\")");
            NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i);
            if (inflateArgument.isDefaultValuePresent()) {
                inflateArgument.putDefaultValue(string, bundle);
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateArgumentForDestination(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        IIX0o.oO(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string != null) {
            IIX0o.oO(string, "array.getString(R.stylea…uments must have a name\")");
            navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i));
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateDeepLink(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
        IIX0o.oO(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String string = obtainAttributes.getString(R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(R.styleable.NavDeepLink_mimeType);
        if ((string == null || string.length() == 0) && ((string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0))) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            String packageName = this.context.getPackageName();
            IIX0o.oO(packageName, "context.packageName");
            builder.setUriPattern(OxI.IIOIX(string, APPLICATION_ID_PLACEHOLDER, packageName, false, 4, (Object) null));
        }
        if (!(string2 == null || string2.length() == 0)) {
            String packageName2 = this.context.getPackageName();
            IIX0o.oO(packageName2, "context.packageName");
            builder.setAction(OxI.IIOIX(string2, APPLICATION_ID_PLACEHOLDER, packageName2, false, 4, (Object) null));
        }
        if (string3 != null) {
            String packageName3 = this.context.getPackageName();
            IIX0o.oO(packageName3, "context.packageName");
            builder.setMimeType(OxI.IIOIX(string3, APPLICATION_ID_PLACEHOLDER, packageName3, false, 4, (Object) null));
        }
        navDestination.addDeepLink(builder.build());
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        obtainAttributes.recycle();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062 A[Catch:{ Exception -> 0x0040, all -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0022 A[Catch:{ Exception -> 0x0040, all -> 0x003e }] */
    @android.annotation.SuppressLint({"ResourceType"})
    @OXOo.OOXIXo
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavGraph inflate(@androidx.annotation.NavigationRes int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.context
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            java.lang.String r2 = "res.getXml(graphResId)"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
            r2 = r1
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r2)
        L_0x0016:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0040 }
            r4 = 2
            if (r3 == r4) goto L_0x0020
            r5 = 1
            if (r3 != r5) goto L_0x0016
        L_0x0020:
            if (r3 != r4) goto L_0x0062
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = "res"
            kotlin.jvm.internal.IIX0o.oO(r0, r4)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = "attrs"
            kotlin.jvm.internal.IIX0o.oO(r2, r4)     // Catch:{ Exception -> 0x0040 }
            androidx.navigation.NavDestination r2 = r6.inflate(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0040 }
            boolean r4 = r2 instanceof androidx.navigation.NavGraph     // Catch:{ Exception -> 0x0040 }
            if (r4 == 0) goto L_0x0042
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2     // Catch:{ Exception -> 0x0040 }
            r1.close()
            return r2
        L_0x003e:
            r7 = move-exception
            goto L_0x0091
        L_0x0040:
            r2 = move-exception
            goto L_0x006a
        L_0x0042:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r2.<init>()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = "Root element <"
            r2.append(r4)     // Catch:{ Exception -> 0x0040 }
            r2.append(r3)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r2.append(r3)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0040 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0040 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0040 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0040 }
            throw r3     // Catch:{ Exception -> 0x0040 }
        L_0x0062:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0040 }
            throw r2     // Catch:{ Exception -> 0x0040 }
        L_0x006a:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r4.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x003e }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x003e }
            r4.append(r7)     // Catch:{ all -> 0x003e }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x003e }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x003e }
            r4.append(r7)     // Catch:{ all -> 0x003e }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x003e }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x003e }
            throw r3     // Catch:{ all -> 0x003e }
        L_0x0091:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflate(int):androidx.navigation.NavGraph");
    }

    private final NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        NavigatorProvider navigatorProvider2 = this.navigatorProvider;
        String name = xmlResourceParser.getName();
        IIX0o.oO(name, "parser.name");
        NavDestination createDestination = navigatorProvider2.getNavigator(name).createDestination();
        createDestination.onInflate(this.context, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return createDestination;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (IIX0o.Oxx0IOOO(TAG_ARGUMENT, name2)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i);
                } else if (IIX0o.Oxx0IOOO("deepLink", name2)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else if (IIX0o.Oxx0IOOO("action", name2)) {
                    inflateAction(resources, createDestination, attributeSet, xmlResourceParser, i);
                } else if (IIX0o.Oxx0IOOO(TAG_INCLUDE, name2) && (createDestination instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    IIX0o.oO(obtainAttributes, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
                    ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return createDestination;
    }
}
