package IoxOx;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import java.util.ArrayList;
import java.util.List;
import me.devilsen.czxing.view.AutoFitSurfaceView;

@RequiresApi(api = 21)
/* loaded from: classes6.dex */
public class oIX0oI extends IOOXOOOOo.II0xO0 {

    /* renamed from: Io, reason: collision with root package name */
    public static final String f818Io = "focus_tag";

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f819OI0 = 2;

    /* renamed from: IIX0o, reason: collision with root package name */
    public CameraCaptureSession f820IIX0o;

    /* renamed from: IO, reason: collision with root package name */
    public boolean f821IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public boolean f822IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final CameraManager f823O0xOxO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public float f824X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public String f825X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public CameraCharacteristics f826XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public final HandlerThread f827XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public final CameraCaptureSession.CaptureCallback f828XOxIOxOx;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f829Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public ImageReader f830XxX0x0xxx;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f831oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public boolean f832oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f833oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public CaptureRequest.Builder f834ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public Size f835x0o;

    /* renamed from: xI, reason: collision with root package name */
    public Rect f836xI;

    /* renamed from: xII, reason: collision with root package name */
    public boolean f837xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public CameraDevice f838xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public Handler f839xxX;

    /* loaded from: classes6.dex */
    public class I0Io implements ImageReader.OnImageAvailableListener {
        public I0Io() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            if (oIX0oI.this.f547o00 != null && oIX0oI.this.f830XxX0x0xxx != null) {
                oIX0oI.this.f547o00.oIX0oI(oIX0oI.this.Io(imageReader), oIX0oI.this.f830XxX0x0xxx.getWidth(), oIX0oI.this.f830XxX0x0xxx.getHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class II0xO0 extends CameraDevice.StateCallback {
        public II0xO0() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            oI00o.II0xO0.xxIXOIIO("Disconnected Camera finish Activity");
            if (oIX0oI.this.f546XO instanceof Activity) {
                ((Activity) oIX0oI.this.f546XO).finish();
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            oI00o.II0xO0.I0Io("Open camera error, code = " + i);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            oIX0oI.this.f838xXxxox0I = cameraDevice;
            oIX0oI.this.XOxIOxOx();
        }
    }

    /* loaded from: classes6.dex */
    public class X0o0xo extends CameraCaptureSession.CaptureCallback {
        public X0o0xo() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            oIX0oI.this.f831oOXoIIIo = false;
            if (oIX0oI.f818Io.equals(captureRequest.getTag())) {
                CaptureRequest.Builder builder = oIX0oI.this.f834ooXIXxIX;
                CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
                builder.set(key, 0);
                oIX0oI.this.f834ooXIXxIX.set(key, 2);
                oIX0oI.this.f834ooXIXxIX.set(key, null);
                try {
                    cameraCaptureSession.setRepeatingRequest(oIX0oI.this.f834ooXIXxIX.build(), null, oIX0oI.this.f839xxX);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            oIX0oI.this.f831oOXoIIIo = false;
        }
    }

    /* loaded from: classes6.dex */
    public class oxoX extends CameraCaptureSession.StateCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ CameraDevice f846oIX0oI;

        public oxoX(CameraDevice cameraDevice) {
            this.f846oIX0oI = cameraDevice;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            oI00o.II0xO0.I0Io("Camera " + this.f846oIX0oI.getId() + " session configuration failed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            oIX0oI.this.f820IIX0o = cameraCaptureSession;
            oIX0oI.this.IO(this.f846oIX0oI, cameraCaptureSession);
        }
    }

    public oIX0oI(Context context, AutoFitSurfaceView autoFitSurfaceView) {
        super(context, autoFitSurfaceView);
        this.f827XIxXXX0x0 = new HandlerThread("CameraThread");
        this.f828XOxIOxOx = new X0o0xo();
        this.f823O0xOxO = (CameraManager) context.getSystemService(PixelReadParams.DEFAULT_FILTER_ID);
    }

    public final void I0oOoX() {
        this.f543Oo.getHolder().addCallback(new SurfaceHolderCallbackC0023oIX0oI());
    }

    @Override // IOOXOOOOo.II0xO0
    public float II0XooXoX() {
        if (this.f824X00IoxXI == 0.0f) {
            this.f824X00IoxXI = ((Float) this.f826XI0IXoo.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() * 7.0f;
        }
        return this.f824X00IoxXI;
    }

    @Override // me.devilsen.czxing.view.AutoFitSurfaceView.oIX0oI
    public void II0xO0(float f) {
        if (f > 0.0f) {
            this.f829Xx000oIo += 1.0f;
        } else {
            this.f829Xx000oIo -= 1.0f;
        }
        OxxIIOOXO(this.f829Xx000oIo);
    }

    public final void IO(CameraDevice cameraDevice, CameraCaptureSession cameraCaptureSession) {
        try {
            CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(1);
            this.f834ooXIXxIX = createCaptureRequest;
            createCaptureRequest.addTarget(this.f830XxX0x0xxx.getSurface());
            this.f834ooXIXxIX.addTarget(this.f543Oo.getHolder().getSurface());
            this.f821IO = false;
            cameraCaptureSession.setRepeatingRequest(this.f834ooXIXxIX.build(), null, this.f839xxX);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public void IXxxXO() {
        if (this.f833oo0xXOI0I && !this.f541IIXOooo) {
            try {
                this.f834ooXIXxIX.set(CaptureRequest.FLASH_MODE, 2);
                this.f820IIX0o.setRepeatingRequest(this.f834ooXIXxIX.build(), null, this.f839xxX);
                this.f541IIXOooo = true;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public byte[] Io(ImageReader imageReader) {
        Image acquireLatestImage = imageReader.acquireLatestImage();
        if (acquireLatestImage == null) {
            return null;
        }
        byte[] x0o2 = x0o(acquireLatestImage);
        acquireLatestImage.close();
        return x0o2;
    }

    public void OI0() {
        if (ContextCompat.checkSelfPermission(this.f546XO, "android.permission.CAMERA") != 0) {
            return;
        }
        if (!this.f827XIxXXX0x0.isAlive()) {
            this.f827XIxXXX0x0.start();
            this.f839xxX = new Handler(this.f827XIxXXX0x0.getLooper());
        }
        try {
            this.f823O0xOxO.openCamera(this.f825X0IIOO, new II0xO0(), this.f839xxX);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public void Oo() {
        this.f837xII = false;
        this.f542IXxxXO.I0Io();
    }

    @Override // IOOXOOOOo.II0xO0
    public void Oxx0IOOO(float f, float f2) {
        try {
            oI00o.II0xO0.oIX0oI("Focus x = " + f + " y = " + f2);
            o0(f, f2);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public float OxxIIOOXO(float f) {
        float II0XooXoX2;
        Rect rect;
        if (this.f826XI0IXoo == null || this.f834ooXIXxIX == null || this.f820IIX0o == null || this.f837xII) {
            return 0.0f;
        }
        try {
            II0XooXoX2 = II0XooXoX();
            rect = (Rect) this.f826XI0IXoo.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > II0XooXoX2) {
            return (int) II0XooXoX2;
        }
        if (f < this.f829Xx000oIo) {
            this.f545OxxIIOOXO = true;
        }
        this.f829Xx000oIo = f;
        int width = (int) (rect.width() / II0XooXoX2);
        int width2 = rect.width() - width;
        int height = rect.height() - ((int) (rect.height() / II0XooXoX2));
        int i = (int) ((width2 / 100) * f);
        int i2 = (int) ((height / 100) * f);
        int i3 = i - (i & 3);
        int i4 = i2 - (i2 & 3);
        this.f834ooXIXxIX.set(CaptureRequest.SCALER_CROP_REGION, new Rect(i3, i4, rect.width() - i3, rect.height() - i4));
        this.f820IIX0o.setRepeatingRequest(this.f834ooXIXxIX.build(), null, this.f839xxX);
        return f;
    }

    @Override // IOOXOOOOo.II0xO0
    public void XO() {
        if (this.f833oo0xXOI0I && this.f541IIXOooo) {
            try {
                this.f834ooXIXxIX.set(CaptureRequest.FLASH_MODE, 0);
                this.f820IIX0o.setRepeatingRequest(this.f834ooXIXxIX.build(), null, this.f839xxX);
                this.f541IIXOooo = false;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public final void XOxIOxOx() {
        boolean z;
        boolean z2;
        ((StreamConfigurationMap) this.f826XI0IXoo.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(35);
        Boolean bool = (Boolean) this.f826XI0IXoo.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        boolean z3 = false;
        if (bool != null && bool.booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        this.f833oo0xXOI0I = z;
        Integer num = (Integer) this.f826XI0IXoo.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num != null && num.intValue() >= 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f832oo = z2;
        Integer num2 = (Integer) this.f826XI0IXoo.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num2 != null && num2.intValue() >= 1) {
            z3 = true;
        }
        this.f822IoOoX = z3;
        this.f836xI = (Rect) this.f826XI0IXoo.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        oI00o.II0xO0.oIX0oI("image reader-preview size: width = " + this.f835x0o.getWidth() + " height = " + this.f835x0o.getHeight());
        ImageReader newInstance = ImageReader.newInstance(this.f835x0o.getWidth(), this.f835x0o.getHeight(), 35, 2);
        this.f830XxX0x0xxx = newInstance;
        newInstance.setOnImageAvailableListener(new I0Io(), null);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f543Oo.getHolder().getSurface());
        arrayList.add(this.f830XxX0x0xxx.getSurface());
        xII(this.f838xXxxox0I, arrayList, this.f839xxX);
    }

    public final void XX() {
        try {
            this.f821IO = true;
            for (String str : this.f823O0xOxO.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = this.f823O0xOxO.getCameraCharacteristics(str);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() != 0) {
                    this.f826XI0IXoo = cameraCharacteristics;
                    this.f825X0IIOO = str;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public final void o0(float f, float f2) throws CameraAccessException {
        if (f < 0.0f || f2 < 0.0f || this.f831oOXoIIIo) {
            return;
        }
        if (this.f836xI != null) {
            f = (int) ((f / this.f543Oo.getWidth()) * this.f836xI.height());
            f2 = (int) ((f2 / this.f543Oo.getHeight()) * this.f836xI.width());
        }
        MeteringRectangle meteringRectangle = new MeteringRectangle((int) Math.max(f2 - 150.0f, 0.0f), (int) Math.max(f - 150.0f, 0.0f), 300, 300, 999);
        this.f820IIX0o.stopRepeating();
        CaptureRequest.Builder builder = this.f834ooXIXxIX;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
        builder.set(key, 0);
        this.f834ooXIXxIX.set(key, 1);
        this.f820IIX0o.capture(this.f834ooXIXxIX.build(), this.f828XOxIOxOx, this.f839xxX);
        if (this.f822IoOoX) {
            this.f834ooXIXxIX.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        if (this.f832oo) {
            this.f834ooXIXxIX.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            this.f834ooXIXxIX.set(CaptureRequest.CONTROL_AF_MODE, 1);
        }
        this.f834ooXIXxIX.setTag(f818Io);
        this.f820IIX0o.capture(this.f834ooXIXxIX.build(), this.f828XOxIOxOx, this.f839xxX);
        this.f831oOXoIIIo = true;
    }

    @Override // IOOXOOOOo.II0xO0
    public void oO() {
        synchronized (oIX0oI.class) {
            try {
                CameraCaptureSession cameraCaptureSession = this.f820IIX0o;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.f820IIX0o = null;
                }
                this.f839xxX.removeCallbacksAndMessages(null);
                this.f827XIxXXX0x0.quitSafely();
                ImageReader imageReader = this.f830XxX0x0xxx;
                if (imageReader != null) {
                    imageReader.close();
                    this.f830XxX0x0xxx = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public boolean ooOOo0oXI() {
        if (this.f836xI != null) {
            return true;
        }
        return false;
    }

    @Override // me.devilsen.czxing.view.AutoFitSurfaceView.oIX0oI
    public void oxoX() {
        float f = this.f829Xx000oIo + 5.0f;
        this.f829Xx000oIo = f;
        OxxIIOOXO(f);
    }

    @Override // IOOXOOOOo.II0xO0
    public void x0XOIxOo() {
        if (this.f838xXxxox0I == null && !this.f821IO) {
            XX();
            I0oOoX();
        }
    }

    @Nullable
    public final byte[] x0o(Image image) {
        byte[] bArr = null;
        if (image != null) {
            try {
                if (image.getPlanes() != null && image.getPlanes().length != 0) {
                    Image.Plane[] planes = image.getPlanes();
                    int remaining = planes[0].getBuffer().remaining();
                    int remaining2 = planes[2].getBuffer().remaining();
                    int width = image.getWidth();
                    int height = image.getHeight();
                    byte[] bArr2 = new byte[remaining];
                    byte[] bArr3 = new byte[remaining2];
                    int i = ((width * height) * 3) / 2;
                    bArr = new byte[i];
                    planes[0].getBuffer().get(bArr2);
                    planes[2].getBuffer().get(bArr3);
                    for (int i2 = 0; i2 < height; i2++) {
                        System.arraycopy(bArr2, planes[0].getRowStride() * i2, bArr, width * i2, width);
                        if (i2 <= image.getHeight() / 2) {
                            int i3 = (height + i2) * width;
                            if (i3 + width < i) {
                                System.arraycopy(bArr3, planes[2].getRowStride() * i2, bArr, i3, width);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return bArr;
    }

    @Override // IOOXOOOOo.II0xO0
    public void x0xO0oo() {
        if (this.f837xII) {
            return;
        }
        this.f837xII = true;
        this.f541IIXOooo = false;
        XO();
        this.f542IXxxXO.oxoX();
        try {
            this.f838xXxxox0I.close();
        } catch (Throwable th) {
            oI00o.II0xO0.I0Io("Error closing camera" + th);
            this.f837xII = false;
        }
    }

    public final void xII(CameraDevice cameraDevice, List<Surface> list, Handler handler) {
        try {
            cameraDevice.createCaptureSession(list, new oxoX(cameraDevice), handler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public float xxIXOIIO() {
        return this.f829Xx000oIo;
    }

    /* renamed from: IoxOx.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class SurfaceHolderCallbackC0023oIX0oI implements SurfaceHolder.Callback {

        /* renamed from: IoxOx.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0024oIX0oI implements Runnable {
            public RunnableC0024oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                oIX0oI.this.OI0();
            }
        }

        public SurfaceHolderCallbackC0023oIX0oI() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            oIX0oI oix0oi = oIX0oI.this;
            oix0oi.f835x0o = IOOXOOOOo.oIX0oI.II0xO0(oix0oi.f543Oo.getDisplay(), oIX0oI.this.f826XI0IXoo, SurfaceHolder.class);
            oI00o.II0xO0.oIX0oI("View finder size: " + oIX0oI.this.f543Oo.getWidth() + " x " + oIX0oI.this.f543Oo.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("Selected preview size: ");
            sb.append(oIX0oI.this.f835x0o);
            oI00o.II0xO0.oIX0oI(sb.toString());
            oIX0oI.this.f543Oo.II0xO0(oIX0oI.this.f835x0o.getWidth(), oIX0oI.this.f835x0o.getHeight());
            oIX0oI.this.f543Oo.post(new RunnableC0024oIX0oI());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public void X0o0xo(byte[] bArr) {
    }
}
