package com.microsoft.cognitiveservices.speech;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.lang3.XX0;

/* loaded from: classes11.dex */
public class KeywordRecognitionModel implements AutoCloseable {
    private boolean disposed = false;
    private SafeHandle keywordModelHandle;

    static {
        Class<?> cls = SpeechConfig.speechConfigClass;
    }

    public KeywordRecognitionModel(IntRef intRef) {
        this.keywordModelHandle = null;
        Contracts.throwIfNull(intRef, "modelHandle");
        this.keywordModelHandle = new SafeHandle(intRef.getValue(), SafeHandleType.KeywordModel);
    }

    private static final native long createKeywordRecognitionModelFromConfig(SafeHandle safeHandle, IntRef intRef);

    private static final native long createKeywordRecognitionModelFromFile(String str, IntRef intRef);

    public static KeywordRecognitionModel fromConfig(EmbeddedSpeechConfig embeddedSpeechConfig) {
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createKeywordRecognitionModelFromConfig(embeddedSpeechConfig.getImpl(), intRef));
        return new KeywordRecognitionModel(intRef);
    }

    public static KeywordRecognitionModel fromFile(String str) {
        Contracts.throwIfFileDoesNotExist(str, TTDownloadField.TT_FILE_NAME);
        try {
            File file = new File(str);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
            byte[] bArr = new byte[2];
            bufferedInputStream.mark(4);
            int read = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            boolean z = false;
            if (read == 2 && bArr[0] == 80 && bArr[1] == 75) {
                z = true;
            }
            if (z) {
                KeywordRecognitionModel fromStream = fromStream(bufferedInputStream, file.getName(), z);
                bufferedInputStream.close();
                return fromStream;
            }
            bufferedInputStream.close();
            IntRef intRef = new IntRef(0L);
            Contracts.throwIfFail(createKeywordRecognitionModelFromFile(file.getCanonicalPath(), intRef));
            return new KeywordRecognitionModel(intRef);
        } catch (FileNotFoundException unused) {
            throw new IllegalArgumentException("fileName not found");
        } catch (IOException e) {
            throw new IllegalArgumentException("could not access file " + e.toString());
        }
    }

    public static KeywordRecognitionModel fromStream(InputStream inputStream, String str, boolean z) throws IOException {
        Contracts.throwIfNull(inputStream, "inputStream");
        Contracts.throwIfNullOrWhitespace(str, "name");
        if (str.contains(File.separator) || str.contains(FileUtils.FILE_EXTENSION_SEPARATOR) || str.contains(":")) {
            throw new IOException("name must not contain separator, ., or :");
        }
        String property = System.getProperty(XX0.f32564X0o0xo);
        Contracts.throwIfNullOrWhitespace(property, "tempFolder");
        String canonicalPath = new File(property).getCanonicalPath();
        Contracts.throwIfNullOrWhitespace(canonicalPath, "canonicalTempFolder");
        File canonicalFile = new File(canonicalPath, "speech-sdk-keyword-" + str).getCanonicalFile();
        if (!canonicalFile.getCanonicalPath().startsWith(canonicalPath)) {
            throw new IOException("invalid kws temp directory " + canonicalFile.getCanonicalPath());
        }
        if (!canonicalFile.exists()) {
            if (!canonicalFile.mkdirs()) {
                throw new IllegalArgumentException("cannot create directory");
            }
            canonicalFile.deleteOnExit();
            if (!canonicalFile.isDirectory()) {
                throw new IllegalArgumentException("path is not a directory");
            }
            byte[] bArr = new byte[1048576];
            FileOutputStream fileOutputStream = null;
            if (z) {
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        StringBuilder sb = new StringBuilder();
                        String str2 = "";
                        sb.append("");
                        sb.append(nextEntry.getName());
                        String sb2 = sb.toString();
                        if (sb2.length() <= 128 && !sb2.contains("..")) {
                            str2 = sb2;
                        }
                        Contracts.throwIfNullOrWhitespace(str2, "zipEntry.name");
                        File file = new File(canonicalFile, str2);
                        if (!file.getCanonicalPath().startsWith(canonicalFile.getCanonicalPath())) {
                            throw new IOException("invalid file " + file.getCanonicalPath());
                        }
                        if (file.exists() && !file.delete()) {
                            throw new IllegalArgumentException("could not delete " + file.getCanonicalPath());
                        }
                        file.deleteOnExit();
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    safeClose(fileOutputStream);
                                    throw th;
                                }
                            }
                            safeClose(fileOutputStream2);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            } else {
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(new File(canonicalFile, "kws.table"));
                    while (true) {
                        try {
                            int read2 = inputStream.read(bArr);
                            if (read2 <= 0) {
                                break;
                            }
                            fileOutputStream3.write(bArr, 0, read2);
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream3;
                            safeClose(fileOutputStream);
                            throw th;
                        }
                    }
                    safeClose(fileOutputStream3);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        File file2 = new File(canonicalFile, "kws.table");
        if (!file2.exists() || !file2.isFile()) {
            throw new IllegalArgumentException("zip did not contain kws.table");
        }
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createKeywordRecognitionModelFromFile(file2.getCanonicalPath(), intRef));
        return new KeywordRecognitionModel(intRef);
    }

    private static final native long keywordRecognitionModelAddUserDefinedWakeWord(SafeHandle safeHandle, String str);

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.keywordModelHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.keywordModelHandle = null;
        }
        this.disposed = true;
    }

    public SafeHandle getImpl() {
        return this.keywordModelHandle;
    }

    public static KeywordRecognitionModel fromConfig(EmbeddedSpeechConfig embeddedSpeechConfig, List<String> list) {
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createKeywordRecognitionModelFromConfig(embeddedSpeechConfig.getImpl(), intRef));
        KeywordRecognitionModel keywordRecognitionModel = new KeywordRecognitionModel(intRef);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Contracts.throwIfFail(keywordRecognitionModelAddUserDefinedWakeWord(keywordRecognitionModel.getImpl(), it.next()));
        }
        return keywordRecognitionModel;
    }
}
