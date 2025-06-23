package oOXoIIIo;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.text.TextUtils;
import android.widget.TextView;
import com.bestmafen.androidbase.R;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.szabh.smable3.entity.Languages;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class X0o0xo {

    /* loaded from: classes8.dex */
    public static final class oIX0oI implements PermissionUtils.FullCallback {

        /* renamed from: oIX0oI */
        public final /* synthetic */ oOoXoXO<PermissionStatus, oXIO0o0XI> f32007oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(oOoXoXO<? super PermissionStatus, oXIO0o0XI> oooxoxo) {
            this.f32007oIX0oI = oooxoxo;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.FullCallback
        public void onDenied(@OOXIXo List<String> permissionsDeniedForever, @OOXIXo List<String> permissionsDenied) {
            IIX0o.x0xO0oo(permissionsDeniedForever, "permissionsDeniedForever");
            IIX0o.x0xO0oo(permissionsDenied, "permissionsDenied");
            if (!permissionsDeniedForever.isEmpty()) {
                this.f32007oIX0oI.invoke(PermissionStatus.DENIED_FOREVER);
            } else if (!permissionsDenied.isEmpty()) {
                this.f32007oIX0oI.invoke(PermissionStatus.DENIED);
            }
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.FullCallback
        public void onGranted(@OOXIXo List<String> permissionsGranted) {
            IIX0o.x0xO0oo(permissionsGranted, "permissionsGranted");
            this.f32007oIX0oI.invoke(PermissionStatus.GRANTED);
        }
    }

    public static /* synthetic */ void I0Io(PermissionUtils permissionUtils, String str, String str2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        II0xO0(permissionUtils, str, str2, oooxoxo);
    }

    public static final void II0xO0(@OOXIXo PermissionUtils permissionUtils, @OOXIXo final String explainTitle, @OOXIXo final String explainContent, @OOXIXo oOoXoXO<? super PermissionStatus, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(permissionUtils, "<this>");
        IIX0o.x0xO0oo(explainTitle, "explainTitle");
        IIX0o.x0xO0oo(explainContent, "explainContent");
        IIX0o.x0xO0oo(action, "action");
        permissionUtils.explain(new PermissionUtils.OnExplainListener() { // from class: oOXoIIIo.oxoX
            @Override // com.blankj.utilcode.util.PermissionUtils.OnExplainListener
            public final void explain(UtilsTransActivity utilsTransActivity, List list, PermissionUtils.OnExplainListener.ShouldRequest shouldRequest) {
                X0o0xo.oxoX(explainTitle, explainContent, utilsTransActivity, list, shouldRequest);
            }
        });
        permissionUtils.callback(new oIX0oI(action)).request();
    }

    public static final void oxoX(String explainTitle, String explainContent, UtilsTransActivity activity, List denied, PermissionUtils.OnExplainListener.ShouldRequest shouldRequest) {
        IIX0o.x0xO0oo(explainTitle, "$explainTitle");
        IIX0o.x0xO0oo(explainContent, "$explainContent");
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(denied, "denied");
        IIX0o.x0xO0oo(shouldRequest, "shouldRequest");
        Locale locale = activity.getResources().getConfiguration().locale;
        if (IIX0o.Oxx0IOOO(locale.getLanguage(), Languages.DEFAULT_LANGUAGE_ZH) && IIX0o.Oxx0IOOO(locale.getCountry(), "CN") && !TextUtils.isEmpty(explainTitle)) {
            activity.setContentView(R.layout.activity_permission_explain);
            TextView textView = (TextView) activity.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) activity.findViewById(R.id.tv_content);
            textView.setText(explainTitle);
            textView2.setText(explainContent);
        }
        shouldRequest.start(true);
    }
}
