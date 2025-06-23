package com.tenmeter.smlibrary.entity;

import java.io.Serializable;

/* loaded from: classes13.dex */
public class SMGameSensor implements Serializable {
    private static final long serialVersionUID = -3677634784241553837L;
    int Count_Throw;
    int Speed;
    int X_Gravity;
    int X_Throw;
    int Y_Gravity;
    int Y_Throw;
    int Z_Gravity;
    int x;
    int y;

    public SMGameSensor(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.x = i;
        this.y = i2;
        this.Speed = i3;
        this.X_Throw = i4;
        this.Y_Throw = i5;
        this.Z_Gravity = i6;
        this.Count_Throw = i7;
        this.X_Gravity = i8;
        this.Y_Gravity = i9;
    }

    public int getCount_Throw() {
        return this.Count_Throw;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public int getX() {
        return this.x;
    }

    public int getX_Gravity() {
        return this.X_Gravity;
    }

    public int getX_Throw() {
        return this.X_Throw;
    }

    public int getY() {
        return this.y;
    }

    public int getY_Gravity() {
        return this.Y_Gravity;
    }

    public int getY_Throw() {
        return this.Y_Throw;
    }

    public int getZ_Gravity() {
        return this.Z_Gravity;
    }

    public void setCount_Throw(int i) {
        this.Count_Throw = i;
    }

    public void setSpeed(int i) {
        this.Speed = i;
    }

    public void setX(int i) {
        this.x = i;
    }

    public void setX_Gravity(int i) {
        this.X_Gravity = i;
    }

    public void setX_Throw(int i) {
        this.X_Throw = i;
    }

    public void setY(int i) {
        this.y = i;
    }

    public void setY_Gravity(int i) {
        this.Y_Gravity = i;
    }

    public void setY_Throw(int i) {
        this.Y_Throw = i;
    }

    public void setZ_Gravity(int i) {
        this.Z_Gravity = i;
    }
}
