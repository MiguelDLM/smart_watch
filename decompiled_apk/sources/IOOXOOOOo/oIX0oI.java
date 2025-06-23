package IOOXOOOOo;

import android.graphics.Point;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Display;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.Arrays;
import java.util.Comparator;

@RequiresApi(api = 21)
/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final II0xO0 f550oIX0oI = new II0xO0(ScreenUtil.DEFAULT_HEIGHT, ScreenUtil.DEFAULT_WIDTH);

    /* renamed from: IOOXOOOOo.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0015oIX0oI implements Comparator<Size> {
        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(Size size, Size size2) {
            return (size.getHeight() * size.getWidth()) - (size2.getHeight() * size2.getWidth());
        }
    }

    public static <T> Size II0xO0(Display display, CameraCharacteristics cameraCharacteristics, Class<T> cls) {
        II0xO0 oIX0oI2 = oIX0oI(display);
        int oIX0oI3 = oIX0oI2.oIX0oI();
        II0xO0 iI0xO0 = f550oIX0oI;
        if (oIX0oI3 >= iI0xO0.oIX0oI() || oIX0oI2.II0xO0() >= iI0xO0.II0xO0()) {
            oIX0oI2 = iI0xO0;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        StreamConfigurationMap.isOutputSupportedFor(cls);
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(cls);
        Arrays.sort(outputSizes, new C0015oIX0oI());
        for (int length = outputSizes.length - 1; length >= 0; length--) {
            II0xO0 iI0xO02 = new II0xO0(outputSizes[length]);
            if (iI0xO02.oIX0oI() <= oIX0oI2.oIX0oI() && iI0xO02.II0xO0() <= oIX0oI2.II0xO0()) {
                return iI0xO02.f553oIX0oI;
            }
        }
        return f550oIX0oI.f553oIX0oI;
    }

    public static II0xO0 oIX0oI(Display display) {
        Point point = new Point();
        display.getRealSize(point);
        return new II0xO0(point.x, point.y);
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f551I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f552II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Size f553oIX0oI;

        public II0xO0(Size size) {
            this.f553oIX0oI = size;
            this.f552II0xO0 = size.getWidth();
            this.f551I0Io = size.getHeight();
        }

        public int II0xO0() {
            return Math.min(this.f552II0xO0, this.f551I0Io);
        }

        public int oIX0oI() {
            return Math.max(this.f552II0xO0, this.f551I0Io);
        }

        public String toString() {
            return "SmartSize{width=" + this.f552II0xO0 + ", height=" + this.f551I0Io + '}';
        }

        public II0xO0(int i, int i2) {
            this.f552II0xO0 = i;
            this.f551I0Io = i2;
        }
    }
}
