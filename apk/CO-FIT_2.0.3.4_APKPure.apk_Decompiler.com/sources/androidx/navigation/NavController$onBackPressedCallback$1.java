package androidx.navigation;

import androidx.activity.OnBackPressedCallback;

public final class NavController$onBackPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$onBackPressedCallback$1(NavController navController) {
        super(false);
        this.this$0 = navController;
    }

    public void handleOnBackPressed() {
        this.this$0.popBackStack();
    }
}
