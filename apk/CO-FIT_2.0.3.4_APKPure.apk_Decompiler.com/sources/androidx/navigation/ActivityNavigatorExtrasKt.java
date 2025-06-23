package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.ActivityNavigator;

public final class ActivityNavigatorExtrasKt {
    @OOXIXo
    public static final ActivityNavigator.Extras ActivityNavigatorExtras(@oOoXoXO ActivityOptionsCompat activityOptionsCompat, int i) {
        ActivityNavigator.Extras.Builder builder = new ActivityNavigator.Extras.Builder();
        if (activityOptionsCompat != null) {
            builder.setActivityOptions(activityOptionsCompat);
        }
        builder.addFlags(i);
        return builder.build();
    }

    public static /* synthetic */ ActivityNavigator.Extras ActivityNavigatorExtras$default(ActivityOptionsCompat activityOptionsCompat, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activityOptionsCompat = null;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return ActivityNavigatorExtras(activityOptionsCompat, i);
    }
}
