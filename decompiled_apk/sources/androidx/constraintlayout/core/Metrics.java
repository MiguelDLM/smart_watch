package androidx.constraintlayout.core;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class Metrics {
    public long additionalMeasures;
    public long bfs;
    public long constraints;
    public long determineGroups;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long graphSolved;
    public long grouping;
    public long infeasibleDetermineGroups;
    public long iterations;
    public long lastTableSize;
    public long layouts;
    public long linearSolved;
    public long mChildCount;
    public long mEquations;
    public long mMeasureCalls;
    public long mMeasureDuration;
    public int mNumberOfLayouts;
    public int mNumberOfMeasures;
    public long mSimpleEquations;
    public long mSolverPasses;
    public long mVariables;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measuredMatchWidgets;
    public long measuredWidgets;
    public long measures;
    public long measuresLayoutDuration;
    public long measuresWidgetsDuration;
    public long measuresWrap;
    public long measuresWrapInfeasible;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts = new ArrayList<>();
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;
    public long widgets;

    public void copy(Metrics metrics) {
        this.mVariables = metrics.mVariables;
        this.mEquations = metrics.mEquations;
        this.mSimpleEquations = metrics.mSimpleEquations;
        this.mNumberOfMeasures = metrics.mNumberOfMeasures;
        this.mNumberOfLayouts = metrics.mNumberOfLayouts;
        this.mMeasureDuration = metrics.mMeasureDuration;
        this.mChildCount = metrics.mChildCount;
        this.mMeasureCalls = metrics.mMeasureCalls;
        this.measuresWidgetsDuration = metrics.measuresWidgetsDuration;
        this.mSolverPasses = metrics.mSolverPasses;
        this.measuresLayoutDuration = metrics.measuresLayoutDuration;
        this.measures = metrics.measures;
        this.widgets = metrics.widgets;
        this.additionalMeasures = metrics.additionalMeasures;
        this.resolutions = metrics.resolutions;
        this.tableSizeIncrease = metrics.tableSizeIncrease;
        this.maxTableSize = metrics.maxTableSize;
        this.lastTableSize = metrics.lastTableSize;
        this.maxVariables = metrics.maxVariables;
        this.maxRows = metrics.maxRows;
        this.minimize = metrics.minimize;
        this.minimizeGoal = metrics.minimizeGoal;
        this.constraints = metrics.constraints;
        this.simpleconstraints = metrics.simpleconstraints;
        this.optimize = metrics.optimize;
        this.iterations = metrics.iterations;
        this.pivots = metrics.pivots;
        this.bfs = metrics.bfs;
        this.variables = metrics.variables;
        this.errors = metrics.errors;
        this.slackvariables = metrics.slackvariables;
        this.extravariables = metrics.extravariables;
        this.fullySolved = metrics.fullySolved;
        this.graphOptimizer = metrics.graphOptimizer;
        this.graphSolved = metrics.graphSolved;
        this.resolvedWidgets = metrics.resolvedWidgets;
        this.nonresolvedWidgets = metrics.nonresolvedWidgets;
    }

    public void reset() {
        this.measures = 0L;
        this.widgets = 0L;
        this.additionalMeasures = 0L;
        this.resolutions = 0L;
        this.tableSizeIncrease = 0L;
        this.maxTableSize = 0L;
        this.lastTableSize = 0L;
        this.maxVariables = 0L;
        this.maxRows = 0L;
        this.minimize = 0L;
        this.minimizeGoal = 0L;
        this.constraints = 0L;
        this.simpleconstraints = 0L;
        this.optimize = 0L;
        this.iterations = 0L;
        this.pivots = 0L;
        this.bfs = 0L;
        this.variables = 0L;
        this.errors = 0L;
        this.slackvariables = 0L;
        this.extravariables = 0L;
        this.fullySolved = 0L;
        this.graphOptimizer = 0L;
        this.graphSolved = 0L;
        this.resolvedWidgets = 0L;
        this.nonresolvedWidgets = 0L;
        this.linearSolved = 0L;
        this.problematicLayouts.clear();
        this.mNumberOfMeasures = 0;
        this.mNumberOfLayouts = 0;
        this.measuresWidgetsDuration = 0L;
        this.measuresLayoutDuration = 0L;
        this.mChildCount = 0L;
        this.mMeasureDuration = 0L;
        this.mMeasureCalls = 0L;
        this.mSolverPasses = 0L;
        this.mVariables = 0L;
        this.mEquations = 0L;
        this.mSimpleEquations = 0L;
    }

    public String toString() {
        return "\n*** Metrics ***\nmeasures: " + this.measures + "\nmeasuresWrap: " + this.measuresWrap + "\nmeasuresWrapInfeasible: " + this.measuresWrapInfeasible + "\ndetermineGroups: " + this.determineGroups + "\ninfeasibleDetermineGroups: " + this.infeasibleDetermineGroups + "\ngraphOptimizer: " + this.graphOptimizer + "\nwidgets: " + this.widgets + "\ngraphSolved: " + this.graphSolved + "\nlinearSolved: " + this.linearSolved + "\n";
    }
}
