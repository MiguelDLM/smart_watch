package androidx.constraintlayout.core.widgets;

/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.x;
        if (i >= i4 && i < i4 + this.width && i2 >= (i3 = this.y) && i2 < i3 + this.height) {
            return true;
        }
        return false;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    public void grow(int i, int i2) {
        this.x -= i;
        this.y -= i2;
        this.width += i * 2;
        this.height += i2 * 2;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.x;
        int i4 = rectangle.x;
        if (i3 >= i4 && i3 < i4 + rectangle.width && (i = this.y) >= (i2 = rectangle.y) && i < i2 + rectangle.height) {
            return true;
        }
        return false;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }
}
