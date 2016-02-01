# Emotion-Analysis-API
 [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Emotion--Analysis--API-green.svg?style=true)](https://android-arsenal.com/details/1/3070)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](http://developer.android.com/index.html) [![API](https://img.shields.io/badge/API-9%2B-brightgreen.svg)](https://android-arsenal.com/api?level=9)
[![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/DavidPacioianu/Emotion-Analysis-API/master/LICENSE)

Android Wrapper for the Microsoft Project Oxford Emotion API.

##Download

In your gradle file [ ![Download](https://api.bintray.com/packages/davidpacioianu/maven/emotion-analysis-api/images/download.svg) ](https://bintray.com/davidpacioianu/maven/emotion-analysis-api/_latestVersion)
```groovy
compile 'com.pacioianu.david:emotion-analysis-api:1.1.0'
```

##Usage

First, init EmotionAnalysis in your application
```java
  EmotionRestClient.init(context, <subscription_key>);
```
You can get a free subscription key from https://www.projectoxford.ai/emotion

Asynchronous:
```java
 EmotionRestClient.getInstance().detect(<your uri/url/bitmap>, new ResponseCallback() {
          @Override
          public void onError(String errorMessage) {
              Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
          }

          @Override
          public void onSuccess(FaceAnalysis[] response) {
              Toast.makeText(context, context.getString(R.string.successfully_analysed), Toast.LENGTH_LONG).show();
          }
      });
```

Synchronous:
```java
 EmotionRestClient.getInstance().detect(<your uri/url/bitmap>);
```

<img src="http://i63.tinypic.com/nzkai9.png" alt="sample" title="sample" width="350" height="610" align="right" vspace="52" />

##Sample

Sample response for https://thenypost.files.wordpress.com/2014/02/trump.jpg
```json
[
  {
    "faceRectangle": {
      "left": 523,
      "top": 293,
      "width": 522,
      "height": 522
    },
    "scores": {
      "anger": 0.231301255,
      "contempt": 0.00228384347,
      "disgust": 0.013675208,
      "fear": 0.0000379959965,
      "happiness": 0.000004979391,
      "neutral": 0.582898065,
      "sadness": 0.1897379,
      "surprise": 0.0000607591355
    }
  }
]
```

##Apps using the Emotion API
(feel free to send me your project)

Icon | Application
------------ | -------------
<img src="https://lh3.googleusercontent.com/Jqkeew5ZWXvMNp9DeelI159XotPZi6oRQ00T5Oz2uvcYtLMRIBKryDK57zvDFPHO0w=w300-rw" width="48" height="48" /> | [Facelyse](https://play.google.com/store/apps/details?id=com.pixelcan.facelyse) <alt="width="40" height="40" />

##Community

Looking for contributors, feel free to fork !

##Dependencies

- Retrofit 2.0 from Square: https://github.com/square/retrofit
- GSON from Google: https://github.com/google/gson

##Developed By

Author: David Pacioianu www.david.pacioianu.com/

##License

    Copyright 2016 David Pacioianu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
