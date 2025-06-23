package com.bluetrum.abota.time;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import OXOo.xoIox;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nTimber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timber.kt\ncom/bluetrum/abota/time/Timber\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,456:1\n26#2:457\n*S KotlinDebug\n*F\n+ 1 Timber.kt\ncom/bluetrum/abota/time/Timber\n*L\n453#1:457\n*E\n"})
/* loaded from: classes8.dex */
public final class Timber {

    @OOXIXo
    public static final Forest Forest = new Forest(null);

    @OOXIXo
    private static final ArrayList<Tree> trees = new ArrayList<>();

    @OOXIXo
    private static volatile Tree[] treeArray = new Tree[0];

    @XX({"SMAP\nTimber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timber.kt\ncom/bluetrum/abota/time/Timber$DebugTree\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,456:1\n1109#2,2:457\n1#3:459\n*S KotlinDebug\n*F\n+ 1 Timber.kt\ncom/bluetrum/abota/time/Timber$DebugTree\n*L\n206#1:457,2\n*E\n"})
    /* loaded from: classes8.dex */
    public static class DebugTree extends Tree {
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        @OOXIXo
        private final List<String> fqcnIgnore = CollectionsKt__CollectionsKt.X00IoxXI(Timber.class.getName(), Forest.class.getName(), Tree.class.getName(), DebugTree.class.getName());

