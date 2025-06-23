package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import org.xmlpull.v1.XmlPullParserException;

@XX({"SMAP\nNavInflater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavInflater.kt\nandroidx/navigation/NavInflater\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TypedArray.kt\nandroidx/core/content/res/TypedArrayKt\n+ 4 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,365:1\n1#2:366\n232#3,3:367\n232#3,3:370\n232#3,3:373\n232#3,3:376\n55#4,6:379\n*S KotlinDebug\n*F\n+ 1 NavInflater.kt\nandroidx/navigation/NavInflater\n*L\n110#1:367,3\n128#1:370,3\n144#1:373,3\n261#1:376,3\n295#1:379,6\n*E\n"})
/* loaded from: classes.dex */
public final class NavInflater {

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";

    @OOXIXo
    private static final String TAG_ACTION = "action";

    @OOXIXo
    private static final String TAG_ARGUMENT = "argument";

    @OOXIXo
    private static final String TAG_DEEP_LINK = "deepLink";

    @OOXIXo
    private static final String TAG_INCLUDE = "include";

    @OOXIXo
    private final Context context;

    @OOXIXo
    private final NavigatorProvider navigatorProvider;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final NavType<?> checkNavType$navigation_runtime_release(@OOXIXo TypedValue value, @oOoXoXO NavType<?> navType, @OOXIXo NavType<?> expectedNavType, @oOoXoXO String str, @OOXIXo String foundType) throws XmlPullParserException {
            IIX0o.x0xO0oo(value, "value");
            IIX0o.x0xO0oo(expectedNavType, "expectedNavType");
            IIX0o.x0xO0oo(foundType, "foundType");
            if (navType != null && navType != expectedNavType) {
                throw new XmlPullParserException("Type is " + str + " but found " + foundType + ": " + value.data);
            }
            if (navType == null) {
                return expectedNavType;
            }
            return navType;
        }

