package com.facebook.appevents.ml;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class Model {
    private static final int SEQ_LEN = 128;

    @OOXIXo
    private final MTensor convs0Bias;

    @OOXIXo
    private final MTensor convs0Weight;

    @OOXIXo
    private final MTensor convs1Bias;

    @OOXIXo
    private final MTensor convs1Weight;

    @OOXIXo
    private final MTensor convs2Bias;

    @OOXIXo
    private final MTensor convs2Weight;

    @OOXIXo
    private final MTensor embedding;

    @OOXIXo
    private final MTensor fc1Bias;

    @OOXIXo
    private final MTensor fc1Weight;

    @OOXIXo
    private final MTensor fc2Bias;

    @OOXIXo
    private final MTensor fc2Weight;

    @OOXIXo
    private final Map<String, MTensor> finalWeights;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Map<String, String> mapping = o0.oOXoIIIo(Xo0.oIX0oI("embedding.weight", "embed.weight"), Xo0.oIX0oI("dense1.weight", "fc1.weight"), Xo0.oIX0oI("dense2.weight", "fc2.weight"), Xo0.oIX0oI("dense3.weight", "fc3.weight"), Xo0.oIX0oI("dense1.bias", "fc1.bias"), Xo0.oIX0oI("dense2.bias", "fc2.bias"), Xo0.oIX0oI("dense3.bias", "fc3.bias"));

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final Map<String, MTensor> parse(File file) {
            Utils utils = Utils.INSTANCE;
            Map<String, MTensor> parseModelWeights = Utils.parseModelWeights(file);
            if (parseModelWeights == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Map access$getMapping$cp = Model.access$getMapping$cp();
            for (Map.Entry<String, MTensor> entry : parseModelWeights.entrySet()) {
                String key = entry.getKey();
                if (access$getMapping$cp.containsKey(entry.getKey()) && (key = (String) access$getMapping$cp.get(entry.getKey())) == null) {
                    return null;
                }
                hashMap.put(key, entry.getValue());
            }
            return hashMap;
        }

        @oOoXoXO
        public final Model build(@OOXIXo File file) {
            IIX0o.x0xO0oo(file, "file");
            Map<String, MTensor> parse = parse(file);
            IIXOooo iIXOooo = null;
            if (parse == null) {
                return null;
            }
            try {
                return new Model(parse, iIXOooo);
            } catch (Exception unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ Model(Map map, IIXOooo iIXOooo) {
        this(map);
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        if (CrashShieldHandler.isObjectCrashing(Model.class)) {
            return null;
        }
        try {
            return mapping;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Model.class);
            return null;
        }
    }

    @oOoXoXO
    public final MTensor predictOnMTML(@OOXIXo MTensor dense, @OOXIXo String[] texts, @OOXIXo String task) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(dense, "dense");
            IIX0o.x0xO0oo(texts, "texts");
            IIX0o.x0xO0oo(task, "task");
            Operator operator = Operator.INSTANCE;
            MTensor conv1D = Operator.conv1D(Operator.embedding(texts, 128, this.embedding), this.convs0Weight);
            Operator.addmv(conv1D, this.convs0Bias);
            Operator.relu(conv1D);
            MTensor conv1D2 = Operator.conv1D(conv1D, this.convs1Weight);
            Operator.addmv(conv1D2, this.convs1Bias);
            Operator.relu(conv1D2);
            MTensor maxPool1D = Operator.maxPool1D(conv1D2, 2);
            MTensor conv1D3 = Operator.conv1D(maxPool1D, this.convs2Weight);
            Operator.addmv(conv1D3, this.convs2Bias);
            Operator.relu(conv1D3);
            MTensor maxPool1D2 = Operator.maxPool1D(conv1D, conv1D.getShape(1));
            MTensor maxPool1D3 = Operator.maxPool1D(maxPool1D, maxPool1D.getShape(1));
            MTensor maxPool1D4 = Operator.maxPool1D(conv1D3, conv1D3.getShape(1));
            Operator.flatten(maxPool1D2, 1);
            Operator.flatten(maxPool1D3, 1);
            Operator.flatten(maxPool1D4, 1);
            MTensor dense2 = Operator.dense(Operator.concatenate(new MTensor[]{maxPool1D2, maxPool1D3, maxPool1D4, dense}), this.fc1Weight, this.fc1Bias);
            Operator.relu(dense2);
            MTensor dense3 = Operator.dense(dense2, this.fc2Weight, this.fc2Bias);
            Operator.relu(dense3);
            MTensor mTensor = this.finalWeights.get(IIX0o.XIxXXX0x0(task, ".weight"));
            MTensor mTensor2 = this.finalWeights.get(IIX0o.XIxXXX0x0(task, ".bias"));
            if (mTensor != null && mTensor2 != null) {
                MTensor dense4 = Operator.dense(dense3, mTensor, mTensor2);
                Operator.softmax(dense4);
                return dense4;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private Model(Map<String, MTensor> map) {
        MTensor mTensor = map.get("embed.weight");
        if (mTensor != null) {
            this.embedding = mTensor;
            Operator operator = Operator.INSTANCE;
            MTensor mTensor2 = map.get("convs.0.weight");
            if (mTensor2 != null) {
                this.convs0Weight = Operator.transpose3D(mTensor2);
                MTensor mTensor3 = map.get("convs.1.weight");
                if (mTensor3 != null) {
                    this.convs1Weight = Operator.transpose3D(mTensor3);
                    MTensor mTensor4 = map.get("convs.2.weight");
                    if (mTensor4 != null) {
                        this.convs2Weight = Operator.transpose3D(mTensor4);
                        MTensor mTensor5 = map.get("convs.0.bias");
                        if (mTensor5 != null) {
                            this.convs0Bias = mTensor5;
                            MTensor mTensor6 = map.get("convs.1.bias");
                            if (mTensor6 != null) {
                                this.convs1Bias = mTensor6;
                                MTensor mTensor7 = map.get("convs.2.bias");
                                if (mTensor7 != null) {
                                    this.convs2Bias = mTensor7;
                                    MTensor mTensor8 = map.get("fc1.weight");
                                    if (mTensor8 != null) {
                                        this.fc1Weight = Operator.transpose2D(mTensor8);
                                        MTensor mTensor9 = map.get("fc2.weight");
                                        if (mTensor9 != null) {
                                            this.fc2Weight = Operator.transpose2D(mTensor9);
                                            MTensor mTensor10 = map.get("fc1.bias");
                                            if (mTensor10 != null) {
                                                this.fc1Bias = mTensor10;
                                                MTensor mTensor11 = map.get("fc2.bias");
                                                if (mTensor11 != null) {
                                                    this.fc2Bias = mTensor11;
                                                    this.finalWeights = new HashMap();
                                                    for (String str : kotlin.collections.Xo0.OxxIIOOXO(ModelManager.Task.MTML_INTEGRITY_DETECT.toKey(), ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey())) {
                                                        String XIxXXX0x02 = IIX0o.XIxXXX0x0(str, ".weight");
                                                        String XIxXXX0x03 = IIX0o.XIxXXX0x0(str, ".bias");
                                                        MTensor mTensor12 = map.get(XIxXXX0x02);
                                                        MTensor mTensor13 = map.get(XIxXXX0x03);
                                                        if (mTensor12 != null) {
                                                            Operator operator2 = Operator.INSTANCE;
                                                            this.finalWeights.put(XIxXXX0x02, Operator.transpose2D(mTensor12));
                                                        }
                                                        if (mTensor13 != null) {
                                                            this.finalWeights.put(XIxXXX0x03, mTensor13);
                                                        }
                                                    }
                                                    return;
                                                }
                                                throw new IllegalStateException("Required value was null.");
                                            }
                                            throw new IllegalStateException("Required value was null.");
                                        }
                                        throw new IllegalStateException("Required value was null.");
                                    }
                                    throw new IllegalStateException("Required value was null.");
                                }
                                throw new IllegalStateException("Required value was null.");
                            }
                            throw new IllegalStateException("Required value was null.");
                        }
                        throw new IllegalStateException("Required value was null.");
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                throw new IllegalStateException("Required value was null.");
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }
}
