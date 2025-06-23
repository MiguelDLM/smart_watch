package com.sma.smartv3.ui.device;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nCameraActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraActivity.kt\ncom/sma/smartv3/ui/device/CameraActivityKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,374:1\n13309#2,2:375\n*S KotlinDebug\n*F\n+ 1 CameraActivity.kt\ncom/sma/smartv3/ui/device/CameraActivityKt\n*L\n319#1:375,2\n*E\n"})
/* loaded from: classes12.dex */
public final class o00 {
    public static final int II0xO0(@OXOo.OOXIXo byte[] byteArray) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(byteArray, "byteArray");
        try {
            int attributeInt = new ExifInterface(new ByteArrayInputStream(byteArray)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @OXOo.OOXIXo
    public static final List<Uri> oIX0oI() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 29) {
            File[] listFiles = com.sma.smartv3.initializer.IXxxXO.XOxIOxOx(X00IoxXI.oIX0oI.f3233oIX0oI).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    Uri fromFile = Uri.fromFile(file);
                    kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
                    arrayList.add(fromFile);
                }
            }
        } else {
            Cursor query = Utils.getApp().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", "bucket_display_name", "mime_type", "_data"}, "bucket_display_name = '" + AppUtils.getAppName() + '\'', null, "_id DESC");
            if (query != null) {
                LogUtils.d("photo size = " + query.getCount());
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("_data"));
                    Uri parse = Uri.parse(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString() + File.separator + query.getInt(query.getColumnIndex("_id")));
                    if (new File(string).exists()) {
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(parse);
                        arrayList.add(parse);
                    }
                    query.moveToNext();
                }
                query.close();
            }
            LogUtils.d("file size = " + arrayList.size());
        }
        return arrayList;
    }
}
