package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.IdRes;
import androidx.navigation.ActivityNavigator;
import java.util.Map;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;

@NavDestinationDsl
/* loaded from: classes.dex */
public final class ActivityNavigatorDestinationBuilder extends NavDestinationBuilder<ActivityNavigator.Destination> {

    @oOoXoXO
    private String action;

    @oOoXoXO
    private oxoX<? extends Activity> activityClass;

    @OOXIXo
    private Context context;

    @oOoXoXO
    private Uri data;

    @oOoXoXO
    private String dataPattern;

    @oOoXoXO
    private String targetPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "Use routes to create your ActivityNavigatorDestinationBuilder instead", replaceWith = @XX(expression = "ActivityNavigatorDestinationBuilder(navigator, route = id.toString())", imports = {}))
    public ActivityNavigatorDestinationBuilder(@OOXIXo ActivityNavigator navigator, @IdRes int i) {
        super(navigator, i);
        IIX0o.x0xO0oo(navigator, "navigator");
        this.context = navigator.getContext();
    }

    @oOoXoXO
    public final String getAction() {
        return this.action;
    }

    @oOoXoXO
    public final oxoX<? extends Activity> getActivityClass() {
        return this.activityClass;
    }

    @oOoXoXO
    public final Uri getData() {
        return this.data;
    }

    @oOoXoXO
    public final String getDataPattern() {
        return this.dataPattern;
    }

    @oOoXoXO
    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final void setAction(@oOoXoXO String str) {
        this.action = str;
    }

    public final void setActivityClass(@oOoXoXO oxoX<? extends Activity> oxox) {
        this.activityClass = oxox;
    }

    public final void setData(@oOoXoXO Uri uri) {
        this.data = uri;
    }

    public final void setDataPattern(@oOoXoXO String str) {
        this.dataPattern = str;
    }

    public final void setTargetPackage(@oOoXoXO String str) {
        this.targetPackage = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavDestinationBuilder
    @OOXIXo
    public ActivityNavigator.Destination build() {
        ActivityNavigator.Destination destination = (ActivityNavigator.Destination) super.build();
        destination.setTargetPackage(this.targetPackage);
        oxoX<? extends Activity> oxox = this.activityClass;
        if (oxox != null) {
            destination.setComponentName(new ComponentName(this.context, (Class<?>) XO0OX.II0xO0.X0o0xo(oxox)));
        }
        destination.setAction(this.action);
        destination.setData(this.data);
        destination.setDataPattern(this.dataPattern);
        return destination;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavigatorDestinationBuilder(@OOXIXo ActivityNavigator navigator, @OOXIXo String route) {
        super(navigator, route);
        IIX0o.x0xO0oo(navigator, "navigator");
        IIX0o.x0xO0oo(route, "route");
        this.context = navigator.getContext();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavigatorDestinationBuilder(@OOXIXo ActivityNavigator navigator, @OOXIXo oxoX<? extends Object> route, @OOXIXo Map<Oxx0xo, NavType<?>> typeMap) {
        super(navigator, route, typeMap);
        IIX0o.x0xO0oo(navigator, "navigator");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.context = navigator.getContext();
    }
}
