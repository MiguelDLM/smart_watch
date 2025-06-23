package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes11.dex */
public final class ContactUsActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.Oxx0xo contactImgPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rooView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$rooView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO facebookLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$facebookLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.facebookLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO facebookLlLine$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$facebookLlLine$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.facebookLlLine);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO lineLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$lineLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.lineLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO lineLlLine$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$lineLlLine$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.lineLlLine);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO whatsAppLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$whatsAppLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.whatsAppLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO whatsAppLlLine$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$whatsAppLlLine$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.whatsAppLlLine);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO wxLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$wxLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.wxLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO wxLlLine$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$wxLlLine$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.wxLine);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO qqLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$qqLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.qqLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO qqLlLine$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.ContactUsActivity$qqLlLine$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactUsActivity.this.findViewById(R.id.qqLine);
        }
    });

    private final View getFacebookLl() {
        return (View) this.facebookLl$delegate.getValue();
    }

    private final View getFacebookLlLine() {
        return (View) this.facebookLlLine$delegate.getValue();
    }

    private final View getLineLl() {
        return (View) this.lineLl$delegate.getValue();
    }

    private final View getLineLlLine() {
        return (View) this.lineLlLine$delegate.getValue();
    }

    private final View getQqLl() {
        return (View) this.qqLl$delegate.getValue();
    }

    private final View getQqLlLine() {
        return (View) this.qqLlLine$delegate.getValue();
    }

    private final View getRooView() {
        return (View) this.rooView$delegate.getValue();
    }

    private final View getWhatsAppLl() {
        return (View) this.whatsAppLl$delegate.getValue();
    }

    private final View getWhatsAppLlLine() {
        return (View) this.whatsAppLlLine$delegate.getValue();
    }

    private final View getWxLl() {
        return (View) this.wxLl$delegate.getValue();
    }

    private final View getWxLlLine() {
        return (View) this.wxLlLine$delegate.getValue();
    }

    public final void contactFacebook(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Uri parse = Uri.parse(ProjectManager.f19822oIX0oI.IIXOooo());
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setPackage("com.facebook.katana");
        try {
            startActivity(intent);
        } catch (Exception unused) {
            startActivity(new Intent(new Intent("android.intent.action.VIEW", parse)));
        }
    }

    public final void contactLine(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Intent intent = new Intent();
        intent.setData(Uri.parse(ProjectManager.f19822oIX0oI.OxI()));
        intent.setAction("android.intent.action.VIEW");
        startActivity(intent);
    }

    public final void contactQQ(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.Oxx0xo oxx0xo = new com.sma.smartv3.pop.Oxx0xo(this);
        oxx0xo.XIxXXX0x0(Integer.valueOf(ProjectManager.f19822oIX0oI.XxX0x0xxx()));
        this.contactImgPopup = oxx0xo;
        View rooView = getRooView();
        kotlin.jvm.internal.IIX0o.oO(rooView, "<get-rooView>(...)");
        oxx0xo.xoXoI(rooView);
    }

    public final void contactWX(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.Oxx0xo oxx0xo = new com.sma.smartv3.pop.Oxx0xo(this);
        oxx0xo.XIxXXX0x0(Integer.valueOf(ProjectManager.f19822oIX0oI.oo()));
        this.contactImgPopup = oxx0xo;
        View rooView = getRooView();
        kotlin.jvm.internal.IIX0o.oO(rooView, "<get-rooView>(...)");
        oxx0xo.xoXoI(rooView);
    }

    public final void contactWhatsApp(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Intent intent = new Intent();
        intent.setData(Uri.parse(ProjectManager.f19822oIX0oI.oo0xXOI0I()));
        intent.setAction("android.intent.action.VIEW");
        startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.contact_us);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.oI()) {
            getFacebookLl().setVisibility(0);
            getFacebookLlLine().setVisibility(0);
        } else {
            getFacebookLl().setVisibility(8);
            getFacebookLlLine().setVisibility(8);
        }
        if (projectManager.oXxOI0oIx()) {
            getLineLl().setVisibility(0);
            getLineLlLine().setVisibility(0);
        } else {
            getLineLl().setVisibility(8);
            getLineLlLine().setVisibility(8);
        }
        if (projectManager.xIx()) {
            getWhatsAppLl().setVisibility(0);
            getWhatsAppLlLine().setVisibility(0);
        } else {
            getWhatsAppLl().setVisibility(8);
            getWhatsAppLlLine().setVisibility(8);
        }
        if (projectManager.xIx0XO()) {
            getWxLl().setVisibility(0);
            getWxLlLine().setVisibility(0);
        } else {
            getWxLl().setVisibility(8);
            getWxLlLine().setVisibility(8);
        }
        if (projectManager.xOOxIO()) {
            getQqLl().setVisibility(0);
            getQqLlLine().setVisibility(0);
        } else {
            getQqLl().setVisibility(8);
            getQqLlLine().setVisibility(8);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_contact_us;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
