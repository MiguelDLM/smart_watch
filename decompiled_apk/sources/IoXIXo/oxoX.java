package IoXIXo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes11.dex */
public class oxoX {

    /* loaded from: classes11.dex */
    public static final class II0xO0 implements Comparator<File> {
        public II0xO0() {
        }

        @Override // java.util.Comparator
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return oIX0oI(file.lastModified(), file2.lastModified());
        }

        public final int oIX0oI(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            if (j == j2) {
                return 0;
            }
            return 1;
        }
    }

    public static void I0Io(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                oxoX(file);
                if (file.lastModified() < currentTimeMillis) {
                    com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18693Oxx0xo, "Last modified date {} is not set for file {}" + new Date(file.lastModified()) + file.getAbsolutePath());
                }
            }
        }
    }

    public static List<File> II0xO0(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new II0xO0());
            return asList;
        }
        return linkedList;
    }

    public static void X0o0xo(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    public static void oIX0oI(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
            return;
        }
        if (file.mkdirs()) {
        } else {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static void oxoX(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            X0o0xo(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }
}
