package com.alibaba.fastjson.parser.deserializer;

import XXO0.oIX0oI;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.huawei.openalliance.ad.constant.bn;
import com.squareup.javapoet.X0o0xo;
import com.tenmeter.smlibrary.utils.FileUtils;
import com.vtrump.vtble.Oxx0IOOO;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    public static class Context {
        static final int fieldName = 3;
        static final int parser = 1;
        static final int type = 2;
        /* access modifiers changed from: private */
        public final JavaBeanInfo beanInfo;
        /* access modifiers changed from: private */
        public final String className;
        /* access modifiers changed from: private */
        public final Class<?> clazz;
        /* access modifiers changed from: private */
        public FieldInfo[] fieldInfoList;
        /* access modifiers changed from: private */
        public int variantIndex = -1;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i) {
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public String fieldDeserName(FieldInfo fieldInfo) {
            if (validIdent(fieldInfo.name)) {
                return fieldInfo.name + "_asm_deser__";
            }
            return "_asm_deser__" + TypeUtils.fnv1a_64_extract(fieldInfo.name);
        }

        public String fieldName(FieldInfo fieldInfo) {
            if (validIdent(fieldInfo.name)) {
                return fieldInfo.name + "_asm_prefix__";
            }
            return "asm_field_" + TypeUtils.fnv1a_64_extract(fieldInfo.name);
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            if (cls == null) {
                return this.clazz;
            }
            return cls;
        }

        public boolean validIdent(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == 0) {
                    if (!IOUtils.firstIdentifier(charAt)) {
                        return false;
                    }
                } else if (!IOUtils.isIdent(charAt)) {
                    return false;
                }
            }
            return true;
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int var_asm(FieldInfo fieldInfo) {
            return var(fieldInfo.name + "_asm");
        }

        public int var_asm(FieldInfo fieldInfo, int i) {
            return var(fieldInfo.name + "_asm", i);
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
    }

    public ASMDeserializerFactory(ClassLoader classLoader2) {
        ASMClassLoader aSMClassLoader;
        if (classLoader2 instanceof ASMClassLoader) {
            aSMClassLoader = (ASMClassLoader) classLoader2;
        } else {
            aSMClassLoader = new ASMClassLoader(classLoader2);
        }
        this.classLoader = aSMClassLoader;
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), X0o0xo.f5789oOoXoXO, "()V");
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 0);
            Class<JavaBeanDeserializer> cls = JavaBeanDeserializer.class;
            methodVisitor.visitFieldInsn(180, ASMUtils.type(cls), "clazz", "Ljava/lang/Class;");
            String type = ASMUtils.type(cls);
            methodVisitor.visitMethodInsn(183, type, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        }
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i) {
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        _getFieldDeser(context, methodVisitor, fieldInfo);
        Label label = new Label();
        Label label2 = new Label();
        Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
        if ((fieldInfo2.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
            methodVisitor2.visitInsn(89);
            methodVisitor2.visitTypeInsn(193, ASMUtils.type(cls2));
            methodVisitor2.visitJumpInsn(153, label);
            methodVisitor2.visitTypeInsn(192, ASMUtils.type(cls2));
            methodVisitor2.visitVarInsn(25, 1);
            if (fieldInfo2.fieldType instanceof Class) {
                methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo2.fieldClass)));
            } else {
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitLdcInsn(Integer.valueOf(i));
                methodVisitor2.visitMethodInsn(182, ASMUtils.type(cls2), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor2.visitLdcInsn(fieldInfo2.name);
            methodVisitor2.visitLdcInsn(Integer.valueOf(fieldInfo2.parserFeatures));
            String type = ASMUtils.type(cls2);
            methodVisitor2.visitMethodInsn(182, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodVisitor2.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor2.visitVarInsn(58, context2.var_asm(fieldInfo2));
            methodVisitor2.visitJumpInsn(167, label2);
            methodVisitor2.visitLabel(label);
        }
        methodVisitor2.visitVarInsn(25, 1);
        if (fieldInfo2.fieldType instanceof Class) {
            methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo2.fieldClass)));
        } else {
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitLdcInsn(Integer.valueOf(i));
            methodVisitor2.visitMethodInsn(182, ASMUtils.type(cls2), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor2.visitLdcInsn(fieldInfo2.name);
        String type2 = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor2.visitMethodInsn(185, type2, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor2.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor2.visitVarInsn(58, context2.var_asm(fieldInfo2));
        methodVisitor2.visitLabel(label2);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(158, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0ac1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _deserialze(com.alibaba.fastjson.asm.ClassWriter r31, com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory.Context r32) {
        /*
            r30 = this;
            r8 = r30
            r9 = r32
            com.alibaba.fastjson.util.FieldInfo[] r0 = r32.fieldInfoList
            int r0 = r0.length
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            com.alibaba.fastjson.util.FieldInfo[] r0 = r32.fieldInfoList
            int r1 = r0.length
            r10 = 0
            r2 = 0
        L_0x0013:
            if (r2 >= r1) goto L_0x003d
            r3 = r0[r2]
            java.lang.Class<?> r4 = r3.fieldClass
            java.lang.reflect.Type r3 = r3.fieldType
            java.lang.Class r5 = java.lang.Character.TYPE
            if (r4 != r5) goto L_0x0020
            return
        L_0x0020:
            java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
            boolean r4 = r5.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x003a
            boolean r4 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r4 == 0) goto L_0x0039
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r3 = r3[r10]
            boolean r3 = r3 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            return
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x003d:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r32.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r1 = r0.sortedFields
            com.alibaba.fastjson.util.FieldInfo[] unused = r9.fieldInfoList = r1
            com.alibaba.fastjson.asm.MethodWriter r7 = new com.alibaba.fastjson.asm.MethodWriter
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "(L"
            r1.append(r6)
            java.lang.String r2 = DefaultJSONParser
            r1.append(r2)
            java.lang.String r3 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
            r1.append(r3)
            java.lang.String r15 = r1.toString()
            r16 = 0
            r17 = 0
            r13 = 1
            java.lang.String r14 = "deserialze"
            r11 = r7
            r12 = r31
            r11.<init>(r12, r13, r14, r15, r16, r17)
            com.alibaba.fastjson.asm.Label r11 = new com.alibaba.fastjson.asm.Label
            r11.<init>()
            com.alibaba.fastjson.asm.Label r12 = new com.alibaba.fastjson.asm.Label
            r12.<init>()
            com.alibaba.fastjson.asm.Label r13 = new com.alibaba.fastjson.asm.Label
            r13.<init>()
            com.alibaba.fastjson.asm.Label r14 = new com.alibaba.fastjson.asm.Label
            r14.<init>()
            r8.defineVarLexer(r9, r7)
            com.alibaba.fastjson.asm.Label r1 = new com.alibaba.fastjson.asm.Label
            r1.<init>()
            java.lang.String r15 = "lexer"
            int r3 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r3)
            java.lang.String r3 = JSONLexerBase
            java.lang.String r4 = "token"
            java.lang.String r10 = "()I"
            r5 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r5, r3, r4, r10)
            r4 = 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.visitLdcInsn(r4)
            r10 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r10, r1)
            int r0 = r0.parserFeatures
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean
            int r10 = r4.mask
            r0 = r0 & r10
            r10 = 21
            r5 = 4
            if (r0 != 0) goto L_0x00e2
            int r0 = r9.var(r15)
            r18 = r14
            r14 = 25
            r7.visitVarInsn(r14, r0)
            r7.visitVarInsn(r10, r5)
            int r0 = r4.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = "isEnabled"
            java.lang.String r4 = "(II)Z"
            r14 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r14, r3, r0, r4)
            r0 = 153(0x99, float:2.14E-43)
            r7.visitJumpInsn(r0, r1)
        L_0x00de:
            r0 = 0
            r4 = 25
            goto L_0x00e5
        L_0x00e2:
            r18 = r14
            goto L_0x00de
        L_0x00e5:
            r7.visitVarInsn(r4, r0)
            r14 = 1
            r7.visitVarInsn(r4, r14)
            r0 = 2
            r7.visitVarInsn(r4, r0)
            r10 = 3
            r7.visitVarInsn(r4, r10)
            r7.visitInsn(r14)
            java.lang.String r4 = r32.className
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r2)
            java.lang.String r5 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 183(0xb7, float:2.56E-43)
            java.lang.String r10 = "deserialzeArrayMapping"
            r7.visitMethodInsn(r5, r4, r10, r0)
            r0 = 176(0xb0, float:2.47E-43)
            r7.visitInsn(r0)
            r7.visitLabel(r1)
            int r0 = r9.var(r15)
            r1 = 25
            r7.visitVarInsn(r1, r0)
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.SortFeidFastMatch
            int r0 = r0.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = "isEnabled"
            java.lang.String r1 = "(I)Z"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r3, r0, r1)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r1 = 154(0x9a, float:2.16E-43)
            r7.visitJumpInsn(r1, r0)
            r1 = 200(0xc8, float:2.8E-43)
            r7.visitJumpInsn(r1, r12)
            r7.visitLabel(r0)
            int r0 = r9.var(r15)
            r1 = 25
            r7.visitVarInsn(r1, r0)
            java.lang.Class r0 = r32.clazz
            java.lang.String r0 = r0.getName()
            r7.visitLdcInsn(r0)
            java.lang.String r0 = "scanType"
            java.lang.String r1 = "(Ljava/lang/String;)I"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r3, r0, r1)
            r0 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r1 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r1, r0)
            r1 = 200(0xc8, float:2.8E-43)
            r7.visitJumpInsn(r1, r12)
            r7.visitLabel(r0)
            r0 = 25
            r7.visitVarInsn(r0, r14)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "()"
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "getContext"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r2, r1, r0)
            java.lang.String r0 = "mark_context"
            int r0 = r9.var(r0)
            r10 = 58
            r7.visitVarInsn(r10, r0)
            r0 = 3
            r7.visitInsn(r0)
            java.lang.String r0 = "matchedCount"
            int r0 = r9.var(r0)
            r5 = 54
            r7.visitVarInsn(r5, r0)
            r8._createInstance((com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory.Context) r9, (com.alibaba.fastjson.asm.MethodVisitor) r7)
            r0 = 25
            r7.visitVarInsn(r0, r14)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "()"
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "getContext"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r2, r1, r0)
            java.lang.String r0 = "context"
            int r0 = r9.var(r0)
            r7.visitVarInsn(r10, r0)
            r0 = 25
            r7.visitVarInsn(r0, r14)
            java.lang.String r1 = "context"
            int r1 = r9.var(r1)
            r7.visitVarInsn(r0, r1)
            java.lang.String r1 = "instance"
            int r1 = r9.var(r1)
            r7.visitVarInsn(r0, r1)
            r1 = 3
            r7.visitVarInsn(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "("
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r1 = "Ljava/lang/Object;Ljava/lang/Object;)"
            r0.append(r1)
            java.lang.Class<com.alibaba.fastjson.parser.ParseContext> r1 = com.alibaba.fastjson.parser.ParseContext.class
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "setContext"
            r4 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r4, r2, r1, r0)
            java.lang.String r0 = "childContext"
            int r0 = r9.var(r0)
            r7.visitVarInsn(r10, r0)
            int r0 = r9.var(r15)
            r1 = 25
            r7.visitVarInsn(r1, r0)
            r4 = 180(0xb4, float:2.52E-43)
            java.lang.String r2 = "matchStat"
            java.lang.String r1 = "I"
            r7.visitFieldInsn(r4, r3, r2, r1)
            r0 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r3)
            com.alibaba.fastjson.asm.Label r0 = new com.alibaba.fastjson.asm.Label
            r0.<init>()
            r3 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r3, r0)
            r3 = 200(0xc8, float:2.8E-43)
            r7.visitJumpInsn(r3, r13)
            r7.visitLabel(r0)
            r0 = 3
            r7.visitInsn(r0)
            int r3 = r9.var(r2)
            r7.visitIntInsn(r5, r3)
            com.alibaba.fastjson.util.FieldInfo[] r3 = r32.fieldInfoList
            int r3 = r3.length
            r4 = 0
        L_0x027d:
            if (r4 >= r3) goto L_0x02a2
            r7.visitInsn(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "_asm_flag_"
            r0.append(r10)
            int r10 = r4 / 32
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            int r0 = r9.var(r0)
            r7.visitVarInsn(r5, r0)
            int r4 = r4 + 32
            r0 = 3
            r10 = 58
            goto L_0x027d
        L_0x02a2:
            int r0 = r9.var(r15)
            r4 = 25
            r7.visitVarInsn(r4, r0)
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r0 = r0.mask
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r4 = "isEnabled"
            java.lang.String r10 = "(I)Z"
            r14 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r14, r0, r4, r10)
            java.lang.String r0 = "initStringFieldAsEmpty"
            int r0 = r9.var(r0)
            r7.visitIntInsn(r5, r0)
            r0 = 0
        L_0x02cb:
            if (r0 >= r3) goto L_0x03ba
            com.alibaba.fastjson.util.FieldInfo[] r4 = r32.fieldInfoList
            r4 = r4[r0]
            java.lang.Class<?> r10 = r4.fieldClass
            java.lang.Class r14 = java.lang.Boolean.TYPE
            if (r10 == r14) goto L_0x02e5
            java.lang.Class r14 = java.lang.Byte.TYPE
            if (r10 == r14) goto L_0x02e5
            java.lang.Class r14 = java.lang.Short.TYPE
            if (r10 == r14) goto L_0x02e5
            java.lang.Class r14 = java.lang.Integer.TYPE
            if (r10 != r14) goto L_0x02f0
        L_0x02e5:
            r25 = r6
            r24 = r11
            r22 = r12
            r23 = r13
            r5 = 3
            goto L_0x03a0
        L_0x02f0:
            java.lang.Class r14 = java.lang.Long.TYPE
            if (r10 != r14) goto L_0x030d
            r10 = 9
            r7.visitInsn(r10)
            r10 = 55
            r14 = 2
            int r4 = r9.var_asm(r4, r14)
            r7.visitVarInsn(r10, r4)
        L_0x0303:
            r25 = r6
            r24 = r11
            r22 = r12
            r23 = r13
            goto L_0x03ac
        L_0x030d:
            java.lang.Class r14 = java.lang.Float.TYPE
            if (r10 != r14) goto L_0x0320
            r10 = 11
            r7.visitInsn(r10)
            r10 = 56
            int r4 = r9.var_asm(r4)
            r7.visitVarInsn(r10, r4)
            goto L_0x0303
        L_0x0320:
            java.lang.Class r14 = java.lang.Double.TYPE
            if (r10 != r14) goto L_0x0334
            r10 = 14
            r7.visitInsn(r10)
            r10 = 57
            r14 = 2
            int r4 = r9.var_asm(r4, r14)
            r7.visitVarInsn(r10, r4)
            goto L_0x0303
        L_0x0334:
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            if (r10 != r14) goto L_0x0381
            com.alibaba.fastjson.asm.Label r14 = new com.alibaba.fastjson.asm.Label
            r14.<init>()
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r22 = r12
            java.lang.String r12 = "initStringFieldAsEmpty"
            int r12 = r9.var(r12)
            r23 = r13
            r13 = 21
            r7.visitVarInsn(r13, r12)
            r12 = 153(0x99, float:2.14E-43)
            r7.visitJumpInsn(r12, r5)
            r8._setFlag(r7, r9, r0)
            int r12 = r9.var(r15)
            r13 = 25
            r7.visitVarInsn(r13, r12)
            java.lang.String r12 = JSONLexerBase
            java.lang.String r13 = "stringDefaultValue"
            r24 = r11
            java.lang.String r11 = "()Ljava/lang/String;"
            r25 = r6
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r12, r13, r11)
            r6 = 167(0xa7, float:2.34E-43)
            r7.visitJumpInsn(r6, r14)
            r7.visitLabel(r5)
            r5 = 1
            r7.visitInsn(r5)
            r7.visitLabel(r14)
            goto L_0x038d
        L_0x0381:
            r25 = r6
            r24 = r11
            r22 = r12
            r23 = r13
            r5 = 1
            r7.visitInsn(r5)
        L_0x038d:
            r5 = 192(0xc0, float:2.69E-43)
            java.lang.String r6 = com.alibaba.fastjson.util.ASMUtils.type(r10)
            r7.visitTypeInsn(r5, r6)
            int r4 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r4)
            goto L_0x03ac
        L_0x03a0:
            r7.visitInsn(r5)
            int r4 = r9.var_asm(r4)
            r5 = 54
            r7.visitVarInsn(r5, r4)
        L_0x03ac:
            int r0 = r0 + 1
            r12 = r22
            r13 = r23
            r11 = r24
            r6 = r25
            r5 = 54
            goto L_0x02cb
        L_0x03ba:
            r25 = r6
            r24 = r11
            r22 = r12
            r23 = r13
            r10 = 0
        L_0x03c3:
            if (r10 >= r3) goto L_0x0b4f
            com.alibaba.fastjson.util.FieldInfo[] r0 = r32.fieldInfoList
            r4 = r0[r10]
            java.lang.Class<?> r5 = r4.fieldClass
            java.lang.reflect.Type r0 = r4.fieldType
            com.alibaba.fastjson.asm.Label r6 = new com.alibaba.fastjson.asm.Label
            r6.<init>()
            java.lang.Class r11 = java.lang.Boolean.TYPE
            java.lang.String r12 = "[C"
            if (r5 != r11) goto L_0x0415
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r5 = "scanFieldBoolean"
            java.lang.String r11 = "([C)Z"
            r12 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r12, r0, r5, r11)
            int r0 = r9.var_asm(r4)
            r4 = 54
            r7.visitVarInsn(r4, r0)
        L_0x0408:
            r27 = r3
            r28 = r6
        L_0x040c:
            r6 = r25
            r11 = 2
        L_0x040f:
            r13 = 182(0xb6, float:2.55E-43)
            r14 = 58
            goto L_0x0a23
        L_0x0415:
            java.lang.Class r11 = java.lang.Byte.TYPE
            java.lang.String r13 = "([C)I"
            java.lang.String r14 = "scanFieldInt"
            if (r5 != r11) goto L_0x0448
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            r5 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r5, r0, r14, r13)
            int r0 = r9.var_asm(r4)
            r4 = 54
            r7.visitVarInsn(r4, r0)
            goto L_0x0408
        L_0x0448:
            java.lang.Class<java.lang.Byte> r11 = java.lang.Byte.class
            r26 = 5
            r27 = r3
            java.lang.String r3 = "valueOf"
            r28 = r6
            r6 = 184(0xb8, float:2.58E-43)
            if (r5 != r11) goto L_0x04b6
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            r5 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r5, r0, r14, r13)
            java.lang.String r5 = "java/lang/Byte"
            java.lang.String r11 = "(B)Ljava/lang/Byte;"
            r7.visitMethodInsn(r6, r5, r3, r11)
            int r3 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r11 = 25
            r7.visitVarInsn(r11, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r26)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            int r0 = r9.var_asm(r4)
            r7.visitVarInsn(r5, r0)
            r7.visitLabel(r3)
            goto L_0x040c
        L_0x04b6:
            java.lang.Class r11 = java.lang.Short.TYPE
            if (r5 != r11) goto L_0x04e6
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            r3 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r3, r0, r14, r13)
            int r0 = r9.var_asm(r4)
            r3 = 54
            r7.visitVarInsn(r3, r0)
            goto L_0x040c
        L_0x04e6:
            java.lang.Class<java.lang.Short> r11 = java.lang.Short.class
            if (r5 != r11) goto L_0x054a
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            r5 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r5, r0, r14, r13)
            java.lang.String r5 = "java/lang/Short"
            java.lang.String r11 = "(S)Ljava/lang/Short;"
            r7.visitMethodInsn(r6, r5, r3, r11)
            int r3 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r11 = 25
            r7.visitVarInsn(r11, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r26)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            int r0 = r9.var_asm(r4)
            r7.visitVarInsn(r5, r0)
            r7.visitLabel(r3)
            goto L_0x040c
        L_0x054a:
            java.lang.Class r11 = java.lang.Integer.TYPE
            if (r5 != r11) goto L_0x057a
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            r3 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r3, r0, r14, r13)
            int r0 = r9.var_asm(r4)
            r3 = 54
            r7.visitVarInsn(r3, r0)
            goto L_0x040c
        L_0x057a:
            java.lang.Class<java.lang.Integer> r11 = java.lang.Integer.class
            if (r5 != r11) goto L_0x05de
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            r5 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r5, r0, r14, r13)
            java.lang.String r5 = "java/lang/Integer"
            java.lang.String r11 = "(I)Ljava/lang/Integer;"
            r7.visitMethodInsn(r6, r5, r3, r11)
            int r3 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r11 = 25
            r7.visitVarInsn(r11, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r26)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            int r0 = r9.var_asm(r4)
            r7.visitVarInsn(r5, r0)
            r7.visitLabel(r3)
            goto L_0x040c
        L_0x05de:
            java.lang.Class r11 = java.lang.Long.TYPE
            if (r5 != r11) goto L_0x0613
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldLong"
            java.lang.String r5 = "([C)J"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            r0 = 55
            r3 = 2
            int r4 = r9.var_asm(r4, r3)
            r7.visitVarInsn(r0, r4)
            goto L_0x040c
        L_0x0613:
            java.lang.Class<java.lang.Long> r11 = java.lang.Long.class
            if (r5 != r11) goto L_0x067b
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r5 = "scanFieldLong"
            java.lang.String r11 = "([C)J"
            r12 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r12, r0, r5, r11)
            java.lang.String r5 = "java/lang/Long"
            java.lang.String r11 = "(J)Ljava/lang/Long;"
            r7.visitMethodInsn(r6, r5, r3, r11)
            int r3 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r11 = 25
            r7.visitVarInsn(r11, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r26)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            int r0 = r9.var_asm(r4)
            r7.visitVarInsn(r5, r0)
            r7.visitLabel(r3)
            goto L_0x040c
        L_0x067b:
            java.lang.Class r11 = java.lang.Float.TYPE
            if (r5 != r11) goto L_0x06af
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloat"
            java.lang.String r5 = "([C)F"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            r0 = 56
            int r3 = r9.var_asm(r4)
            r7.visitVarInsn(r0, r3)
            goto L_0x040c
        L_0x06af:
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            if (r5 != r11) goto L_0x0717
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r11 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r11, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r5 = "scanFieldFloat"
            java.lang.String r11 = "([C)F"
            r12 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r12, r0, r5, r11)
            java.lang.String r5 = "java/lang/Float"
            java.lang.String r11 = "(F)Ljava/lang/Float;"
            r7.visitMethodInsn(r6, r5, r3, r11)
            int r3 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r11 = 25
            r7.visitVarInsn(r11, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r26)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            int r0 = r9.var_asm(r4)
            r7.visitVarInsn(r5, r0)
            r7.visitLabel(r3)
            goto L_0x040c
        L_0x0717:
            java.lang.Class r11 = java.lang.Double.TYPE
            if (r5 != r11) goto L_0x074e
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDouble"
            java.lang.String r5 = "([C)D"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            r0 = 57
            r11 = 2
            int r3 = r9.var_asm(r4, r11)
            r7.visitVarInsn(r0, r3)
        L_0x074a:
            r6 = r25
            goto L_0x040f
        L_0x074e:
            r11 = 2
            java.lang.Class<java.lang.Double> r13 = java.lang.Double.class
            if (r5 != r13) goto L_0x07b6
            int r0 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r0)
            r0 = 0
            r7.visitVarInsn(r5, r0)
            java.lang.String r0 = r32.className
            java.lang.String r5 = r9.fieldName(r4)
            r13 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r13, r0, r5, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r5 = "scanFieldDouble"
            java.lang.String r12 = "([C)D"
            r13 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r13, r0, r5, r12)
            java.lang.String r5 = "java/lang/Double"
            java.lang.String r12 = "(D)Ljava/lang/Double;"
            r7.visitMethodInsn(r6, r5, r3, r12)
            int r3 = r9.var_asm(r4)
            r5 = 58
            r7.visitVarInsn(r5, r3)
            com.alibaba.fastjson.asm.Label r3 = new com.alibaba.fastjson.asm.Label
            r3.<init>()
            int r6 = r9.var(r15)
            r12 = 25
            r7.visitVarInsn(r12, r6)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r26)
            r7.visitLdcInsn(r0)
            r0 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r0, r3)
            r0 = 1
            r7.visitInsn(r0)
            int r0 = r9.var_asm(r4)
            r7.visitVarInsn(r5, r0)
            r7.visitLabel(r3)
            goto L_0x074a
        L_0x07b6:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r5 != r3) goto L_0x07ea
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldString"
            java.lang.String r5 = "([C)Ljava/lang/String;"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x07ea:
            java.lang.Class<java.util.Date> r3 = java.util.Date.class
            if (r5 != r3) goto L_0x081e
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDate"
            java.lang.String r5 = "([C)Ljava/util/Date;"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x081e:
            java.lang.Class<java.util.UUID> r3 = java.util.UUID.class
            if (r5 != r3) goto L_0x0852
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldUUID"
            java.lang.String r5 = "([C)Ljava/util/UUID;"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x0852:
            java.lang.Class<java.math.BigDecimal> r3 = java.math.BigDecimal.class
            if (r5 != r3) goto L_0x0886
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldDecimal"
            java.lang.String r5 = "([C)Ljava/math/BigDecimal;"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x0886:
            java.lang.Class<java.math.BigInteger> r3 = java.math.BigInteger.class
            if (r5 != r3) goto L_0x08ba
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldBigInteger"
            java.lang.String r5 = "([C)Ljava/math/BigInteger;"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x08ba:
            java.lang.Class<int[]> r3 = int[].class
            if (r5 != r3) goto L_0x08ee
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldIntArray"
            java.lang.String r5 = "([C)[I"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x08ee:
            java.lang.Class<float[]> r3 = float[].class
            if (r5 != r3) goto L_0x0922
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloatArray"
            java.lang.String r5 = "([C)[F"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x0922:
            java.lang.Class<float[][]> r3 = float[][].class
            if (r5 != r3) goto L_0x0956
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            r0 = 0
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r5 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r5, r0, r3, r12)
            java.lang.String r0 = JSONLexerBase
            java.lang.String r3 = "scanFieldFloatArray2"
            java.lang.String r5 = "([C)[[F"
            r6 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r6, r0, r3, r5)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x074a
        L_0x0956:
            boolean r3 = r5.isEnum()
            if (r3 == 0) goto L_0x09c3
            r3 = 0
            r6 = 25
            r7.visitVarInsn(r6, r3)
            int r0 = r9.var(r15)
            r7.visitVarInsn(r6, r0)
            r7.visitVarInsn(r6, r3)
            java.lang.String r0 = r32.className
            java.lang.String r3 = r9.fieldName(r4)
            r6 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r6, r0, r3, r12)
            r8._getFieldDeser(r9, r7, r4)
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r0 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r6 = r25
            r3.append(r6)
            java.lang.String r12 = JSONLexerBase
            r3.append(r12)
            java.lang.String r12 = ";[C"
            r3.append(r12)
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> r12 = com.alibaba.fastjson.parser.deserializer.ObjectDeserializer.class
            java.lang.String r12 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r12)
            r3.append(r12)
            java.lang.String r12 = ")Ljava/lang/Enum;"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            java.lang.String r12 = "scanEnum"
            r13 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r13, r0, r12, r3)
            r0 = 192(0xc0, float:2.69E-43)
            java.lang.String r3 = com.alibaba.fastjson.util.ASMUtils.type(r5)
            r7.visitTypeInsn(r0, r3)
            int r0 = r9.var_asm(r4)
            r3 = 58
            r7.visitVarInsn(r3, r0)
            goto L_0x040f
        L_0x09c3:
            r6 = r25
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r5)
            if (r3 == 0) goto L_0x0b18
            int r3 = r9.var(r15)
            r13 = 25
            r7.visitVarInsn(r13, r3)
            r3 = 0
            r7.visitVarInsn(r13, r3)
            java.lang.String r3 = r32.className
            java.lang.String r13 = r9.fieldName(r4)
            r14 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r14, r3, r13, r12)
            java.lang.Class r12 = com.alibaba.fastjson.util.TypeUtils.getCollectionItemClass(r0)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r12 != r0) goto L_0x0aea
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r5)
            com.alibaba.fastjson.asm.Type r0 = com.alibaba.fastjson.asm.Type.getType(r0)
            r7.visitLdcInsn(r0)
            java.lang.String r0 = JSONLexerBase
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "([CLjava/lang/Class;)"
            r3.append(r5)
            java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
            java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r5)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "scanFieldStringArray"
            r13 = 182(0xb6, float:2.55E-43)
            r7.visitMethodInsn(r13, r0, r5, r3)
            int r0 = r9.var_asm(r4)
            r14 = 58
            r7.visitVarInsn(r14, r0)
        L_0x0a23:
            int r0 = r9.var(r15)
            r3 = 25
            r7.visitVarInsn(r3, r0)
            java.lang.String r0 = JSONLexerBase
            r4 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r4, r0, r2, r1)
            com.alibaba.fastjson.asm.Label r5 = new com.alibaba.fastjson.asm.Label
            r5.<init>()
            r12 = 158(0x9e, float:2.21E-43)
            r7.visitJumpInsn(r12, r5)
            r8._setFlag(r7, r9, r10)
            r7.visitLabel(r5)
            int r5 = r9.var(r15)
            r7.visitVarInsn(r3, r5)
            r7.visitFieldInsn(r4, r0, r2, r1)
            r3 = 89
            r7.visitInsn(r3)
            int r3 = r9.var(r2)
            r4 = 54
            r7.visitVarInsn(r4, r3)
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.visitLdcInsn(r3)
            r3 = 159(0x9f, float:2.23E-43)
            r4 = r24
            r7.visitJumpInsn(r3, r4)
            int r3 = r9.var(r15)
            r5 = 25
            r7.visitVarInsn(r5, r3)
            r3 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r3, r0, r2, r1)
            r3 = 158(0x9e, float:2.21E-43)
            r5 = r28
            r7.visitJumpInsn(r3, r5)
            java.lang.String r3 = "matchedCount"
            int r3 = r9.var(r3)
            r12 = 21
            r7.visitVarInsn(r12, r3)
            r3 = 4
            r7.visitInsn(r3)
            r12 = 96
            r7.visitInsn(r12)
            java.lang.String r12 = "matchedCount"
            int r12 = r9.var(r12)
            r11 = 54
            r7.visitVarInsn(r11, r12)
            int r12 = r9.var(r15)
            r11 = 25
            r7.visitVarInsn(r11, r12)
            r12 = 180(0xb4, float:2.52E-43)
            r7.visitFieldInsn(r12, r0, r2, r1)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            r7.visitLdcInsn(r13)
            r13 = 159(0x9f, float:2.23E-43)
            r14 = r18
            r7.visitJumpInsn(r13, r14)
            r7.visitLabel(r5)
            int r5 = r27 + -1
            if (r10 != r5) goto L_0x0ad7
            int r5 = r9.var(r15)
            r7.visitVarInsn(r11, r5)
            r7.visitFieldInsn(r12, r0, r2, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r7.visitLdcInsn(r0)
            r13 = 160(0xa0, float:2.24E-43)
            r7.visitJumpInsn(r13, r4)
        L_0x0ad7:
            r18 = r1
            r19 = r2
            r29 = r6
            r12 = r7
            r21 = r27
            r11 = 182(0xb6, float:2.55E-43)
            r13 = 25
            r17 = 180(0xb4, float:2.52E-43)
            r20 = 54
            r7 = r4
            goto L_0x0b3e
        L_0x0aea:
            r14 = r18
            r3 = 4
            r13 = 160(0xa0, float:2.24E-43)
            r17 = 180(0xb4, float:2.52E-43)
            r0 = r30
            r18 = r1
            r1 = r32
            r19 = r2
            r2 = r7
            r21 = r27
            r20 = 4
            r3 = r24
            r11 = 182(0xb6, float:2.55E-43)
            r13 = 25
            r20 = 54
            r29 = r6
            r6 = r12
            r12 = r7
            r7 = r10
            r0._deserialze_list_obj(r1, r2, r3, r4, r5, r6, r7)
            int r3 = r21 + -1
            r7 = r24
            if (r10 != r3) goto L_0x0b3e
            r8._deserialize_endCheck(r9, r12, r7)
            goto L_0x0b3e
        L_0x0b18:
            r19 = r2
            r29 = r6
            r12 = r7
            r14 = r18
            r7 = r24
            r21 = r27
            r11 = 182(0xb6, float:2.55E-43)
            r13 = 25
            r17 = 180(0xb4, float:2.52E-43)
            r20 = 54
            r18 = r1
            r0 = r30
            r1 = r32
            r2 = r12
            r3 = r7
            r6 = r10
            r0._deserialze_obj(r1, r2, r3, r4, r5, r6)
            int r3 = r21 + -1
            if (r10 != r3) goto L_0x0b3e
            r8._deserialize_endCheck(r9, r12, r7)
        L_0x0b3e:
            int r10 = r10 + 1
            r24 = r7
            r7 = r12
            r1 = r18
            r2 = r19
            r3 = r21
            r25 = r29
            r18 = r14
            goto L_0x03c3
        L_0x0b4f:
            r21 = r3
            r12 = r7
            r14 = r18
            r7 = r24
            r29 = r25
            r11 = 182(0xb6, float:2.55E-43)
            r13 = 25
            r12.visitLabel(r14)
            java.lang.Class r0 = r32.clazz
            boolean r0 = r0.isInterface()
            if (r0 != 0) goto L_0x0b7a
            java.lang.Class r0 = r32.clazz
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 != 0) goto L_0x0b7a
            r8._batchSet(r9, r12)
        L_0x0b7a:
            r0 = r23
            r12.visitLabel(r0)
            r8._setContext(r9, r12)
            java.lang.String r0 = "instance"
            int r0 = r9.var(r0)
            r12.visitVarInsn(r13, r0)
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r32.beanInfo
            java.lang.reflect.Method r0 = r0.buildMethod
            if (r0 == 0) goto L_0x0bbb
            java.lang.Class r1 = r32.getInstClass()
            java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.type(r1)
            java.lang.String r2 = r0.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "()"
            r3.append(r4)
            java.lang.Class r0 = r0.getReturnType()
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r12.visitMethodInsn(r11, r1, r2, r0)
        L_0x0bbb:
            r0 = 176(0xb0, float:2.47E-43)
            r12.visitInsn(r0)
            r12.visitLabel(r7)
            r8._batchSet(r9, r12)
            r0 = 0
            r12.visitVarInsn(r13, r0)
            r0 = 1
            r12.visitVarInsn(r13, r0)
            r0 = 2
            r12.visitVarInsn(r13, r0)
            r0 = 3
            r12.visitVarInsn(r13, r0)
            java.lang.String r0 = "instance"
            int r0 = r9.var(r0)
            r12.visitVarInsn(r13, r0)
            r0 = 21
            r1 = 4
            r12.visitVarInsn(r0, r1)
            int r3 = r21 / 32
            if (r21 == 0) goto L_0x0bef
            int r0 = r21 % 32
            if (r0 == 0) goto L_0x0bef
            int r3 = r3 + 1
        L_0x0bef:
            r0 = 1
            if (r3 != r0) goto L_0x0bf6
            r12.visitInsn(r1)
            goto L_0x0bfb
        L_0x0bf6:
            r0 = 16
            r12.visitIntInsn(r0, r3)
        L_0x0bfb:
            r0 = 188(0xbc, float:2.63E-43)
            r2 = 10
            r12.visitIntInsn(r0, r2)
            r0 = 0
        L_0x0c03:
            if (r0 >= r3) goto L_0x0c3f
            r2 = 89
            r12.visitInsn(r2)
            if (r0 != 0) goto L_0x0c11
            r2 = 3
            r12.visitInsn(r2)
            goto L_0x0c1d
        L_0x0c11:
            r2 = 1
            if (r0 != r2) goto L_0x0c18
            r12.visitInsn(r1)
            goto L_0x0c1d
        L_0x0c18:
            r2 = 16
            r12.visitIntInsn(r2, r0)
        L_0x0c1d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "_asm_flag_"
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            int r2 = r9.var(r2)
            r4 = 21
            r12.visitVarInsn(r4, r2)
            r2 = 79
            r12.visitInsn(r2)
            int r0 = r0 + 1
            goto L_0x0c03
        L_0x0c3f:
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r0 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r29
            r2.append(r3)
            java.lang.String r4 = DefaultJSONParser
            r2.append(r4)
            java.lang.String r5 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;"
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "parseRest"
            r12.visitMethodInsn(r11, r0, r5, r2)
            java.lang.Class r0 = r32.clazz
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            r2 = 192(0xc0, float:2.69E-43)
            r12.visitTypeInsn(r2, r0)
            r0 = 176(0xb0, float:2.47E-43)
            r12.visitInsn(r0)
            r0 = r22
            r12.visitLabel(r0)
            r0 = 0
            r12.visitVarInsn(r13, r0)
            r0 = 1
            r12.visitVarInsn(r13, r0)
            r0 = 2
            r12.visitVarInsn(r13, r0)
            r0 = 3
            r12.visitVarInsn(r13, r0)
            r0 = 21
            r12.visitVarInsn(r0, r1)
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r0 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.type(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r4)
            java.lang.String r2 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 183(0xb7, float:2.56E-43)
            java.lang.String r3 = "deserialze"
            r12.visitMethodInsn(r2, r0, r3, r1)
            r0 = 176(0xb0, float:2.47E-43)
            r12.visitInsn(r0)
            r0 = 10
            int r1 = r32.variantIndex
            r12.visitMaxs(r0, r1)
            r12.visitEnd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory._deserialze(com.alibaba.fastjson.asm.ClassWriter, com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory$Context):void");
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        Class<JavaBeanDeserializer> cls;
        int i;
        int i2;
        int i3;
        int i4;
        Context context2 = context;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str = DefaultJSONParser;
        sb.append(str);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", sb.toString(), (String) null, (String[]) null);
        defineVarLexer(context2, methodWriter);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(182, str, "getSymbolTable", "()" + ASMUtils.desc((Class<?>) SymbolTable.class));
        String str2 = JSONLexerBase;
        methodWriter.visitMethodInsn(182, str2, "scanTypeName", oIX0oI.I0Io.f17332II0xO0 + ASMUtils.desc((Class<?>) SymbolTable.class) + ")Ljava/lang/String;");
        methodWriter.visitVarInsn(58, context2.var("typeName"));
        Label label = new Label();
        methodWriter.visitVarInsn(25, context2.var("typeName"));
        methodWriter.visitJumpInsn(198, label);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(182, str, "getConfig", "()" + ASMUtils.desc((Class<?>) ParserConfig.class));
        methodWriter.visitVarInsn(25, 0);
        Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
        methodWriter.visitFieldInsn(180, ASMUtils.type(cls2), "beanInfo", ASMUtils.desc((Class<?>) JavaBeanInfo.class));
        methodWriter.visitVarInsn(25, context2.var("typeName"));
        String type = ASMUtils.type(cls2);
        methodWriter.visitMethodInsn(184, type, "getSeeAlso", oIX0oI.I0Io.f17332II0xO0 + ASMUtils.desc((Class<?>) ParserConfig.class) + ASMUtils.desc((Class<?>) JavaBeanInfo.class) + "Ljava/lang/String;)" + ASMUtils.desc((Class<?>) cls2));
        methodWriter.visitVarInsn(58, context2.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, context2.var("userTypeDeser"));
        methodWriter.visitTypeInsn(193, ASMUtils.type(cls2));
        methodWriter.visitJumpInsn(153, label);
        methodWriter.visitVarInsn(25, context2.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitVarInsn(25, 4);
        String type2 = ASMUtils.type(cls2);
        methodWriter.visitMethodInsn(182, type2, "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        methodWriter.visitInsn(176);
        methodWriter.visitLabel(label);
        _createInstance(context2, (MethodVisitor) methodWriter);
        FieldInfo[] fieldInfoArr = context.beanInfo.sortedFields;
        int length = fieldInfoArr.length;
        int i5 = 0;
        while (i5 < length) {
            boolean z = i5 == length + -1;
            int i6 = z ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr[i5];
            Class<?> cls3 = fieldInfo.fieldClass;
            java.lang.reflect.Type type3 = fieldInfo.fieldType;
            int i7 = length;
            FieldInfo[] fieldInfoArr2 = fieldInfoArr;
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                i2 = i5;
                String str3 = "scanInt";
                cls = cls2;
                i = i7;
                methodWriter.visitVarInsn(25, context2.var("lexer"));
                methodWriter.visitVarInsn(16, i6);
                methodWriter.visitMethodInsn(182, JSONLexerBase, str3, "(C)I");
                methodWriter.visitVarInsn(54, context2.var_asm(fieldInfo));
            } else {
                boolean z2 = z;
                String str4 = "(I)V";
                int i8 = i5;
                if (cls3 == Byte.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str5 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str5, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    Label label2 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str5, "matchStat", Oxx0IOOO.f13869xI);
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label2);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    methodWriter.visitLabel(label2);
                } else if (cls3 == Short.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str6 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str6, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    Label label3 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str6, "matchStat", Oxx0IOOO.f13869xI);
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label3);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    methodWriter.visitLabel(label3);
                } else if (cls3 == Integer.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str7 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str7, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    Label label4 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str7, "matchStat", Oxx0IOOO.f13869xI);
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label4);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    methodWriter.visitLabel(label4);
                } else if (cls3 == Long.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
                    methodWriter.visitVarInsn(55, context2.var_asm(fieldInfo, 2));
                } else if (cls3 == Long.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str8 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str8, "scanLong", "(C)J");
                    methodWriter.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    Label label5 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str8, "matchStat", Oxx0IOOO.f13869xI);
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label5);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    methodWriter.visitLabel(label5);
                } else if (cls3 == Boolean.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
                    methodWriter.visitVarInsn(54, context2.var_asm(fieldInfo));
                } else if (cls3 == Float.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
                    methodWriter.visitVarInsn(56, context2.var_asm(fieldInfo));
                } else if (cls3 == Float.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str9 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str9, "scanFloat", "(C)F");
                    methodWriter.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    Label label6 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str9, "matchStat", Oxx0IOOO.f13869xI);
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label6);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    methodWriter.visitLabel(label6);
                } else if (cls3 == Double.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
                    methodWriter.visitVarInsn(57, context2.var_asm(fieldInfo, 2));
                } else if (cls3 == Double.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String str10 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str10, "scanDouble", "(C)D");
                    methodWriter.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    Label label7 = new Label();
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitFieldInsn(180, str10, "matchStat", Oxx0IOOO.f13869xI);
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label7);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    methodWriter.visitLabel(label7);
                } else if (cls3 == Character.TYPE) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitInsn(3);
                    methodWriter.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
                    methodWriter.visitVarInsn(54, context2.var_asm(fieldInfo));
                } else if (cls3 == String.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                } else if (cls3 == BigDecimal.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                } else if (cls3 == Date.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDate", "(C)Ljava/util/Date;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                } else if (cls3 == UUID.class) {
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanUUID", "(C)Ljava/util/UUID;");
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                } else if (cls3.isEnum()) {
                    Label label8 = new Label();
                    Label label9 = new Label();
                    Label label10 = new Label();
                    Label label11 = new Label();
                    cls = cls2;
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    String str11 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str11, "getCurrent", "()C");
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(54, context2.var("ch"));
                    methodWriter.visitLdcInsn(110);
                    methodWriter.visitJumpInsn(159, label11);
                    methodWriter.visitVarInsn(21, context2.var("ch"));
                    methodWriter.visitLdcInsn(34);
                    methodWriter.visitJumpInsn(160, label8);
                    methodWriter.visitLabel(label11);
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                    methodWriter.visitVarInsn(25, 1);
                    String str12 = DefaultJSONParser;
                    methodWriter.visitMethodInsn(182, str12, "getSymbolTable", "()" + ASMUtils.desc((Class<?>) SymbolTable.class));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, str11, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc((Class<?>) SymbolTable.class) + "C)Ljava/lang/Enum;");
                    methodWriter.visitJumpInsn(167, label10);
                    methodWriter.visitLabel(label8);
                    methodWriter.visitVarInsn(21, context2.var("ch"));
                    methodWriter.visitLdcInsn(48);
                    methodWriter.visitJumpInsn(161, label9);
                    methodWriter.visitVarInsn(21, context2.var("ch"));
                    methodWriter.visitLdcInsn(57);
                    methodWriter.visitJumpInsn(163, label9);
                    _getFieldDeser(context2, methodWriter, fieldInfo);
                    methodWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(182, str11, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(182, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                    methodWriter.visitJumpInsn(167, label10);
                    methodWriter.visitLabel(label9);
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitVarInsn(25, context2.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    String type4 = ASMUtils.type(cls);
                    methodWriter.visitMethodInsn(182, type4, "scanEnum", "(L" + str11 + ";C)Ljava/lang/Enum;");
                    methodWriter.visitLabel(label10);
                    methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                    methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                    i = i7;
                    i2 = i8;
                } else {
                    cls = cls2;
                    if (Collection.class.isAssignableFrom(cls3)) {
                        Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type3);
                        if (collectionItemClass == String.class) {
                            if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                methodWriter.visitTypeInsn(187, ASMUtils.type(ArrayList.class));
                                methodWriter.visitInsn(89);
                                methodWriter.visitMethodInsn(183, ASMUtils.type(ArrayList.class), X0o0xo.f5789oOoXoXO, "()V");
                            } else {
                                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodWriter.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                            }
                            methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitVarInsn(25, context2.var_asm(fieldInfo));
                            methodWriter.visitVarInsn(16, i6);
                            String str13 = JSONLexerBase;
                            methodWriter.visitMethodInsn(182, str13, "scanStringArray", "(Ljava/util/Collection;C)V");
                            Label label12 = new Label();
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitFieldInsn(180, str13, "matchStat", Oxx0IOOO.f13869xI);
                            methodWriter.visitLdcInsn(5);
                            methodWriter.visitJumpInsn(160, label12);
                            methodWriter.visitInsn(1);
                            methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                            methodWriter.visitLabel(label12);
                            i4 = i8;
                        } else {
                            Label label13 = new Label();
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            String str14 = JSONLexerBase;
                            methodWriter.visitMethodInsn(182, str14, "token", "()I");
                            methodWriter.visitVarInsn(54, context2.var("token"));
                            methodWriter.visitVarInsn(21, context2.var("token"));
                            int i9 = i8 == 0 ? 14 : 16;
                            methodWriter.visitLdcInsn(Integer.valueOf(i9));
                            methodWriter.visitJumpInsn(159, label13);
                            methodWriter.visitVarInsn(25, 1);
                            methodWriter.visitLdcInsn(Integer.valueOf(i9));
                            String str15 = DefaultJSONParser;
                            String str16 = str4;
                            methodWriter.visitMethodInsn(182, str15, "throwException", str16);
                            methodWriter.visitLabel(label13);
                            Label label14 = new Label();
                            Label label15 = new Label();
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitMethodInsn(182, str14, "getCurrent", "()C");
                            methodWriter.visitVarInsn(16, 91);
                            methodWriter.visitJumpInsn(160, label14);
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitMethodInsn(182, str14, "next", "()C");
                            methodWriter.visitInsn(87);
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitLdcInsn(14);
                            methodWriter.visitMethodInsn(182, str14, "setToken", str16);
                            methodWriter.visitJumpInsn(167, label15);
                            methodWriter.visitLabel(label14);
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitLdcInsn(14);
                            methodWriter.visitMethodInsn(182, str14, "nextToken", str16);
                            methodWriter.visitLabel(label15);
                            i4 = i8;
                            _newCollection(methodWriter, cls3, i4, false);
                            methodWriter.visitInsn(89);
                            methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                            _getCollectionFieldItemDeser(context2, methodWriter, fieldInfo, collectionItemClass);
                            methodWriter.visitVarInsn(25, 1);
                            methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(collectionItemClass)));
                            methodWriter.visitVarInsn(25, 3);
                            String type5 = ASMUtils.type(cls);
                            methodWriter.visitMethodInsn(184, type5, "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc((Class<?>) ObjectDeserializer.class) + "L" + str15 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                        }
                        i2 = i4;
                        i = i7;
                    } else {
                        String str17 = str4;
                        int i10 = i8;
                        if (cls3.isArray()) {
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitLdcInsn(14);
                            methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", str17);
                            methodWriter.visitVarInsn(25, 1);
                            methodWriter.visitVarInsn(25, 0);
                            methodWriter.visitLdcInsn(Integer.valueOf(i10));
                            methodWriter.visitMethodInsn(182, ASMUtils.type(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                            methodWriter.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                            methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                            methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                            i2 = i10;
                            i = i7;
                        } else {
                            Label label16 = new Label();
                            Label label17 = new Label();
                            if (cls3 == Date.class) {
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                String str18 = JSONLexerBase;
                                methodWriter.visitMethodInsn(182, str18, "getCurrent", "()C");
                                methodWriter.visitLdcInsn(49);
                                methodWriter.visitJumpInsn(160, label16);
                                methodWriter.visitTypeInsn(187, ASMUtils.type(Date.class));
                                methodWriter.visitInsn(89);
                                methodWriter.visitVarInsn(25, context2.var("lexer"));
                                i3 = 16;
                                methodWriter.visitVarInsn(16, i6);
                                methodWriter.visitMethodInsn(182, str18, "scanLong", "(C)J");
                                methodWriter.visitMethodInsn(183, ASMUtils.type(Date.class), X0o0xo.f5789oOoXoXO, "(J)V");
                                methodWriter.visitVarInsn(58, context2.var_asm(fieldInfo));
                                methodWriter.visitJumpInsn(167, label17);
                            } else {
                                i3 = 16;
                            }
                            methodWriter.visitLabel(label16);
                            _quickNextToken(context2, methodWriter, 14);
                            i2 = i10;
                            i = i7;
                            _deserObject(context, methodWriter, fieldInfo, cls3, i2);
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            methodWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
                            methodWriter.visitLdcInsn(15);
                            methodWriter.visitJumpInsn(159, label17);
                            methodWriter.visitVarInsn(25, 0);
                            methodWriter.visitVarInsn(25, context2.var("lexer"));
                            if (!z2) {
                                methodWriter.visitLdcInsn(Integer.valueOf(i3));
                            } else {
                                methodWriter.visitLdcInsn(15);
                            }
                            String type6 = ASMUtils.type(cls);
                            methodWriter.visitMethodInsn(183, type6, "check", oIX0oI.I0Io.f17332II0xO0 + ASMUtils.desc((Class<?>) JSONLexer.class) + "I)V");
                            methodWriter.visitLabel(label17);
                        }
                    }
                }
                cls = cls2;
                i = i7;
                i2 = i8;
            }
            i5 = i2 + 1;
            length = i;
            fieldInfoArr = fieldInfoArr2;
            cls2 = cls;
        }
        String str19 = "(I)V";
        _batchSet(context2, methodWriter, false);
        Label label18 = new Label();
        Label label19 = new Label();
        Label label20 = new Label();
        Label label21 = new Label();
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        String str20 = JSONLexerBase;
        methodWriter.visitMethodInsn(182, str20, "getCurrent", "()C");
        methodWriter.visitInsn(89);
        methodWriter.visitVarInsn(54, context2.var("ch"));
        methodWriter.visitVarInsn(16, 44);
        methodWriter.visitJumpInsn(160, label19);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitMethodInsn(182, str20, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(182, str20, "setToken", str19);
        methodWriter.visitJumpInsn(167, label21);
        methodWriter.visitLabel(label19);
        methodWriter.visitVarInsn(21, context2.var("ch"));
        methodWriter.visitVarInsn(16, 93);
        methodWriter.visitJumpInsn(160, label20);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitMethodInsn(182, str20, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(15);
        methodWriter.visitMethodInsn(182, str20, "setToken", str19);
        methodWriter.visitJumpInsn(167, label21);
        methodWriter.visitLabel(label20);
        methodWriter.visitVarInsn(21, context2.var("ch"));
        methodWriter.visitVarInsn(16, 26);
        methodWriter.visitJumpInsn(160, label18);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitMethodInsn(182, str20, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(20);
        methodWriter.visitMethodInsn(182, str20, "setToken", str19);
        methodWriter.visitJumpInsn(167, label21);
        methodWriter.visitLabel(label18);
        methodWriter.visitVarInsn(25, context2.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(182, str20, "nextToken", str19);
        methodWriter.visitLabel(label21);
        methodWriter.visitVarInsn(25, context2.var("instance"));
        methodWriter.visitInsn(176);
        methodWriter.visitMaxs(5, context.variantIndex);
        methodWriter.visitEnd();
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        Label label2;
        int i2;
        int i3;
        int i4;
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label3 = label;
        FieldInfo fieldInfo2 = fieldInfo;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        int i5 = i;
        Label label4 = new Label();
        String str5 = JSONLexerBase;
        methodVisitor2.visitMethodInsn(182, str5, "matchField", "([C)Z");
        methodVisitor2.visitJumpInsn(153, label4);
        _setFlag(methodVisitor2, context2, i5);
        Label label5 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str5, "token", "()I");
        methodVisitor2.visitLdcInsn(8);
        methodVisitor2.visitJumpInsn(160, label5);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(16);
        methodVisitor2.visitMethodInsn(182, str5, "nextToken", "(I)V");
        methodVisitor2.visitJumpInsn(167, label4);
        methodVisitor2.visitLabel(label5);
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = label4;
        Label label9 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str5, "token", "()I");
        methodVisitor2.visitLdcInsn(21);
        methodVisitor2.visitJumpInsn(160, label7);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(14);
        methodVisitor2.visitMethodInsn(182, str5, "nextToken", "(I)V");
        _newCollection(methodVisitor2, cls3, i5, true);
        methodVisitor2.visitJumpInsn(167, label6);
        methodVisitor2.visitLabel(label7);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str5, "token", "()I");
        methodVisitor2.visitLdcInsn(14);
        methodVisitor2.visitJumpInsn(159, label9);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str5, "token", "()I");
        methodVisitor2.visitLdcInsn(12);
        methodVisitor2.visitJumpInsn(160, label);
        _newCollection(methodVisitor2, cls3, i5, false);
        FieldInfo fieldInfo3 = fieldInfo;
        String str6 = "token";
        methodVisitor2.visitVarInsn(58, context2.var_asm(fieldInfo3));
        Class<?> cls5 = cls2;
        _getCollectionFieldItemDeser(context2, methodVisitor2, fieldInfo3, cls5);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor2.visitInsn(3);
        String str7 = str5;
        String str8 = "nextToken";
        methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        Class<ObjectDeserializer> cls6 = ObjectDeserializer.class;
        String type = ASMUtils.type(cls6);
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str9 = DefaultJSONParser;
        sb.append(str9);
        String str10 = str9;
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str11 = "(I)V";
        methodVisitor2.visitMethodInsn(185, type, "deserialze", sb.toString());
        methodVisitor2.visitVarInsn(58, context2.var("list_item_value"));
        methodVisitor2.visitVarInsn(25, context2.var_asm(fieldInfo3));
        methodVisitor2.visitVarInsn(25, context2.var("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            methodVisitor2.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            methodVisitor2.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor2.visitInsn(87);
        Label label10 = label8;
        methodVisitor2.visitJumpInsn(167, label10);
        methodVisitor2.visitLabel(label9);
        _newCollection(methodVisitor2, cls3, i5, false);
        methodVisitor2.visitLabel(label6);
        methodVisitor2.visitVarInsn(58, context2.var_asm(fieldInfo3));
        boolean isPrimitive2 = ParserConfig.isPrimitive2(fieldInfo3.fieldClass);
        _getCollectionFieldItemDeser(context2, methodVisitor2, fieldInfo3, cls5);
        if (isPrimitive2) {
            methodVisitor2.visitMethodInsn(185, ASMUtils.type(cls6), "getFastMatchToken", "()I");
            methodVisitor2.visitVarInsn(54, context2.var("fastMatchToken"));
            methodVisitor2.visitVarInsn(25, context2.var("lexer"));
            methodVisitor2.visitVarInsn(21, context2.var("fastMatchToken"));
            str2 = str7;
            str3 = str8;
            str4 = str11;
            methodVisitor2.visitMethodInsn(182, str2, str3, str4);
            label2 = label10;
        } else {
            str2 = str7;
            str3 = str8;
            str4 = str11;
            methodVisitor2.visitInsn(87);
            methodVisitor2.visitLdcInsn(12);
            label2 = label10;
            methodVisitor2.visitVarInsn(54, context2.var("fastMatchToken"));
            _quickNextToken(context2, methodVisitor2, 12);
        }
        methodVisitor2.visitVarInsn(25, 1);
        String str12 = str4;
        String str13 = str10;
        methodVisitor2.visitMethodInsn(182, str13, "getContext", "()" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor2.visitVarInsn(58, context2.var("listContext"));
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context2.var_asm(fieldInfo3));
        methodVisitor2.visitLdcInsn(fieldInfo3.name);
        methodVisitor2.visitMethodInsn(182, str13, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor2.visitInsn(87);
        Label label11 = new Label();
        Label label12 = new Label();
        methodVisitor2.visitInsn(3);
        String str14 = str3;
        methodVisitor2.visitVarInsn(54, context2.var("i"));
        methodVisitor2.visitLabel(label11);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        String str15 = str6;
        methodVisitor2.visitMethodInsn(182, str2, str15, "()I");
        methodVisitor2.visitLdcInsn(15);
        methodVisitor2.visitJumpInsn(159, label12);
        Label label13 = label12;
        methodVisitor2.visitVarInsn(25, 0);
        String access$300 = context.className;
        StringBuilder sb2 = new StringBuilder();
        String str16 = "fastMatchToken";
        sb2.append(fieldInfo3.name);
        sb2.append("_asm_list_item_deser__");
        boolean z = isPrimitive2;
        methodVisitor2.visitFieldInsn(180, access$300, sb2.toString(), ASMUtils.desc((Class<?>) cls6));
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor2.visitVarInsn(21, context2.var("i"));
        methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type2 = ASMUtils.type(cls6);
        methodVisitor2.visitMethodInsn(185, type2, "deserialze", "(L" + str13 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str17 = str;
        methodVisitor2.visitVarInsn(58, context2.var(str17));
        methodVisitor2.visitIincInsn(context2.var("i"), 1);
        methodVisitor2.visitVarInsn(25, context2.var_asm(fieldInfo3));
        methodVisitor2.visitVarInsn(25, context2.var(str17));
        if (cls.isInterface()) {
            methodVisitor2.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            i3 = 87;
            i2 = 182;
        } else {
            i2 = 182;
            methodVisitor2.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            i3 = 87;
        }
        methodVisitor2.visitInsn(i3);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context2.var_asm(fieldInfo3));
        methodVisitor2.visitMethodInsn(i2, str13, "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(i2, str2, str15, "()I");
        methodVisitor2.visitLdcInsn(16);
        methodVisitor2.visitJumpInsn(160, label11);
        if (z) {
            methodVisitor2.visitVarInsn(25, context2.var("lexer"));
            methodVisitor2.visitVarInsn(21, context2.var(str16));
            methodVisitor2.visitMethodInsn(i2, str2, str14, str12);
            i4 = 167;
        } else {
            _quickNextToken(context2, methodVisitor2, 12);
            i4 = 167;
        }
        methodVisitor2.visitJumpInsn(i4, label11);
        methodVisitor2.visitLabel(label13);
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context2.var("listContext"));
        methodVisitor2.visitMethodInsn(182, str13, "setContext", oIX0oI.I0Io.f17332II0xO0 + ASMUtils.desc((Class<?>) ParseContext.class) + ")V");
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str2, str15, "()I");
        methodVisitor2.visitLdcInsn(15);
        methodVisitor2.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
        methodVisitor2.visitLabel(label2);
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i) {
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        FieldInfo fieldInfo2 = fieldInfo;
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitFieldInsn(180, context.className, context2.fieldName(fieldInfo2), "[C");
        methodVisitor2.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor2.visitJumpInsn(154, label2);
        methodVisitor2.visitInsn(1);
        methodVisitor2.visitVarInsn(58, context2.var_asm(fieldInfo2));
        methodVisitor2.visitJumpInsn(167, label3);
        methodVisitor2.visitLabel(label2);
        int i2 = i;
        _setFlag(methodVisitor2, context2, i2);
        methodVisitor2.visitVarInsn(21, context2.var("matchedCount"));
        methodVisitor2.visitInsn(4);
        methodVisitor2.visitInsn(96);
        methodVisitor2.visitVarInsn(54, context2.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i2);
        methodVisitor2.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        methodVisitor2.visitMethodInsn(182, str, "getResolveStatus", "()I");
        methodVisitor2.visitLdcInsn(1);
        methodVisitor2.visitJumpInsn(160, label3);
        methodVisitor2.visitVarInsn(25, 1);
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        Class<DefaultJSONParser.ResolveTask> cls2 = DefaultJSONParser.ResolveTask.class;
        sb.append(ASMUtils.desc((Class<?>) cls2));
        methodVisitor2.visitMethodInsn(182, str, "getLastResolveTask", sb.toString());
        methodVisitor2.visitVarInsn(58, context2.var("resolveTask"));
        methodVisitor2.visitVarInsn(25, context2.var("resolveTask"));
        methodVisitor2.visitVarInsn(25, 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("()");
        Class<ParseContext> cls3 = ParseContext.class;
        sb2.append(ASMUtils.desc((Class<?>) cls3));
        methodVisitor2.visitMethodInsn(182, str, "getContext", sb2.toString());
        methodVisitor2.visitFieldInsn(181, ASMUtils.type(cls2), "ownerContext", ASMUtils.desc((Class<?>) cls3));
        methodVisitor2.visitVarInsn(25, context2.var("resolveTask"));
        methodVisitor2.visitVarInsn(25, 0);
        methodVisitor2.visitLdcInsn(fieldInfo2.name);
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(Ljava/lang/String;)");
        Class<FieldDeserializer> cls4 = FieldDeserializer.class;
        sb3.append(ASMUtils.desc((Class<?>) cls4));
        methodVisitor2.visitMethodInsn(182, type, "getFieldDeserializer", sb3.toString());
        methodVisitor2.visitFieldInsn(181, ASMUtils.type(cls2), "fieldDeserializer", ASMUtils.desc((Class<?>) cls4));
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitLdcInsn(0);
        methodVisitor2.visitMethodInsn(182, str, "setResolveStatus", "(I)V");
        methodVisitor2.visitLabel(label3);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String access$300 = context.className;
        Class<ObjectDeserializer> cls2 = ObjectDeserializer.class;
        methodVisitor.visitFieldInsn(180, access$300, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        Class<ParserConfig> cls3 = ParserConfig.class;
        sb.append(ASMUtils.desc((Class<?>) cls3));
        methodVisitor.visitMethodInsn(182, str, "getConfig", sb.toString());
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        String type = ASMUtils.type(cls3);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc((Class<?>) cls2));
        String access$3002 = context.className;
        methodVisitor.visitFieldInsn(181, access$3002, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String access$3003 = context.className;
        methodVisitor.visitFieldInsn(180, access$3003, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2));
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        Class<ObjectDeserializer> cls = ObjectDeserializer.class;
        methodVisitor.visitFieldInsn(180, context.className, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) cls));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        Class<ParserConfig> cls2 = ParserConfig.class;
        sb.append(ASMUtils.desc((Class<?>) cls2));
        methodVisitor.visitMethodInsn(182, str, "getConfig", sb.toString());
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        String type = ASMUtils.type(cls2);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc((Class<?>) cls));
        methodVisitor.visitFieldInsn(181, context.className, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) cls));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) cls));
    }

    private void _init(ClassWriter classWriter, Context context) {
        ClassWriter classWriter2 = classWriter;
        Context context2 = context;
        for (FieldInfo fieldName : context.fieldInfoList) {
            new FieldWriter(classWriter2, 1, context2.fieldName(fieldName), "[C").visitEnd();
        }
        for (FieldInfo fieldInfo : context.fieldInfoList) {
            Class<?> cls = fieldInfo.fieldClass;
            if (!cls.isPrimitive()) {
                Class<ObjectDeserializer> cls2 = ObjectDeserializer.class;
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter2, 1, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc((Class<?>) cls2)).visitEnd();
                } else {
                    new FieldWriter(classWriter2, 1, context2.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) cls2)).visitEnd();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(oIX0oI.I0Io.f17332II0xO0);
        Class<ParserConfig> cls3 = ParserConfig.class;
        sb.append(ASMUtils.desc((Class<?>) cls3));
        Class<JavaBeanInfo> cls4 = JavaBeanInfo.class;
        sb.append(ASMUtils.desc((Class<?>) cls4));
        sb.append(")V");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, X0o0xo.f5789oOoXoXO, sb.toString(), (String) null, (String[]) null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), X0o0xo.f5789oOoXoXO, oIX0oI.I0Io.f17332II0xO0 + ASMUtils.desc((Class<?>) cls3) + ASMUtils.desc((Class<?>) cls4) + ")V");
        for (FieldInfo fieldInfo2 : context.fieldInfoList) {
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo2.name + "\":");
            methodWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
            methodWriter.visitFieldInsn(181, context.className, context2.fieldName(fieldInfo2), "[C");
        }
        methodWriter.visitInsn(177);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(153, label);
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        java.lang.reflect.Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var_asm(fieldInfo, 2));
            if (fieldInfo.method != null) {
                methodVisitor.visitMethodInsn(182, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
                if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                    methodVisitor.visitInsn(87);
                    return;
                }
                return;
            }
            methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var_asm(fieldInfo, 2));
            _set(context, methodVisitor, fieldInfo);
        } else {
            Class<String> cls2 = String.class;
            if (cls == cls2) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
                _set(context, methodVisitor, fieldInfo);
            } else if (cls.isEnum()) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
                _set(context, methodVisitor, fieldInfo);
            } else if (Collection.class.isAssignableFrom(cls)) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                if (TypeUtils.getCollectionItemClass(type) == cls2) {
                    methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
                    methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
                } else {
                    methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
                }
                _set(context, methodVisitor, fieldInfo);
            } else {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
                _set(context, methodVisitor, fieldInfo);
            }
        }
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i, boolean z) {
        if (!cls.isAssignableFrom(ArrayList.class) || z) {
            Class<LinkedList> cls2 = LinkedList.class;
            if (!cls.isAssignableFrom(cls2) || z) {
                Class<HashSet> cls3 = HashSet.class;
                if (cls.isAssignableFrom(cls3)) {
                    methodVisitor.visitTypeInsn(187, ASMUtils.type(cls3));
                    methodVisitor.visitInsn(89);
                    methodVisitor.visitMethodInsn(183, ASMUtils.type(cls3), X0o0xo.f5789oOoXoXO, "()V");
                } else {
                    Class<TreeSet> cls4 = TreeSet.class;
                    if (cls.isAssignableFrom(cls4)) {
                        methodVisitor.visitTypeInsn(187, ASMUtils.type(cls4));
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitMethodInsn(183, ASMUtils.type(cls4), X0o0xo.f5789oOoXoXO, "()V");
                    } else {
                        Class<LinkedHashSet> cls5 = LinkedHashSet.class;
                        if (cls.isAssignableFrom(cls5)) {
                            methodVisitor.visitTypeInsn(187, ASMUtils.type(cls5));
                            methodVisitor.visitInsn(89);
                            methodVisitor.visitMethodInsn(183, ASMUtils.type(cls5), X0o0xo.f5789oOoXoXO, "()V");
                        } else if (z) {
                            methodVisitor.visitTypeInsn(187, ASMUtils.type(cls3));
                            methodVisitor.visitInsn(89);
                            methodVisitor.visitMethodInsn(183, ASMUtils.type(cls3), X0o0xo.f5789oOoXoXO, "()V");
                        } else {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitLdcInsn(Integer.valueOf(i));
                            methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                            methodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
                        }
                    }
                }
            } else {
                methodVisitor.visitTypeInsn(187, ASMUtils.type(cls2));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(cls2), X0o0xo.f5789oOoXoXO, "()V");
            }
        } else {
            methodVisitor.visitTypeInsn(187, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, "java/util/ArrayList", X0o0xo.f5789oOoXoXO, "()V");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i) {
        Label label = new Label();
        Label label2 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str, "getCurrent", "()C");
        if (i == 12) {
            methodVisitor.visitVarInsn(16, 123);
        } else if (i == 14) {
            methodVisitor.visitVarInsn(16, 91);
        } else {
            throw new IllegalStateException();
        }
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(182, str, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
        Context context2 = context;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor2.visitMethodInsn(182, str, "getCurrent", "()C");
        methodVisitor2.visitInsn(89);
        methodVisitor2.visitVarInsn(54, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 44);
        methodVisitor2.visitJumpInsn(160, label2);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str, "next", "()C");
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(16);
        methodVisitor2.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(167, label5);
        methodVisitor2.visitLabel(label2);
        methodVisitor2.visitVarInsn(21, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 125);
        methodVisitor2.visitJumpInsn(160, label3);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str, "next", "()C");
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(13);
        methodVisitor2.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(167, label5);
        methodVisitor2.visitLabel(label3);
        methodVisitor2.visitVarInsn(21, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 93);
        methodVisitor2.visitJumpInsn(160, label4);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str, "next", "()C");
        methodVisitor2.visitInsn(87);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(15);
        methodVisitor2.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(167, label5);
        methodVisitor2.visitLabel(label4);
        methodVisitor2.visitVarInsn(21, context2.var("ch"));
        methodVisitor2.visitVarInsn(16, 26);
        methodVisitor2.visitJumpInsn(160, label);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitLdcInsn(20);
        methodVisitor2.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor2.visitJumpInsn(167, label5);
        methodVisitor2.visitLabel(label);
        methodVisitor2.visitVarInsn(25, context2.var("lexer"));
        methodVisitor2.visitMethodInsn(182, str, "nextToken", "()V");
        methodVisitor2.visitLabel(label5);
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        int i;
        Method method = fieldInfo.method;
        if (method != null) {
            if (method.getDeclaringClass().isInterface()) {
                i = 185;
            } else {
                i = 182;
            }
            methodVisitor.visitMethodInsn(i, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
            if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                methodVisitor.visitInsn(87);
                return;
            }
            return;
        }
        methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(bn.f.o));
        String str = DefaultJSONParser;
        StringBuilder sb = new StringBuilder();
        sb.append(oIX0oI.I0Io.f17332II0xO0);
        Class<ParseContext> cls = ParseContext.class;
        sb.append(ASMUtils.desc((Class<?>) cls));
        sb.append(")V");
        methodVisitor.visitMethodInsn(182, str, "setContext", sb.toString());
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(198, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(cls), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i) {
        String str = "_asm_flag_" + (i / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc((Class<?>) JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        String str;
        Class<?> cls = javaBeanInfo.clazz;
        if (!cls.isPrimitive()) {
            String str2 = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
            Package packageR = ASMDeserializerFactory.class.getPackage();
            if (packageR != null) {
                String name = packageR.getName();
                String str3 = name.replace('.', com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX) + "/" + str2;
                str = name + FileUtils.FILE_EXTENSION_SEPARATOR + str2;
                str2 = str3;
            } else {
                str = str2;
            }
            ClassWriter classWriter = new ClassWriter();
            classWriter.visit(49, 33, str2, ASMUtils.type(JavaBeanDeserializer.class), (String[]) null);
            _init(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _createInstance(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _deserialze(classWriter, new Context(str2, parserConfig, javaBeanInfo, 5));
            _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, javaBeanInfo, 4));
            byte[] byteArray = classWriter.toByteArray();
            return (ObjectDeserializer) this.classLoader.defineClassPublic(str, byteArray, 0, byteArray.length).getConstructor(new Class[]{ParserConfig.class, JavaBeanInfo.class}).newInstance(new Object[]{parserConfig, javaBeanInfo});
        }
        throw new IllegalArgumentException("not support type :" + cls.getName());
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            Label label = new Label();
            if (z) {
                _isFlag(methodVisitor, context, i, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i]);
            if (z) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        if (Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", (String) null, (String[]) null);
            methodWriter.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodWriter.visitInsn(89);
            methodWriter.visitMethodInsn(183, ASMUtils.type(context.getInstClass()), X0o0xo.f5789oOoXoXO, "()V");
            methodWriter.visitInsn(176);
            methodWriter.visitMaxs(3, 3);
            methodWriter.visitEnd();
        }
    }
}
