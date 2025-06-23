package androidx.navigation;

@NavOptionsDsl
public final class PopUpToBuilder {
    private boolean inclusive;
    private boolean saveState;

    public final boolean getInclusive() {
        return this.inclusive;
    }

    public final boolean getSaveState() {
        return this.saveState;
    }

    public final void setInclusive(boolean z) {
        this.inclusive = z;
    }

    public final void setSaveState(boolean z) {
        this.saveState = z;
    }
}
