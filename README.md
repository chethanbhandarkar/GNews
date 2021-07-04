# GNews : Google News 📰
## GNews : Locate articles and breaking news headlines from news
News Api :The main use of News API is to search through every article published by over 80,000 news sources and blogs in the last 3 years. Think of us as Google News that you can interact with programmatically!
https://newsapi.org/

News API has 2 main endpoints:

Everything /v2/everything – search every article published by over 80,000 different sources large and small in the last 3 years. This endpoint is ideal for news analysis and article discovery.

Top headlines /v2/top-headlines – returns breaking news headlines for countries, categories, and singular publishers. This is perfect for use with news tickers or anywhere you want to use live up-to-date news headlines.
													
## Keywords:
														
## Kotlin - Android - MVVM - Retrofit - Navigation - Pagination 3 - Coroutines - Dagger-Hilt- Lifecycle - Glide - Lottie - JUnit - Binding - Google Truth

## Light and Dark Theme
<p float="left">
  <img src="https://user-images.githubusercontent.com/34742621/124395700-20463d00-dd23-11eb-853c-3a2d24af319c.jpg" width="185" />
	
  <img src="https://user-images.githubusercontent.com/34742621/124395379-731ef500-dd21-11eb-8557-fcb3d4e1865f.jpg"  width="185" /> 
	<img src="https://user-images.githubusercontent.com/34742621/124394816-a8761380-dd1e-11eb-855d-5b9b3f352d64.jpg"" width="185" /> 
		<img src="https://user-images.githubusercontent.com/34742621/124395489-035d3a00-dd22-11eb-880f-ed2693cc325b.jpg" width="185" /> 
	<img src="https://user-images.githubusercontent.com/34742621/124395500-1cfe8180-dd22-11eb-912a-ed2e2bb414be.jpg" width="185" /> 
	<img src="https://user-images.githubusercontent.com/34742621/124395808-e3c71100-dd23-11eb-9090-9c79d4977472.jpg" width="185" /> 
	<img src="https://user-images.githubusercontent.com/34742621/124395790-ba0dea00-dd23-11eb-9e3b-c643b2f8ceb4.jpg" width="185" /> 
 
<img src="https://user-images.githubusercontent.com/34742621/124395833-02c5a300-dd24-11eb-817f-f737897484af.jpg" width="185" />

</p>

																						
## If you want to run
	       
- Go to NewsAPI and generate an API key (It's only 2 steps!) https://newsapi.org/
- Put the API key at the bottom of the gradle.properties news_org_access_key = "YOUR_API_KEY"
- Run the app

											     
## App Architecture MVVM
											     
<img src="https://static.packt-cdn.com/products/9781788995511/graphics/0c998f26-d448-48a5-9d84-d629d4f77ba6.png"/> 
														

## Pagination 3
														
<img src="https://3.bp.blogspot.com/-WDij3mAUZEo/XxXYliprwbI/AAAAAAAAPRY/EaHnaoH0S60ydry-Q7ZPpw1L5FuPG_cnACLcBGAsYHQ/s1600/Screenshot%2B2020-07-01%2Bat%2B13.41.47.png"/> 

														
## Libraries:
														
  def version_lifecycle = "2.3.1"
    def version_coroutine = "1.5.0"
    def version_core = "1.5.0"
    def version_retrofit = "2.9.0"
    def version_paging="3.0.0"
    def version_glide="4.12.0"
    def version_navigation="2.3.5"


    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.5.0'
    implementation 'androidx.appcompat:appcompat:1.3.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'

    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'


    implementation 'androidx.fragment:fragment-ktx:1.3.2'

    // Android KTX
    implementation "androidx.core:core-ktx:$version_core"
    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version_coroutine"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version_coroutine"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$version_lifecycle")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$version_lifecycle")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$version_lifecycle")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$version_lifecycle")

    //retrofit
    implementation "com.squareup.retrofit2:retrofit:$version_retrofit"
    implementation "com.squareup.retrofit2:converter-gson:$version_retrofit"


    //Pager3
    implementation("androidx.paging:paging-runtime-ktx:$version_paging")
    testImplementation("androidx.paging:paging-common-ktx:$version_paging")

    // When using Kotlin.
    implementation "com.google.dagger:hilt-android:2.30.1-alpha"
    kapt "com.google.dagger:hilt-android-compiler:2.30.1-alpha"
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02'
    // When using Kotlin.
    kapt 'androidx.hilt:hilt-compiler:1.0.0-alpha02'

    //coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version_coroutine"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version_coroutine"

    implementation "com.github.bumptech.glide:glide:$version_glide"
    annotationProcessor "com.github.bumptech.glide:compiler:$version_glide"

    //navigation

    // Kotlin
    implementation "androidx.navigation:navigation-fragment-ktx:$version_navigation"
    implementation "androidx.navigation:navigation-ui-ktx:$version_navigation"

    // Feature module Support
    implementation "androidx.navigation:navigation-dynamic-features-fragment:$version_navigation"

    // Testing Navigation
    androidTestImplementation "androidx.navigation:navigation-testing:$version_navigation"

    def lottieVersion = "3.4.4"
    implementation "com.airbnb.android:lottie:$lottieVersion"



  //TESTING




    // Local Unit Tests
    implementation "androidx.test:core:1.2.0"
    testImplementation "junit:junit:4.13"
    testImplementation "org.hamcrest:hamcrest-all:1.3"
    testImplementation "androidx.arch.core:core-testing:2.1.0"
    testImplementation "org.robolectric:robolectric:4.3.1"
    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1"
    testImplementation "com.google.truth:truth:1.0.1"
    testImplementation "org.mockito:mockito-core:2.21.0"

    // Instrumented Unit Tests
    androidTestImplementation "junit:junit:4.13"
    androidTestImplementation "com.linkedin.dexmaker:dexmaker-mockito:2.12.1"
    androidTestImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1"
    androidTestImplementation "androidx.arch.core:core-testing:2.1.0"
    androidTestImplementation "com.google.truth:truth:1.0.1"
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    androidTestImplementation "org.mockito:mockito-core:2.21.0"


														
## Requirements:
													
Minimum API - 26
																																																															
																																																															
																																																															
																																																															
