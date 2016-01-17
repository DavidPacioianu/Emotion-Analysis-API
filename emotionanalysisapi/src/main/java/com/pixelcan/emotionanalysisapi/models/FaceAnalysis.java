package com.pixelcan.emotionanalysisapi.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FaceAnalysis implements Parcelable {

    private FaceRectangle faceRectangle;
    private Scores scores;

    /**
     * No args constructor for use in serialization
     *
     */
    public FaceAnalysis() {
    }

    /**
     *
     * @param scores
     * @param faceRectangle
     */
    public FaceAnalysis(FaceRectangle faceRectangle, Scores scores) {
        this.faceRectangle = faceRectangle;
        this.scores = scores;
    }

    /**
     *
     * @return
     *     The faceRectangle
     */
    public FaceRectangle getFaceRectangle() {
        return faceRectangle;
    }

    /**
     *
     * @param faceRectangle
     *     The faceRectangle
     */
    public void setFaceRectangle(FaceRectangle faceRectangle) {
        this.faceRectangle = faceRectangle;
    }

    /**
     *
     * @return
     *     The scores
     */
    public Scores getScores() {
        return scores;
    }

    /**
     *
     * @param scores
     *     The scores
     */
    public void setScores(Scores scores) {
        this.scores = scores;
    }


    public FaceAnalysis(Parcel in) {
        faceRectangle = (FaceRectangle) in.readValue(FaceRectangle.class.getClassLoader());
        scores = (Scores) in.readValue(Scores.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(faceRectangle);
        dest.writeValue(scores);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FaceAnalysis> CREATOR = new Parcelable.Creator<FaceAnalysis>() {
        @Override
        public FaceAnalysis createFromParcel(Parcel in) {
            return new FaceAnalysis(in);
        }

        @Override
        public FaceAnalysis[] newArray(int size) {
            return new FaceAnalysis[size];
        }
    };
}