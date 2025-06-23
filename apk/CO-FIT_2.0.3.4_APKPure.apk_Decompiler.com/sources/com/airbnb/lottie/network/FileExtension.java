package com.airbnb.lottie.network;

import IIXOooo.XO;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;

public enum FileExtension {
    JSON(".json"),
    ZIP(OTAManager.OTA_ZIP_SUFFIX);
    
    public final String extension;

    private FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        XO.X0o0xo("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    public String toString() {
        return this.extension;
    }
}
