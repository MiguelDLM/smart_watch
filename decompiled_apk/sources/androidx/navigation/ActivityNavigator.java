package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.OxI;

@Navigator.Name(TTDownloadField.TT_ACTIVITY)
@XX({"SMAP\nActivityNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityNavigator.kt\nandroidx/navigation/ActivityNavigator\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,501:1\n179#2,2:502\n*S KotlinDebug\n*F\n+ 1 ActivityNavigator.kt\nandroidx/navigation/ActivityNavigator\n*L\n45#1:502,2\n*E\n"})
/* loaded from: classes.dex */
public class ActivityNavigator extends Navigator<Destination> {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";

    @OOXIXo
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";

    @OOXIXo
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";

    @OOXIXo
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";

    @OOXIXo
    private static final String LOG_TAG = "ActivityNavigator";

    @OOXIXo
    private final Context context;

    @oOoXoXO
    private final Activity hostActivity;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public final void applyPopAnimationsToPendingTransition(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, "activity");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra(ActivityNavigator.EXTRA_POP_ENTER_ANIM, -1);
            int intExtra2 = intent.getIntExtra(ActivityNavigator.EXTRA_POP_EXIT_ANIM, -1);
            if (intExtra != -1 || intExtra2 != -1) {
                if (intExtra == -1) {
                    intExtra = 0;
                }
                if (intExtra2 == -1) {
                    intExtra2 = 0;
                }
                activity.overridePendingTransition(intExtra, intExtra2);
            }
        }

        private Companion() {
        }
    }

    @NavDestination.ClassType(Activity.class)
    @XX({"SMAP\nActivityNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityNavigator.kt\nandroidx/navigation/ActivityNavigator$Destination\n+ 2 TypedArray.kt\nandroidx/core/content/res/TypedArrayKt\n*L\n1#1,501:1\n232#2,3:502\n*S KotlinDebug\n*F\n+ 1 ActivityNavigator.kt\nandroidx/navigation/ActivityNavigator$Destination\n*L\n258#1:502,3\n*E\n"})
    /* loaded from: classes.dex */
    public static class Destination extends NavDestination {

        @oOoXoXO
        private String action;

        @oOoXoXO
        private ComponentName component;

        @oOoXoXO
        private Uri data;

        @oOoXoXO
        private String dataPattern;

        @oOoXoXO
        private Intent intent;

        @oOoXoXO
        private String targetPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(@OOXIXo Navigator<? extends Destination> activityNavigator) {
            super(activityNavigator);
            IIX0o.x0xO0oo(activityNavigator, "activityNavigator");
        }

        private final String parseApplicationId(Context context, String str) {
            if (str != null) {
                String packageName = context.getPackageName();
                IIX0o.oO(packageName, "context.packageName");
                return OxI.IIOIX(str, NavInflater.APPLICATION_ID_PLACEHOLDER, packageName, false, 4, null);
            }
            return null;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(@oOoXoXO Object obj) {
            boolean z;
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Destination) && super.equals(obj)) {
                Intent intent = this.intent;
                if (intent != null) {
                    z = intent.filterEquals(((Destination) obj).intent);
                } else if (((Destination) obj).intent == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && IIX0o.Oxx0IOOO(this.dataPattern, ((Destination) obj).dataPattern)) {
                    return true;
                }
            }
            return false;
        }

        @oOoXoXO
        public final String getAction() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getAction();
            }
            return null;
        }

        @oOoXoXO
        public final ComponentName getComponent() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getComponent();
            }
            return null;
        }

        @oOoXoXO
        public final Uri getData() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @oOoXoXO
        public final String getDataPattern() {
            return this.dataPattern;
        }

        @oOoXoXO
        public final Intent getIntent() {
            return this.intent;
        }

        @oOoXoXO
        public final String getTargetPackage() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getPackage();
            }
            return null;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int i;
            int hashCode = super.hashCode() * 31;
            Intent intent = this.intent;
            int i2 = 0;
            if (intent != null) {
                i = intent.filterHashCode();
            } else {
                i = 0;
            }
            int i3 = (hashCode + i) * 31;
            String str = this.dataPattern;
            if (str != null) {
                i2 = str.hashCode();
            }
            return i3 + i2;
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@OOXIXo Context context, @OOXIXo AttributeSet attrs) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(attrs, "attrs");
            super.onInflate(context, attrs);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.ActivityNavigator);
            IIX0o.oO(obtainAttributes, "context.resources.obtain…leable.ActivityNavigator)");
            setTargetPackage(parseApplicationId(context, obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage)));
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string != null) {
                if (string.charAt(0) == '.') {
                    string = context.getPackageName() + string;
                }
                setComponentName(new ComponentName(context, string));
            }
            setAction(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String parseApplicationId = parseApplicationId(context, obtainAttributes.getString(R.styleable.ActivityNavigator_data));
            if (parseApplicationId != null) {
                setData(Uri.parse(parseApplicationId));
            }
            setDataPattern(parseApplicationId(context, obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern)));
            obtainAttributes.recycle();
        }

        @OOXIXo
        public final Destination setAction(@oOoXoXO String str) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            IIX0o.ooOOo0oXI(intent);
            intent.setAction(str);
            return this;
        }

        @OOXIXo
        public final Destination setComponentName(@oOoXoXO ComponentName componentName) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            IIX0o.ooOOo0oXI(intent);
            intent.setComponent(componentName);
            return this;
        }

        @OOXIXo
        public final Destination setData(@oOoXoXO Uri uri) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            IIX0o.ooOOo0oXI(intent);
            intent.setData(uri);
            return this;
        }

        @OOXIXo
        public final Destination setDataPattern(@oOoXoXO String str) {
            this.dataPattern = str;
            return this;
        }

        @OOXIXo
        public final Destination setIntent(@oOoXoXO Intent intent) {
            this.intent = intent;
            return this;
        }

        @OOXIXo
        public final Destination setTargetPackage(@oOoXoXO String str) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            IIX0o.ooOOo0oXI(intent);
            intent.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean supportsActions() {
            return false;
        }

        @Override // androidx.navigation.NavDestination
        @OOXIXo
        public String toString() {
            ComponentName component = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                String action = getAction();
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "sb.toString()");
            return sb2;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Destination(@OOXIXo NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(ActivityNavigator.class));
            IIX0o.x0xO0oo(navigatorProvider, "navigatorProvider");
        }
    }

    /* loaded from: classes.dex */
    public static final class Extras implements Navigator.Extras {

        @oOoXoXO
        private final ActivityOptionsCompat activityOptions;
        private final int flags;

        /* loaded from: classes.dex */
        public static final class Builder {

            @oOoXoXO
            private ActivityOptionsCompat activityOptions;
            private int flags;

            @OOXIXo
            public final Builder addFlags(int i) {
                this.flags = i | this.flags;
                return this;
            }

            @OOXIXo
            public final Extras build() {
                return new Extras(this.flags, this.activityOptions);
            }

            @OOXIXo
            public final Builder setActivityOptions(@OOXIXo ActivityOptionsCompat activityOptions) {
                IIX0o.x0xO0oo(activityOptions, "activityOptions");
                this.activityOptions = activityOptions;
                return this;
            }
        }

        public Extras(int i, @oOoXoXO ActivityOptionsCompat activityOptionsCompat) {
            this.flags = i;
            this.activityOptions = activityOptionsCompat;
        }

        @oOoXoXO
        public final ActivityOptionsCompat getActivityOptions() {
            return this.activityOptions;
        }

        public final int getFlags() {
            return this.flags;
        }
    }

    public ActivityNavigator(@OOXIXo Context context) {
        Object obj;
        IIX0o.x0xO0oo(context, "context");
        this.context = context;
        Iterator it = SequencesKt__SequencesKt.x0XOIxOo(context, new Oox.oOoXoXO<Context, Context>() { // from class: androidx.navigation.ActivityNavigator$hostActivity$1
            @Override // Oox.oOoXoXO
            public final Context invoke(Context it2) {
                IIX0o.x0xO0oo(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        this.hostActivity = (Activity) obj;
    }

    @x0XOIxOo
    public static final void applyPopAnimationsToPendingTransition(@OOXIXo Activity activity) {
        Companion.applyPopAnimationsToPendingTransition(activity);
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.Navigator
    @OOXIXo
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    @oOoXoXO
    public NavDestination navigate(@OOXIXo Destination destination, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        String encode;
        IIX0o.x0xO0oo(destination, "destination");
        if (destination.getIntent() != null) {
            Intent intent2 = new Intent(destination.getIntent());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String dataPattern = destination.getDataPattern();
                if (dataPattern != null && dataPattern.length() != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            Map<String, NavArgument> arguments = destination.getArguments();
                            IIX0o.ooOOo0oXI(group);
                            NavArgument navArgument = arguments.get(group);
                            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                            if (type == null || (encode = type.serializeAsValue(type.get(bundle, group))) == null) {
                                encode = Uri.encode(String.valueOf(bundle.get(group)));
                            }
                            stringBuffer.append(encode);
                        } else {
                            throw new IllegalArgumentException(("Could not find " + group + " in " + bundle + " to fill data pattern " + dataPattern).toString());
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = extras instanceof Extras;
            if (z) {
                intent2.addFlags(((Extras) extras).getFlags());
            }
            if (this.hostActivity == null) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.hostActivity;
            if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra(EXTRA_NAV_CURRENT, 0)) != 0) {
                intent2.putExtra(EXTRA_NAV_SOURCE, intExtra);
            }
            intent2.putExtra(EXTRA_NAV_CURRENT, destination.getId());
            Resources resources = this.context.getResources();
            if (navOptions != null) {
                int popEnterAnim = navOptions.getPopEnterAnim();
                int popExitAnim = navOptions.getPopExitAnim();
                if ((popEnterAnim > 0 && IIX0o.Oxx0IOOO(resources.getResourceTypeName(popEnterAnim), "animator")) || (popExitAnim > 0 && IIX0o.Oxx0IOOO(resources.getResourceTypeName(popExitAnim), "animator"))) {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(popEnterAnim) + " and popExit resource " + resources.getResourceName(popExitAnim) + " when launching " + destination);
                } else {
                    intent2.putExtra(EXTRA_POP_ENTER_ANIM, popEnterAnim);
                    intent2.putExtra(EXTRA_POP_EXIT_ANIM, popExitAnim);
                }
            }
            if (z) {
                ActivityOptionsCompat activityOptions = ((Extras) extras).getActivityOptions();
                if (activityOptions != null) {
                    ContextCompat.startActivity(this.context, intent2, activityOptions.toBundle());
                } else {
                    this.context.startActivity(intent2);
                }
            } else {
                this.context.startActivity(intent2);
            }
            if (navOptions != null && this.hostActivity != null) {
                int enterAnim = navOptions.getEnterAnim();
                int exitAnim = navOptions.getExitAnim();
                if ((enterAnim > 0 && IIX0o.Oxx0IOOO(resources.getResourceTypeName(enterAnim), "animator")) || (exitAnim > 0 && IIX0o.Oxx0IOOO(resources.getResourceTypeName(exitAnim), "animator"))) {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(enterAnim) + " and exit resource " + resources.getResourceName(exitAnim) + "when launching " + destination);
                } else if (enterAnim >= 0 || exitAnim >= 0) {
                    this.hostActivity.overridePendingTransition(X0.IIXOooo.OxxIIOOXO(enterAnim, 0), X0.IIXOooo.OxxIIOOXO(exitAnim, 0));
                }
            }
            return null;
        }
        throw new IllegalStateException(("Destination " + destination.getId() + " does not have an Intent set.").toString());
    }
}
