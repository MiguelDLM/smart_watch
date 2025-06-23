package com.realsil.sdk.dfu.image;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.b.f;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.j.a;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.o.b;
import com.realsil.sdk.dfu.r.d;
import com.realsil.sdk.dfu.r.e;
import com.realsil.sdk.dfu.v.g;
import com.realsil.sdk.dfu.v.h;
import com.realsil.sdk.dfu.v.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class FirmwareLoaderX extends a {
    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        int k = loadParams.k();
        int j = loadParams.j();
        if (j == 16) {
            if (k >= 5) {
                return e.c(loadParams);
            }
            return d.c(loadParams);
        }
        if (j == 17) {
            if (k >= 6) {
                if (loadParams.r()) {
                    return i.d(loadParams);
                }
                return i.c(loadParams);
            }
            return g.c(loadParams);
        }
        if (j == 20) {
            return b.c(loadParams);
        }
        if (j == 21) {
            return com.realsil.sdk.dfu.p.b.c(loadParams);
        }
        if (j == 18) {
            return com.realsil.sdk.dfu.m.b.c(loadParams);
        }
        return com.realsil.sdk.dfu.j.e.c(loadParams);
    }

    public static BinInfo d(LoadParams loadParams) throws LoadFileException {
        int j = loadParams.j();
        int k = loadParams.k();
        if (j == 16) {
            if (k >= 5) {
                if (loadParams.r()) {
                    return e.d(loadParams);
                }
                return e.loadImageBinInfo(loadParams);
            }
            return d.loadImageBinInfo(loadParams);
        }
        if (j == 17) {
            if (k >= 6) {
                if (loadParams.r()) {
                    if (loadParams.o() == 19) {
                        return i.i(loadParams);
                    }
                    if (loadParams.o() == 20) {
                        return i.h(loadParams);
                    }
                    if (loadParams.o() == 23) {
                        return i.f(loadParams);
                    }
                    if (loadParams.o() == 24) {
                        return i.g(loadParams);
                    }
                    return i.e(loadParams);
                }
                return i.loadImageBinInfo(loadParams);
            }
            if (k == 5) {
                if (loadParams.r()) {
                    if (loadParams.o() == 19) {
                        return h.e(loadParams);
                    }
                    if (loadParams.o() == 20) {
                        return h.d(loadParams);
                    }
                    return h.d(loadParams);
                }
                return h.c(loadParams);
            }
            return g.loadImageBinInfo(loadParams);
        }
        if (j == 20) {
            return b.loadImageBinInfo(loadParams);
        }
        if (j == 21) {
            return com.realsil.sdk.dfu.p.b.loadImageBinInfo(loadParams);
        }
        if (j == 18) {
            return com.realsil.sdk.dfu.m.b.loadImageBinInfo(loadParams);
        }
        return com.realsil.sdk.dfu.j.e.loadImageBinInfo(loadParams);
    }

    public static BinInfo loadImageBinInfo(LoadParams loadParams) throws LoadFileException {
        BinInfo d;
        if (loadParams == null) {
            ZLogger.w("loadParams can not be null");
            return null;
        }
        ZLogger.v(loadParams.toString());
        if (loadParams.c() == 1) {
            d = c(loadParams);
        } else {
            d = d(loadParams);
        }
        if (d != null && d.status == 4096) {
            d.status = f.a(loadParams.g(), d);
        }
        return d;
    }

    public static List<BaseBinInputStream> loadImageFile(LoadParams loadParams) throws LoadFileException {
        BinInfo loadImageBinInfo = loadImageBinInfo(loadParams);
        if (loadImageBinInfo != null) {
            if (loadImageBinInfo.status == 4096) {
                return loadImageBinInfo.supportBinInputStreams;
            }
            return new ArrayList();
        }
        return new ArrayList();
    }

    public int getImageVersion(OtaDeviceInfo otaDeviceInfo, int i) {
        if (otaDeviceInfo == null) {
            return 0;
        }
        int protocolType = otaDeviceInfo.getProtocolType();
        if (protocolType != 0) {
            if (protocolType == 16 || protocolType == 17) {
                for (ImageVersionInfo imageVersionInfo : otaDeviceInfo.getExistImageVersionInfos()) {
                    if (otaDeviceInfo.icType <= 3) {
                        if (imageVersionInfo.getBitNumber() == i) {
                            return imageVersionInfo.getVersion();
                        }
                    } else if (imageVersionInfo.getBitNumber() == i || imageVersionInfo.getBitNumber() == i + 16) {
                        return imageVersionInfo.getVersion();
                    }
                }
            }
        } else {
            int i2 = otaDeviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                for (ImageVersionInfo imageVersionInfo2 : otaDeviceInfo.getExistImageVersionInfos()) {
                    if (otaDeviceInfo.icType <= 3) {
                        if (imageVersionInfo2.getBitNumber() == i) {
                            return imageVersionInfo2.getVersion();
                        }
                    } else if (imageVersionInfo2.getBitNumber() == i || imageVersionInfo2.getBitNumber() == i + 16) {
                        return imageVersionInfo2.getVersion();
                    }
                }
            }
        }
        return 0;
    }
}
