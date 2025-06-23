package OOIXx0x;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes13.dex */
public class oIX0oI implements View.OnClickListener {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f1719IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @NonNull
    public final Activity f1720IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @Nullable
    public View f1721Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public InputStream f1722OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f1723Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f1724OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @Nullable
    public TextView f1725XO;

    /* renamed from: o00, reason: collision with root package name */
    public String f1726o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public File f1727oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Uri f1728xoXoI;

    public oIX0oI(@NonNull Activity activity) {
        this.f1720IXxxXO = activity;
    }

    @Nullable
    public InputStream I0Io() {
        return this.f1722OxI;
    }

    @Nullable
    public String II0xO0() {
        return this.f1726o00;
    }

    public void Oxx0IOOO() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        String str = this.f1724OxxIIOOXO;
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        String str2 = this.f1719IIXOooo;
        if (str2 != null) {
            intent.putExtra("android.intent.extra.TITLE", str2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            File file = this.f1727oI0IIXIo;
            if (file != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", Uri.fromFile(file));
            } else {
                intent.putExtra("android.provider.extra.INITIAL_URI", Uri.fromFile(this.f1720IXxxXO.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)));
            }
        }
        int currentTimeMillis = ((int) (System.currentTimeMillis() & 65535)) | 5393;
        this.f1723Oxx0xo = currentTimeMillis;
        this.f1720IXxxXO.startActivityForResult(intent, currentTimeMillis, null);
    }

    @SuppressLint({"SetTextI18n"})
    public boolean X0o0xo(int i, int i2, @Nullable Intent intent) {
        TextView textView;
        InputStream openInputStream;
        String str;
        int i3 = this.f1723Oxx0xo;
        if (i3 == 0 || i != i3) {
            return false;
        }
        this.f1723Oxx0xo = 0;
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                try {
                    ContentResolver contentResolver = this.f1720IXxxXO.getContentResolver();
                    openInputStream = contentResolver.openInputStream(data);
                    Cursor query = contentResolver.query(data, new String[]{"_display_name"}, null, null, null);
                    if (query != null) {
                        if (query.moveToNext()) {
                            str = query.getString(0);
                        } else {
                            str = null;
                        }
                        query.close();
                    } else {
                        str = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    TextView textView2 = this.f1725XO;
                    if (textView2 == null) {
                        return false;
                    }
                    textView2.setText(e.getMessage());
                    return false;
                }
            } else {
                openInputStream = null;
                str = null;
            }
            this.f1726o00 = str;
            TextView textView3 = this.f1725XO;
            if (textView3 != null) {
                if (str != null) {
                    textView3.setText(str);
                } else {
                    textView3.setText("Failed to read file name.");
                }
            }
            if (openInputStream != null) {
                this.f1728xoXoI = data;
                this.f1722OxI = openInputStream;
                return true;
            }
            this.f1728xoXoI = null;
            TextView textView4 = this.f1725XO;
            if (textView4 == null) {
                return false;
            }
            textView4.setText("Failed to read file.");
            return false;
        }
        if (this.f1728xoXoI != null || (textView = this.f1725XO) == null) {
            return false;
        }
        textView.setText("No File");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream XO() {
        /*
            r2 = this;
            android.net.Uri r0 = r2.f1728xoXoI
            if (r0 == 0) goto L15
            android.app.Activity r0 = r2.f1720IXxxXO
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = r2.f1728xoXoI     // Catch: java.lang.Exception -> L11
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch: java.lang.Exception -> L11
            goto L16
        L11:
            r0 = move-exception
            r0.printStackTrace()
        L15:
            r0 = 0
        L16:
            if (r0 == 0) goto L1a
            r2.f1722OxI = r0
        L1a:
            java.io.InputStream r0 = r2.f1722OxI
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: OOIXx0x.oIX0oI.XO():java.io.InputStream");
    }

    public boolean oIX0oI(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1721Oo) {
            Oxx0IOOO();
        }
    }

    @Nullable
    public Uri oxoX() {
        return this.f1728xoXoI;
    }

    public oIX0oI(@NonNull Activity activity, @Nullable TextView textView, @Nullable View view) {
        this(activity);
        this.f1725XO = textView;
        this.f1721Oo = view;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }
}
