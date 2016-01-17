package com.pixelcan.emotionanalysisapi.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FaceRectangle implements Parcelable {

    private int left;
    private int top;
    private int width;
    private int height;

    /**
     * No args constructor for use in serialization
     *
     */
    public FaceRectangle() {
    }

    /**
     *
     * @param height
     * @param width
     * @param left
     * @param top
     */
    public FaceRectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @return
     *     The left
     */
    public int getLeft() {
        return left;
    }

    /**
     *
     * @param left
     *     The left
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     *
     * @return
     *     The top
     */
    public int getTop() {
        return top;
    }

    /**
     *
     * @param top
     *     The top
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     *
     * @return
     *     The width
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     *     The width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     *     The height
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     *     The height
     */
    public void setHeight(int height) {
        this.height = height;
    }


    public FaceRectangle(Parcel in) {
        left = in.readInt();
        top = in.readInt();
        width = in.readInt();
        height = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(left);
        dest.writeInt(top);
        dest.writeInt(width);
        dest.writeInt(height);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FaceRectangle> CREATOR = new Parcelable.Creator<FaceRectangle>() {
        @Override
        public FaceRectangle createFromParcel(Parcel in) {
            return new FaceRectangle(in);
        }

        @Override
        public FaceRectangle[] newArray(int size) {
            return new FaceRectangle[size];
        }
    };
}
