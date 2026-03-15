package com.example.dialsender.ble;

import org.junit.Test;
import static org.junit.Assert.*;

public class SleepAnalyzerTest {

    // Build a record string: "ts:mode:soft:strong"
    private String rec(int ts, int mode) {
        return ts + ":" + mode + ":0:0";
    }

    @Test
    public void testBasicSession() {
        // START at t=0, END at t=3600 (1 hour)
        // Deep phase: t=100 to t=1900 (30 min deep)
        // Light phase: t=1900 to t=3600 (28 min light)
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(100, BleSleep.MODE_DEEP) + ","
                + rec(1900, BleSleep.MODE_LIGHT) + ","
                + rec(3600, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(60, r.totalMinutes); // 3600s = 60min
        assertEquals(30, r.deepMin);      // 1800s = 30min
        assertEquals(28, r.lightMin);     // 1700s ≈ 28min
    }

    @Test
    public void testEmptyData() {
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze("");
        assertEquals(0, r.totalMinutes);
    }

    @Test
    public void testNullData() {
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(null);
        assertEquals(0, r.totalMinutes);
    }

    @Test
    public void testPiecemealCountsAsLight() {
        // START at t=0, PIECEMEAL starts at t=60 (non-zero to avoid ambiguity), END at t=660
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(60, BleSleep.MODE_PIECEMEAL) + ","   // 600s piecemeal (t=60 to t=660)
                + rec(660, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(11, r.totalMinutes); // 660s = 11min total
        assertEquals(10, r.lightMin);     // piecemeal (600s = 10min) maps to light
    }

    @Test
    public void testRemPhase() {
        // REM starts at t=60 (non-zero) to avoid ordering ambiguity with MODE_START
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(60, BleSleep.MODE_REM) + ","
                + rec(1200, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(20, r.totalMinutes);  // (1200-0)/60 = 20
        assertEquals(19, r.remMin);        // (1200-60)/60 = 19
    }

    @Test
    public void testLastSessionWins() {
        // Two sessions — only the last one should be returned
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(3600, BleSleep.MODE_END) + ","
                + rec(7200, BleSleep.MODE_START) + ","
                + rec(9000, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(30, r.totalMinutes); // 9000-7200=1800s=30min
    }

    @Test
    public void testSessionWithNoPhasesShowsZeroPhases() {
        // Valid session but no phase records between start and end
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(1800, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(30, r.totalMinutes); // 1800s = 30min
        assertEquals(0, r.deepMin);
        assertEquals(0, r.lightMin);
        assertEquals(0, r.remMin);
    }
}
