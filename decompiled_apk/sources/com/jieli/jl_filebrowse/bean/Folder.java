package com.jieli.jl_filebrowse.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class Folder extends File {
    private final transient List<File> files;
    private boolean isLoadFinish;

    public Folder(Folder folder) {
        super(folder);
        this.files = new ArrayList();
        this.isLoadFinish = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addChild$0(File file, File file2) {
        return Integer.compare(file.getFileNum(), file2.getFileNum());
    }

    public void addChild(File file) {
        if (file == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        addChild(arrayList, false);
    }

    public void clean() {
        for (File file : this.files) {
            if (file.isFolder()) {
                ((Folder) file).clean();
            }
        }
        this.files.clear();
        setLoadFinished(false);
    }

    public Folder findFolderByName(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        for (File file : this.files) {
            if (str.equals(file.getName()) && file.isFolder()) {
                return (Folder) file;
            }
        }
        return null;
    }

    public int getChildCount() {
        return this.files.size();
    }

    public File getChildFile(int i) {
        return getChildFile(i, false);
    }

    public List<FileStruct> getChildFileStructs() {
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = this.files.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFileStruct());
        }
        return arrayList;
    }

    @Override // com.jieli.jl_filebrowse.bean.File
    public List<Integer> getClusterArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getCluster()));
        for (Folder parent = getParent(); parent != null; parent = parent.getParent()) {
            int cluster = parent.getCluster();
            if (arrayList.contains(Integer.valueOf(cluster))) {
                break;
            }
            arrayList.add(Integer.valueOf(cluster));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public int getStartIndex() {
        return this.files.size() + 1;
    }

    public boolean isEndElement(FileStruct fileStruct) {
        if (fileStruct == null || this.files.isEmpty() || !this.isLoadFinish) {
            return false;
        }
        List<File> list = this.files;
        if (list.get(list.size() - 1).getCluster() != fileStruct.getCluster()) {
            return false;
        }
        return true;
    }

    public boolean isLoadFinished(boolean z) {
        return this.isLoadFinish;
    }

    public boolean isRootFolder() {
        if (isFolder() && getCluster() == 0 && File.ROOT_DIR_NAME.equals(getName())) {
            return true;
        }
        return false;
    }

    public boolean removeChild(int i) {
        return removeChild(getChildFile(i));
    }

    public void setLoadFinished(boolean z) {
        this.isLoadFinish = z;
    }

    @Override // com.jieli.jl_filebrowse.bean.File, com.jieli.jl_filebrowse.bean.FileStruct
    public String toString() {
        return "Folder{parent=" + getParent() + ",\n level=" + getLevel() + ", isUnicode=" + isUnicode() + ", cluster=" + getCluster() + ", devIndex=" + ((int) getDevIndex()) + ", name=\"" + getName() + "\", path=\"" + getPathString() + "\", isLoadFinish=" + this.isLoadFinish + '}';
    }

    public File getChildFile(int i, boolean z) {
        File childFile;
        for (File file : this.files) {
            if (file.getFileStruct().getCluster() == i) {
                return file;
            }
            if (z && file.isFolder() && (childFile = ((Folder) file).getChildFile(i, true)) != null) {
                return childFile;
            }
        }
        return null;
    }

    public boolean removeChild(File file) {
        if (file == null) {
            return false;
        }
        return this.files.remove(file);
    }

    public Folder(Folder folder, FileStruct fileStruct) throws NullPointerException {
        super(folder, fileStruct);
        this.files = new ArrayList();
        this.isLoadFinish = false;
    }

    public void addChild(List<File> list) {
        addChild(list, false);
    }

    public void addChild(List<File> list, boolean z) {
        if (z) {
            this.files.clear();
        }
        if (list == null) {
            return;
        }
        boolean z2 = false;
        for (File file : list) {
            if (!this.files.contains(file)) {
                this.files.add(file);
                z2 = true;
            }
        }
        if (z2) {
            Collections.sort(this.files, new Comparator() { // from class: com.jieli.jl_filebrowse.bean.oIX0oI
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$addChild$0;
                    lambda$addChild$0 = Folder.lambda$addChild$0((File) obj, (File) obj2);
                    return lambda$addChild$0;
                }
            });
        }
    }

    public Folder(Folder folder, boolean z, int i, short s, String str, byte b) {
        super(folder, false, z, i, s, str, b);
        this.files = new ArrayList();
        this.isLoadFinish = false;
    }
}
