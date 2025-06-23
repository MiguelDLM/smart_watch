package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.Keep;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Keep
/* loaded from: classes7.dex */
public class Page {
    private int _currentPageIndex;

    @oOoXoXO
    private String asc;

    @oOoXoXO
    private String desc;
    private int firstPageIndex;

    @OOXIXo
    private String keyCurrent;

    @OOXIXo
    private String keySize;
    private int requestPageIndex;
    private int requestPageSize;

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static int PAGE_SIZE = 20;
    private static int FIRST_PAGE_INDEX = 1;

    @OOXIXo
    private static String KEY_CURRENT = "current";

    @OOXIXo
    private static String KEY_SIZE = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String I0Io() {
            return Page.KEY_SIZE;
        }

        public final void II0XooXoX(int i) {
            Page.PAGE_SIZE = i;
        }

        @OOXIXo
        public final String II0xO0() {
            return Page.KEY_CURRENT;
        }

        public final void Oxx0IOOO(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            Page.KEY_SIZE = str;
        }

        public final void X0o0xo(int i) {
            Page.FIRST_PAGE_INDEX = i;
        }

        public final void XO(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            Page.KEY_CURRENT = str;
        }

        public final int oIX0oI() {
            return Page.FIRST_PAGE_INDEX;
        }

        public final int oxoX() {
            return Page.PAGE_SIZE;
        }

        public oIX0oI() {
        }
    }

    public Page() {
        int i = FIRST_PAGE_INDEX;
        this.firstPageIndex = i;
        this._currentPageIndex = i;
        this.requestPageIndex = i;
        this.requestPageSize = PAGE_SIZE;
        this.keyCurrent = KEY_CURRENT;
        this.keySize = KEY_SIZE;
    }

    @oOoXoXO
    public final String getAsc() {
        return this.asc;
    }

    public final int getCurrentEndIndex() {
        return getCurrentStartIndex() + this.requestPageSize;
    }

    public final int getCurrentStartIndex() {
        return (this.requestPageIndex - this.firstPageIndex) * this.requestPageSize;
    }

    @oOoXoXO
    public final String getDesc() {
        return this.desc;
    }

    public final int getFirstPageIndex() {
        return this.firstPageIndex;
    }

    @OOXIXo
    public final String getKeyCurrent() {
        return this.keyCurrent;
    }

    @OOXIXo
    public final String getKeySize() {
        return this.keySize;
    }

    public final int getRequestPageIndex() {
        return this.requestPageIndex;
    }

    public final int getRequestPageSize() {
        return this.requestPageSize;
    }

    public final int get_currentPageIndex() {
        return this._currentPageIndex;
    }

    public boolean isFirstPage() {
        if (this.requestPageIndex == this.firstPageIndex) {
            return true;
        }
        return false;
    }

    public void pageLoadEnd() {
        this._currentPageIndex = this.requestPageIndex;
    }

    public void pageLoadMore() {
        this.requestPageIndex = this._currentPageIndex + 1;
    }

    public void pageRefresh() {
        int i = this.firstPageIndex;
        this._currentPageIndex = i;
        this.requestPageIndex = i;
    }

    public void set(@OOXIXo Page page) {
        IIX0o.x0xO0oo(page, "page");
        setFirstPageIndex(page.firstPageIndex);
        this._currentPageIndex = page._currentPageIndex;
        this.requestPageIndex = page.requestPageIndex;
        this.requestPageSize = page.requestPageSize;
    }

    public final void setAsc(@oOoXoXO String str) {
        this.asc = str;
    }

    public final void setDesc(@oOoXoXO String str) {
        this.desc = str;
    }

    public final void setFirstPageIndex(int i) {
        this.firstPageIndex = i;
        pageRefresh();
    }

    public final void setKeyCurrent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.keyCurrent = str;
    }

    public final void setKeySize(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.keySize = str;
    }

    public final void setRequestPageIndex(int i) {
        this.requestPageIndex = i;
    }

    public final void setRequestPageSize(int i) {
        this.requestPageSize = i;
    }

    public final void set_currentPageIndex(int i) {
        this._currentPageIndex = i;
    }

    public void singlePage() {
        this.requestPageSize = Integer.MAX_VALUE;
    }
}
