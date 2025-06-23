package com.sma.smartv3.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.me.DeveloperServerActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ServerSelectActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private XoI0Ixx0 mTestServerRemindPop;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.ServerSelectActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ServerSelectActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO taiWanServerLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.login.ServerSelectActivity$taiWanServerLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) ServerSelectActivity.this.findViewById(R.id.taiWanServerLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO selectServerButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.ServerSelectActivity$selectServerButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ServerSelectActivity.this.findViewById(R.id.server_select_img_button);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO selectServerIsShow$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.ServerSelectActivity$selectServerIsShow$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ServerSelectActivity.this.findViewById(R.id.server_select_tv);
        }
    });

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final View getSelectServerButton() {
        return (View) this.selectServerButton$delegate.getValue();
    }

    private final View getSelectServerIsShow() {
        return (View) this.selectServerIsShow$delegate.getValue();
    }

    private final LinearLayout getTaiWanServerLl() {
        return (LinearLayout) this.taiWanServerLl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$0(ServerSelectActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getSelectServerButton().setVisibility(0);
        return true;
    }

    private final void toStartLogin() {
        x0xO0oo.II0xO0(x0xO0oo.f24576IoIOOxIIo, null, 2, null);
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24473x0o, true);
        ProjectManager.f19822oIX0oI.XxXX(this);
    }

    public final void SiliconValleyServerLl(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23073X0o0xo);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, getString(R.string.silicon_valley_of_america_name));
        toStartLogin();
    }

    public final void asiaPacific(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23074oIX0oI);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, getString(R.string.asia_pacific));
        toStartLogin();
    }

    public final void asiaPacificTaiWan(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23074oIX0oI);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, getString(R.string.tai_wan));
        toStartLogin();
    }

    public final void chinaMainland(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23071I0Io);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, getString(R.string.china_mainland));
        toStartLogin();
    }

    public final void europAmerica(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23072II0xO0);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, getString(R.string.europe_and_america));
        toStartLogin();
    }

    public final void indiaBeatxp(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23075oxoX);
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO, getString(R.string.india));
        toStartLogin();
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
        if (ProjectManager.f19822oIX0oI.O00XxXI()) {
            getTaiWanServerLl().setVisibility(0);
        } else {
            getTaiWanServerLl().setVisibility(8);
        }
        getSelectServerButton().setVisibility(8);
        getSelectServerIsShow().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sma.smartv3.ui.login.oOoXoXO
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean initView$lambda$0;
                initView$lambda$0 = ServerSelectActivity.initView$lambda$0(ServerSelectActivity.this, view);
                return initView$lambda$0;
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_server_select;
    }

    public final void moreSetting(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mTestServerRemindPop == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.test_function_remind);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.open_test_function, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.login.ServerSelectActivity$moreSetting$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    ServerSelectActivity serverSelectActivity = ServerSelectActivity.this;
                    serverSelectActivity.startActivity(new Intent(serverSelectActivity, (Class<?>) DeveloperServerActivity.class));
                    return Boolean.TRUE;
                }
            });
            this.mTestServerRemindPop = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mTestServerRemindPop;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void noLogin(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24363IO, false);
        ProjectManager.f19822oIX0oI.x0oxIIIX(this);
        finish();
    }

    @XO0.XO(tag = x0xO0oo.f24563I0X0x0oIo)
    public final void onEmailLoginDone(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        if (!isFinishing()) {
            finish();
        }
    }
}
