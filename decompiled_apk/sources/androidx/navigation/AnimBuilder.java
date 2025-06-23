package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;

@NavOptionsDsl
/* loaded from: classes.dex */
public final class AnimBuilder {

    @AnimRes
    @AnimatorRes
    private int enter = -1;

    @AnimRes
    @AnimatorRes
    private int exit = -1;

    @AnimRes
    @AnimatorRes
    private int popEnter = -1;

    @AnimRes
    @AnimatorRes
    private int popExit = -1;

    public final int getEnter() {
        return this.enter;
    }

    public final int getExit() {
        return this.exit;
    }

    public final int getPopEnter() {
        return this.popEnter;
    }

    public final int getPopExit() {
        return this.popExit;
    }

    public final void setEnter(int i) {
        this.enter = i;
    }

    public final void setExit(int i) {
        this.exit = i;
    }

    public final void setPopEnter(int i) {
        this.popEnter = i;
    }

    public final void setPopExit(int i) {
        this.popExit = i;
    }
}
