package com.univocity.parsers.common;

import com.google.android.gms.fitness.data.WorkoutExercises;

/* loaded from: classes13.dex */
public class DataProcessingException extends TextParsingException {
    private static final long serialVersionUID = 1410975527141918215L;
    private int columnIndex;
    private String columnName;
    private boolean fatal;
    private Object[] row;
    private Object value;

    public DataProcessingException(String str) {
        this(str, -1, null, null);
    }

    private int getExtractedColumnIndex() {
        int i;
        int[] iArr = this.extractedIndexes;
        if (iArr != null && (i = this.columnIndex) < iArr.length && i > -1) {
            return iArr[i];
        }
        return this.columnIndex;
    }

    @Override // com.univocity.parsers.common.TextParsingException
    public final int getColumnIndex() {
        return this.columnIndex;
    }

    public String getColumnName() {
        String str = this.columnName;
        if (str != null) {
            return str;
        }
        String[] headers = getHeaders();
        if (headers != null && getExtractedColumnIndex() != -1 && getExtractedColumnIndex() < headers.length) {
            return headers[getExtractedColumnIndex()];
        }
        return null;
    }

    @Override // com.univocity.parsers.common.TextParsingException, com.univocity.parsers.common.AbstractException
    public String getDetails() {
        return AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(super.getDetails(), WorkoutExercises.ROW, getRow()), "value", getValue()), "columnName", getColumnName()), "columnIndex", Integer.valueOf(getColumnIndex()));
    }

    @Override // com.univocity.parsers.common.TextParsingException, com.univocity.parsers.common.AbstractException
    public String getErrorDescription() {
        return "Error processing parsed input";
    }

    public final Object[] getRow() {
        return this.row;
    }

    public final Object getValue() {
        int i;
        Object obj = this.value;
        if (obj != null) {
            return obj;
        }
        Object[] objArr = this.row;
        if (objArr != null && (i = this.columnIndex) != -1 && i < objArr.length) {
            return objArr[i];
        }
        return null;
    }

    public final boolean isFatal() {
        return this.fatal;
    }

    public final void markAsNonFatal() {
        this.fatal = false;
    }

    public final void setColumnIndex(int i) {
        this.columnIndex = i;
    }

    public final void setColumnName(String str) {
        this.columnName = str;
    }

    public final void setRow(Object[] objArr) {
        this.row = objArr;
    }

    public final void setValue(Object obj) {
        this.value = obj;
    }

    public DataProcessingException(String str, Throwable th) {
        this(str, -1, null, th);
    }

    public DataProcessingException(String str, Object[] objArr) {
        this(str, -1, objArr, null);
    }

    public DataProcessingException(String str, Object[] objArr, Throwable th) {
        this(str, -1, objArr, th);
    }

    public DataProcessingException(String str, int i) {
        this(str, i, null, null);
    }

    public DataProcessingException(String str, int i, Object[] objArr, Throwable th) {
        super(null, str, th);
        this.fatal = true;
        setColumnIndex(i);
        this.row = objArr;
    }
}
