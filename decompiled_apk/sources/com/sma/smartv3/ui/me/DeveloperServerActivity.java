package com.sma.smartv3.ui.me;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes11.dex */
public final class DeveloperServerActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.IIX0o mEditPop;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.DeveloperServerActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return DeveloperServerActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO kaiServerLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.DeveloperServerActivity$kaiServerLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DeveloperServerActivity.this.findViewById(R.id.kaiServerLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO taoServerLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.DeveloperServerActivity$taoServerLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DeveloperServerActivity.this.findViewById(R.id.taoServerLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO devServerLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.DeveloperServerActivity$devServerLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) DeveloperServerActivity.this.findViewById(R.id.devServerLl);
        }
    });

    private final LinearLayout getDevServerLl() {
        return (LinearLayout) this.devServerLl$delegate.getValue();
    }

    private final LinearLayout getKaiServerLl() {
        return (LinearLayout) this.kaiServerLl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final LinearLayout getTaoServerLl() {
        return (LinearLayout) this.taoServerLl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toStartLogin() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24473x0o, true);
        ProjectManager.f19822oIX0oI.XxXX(this);
    }

    public final void devServer(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(getMContext(), 0, 2, null);
        iIX0o.xXxxox0I().setHint("Invitation code");
        iIX0o.X00IoxXI(2);
        iIX0o.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperServerActivity$devServer$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo String text) {
                com.sma.smartv3.pop.IIX0o iIX0o2;
                View rootView;
                kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(text, "752868")) {
                    iIX0o2 = DeveloperServerActivity.this.mEditPop;
                    if (iIX0o2 != null) {
                        rootView = DeveloperServerActivity.this.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "access$getRootView(...)");
                        iIX0o2.OxxIIOOXO(rootView);
                    }
                    com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                    xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, O0X.f23389oIX0oI);
                    xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, "Dev Server");
                    DeveloperServerActivity.this.toStartLogin();
                } else {
                    ToastUtils.showLong("error", new Object[0]);
                }
                return Boolean.TRUE;
            }
        });
        this.mEditPop = iIX0o;
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        iIX0o.OxxIIOOXO(rootView);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getKaiServerLl().setVisibility(8);
        getTaoServerLl().setVisibility(8);
        getDevServerLl().setVisibility(8);
    }

    public final void kaiServer(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, O0X.f23388XO);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, "Kai Server");
        toStartLogin();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_test_server_select;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24563I0X0x0oIo)
    public final void onEmailLoginDone(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        if (!isFinishing()) {
            finish();
        }
    }

    public final void taoServer(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, O0X.f23386Oxx0IOOO);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, "Tao Server");
        toStartLogin();
    }

    public final void testServer(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(getMContext(), 0, 2, null);
        iIX0o.xXxxox0I().setHint("Invitation code");
        iIX0o.X00IoxXI(2);
        iIX0o.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperServerActivity$testServer$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo String text) {
                com.sma.smartv3.pop.IIX0o iIX0o2;
                View rootView;
                kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(text, "837765")) {
                    iIX0o2 = DeveloperServerActivity.this.mEditPop;
                    if (iIX0o2 != null) {
                        rootView = DeveloperServerActivity.this.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "access$getRootView(...)");
                        iIX0o2.OxxIIOOXO(rootView);
                    }
                    com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                    xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, O0X.f23385II0xO0);
                    xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, "Test Server");
                    DeveloperServerActivity.this.toStartLogin();
                } else {
                    ToastUtils.showLong("error", new Object[0]);
                }
                return Boolean.TRUE;
            }
        });
        this.mEditPop = iIX0o;
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        iIX0o.OxxIIOOXO(rootView);
    }
}
