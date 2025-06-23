package com.github.doyaaaaaken.kotlincsv.client;

import Oox.oOoXoXO;
import kotlin.jvm.internal.xxX;
import kotlin.oO;

/* loaded from: classes9.dex */
public final class II0xO0 {
    public static final <R> R oIX0oI(CsvFileReader csvFileReader, oOoXoXO<? super CsvFileReader, ? extends R> oooxoxo) {
        try {
            R invoke = oooxoxo.invoke(csvFileReader);
            xxX.oxoX(1);
            csvFileReader.oxoX();
            xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                xxX.oxoX(1);
                try {
                    csvFileReader.oxoX();
                } catch (Throwable th3) {
                    oO.oIX0oI(th, th3);
                }
                xxX.I0Io(1);
                throw th2;
            }
        }
    }
}
