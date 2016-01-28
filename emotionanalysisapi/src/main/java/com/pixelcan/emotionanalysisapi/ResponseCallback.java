package com.pixelcan.emotionanalysisapi;

import com.pixelcan.emotionanalysisapi.models.FaceAnalysis;

/**
 * Created by David Pacioianu on 1/12/16.
 */
public interface ResponseCallback {

    void onError(String errorMessage);

    void onSuccess(FaceAnalysis[] response);

}
