package com.pixelcan.emotionanalysisapi.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Scores implements Parcelable {

    private double anger;
    private double contempt;
    private double disgust;
    private double fear;
    private double happiness;
    private double neutral;
    private double sadness;
    private double surprise;

    /**
     * No args constructor for use in serialization
     *
     */
    public Scores() {
    }

    /**
     *
     * @param disgust
     * @param sadness
     * @param contempt
     * @param anger
     * @param happiness
     * @param neutral
     * @param surprise
     * @param fear
     */
    public Scores(double anger, double contempt, double disgust, double fear, double happiness, double neutral, double sadness, double surprise) {
        this.anger = anger;
        this.contempt = contempt;
        this.disgust = disgust;
        this.fear = fear;
        this.happiness = happiness;
        this.neutral = neutral;
        this.sadness = sadness;
        this.surprise = surprise;
    }

    /**
     *
     * @return
     *     The anger
     */
    public double getAnger() {
        return anger;
    }

    /**
     *
     * @param anger
     *     The anger
     */
    public void setAnger(double anger) {
        this.anger = anger;
    }

    /**
     *
     * @return
     *     The contempt
     */
    public double getContempt() {
        return contempt;
    }

    /**
     *
     * @param contempt
     *     The contempt
     */
    public void setContempt(double contempt) {
        this.contempt = contempt;
    }

    /**
     *
     * @return
     *     The disgust
     */
    public double getDisgust() {
        return disgust;
    }

    /**
     *
     * @param disgust
     *     The disgust
     */
    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    /**
     *
     * @return
     *     The fear
     */
    public double getFear() {
        return fear;
    }

    /**
     *
     * @param fear
     *     The fear
     */
    public void setFear(double fear) {
        this.fear = fear;
    }

    /**
     *
     * @return
     *     The happiness
     */
    public double getHappiness() {
        return happiness;
    }

    /**
     *
     * @param happiness
     *     The happiness
     */
    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    /**
     *
     * @return
     *     The neutral
     */
    public double getNeutral() {
        return neutral;
    }

    /**
     *
     * @param neutral
     *     The neutral
     */
    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }

    /**
     *
     * @return
     *     The sadness
     */
    public double getSadness() {
        return sadness;
    }

    /**
     *
     * @param sadness
     *     The sadness
     */
    public void setSadness(double sadness) {
        this.sadness = sadness;
    }

    /**
     *
     * @return
     *     The surprise
     */
    public double getSurprise() {
        return surprise;
    }

    /**
     *
     * @param surprise
     *     The surprise
     */
    public void setSurprise(double surprise) {
        this.surprise = surprise;
    }


    public Scores(Parcel in) {
        anger = in.readDouble();
        contempt = in.readDouble();
        disgust = in.readDouble();
        fear = in.readDouble();
        happiness = in.readDouble();
        neutral = in.readDouble();
        sadness = in.readDouble();
        surprise = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(anger);
        dest.writeDouble(contempt);
        dest.writeDouble(disgust);
        dest.writeDouble(fear);
        dest.writeDouble(happiness);
        dest.writeDouble(neutral);
        dest.writeDouble(sadness);
        dest.writeDouble(surprise);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Scores> CREATOR = new Parcelable.Creator<Scores>() {
        @Override
        public Scores createFromParcel(Parcel in) {
            return new Scores(in);
        }

        @Override
        public Scores[] newArray(int size) {
            return new Scores[size];
        }
    };
}
