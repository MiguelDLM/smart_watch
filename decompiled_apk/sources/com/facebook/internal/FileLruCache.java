package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes8.dex */
public final class FileLruCache {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String HEADER_CACHEKEY_KEY = "key";

    @OXOo.OOXIXo
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    private static final AtomicLong bufferIndex;
    private final Condition condition;

    @OXOo.OOXIXo
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;

    @OXOo.OOXIXo
    private final AtomicLong lastClearCacheTime;

    @OXOo.OOXIXo
    private final Limits limits;

    @OXOo.OOXIXo
    private final ReentrantLock lock;

    @OXOo.OOXIXo
    private final String tag;

    /* loaded from: classes8.dex */
    public static final class BufferFile {

        @OXOo.OOXIXo
        private static final String FILE_NAME_PREFIX = "buffer";

        @OXOo.OOXIXo
        public static final BufferFile INSTANCE = new BufferFile();

        @OXOo.OOXIXo
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.oOoXoXO
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m206filterExcludeBufferFiles$lambda0;
                m206filterExcludeBufferFiles$lambda0 = FileLruCache.BufferFile.m206filterExcludeBufferFiles$lambda0(file, str);
                return m206filterExcludeBufferFiles$lambda0;
            }
        };

        @OXOo.OOXIXo
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.ooOOo0oXI
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m207filterExcludeNonBufferFiles$lambda1;
                m207filterExcludeNonBufferFiles$lambda1 = FileLruCache.BufferFile.m207filterExcludeNonBufferFiles$lambda1(file, str);
                return m207filterExcludeNonBufferFiles$lambda1;
            }
        };

        private BufferFile() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: filterExcludeBufferFiles$lambda-0, reason: not valid java name */
        public static final boolean m206filterExcludeBufferFiles$lambda0(File file, String filename) {
            IIX0o.oO(filename, "filename");
            return !kotlin.text.OxI.IOOoXo0Ix(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: filterExcludeNonBufferFiles$lambda-1, reason: not valid java name */
        public static final boolean m207filterExcludeNonBufferFiles$lambda1(File file, String filename) {
            IIX0o.oO(filename, "filename");
            return kotlin.text.OxI.IOOoXo0Ix(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        public final void deleteAll(@OXOo.OOXIXo File root) {
            IIX0o.x0xO0oo(root, "root");
            File[] listFiles = root.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    i++;
                    file.delete();
                }
            }
        }

        @OXOo.OOXIXo
        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        @OXOo.OOXIXo
        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        @OXOo.OOXIXo
        public final File newFile(@OXOo.oOoXoXO File file) {
            return new File(file, IIX0o.XIxXXX0x0(FILE_NAME_PREFIX, Long.valueOf(FileLruCache.bufferIndex.incrementAndGet())));
        }
    }

    /* loaded from: classes8.dex */
    public static final class CloseCallbackOutputStream extends OutputStream {

        @OXOo.OOXIXo
        private final StreamCloseCallback callback;

        @OXOo.OOXIXo
        private final OutputStream innerStream;

        public CloseCallbackOutputStream(@OXOo.OOXIXo OutputStream innerStream, @OXOo.OOXIXo StreamCloseCallback callback) {
            IIX0o.x0xO0oo(innerStream, "innerStream");
            IIX0o.x0xO0oo(callback, "callback");
            this.innerStream = innerStream;
            this.callback = callback;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.innerStream.flush();
        }

        @OXOo.OOXIXo
        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        @OXOo.OOXIXo
        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        @Override // java.io.OutputStream
        public void write(@OXOo.OOXIXo byte[] buffer, int i, int i2) throws IOException {
            IIX0o.x0xO0oo(buffer, "buffer");
            this.innerStream.write(buffer, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(@OXOo.OOXIXo byte[] buffer) throws IOException {
            IIX0o.x0xO0oo(buffer, "buffer");
            this.innerStream.write(buffer);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.innerStream.write(i);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final String getTAG() {
            return FileLruCache.TAG;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setByteCount(int i) {
            if (i >= 0) {
                this.byteCount = i;
                return;
            }
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }

        public final void setFileCount(int i) {
            if (i >= 0) {
                this.fileCount = i;
                return;
            }
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
    }

    /* loaded from: classes8.dex */
    public static final class ModifiedFile implements Comparable<ModifiedFile> {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;

        @OXOo.OOXIXo
        private final File file;
        private final long modified;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public ModifiedFile(@OXOo.OOXIXo File file) {
            IIX0o.x0xO0oo(file, "file");
            this.file = file;
            this.modified = file.lastModified();
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if ((obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0) {
                return true;
            }
            return false;
        }

        @OXOo.OOXIXo
        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % Integer.MAX_VALUE));
        }

        @Override // java.lang.Comparable
        public int compareTo(@OXOo.OOXIXo ModifiedFile another) {
            IIX0o.x0xO0oo(another, "another");
            long j = this.modified;
            long j2 = another.modified;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.file.compareTo(another.file);
        }
    }

    /* loaded from: classes8.dex */
    public interface StreamCloseCallback {
        void onClose();
    }

    /* loaded from: classes8.dex */
    public static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        @OXOo.OOXIXo
        public static final StreamHeader INSTANCE = new StreamHeader();

        private StreamHeader() {
        }

        @OXOo.oOoXoXO
        public final JSONObject readHeader(@OXOo.OOXIXo InputStream stream) throws IOException {
            IIX0o.x0xO0oo(stream, "stream");
            if (stream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = stream.read();
                if (read == -1) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int read2 = stream.read(bArr, i, i2 - i);
                if (read2 < 1) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), "readHeader: stream.read stopped at " + i + " when expected " + i2);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr, kotlin.text.oxoX.f29581II0xO0)).nextValue();
                if (!(nextValue instanceof JSONObject)) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), IIX0o.XIxXXX0x0("readHeader: expected JSONObject, got ", nextValue.getClass().getCanonicalName()));
                    return null;
                }
                return (JSONObject) nextValue;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final void writeHeader(@OXOo.OOXIXo OutputStream stream, @OXOo.OOXIXo JSONObject header) throws IOException {
            IIX0o.x0xO0oo(stream, "stream");
            IIX0o.x0xO0oo(header, "header");
            String jSONObject = header.toString();
            IIX0o.oO(jSONObject, "header.toString()");
            byte[] bytes = jSONObject.getBytes(kotlin.text.oxoX.f29581II0xO0);
            IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
            stream.write(0);
            stream.write((bytes.length >> 16) & 255);
            stream.write((bytes.length >> 8) & 255);
            stream.write(bytes.length & 255);
            stream.write(bytes);
        }
    }

    static {
        String simpleName = FileLruCache.class.getSimpleName();
        IIX0o.oO(simpleName, "FileLruCache::class.java.simpleName");
        TAG = simpleName;
        bufferIndex = new AtomicLong();
    }

    public FileLruCache(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Limits limits) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(limits, "limits");
        this.tag = tag;
        this.limits = limits;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        File file = new File(FacebookSdk.getCacheDir(), tag);
        this.directory = file;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.lastClearCacheTime = new AtomicLong(0L);
        if (file.mkdirs() || file.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearCache$lambda-1, reason: not valid java name */
    public static final void m204clearCache$lambda1(File[] filesToDelete) {
        IIX0o.oO(filesToDelete, "filesToDelete");
        int length = filesToDelete.length;
        int i = 0;
        while (i < length) {
            File file = filesToDelete[i];
            i++;
            file.delete();
        }
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.get(str, str2);
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.OOXIXo
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileLruCache.m205postTrim$lambda3$lambda2(FileLruCache.this);
                    }
                });
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: postTrim$lambda-3$lambda-2, reason: not valid java name */
    public static final void m205postTrim$lambda3$lambda2(FileLruCache this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        File file2 = this.directory;
        Utility utility = Utility.INSTANCE;
        if (!file.renameTo(new File(file2, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    private final void trim() {
        long j;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
            try {
                Logger.Companion.log(LoggingBehavior.CACHE, TAG, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long j2 = 0;
                if (listFiles != null) {
                    int length = listFiles.length;
                    j = 0;
                    int i = 0;
                    while (i < length) {
                        File file = listFiles[i];
                        i++;
                        IIX0o.oO(file, "file");
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue.add(modifiedFile);
                        Logger.Companion.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + modifiedFile.getModified() + " name=" + ((Object) modifiedFile.getFile().getName()));
                        j2 += file.length();
                        j++;
                        listFiles = listFiles;
                    }
                } else {
                    j = 0;
                }
                while (true) {
                    if (j2 <= this.limits.getByteCount() && j <= this.limits.getFileCount()) {
                        this.lock.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                            return;
                        } finally {
                        }
                    }
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.Companion.log(LoggingBehavior.CACHE, TAG, IIX0o.XIxXXX0x0("  trim removing ", file2.getName()));
                    j2 -= file2.length();
                    j--;
                    file2.delete();
                }
            } catch (Throwable th) {
                this.lock.lock();
                try {
                    this.isTrimInProgress = false;
                    this.condition.signalAll();
                    oXIO0o0XI oxio0o0xi3 = oXIO0o0XI.f29392oIX0oI;
                    throw th;
                } finally {
                }
            }
        } finally {
        }
    }

    public final void clearCache() {
        final File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.xoIox
                @Override // java.lang.Runnable
                public final void run() {
                    FileLruCache.m204clearCache$lambda1(listFiles);
                }
            });
        }
    }

    @OXOo.oOoXoXO
    @XO0OX.xoIox
    public final InputStream get(@OXOo.OOXIXo String key) throws IOException {
        IIX0o.x0xO0oo(key, "key");
        return get$default(this, key, null, 2, null);
    }

    @OXOo.OOXIXo
    public final String getLocation() {
        String path = this.directory.getPath();
        IIX0o.oO(path, "directory.path");
        return path;
    }

    @OXOo.OOXIXo
    public final InputStream interceptAndPut(@OXOo.OOXIXo String key, @OXOo.OOXIXo InputStream input) throws IOException {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(input, "input");
        return new CopyingInputStream(input, openPutStream$default(this, key, null, 2, null));
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final OutputStream openPutStream(@OXOo.OOXIXo String key) throws IOException {
        IIX0o.x0xO0oo(key, "key");
        return openPutStream$default(this, key, null, 2, null);
    }

    public final long sizeInBytesForTest() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.condition.await();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        reentrantLock.unlock();
        File[] listFiles = this.directory.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file = listFiles[i];
                i++;
                j += file.length();
            }
        }
        return j;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + ((Object) this.directory.getName()) + '}';
    }

    /* loaded from: classes8.dex */
    public static final class CopyingInputStream extends InputStream {

        @OXOo.OOXIXo
        private final InputStream input;

        @OXOo.OOXIXo
        private final OutputStream output;

        public CopyingInputStream(@OXOo.OOXIXo InputStream input, @OXOo.OOXIXo OutputStream output) {
            IIX0o.x0xO0oo(input, "input");
            IIX0o.x0xO0oo(output, "output");
            this.input = input;
            this.output = output;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.input.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @OXOo.OOXIXo
        public final InputStream getInput() {
            return this.input;
        }

        @OXOo.OOXIXo
        public final OutputStream getOutput() {
            return this.output;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read(@OXOo.OOXIXo byte[] buffer) throws IOException {
            IIX0o.x0xO0oo(buffer, "buffer");
            int read = this.input.read(buffer);
            if (read > 0) {
                this.output.write(buffer, 0, read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j) {
                int read = read(bArr, 0, (int) Math.min(j - j2, 1024));
                if (read < 0) {
                    return j2;
                }
                j2 += read;
            }
            return j2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(@OXOo.OOXIXo byte[] buffer, int i, int i2) throws IOException {
            IIX0o.x0xO0oo(buffer, "buffer");
            int read = this.input.read(buffer, i, i2);
            if (read > 0) {
                this.output.write(buffer, i, read);
            }
            return read;
        }
    }

    @OXOo.oOoXoXO
    @XO0OX.xoIox
    public final InputStream get(@OXOo.OOXIXo String key, @OXOo.oOoXoXO String str) throws IOException {
        IIX0o.x0xO0oo(key, "key");
        File file = this.directory;
        Utility utility = Utility.INSTANCE;
        File file2 = new File(file, Utility.md5hash(key));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2), 8192);
            try {
                JSONObject readHeader = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (readHeader == null) {
                    return null;
                }
                if (!IIX0o.Oxx0IOOO(readHeader.optString("key"), key)) {
                    return null;
                }
                String optString = readHeader.optString("tag", null);
                if (str == null && !IIX0o.Oxx0IOOO(str, optString)) {
                    return null;
                }
                long time = new Date().getTime();
                Logger.Companion.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + time + " for " + ((Object) file2.getName()));
                file2.setLastModified(time);
                return bufferedInputStream;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final OutputStream openPutStream(@OXOo.OOXIXo final String key, @OXOo.oOoXoXO String str) throws IOException {
        IIX0o.x0xO0oo(key, "key");
        final File newFile = BufferFile.INSTANCE.newFile(this.directory);
        newFile.delete();
        if (newFile.createNewFile()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                final long currentTimeMillis = System.currentTimeMillis();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() { // from class: com.facebook.internal.FileLruCache$openPutStream$renameToTargetCallback$1
                    @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                    public void onClose() {
                        AtomicLong atomicLong;
                        long j = currentTimeMillis;
                        atomicLong = this.lastClearCacheTime;
                        if (j >= atomicLong.get()) {
                            this.renameToTargetAndTrim(key, newFile);
                        } else {
                            newFile.delete();
                        }
                    }
                }), 8192);
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("key", key);
                        Utility utility = Utility.INSTANCE;
                        if (!Utility.isNullOrEmpty(str)) {
                            jSONObject.put("tag", str);
                        }
                        StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                        return bufferedOutputStream;
                    } catch (JSONException e) {
                        Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, IIX0o.XIxXXX0x0("Error creating JSON header for cache file: ", e));
                        throw new IOException(e.getMessage());
                    }
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, IIX0o.XIxXXX0x0("Error creating buffer output stream: ", e2));
                throw new IOException(e2.getMessage());
            }
        }
        throw new IOException(IIX0o.XIxXXX0x0("Could not create file at ", newFile.getAbsolutePath()));
    }
}
