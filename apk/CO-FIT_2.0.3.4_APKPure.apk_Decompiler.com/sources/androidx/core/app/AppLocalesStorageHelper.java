package androidx.core.app;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(2:31|32)|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        if (r5 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r5 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0056 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0056=Splitter:B:33:0x0056, B:27:0x004f=Splitter:B:27:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void persistLocales(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Object r1 = sAppLocaleStorageSync
            monitor-enter(r1)
            java.lang.String r2 = ""
            boolean r2 = r6.equals(r2)     // Catch:{ all -> 0x0013 }
            if (r2 == 0) goto L_0x0015
            java.lang.String r6 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r5.deleteFile(r6)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r5 = move-exception
            goto L_0x006b
        L_0x0015:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileOutputStream r5 = r5.openFileOutput(r2, r0)     // Catch:{ FileNotFoundException -> 0x0057 }
            org.xmlpull.v1.XmlSerializer r0 = android.util.Xml.newSerializer()     // Catch:{ all -> 0x0013 }
            r2 = 0
            r0.setOutput(r5, r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "UTF-8"
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r0.startDocument(r3, r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "locales"
            r0.startTag(r2, r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "application_locales"
            r0.attribute(r2, r3, r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = "locales"
            r0.endTag(r2, r6)     // Catch:{ Exception -> 0x0044 }
            r0.endDocument()     // Catch:{ Exception -> 0x0044 }
            if (r5 == 0) goto L_0x004f
        L_0x003e:
            r5.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x004f
        L_0x0042:
            r6 = move-exception
            goto L_0x0051
        L_0x0044:
            r6 = move-exception
            java.lang.String r0 = "AppLocalesStorageHelper"
            java.lang.String r2 = "Storing App Locales : Failed to persist app-locales in storage "
            android.util.Log.w(r0, r2, r6)     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x004f
            goto L_0x003e
        L_0x004f:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            return
        L_0x0051:
            if (r5 == 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            throw r6     // Catch:{ all -> 0x0013 }
        L_0x0057:
            java.lang.String r5 = "AppLocalesStorageHelper"
            java.lang.String r6 = "Storing App Locales : FileNotFoundException: Cannot open file %s for writing "
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0013 }
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r2[r0] = r3     // Catch:{ all -> 0x0013 }
            java.lang.String r6 = java.lang.String.format(r6, r2)     // Catch:{ all -> 0x0013 }
            android.util.Log.w(r5, r6)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            return
        L_0x006b:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.persistLocales(android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|(2:40|41)|42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r2 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        if (r2 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005a, code lost:
        if (r1.isEmpty() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
        r8.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0069 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0056=Splitter:B:32:0x0056, B:42:0x0069=Splitter:B:42:0x0069} */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readLocales(@androidx.annotation.NonNull android.content.Context r8) {
        /*
            java.lang.Object r0 = sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x006a }
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            int r4 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
        L_0x0018:
            int r5 = r3.next()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            r6 = 1
            if (r5 == r6) goto L_0x0044
            r6 = 3
            if (r5 != r6) goto L_0x002b
            int r7 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            if (r7 <= r4) goto L_0x0044
            goto L_0x002b
        L_0x0029:
            r8 = move-exception
            goto L_0x0064
        L_0x002b:
            if (r5 == r6) goto L_0x0018
            r6 = 4
            if (r5 != r6) goto L_0x0031
            goto L_0x0018
        L_0x0031:
            java.lang.String r5 = r3.getName()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            if (r5 == 0) goto L_0x0018
            java.lang.String r4 = "application_locales"
            r5 = 0
            java.lang.String r1 = r3.getAttributeValue(r5, r4)     // Catch:{ IOException | XmlPullParserException -> 0x004c }
        L_0x0044:
            if (r2 == 0) goto L_0x0056
        L_0x0046:
            r2.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0056
        L_0x004a:
            r8 = move-exception
            goto L_0x006c
        L_0x004c:
            java.lang.String r3 = "AppLocalesStorageHelper"
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r3, r4)     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0056
            goto L_0x0046
        L_0x0056:
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch:{ all -> 0x004a }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            throw r8     // Catch:{ all -> 0x004a }
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x006c:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.readLocales(android.content.Context):java.lang.String");
    }
}
