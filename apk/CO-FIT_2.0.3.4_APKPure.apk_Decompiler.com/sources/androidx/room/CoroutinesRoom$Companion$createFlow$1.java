package androidx.room;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.concurrent.Callable;
import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Oxx0IOOO;
import kotlinx.coroutines.channels.xxIXOIIO;
import kotlinx.coroutines.flow.XO;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;
import kotlinx.coroutines.xoIox;

@oxoX(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$createFlow$1 extends SuspendLambda implements x0xO0oo<XO<R>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    @oxoX(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @OOXIXo
        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
            AnonymousClass1 r0 = new AnonymousClass1(z, roomDatabase, xo2, strArr, callable, i0Io);
            r0.L$0 = obj;
            return r0;
        }

        @oOoXoXO
        public final Object invokeSuspend(@OOXIXo Object obj) {
            CoroutineContext coroutineContext;
            Object oOoXoXO2 = II0xO0.oOoXoXO();
            int i = this.label;
            if (i == 0) {
                I0oOoX.x0XOIxOo(obj);
                xII xii = (xII) this.L$0;
                final Oxx0IOOO oxoX2 = xxIXOIIO.oxoX(-1, (BufferOverflow) null, (Oox.oOoXoXO) null, 6, (Object) null);
                final CoroutinesRoom$Companion$createFlow$1$1$observer$1 coroutinesRoom$Companion$createFlow$1$1$observer$1 = new CoroutinesRoom$Companion$createFlow$1$1$observer$1(strArr, oxoX2);
                oxoX2.x0xO0oo(oXIO0o0XI.f19155oIX0oI);
                TransactionElement transactionElement = (TransactionElement) xii.getCoroutineContext().get(TransactionElement.Key);
                if (transactionElement == null || (coroutineContext = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                    if (z) {
                        coroutineContext = CoroutinesRoomKt.getTransactionDispatcher(roomDatabase);
                    } else {
                        coroutineContext = CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
                    }
                }
                Oxx0IOOO oxoX3 = xxIXOIIO.oxoX(0, (BufferOverflow) null, (Oox.oOoXoXO) null, 7, (Object) null);
                final RoomDatabase roomDatabase = roomDatabase;
                final Callable<R> callable = callable;
                final Oxx0IOOO oxx0IOOO = oxoX3;
                kotlinx.coroutines.oXIO0o0XI unused = xoIox.XO(xii, coroutineContext, (CoroutineStart) null, new x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object>((I0Io<? super AnonymousClass1>) null) {
                    Object L$0;
                    int label;

                    @OOXIXo
                    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public CoroutinesRoom$Companion$createFlow$1(boolean z, RoomDatabase roomDatabase, String[] strArr, Callable<R> callable, I0Io<? super CoroutinesRoom$Companion$createFlow$1> i0Io) {
                            super(2, i0Io);
                            this.$inTransaction = z;
                            this.$db = roomDatabase;
                            this.$tableNames = strArr;
                            this.$callable = callable;
                        }

                        @OOXIXo
                        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
                            CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, i0Io);
                            coroutinesRoom$Companion$createFlow$1.L$0 = obj;
                            return coroutinesRoom$Companion$createFlow$1;
                        }

                        @oOoXoXO
                        public final Object invokeSuspend(@OOXIXo Object obj) {
                            Object oOoXoXO2 = II0xO0.oOoXoXO();
                            int i = this.label;
                            if (i == 0) {
                                I0oOoX.x0XOIxOo(obj);
                                final XO xo2 = (XO) this.L$0;
                                final boolean z = this.$inTransaction;
                                final RoomDatabase roomDatabase = this.$db;
                                final String[] strArr = this.$tableNames;
                                final Callable<R> callable = this.$callable;
                                AnonymousClass1 r3 = new AnonymousClass1((I0Io<? super AnonymousClass1>) null);
                                this.label = 1;
                                if (x0o.Oxx0IOOO(r3, this) == oOoXoXO2) {
                                    return oOoXoXO2;
                                }
                            } else if (i == 1) {
                                I0oOoX.x0XOIxOo(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return oXIO0o0XI.f19155oIX0oI;
                        }

                        @oOoXoXO
                        public final Object invoke(@OOXIXo XO<R> xo2, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
                            return ((CoroutinesRoom$Companion$createFlow$1) create(xo2, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
                        }
                    }
