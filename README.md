![findr-logo](https://i.imgur.com/2JZruHN.png)
# Findr - A photo library application
Findr is a photo library application using Flickr API. Started on March 03, 2022, it offers wide range of image collection that can be filtered through your own search inputs.

## Description
A sample photo library application made for the purpose of showcasing my Android development skills and techniques focusing mainly on clean architecture components together with the tools and approaches which I have been using for multiple projects.

## Technology and techniques used
* MultiModule Clean architecture + MVVM
* Retrofit
* OkHTTP
* Moshi
* ViewBinding
* Coroutines
* Jetpack Navigation
* Dagger Hilt
* DataStore
* Room
* Coil
* Mockito-Kotlin
* Manual pagination

### MultiModule
Used to emphasize loosely coupled design and adds more flexibility and scalability overall

### Clean Architecture
Provides overall orderliness, readability, scalability and maintainability of the code by dividing the it in three major layers
* Presentation layer - This is app module where all features and UI related logics are contained
* Domain layer - This is the domain module where all business logics which are non platform specific codes are placed
* Data layer - This is the data module which is divided into remote and local as well. This contains everything related to local data, platform specific data and API communication.

### Model–view–ViewModel (MVVM)
This design pattern was chosen since the features needed are very reactive. There is another option which is MVI pattern but, since there is not much states to be maintained MVVM will work good in this project.

### Room
This persistence library would work best since the API consumed is design to be very structured.

### DataStore
This was chosen to persist configurations or flat data as it is supports asynchronous API for persistence

### Coil
This image loading library was chosen as it utilizes power of Kotlin very well. And benchmark records say that this is relatively faster than other image loading libraries

### Manual Pagination
Why not Paging Library of Android? Since we are using Clean Architecture, the domain layer is aimed to be flat and separated from any native or platform specific components.
Paging Library has a tight coupling between its adapter, mediator and the paging data persisted which in return has its own way of getting updated internally more coupled with Android native itself