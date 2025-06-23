package com.jieli.jl_filebrowse.bean;

import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/* loaded from: classes10.dex */
public abstract class File extends FileStruct {
    public static final String ROOT_DIR_NAME = "ROOT";
    private final int level;
    private final transient Folder parent;

    public File(Folder folder) {
        this.parent = folder;
        this.level = folder == null ? 0 : folder.getLevel() + 1;
    }

    public static Folder createRootFolder(int i) {
        return new Folder(null, true, 0, (short) 1, ROOT_DIR_NAME, (byte) i);
    }

    public PathData convertPathData(SDCardBean sDCardBean, short s, int i) {
        if (sDCardBean.getIndex() != getDevIndex()) {
            return null;
        }
        return new PathData(CHexConver.intToByte(isFile() ? 1 : 0), CHexConver.intToByte(i), s, sDCardBean.getDevHandler(), getClusterArray());
    }

    public abstract List<Integer> getClusterArray();

    public FileStruct getFileStruct() {
        return new FileStruct(isFile(), isUnicode(), getCluster(), getFileNum(), getName(), getDevIndex());
    }

    public int getLevel() {
        return this.level;
    }

    public Folder getParent() {
        return this.parent;
    }

    public byte[] getPathData() {
        List<Integer> clusterArray = getClusterArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (int size = clusterArray.size() - 1; size >= 0; size--) {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(clusterArray.get(size).intValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getPathString() {
        if (this.parent == null) {
            return "/" + getName();
        }
        return this.parent.getPathString() + "/" + getName();
    }

    public boolean isFolder() {
        return !isFile();
    }

    @Override // com.jieli.jl_filebrowse.bean.FileStruct
    public String toString() {
        return "File{parent=" + this.parent + ",\n level=" + this.level + ", isFile=" + isFile() + ", isUnicode=" + isUnicode() + ", cluster=" + getCluster() + ", devIndex=" + ((int) getDevIndex()) + ", fileNum=" + ((int) getFileNum()) + ", name=\"" + getName() + "\", path=\"" + getPathString() + "\"}";
    }

    public File(Folder folder, FileStruct fileStruct) throws NullPointerException {
        this(folder, fileStruct.isFile(), fileStruct.isUnicode(), fileStruct.getCluster(), fileStruct.getFileNum(), fileStruct.getName(), fileStruct.getDevIndex());
    }

    public File(Folder folder, boolean z, boolean z2, int i, short s, String str, byte b) {
        super(z, z2, i, s, str, b);
        this.parent = folder;
        this.level = folder == null ? 0 : folder.getLevel() + 1;
    }
}