        @OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        @oOoXoXO
        public String createStackElementTag(@OOXIXo StackTraceElement element) {
            IIX0o.x0xO0oo(element, "element");
            String className = element.getClassName();
            IIX0o.oO(className, "getClassName(...)");
            String oIxOXo2 = StringsKt__StringsKt.oIxOXo(className, '.', null, 2, null);
            Matcher matcher = ANONYMOUS_CLASS.matcher(oIxOXo2);
            if (matcher.find()) {
                oIxOXo2 = matcher.replaceAll("");
                IIX0o.oO(oIxOXo2, "replaceAll(...)");
            }
            if (oIxOXo2.length() > 23 && Build.VERSION.SDK_INT < 26) {
                String substring = oIxOXo2.substring(0, 23);
                IIX0o.oO(substring, "substring(...)");
                return substring;
            }
            return oIxOXo2;
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @oOoXoXO
        public String getTag$AndroidDfuLib_release() {
            String tag$AndroidDfuLib_release = super.getTag$AndroidDfuLib_release();
            if (tag$AndroidDfuLib_release == null) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                IIX0o.oO(stackTrace, "getStackTrace(...)");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (!this.fqcnIgnore.contains(stackTraceElement.getClassName())) {
                        return createStackElementTag(stackTraceElement);
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
            return tag$AndroidDfuLib_release;
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        public void log(int i, @oOoXoXO String str, @OOXIXo String message, @oOoXoXO Throwable th) {
            int min;
            IIX0o.x0xO0oo(message, "message");
            if (message.length() < 4000) {
                if (i == 7) {
                    Log.wtf(str, message);
                    return;
                } else {
                    Log.println(i, str, message);
                    return;
                }
            }
            int length = message.length();
            int i2 = 0;
            while (i2 < length) {
                int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(message, '\n', i2, false, 4, null);
                if (XxIIOXIXx2 == -1) {
                    XxIIOXIXx2 = length;
                }
                while (true) {
                    min = Math.min(XxIIOXIXx2, i2 + 4000);
                    String substring = message.substring(i2, min);
                    IIX0o.oO(substring, "substring(...)");
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (min >= XxIIOXIXx2) {
                        break;
                    } else {
                        i2 = min;
                    }
                }
                i2 = min + 1;
            }
        }
    }

    @XX({"SMAP\nTimber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timber.kt\ncom/bluetrum/abota/time/Timber$Forest\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,456:1\n13309#2,2:457\n13309#2,2:459\n13309#2,2:461\n13309#2,2:463\n13309#2,2:465\n13309#2,2:467\n13309#2,2:469\n13309#2,2:471\n13309#2,2:473\n13309#2,2:475\n13309#2,2:477\n13309#2,2:479\n13309#2,2:481\n13309#2,2:483\n13309#2,2:485\n13309#2,2:487\n13309#2,2:489\n13309#2,2:491\n13309#2,2:493\n13309#2,2:495\n13309#2,2:497\n1#3:499\n37#4,2:500\n37#4,2:502\n37#4,2:504\n26#5:506\n*S KotlinDebug\n*F\n+ 1 Timber.kt\ncom/bluetrum/abota/time/Timber$Forest\n*L\n277#1:457,2\n282#1:459,2\n287#1:461,2\n292#1:463,2\n297#1:465,2\n302#1:467,2\n307#1:469,2\n312#1:471,2\n317#1:473,2\n322#1:475,2\n327#1:477,2\n332#1:479,2\n337#1:481,2\n342#1:483,2\n347#1:485,2\n352#1:487,2\n357#1:489,2\n362#1:491,2\n367#1:493,2\n373#1:495,2\n378#1:497,2\n409#1:500,2\n421#1:502,2\n429#1:504,2\n437#1:506\n*E\n"})
    /* loaded from: classes8.dex */
    public static final class Forest extends Tree {
        public /* synthetic */ Forest(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public Tree asTree() {
            return this;
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void d(@oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.d(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void e(@oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.e(str, Arrays.copyOf(args, args.length));
            }
        }

        @x0XOIxOo
        @OOXIXo
        public final List<Tree> forest() {
            List<Tree> unmodifiableList;
            synchronized (Timber.trees) {
                unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.oOo0o(Timber.trees));
                IIX0o.oO(unmodifiableList, "unmodifiableList(...)");
            }
            return unmodifiableList;
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void i(@oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.i(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void log(int i, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.log(i, str, Arrays.copyOf(args, args.length));
            }
        }

        @x0XOIxOo
        public final void plant(@OOXIXo Tree tree) {
            IIX0o.x0xO0oo(tree, "tree");
            if (tree != this) {
                synchronized (Timber.trees) {
                    Timber.trees.add(tree);
                    Forest forest = Timber.Forest;
                    Timber.treeArray = (Tree[]) Timber.trees.toArray(new Tree[0]);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }

        @x0XOIxOo
        @OOXIXo
        public final Tree tag(@OOXIXo String tag) {
            IIX0o.x0xO0oo(tag, "tag");
            for (Tree tree : Timber.treeArray) {
                tree.getExplicitTag$AndroidDfuLib_release().set(tag);
            }
            return this;
        }

        @x0XOIxOo
        @xxIXOIIO(name = "treeCount")
        public final int treeCount() {
            return Timber.treeArray.length;
        }

        @x0XOIxOo
        public final void uproot(@OOXIXo Tree tree) {
            IIX0o.x0xO0oo(tree, "tree");
            synchronized (Timber.trees) {
                if (Timber.trees.remove(tree)) {
                    Forest forest = Timber.Forest;
                    Timber.treeArray = (Tree[]) Timber.trees.toArray(new Tree[0]);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } else {
                    throw new IllegalArgumentException(("Cannot uproot tree which is not planted: " + tree).toString());
                }
            }
        }

        @x0XOIxOo
        public final void uprootAll() {
            synchronized (Timber.trees) {
                Timber.trees.clear();
                Forest forest = Timber.Forest;
                Timber.treeArray = new Tree[0];
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void v(@oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.v(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void w(@oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.w(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void wtf(@oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.wtf(str, Arrays.copyOf(args, args.length));
            }
        }

        private Forest() {
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void d(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.d(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void e(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.e(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void i(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.i(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void log(int i, @oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.log(i, th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void v(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.v(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void w(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.w(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void wtf(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            for (Tree tree : Timber.treeArray) {
                tree.wtf(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void d(@oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.d(th);
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void e(@oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.e(th);
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void i(@oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.i(th);
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void log(int i, @oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.log(i, th);
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void v(@oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.v(th);
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void w(@oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.w(th);
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        @x0XOIxOo
        public void wtf(@oOoXoXO Throwable th) {
            for (Tree tree : Timber.treeArray) {
                tree.wtf(th);
            }
        }

        @x0XOIxOo
        public final void plant(@OOXIXo Tree... trees) {
            IIX0o.x0xO0oo(trees, "trees");
            for (Tree tree : trees) {
                if (tree == null) {
                    throw new IllegalArgumentException("trees contained null");
                }
                if (tree == this) {
                    throw new IllegalArgumentException("Cannot plant Timber into itself.");
                }
            }
            synchronized (Timber.trees) {
                Collections.addAll(Timber.trees, Arrays.copyOf(trees, trees.length));
                Forest forest = Timber.Forest;
                Timber.treeArray = (Tree[]) Timber.trees.toArray(new Tree[0]);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }

        @Override // com.bluetrum.abota.time.Timber.Tree
        public void log(int i, @oOoXoXO String str, @OOXIXo String message, @oOoXoXO Throwable th) {
            IIX0o.x0xO0oo(message, "message");
            throw new AssertionError();
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class Tree {

        @OOXIXo
        private final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        private final String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            IIX0o.oO(stringWriter2, "toString(...)");
            return stringWriter2;
        }

        private final void prepareLog(int i, Throwable th, String str, Object... objArr) {
            boolean z;
            String tag$AndroidDfuLib_release = getTag$AndroidDfuLib_release();
            if (!isLoggable(tag$AndroidDfuLib_release, i)) {
                return;
            }
            if (str != null && str.length() != 0) {
                if (objArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    str = formatMessage(str, objArr);
                }
                if (th != null) {
                    str = str + '\n' + getStackTraceString(th);
                }
            } else if (th == null) {
                return;
            } else {
                str = getStackTraceString(th);
            }
            log(i, tag$AndroidDfuLib_release, str, th);
        }

        public void d(@oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(3, null, str, Arrays.copyOf(args, args.length));
        }

        public void e(@oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(6, null, str, Arrays.copyOf(args, args.length));
        }

        @OOXIXo
        public String formatMessage(@OOXIXo String message, @OOXIXo Object[] args) {
            IIX0o.x0xO0oo(message, "message");
            IIX0o.x0xO0oo(args, "args");
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(message, Arrays.copyOf(copyOf, copyOf.length));
            IIX0o.oO(format, "format(...)");
            return format;
        }

        public final /* synthetic */ ThreadLocal getExplicitTag$AndroidDfuLib_release() {
            return this.explicitTag;
        }

        public /* synthetic */ String getTag$AndroidDfuLib_release() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        public void i(@oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(4, null, str, Arrays.copyOf(args, args.length));
        }

        @kotlin.OOXIXo(message = "Use isLoggable(String, int)", replaceWith = @kotlin.XX(expression = "this.isLoggable(null, priority)", imports = {}))
        public boolean isLoggable(int i) {
            return true;
        }

        public abstract void log(int i, @oOoXoXO String str, @OOXIXo String str2, @oOoXoXO Throwable th);

        public void log(int i, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(i, null, str, Arrays.copyOf(args, args.length));
        }

        public void v(@oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(2, null, str, Arrays.copyOf(args, args.length));
        }

        public void w(@oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(5, null, str, Arrays.copyOf(args, args.length));
        }

        public void wtf(@oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(7, null, str, Arrays.copyOf(args, args.length));
        }

        public void d(@oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(3, th, str, Arrays.copyOf(args, args.length));
        }

        public void e(@oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(6, th, str, Arrays.copyOf(args, args.length));
        }

        public void i(@oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(4, th, str, Arrays.copyOf(args, args.length));
        }

        public boolean isLoggable(@oOoXoXO String str, int i) {
            return isLoggable(i);
        }

        public void log(int i, @oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(i, th, str, Arrays.copyOf(args, args.length));
        }

        public void v(@oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(2, th, str, Arrays.copyOf(args, args.length));
        }

        public void w(@oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(5, th, str, Arrays.copyOf(args, args.length));
        }

        public void wtf(@oOoXoXO Throwable th, @oOoXoXO String str, @OOXIXo Object... args) {
            IIX0o.x0xO0oo(args, "args");
            prepareLog(7, th, str, Arrays.copyOf(args, args.length));
        }

        public void d(@oOoXoXO Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        public void e(@oOoXoXO Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void i(@oOoXoXO Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        public void log(int i, @oOoXoXO Throwable th) {
            prepareLog(i, th, null, new Object[0]);
        }

        public void v(@oOoXoXO Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        public void w(@oOoXoXO Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        public void wtf(@oOoXoXO Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }
    }

    private Timber() {
        throw new AssertionError();
    }

    @x0XOIxOo
    @OOXIXo
    public static Tree asTree() {
        return Forest.asTree();
    }

    @x0XOIxOo
    public static void d(@oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.d(str, objArr);
    }

    @x0XOIxOo
    public static void e(@oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.e(str, objArr);
    }

    @x0XOIxOo
    @OOXIXo
    public static final List<Tree> forest() {
        return Forest.forest();
    }

    @x0XOIxOo
    public static void i(@oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.i(str, objArr);
    }

    @x0XOIxOo
    public static void log(int i, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.log(i, str, objArr);
    }

    @x0XOIxOo
    public static final void plant(@OOXIXo Tree tree) {
        Forest.plant(tree);
    }

    @x0XOIxOo
    @OOXIXo
    public static final Tree tag(@OOXIXo String str) {
        return Forest.tag(str);
    }

    @x0XOIxOo
    @xxIXOIIO(name = "treeCount")
    public static final int treeCount() {
        return Forest.treeCount();
    }

    @x0XOIxOo
    public static final void uproot(@OOXIXo Tree tree) {
        Forest.uproot(tree);
    }

    @x0XOIxOo
    public static final void uprootAll() {
        Forest.uprootAll();
    }

    @x0XOIxOo
    public static void v(@oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.v(str, objArr);
    }

    @x0XOIxOo
    public static void w(@oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.w(str, objArr);
    }

    @x0XOIxOo
    public static void wtf(@oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.wtf(str, objArr);
    }

    @x0XOIxOo
    public static void d(@oOoXoXO Throwable th) {
        Forest.d(th);
    }

    @x0XOIxOo
    public static void e(@oOoXoXO Throwable th) {
        Forest.e(th);
    }

    @x0XOIxOo
    public static void i(@oOoXoXO Throwable th) {
        Forest.i(th);
    }

    @x0XOIxOo
    public static void log(int i, @oOoXoXO Throwable th) {
        Forest.log(i, th);
    }

    @x0XOIxOo
    public static final void plant(@OOXIXo Tree... treeArr) {
        Forest.plant(treeArr);
    }

    @x0XOIxOo
    public static void v(@oOoXoXO Throwable th) {
        Forest.v(th);
    }

    @x0XOIxOo
    public static void w(@oOoXoXO Throwable th) {
        Forest.w(th);
    }

    @x0XOIxOo
    public static void wtf(@oOoXoXO Throwable th) {
        Forest.wtf(th);
    }

    @x0XOIxOo
    public static void d(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.d(th, str, objArr);
    }

    @x0XOIxOo
    public static void e(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.e(th, str, objArr);
    }

    @x0XOIxOo
    public static void i(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.i(th, str, objArr);
    }

    @x0XOIxOo
    public static void log(int i, @oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.log(i, th, str, objArr);
    }

    @x0XOIxOo
    public static void v(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.v(th, str, objArr);
    }

    @x0XOIxOo
    public static void w(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.w(th, str, objArr);
    }

    @x0XOIxOo
    public static void wtf(@oOoXoXO Throwable th, @oOoXoXO @xoIox String str, @OOXIXo Object... objArr) {
        Forest.wtf(th, str, objArr);
    }
}
