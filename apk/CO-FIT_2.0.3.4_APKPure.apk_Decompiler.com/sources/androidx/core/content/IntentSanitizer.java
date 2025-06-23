package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    /* access modifiers changed from: private */
    public boolean mAllowAnyComponent;
    /* access modifiers changed from: private */
    public boolean mAllowClipDataText;
    /* access modifiers changed from: private */
    public boolean mAllowIdentifier;
    /* access modifiers changed from: private */
    public boolean mAllowSelector;
    /* access modifiers changed from: private */
    public boolean mAllowSourceBounds;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedActions;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedCategories;
    /* access modifiers changed from: private */
    public Predicate<ClipData> mAllowedClipData;
    /* access modifiers changed from: private */
    public Predicate<Uri> mAllowedClipDataUri;
    /* access modifiers changed from: private */
    public Predicate<ComponentName> mAllowedComponents;
    /* access modifiers changed from: private */
    public Predicate<Uri> mAllowedData;
    /* access modifiers changed from: private */
    public Map<String, Predicate<Object>> mAllowedExtras;
    /* access modifiers changed from: private */
    public int mAllowedFlags;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedPackages;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedTypes;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }

        @DoNotInline
        public static Intent setIdentifier(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() != null || item.getIntent() != null || item.getTextLinks() != null) {
                consumer.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
            }
        }
    }

    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText = false;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions = new x0XOIxOo();
        private Predicate<String> mAllowedCategories = new IXxxXO();
        private Predicate<ClipData> mAllowedClipData = new IIXOooo();
        private Predicate<Uri> mAllowedClipDataUri = new OxxIIOOXO();
        private Predicate<ComponentName> mAllowedComponents = new oI0IIXIo();
        private Predicate<Uri> mAllowedData = new oO();
        private Map<String, Predicate<Object>> mAllowedExtras = new HashMap();
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages = new Oxx0xo();
        private Predicate<String> mAllowedTypes = new x0xO0oo();

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName componentName) {
            return true;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$12(Object obj) {
            return true;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$13(Class cls, Predicate predicate, Object obj) {
            if (!cls.isInstance(obj) || !predicate.test(cls.cast(obj))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$14(Object obj) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$1(Uri uri) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$2(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$3(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$4(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$5(ComponentName componentName) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$6(Uri uri) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$7(ClipData clipData) {
            return false;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowAction(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            allowAction((Predicate<String>) new X0o0xo(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new xoIox();
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowCategory(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowCategory((Predicate<String>) new X0o0xo(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowClipData(@NonNull Predicate<ClipData> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipData = this.mAllowedClipData.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowClipDataUri(@NonNull Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowClipDataUriWithAuthority(@NonNull String str) {
            Preconditions.checkNotNull(str);
            return allowClipDataUri(new OOXIXo(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowComponent(@NonNull ComponentName componentName) {
            Preconditions.checkNotNull(componentName);
            Objects.requireNonNull(componentName);
            return allowComponent((Predicate<ComponentName>) new xxIXOIIO(componentName));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowComponentWithPackage(@NonNull String str) {
            Preconditions.checkNotNull(str);
            return allowComponent((Predicate<ComponentName>) new XO(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowData(@NonNull Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedData = this.mAllowedData.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowDataWithAuthority(@NonNull String str) {
            Preconditions.checkNotNull(str);
            allowData(new Oxx0IOOO(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowExtra(@NonNull String str, @NonNull Class<?> cls) {
            return allowExtra(str, cls, new xoXoI());
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowExtraOutput(@NonNull String str) {
            allowExtra("output", Uri.class, new oxoX(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowExtraStream(@NonNull Predicate<Uri> predicate) {
            allowExtra("android.intent.extra.STREAM", Uri.class, predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowExtraStreamUriWithAuthority(@NonNull String str) {
            Preconditions.checkNotNull(str);
            allowExtra("android.intent.extra.STREAM", Uri.class, new ooOOo0oXI(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowFlags(int i) {
            this.mAllowedFlags = i | this.mAllowedFlags;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowPackage(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowPackage((Predicate<String>) new X0o0xo(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowType((Predicate<String>) new X0o0xo(str));
        }

        @NonNull
        public IntentSanitizer build() {
            boolean z = this.mAllowAnyComponent;
            if ((!z || !this.mAllowSomeComponents) && (z || this.mAllowSomeComponents)) {
                IntentSanitizer intentSanitizer = new IntentSanitizer();
                int unused = intentSanitizer.mAllowedFlags = this.mAllowedFlags;
                Predicate unused2 = intentSanitizer.mAllowedActions = this.mAllowedActions;
                Predicate unused3 = intentSanitizer.mAllowedData = this.mAllowedData;
                Predicate unused4 = intentSanitizer.mAllowedTypes = this.mAllowedTypes;
                Predicate unused5 = intentSanitizer.mAllowedCategories = this.mAllowedCategories;
                Predicate unused6 = intentSanitizer.mAllowedPackages = this.mAllowedPackages;
                boolean unused7 = intentSanitizer.mAllowAnyComponent = this.mAllowAnyComponent;
                Predicate unused8 = intentSanitizer.mAllowedComponents = this.mAllowedComponents;
                Map unused9 = intentSanitizer.mAllowedExtras = this.mAllowedExtras;
                boolean unused10 = intentSanitizer.mAllowClipDataText = this.mAllowClipDataText;
                Predicate unused11 = intentSanitizer.mAllowedClipDataUri = this.mAllowedClipDataUri;
                Predicate unused12 = intentSanitizer.mAllowedClipData = this.mAllowedClipData;
                boolean unused13 = intentSanitizer.mAllowIdentifier = this.mAllowIdentifier;
                boolean unused14 = intentSanitizer.mAllowSelector = this.mAllowSelector;
                boolean unused15 = intentSanitizer.mAllowSourceBounds = this.mAllowSourceBounds;
                return intentSanitizer;
            }
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public <T> Builder allowExtra(@NonNull String str, @NonNull Class<T> cls, @NonNull Predicate<T> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(predicate);
            return allowExtra(str, (Predicate<Object>) new II0XooXoX(cls, predicate));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowExtraOutput(@NonNull Predicate<Uri> predicate) {
            allowExtra("output", Uri.class, predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowAction(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedActions = this.mAllowedActions.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowCategory(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedCategories = this.mAllowedCategories.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowComponent(@NonNull Predicate<ComponentName> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowPackage(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedPackages = this.mAllowedPackages.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowType(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedTypes = this.mAllowedTypes.or(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder allowExtra(@NonNull String str, @NonNull Predicate<Object> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(predicate);
            Predicate predicate2 = this.mAllowedExtras.get(str);
            if (predicate2 == null) {
                new oOoXoXO
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v5 ? I:androidx.core.content.oOoXoXO) =  call: androidx.core.content.oOoXoXO.<init>():void type: CONSTRUCTOR in method: androidx.core.content.IntentSanitizer.Builder.allowExtra(java.lang.String, androidx.core.util.Predicate):androidx.core.content.IntentSanitizer$Builder, dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v5 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 49 more
                    */
                /*
                    this = this;
                    androidx.core.util.Preconditions.checkNotNull(r2)
                    androidx.core.util.Preconditions.checkNotNull(r3)
                    java.util.Map<java.lang.String, androidx.core.util.Predicate<java.lang.Object>> r0 = r1.mAllowedExtras
                    java.lang.Object r0 = r0.get(r2)
                    androidx.core.util.Predicate r0 = (androidx.core.util.Predicate) r0
                    if (r0 != 0) goto L_0x0015
                    androidx.core.content.oOoXoXO r0 = new androidx.core.content.oOoXoXO
                    r0.<init>()
                L_0x0015:
                    androidx.core.util.Predicate r3 = r0.or(r3)
                    java.util.Map<java.lang.String, androidx.core.util.Predicate<java.lang.Object>> r0 = r1.mAllowedExtras
                    r0.put(r2, r3)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.IntentSanitizer.Builder.allowExtra(java.lang.String, androidx.core.util.Predicate):androidx.core.content.IntentSanitizer$Builder");
            }
        }

        private static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() != null || item.getIntent() != null) {
                consumer.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$sanitizeByFiltering$0(String str) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$sanitizeByThrowing$1(String str) {
            throw new SecurityException(str);
        }

        private void putExtra(Intent intent, String str, Object obj) {
            if (obj == null) {
                intent.getExtras().putString(str, (String) null);
            } else if (obj instanceof Parcelable) {
                intent.putExtra(str, (Parcelable) obj);
            } else if (obj instanceof Parcelable[]) {
                intent.putExtra(str, (Parcelable[]) obj);
            } else if (obj instanceof Serializable) {
                intent.putExtra(str, (Serializable) obj);
            } else {
                throw new IllegalArgumentException("Unsupported type " + obj.getClass());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void sanitizeClipData(@androidx.annotation.NonNull android.content.Intent r7, android.content.Intent r8, androidx.core.util.Predicate<android.content.ClipData> r9, boolean r10, androidx.core.util.Predicate<android.net.Uri> r11, androidx.core.util.Consumer<java.lang.String> r12) {
            /*
                android.content.ClipData r7 = r7.getClipData()
                if (r7 != 0) goto L_0x0007
                return
            L_0x0007:
                if (r9 == 0) goto L_0x0014
                boolean r9 = r9.test(r7)
                if (r9 == 0) goto L_0x0014
                r8.setClipData(r7)
                goto L_0x00de
            L_0x0014:
                r9 = 0
                r0 = 0
                r1 = r9
            L_0x0017:
                int r2 = r7.getItemCount()
                if (r0 >= r2) goto L_0x00d9
                android.content.ClipData$Item r2 = r7.getItemAt(r0)
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 31
                if (r3 < r4) goto L_0x002b
                androidx.core.content.IntentSanitizer.Api31Impl.checkOtherMembers(r0, r2, r12)
                goto L_0x002e
            L_0x002b:
                checkOtherMembers(r0, r2, r12)
            L_0x002e:
                if (r10 == 0) goto L_0x0035
                java.lang.CharSequence r3 = r2.getText()
                goto L_0x005c
            L_0x0035:
                java.lang.CharSequence r3 = r2.getText()
                if (r3 == 0) goto L_0x005b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Item text cannot contain value. Item position: "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r4 = ". Text: "
                r3.append(r4)
                java.lang.CharSequence r4 = r2.getText()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r12.accept(r3)
            L_0x005b:
                r3 = r9
            L_0x005c:
                java.lang.String r4 = ". URI: "
                java.lang.String r5 = "Item URI is not allowed. Item position: "
                if (r11 != 0) goto L_0x0085
                android.net.Uri r6 = r2.getUri()
                if (r6 == 0) goto L_0x00b2
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                r6.append(r0)
                r6.append(r4)
                android.net.Uri r2 = r2.getUri()
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r12.accept(r2)
                goto L_0x00b2
            L_0x0085:
                android.net.Uri r6 = r2.getUri()
                if (r6 == 0) goto L_0x00b4
                android.net.Uri r6 = r2.getUri()
                boolean r6 = r11.test(r6)
                if (r6 == 0) goto L_0x0096
                goto L_0x00b4
            L_0x0096:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                r6.append(r0)
                r6.append(r4)
                android.net.Uri r2 = r2.getUri()
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r12.accept(r2)
            L_0x00b2:
                r2 = r9
                goto L_0x00b8
            L_0x00b4:
                android.net.Uri r2 = r2.getUri()
            L_0x00b8:
                if (r3 != 0) goto L_0x00bc
                if (r2 == 0) goto L_0x00d5
            L_0x00bc:
                if (r1 != 0) goto L_0x00cd
                android.content.ClipData r1 = new android.content.ClipData
                android.content.ClipDescription r4 = r7.getDescription()
                android.content.ClipData$Item r5 = new android.content.ClipData$Item
                r5.<init>(r3, r9, r2)
                r1.<init>(r4, r5)
                goto L_0x00d5
            L_0x00cd:
                android.content.ClipData$Item r4 = new android.content.ClipData$Item
                r4.<init>(r3, r9, r2)
                r1.addItem(r4)
            L_0x00d5:
                int r0 = r0 + 1
                goto L_0x0017
            L_0x00d9:
                if (r1 == 0) goto L_0x00de
                r8.setClipData(r1)
            L_0x00de:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.IntentSanitizer.sanitizeClipData(android.content.Intent, android.content.Intent, androidx.core.util.Predicate, boolean, androidx.core.util.Predicate, androidx.core.util.Consumer):void");
        }

        @NonNull
        public Intent sanitize(@NonNull Intent intent, @NonNull Consumer<String> consumer) {
            Intent intent2 = new Intent();
            ComponentName component = intent.getComponent();
            if ((!this.mAllowAnyComponent || component != null) && !this.mAllowedComponents.test(component)) {
                consumer.accept("Component is not allowed: " + component);
                intent2.setComponent(new ComponentName("android", "java.lang.Void"));
            } else {
                intent2.setComponent(component);
            }
            String str = intent.getPackage();
            if (str == null || this.mAllowedPackages.test(str)) {
                intent2.setPackage(str);
            } else {
                consumer.accept("Package is not allowed: " + str);
            }
            int flags = this.mAllowedFlags | intent.getFlags();
            int i = this.mAllowedFlags;
            if (flags == i) {
                intent2.setFlags(intent.getFlags());
            } else {
                intent2.setFlags(intent.getFlags() & i);
                consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.mAllowedFlags)));
            }
            String action = intent.getAction();
            if (action == null || this.mAllowedActions.test(action)) {
                intent2.setAction(action);
            } else {
                consumer.accept("Action is not allowed: " + action);
            }
            Uri data = intent.getData();
            if (data == null || this.mAllowedData.test(data)) {
                intent2.setData(data);
            } else {
                consumer.accept("Data is not allowed: " + data);
            }
            String type = intent.getType();
            if (type == null || this.mAllowedTypes.test(type)) {
                intent2.setDataAndType(intent2.getData(), type);
            } else {
                consumer.accept("Type is not allowed: " + type);
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                for (String next : categories) {
                    if (this.mAllowedCategories.test(next)) {
                        intent2.addCategory(next);
                    } else {
                        consumer.accept("Category is not allowed: " + next);
                    }
                }
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String next2 : extras.keySet()) {
                    if (next2.equals("android.intent.extra.STREAM") && (this.mAllowedFlags & 1) == 0) {
                        consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                    } else if (!next2.equals("output") || ((~this.mAllowedFlags) & 3) == 0) {
                        Object obj = extras.get(next2);
                        Predicate predicate = this.mAllowedExtras.get(next2);
                        if (predicate == null || !predicate.test(obj)) {
                            consumer.accept("Extra is not allowed. Key: " + next2 + ". Value: " + obj);
                        } else {
                            putExtra(intent2, next2, obj);
                        }
                    } else {
                        consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                    }
                }
            }
            sanitizeClipData(intent, intent2, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, consumer);
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.mAllowIdentifier) {
                    Api29Impl.setIdentifier(intent2, Api29Impl.getIdentifier(intent));
                } else if (Api29Impl.getIdentifier(intent) != null) {
                    consumer.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(intent));
                }
            }
            if (this.mAllowSelector) {
                intent2.setSelector(intent.getSelector());
            } else if (intent.getSelector() != null) {
                consumer.accept("Selector is not allowed: " + intent.getSelector());
            }
            if (this.mAllowSourceBounds) {
                intent2.setSourceBounds(intent.getSourceBounds());
            } else if (intent.getSourceBounds() != null) {
                consumer.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
            }
            return intent2;
        }

        @NonNull
        public Intent sanitizeByFiltering(@NonNull Intent intent) {
            return sanitize(intent, new I0Io());
        }

        @NonNull
        public Intent sanitizeByThrowing(@NonNull Intent intent) {
            return sanitize(intent, new II0xO0());
        }

        private IntentSanitizer() {
        }
    }