        private Companion() {
        }
    }

    public NavInflater(@OOXIXo Context context, @OOXIXo NavigatorProvider navigatorProvider) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(navigatorProvider, "navigatorProvider");
        this.context = context;
        this.navigatorProvider = navigatorProvider;
    }

    private final void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        int depth;
        Context context = this.context;
        int[] NavAction = androidx.navigation.common.R.styleable.NavAction;
        IIX0o.oO(NavAction, "NavAction");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NavAction, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0), null, null, 6, null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        builder.setRestoreState(obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_restoreState, false));
        builder.setPopUpTo(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToSaveState, false));
        builder.setEnterAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && IIX0o.Oxx0IOOO(TAG_ARGUMENT, xmlResourceParser.getName())) {
                inflateArgumentForBundle(resources, bundle, attributeSet, i);
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainStyledAttributes.recycle();
    }

    private final NavArgument inflateArgument(TypedArray typedArray, Resources resources, int i) throws XmlPullParserException {
        NavType<Object> navType;
        NavArgument.Builder builder = new NavArgument.Builder();
        boolean z = false;
        int i2 = 0;
        builder.setIsNullable(typedArray.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = sTmpValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object obj = null;
        if (string != null) {
            navType = NavType.Companion.fromArgType(string, resources.getResourcePackageName(i));
        } else {
            navType = null;
        }
        int i3 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i3, typedValue)) {
            NavType<Object> navType2 = NavType.ReferenceType;
            if (navType == navType2) {
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    i2 = i4;
                } else if (typedValue.type != 16 || typedValue.data != 0) {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType.getName() + ". Must be a reference to a resource.");
                }
                obj = Integer.valueOf(i2);
            } else {
                int i5 = typedValue.resourceId;
                if (i5 != 0) {
                    if (navType == null) {
                        navType = navType2;
                        obj = Integer.valueOf(i5);
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType.getName() + ". You must use a \"" + navType2.getName() + "\" type to reference other resources.");
                    }
                } else if (navType == NavType.StringType) {
                    obj = typedArray.getString(i3);
                } else {
                    int i6 = typedValue.type;
                    if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 != 5) {
                                if (i6 != 18) {
                                    if (i6 >= 16 && i6 <= 31) {
                                        NavType<Object> navType3 = NavType.FloatType;
                                        if (navType == navType3) {
                                            navType = Companion.checkNavType$navigation_runtime_release(typedValue, navType, navType3, string, TypedValues.Custom.S_FLOAT);
                                            obj = Float.valueOf(typedValue.data);
                                        } else {
                                            navType = Companion.checkNavType$navigation_runtime_release(typedValue, navType, NavType.IntType, string, TypedValues.Custom.S_INT);
                                            obj = Integer.valueOf(typedValue.data);
                                        }
                                    } else {
                                        throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                                    }
                                } else {
                                    navType = Companion.checkNavType$navigation_runtime_release(typedValue, navType, NavType.BoolType, string, TypedValues.Custom.S_BOOLEAN);
                                    if (typedValue.data != 0) {
                                        z = true;
                                    }
                                    obj = Boolean.valueOf(z);
                                }
                            } else {
                                navType = Companion.checkNavType$navigation_runtime_release(typedValue, navType, NavType.IntType, string, "dimension");
                                obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                            }
                        } else {
                            navType = Companion.checkNavType$navigation_runtime_release(typedValue, navType, NavType.FloatType, string, TypedValues.Custom.S_FLOAT);
                            obj = Float.valueOf(typedValue.getFloat());
                        }
                    } else {
                        String obj2 = typedValue.string.toString();
                        if (navType == null) {
                            navType = NavType.Companion.inferFromValue(obj2);
                        }
                        obj = navType.parseValue(obj2);
                    }
                }
            }
        }
        if (obj != null) {
            builder.setDefaultValue(obj);
        }
        if (navType != null) {
            builder.setType(navType);
        }
        return builder.build();
    }

    private final void inflateArgumentForBundle(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        IIX0o.oO(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string != null) {
            IIX0o.oO(string, "array.getString(R.stylea…uments must have a name\")");
            NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i);
            if (inflateArgument.isDefaultValuePresent()) {
                inflateArgument.putDefaultValue(string, bundle);
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateArgumentForDestination(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        IIX0o.oO(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string != null) {
            IIX0o.oO(string, "array.getString(R.stylea…uments must have a name\")");
            navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i));
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateDeepLink(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
        IIX0o.oO(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        if ((string != null && string.length() != 0) || ((string2 != null && string2.length() != 0) || (string3 != null && string3.length() != 0))) {
            NavDeepLink.Builder builder = new NavDeepLink.Builder();
            if (string != null) {
                String packageName = this.context.getPackageName();
                IIX0o.oO(packageName, "context.packageName");
                builder.setUriPattern(OxI.IIOIX(string, APPLICATION_ID_PLACEHOLDER, packageName, false, 4, null));
            }
            if (string2 != null && string2.length() != 0) {
                String packageName2 = this.context.getPackageName();
                IIX0o.oO(packageName2, "context.packageName");
                builder.setAction(OxI.IIOIX(string2, APPLICATION_ID_PLACEHOLDER, packageName2, false, 4, null));
            }
            if (string3 != null) {
                String packageName3 = this.context.getPackageName();
                IIX0o.oO(packageName3, "context.packageName");
                builder.setMimeType(OxI.IIOIX(string3, APPLICATION_ID_PLACEHOLDER, packageName3, false, 4, null));
            }
            navDestination.addDeepLink(builder.build());
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
    }

    @OOXIXo
    @SuppressLint({"ResourceType"})
    public final NavGraph inflate(@NavigationRes int i) {
        int next;
        Resources res = this.context.getResources();
        XmlResourceParser xml = res.getXml(i);
        IIX0o.oO(xml, "res.getXml(graphResId)");
        AttributeSet attrs = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + res.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            IIX0o.oO(res, "res");
            IIX0o.oO(attrs, "attrs");
            NavDestination inflate = inflate(res, xml, attrs, i);
            if (inflate instanceof NavGraph) {
                return (NavGraph) inflate;
            }
            throw new IllegalArgumentException(("Root element <" + name + "> did not inflate into a NavGraph").toString());
        }
        throw new XmlPullParserException("No start tag found");
    }

    private final NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        NavigatorProvider navigatorProvider = this.navigatorProvider;
        String name = xmlResourceParser.getName();
        IIX0o.oO(name, "parser.name");
        NavDestination createDestination = navigatorProvider.getNavigator(name).createDestination();
        createDestination.onInflate(this.context, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
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
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return createDestination;
    }
}
