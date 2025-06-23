package XXx0OXXXo;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.XOxIOxOx;
import oI00o.X0o0xo;

/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public Point f4141I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Point f4142II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f4143oIX0oI;

    public oIX0oI(Context context) {
        this.f4143oIX0oI = context;
    }

    public static Point II0XooXoX(Camera.Parameters parameters, Point point) {
        Point oxoX2 = oxoX(parameters.getSupportedPreviewSizes(), point);
        if (oxoX2 == null) {
            return new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return oxoX2;
    }

    public static String X0o0xo(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public static boolean oIX0oI(Camera camera) {
        if (X0o0xo(camera.getParameters().getSupportedFocusModes(), "auto") != null) {
            return true;
        }
        return false;
    }

    public static Point oxoX(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i4 = next.width;
            int i5 = next.height;
            int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
            if (abs == 0) {
                i2 = i5;
                i = i4;
                break;
            }
            if (abs < i3) {
                i2 = i5;
                i = i4;
                i3 = abs;
            }
        }
        if (i > 0 && i2 > 0) {
            return new Point(i, i2);
        }
        return null;
    }

    public final void I0Io(Camera camera, boolean z) {
        String X0o0xo2;
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (z) {
                X0o0xo2 = X0o0xo(parameters.getSupportedFlashModes(), "torch", XOxIOxOx.f29774oxoX);
            } else {
                X0o0xo2 = X0o0xo(parameters.getSupportedFlashModes(), XOxIOxOx.f29771X0o0xo);
            }
            if (X0o0xo2 != null) {
                parameters.setFlashMode(X0o0xo2);
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void II0xO0(Camera camera) {
        I0Io(camera, false);
    }

    public final int[] OOXIXo(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    public final int Oxx0IOOO() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = 0;
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) this.f4143oIX0oI.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        i = 270;
                    }
                } else {
                    i = 180;
                }
            } else {
                i = 90;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public Point XO() {
        return this.f4142II0xO0;
    }

    public void oOoXoXO(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Point point = this.f4141I0Io;
        parameters.setPreviewSize(point.x, point.y);
        int[] OOXIXo2 = OOXIXo(camera, 60.0f);
        if (OOXIXo2 != null) {
            parameters.setPreviewFpsRange(OOXIXo2[0], OOXIXo2[1]);
        }
        camera.setDisplayOrientation(Oxx0IOOO());
        camera.setParameters(parameters);
    }

    public void xoIox(Camera camera) {
        I0Io(camera, true);
    }

    public void xxIXOIIO(Camera camera) {
        Point X0o0xo2 = X0o0xo.X0o0xo(this.f4143oIX0oI);
        Point point = new Point();
        point.x = X0o0xo2.x;
        point.y = X0o0xo2.y;
        if (X0o0xo.XO(this.f4143oIX0oI)) {
            point.x = X0o0xo2.y;
            point.y = X0o0xo2.x;
        }
        this.f4141I0Io = II0XooXoX(camera.getParameters(), point);
        if (X0o0xo.XO(this.f4143oIX0oI)) {
            Point point2 = this.f4141I0Io;
            this.f4142II0xO0 = new Point(point2.y, point2.x);
        } else {
            this.f4142II0xO0 = this.f4141I0Io;
        }
    }
}
