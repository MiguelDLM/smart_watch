package com.sma.smartv3.initializer;

import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20835I0Io = "images";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20836II0XooXoX = "smart_watch_recording";

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20837II0xO0 = "agps";

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20838IIX0o = "dial_bg_preview_file.bmp";

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20839IIXOooo = "device_logs";

    /* renamed from: IO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20840IO = "logcat";

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20841IXxxXO = "ble_logs";

    /* renamed from: Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20842Io = "logo_bg_file.png";

    /* renamed from: IoOoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20843IoOoX = "dial";

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20844O0xOxO = "hr_logs";

    /* renamed from: OI0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20845OI0 = "qr";

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20846OOXIXo = "avatar_photo.jpg";

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20847Oo = "share_image.png";

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20848OxI = "device_gps_logs";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20849Oxx0IOOO = "share";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20850Oxx0xo = "run_time_logs";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20851OxxIIOOXO = "rri";

    /* renamed from: X00IoxXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20852X00IoxXI = "fit";

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20853X0IIOO = "test_data_dir";

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20854X0o0xo = "music";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20855XI0IXoo = "gsensor_data_dir";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20856XIxXXX0x0 = "dial_photo_file.jpg";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20857XO = "data";

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20858XOxIOxOx = "pair";

    /* renamed from: Xx000oIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20859Xx000oIo = "gpx";

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20860XxX0x0xxx = "dial_bg_file.bmp";

    /* renamed from: o0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20861o0 = "device_info";

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20862o00 = "device_realtime_logs";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20863oI0IIXIo = "crash";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20864oIX0oI = "logs";

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20865oO = "avatar_final.jpg";

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20866oOXoIIIo = "image_cache";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20867oOoXoXO = "avatar.jpg";

    /* renamed from: oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20868oo = "dial_bg_test3.bmp";

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20869oo0xXOI0I = "dial_bg_test2.png";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20870ooOOo0oXI = "cache_photo.jpg";

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20871ooXIXxIX = "gpx_file.gpx";

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20872oxoX = "videos";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20873x0XOIxOo = "cache.jpg";

    /* renamed from: x0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20874x0o = "watchface";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20875x0xO0oo = "share_image.jpg";

    /* renamed from: xI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20876xI = "dial_bg_test.png";

    /* renamed from: xII, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20877xII = "aigc";

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20878xXxxox0I = "dial_bg_preview_file.png";

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20879xoIox = "watch_recording.pcm";

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20880xoXoI = "device_sleep_logs";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20881xxIXOIIO = "smart_watch_recording.pcm";

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20882xxX = "dial_bg_file.png";

    @OXOo.OOXIXo
    public static final File I0Io(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(oI0IIXIo(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File I0X0x0oIo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20874x0o), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File I0oOIX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String mBleName, @OXOo.OOXIXo String mFirmwareFlag) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        return new File(x0o(oix0oi), mBleName + '_' + mFirmwareFlag);
    }

    @OXOo.OOXIXo
    public static final File I0oOoX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20851OxxIIOOXO), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File II0XooXoX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20867oOoXoXO);
    }

    @OXOo.OOXIXo
    public static final File II0xO0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(IXxxXO(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File IIX0o(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20859Xx000oIo), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File IIXOooo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0("device_info"), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File IO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20842Io);
    }

    @OXOo.OOXIXo
    public static final File IXxxXO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20848OxI), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File Io(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20836II0XooXoX), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File IoOoX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20835I0Io), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File IoOoo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String mBleName, @OXOo.OOXIXo String mFirmwareFlag) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        return new File(x0o(oix0oi), mBleName + '_' + mFirmwareFlag + "_attachment");
    }

    @OXOo.OOXIXo
    public static final File O0Xx(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.oOoXoXO BleDeviceInfo bleDeviceInfo) {
        String str;
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File x0o2 = x0o(oix0oi);
        StringBuilder sb = new StringBuilder();
        String str2 = null;
        if (bleDeviceInfo != null) {
            str = bleDeviceInfo.getMBleName();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append('_');
        if (bleDeviceInfo != null) {
            str2 = bleDeviceInfo.getMFirmwareFlag();
        }
        sb.append(str2);
        return new File(x0o2, sb.toString());
    }

    @OXOo.OOXIXo
    public static final File O0xOxO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20869oo0xXOI0I);
    }

    @OXOo.OOXIXo
    public static final File OI0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20845OI0), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File OO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.oOoXoXO BleDeviceInfo bleDeviceInfo) {
        String str;
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File x0o2 = x0o(oix0oi);
        StringBuilder sb = new StringBuilder();
        String str2 = null;
        if (bleDeviceInfo != null) {
            str = bleDeviceInfo.getMBleName();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append('_');
        if (bleDeviceInfo != null) {
            str2 = bleDeviceInfo.getMFirmwareFlag();
        }
        sb.append(str2);
        sb.append("_attachment");
        return new File(x0o2, sb.toString());
    }

    @OXOo.OOXIXo
    public static final File OO0x0xX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(xXOx(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File OOXIXo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20841IXxxXO), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File Oo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(oOoXoXO(oix0oi), "data");
    }

    @OXOo.OOXIXo
    public static final File OxI(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20876xI);
    }

    @OXOo.OOXIXo
    public static final File Oxx0IOOO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20877xII), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File Oxx0xo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20839IIXOooo), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File OxxIIOOXO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20880xoXoI), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File X00IoxXI(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO(), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File X0IIOO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20868oo);
    }

    @OXOo.OOXIXo
    public static final File X0o0xo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(XI0IXoo(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File XI0IXoo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.oIX0oI().II0xO0(f20843IoOoX), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File XIxXXX0x0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20856XIxXXX0x0);
    }

    @OXOo.OOXIXo
    public static final File XO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(oOoXoXO(oix0oi), f20837II0xO0);
    }

    @OXOo.OOXIXo
    public static final File XOxIOxOx(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        Location location = Location.PUBLIC;
        X00IoxXI.II0xO0 I0Io2 = X00IoxXI.II0xO0.f3231II0xO0.I0Io();
        String appName = AppUtils.getAppName();
        IIX0o.oO(appName, "getAppName(...)");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, location, I0Io2.II0xO0(appName), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File XX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(oOoXoXO(oix0oi), f20879xoIox);
    }

    @OXOo.OOXIXo
    public static final File XX0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20872oxoX), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File Xo0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(xI(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File XoI0Ixx0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(oo0xXOI0I(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File XoX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0("share"), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File Xx000oIo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0("logcat"), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File XxX0x0xxx(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20838IIX0o);
    }

    @OXOo.OOXIXo
    public static final File o0(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(oOoXoXO(oix0oi), f20881xxIXOIIO);
    }

    @OXOo.OOXIXo
    public static final File o00(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20860XxX0x0xxx);
    }

    @OXOo.OOXIXo
    public static final File oI0IIXIo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20862o00), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File oIX0oI(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(OOXIXo(oix0oi), name);
        try {
            if (FileUtils.createOrExistsDir(OOXIXo(oix0oi)) && !FileUtils.isFileExists(file) && file.createNewFile()) {
                FilesKt__FileReadWriteKt.xxIXOIIO(file, "App Name           : " + AppUtils.getAppName() + '\n', null, 2, null);
                FilesKt__FileReadWriteKt.xxIXOIIO(file, "App VersionName    : co_fit_v2BaiduNav_release_" + AppUtils.getAppVersionName() + '\n', null, 2, null);
                FilesKt__FileReadWriteKt.xxIXOIIO(file, "App VersionCode    : " + AppUtils.getAppVersionCode() + '\n', null, 2, null);
                String Oo2 = OI0.oxoX.Oo();
                IIX0o.oO(Oo2, "printRomInfo(...)");
                FilesKt__FileReadWriteKt.xxIXOIIO(file, Oo2, null, 2, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FileUtils.createOrExistsFile(file);
        }
        return file;
    }

    @OXOo.OOXIXo
    public static final File oO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20870ooOOo0oXI);
    }

    @OXOo.OOXIXo
    public static final File oOXoIIIo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.INTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20843IoOoX), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File oOoXoXO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.oIX0oI(), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File oX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0("share"), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File oo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.oIX0oI().II0xO0(f20866oOXoIIIo), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File oo0xXOI0I(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20844O0xOxO), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final String ooOOo0oXI(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        String absolutePath = oOoXoXO(oix0oi).getAbsolutePath();
        IIX0o.oO(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @OXOo.OOXIXo
    public static final File ooXIXxIX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(XoX(oix0oi), f20871ooXIXxIX);
    }

    @OXOo.OOXIXo
    public static final File oxXx0IX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20875x0xO0oo);
    }

    @OXOo.OOXIXo
    public static final File oxoX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        File file = new File(OxxIIOOXO(oix0oi), name);
        FileUtils.createOrExistsFile(file);
        return file;
    }

    @OXOo.OOXIXo
    public static final File oxxXoxO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20850Oxx0xo), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File x0XOIxOo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20873x0XOIxOo);
    }

    @OXOo.OOXIXo
    public static final File x0o(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20858XOxIOxOx), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File x0xO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(name, "name");
        return new File(XOxIOxOx(oix0oi), name);
    }

    @OXOo.OOXIXo
    public static final File x0xO0oo(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20863oI0IIXIo), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File xI(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20855XI0IXoo), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File xII(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0("music"), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File xXOx(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.XO().II0xO0(f20853X0IIOO), null, 4, null);
    }

    @OXOo.OOXIXo
    public static final File xXxxox0I(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        File II0xO02 = X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0(f20852X00IoxXI), null, 4, null);
        FileUtils.createOrExistsDir(II0xO02);
        return II0xO02;
    }

    @OXOo.OOXIXo
    public static final File xo0x(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20847Oo);
    }

    @OXOo.OOXIXo
    public static final File xoIox(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20846OOXIXo);
    }

    public static /* synthetic */ File xoIxX(X00IoxXI.oIX0oI oix0oi, BleDeviceInfo bleDeviceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bleDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
        }
        return OO(oix0oi, bleDeviceInfo);
    }

    @OXOo.OOXIXo
    public static final File xoXoI(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20882xxX);
    }

    public static /* synthetic */ File xoxXI(X00IoxXI.oIX0oI oix0oi, BleDeviceInfo bleDeviceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bleDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
        }
        return O0Xx(oix0oi, bleDeviceInfo);
    }

    @OXOo.OOXIXo
    public static final File xxIXOIIO(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20865oO);
    }

    @OXOo.OOXIXo
    public static final File xxX(@OXOo.OOXIXo X00IoxXI.oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return new File(IoOoX(oix0oi), f20878xXxxox0I);
    }
}
