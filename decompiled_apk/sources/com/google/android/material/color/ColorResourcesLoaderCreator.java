package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(30)
/* loaded from: classes9.dex */
public final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    @Nullable
    public static ResourcesLoader create(@NonNull Context context, @NonNull Map<Integer, Integer> map) {
        FileDescriptor fileDescriptor;
        ResourcesProvider loadFromTable;
        try {
            byte[] create = ColorResourcesTableCreator.create(context, map);
            Log.i(TAG, "Table created, length: " + create.length);
            if (create.length != 0) {
                try {
                    fileDescriptor = Os.memfd_create("temp.arsc", 0);
                    try {
                        if (fileDescriptor == null) {
                            Log.w(TAG, "Cannot create memory file descriptor.");
                            if (fileDescriptor != null) {
                                Os.close(fileDescriptor);
                            }
                            return null;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptor);
                        try {
                            fileOutputStream.write(create);
                            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
                            try {
                                II0XooXoX.oIX0oI();
                                ResourcesLoader oIX0oI2 = Oxx0IOOO.oIX0oI();
                                loadFromTable = ResourcesProvider.loadFromTable(dup, null);
                                oIX0oI2.addProvider(loadFromTable);
                                if (dup != null) {
                                    dup.close();
                                }
                                fileOutputStream.close();
                                Os.close(fileDescriptor);
                                return oIX0oI2;
                            } finally {
                            }
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileDescriptor != null) {
                            Os.close(fileDescriptor);
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileDescriptor = null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to create the ColorResourcesTableCreator.", e);
            return null;
        }
    }
}
