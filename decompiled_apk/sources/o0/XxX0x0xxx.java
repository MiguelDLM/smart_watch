package o0;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes8.dex */
public class XxX0x0xxx {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f31014oIX0oI = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f31013II0xO0 = -1;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f31012I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public ValueSet f31015oxoX = null;

    /* loaded from: classes8.dex */
    public static final class II0xO0 implements Result {

        /* renamed from: I0Io, reason: collision with root package name */
        public final String f31016I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f31017II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final boolean f31018oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final ValueSet f31019oxoX;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f31017II0xO0;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f31018oIX0oI;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f31016I0Io;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f31019oxoX;
        }

        public II0xO0(boolean z, int i, String str, ValueSet valueSet) {
            this.f31018oIX0oI = z;
            this.f31017II0xO0 = i;
            this.f31016I0Io = str;
            this.f31019oxoX = valueSet;
        }
    }

    public static final XxX0x0xxx oIX0oI() {
        return new XxX0x0xxx();
    }

    public XxX0x0xxx I0Io(ValueSet valueSet) {
        this.f31015oxoX = valueSet;
        return this;
    }

    public XxX0x0xxx II0xO0(int i) {
        this.f31013II0xO0 = i;
        return this;
    }

    public XxX0x0xxx X0o0xo(boolean z) {
        this.f31014oIX0oI = z;
        return this;
    }

    public Result XO() {
        boolean z = this.f31014oIX0oI;
        int i = this.f31013II0xO0;
        String str = this.f31012I0Io;
        ValueSet valueSet = this.f31015oxoX;
        if (valueSet == null) {
            valueSet = xXxxox0I.oIX0oI().OOXIXo();
        }
        return new II0xO0(z, i, str, valueSet);
    }

    public XxX0x0xxx oxoX(String str) {
        this.f31012I0Io = str;
        return this;
    }
}
