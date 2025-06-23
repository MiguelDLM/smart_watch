package com.alimm.tanx.core.web.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
class AssetsLoader {
    private static volatile AssetsLoader assetsLoader;
    private CopyOnWriteArraySet<String> mAssetResSet;
    private Context mContext;
    private String mDir = "";
    private boolean mCleared = false;
    private boolean mIsSuffixMod = false;

    private void addAssetsFile(String str) {
        int indexOf;
        String str2 = this.mDir + File.separator;
        if (!TextUtils.isEmpty(this.mDir) && (indexOf = str.indexOf(str2)) >= 0) {
            str = str.substring(indexOf + str2.length());
        }
        this.mAssetResSet.add(str);
    }

    public static AssetsLoader getInstance() {
        if (assetsLoader == null) {
            synchronized (AssetsLoader.class) {
                try {
                    if (assetsLoader == null) {
                        assetsLoader = new AssetsLoader();
                    }
                } finally {
                }
            }
        }
        return assetsLoader;
    }

    private String getUrlPath(String str) {
        try {
            String path = new URL(str).getPath();
            if (path.startsWith("/")) {
                if (path.length() == 1) {
                    return path;
                }
                return path.substring(1);
            }
            return path;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AssetsLoader initResourceNoneRecursion(String str) {
        try {
            LinkedList linkedList = new LinkedList();
            String[] list = AssetsUtil.getApplicationAssets(this.mContext).list(str);
            if (list != null && list.length > 0) {
                for (String str2 : list) {
                    String str3 = str + File.separator + str2;
                    String[] list2 = AssetsUtil.getApplicationAssets(this.mContext).list(str3);
                    if (list2 != null && list2.length != 0) {
                        linkedList.add(str3);
                    }
                    addAssetsFile(str3);
                }
            }
            while (!linkedList.isEmpty() && !this.mCleared) {
                String str4 = (String) linkedList.removeFirst();
                String[] list3 = AssetsUtil.getApplicationAssets(this.mContext).list(str4);
                if (list3 != null && list3.length != 0) {
                    for (String str5 : list3) {
                        AssetManager applicationAssets = AssetsUtil.getApplicationAssets(this.mContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        String str6 = File.separator;
                        sb.append(str6);
                        sb.append(str5);
                        String[] list4 = applicationAssets.list(sb.toString());
                        if (list4 != null && list4.length != 0) {
                            linkedList.add(str4 + str6 + str5);
                        }
                        addAssetsFile(str4 + str6 + str5);
                    }
                }
                addAssetsFile(str4);
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return this;
    }

    public void clear() {
        this.mCleared = true;
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mAssetResSet;
        if (copyOnWriteArraySet != null && copyOnWriteArraySet.size() > 0) {
            this.mAssetResSet.clear();
        }
    }

    public InputStream getAssetFileStream(String str) {
        try {
            return AssetsUtil.getApplicationAssets(this.mContext).open(str);
        } catch (IOException unused) {
            return null;
        }
    }

    public InputStream getResByUrl(String str) {
        String urlPath = getUrlPath(str);
        if (TextUtils.isEmpty(urlPath)) {
            return null;
        }
        if (!this.mIsSuffixMod) {
            if (TextUtils.isEmpty(this.mDir)) {
                return getAssetFileStream(urlPath);
            }
            return getAssetFileStream(this.mDir + File.separator + urlPath);
        }
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mAssetResSet;
        if (copyOnWriteArraySet != null) {
            Iterator<String> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (urlPath.endsWith(next)) {
                    if (TextUtils.isEmpty(this.mDir)) {
                        return getAssetFileStream(next);
                    }
                    return getAssetFileStream(this.mDir + File.separator + next);
                }
            }
        }
        return null;
    }

    public AssetsLoader init(Context context) {
        this.mContext = context;
        this.mAssetResSet = new CopyOnWriteArraySet<>();
        this.mCleared = false;
        return this;
    }

    public AssetsLoader initData() {
        if (!this.mIsSuffixMod) {
            return this;
        }
        if (this.mAssetResSet.size() == 0) {
            new Thread(new Runnable() { // from class: com.alimm.tanx.core.web.cache.AssetsLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    AssetsLoader assetsLoader2 = AssetsLoader.this;
                    assetsLoader2.initResourceNoneRecursion(assetsLoader2.mDir);
                }
            }).start();
        }
        return this;
    }

    public AssetsLoader isAssetsSuffixMod(boolean z) {
        this.mIsSuffixMod = z;
        return this;
    }

    public AssetsLoader setDir(String str) {
        this.mDir = str;
        return this;
    }
}
