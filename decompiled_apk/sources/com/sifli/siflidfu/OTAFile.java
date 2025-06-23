package com.sifli.siflidfu;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes11.dex */
public class OTAFile {
    private byte[] fileData;
    private String fileExtension;
    private int fileIndex;
    private String fileName;
    private int fileOrder;
    private String filePath;
    private int imageID;
    private String listName;

    public OTAFile(byte[] bArr, String str) {
        this.fileData = bArr;
        this.fileName = str;
    }

    public byte[] getFileData() {
        return this.fileData;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public int getFileIndex() {
        return this.fileIndex;
    }

    public int getFileLength() {
        byte[] bArr = this.fileData;
        if (bArr == null) {
            return FileProcess.getFileSize(this.filePath);
        }
        return bArr.length;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getImageID() {
        return this.imageID;
    }

    public String getListName() {
        return this.listName;
    }

    public void setFileIndex(int i) {
        this.fileIndex = i;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setImageID(int i) {
        this.imageID = i;
    }

    public OTAFile(String str, byte[] bArr, String str2) {
        this.filePath = str;
        this.fileData = bArr;
        this.fileName = str2;
        this.imageID = -2;
        int indexOf = str2.indexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        if (indexOf == -1) {
            this.fileExtension = Languages.ANY;
            this.listName = str2;
            return;
        }
        String substring = str2.substring(indexOf + 1);
        this.fileExtension = substring;
        substring.toLowerCase();
        this.listName = str2.substring(0, indexOf - 4);
        this.listName += FileUtils.FILE_EXTENSION_SEPARATOR + this.fileExtension;
    }

    public OTAFile(byte[] bArr, int i) {
        this.fileData = bArr;
        this.imageID = i;
    }
}
