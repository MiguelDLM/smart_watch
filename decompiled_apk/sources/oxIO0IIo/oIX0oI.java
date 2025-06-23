package oxIO0IIo;

import XxXX.Oxx0IOOO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.connect.common.I0Io;
import java.util.ArrayList;
import o0Oo.II0xO0;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public II0xO0 f33539oIX0oI;

    public oIX0oI(xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public void oO(Activity activity, ArrayList<Uri> arrayList, II0xO0 iI0xO0) {
        II0xO0 iI0xO02 = this.f33539oIX0oI;
        if (iI0xO02 != null) {
            iI0xO02.onCancel();
        }
        this.f33539oIX0oI = iI0xO0;
        if (!Oxx0IOOO.ooOOo0oXI(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (Oxx0IOOO.x0XOIxOo(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            return;
        }
        if (!x0XOIxOo(activity.getApplicationContext(), arrayList)) {
            Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
            return;
        }
        String II0XooXoX2 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
        if (!TextUtils.isEmpty(II0XooXoX2)) {
            if (II0XooXoX2.length() > 20) {
                II0XooXoX2 = II0XooXoX2.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX2), 2));
        }
        String X0o0xo2 = this.c.X0o0xo();
        String II0XooXoX3 = this.c.II0XooXoX();
        if (!TextUtils.isEmpty(X0o0xo2)) {
            stringBuffer.append("&share_id=" + X0o0xo2);
        }
        if (!TextUtils.isEmpty(II0XooXoX3)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX3), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(com.tencent.connect.common.II0xO0.f26901xoIox), 2));
        String ooOOo0oXI2 = ooOOo0oXI(arrayList);
        if (!TextUtils.isEmpty(ooOOo0oXI2)) {
            stringBuffer.append("&set_uri_list=" + ooOOo0oXI2);
        }
        xxIXOIIO.IXxxXO("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        if (II0XooXoX(intent)) {
            I0Io.II0xO0().Oxx0IOOO(10109, iI0xO0);
            oxoX(activity, 10109, intent, false);
        }
    }

    public final String ooOOo0oXI(ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            sb.append(x.aL);
        }
        String sb2 = sb.toString();
        xxIXOIIO.oOoXoXO("QQEMOTION", "-->getFilePathListJson listStr : " + sb2);
        return Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(sb2), 2);
    }

    public final boolean x0XOIxOo(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            xxIXOIIO.oOoXoXO("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            String xxIXOIIO2 = com.tencent.open.utils.II0xO0.xxIXOIIO(context, arrayList.get(i));
            long Io2 = com.tencent.open.utils.II0xO0.Io(xxIXOIIO2);
            if (Io2 > 1048576) {
                xxIXOIIO.oOoXoXO("QQEMOTION", "isLegality -->illegal, fileSize: " + Io2 + "， path =" + xxIXOIIO2);
                return false;
            }
            j += Io2;
        }
        if (j > 3145728) {
            xxIXOIIO.oOoXoXO("QQEMOTION", "isLegality -->illegal, totalSize: " + j);
            return false;
        }
        xxIXOIIO.oOoXoXO("QQEMOTION", "isLegality -->legal, totalSize: " + j);
        return true;
    }
}
