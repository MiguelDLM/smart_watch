package com.sma.smartv3.ui.device.model;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.xII;

@oxoX(c = "com.sma.smartv3.ui.device.model.AddDeviceViewModel$onDownload$1$handleResponse$1", f = "AddDeviceViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AddDeviceViewModel$onDownload$1$handleResponse$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ oOoXoXO<Boolean, oXIO0o0XI> $callback;
    final /* synthetic */ String $mFilePath;
    int label;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddDeviceViewModel$onDownload$1$handleResponse$1(AddDeviceViewModel addDeviceViewModel, String str, oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, I0Io<? super AddDeviceViewModel$onDownload$1$handleResponse$1> i0Io) {
        super(2, i0Io);
        this.this$0 = addDeviceViewModel;
        this.$mFilePath = str;
        this.$callback = oooxoxo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        return new AddDeviceViewModel$onDownload$1$handleResponse$1(this.this$0, this.$mFilePath, this.$callback, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            this.label = 1;
            if (DelayKt.II0xO0(50L, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        this.this$0.getFileData(this.$mFilePath, this.$callback);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @OXOo.oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((AddDeviceViewModel$onDownload$1$handleResponse$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
