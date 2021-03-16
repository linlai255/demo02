package com.cll.admin.vo;

import java.util.List;

public class Lists<T> {
    private List<T> top;
    private List<T> middle;
    private List<T> bottom;

    public List<T> getTop() {
        return top;
    }

    public void setTop(List<T> top) {
        this.top = top;
    }

    public List<T> getMiddle() {
        return middle;
    }

    public void setMiddle(List<T> middle) {
        this.middle = middle;
    }

    public List<T> getBottom() {
        return bottom;
    }

    public void setBottom(List<T> bottom) {
        this.bottom = bottom;
    }
}
