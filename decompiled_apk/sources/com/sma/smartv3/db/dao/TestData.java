package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.Electrocardiogram;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Weight;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class TestData {

    @OOXIXo
    public static final TestData INSTANCE = new TestData();

    @OOXIXo
    private static final List<HeartRate> testHeartRates = new ArrayList();

    @OOXIXo
    private static final List<Pressure> testPressures = new ArrayList();

    @OOXIXo
    private static final List<BloodPressure> testBloodPressures = new ArrayList();

    @OOXIXo
    private static List<Sleep> testSleeps = new ArrayList();

    @OOXIXo
    private static List<Weight> testWeights = new ArrayList();

    @OOXIXo
    private static final List<Electrocardiogram> testElectrocardiograms = new ArrayList();

    private TestData() {
    }

    @OOXIXo
    public final List<BloodPressure> getTestBloodPressures() {
        return testBloodPressures;
    }

    @OOXIXo
    public final List<Electrocardiogram> getTestElectrocardiograms() {
        return testElectrocardiograms;
    }

    @OOXIXo
    public final List<HeartRate> getTestHeartRates() {
        return testHeartRates;
    }

    @OOXIXo
    public final List<Pressure> getTestPressures() {
        return testPressures;
    }

    @OOXIXo
    public final List<Sleep> getTestSleeps() {
        return testSleeps;
    }

    @OOXIXo
    public final List<Weight> getTestWeights() {
        return testWeights;
    }

    public final void setTestSleeps(@OOXIXo List<Sleep> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        testSleeps = list;
    }

    public final void setTestWeights(@OOXIXo List<Weight> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        testWeights = list;
    }
}
