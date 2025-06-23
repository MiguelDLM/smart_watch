package androidx.constraintlayout.core;

import java.util.ArrayList;

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
        this.measures = 0;
        this.widgets = 0;
        this.additionalMeasures = 0;
        this.resolutions = 0;
        this.tableSizeIncrease = 0;
        this.maxTableSize = 0;
        this.lastTableSize = 0;
        this.maxVariables = 0;
        this.maxRows = 0;
        this.minimize = 0;
        this.minimizeGoal = 0;
        this.constraints = 0;
        this.simpleconstraints = 0;
        this.optimize = 0;
        this.iterations = 0;
        this.pivots = 0;
        this.bfs = 0;
        this.variables = 0;
        this.errors = 0;
        this.slackvariables = 0;
        this.extravariables = 0;
        this.fullySolved = 0;
        this.graphOptimizer = 0;
        this.graphSolved = 0;
        this.resolvedWidgets = 0;
        this.nonresolvedWidgets = 0;
        this.linearSolved = 0;
        this.problematicLayouts.clear();
        this.mNumberOfMeasures = 0;
        this.mNumberOfLayouts = 0;
        this.measuresWidgetsDuration = 0;
        this.measuresLayoutDuration = 0;
        this.mChildCount = 0;
        this.mMeasureDuration = 0;
        this.mMeasureCalls = 0;
        this.mSolverPasses = 0;
        this.mVariables = 0;
        this.mEquations = 0;
        this.mSimpleEquations = 0;
    }

    public String toString() {
        return "\n*** Metrics ***\nmeasures: " + this.measures + "\nmeasuresWrap: " + this.measuresWrap + "\nmeasuresWrapInfeasible: " + this.measuresWrapInfeasible + "\ndetermineGroups: " + this.determineGroups + "\ninfeasibleDetermineGroups: " + this.infeasibleDetermineGroups + "\ngraphOptimizer: " + this.graphOptimizer + "\nwidgets: " + this.widgets + "\ngraphSolved: " + this.graphSolved + "\nlinearSolved: " + this.linearSolved + "\n";
    }
}
