# Emotion-Analysis-API [![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/DavidPacioianu/Emotion-Analysis-API/master/LICENSE)
Android Wrapper for the Microsoft Project Oxford Emotion API.

#Download

In your gradle file [ ![Download](https://api.bintray.com/packages/davidpacioianu/maven/emotion-analysis-api/images/download.svg) ](https://bintray.com/davidpacioianu/maven/emotion-analysis-api/_latestVersion)
```groovy
compile 'com.pacioianu.david:emotion-analysis-api:1.0.0@aar'
```

#Usage

##Initialisation

First, init EmotionAnalysis in your application
```java
  EmotionRestClient.init(context, <subscription_key>);
```
You can get a free subscription key from https://www.projectoxford.ai/emotion

##Sample

```java
 EmotionRestClient.getInstance().detect(card.getImageUri(), new ResponseCallback() {
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


#Community

Looking for contributors, feel free to fork !

#Dependencies

- Retrofit 2.0 from Square: https://github.com/square/retrofit
- GSON from Google: https://github.com/google/gson

#Developed By

Author: David Pacioianu www.david.pacioianu.com/

#License

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
