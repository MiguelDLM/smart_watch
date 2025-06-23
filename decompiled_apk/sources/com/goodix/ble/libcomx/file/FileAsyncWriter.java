package com.goodix.ble.libcomx.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes9.dex */
public class FileAsyncWriter extends StreamAsyncWriter {
    private SimpleDateFormat dateFormatter;
    private String fileNamePattern;
    private File outFile;
    private FileOutputStream outputStream;
    private boolean appendable = true;
    private boolean firstRun = true;

    public FileAsyncWriter(File file) {
        this.outFile = file;
    }

    public File getOutFile() {
        return this.outFile;
    }

    @Override // com.goodix.ble.libcomx.file.StreamAsyncWriter
    public void onCloseOutputStream(OutputStream outputStream) {
        if (this.outputStream == outputStream) {
            this.outputStream = null;
        }
    }

    @Override // com.goodix.ble.libcomx.file.StreamAsyncWriter
    public OutputStream onPrepareOutputStream() throws Exception {
        boolean z;
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            return fileOutputStream;
        }
        if (this.outFile == null) {
            String str = this.fileNamePattern;
            if (str != null && str.trim().length() > 0) {
                this.outFile = new File(this.fileNamePattern.replace("${date}", this.dateFormatter.format(new Date())));
            } else {
                return null;
            }
        }
        if (!this.outFile.exists()) {
            File parentFile = this.outFile.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new Exception("Failed to make parent directory: " + parentFile);
            }
            if (this.outFile.createNewFile()) {
                this.outputStream = new FileOutputStream(this.outFile);
            } else {
                throw new Exception("Failed to create file: " + this.outFile.getAbsolutePath());
            }
        } else {
            File file = this.outFile;
            if (this.firstRun && !this.appendable) {
                z = false;
            } else {
                z = true;
            }
            this.outputStream = new FileOutputStream(file, z);
        }
        this.firstRun = false;
        return this.outputStream;
    }

    public void setDateFormatter(String str) {
        SimpleDateFormat simpleDateFormat = this.dateFormatter;
        if (simpleDateFormat != null) {
            simpleDateFormat.applyPattern(str);
        } else {
            this.dateFormatter = new SimpleDateFormat(str, Locale.US);
        }
    }

    public FileAsyncWriter(String str) {
        this.fileNamePattern = str;
        setDateFormatter("yyyyMMdd-HHmmss-SSS");
    }
}
