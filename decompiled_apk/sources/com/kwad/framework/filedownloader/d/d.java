package com.kwad.framework.filedownloader.d;

/* loaded from: classes11.dex */
public final class d {
    public static boolean bF(int i) {
        return i < 0;
    }

    public static boolean bG(int i) {
        return i > 0;
    }

    public static boolean f(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.uz() != 0 && aVar.uz() != 3) {
            return false;
        }
        return true;
    }

    public static boolean t(int i, int i2) {
        if ((i != 3 && i != 5 && i == i2) || bF(i)) {
            return false;
        }
        if (i > 0 && i <= 6 && i2 >= 10 && i2 <= 11) {
            return false;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        if (i != 6) {
                            return true;
                        }
                        if (i2 == 0 || i2 == 1) {
                            return false;
                        }
                        return true;
                    }
                    if (i2 == 1 || i2 == 6) {
                        return false;
                    }
                    return true;
                }
                if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) {
                    return false;
                }
                return true;
            }
            if (i2 == 0 || i2 == 1 || i2 == 6) {
                return false;
            }
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        return true;
    }

    public static boolean u(int i, int i2) {
        if ((i != 3 && i != 5 && i == i2) || bF(i)) {
            return false;
        }
        if (i2 == -2 || i2 == -1) {
            return true;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i != 5 && i != 6) {
                        if (i != 10) {
                            if (i != 11) {
                                return false;
                            }
                            if (i2 != -4 && i2 != -3 && i2 != 1) {
                                return false;
                            }
                            return true;
                        }
                        if (i2 != 11) {
                            return false;
                        }
                        return true;
                    }
                    if (i2 != 2 && i2 != 5) {
                        return false;
                    }
                    return true;
                }
                if (i2 != -3 && i2 != 3 && i2 != 5) {
                    return false;
                }
                return true;
            }
            if (i2 != 6) {
                return false;
            }
            return true;
        }
        if (i2 != 10) {
            return false;
        }
        return true;
    }
}
