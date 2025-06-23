package com.kwad.components.offline.c.a;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.p;

/* loaded from: classes11.dex */
public final class c implements IOfflineHostActionHandler {
    private final p ZW;

    public c(p pVar) {
        this.ZW = pVar;
    }

    private l a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new l() { // from class: com.kwad.components.offline.c.a.c.1
            @Override // com.kwad.sdk.components.l
            public final void a(o oVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new g(oVar));
            }

            @Override // com.kwad.sdk.components.l
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.l
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.l
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.l
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.l
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }

            @Override // com.kwad.sdk.components.l
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        p pVar = this.ZW;
        if (pVar != null) {
            pVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        p pVar = this.ZW;
        if (pVar != null) {
            pVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        p pVar = this.ZW;
        if (pVar != null) {
            pVar.a(a(iOfflineTKNativeIntent));
        }
    }

    private k a(final IOfflineTKDialog iOfflineTKDialog) {
        return new k() { // from class: com.kwad.components.offline.c.a.c.2
            @Override // com.kwad.sdk.components.k
            public final void a(o oVar) {
                iOfflineTKDialog.registerJSCallHandler(new g(oVar));
            }

            @Override // com.kwad.sdk.components.k
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.k
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.k
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKDialog.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.k
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.k
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.k
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }

            @Override // com.kwad.sdk.components.k
            public final boolean isHideNavigationBar() {
                return iOfflineTKDialog.isHideNavigationBar();
            }
        };
    }
}
