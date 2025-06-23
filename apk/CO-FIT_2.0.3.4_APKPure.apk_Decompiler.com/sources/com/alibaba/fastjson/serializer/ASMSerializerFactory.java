package com.alibaba.fastjson.serializer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.openalliance.ad.constant.x;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.HttpUrl;

public class ASMSerializerFactory implements Opcodes {
    static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
    static final String JavaBeanSerializer;
    static final String JavaBeanSerializer_desc;
    static final String ObjectSerializer;
    static final String ObjectSerializer_desc;
    static final String SerialContext_desc = ASMUtils.desc((Class<?>) SerialContext.class);
    static final String SerializeFilterable_desc = ASMUtils.desc((Class<?>) SerializeFilterable.class);
    static final String SerializeWriter;
    static final String SerializeWriter_desc;
    protected final ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    static {
        String type = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer = type;
        ObjectSerializer_desc = "L" + type + x.aL;
        String type2 = ASMUtils.type(SerializeWriter.class);
        SerializeWriter = type2;
        SerializeWriter_desc = "L" + type2 + x.aL;
        Class<JavaBeanSerializer> cls = JavaBeanSerializer.class;
        JavaBeanSerializer = ASMUtils.type(cls);
        JavaBeanSerializer_desc = "L" + ASMUtils.type(cls) + x.aL;
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(182, str, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var(TypedValues.Custom.S_FLOAT));
            methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(TypedValues.Custom.S_BOOLEAN));
            methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var(TypedValues.Custom.S_STRING));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(182, str, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(182, str, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(199, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(199, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(182, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(154, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (!context.writeDirect) {
            _apply(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(153, label);
            _processKey(methodVisitor, fieldInfo, context);
            _processValue(methodVisitor, fieldInfo, context, label);
        }
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var(TypedValues.Custom.S_FLOAT));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var(TypedValues.Custom.S_FLOAT));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        int i;
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            if (declaringClass.isInterface()) {
                i = 185;
            } else {
                i = 182;
            }
            methodVisitor.visitMethodInsn(i, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
            if (!method.getReturnType().equals(fieldInfo.fieldClass)) {
                methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
                return;
            }
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(180, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
        if (!field.getType().equals(fieldInfo.fieldClass)) {
            methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
        }
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str);
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(182, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        methodVisitor.visitFieldInsn(181, context.className, fieldInfo.name + "_asm_ser_", str);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str);
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(182, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str);
        methodVisitor.visitFieldInsn(181, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _if_write_null(com.alibaba.fastjson.asm.MethodVisitor r18, com.alibaba.fastjson.util.FieldInfo r19, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.Class<?> r4 = r2.fieldClass
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r7 = new com.alibaba.fastjson.asm.Label
            r7.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            r1.visitLabel(r5)
            com.alibaba.fastjson.annotation.JSONField r2 = r19.getAnnotation()
            if (r2 == 0) goto L_0x0030
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r2.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2)
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r9 = r20.beanInfo
            com.alibaba.fastjson.annotation.JSONType r9 = r9.jsonType
            if (r9 == 0) goto L_0x0042
            com.alibaba.fastjson.serializer.SerializerFeature[] r9 = r9.serialzeFeatures()
            int r9 = com.alibaba.fastjson.serializer.SerializerFeature.of(r9)
            r2 = r2 | r9
        L_0x0042:
            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
            java.lang.Class<java.util.Collection> r10 = java.util.Collection.class
            java.lang.Class<java.lang.Number> r11 = java.lang.Number.class
            java.lang.Class<java.lang.String> r12 = java.lang.String.class
            if (r4 != r12) goto L_0x005a
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r14 = r14.getMask()
        L_0x0058:
            r13 = r13 | r14
            goto L_0x0091
        L_0x005a:
            boolean r13 = r11.isAssignableFrom(r4)
            if (r13 == 0) goto L_0x006d
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r14 = r14.getMask()
            goto L_0x0058
        L_0x006d:
            boolean r13 = r10.isAssignableFrom(r4)
            if (r13 == 0) goto L_0x0080
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r14 = r14.getMask()
            goto L_0x0058
        L_0x0080:
            if (r9 != r4) goto L_0x008f
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
            int r13 = r13.getMask()
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r14 = r14.getMask()
            goto L_0x0058
        L_0x008f:
            int r13 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
        L_0x0091:
            r14 = r2 & r13
            java.lang.String r5 = "out"
            r15 = 25
            if (r14 != 0) goto L_0x00ba
            int r14 = r3.var(r5)
            r1.visitVarInsn(r15, r14)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1.visitLdcInsn(r13)
            java.lang.String r13 = SerializeWriter
            java.lang.String r14 = "isEnabled"
            java.lang.String r15 = "(I)Z"
            r16 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r8, r13, r14, r15)
            r8 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r8, r6)
            goto L_0x00bc
        L_0x00ba:
            r16 = r8
        L_0x00bc:
            r1.visitLabel(r7)
            int r7 = r3.var(r5)
            r8 = 25
            r1.visitVarInsn(r8, r7)
            java.lang.String r7 = "seperator"
            int r7 = r3.var(r7)
            r13 = 21
            r1.visitVarInsn(r13, r7)
            java.lang.String r7 = SerializeWriter
            java.lang.String r13 = "write"
            java.lang.String r14 = "(I)V"
            r15 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r15, r7, r13, r14)
            r0._writeFieldName(r1, r3)
            int r5 = r3.var(r5)
            r1.visitVarInsn(r8, r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            if (r4 == r12) goto L_0x0139
            java.lang.Class<java.lang.Character> r2 = java.lang.Character.class
            if (r4 != r2) goto L_0x00f7
            goto L_0x0139
        L_0x00f7:
            boolean r2 = r11.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x0109
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0144
        L_0x0109:
            if (r4 != r9) goto L_0x0117
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0144
        L_0x0117:
            boolean r2 = r10.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x012d
            boolean r2 = r4.isArray()
            if (r2 == 0) goto L_0x0124
            goto L_0x012d
        L_0x0124:
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0144
        L_0x012d:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            goto L_0x0144
        L_0x0139:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r2 = r2.mask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
        L_0x0144:
            java.lang.String r2 = "writeNull"
            java.lang.String r4 = "(II)V"
            r5 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r5, r7, r2, r4)
            r0._seperator(r1, r3)
            r2 = 167(0xa7, float:2.34E-43)
            r3 = r16
            r1.visitJumpInsn(r2, r3)
            r1.visitLabel(r6)
            r1.visitLabel(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory._if_write_null(com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i, char c) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(21, i);
        String str = SerializeWriter;
        methodVisitor.visitMethodInsn(182, str, "writeFieldValue", "(CLjava/lang/String;" + c + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(182, str, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
        methodVisitor.visitJumpInsn(153, label);
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<Serializable> cls2;
        Label label;
        int i;
        int i2;
        int i3;
        Label label2;
        Label label3;
        Label label4;
        String str;
        String str2;
        FieldInfo fieldInfo2;
        Label label5;
        Label label6;
        String str3;
        Label label7;
        Label label8;
        String str4;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo3 = fieldInfo;
        Context context2 = context;
        java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo3.fieldType);
        Class<Serializable> cls3 = null;
        if (collectionItemType instanceof Class) {
            cls2 = (Class) collectionItemType;
        } else {
            cls2 = null;
        }
        if (!(cls2 == Object.class || cls2 == Serializable.class)) {
            cls3 = cls2;
        }
        Label label9 = new Label();
        Label label10 = new Label();
        Label label11 = new Label();
        _nameApply(methodVisitor2, fieldInfo3, context2, label9);
        _get(methodVisitor2, context2, fieldInfo3);
        methodVisitor2.visitTypeInsn(192, "java/util/List");
        methodVisitor2.visitVarInsn(58, context2.var("list"));
        _filters(methodVisitor2, fieldInfo3, context2, label9);
        methodVisitor2.visitVarInsn(25, context2.var("list"));
        methodVisitor2.visitJumpInsn(199, label10);
        _if_write_null(methodVisitor2, fieldInfo3, context2);
        methodVisitor2.visitJumpInsn(167, label11);
        methodVisitor2.visitLabel(label10);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        String str5 = SerializeWriter;
        methodVisitor2.visitMethodInsn(182, str5, "write", "(I)V");
        _writeFieldName(methodVisitor2, context2);
        methodVisitor2.visitVarInsn(25, context2.var("list"));
        Label label12 = label9;
        methodVisitor2.visitMethodInsn(185, "java/util/List", MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, "()I");
        methodVisitor2.visitVarInsn(54, context2.var(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE));
        Label label13 = new Label();
        Label label14 = new Label();
        Label label15 = label11;
        methodVisitor2.visitVarInsn(21, context2.var(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE));
        methodVisitor2.visitInsn(3);
        methodVisitor2.visitJumpInsn(160, label13);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitLdcInsn(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        methodVisitor2.visitMethodInsn(182, str5, "write", "(Ljava/lang/String;)V");
        methodVisitor2.visitJumpInsn(167, label14);
        methodVisitor2.visitLabel(label13);
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            label = label14;
            methodVisitor2.visitMethodInsn(182, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        } else {
            label = label14;
        }
        if (collectionItemType != String.class || !context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(16, 91);
            methodVisitor2.visitMethodInsn(182, str5, "write", "(I)V");
            Label label16 = new Label();
            Label label17 = new Label();
            Label label18 = new Label();
            methodVisitor2.visitInsn(3);
            java.lang.reflect.Type type = collectionItemType;
            methodVisitor2.visitVarInsn(54, context2.var("i"));
            methodVisitor2.visitLabel(label16);
            methodVisitor2.visitVarInsn(21, context2.var("i"));
            methodVisitor2.visitVarInsn(21, context2.var(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE));
            methodVisitor2.visitJumpInsn(162, label18);
            methodVisitor2.visitVarInsn(21, context2.var("i"));
            methodVisitor2.visitJumpInsn(153, label17);
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitMethodInsn(182, str5, "write", "(I)V");
            methodVisitor2.visitLabel(label17);
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(21, context2.var("i"));
            methodVisitor2.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            methodVisitor2.visitVarInsn(58, context2.var("list_item"));
            Label label19 = new Label();
            Label label20 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var("list_item"));
            methodVisitor2.visitJumpInsn(199, label20);
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitMethodInsn(182, str5, "writeNull", "()V");
            methodVisitor2.visitJumpInsn(167, label19);
            methodVisitor2.visitLabel(label20);
            Label label21 = new Label();
            Label label22 = new Label();
            String str6 = str5;
            String str7 = "(I)V";
            if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                label3 = label16;
                label2 = label19;
                str = "out";
                label5 = label21;
                str2 = "write";
                label4 = label18;
                fieldInfo2 = fieldInfo;
                label6 = label22;
            } else {
                str = "out";
                methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                label4 = label18;
                label3 = label16;
                methodVisitor2.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls3)));
                methodVisitor2.visitJumpInsn(166, label22);
                fieldInfo2 = fieldInfo;
                _getListFieldItemSer(context2, methodVisitor2, fieldInfo2, cls3);
                methodVisitor2.visitVarInsn(58, context2.var("list_item_desc"));
                Label label23 = new Label();
                Label label24 = new Label();
                if (context.writeDirect) {
                    if (!context.nonContext || !context.writeDirect) {
                        label2 = label19;
                        label8 = label22;
                        str4 = "write";
                    } else {
                        label2 = label19;
                        str4 = "writeDirectNonContext";
                        label8 = label22;
                    }
                    label7 = label21;
                    methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                    String str8 = JavaBeanSerializer;
                    methodVisitor2.visitTypeInsn(193, str8);
                    methodVisitor2.visitJumpInsn(153, label23);
                    str3 = "write";
                    methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                    methodVisitor2.visitTypeInsn(192, str8);
                    methodVisitor2.visitVarInsn(25, 1);
                    methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor2.visitInsn(1);
                    } else {
                        methodVisitor2.visitVarInsn(21, context2.var("i"));
                        methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls3)));
                    methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                    methodVisitor2.visitMethodInsn(182, str8, str4, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor2.visitJumpInsn(167, label24);
                    methodVisitor2.visitLabel(label23);
                } else {
                    label2 = label19;
                    label7 = label21;
                    label8 = label22;
                    str3 = "write";
                }
                methodVisitor2.visitVarInsn(25, context2.var("list_item_desc"));
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitVarInsn(25, context2.var("list_item"));
                if (context.nonContext) {
                    methodVisitor2.visitInsn(1);
                } else {
                    methodVisitor2.visitVarInsn(21, context2.var("i"));
                    methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls3)));
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                str2 = str3;
                methodVisitor2.visitMethodInsn(185, ObjectSerializer, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor2.visitLabel(label24);
                label5 = label7;
                methodVisitor2.visitJumpInsn(167, label5);
                label6 = label8;
            }
            methodVisitor2.visitLabel(label6);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("list_item"));
            if (context.nonContext) {
                methodVisitor2.visitInsn(1);
            } else {
                methodVisitor2.visitVarInsn(21, context2.var("i"));
                methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                methodVisitor2.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) (Class) type)));
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor2.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            methodVisitor2.visitLabel(label5);
            methodVisitor2.visitLabel(label2);
            i3 = 1;
            methodVisitor2.visitIincInsn(context2.var("i"), 1);
            methodVisitor2.visitJumpInsn(167, label3);
            methodVisitor2.visitLabel(label4);
            i2 = 25;
            methodVisitor2.visitVarInsn(25, context2.var(str));
            methodVisitor2.visitVarInsn(16, 93);
            i = 182;
            methodVisitor2.visitMethodInsn(182, str6, str2, str7);
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("out"));
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitMethodInsn(182, str5, "write", "(Ljava/util/List;)V");
            i3 = 1;
            i2 = 25;
            i = 182;
        }
        methodVisitor2.visitVarInsn(i2, i3);
        methodVisitor2.visitMethodInsn(i, JSONSerializer, "popContext", "()V");
        methodVisitor2.visitLabel(label);
        _seperator(methodVisitor2, context2);
        methodVisitor2.visitLabel(label15);
        methodVisitor2.visitLabel(label12);
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(182, str, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(153, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(154, label);
        }
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            Label label2 = new Label();
            methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
            methodVisitor.visitJumpInsn(153, label2);
            Class<?> cls = fieldInfo.fieldClass;
            if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(21, context.var(TypedValues.Custom.S_BOOLEAN));
                methodVisitor.visitJumpInsn(153, label);
            } else if (cls == Byte.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("byte"));
                methodVisitor.visitJumpInsn(153, label);
            } else if (cls == Short.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("short"));
                methodVisitor.visitJumpInsn(153, label);
            } else if (cls == Integer.TYPE) {
                methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
                methodVisitor.visitJumpInsn(153, label);
            } else if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(22, context.var("long"));
                methodVisitor.visitInsn(9);
                methodVisitor.visitInsn(148);
                methodVisitor.visitJumpInsn(153, label);
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(23, context.var(TypedValues.Custom.S_FLOAT));
                methodVisitor.visitInsn(11);
                methodVisitor.visitInsn(149);
                methodVisitor.visitJumpInsn(153, label);
            } else if (cls == Double.TYPE) {
                methodVisitor.visitVarInsn(24, context.var("double"));
                methodVisitor.visitInsn(14);
                methodVisitor.visitInsn(151);
                methodVisitor.visitJumpInsn(153, label);
            }
            methodVisitor.visitLabel(label2);
        }
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(153, label);
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var(TypedValues.Custom.S_FLOAT));
            methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var(TypedValues.Custom.S_BOOLEAN));
            methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var(TypedValues.Custom.S_STRING));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(182, str, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        methodVisitor.visitVarInsn(58, Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Context context2 = context;
        Label label2 = new Label();
        Class<?> cls = fieldInfo2.fieldClass;
        if (cls.isPrimitive()) {
            Label label3 = new Label();
            methodVisitor2.visitVarInsn(21, context2.var("checkValue"));
            methodVisitor2.visitJumpInsn(154, label3);
            methodVisitor2.visitInsn(1);
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(58, Context.processValue);
            methodVisitor2.visitJumpInsn(167, label2);
            methodVisitor2.visitLabel(label3);
        }
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitLdcInsn(Integer.valueOf(context2.getFieldOrinal(fieldInfo2.name)));
        String str = JavaBeanSerializer;
        StringBuilder sb = new StringBuilder();
        sb.append("(I)");
        Class<BeanContext> cls2 = BeanContext.class;
        sb.append(ASMUtils.desc((Class<?>) cls2));
        methodVisitor2.visitMethodInsn(182, str, "getBeanContext", sb.toString());
        methodVisitor2.visitVarInsn(25, 2);
        methodVisitor2.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("byte"));
            methodVisitor2.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Short.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("short"));
            methodVisitor2.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Integer.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL));
            methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Character.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var("char"));
            methodVisitor2.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Long.TYPE) {
            methodVisitor2.visitVarInsn(22, context2.var("long", 2));
            methodVisitor2.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Float.TYPE) {
            methodVisitor2.visitVarInsn(23, context2.var(TypedValues.Custom.S_FLOAT));
            methodVisitor2.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Double.TYPE) {
            methodVisitor2.visitVarInsn(24, context2.var("double", 2));
            methodVisitor2.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == Boolean.TYPE) {
            methodVisitor2.visitVarInsn(21, context2.var(TypedValues.Custom.S_BOOLEAN));
            methodVisitor2.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitVarInsn(58, Context.original);
        } else if (cls == BigDecimal.class) {
            methodVisitor2.visitVarInsn(25, context2.var("decimal"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (cls == String.class) {
            methodVisitor2.visitVarInsn(25, context2.var(TypedValues.Custom.S_STRING));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (cls.isEnum()) {
            methodVisitor2.visitVarInsn(25, context2.var("enum"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor2.visitVarInsn(25, context2.var("list"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(58, Context.original);
            methodVisitor2.visitVarInsn(25, Context.original);
        }
        methodVisitor2.visitMethodInsn(182, str, "processValue", "(L" + JSONSerializer + x.aL + ASMUtils.desc((Class<?>) cls2) + "Ljava/lang/Object;Ljava/lang/String;" + "Ljava/lang/Object;" + ")Ljava/lang/Object;");
        methodVisitor2.visitVarInsn(58, Context.processValue);
        methodVisitor2.visitVarInsn(25, Context.original);
        methodVisitor2.visitVarInsn(25, Context.processValue);
        methodVisitor2.visitJumpInsn(165, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor2.visitJumpInsn(167, label);
        methodVisitor2.visitLabel(label2);
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(182, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(154, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var(TypedValues.Custom.S_STRING));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var(TypedValues.Custom.S_STRING));
        methodVisitor.visitJumpInsn(199, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        if ("trim".equals(fieldInfo.format)) {
            methodVisitor.visitVarInsn(25, context.var(TypedValues.Custom.S_STRING));
            methodVisitor.visitMethodInsn(182, "java/lang/String", "trim", "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, context.var(TypedValues.Custom.S_STRING));
        }
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var(TypedValues.Custom.S_STRING));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var(TypedValues.Custom.S_STRING));
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        String str;
        Label label2;
        Label label3;
        boolean z;
        boolean z2;
        String str2;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Context context2 = context;
        String format = fieldInfo.getFormat();
        Class<?> cls = fieldInfo2.fieldClass;
        Label label4 = new Label();
        if (context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
        } else {
            methodVisitor2.visitVarInsn(25, Context.processValue);
        }
        methodVisitor2.visitInsn(89);
        methodVisitor2.visitVarInsn(58, context2.var("object"));
        methodVisitor2.visitJumpInsn(199, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor2.visitJumpInsn(167, label);
        methodVisitor2.visitLabel(label4);
        methodVisitor2.visitVarInsn(25, context2.var("out"));
        methodVisitor2.visitVarInsn(21, context2.var("seperator"));
        methodVisitor2.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor2, context2);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.isPrimitive2(cls)) {
            str = format;
            label2 = label5;
            label3 = label6;
        } else {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            methodVisitor2.visitJumpInsn(166, label6);
            _getFieldSer(context2, methodVisitor2, fieldInfo2);
            methodVisitor2.visitVarInsn(58, context2.var("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            String str3 = JavaBeanSerializer;
            methodVisitor2.visitTypeInsn(193, str3);
            methodVisitor2.visitJumpInsn(153, label7);
            int i = fieldInfo2.serialzeFeatures;
            str = format;
            if ((SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((SerializerFeature.BeanToArray.mask & i) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || (context.nonContext && context.writeDirect)) {
                if (z2) {
                    str2 = "writeAsArrayNonContext";
                } else {
                    str2 = "writeDirectNonContext";
                }
            } else if (z2) {
                str2 = "writeAsArray";
            } else {
                str2 = "write";
            }
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            methodVisitor2.visitTypeInsn(192, str3);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            methodVisitor2.visitVarInsn(25, 0);
            String access$300 = context.className;
            methodVisitor2.visitFieldInsn(180, access$300, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            String str4 = JSONSerializer;
            sb.append(str4);
            Label label9 = label5;
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitMethodInsn(182, str3, str2, sb.toString());
            methodVisitor2.visitJumpInsn(167, label8);
            methodVisitor2.visitLabel(label7);
            methodVisitor2.visitVarInsn(25, context2.var("fied_ser"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context2.var("object"));
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            methodVisitor2.visitVarInsn(25, 0);
            String access$3002 = context.className;
            methodVisitor2.visitFieldInsn(180, access$3002, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
            String str5 = ObjectSerializer;
            methodVisitor2.visitMethodInsn(185, str5, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitLabel(label8);
            label2 = label9;
            methodVisitor2.visitJumpInsn(167, label2);
            label3 = label6;
        }
        methodVisitor2.visitLabel(label3);
        methodVisitor2.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context2.var("object"));
        } else {
            methodVisitor2.visitVarInsn(25, Context.processValue);
        }
        if (str != null) {
            methodVisitor2.visitLdcInsn(str);
            methodVisitor2.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor2.visitVarInsn(25, Context.fieldName);
            java.lang.reflect.Type type = fieldInfo2.fieldType;
            if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
                Class<String> cls2 = String.class;
                if (fieldInfo2.fieldClass == cls2) {
                    methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) cls2)));
                } else {
                    methodVisitor2.visitVarInsn(25, 0);
                    String access$3003 = context.className;
                    methodVisitor2.visitFieldInsn(180, access$3003, fieldInfo2.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor2.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                methodVisitor2.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
        }
        methodVisitor2.visitLabel(label2);
        _seperator(methodVisitor2, context2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateWriteAsArray(java.lang.Class<?> r34, com.alibaba.fastjson.asm.MethodVisitor r35, com.alibaba.fastjson.util.FieldInfo[] r36, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r37) throws java.lang.Exception {
        /*
            r33 = this;
            r0 = r33
            r1 = r35
            r2 = r36
            r3 = r37
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            r5 = 25
            r6 = 1
            r1.visitVarInsn(r5, r6)
            r7 = 0
            r1.visitVarInsn(r5, r7)
            java.lang.String r8 = JSONSerializer
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "("
            r9.append(r10)
            java.lang.String r10 = SerializeFilterable_desc
            r9.append(r10)
            java.lang.String r10 = ")Z"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r10 = 182(0xb6, float:2.55E-43)
            java.lang.String r11 = "hasPropertyFilters"
            r1.visitMethodInsn(r10, r8, r11, r9)
            r9 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r9, r4)
            r1.visitVarInsn(r5, r7)
            r1.visitVarInsn(r5, r6)
            r9 = 2
            r1.visitVarInsn(r5, r9)
            r9 = 3
            r1.visitVarInsn(r5, r9)
            r9 = 4
            r1.visitVarInsn(r5, r9)
            r9 = 5
            r11 = 21
            r1.visitVarInsn(r11, r9)
            java.lang.String r9 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "(L"
            r12.append(r13)
            r12.append(r8)
            java.lang.String r8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r12.append(r8)
            java.lang.String r12 = r12.toString()
            r14 = 183(0xb7, float:2.56E-43)
            java.lang.String r15 = "writeNoneASM"
            r1.visitMethodInsn(r14, r9, r15, r12)
            r9 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r9)
            r1.visitLabel(r4)
            java.lang.String r4 = "out"
            int r9 = r3.var(r4)
            r1.visitVarInsn(r5, r9)
            r9 = 91
            r12 = 16
            r1.visitVarInsn(r12, r9)
            java.lang.String r9 = SerializeWriter
            java.lang.String r14 = "write"
            java.lang.String r15 = "(I)V"
            r1.visitMethodInsn(r10, r9, r14, r15)
            int r6 = r2.length
            if (r6 != 0) goto L_0x00aa
            int r2 = r3.var(r4)
            r1.visitVarInsn(r5, r2)
            r2 = 93
            r1.visitVarInsn(r12, r2)
            r1.visitMethodInsn(r10, r9, r14, r15)
            return
        L_0x00aa:
            r9 = 0
        L_0x00ab:
            if (r9 >= r6) goto L_0x08a7
            int r11 = r6 + -1
            if (r9 != r11) goto L_0x00b4
            r11 = 93
            goto L_0x00b6
        L_0x00b4:
            r11 = 44
        L_0x00b6:
            r7 = r2[r9]
            java.lang.Class<?> r12 = r7.fieldClass
            java.lang.String r10 = r7.name
            r1.visitLdcInsn(r10)
            int r10 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r5 = 58
            r1.visitVarInsn(r5, r10)
            java.lang.Class r10 = java.lang.Byte.TYPE
            r5 = 89
            if (r12 == r10) goto L_0x00d4
            java.lang.Class r10 = java.lang.Short.TYPE
            if (r12 == r10) goto L_0x00d4
            java.lang.Class r10 = java.lang.Integer.TYPE
            if (r12 != r10) goto L_0x00e3
        L_0x00d4:
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r2 = r15
            r4 = 25
            r6 = 0
            r9 = 1
            r10 = 182(0xb6, float:2.55E-43)
            goto L_0x0872
        L_0x00e3:
            java.lang.Class r10 = java.lang.Long.TYPE
            if (r12 != r10) goto L_0x011c
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeLong"
            java.lang.String r10 = "(J)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r12, r5, r14, r15)
        L_0x010a:
            r12 = r0
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r2 = r15
        L_0x0112:
            r4 = 25
            r6 = 0
            r9 = 1
            r10 = 182(0xb6, float:2.55E-43)
        L_0x0118:
            r13 = 16
            goto L_0x0893
        L_0x011c:
            java.lang.Class r10 = java.lang.Float.TYPE
            if (r12 != r10) goto L_0x0148
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            r5 = 4
            r1.visitInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeFloat"
            java.lang.String r10 = "(FZ)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r12, r5, r14, r15)
            goto L_0x010a
        L_0x0148:
            java.lang.Class r10 = java.lang.Double.TYPE
            if (r12 != r10) goto L_0x0174
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            r5 = 4
            r1.visitInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeDouble"
            java.lang.String r10 = "(DZ)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r10)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r12, r5, r14, r15)
            goto L_0x010a
        L_0x0174:
            java.lang.Class r10 = java.lang.Boolean.TYPE
            if (r12 != r10) goto L_0x01a6
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "(Z)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r5, r14, r7)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r10, r5, r14, r15)
        L_0x0198:
            r12 = r0
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r2 = r15
            r4 = 25
            r6 = 0
            r9 = 1
            goto L_0x0118
        L_0x01a6:
            java.lang.Class r10 = java.lang.Character.TYPE
            r5 = 184(0xb8, float:2.58E-43)
            if (r12 != r10) goto L_0x01d4
            int r10 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r10)
            r0._get(r1, r3, r7)
            java.lang.String r7 = "toString"
            java.lang.String r10 = "(C)Ljava/lang/String;"
            java.lang.String r12 = "java/lang/Character"
            r1.visitMethodInsn(r5, r12, r7, r10)
            r10 = 16
            r1.visitVarInsn(r10, r11)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeString"
            java.lang.String r11 = "(Ljava/lang/String;C)V"
            r12 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r12, r5, r7, r11)
            goto L_0x010a
        L_0x01d4:
            r10 = 16
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r12 != r5) goto L_0x01f7
            int r5 = r3.var(r4)
            r12 = 25
            r1.visitVarInsn(r12, r5)
            r0._get(r1, r3, r7)
            r1.visitVarInsn(r10, r11)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeString"
            java.lang.String r10 = "(Ljava/lang/String;C)V"
            r11 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r11, r5, r7, r10)
            goto L_0x010a
        L_0x01f7:
            r5 = 25
            r10 = 182(0xb6, float:2.55E-43)
            boolean r16 = r12.isEnum()
            if (r16 == 0) goto L_0x0224
            int r12 = r3.var(r4)
            r1.visitVarInsn(r5, r12)
            r5 = 89
            r1.visitInsn(r5)
            r0._get(r1, r3, r7)
            java.lang.String r5 = SerializeWriter
            java.lang.String r7 = "writeEnum"
            java.lang.String r12 = "(Ljava/lang/Enum;)V"
            r1.visitMethodInsn(r10, r5, r7, r12)
            r7 = 16
            r1.visitVarInsn(r7, r11)
            r1.visitMethodInsn(r10, r5, r14, r15)
            goto L_0x0198
        L_0x0224:
            java.lang.Class<java.util.List> r5 = java.util.List.class
            boolean r5 = r5.isAssignableFrom(r12)
            java.lang.String r10 = "writeWithFieldName"
            if (r5 == 0) goto L_0x05fa
            java.lang.reflect.Type r5 = r7.fieldType
            boolean r12 = r5 instanceof java.lang.Class
            if (r12 == 0) goto L_0x0238
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            goto L_0x0241
        L_0x0238:
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r12 = 0
            r5 = r5[r12]
        L_0x0241:
            boolean r12 = r5 instanceof java.lang.Class
            if (r12 == 0) goto L_0x024c
            r12 = r5
            java.lang.Class r12 = (java.lang.Class) r12
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r12 != r2) goto L_0x024d
        L_0x024c:
            r12 = 0
        L_0x024d:
            r0._get(r1, r3, r7)
            r2 = 192(0xc0, float:2.69E-43)
            r20 = r6
            java.lang.String r6 = "java/util/List"
            r1.visitTypeInsn(r2, r6)
            java.lang.String r2 = "list"
            int r6 = r3.var(r2)
            r21 = r9
            r9 = 58
            r1.visitVarInsn(r9, r6)
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            if (r12 != r6) goto L_0x0298
            boolean r6 = r37.writeDirect
            if (r6 == 0) goto L_0x0298
            int r5 = r3.var(r4)
            r6 = 25
            r1.visitVarInsn(r6, r5)
            int r2 = r3.var(r2)
            r1.visitVarInsn(r6, r2)
            java.lang.String r2 = SerializeWriter
            java.lang.String r5 = "(Ljava/util/List;)V"
            r6 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r6, r2, r14, r5)
            r0 = r4
            r22 = r11
            r5 = r13
            r9 = r15
            r2 = 21
            r4 = 182(0xb6, float:2.55E-43)
            r6 = 25
            r7 = 16
            goto L_0x05e4
        L_0x0298:
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            r22 = r11
            int r11 = r3.var(r2)
            r23 = r10
            r10 = 25
            r1.visitVarInsn(r10, r11)
            r11 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r11, r9)
            int r11 = r3.var(r4)
            r1.visitVarInsn(r10, r11)
            java.lang.String r11 = SerializeWriter
            java.lang.String r10 = "writeNull"
            r18 = r5
            java.lang.String r5 = "()V"
            r24 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r8, r11, r10, r5)
            r5 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r5, r6)
            r1.visitLabel(r9)
            int r5 = r3.var(r2)
            r8 = 25
            r1.visitVarInsn(r8, r5)
            java.lang.String r5 = "size"
            java.lang.String r9 = "()I"
            java.lang.String r10 = "java/util/List"
            r8 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r8, r10, r5, r9)
            java.lang.String r5 = "size"
            int r5 = r3.var(r5)
            r8 = 54
            r1.visitVarInsn(r8, r5)
            int r5 = r3.var(r4)
            r8 = 25
            r1.visitVarInsn(r8, r5)
            r5 = 91
            r8 = 16
            r1.visitVarInsn(r8, r5)
            r5 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r5, r11, r14, r15)
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            r10 = 3
            r1.visitInsn(r10)
            r10 = 54
            r25 = r6
            java.lang.String r6 = "i"
            r26 = r13
            int r13 = r3.var(r6)
            r1.visitVarInsn(r10, r13)
            r1.visitLabel(r5)
            int r10 = r3.var(r6)
            r13 = 21
            r1.visitVarInsn(r13, r10)
            java.lang.String r10 = "size"
            int r10 = r3.var(r10)
            r1.visitVarInsn(r13, r10)
            r10 = 162(0xa2, float:2.27E-43)
            r1.visitJumpInsn(r10, r9)
            int r10 = r3.var(r6)
            r1.visitVarInsn(r13, r10)
            r10 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r10, r8)
            int r10 = r3.var(r4)
            r13 = 25
            r1.visitVarInsn(r13, r10)
            r10 = 44
            r13 = 16
            r1.visitVarInsn(r13, r10)
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r14, r15)
            r1.visitLabel(r8)
            int r2 = r3.var(r2)
            r8 = 25
            r1.visitVarInsn(r8, r2)
            int r2 = r3.var(r6)
            r8 = 21
            r1.visitVarInsn(r8, r2)
            java.lang.String r2 = "get"
            java.lang.String r8 = "(I)Ljava/lang/Object;"
            java.lang.String r10 = "java/util/List"
            r13 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r13, r10, r2, r8)
            java.lang.String r2 = "list_item"
            int r8 = r3.var(r2)
            r10 = 58
            r1.visitVarInsn(r10, r8)
            com.alibaba.fastjson.asm.Label r8 = new com.alibaba.fastjson.asm.Label
            r8.<init>()
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            int r13 = r3.var(r2)
            r27 = r15
            r15 = 25
            r1.visitVarInsn(r15, r13)
            r13 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r13, r10)
            int r13 = r3.var(r4)
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = "writeNull"
            java.lang.String r15 = "()V"
            r28 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r11, r13, r15)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r8)
            r1.visitLabel(r10)
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r10 = new com.alibaba.fastjson.asm.Label
            r10.<init>()
            if (r12 == 0) goto L_0x0530
            int r13 = r12.getModifiers()
            boolean r13 = java.lang.reflect.Modifier.isPublic(r13)
            if (r13 == 0) goto L_0x0530
            int r13 = r3.var(r2)
            r15 = 25
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = "getClass"
            java.lang.String r15 = "()Ljava/lang/Class;"
            r29 = r11
            java.lang.String r11 = "java/lang/Object"
            r30 = r9
            r9 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r9, r11, r13, r15)
            java.lang.String r9 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r9 = com.alibaba.fastjson.asm.Type.getType(r9)
            r1.visitLdcInsn(r9)
            r9 = 166(0xa6, float:2.33E-43)
            r1.visitJumpInsn(r9, r10)
            r0._getListFieldItemSer(r3, r1, r7, r12)
            java.lang.String r9 = "list_item_desc"
            int r11 = r3.var(r9)
            r13 = 58
            r1.visitVarInsn(r13, r11)
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            com.alibaba.fastjson.asm.Label r13 = new com.alibaba.fastjson.asm.Label
            r13.<init>()
            boolean r15 = r37.writeDirect
            if (r15 == 0) goto L_0x04b6
            int r15 = r3.var(r9)
            r0 = 25
            r1.visitVarInsn(r0, r15)
            java.lang.String r15 = JavaBeanSerializer
            r0 = 193(0xc1, float:2.7E-43)
            r1.visitTypeInsn(r0, r15)
            r0 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r0, r11)
            int r0 = r3.var(r9)
            r17 = r5
            r5 = 25
            r1.visitVarInsn(r5, r0)
            r0 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r0, r15)
            r0 = 1
            r1.visitVarInsn(r5, r0)
            int r0 = r3.var(r2)
            r1.visitVarInsn(r5, r0)
            boolean r0 = r37.nonContext
            if (r0 == 0) goto L_0x045f
            r0 = 1
            r1.visitInsn(r0)
            r31 = r8
            r32 = r10
            goto L_0x0477
        L_0x045f:
            int r0 = r3.var(r6)
            r5 = 21
            r1.visitVarInsn(r5, r0)
            java.lang.String r0 = "valueOf"
            java.lang.String r5 = "(I)Ljava/lang/Integer;"
            r31 = r8
            java.lang.String r8 = "java/lang/Integer"
            r32 = r10
            r10 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r10, r8, r0, r5)
        L_0x0477:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = r26
            r0.append(r5)
            java.lang.String r8 = JSONSerializer
            r0.append(r8)
            r8 = r24
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r10 = "writeAsArrayNonContext"
            r24 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r15, r10, r0)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r13)
            r1.visitLabel(r11)
            goto L_0x04c2
        L_0x04b6:
            r17 = r5
            r31 = r8
            r32 = r10
            r8 = r24
            r5 = r26
            r24 = r4
        L_0x04c2:
            int r0 = r3.var(r9)
            r4 = 25
            r1.visitVarInsn(r4, r0)
            r0 = 1
            r1.visitVarInsn(r4, r0)
            int r9 = r3.var(r2)
            r1.visitVarInsn(r4, r9)
            boolean r4 = r37.nonContext
            if (r4 == 0) goto L_0x04e0
            r1.visitInsn(r0)
            goto L_0x04f4
        L_0x04e0:
            int r0 = r3.var(r6)
            r4 = 21
            r1.visitVarInsn(r4, r0)
            java.lang.String r0 = "valueOf"
            java.lang.String r4 = "(I)Ljava/lang/Integer;"
            java.lang.String r9 = "java/lang/Integer"
            r10 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r10, r9, r0, r4)
        L_0x04f4:
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.String r0 = ObjectSerializer
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            java.lang.String r9 = JSONSerializer
            r4.append(r9)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            r9 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r9, r0, r14, r4)
            r1.visitLabel(r13)
            r4 = r24
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r0 = r32
            goto L_0x053d
        L_0x0530:
            r17 = r5
            r31 = r8
            r30 = r9
            r29 = r11
            r8 = r24
            r5 = r26
            r0 = r10
        L_0x053d:
            r1.visitLabel(r0)
            r0 = 25
            r9 = 1
            r1.visitVarInsn(r0, r9)
            int r2 = r3.var(r2)
            r1.visitVarInsn(r0, r2)
            boolean r0 = r37.nonContext
            if (r0 == 0) goto L_0x0559
            r1.visitInsn(r9)
            r2 = 21
            goto L_0x056d
        L_0x0559:
            int r0 = r3.var(r6)
            r2 = 21
            r1.visitVarInsn(r2, r0)
            java.lang.String r0 = "valueOf"
            java.lang.String r9 = "(I)Ljava/lang/Integer;"
            java.lang.String r10 = "java/lang/Integer"
            r11 = 184(0xb8, float:2.58E-43)
            r1.visitMethodInsn(r11, r10, r0, r9)
        L_0x056d:
            if (r12 == 0) goto L_0x059d
            int r0 = r12.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
            if (r0 == 0) goto L_0x059d
            r0 = r18
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r0)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r1.visitLdcInsn(r0)
            int r0 = r7.serialzeFeatures
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.visitLdcInsn(r0)
            java.lang.String r0 = JSONSerializer
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r10 = r23
            r9 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r9, r0, r10, r7)
            goto L_0x05a8
        L_0x059d:
            r10 = r23
            r9 = 182(0xb6, float:2.55E-43)
            java.lang.String r0 = JSONSerializer
            java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r1.visitMethodInsn(r9, r0, r10, r7)
        L_0x05a8:
            r1.visitLabel(r4)
            r0 = r31
            r1.visitLabel(r0)
            int r0 = r3.var(r6)
            r4 = 1
            r1.visitIincInsn(r0, r4)
            r4 = r17
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r0 = r30
            r1.visitLabel(r0)
            r0 = r28
            int r4 = r3.var(r0)
            r6 = 25
            r1.visitVarInsn(r6, r4)
            r4 = 93
            r7 = 16
            r1.visitVarInsn(r7, r4)
            r9 = r27
            r10 = r29
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r10, r14, r9)
            r10 = r25
            r1.visitLabel(r10)
        L_0x05e4:
            int r10 = r3.var(r0)
            r1.visitVarInsn(r6, r10)
            r11 = r22
            r1.visitVarInsn(r7, r11)
            java.lang.String r6 = SerializeWriter
            r1.visitMethodInsn(r4, r6, r14, r9)
            r12 = r33
            r2 = r9
            goto L_0x0112
        L_0x05fa:
            r0 = r4
            r20 = r6
            r21 = r9
            r5 = r13
            r9 = r15
            r2 = 21
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            r13 = r33
            r13._get(r1, r3, r7)
            r15 = 89
            r1.visitInsn(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "field_"
            r15.append(r2)
            r27 = r9
            java.lang.Class<?> r9 = r7.fieldClass
            java.lang.String r9 = r9.getName()
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            int r9 = r3.var(r9)
            r15 = 58
            r1.visitVarInsn(r15, r9)
            r9 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r9, r6)
            int r9 = r3.var(r0)
            r15 = 25
            r1.visitVarInsn(r15, r9)
            java.lang.String r9 = SerializeWriter
            java.lang.String r15 = "writeNull"
            r22 = r11
            java.lang.String r11 = "()V"
            r28 = r0
            r0 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r0, r9, r15, r11)
            r0 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r0, r4)
            r1.visitLabel(r6)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r2)
            java.lang.Class<?> r15 = r7.fieldClass
            java.lang.String r15 = r15.getName()
            r11.append(r15)
            java.lang.String r11 = r11.toString()
            int r11 = r3.var(r11)
            r15 = 25
            r1.visitVarInsn(r15, r11)
            java.lang.String r11 = "getClass"
            java.lang.String r15 = "()Ljava/lang/Class;"
            r18 = r9
            java.lang.String r9 = "java/lang/Object"
            r19 = r4
            r4 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r4, r9, r11, r15)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r4 = com.alibaba.fastjson.asm.Type.getType(r4)
            r1.visitLdcInsn(r4)
            r4 = 166(0xa6, float:2.33E-43)
            r1.visitJumpInsn(r4, r6)
            r13._getFieldSer(r3, r1, r7)
            java.lang.String r4 = "fied_ser"
            int r4 = r3.var(r4)
            r9 = 58
            r1.visitVarInsn(r9, r4)
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r9 = new com.alibaba.fastjson.asm.Label
            r9.<init>()
            boolean r11 = r37.writeDirect
            if (r11 == 0) goto L_0x0757
            int r11 = r12.getModifiers()
            boolean r11 = java.lang.reflect.Modifier.isPublic(r11)
            if (r11 == 0) goto L_0x0757
            java.lang.String r11 = "fied_ser"
            int r11 = r3.var(r11)
            r15 = 25
            r1.visitVarInsn(r15, r11)
            java.lang.String r11 = JavaBeanSerializer
            r15 = 193(0xc1, float:2.7E-43)
            r1.visitTypeInsn(r15, r11)
            r15 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r15, r4)
            java.lang.String r15 = "fied_ser"
            int r15 = r3.var(r15)
            r13 = 25
            r1.visitVarInsn(r13, r15)
            r15 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r15, r11)
            r15 = 1
            r1.visitVarInsn(r13, r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r2)
            java.lang.Class<?> r13 = r7.fieldClass
            java.lang.String r13 = r13.getName()
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            int r13 = r3.var(r13)
            r15 = 25
            r1.visitVarInsn(r15, r13)
            int r13 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r15, r13)
            java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r13 = com.alibaba.fastjson.asm.Type.getType(r13)
            r1.visitLdcInsn(r13)
            int r13 = r7.serialzeFeatures
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1.visitLdcInsn(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r5)
            java.lang.String r15 = JSONSerializer
            r13.append(r15)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            java.lang.String r15 = "writeAsArrayNonContext"
            r23 = r10
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r15, r13)
            r10 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r10, r9)
            r1.visitLabel(r4)
            goto L_0x0759
        L_0x0757:
            r23 = r10
        L_0x0759:
            java.lang.String r4 = "fied_ser"
            int r4 = r3.var(r4)
            r10 = 25
            r1.visitVarInsn(r10, r4)
            r4 = 1
            r1.visitVarInsn(r10, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.Class<?> r11 = r7.fieldClass
            java.lang.String r11 = r11.getName()
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            int r4 = r3.var(r4)
            r1.visitVarInsn(r10, r4)
            int r4 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r10, r4)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            com.alibaba.fastjson.asm.Type r4 = com.alibaba.fastjson.asm.Type.getType(r4)
            r1.visitLdcInsn(r4)
            int r4 = r7.serialzeFeatures
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.visitLdcInsn(r4)
            java.lang.String r4 = ObjectSerializer
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            java.lang.String r11 = JSONSerializer
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            r12 = 185(0xb9, float:2.59E-43)
            r1.visitMethodInsn(r12, r4, r14, r10)
            r1.visitLabel(r9)
            r4 = 167(0xa7, float:2.34E-43)
            r1.visitJumpInsn(r4, r0)
            r1.visitLabel(r6)
            java.lang.String r4 = r7.getFormat()
            r6 = 25
            r9 = 1
            r1.visitVarInsn(r6, r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r2)
            java.lang.Class<?> r2 = r7.fieldClass
            java.lang.String r2 = r2.getName()
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            int r2 = r3.var(r2)
            r1.visitVarInsn(r6, r2)
            if (r4 == 0) goto L_0x07fa
            r1.visitLdcInsn(r4)
            java.lang.String r2 = "writeWithFormat"
            java.lang.String r4 = "(Ljava/lang/Object;Ljava/lang/String;)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r2, r4)
        L_0x07f8:
            r6 = 0
            goto L_0x084d
        L_0x07fa:
            r10 = 182(0xb6, float:2.55E-43)
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r1.visitVarInsn(r6, r2)
            java.lang.reflect.Type r2 = r7.fieldType
            boolean r4 = r2 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0817
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r2 = r2.isPrimitive()
            if (r2 == 0) goto L_0x0817
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
            r4 = r23
            r1.visitMethodInsn(r10, r11, r4, r2)
            goto L_0x07f8
        L_0x0817:
            r4 = r23
            r2 = 25
            r6 = 0
            r1.visitVarInsn(r2, r6)
            java.lang.String r2 = r37.className
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r7.name
            r10.append(r12)
            java.lang.String r12 = "_asm_fieldType"
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.String r12 = "Ljava/lang/reflect/Type;"
            r13 = 180(0xb4, float:2.52E-43)
            r1.visitFieldInsn(r13, r2, r10, r12)
            int r2 = r7.serialzeFeatures
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.visitLdcInsn(r2)
            java.lang.String r2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            r10 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r10, r11, r4, r2)
        L_0x084d:
            r1.visitLabel(r0)
            r0 = r19
            r1.visitLabel(r0)
            r0 = r28
            int r2 = r3.var(r0)
            r4 = 25
            r1.visitVarInsn(r4, r2)
            r11 = r22
            r2 = 16
            r1.visitVarInsn(r2, r11)
            r7 = r18
            r2 = r27
            r1.visitMethodInsn(r10, r7, r14, r2)
            r12 = r33
            goto L_0x0118
        L_0x0872:
            int r12 = r3.var(r0)
            r1.visitVarInsn(r4, r12)
            r12 = 89
            r1.visitInsn(r12)
            r12 = r33
            r12._get(r1, r3, r7)
            java.lang.String r7 = SerializeWriter
            java.lang.String r13 = "writeInt"
            r1.visitMethodInsn(r10, r7, r13, r2)
            r13 = 16
            r1.visitVarInsn(r13, r11)
            r1.visitMethodInsn(r10, r7, r14, r2)
        L_0x0893:
            int r7 = r21 + 1
            r4 = r0
            r15 = r2
            r13 = r5
            r9 = r7
            r0 = r12
            r6 = r20
            r5 = 25
            r7 = 0
            r11 = 21
            r12 = 16
            r2 = r36
            goto L_0x00ab
        L_0x08a7:
            r12 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.generateWriteAsArray(java.lang.Class, com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo[], com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x04a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateWriteMethod(java.lang.Class<?> r23, com.alibaba.fastjson.asm.MethodVisitor r24, com.alibaba.fastjson.util.FieldInfo[] r25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context r26) throws java.lang.Exception {
        /*
            r22 = this;
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            int r13 = r10.length
            boolean r0 = r26.writeDirect
            java.lang.String r1 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            java.lang.String r2 = "(I)Z"
            java.lang.String r3 = "isEnabled"
            java.lang.String r14 = "write"
            java.lang.String r4 = "(L"
            java.lang.String r5 = "out"
            r15 = 25
            if (r0 != 0) goto L_0x00c9
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            r19 = r12
            int r12 = r11.var(r5)
            r9.visitVarInsn(r15, r12)
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            int r12 = r12.mask
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.visitLdcInsn(r12)
            java.lang.String r12 = SerializeWriter
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r12, r3, r2)
            r12 = 154(0x9a, float:2.16E-43)
            r9.visitJumpInsn(r12, r6)
            int r12 = r10.length
            r15 = 0
        L_0x0051:
            if (r15 >= r12) goto L_0x0081
            r20 = r12
            r12 = r10[r15]
            java.lang.reflect.Method r12 = r12.method
            if (r12 == 0) goto L_0x007c
            int r12 = r11.var(r5)
            r15 = 25
            r9.visitVarInsn(r15, r12)
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter
            int r12 = r12.mask
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.visitLdcInsn(r12)
            java.lang.String r12 = SerializeWriter
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r12, r3, r2)
            r12 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r12, r0)
            goto L_0x0086
        L_0x007c:
            int r15 = r15 + 1
            r12 = r20
            goto L_0x0051
        L_0x0081:
            r12 = 167(0xa7, float:2.34E-43)
            r9.visitJumpInsn(r12, r0)
        L_0x0086:
            r9.visitLabel(r6)
            r6 = 0
            r12 = 25
            r9.visitVarInsn(r12, r6)
            r6 = 1
            r9.visitVarInsn(r12, r6)
            r6 = 2
            r9.visitVarInsn(r12, r6)
            r6 = 3
            r9.visitVarInsn(r12, r6)
            r6 = 4
            r9.visitVarInsn(r12, r6)
            r6 = 5
            r12 = 21
            r9.visitVarInsn(r12, r6)
            java.lang.String r6 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.String r15 = JSONSerializer
            r12.append(r15)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r15 = 183(0xb7, float:2.56E-43)
            r9.visitMethodInsn(r15, r6, r14, r12)
            r6 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r6)
            r9.visitLabel(r0)
            goto L_0x00cb
        L_0x00c9:
            r19 = r12
        L_0x00cb:
            boolean r0 = r26.nonContext
            if (r0 != 0) goto L_0x0117
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r6 = 0
            r12 = 25
            r9.visitVarInsn(r12, r6)
            r6 = 1
            r9.visitVarInsn(r12, r6)
            r6 = 2
            r9.visitVarInsn(r12, r6)
            r6 = 5
            r12 = 21
            r9.visitVarInsn(r12, r6)
            java.lang.String r6 = JavaBeanSerializer
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.String r15 = JSONSerializer
            r12.append(r15)
            java.lang.String r15 = ";Ljava/lang/Object;I)Z"
            r12.append(r15)
            java.lang.String r12 = r12.toString()
            java.lang.String r15 = "writeReference"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r6, r15, r12)
            r6 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r6, r0)
            r6 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r6)
            r9.visitLabel(r0)
        L_0x0117:
            boolean r0 = r26.writeDirect
            if (r0 == 0) goto L_0x012b
            boolean r0 = r26.nonContext
            if (r0 == 0) goto L_0x0127
            java.lang.String r0 = "writeAsArrayNonContext"
            goto L_0x012e
        L_0x0127:
            java.lang.String r0 = "writeAsArray"
            goto L_0x012e
        L_0x012b:
            java.lang.String r0 = "writeAsArrayNormal"
        L_0x012e:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r26.beanInfo
            int r6 = r6.features
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray
            int r12 = r8.mask
            r6 = r6 & r12
            if (r6 != 0) goto L_0x01a0
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            int r12 = r11.var(r5)
            r15 = 25
            r9.visitVarInsn(r15, r12)
            int r8 = r8.mask
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.visitLdcInsn(r8)
            java.lang.String r8 = SerializeWriter
            r12 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r12, r8, r3, r2)
            r2 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r2, r6)
            r2 = 0
            r9.visitVarInsn(r15, r2)
            r2 = 1
            r9.visitVarInsn(r15, r2)
            r2 = 2
            r9.visitVarInsn(r15, r2)
            r2 = 3
            r9.visitVarInsn(r15, r2)
            r2 = 4
            r9.visitVarInsn(r15, r2)
            r2 = 5
            r3 = 21
            r9.visitVarInsn(r3, r2)
            java.lang.String r2 = r26.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r8 = JSONSerializer
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r3, r2, r0, r1)
            r0 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r0)
            r9.visitLabel(r6)
            r6 = 21
            goto L_0x01de
        L_0x01a0:
            r2 = 0
            r3 = 25
            r9.visitVarInsn(r3, r2)
            r2 = 1
            r9.visitVarInsn(r3, r2)
            r2 = 2
            r9.visitVarInsn(r3, r2)
            r2 = 3
            r9.visitVarInsn(r3, r2)
            r2 = 4
            r9.visitVarInsn(r3, r2)
            r2 = 5
            r6 = 21
            r9.visitVarInsn(r6, r2)
            java.lang.String r2 = r26.className
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r8 = JSONSerializer
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r3, r2, r0, r1)
            r0 = 177(0xb1, float:2.48E-43)
            r9.visitInsn(r0)
        L_0x01de:
            boolean r0 = r26.nonContext
            java.lang.String r8 = "parent"
            java.lang.String r12 = "("
            if (r0 != 0) goto L_0x0250
            r0 = 1
            r1 = 25
            r9.visitVarInsn(r1, r0)
            java.lang.String r0 = JSONSerializer
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "()"
            r1.append(r2)
            java.lang.String r2 = SerialContext_desc
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "getContext"
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r0, r3, r1)
            int r1 = r11.var(r8)
            r3 = 58
            r9.visitVarInsn(r3, r1)
            r1 = 1
            r3 = 25
            r9.visitVarInsn(r3, r1)
            int r1 = r11.var(r8)
            r9.visitVarInsn(r3, r1)
            r1 = 2
            r9.visitVarInsn(r3, r1)
            r1 = 3
            r9.visitVarInsn(r3, r1)
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r26.beanInfo
            int r1 = r1.features
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9.visitLdcInsn(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            r1.append(r2)
            java.lang.String r2 = "Ljava/lang/Object;Ljava/lang/Object;I)V"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "setContext"
            r3 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r3, r0, r2, r1)
        L_0x0250:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r0 = r26.beanInfo
            int r0 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            int r1 = r1.mask
            r0 = r0 & r1
            if (r0 == 0) goto L_0x025f
            r0 = 1
            goto L_0x0260
        L_0x025f:
            r0 = 0
        L_0x0260:
            r15 = 123(0x7b, float:1.72E-43)
            r3 = 16
            if (r0 != 0) goto L_0x0274
            boolean r1 = r26.writeDirect
            if (r1 != 0) goto L_0x026d
            goto L_0x0274
        L_0x026d:
            r9.visitVarInsn(r3, r15)
            r18 = r8
            goto L_0x0336
        L_0x0274:
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            if (r0 != 0) goto L_0x02a9
            r0 = 1
            r3 = 25
            r9.visitVarInsn(r3, r0)
            r0 = 4
            r9.visitVarInsn(r3, r0)
            r15 = 2
            r9.visitVarInsn(r3, r15)
            java.lang.String r15 = JSONSerializer
            java.lang.String r0 = "isWriteClassName"
            java.lang.String r3 = "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z"
            r18 = r8
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r15, r0, r3)
            r0 = 153(0x99, float:2.14E-43)
            r9.visitJumpInsn(r0, r2)
        L_0x02a5:
            r0 = 4
            r3 = 25
            goto L_0x02ae
        L_0x02a9:
            r18 = r8
            r8 = 182(0xb6, float:2.55E-43)
            goto L_0x02a5
        L_0x02ae:
            r9.visitVarInsn(r3, r0)
            r0 = 2
            r9.visitVarInsn(r3, r0)
            java.lang.String r0 = "getClass"
            java.lang.String r15 = "()Ljava/lang/Class;"
            java.lang.String r3 = "java/lang/Object"
            r9.visitMethodInsn(r8, r3, r0, r15)
            r0 = 165(0xa5, float:2.31E-43)
            r9.visitJumpInsn(r0, r2)
            r9.visitLabel(r6)
            int r0 = r11.var(r5)
            r3 = 25
            r9.visitVarInsn(r3, r0)
            r0 = 123(0x7b, float:1.72E-43)
            r6 = 16
            r9.visitVarInsn(r6, r0)
            java.lang.String r0 = SerializeWriter
            java.lang.String r6 = "(I)V"
            r9.visitMethodInsn(r8, r0, r14, r6)
            r0 = 0
            r9.visitVarInsn(r3, r0)
            r0 = 1
            r9.visitVarInsn(r3, r0)
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r26.beanInfo
            java.lang.String r6 = r6.typeKey
            if (r6 == 0) goto L_0x02f8
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r26.beanInfo
            java.lang.String r6 = r6.typeKey
            r9.visitLdcInsn(r6)
        L_0x02f6:
            r0 = 2
            goto L_0x02fc
        L_0x02f8:
            r9.visitInsn(r0)
            goto L_0x02f6
        L_0x02fc:
            r9.visitVarInsn(r3, r0)
            java.lang.String r0 = JavaBeanSerializer
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r4 = JSONSerializer
            r3.append(r4)
            java.lang.String r4 = ";Ljava/lang/String;Ljava/lang/Object;)V"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "writeClassName"
            r6 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r6, r0, r4, r3)
            r0 = 44
            r3 = 16
            r9.visitVarInsn(r3, r0)
            r0 = 167(0xa7, float:2.34E-43)
            r9.visitJumpInsn(r0, r1)
            r9.visitLabel(r2)
            r0 = 123(0x7b, float:1.72E-43)
            r9.visitVarInsn(r3, r0)
            r9.visitLabel(r1)
        L_0x0336:
            java.lang.String r0 = "seperator"
            int r0 = r11.var(r0)
            r1 = 54
            r9.visitVarInsn(r1, r0)
            boolean r0 = r26.writeDirect
            if (r0 != 0) goto L_0x034a
            r7._before(r9, r11)
        L_0x034a:
            boolean r0 = r26.writeDirect
            if (r0 != 0) goto L_0x03cc
            int r0 = r11.var(r5)
            r2 = 25
            r9.visitVarInsn(r2, r0)
            java.lang.String r0 = SerializeWriter
            java.lang.String r4 = "isNotWriteDefaultValue"
            java.lang.String r6 = "()Z"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r0, r4, r6)
            java.lang.String r0 = "notWriteDefaultValue"
            int r0 = r11.var(r0)
            r9.visitVarInsn(r1, r0)
            r0 = 1
            r9.visitVarInsn(r2, r0)
            r0 = 0
            r9.visitVarInsn(r2, r0)
            java.lang.String r0 = JSONSerializer
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            java.lang.String r4 = SerializeFilterable_desc
            r2.append(r4)
            java.lang.String r6 = ")Z"
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "checkValue"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r0, r6, r2)
            java.lang.String r2 = "checkValue"
            int r2 = r11.var(r2)
            r9.visitVarInsn(r1, r2)
            r2 = 25
            r6 = 1
            r9.visitVarInsn(r2, r6)
            r8 = 0
            r9.visitVarInsn(r2, r8)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r4)
            java.lang.String r4 = ")Z"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "hasNameFilters"
            r15 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r15, r0, r4, r2)
            java.lang.String r0 = "hasNameFilters"
            int r0 = r11.var(r0)
            r9.visitVarInsn(r1, r0)
            goto L_0x03d0
        L_0x03cc:
            r6 = 1
            r8 = 0
            goto L_0x04a2
        L_0x03d0:
            if (r8 >= r13) goto L_0x04a6
            r4 = r10[r8]
            java.lang.Class<?> r0 = r4.fieldClass
            java.lang.String r1 = r4.name
            r9.visitLdcInsn(r1)
            r1 = 58
            int r2 = com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName
            r9.visitVarInsn(r1, r2)
            java.lang.Class r1 = java.lang.Byte.TYPE
            if (r0 == r1) goto L_0x03ee
            java.lang.Class r1 = java.lang.Short.TYPE
            if (r0 == r1) goto L_0x03ee
            java.lang.Class r1 = java.lang.Integer.TYPE
            if (r0 != r1) goto L_0x03f6
        L_0x03ee:
            r15 = r23
            r21 = r5
            r10 = 21
            goto L_0x0483
        L_0x03f6:
            java.lang.Class r1 = java.lang.Long.TYPE
            if (r0 != r1) goto L_0x0406
            r2 = r23
            r7._long(r2, r9, r4, r11)
        L_0x03ff:
            r15 = r2
            r21 = r5
            r10 = 21
            goto L_0x0499
        L_0x0406:
            r2 = r23
            java.lang.Class r1 = java.lang.Float.TYPE
            if (r0 != r1) goto L_0x0410
            r7._float(r2, r9, r4, r11)
            goto L_0x03ff
        L_0x0410:
            java.lang.Class r1 = java.lang.Double.TYPE
            if (r0 != r1) goto L_0x0418
            r7._double(r2, r9, r4, r11)
            goto L_0x03ff
        L_0x0418:
            java.lang.Class r1 = java.lang.Boolean.TYPE
            if (r0 != r1) goto L_0x043b
            java.lang.String r0 = "boolean"
            int r16 = r11.var(r0)
            r17 = 90
            r0 = r22
            r1 = r23
            r15 = r2
            r2 = r24
            r3 = r4
            r4 = r26
            r21 = r5
            r10 = 21
            r5 = r16
            r6 = r17
            r0._int(r1, r2, r3, r4, r5, r6)
            goto L_0x0499
        L_0x043b:
            r15 = r2
            r21 = r5
            r10 = 21
            java.lang.Class r1 = java.lang.Character.TYPE
            if (r0 != r1) goto L_0x0459
            java.lang.String r0 = "char"
            int r5 = r11.var(r0)
            r6 = 67
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r4
            r4 = r26
            r0._int(r1, r2, r3, r4, r5, r6)
            goto L_0x0499
        L_0x0459:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r0 != r1) goto L_0x0461
            r7._string(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0461:
            java.lang.Class<java.math.BigDecimal> r1 = java.math.BigDecimal.class
            if (r0 != r1) goto L_0x0469
            r7._decimal(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0469:
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 == 0) goto L_0x0475
            r7._list(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0475:
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L_0x047f
            r7._enum(r15, r9, r4, r11)
            goto L_0x0499
        L_0x047f:
            r7._object(r15, r9, r4, r11)
            goto L_0x0499
        L_0x0483:
            java.lang.String r0 = r0.getName()
            int r5 = r11.var(r0)
            r6 = 73
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r4
            r4 = r26
            r0._int(r1, r2, r3, r4, r5, r6)
        L_0x0499:
            int r8 = r8 + 1
            r10 = r25
            r5 = r21
            r3 = 16
            r6 = 1
        L_0x04a2:
            r15 = 182(0xb6, float:2.55E-43)
            goto L_0x03d0
        L_0x04a6:
            r21 = r5
            r10 = 21
            boolean r0 = r26.writeDirect
            if (r0 != 0) goto L_0x04b3
            r7._after(r9, r11)
        L_0x04b3:
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            java.lang.String r2 = "seperator"
            int r2 = r11.var(r2)
            r9.visitVarInsn(r10, r2)
            r2 = 123(0x7b, float:1.72E-43)
            r3 = 16
            r9.visitIntInsn(r3, r2)
            r4 = 160(0xa0, float:2.24E-43)
            r9.visitJumpInsn(r4, r0)
            r4 = r21
            int r5 = r11.var(r4)
            r6 = 25
            r9.visitVarInsn(r6, r5)
            r9.visitVarInsn(r3, r2)
            java.lang.String r2 = SerializeWriter
            java.lang.String r5 = "(I)V"
            r8 = 182(0xb6, float:2.55E-43)
            r9.visitMethodInsn(r8, r2, r14, r5)
            r9.visitLabel(r0)
            int r0 = r11.var(r4)
            r9.visitVarInsn(r6, r0)
            r0 = 125(0x7d, float:1.75E-43)
            r9.visitVarInsn(r3, r0)
            java.lang.String r0 = "(I)V"
            r9.visitMethodInsn(r8, r2, r14, r0)
            r9.visitLabel(r1)
            r0 = r19
            r9.visitLabel(r0)
            boolean r0 = r26.nonContext
            if (r0 != 0) goto L_0x0535
            r0 = 1
            r9.visitVarInsn(r6, r0)
            r0 = r18
            int r0 = r11.var(r0)
            r9.visitVarInsn(r6, r0)
            java.lang.String r0 = JSONSerializer
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            java.lang.String r2 = SerialContext_desc
            r1.append(r2)
            java.lang.String r2 = ")V"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "setContext"
            r9.visitMethodInsn(r8, r0, r2, r1)
        L_0x0535:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.generateWriteMethod(java.lang.Class, com.alibaba.fastjson.asm.MethodVisitor, com.alibaba.fastjson.util.FieldInfo[], com.alibaba.fastjson.serializer.ASMSerializerFactory$Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x054c  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x04be A[EDGE_INSN: B:128:0x04be->B:95:0x04be ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0544  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.JavaBeanSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo r38) throws java.lang.Exception {
        /*
            r37 = this;
            r0 = r37
            r7 = r38
            java.lang.String r9 = "writeDirectNonContext"
            java.lang.String r10 = "writeNormal"
            java.lang.String r2 = ")V"
            java.lang.String r3 = "("
            java.lang.String r4 = "Ljava/lang/reflect/Type;"
            r12 = 1
            java.lang.Class<?> r13 = r7.beanType
            boolean r5 = r13.isPrimitive()
            if (r5 != 0) goto L_0x0604
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r5 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r5 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r13, r5)
            r14 = r5
            com.alibaba.fastjson.annotation.JSONType r14 = (com.alibaba.fastjson.annotation.JSONType) r14
            com.alibaba.fastjson.util.FieldInfo[] r15 = r7.fields
            int r5 = r15.length
            r6 = 0
        L_0x0026:
            if (r6 >= r5) goto L_0x0044
            r8 = r15[r6]
            java.lang.reflect.Field r1 = r8.field
            if (r1 != 0) goto L_0x0042
            java.lang.reflect.Method r1 = r8.method
            if (r1 == 0) goto L_0x0042
            java.lang.Class r1 = r1.getDeclaringClass()
            boolean r1 = r1.isInterface()
            if (r1 == 0) goto L_0x0042
            com.alibaba.fastjson.serializer.JavaBeanSerializer r1 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r1.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r7)
            return r1
        L_0x0042:
            int r6 = r6 + r12
            goto L_0x0026
        L_0x0044:
            com.alibaba.fastjson.util.FieldInfo[] r8 = r7.sortedFields
            com.alibaba.fastjson.util.FieldInfo[] r1 = r7.fields
            if (r8 != r1) goto L_0x004d
            r18 = 1
            goto L_0x004f
        L_0x004d:
            r18 = 0
        L_0x004f:
            int r1 = r8.length
            r5 = 256(0x100, float:3.59E-43)
            if (r1 <= r5) goto L_0x005a
            com.alibaba.fastjson.serializer.JavaBeanSerializer r1 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r1.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r7)
            return r1
        L_0x005a:
            int r1 = r8.length
            r5 = 0
        L_0x005c:
            if (r5 >= r1) goto L_0x0076
            r6 = r8[r5]
            java.lang.reflect.Member r6 = r6.getMember()
            java.lang.String r6 = r6.getName()
            boolean r6 = com.alibaba.fastjson.util.ASMUtils.checkName(r6)
            if (r6 != 0) goto L_0x0074
            com.alibaba.fastjson.serializer.JavaBeanSerializer r1 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r1.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r7)
            return r1
        L_0x0074:
            int r5 = r5 + r12
            goto L_0x005c
        L_0x0076:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "ASMSerializer_"
            r1.append(r5)
            java.util.concurrent.atomic.AtomicLong r5 = r0.seed
            long r5 = r5.incrementAndGet()
            r1.append(r5)
            java.lang.String r5 = "_"
            r1.append(r5)
            java.lang.String r5 = r13.getSimpleName()
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.Class<com.alibaba.fastjson.serializer.ASMSerializerFactory> r5 = com.alibaba.fastjson.serializer.ASMSerializerFactory.class
            java.lang.Package r5 = r5.getPackage()
            if (r5 == 0) goto L_0x00d8
            java.lang.String r5 = r5.getName()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r11 = 46
            r12 = 47
            java.lang.String r11 = r5.replace(r11, r12)
            r6.append(r11)
            java.lang.String r11 = "/"
            r6.append(r11)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r5)
            java.lang.String r5 = "."
            r11.append(r5)
            r11.append(r1)
            java.lang.String r1 = r11.toString()
            r12 = r1
            r11 = r6
            goto L_0x00da
        L_0x00d8:
            r11 = r1
            r12 = r11
        L_0x00da:
            com.alibaba.fastjson.asm.ClassWriter r6 = new com.alibaba.fastjson.asm.ClassWriter
            r6.<init>()
            java.lang.String r23 = JavaBeanSerializer
            java.lang.String r1 = ObjectSerializer
            java.lang.String[] r24 = new java.lang.String[]{r1}
            r20 = 49
            r21 = 33
            r19 = r6
            r22 = r11
            r19.visit(r20, r21, r22, r23, r24)
            int r1 = r8.length
            r5 = 0
        L_0x00f4:
            java.lang.String r7 = "_asm_fieldType"
            r26 = r12
            java.lang.Class<java.lang.String> r12 = java.lang.String.class
            if (r5 >= r1) goto L_0x017b
            r19 = r1
            r1 = r8[r5]
            r27 = r15
            java.lang.Class<?> r15 = r1.fieldClass
            boolean r15 = r15.isPrimitive()
            if (r15 != 0) goto L_0x010e
            java.lang.Class<?> r15 = r1.fieldClass
            if (r15 != r12) goto L_0x0110
        L_0x010e:
            r12 = 1
            goto L_0x0170
        L_0x0110:
            com.alibaba.fastjson.asm.FieldWriter r12 = new com.alibaba.fastjson.asm.FieldWriter
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = r1.name
            r15.append(r0)
            r15.append(r7)
            java.lang.String r0 = r15.toString()
            r7 = 1
            r12.<init>(r6, r7, r0, r4)
            r12.visitEnd()
            java.lang.Class<java.util.List> r0 = java.util.List.class
            java.lang.Class<?> r7 = r1.fieldClass
            boolean r0 = r0.isAssignableFrom(r7)
            if (r0 == 0) goto L_0x0152
            com.alibaba.fastjson.asm.FieldWriter r0 = new com.alibaba.fastjson.asm.FieldWriter
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r12 = r1.name
            r7.append(r12)
            java.lang.String r12 = "_asm_list_item_ser_"
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            java.lang.String r12 = ObjectSerializer_desc
            r15 = 1
            r0.<init>(r6, r15, r7, r12)
            r0.visitEnd()
        L_0x0152:
            com.alibaba.fastjson.asm.FieldWriter r0 = new com.alibaba.fastjson.asm.FieldWriter
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = r1.name
            r7.append(r1)
            java.lang.String r1 = "_asm_ser_"
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            java.lang.String r7 = ObjectSerializer_desc
            r12 = 1
            r0.<init>(r6, r12, r1, r7)
            r0.visitEnd()
        L_0x0170:
            int r5 = r5 + r12
            r0 = r37
            r1 = r19
            r12 = r26
            r15 = r27
            goto L_0x00f4
        L_0x017b:
            r27 = r15
            com.alibaba.fastjson.asm.MethodWriter r0 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.Class<com.alibaba.fastjson.serializer.SerializeBeanInfo> r15 = com.alibaba.fastjson.serializer.SerializeBeanInfo.class
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r15)
            r1.append(r5)
            r1.append(r2)
            java.lang.String r23 = r1.toString()
            r24 = 0
            r25 = 0
            r21 = 1
            java.lang.String r22 = "<init>"
            r19 = r0
            r20 = r6
            r19.<init>(r20, r21, r22, r23, r24, r25)
            r5 = 25
            r1 = 0
            r0.visitVarInsn(r5, r1)
            r1 = 1
            r0.visitVarInsn(r5, r1)
            java.lang.String r1 = JavaBeanSerializer
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r15)
            r5.append(r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r3 = "<init>"
            r5 = 183(0xb7, float:2.56E-43)
            r0.visitMethodInsn(r5, r1, r3, r2)
            r1 = 0
        L_0x01d0:
            int r2 = r8.length
            if (r1 >= r2) goto L_0x0262
            r2 = r8[r1]
            java.lang.Class<?> r3 = r2.fieldClass
            boolean r3 = r3.isPrimitive()
            if (r3 != 0) goto L_0x0254
            java.lang.Class<?> r3 = r2.fieldClass
            if (r3 != r12) goto L_0x01ea
            r20 = r6
            r21 = r12
            r2 = 1
            r5 = 183(0xb7, float:2.56E-43)
            goto L_0x025b
        L_0x01ea:
            r3 = 25
            r5 = 0
            r0.visitVarInsn(r3, r5)
            java.lang.reflect.Method r3 = r2.method
            if (r3 == 0) goto L_0x0220
            java.lang.Class<?> r3 = r2.declaringClass
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r3)
            com.alibaba.fastjson.asm.Type r3 = com.alibaba.fastjson.asm.Type.getType(r3)
            r0.visitLdcInsn(r3)
            java.lang.reflect.Method r3 = r2.method
            java.lang.String r3 = r3.getName()
            r0.visitLdcInsn(r3)
            java.lang.Class<com.alibaba.fastjson.util.ASMUtils> r3 = com.alibaba.fastjson.util.ASMUtils.class
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.type(r3)
            java.lang.String r5 = "getMethodType"
            r20 = r6
            java.lang.String r6 = "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;"
            r21 = r12
            r12 = 184(0xb8, float:2.58E-43)
            r0.visitMethodInsn(r12, r3, r5, r6)
            r5 = 183(0xb7, float:2.56E-43)
            goto L_0x023c
        L_0x0220:
            r20 = r6
            r21 = r12
            r3 = 0
            r5 = 25
            r0.visitVarInsn(r5, r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r0.visitLdcInsn(r3)
            java.lang.String r3 = JavaBeanSerializer
            java.lang.String r6 = "getFieldType"
            java.lang.String r12 = "(I)Ljava/lang/reflect/Type;"
            r5 = 183(0xb7, float:2.56E-43)
            r0.visitMethodInsn(r5, r3, r6, r12)
        L_0x023c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r2.name
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = r3.toString()
            r3 = 181(0xb5, float:2.54E-43)
            r0.visitFieldInsn(r3, r11, r2, r4)
        L_0x0252:
            r2 = 1
            goto L_0x025b
        L_0x0254:
            r20 = r6
            r21 = r12
            r5 = 183(0xb7, float:2.56E-43)
            goto L_0x0252
        L_0x025b:
            int r1 = r1 + r2
            r6 = r20
            r12 = r21
            goto L_0x01d0
        L_0x0262:
            r20 = r6
            r7 = 177(0xb1, float:2.48E-43)
            r0.visitInsn(r7)
            r12 = 4
            r0.visitMaxs(r12, r12)
            r0.visitEnd()
            if (r14 == 0) goto L_0x0285
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r14.serialzeFeatures()
            int r1 = r0.length
            r2 = 0
        L_0x0278:
            if (r2 >= r1) goto L_0x0285
            r3 = r0[r2]
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            if (r3 != r4) goto L_0x0282
            r0 = 1
            goto L_0x0286
        L_0x0282:
            r3 = 1
            int r2 = r2 + r3
            goto L_0x0278
        L_0x0285:
            r0 = 0
        L_0x0286:
            r6 = 0
        L_0x0287:
            r5 = 7
            java.lang.String r4 = "entity"
            r3 = 192(0xc0, float:2.69E-43)
            r2 = 180(0xb4, float:2.52E-43)
            java.lang.String r17 = "java/io/IOException"
            r1 = 3
            java.lang.String r12 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
            java.lang.String r7 = "(L"
            r28 = r15
            java.lang.String r15 = "out"
            r29 = r0
            r0 = 2
            if (r6 >= r1) goto L_0x04be
            if (r6 != 0) goto L_0x02aa
            java.lang.String r21 = "write"
            r23 = r21
            r30 = r29
            r21 = 1
            goto L_0x02ba
        L_0x02aa:
            r1 = 1
            if (r6 != r1) goto L_0x02b4
            r23 = r10
            r30 = r29
            r21 = 0
            goto L_0x02ba
        L_0x02b4:
            r23 = r9
            r21 = 1
            r30 = 1
        L_0x02ba:
            com.alibaba.fastjson.serializer.ASMSerializerFactory$Context r1 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$Context
            r31 = r1
            r2 = r8
            r3 = r38
            r32 = r4
            r4 = r11
            r33 = r8
            r8 = 25
            r5 = r21
            r35 = r6
            r34 = r20
            r6 = r30
            r1.<init>(r2, r3, r4, r5, r6)
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = JSONSerializer
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r24 = 0
            java.lang.String[] r25 = new java.lang.String[]{r17}
            r21 = 1
            r19 = r1
            r22 = r23
            r23 = r2
            r19.<init>(r20, r21, r22, r23, r24, r25)
            com.alibaba.fastjson.asm.Label r2 = new com.alibaba.fastjson.asm.Label
            r2.<init>()
            r1.visitVarInsn(r8, r0)
            r4 = 199(0xc7, float:2.79E-43)
            r1.visitJumpInsn(r4, r2)
            r4 = 1
            r1.visitVarInsn(r8, r4)
            java.lang.String r5 = "writeNull"
            java.lang.String r6 = "()V"
            r0 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r0, r3, r5, r6)
            r5 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r5)
            r1.visitLabel(r2)
            r1.visitVarInsn(r8, r4)
            java.lang.String r2 = SerializeWriter_desc
            r6 = 180(0xb4, float:2.52E-43)
            r1.visitFieldInsn(r6, r3, r15, r2)
            r2 = r31
            int r4 = r2.var(r15)
            r5 = 58
            r1.visitVarInsn(r5, r4)
            if (r18 != 0) goto L_0x0343
            boolean r6 = r2.writeDirect
            if (r6 != 0) goto L_0x0343
            if (r14 == 0) goto L_0x0345
            boolean r6 = r14.alphabetic()
            if (r6 == 0) goto L_0x0343
            goto L_0x0345
        L_0x0343:
            r8 = 3
            goto L_0x039b
        L_0x0345:
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            int r4 = r2.var(r15)
            r1.visitVarInsn(r8, r4)
            java.lang.String r4 = SerializeWriter
            java.lang.String r5 = "isSortField"
            java.lang.String r8 = "()Z"
            r1.visitMethodInsn(r0, r4, r5, r8)
            r4 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r4, r6)
            r4 = 25
            r5 = 0
            r1.visitVarInsn(r4, r5)
            r5 = 1
            r1.visitVarInsn(r4, r5)
            r5 = 2
            r1.visitVarInsn(r4, r5)
            r8 = 3
            r1.visitVarInsn(r4, r8)
            r5 = 4
            r1.visitVarInsn(r4, r5)
            r4 = 5
            r5 = 21
            r1.visitVarInsn(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            r4.append(r3)
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "writeUnsorted"
            r1.visitMethodInsn(r0, r11, r5, r4)
            r4 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r4)
            r1.visitLabel(r6)
        L_0x039b:
            boolean r4 = r2.writeDirect
            if (r4 == 0) goto L_0x0478
            if (r30 != 0) goto L_0x0478
            com.alibaba.fastjson.asm.Label r4 = new com.alibaba.fastjson.asm.Label
            r4.<init>()
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r6 = 25
            r8 = 0
            r1.visitVarInsn(r6, r8)
            r8 = 1
            r1.visitVarInsn(r6, r8)
            java.lang.String r6 = JavaBeanSerializer
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r3)
            java.lang.String r0 = ";)Z"
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.String r8 = "writeDirect"
            r21 = r14
            r14 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r14, r6, r8, r0)
            r0 = 154(0x9a, float:2.16E-43)
            r1.visitJumpInsn(r0, r5)
            r6 = 25
            r8 = 0
            r1.visitVarInsn(r6, r8)
            r8 = 1
            r1.visitVarInsn(r6, r8)
            r8 = 2
            r1.visitVarInsn(r6, r8)
            r8 = 3
            r1.visitVarInsn(r6, r8)
            r8 = 4
            r1.visitVarInsn(r6, r8)
            r6 = 5
            r8 = 21
            r1.visitVarInsn(r8, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r3)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r8 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r8, r11, r10, r6)
            r6 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r6)
            r1.visitLabel(r5)
            int r5 = r2.var(r15)
            r6 = 25
            r1.visitVarInsn(r6, r5)
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r5 = r5.mask
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.visitLdcInsn(r5)
            java.lang.String r5 = SerializeWriter
            java.lang.String r8 = "isEnabled"
            java.lang.String r14 = "(I)Z"
            r15 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r15, r5, r8, r14)
            r5 = 153(0x99, float:2.14E-43)
            r1.visitJumpInsn(r5, r4)
            r5 = 0
            r1.visitVarInsn(r6, r5)
            r5 = 1
            r1.visitVarInsn(r6, r5)
            r5 = 2
            r1.visitVarInsn(r6, r5)
            r5 = 3
            r1.visitVarInsn(r6, r5)
            r5 = 4
            r1.visitVarInsn(r6, r5)
            r6 = 5
            r8 = 21
            r1.visitVarInsn(r8, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r3)
            r6.append(r12)
            java.lang.String r3 = r6.toString()
            r6 = 182(0xb6, float:2.55E-43)
            r1.visitMethodInsn(r6, r11, r9, r3)
            r3 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r3)
            r1.visitLabel(r4)
        L_0x0474:
            r4 = 25
            r6 = 2
            goto L_0x0480
        L_0x0478:
            r21 = r14
            r0 = 154(0x9a, float:2.16E-43)
            r3 = 177(0xb1, float:2.48E-43)
            r5 = 4
            goto L_0x0474
        L_0x0480:
            r1.visitVarInsn(r4, r6)
            java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.type(r13)
            r8 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r8, r4)
            r14 = r32
            int r4 = r2.var(r14)
            r7 = 58
            r1.visitVarInsn(r7, r4)
            r4 = r37
            r7 = r33
            r4.generateWriteMethod(r13, r1, r7, r2)
            r1.visitInsn(r3)
            int r2 = r2.variantIndex
            int r2 = r2 + r6
            r3 = 7
            r1.visitMaxs(r3, r2)
            r1.visitEnd()
            r1 = 1
            int r6 = r35 + 1
            r8 = r7
            r14 = r21
            r15 = r28
            r0 = r29
            r20 = r34
            r7 = 177(0xb1, float:2.48E-43)
            r12 = 4
            goto L_0x0287
        L_0x04be:
            r3 = 7
            r6 = 180(0xb4, float:2.52E-43)
            r14 = r4
            r1 = r8
            r34 = r20
            r8 = 192(0xc0, float:2.69E-43)
            r4 = r37
            if (r18 != 0) goto L_0x0544
            com.alibaba.fastjson.serializer.ASMSerializerFactory$Context r0 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$Context
            r5 = 0
            r9 = r1
            r1 = r0
            r2 = r9
            r10 = 7
            r3 = r38
            r10 = r4
            r4 = r11
            r8 = 180(0xb4, float:2.52E-43)
            r6 = r29
            r1.<init>(r2, r3, r4, r5, r6)
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = JSONSerializer
            r2.append(r3)
            r2.append(r12)
            java.lang.String r23 = r2.toString()
            r24 = 0
            java.lang.String[] r25 = new java.lang.String[]{r17}
            r21 = 1
            java.lang.String r22 = "writeUnsorted"
            r19 = r1
            r20 = r34
            r19.<init>(r20, r21, r22, r23, r24, r25)
            r2 = 25
            r4 = 1
            r1.visitVarInsn(r2, r4)
            java.lang.String r4 = SerializeWriter_desc
            r1.visitFieldInsn(r8, r3, r15, r4)
            int r3 = r0.var(r15)
            r4 = 58
            r1.visitVarInsn(r4, r3)
            r3 = 2
            r1.visitVarInsn(r2, r3)
            java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.type(r13)
            r5 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r5, r2)
            int r2 = r0.var(r14)
            r1.visitVarInsn(r4, r2)
            r2 = r27
            r10.generateWriteMethod(r13, r1, r2, r0)
            r2 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r2)
            int r0 = r0.variantIndex
            int r0 = r0 + r3
            r2 = 7
            r1.visitMaxs(r2, r0)
            r1.visitEnd()
            goto L_0x0548
        L_0x0544:
            r9 = r1
            r10 = r4
            r8 = 180(0xb4, float:2.52E-43)
        L_0x0548:
            r0 = 0
        L_0x0549:
            r6 = 3
            if (r0 >= r6) goto L_0x05e2
            if (r0 != 0) goto L_0x0557
            java.lang.String r1 = "writeAsArray"
            r22 = r1
            r16 = r29
            r5 = 1
            goto L_0x056b
        L_0x0557:
            r1 = 1
            if (r0 != r1) goto L_0x0563
            java.lang.String r1 = "writeAsArrayNormal"
            r22 = r1
            r16 = r29
            r5 = 0
            goto L_0x056b
        L_0x0563:
            java.lang.String r1 = "writeAsArrayNonContext"
            r22 = r1
            r5 = 1
            r16 = 1
        L_0x056b:
            com.alibaba.fastjson.serializer.ASMSerializerFactory$Context r4 = new com.alibaba.fastjson.serializer.ASMSerializerFactory$Context
            r1 = r4
            r2 = r9
            r3 = r38
            r36 = r4
            r4 = r11
            r18 = 3
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6)
            com.alibaba.fastjson.asm.MethodWriter r1 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = JSONSerializer
            r2.append(r3)
            r2.append(r12)
            java.lang.String r23 = r2.toString()
            r24 = 0
            java.lang.String[] r25 = new java.lang.String[]{r17}
            r21 = 1
            r19 = r1
            r20 = r34
            r19.<init>(r20, r21, r22, r23, r24, r25)
            r2 = 25
            r4 = 1
            r1.visitVarInsn(r2, r4)
            java.lang.String r4 = SerializeWriter_desc
            r1.visitFieldInsn(r8, r3, r15, r4)
            r3 = r36
            int r4 = r3.var(r15)
            r5 = 58
            r1.visitVarInsn(r5, r4)
            r4 = 2
            r1.visitVarInsn(r2, r4)
            java.lang.String r6 = com.alibaba.fastjson.util.ASMUtils.type(r13)
            r2 = 192(0xc0, float:2.69E-43)
            r1.visitTypeInsn(r2, r6)
            int r6 = r3.var(r14)
            r1.visitVarInsn(r5, r6)
            r10.generateWriteAsArray(r13, r1, r9, r3)
            r6 = 177(0xb1, float:2.48E-43)
            r1.visitInsn(r6)
            int r3 = r3.variantIndex
            int r3 = r3 + r4
            r2 = 7
            r1.visitMaxs(r2, r3)
            r1.visitEnd()
            r1 = 1
            int r0 = r0 + r1
            goto L_0x0549
        L_0x05e2:
            r1 = 1
            byte[] r0 = r34.toByteArray()
            com.alibaba.fastjson.util.ASMClassLoader r2 = r10.classLoader
            int r3 = r0.length
            r4 = r26
            r5 = 0
            java.lang.Class r0 = r2.defineClassPublic(r4, r0, r5, r3)
            java.lang.Class[] r2 = new java.lang.Class[r1]
            r2[r5] = r28
            java.lang.reflect.Constructor r0 = r0.getConstructor(r2)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r5] = r38
            java.lang.Object r0 = r0.newInstance(r1)
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r0
            return r0
        L_0x0604:
            r10 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unsupportd class "
            r1.append(r2)
            java.lang.String r2 = r13.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo):com.alibaba.fastjson.serializer.JavaBeanSerializer");
    }

    public static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        /* access modifiers changed from: private */
        public final SerializeBeanInfo beanInfo;
        /* access modifiers changed from: private */
        public final String className;
        private final FieldInfo[] getters;
        /* access modifiers changed from: private */
        public final boolean nonContext;
        /* access modifiers changed from: private */
        public int variantIndex = 9;
        private Map<String, Integer> variants = new HashMap();
        /* access modifiers changed from: private */
        public final boolean writeDirect;

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z, boolean z2) {
            boolean z3;
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z;
            if (z2 || serializeBeanInfo.beanType.isEnum()) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.nonContext = z3;
        }

        public int getFieldOrinal(String str) {
            int length = this.getters.length;
            for (int i = 0; i < length; i++) {
                if (this.getters[i].name.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }
    }
}
