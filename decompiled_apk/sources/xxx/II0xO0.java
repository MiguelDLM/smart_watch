package xxx;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import oX0O.II0XooXoX;
import oX0O.Oxx0IOOO;

/* loaded from: classes6.dex */
public class II0xO0 extends XO {
    public final String Oxx0IOOO(Context context, String str) {
        String absolutePath = new File(II0XooXoX.II0xO0(context), str).getAbsolutePath();
        try {
            InputStream open = context.getAssets().open(Oxx0IOOO.f32090oIX0oI + File.separator + str);
            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return absolutePath;
    }

    @Override // xxx.XO
    public String XO(Context context, String str) {
        return Oxx0IOOO(context, str);
    }

    @Override // IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public int getType() {
        return 0;
    }

    @Override // xxx.XO, IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public String oIX0oI(Context context, String str, int i) {
        return null;
    }
}
