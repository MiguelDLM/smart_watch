package com.goodix.ble.libcomx.file;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes9.dex */
public class DelayedFileWriter extends DelayedStreamWriter {
    private SimpleDateFormat dateFormatter;
    private int fileCnt;
    private long fileFirstCreateTime;
    private String fileNamePattern;
    private File outFileOrDir;
    private boolean appendable = true;
    private boolean seperateFile = false;
    private long maxFileSize = 1048576;

    public DelayedFileWriter(File file) {
        this.outFileOrDir = file;
    }

    public File getOutFileOrDir() {
        return this.outFileOrDir;
    }

    @Override // com.goodix.ble.libcomx.file.DelayedStreamWriter
    public void onStartThread() throws Exception {
        String str = this.fileNamePattern;
        if (str != null && str.trim().length() > 0) {
            if (this.fileFirstCreateTime == 0) {
                this.fileFirstCreateTime = System.currentTimeMillis();
            }
            this.outFileOrDir = new File(this.fileNamePattern.replace("@{date}", this.dateFormatter.format(new Date())).replace("@{idx}", String.valueOf(this.fileCnt)));
            if (this.outputStream != null) {
                this.fileCnt++;
            }
        }
        if (!this.outFileOrDir.exists()) {
            File parentFile = this.outFileOrDir.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new Exception("Failed to make parent directory: " + parentFile);
            }
            if (this.outFileOrDir.createNewFile()) {
                this.outputStream = new FileOutputStream(this.outFileOrDir);
                return;
            }
            throw new Exception("Failed to create file: " + this.outFileOrDir.getAbsolutePath());
        }
        this.outputStream = new FileOutputStream(this.outFileOrDir, this.appendable);
    }

    public void setDateFormatter(String str) {
        SimpleDateFormat simpleDateFormat = this.dateFormatter;
        if (simpleDateFormat != null) {
            simpleDateFormat.applyPattern(str);
        } else {
            this.dateFormatter = new SimpleDateFormat(str, Locale.US);
        }
    }

    public DelayedFileWriter(String str) {
        this.fileNamePattern = str;
        setDateFormatter("yyyyMMdd-HHmmss-SSS");
    }
}
