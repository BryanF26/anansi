### Content on Making Network Calls with HTTP Using Retrofit

Retrofit is a popular and easy-to-use type-safe HTTP client for Android and Java. It simplifies the process of making network requests and handling responses. Retrofit is built on top of OkHttp and converts your HTTP API into a Java interface.

#### **1. What is Retrofit?**
Retrofit is a type-safe REST client for Android. It allows you to define your API endpoints as interfaces and handle all network requests and responses with minimal boilerplate code.

- Converts HTTP API calls into Java/Kotlin methods.
- Automatically handles JSON/XML parsing.
- Supports synchronous and asynchronous requests.
- Built-in error handling.
- Integrates easily with other libraries like Gson, Moshi for parsing, and RxJava or Kotlin Coroutines for asynchronous programming.

#### **2. Setting Up Retrofit**

1. **Add Retrofit Dependencies**:
   To use Retrofit, first, add the following dependencies to your `build.gradle` file:
   ```groovy
   implementation 'com.squareup.retrofit2:retrofit:2.9.0'
   implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
   ```

   - **Retrofit**: The main library for making network requests.
   - **Gson Converter**: Converts JSON data to Java/Kotlin objects.

2. **Define the Base URL**:
   Every Retrofit instance needs a base URL. This is the root URL where all API requests will be sent.
   ```kotlin
   val retrofit = Retrofit.Builder()
       .baseUrl("https://api.example.com/")
       .addConverterFactory(GsonConverterFactory.create()) // To convert JSON
       .build()
   ```

#### **3. Defining API Endpoints**

With Retrofit, API endpoints are defined as interfaces. Each method in the interface corresponds to an API call.

Example of defining an interface for network calls:
```kotlin
interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    @POST("login")
    @FormUrlEncoded
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}
```

**Annotations:**
- `@GET`: Defines an HTTP GET request.
- `@POST`: Defines an HTTP POST request.
- `@FormUrlEncoded`: Indicates that the request body will be sent as form data.
- `@Field`: Denotes parameters sent in the body of a POST request.
  
#### **4. Making HTTP Calls**

1. **Synchronous Calls**:
   Synchronous calls block the main thread until the request completes, so it is not ideal for network requests in Android.

   Example:
   ```kotlin
   val call = retrofit.create(ApiService::class.java).getUsers()
   val response = call.execute() // Blocks the thread
   if (response.isSuccessful) {
       val users = response.body()
   }
   ```

2. **Asynchronous Calls**:
   Asynchronous calls allow the app to remain responsive while the request is being processed. Retrofit automatically runs network calls in the background.

   Example:
   ```kotlin
   val call = retrofit.create(ApiService::class.java).getUsers()
   call.enqueue(object : Callback<List<User>> {
       override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
           if (response.isSuccessful) {
               val users = response.body()
               // Handle the data
           }
       }

       override fun onFailure(call: Call<List<User>>, t: Throwable) {
           // Handle the error
       }
   })
   ```

#### **5. Handling Responses**

Retrofit automatically converts the JSON response into Java/Kotlin objects using Gson (or another converter). You need to create data models that match the structure of the API response.

Example of a data class for parsing the response:
```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)

data class LoginResponse(
    val token: String,
    val message: String
)
```

- Retrofit will automatically map the JSON response to the corresponding data class.

#### **6. Sending Parameters**

1. **Query Parameters**:
   Use `@Query` to append query parameters to the URL.
   ```kotlin
   @GET("users")
   fun getUsers(@Query("page") page: Int): Call<List<User>>
   ```

2. **Path Parameters**:
   Use `@Path` to replace parts of the URL with parameters.
   ```kotlin
   @GET("users/{id}")
   fun getUserById(@Path("id") userId: Int): Call<User>
   ```

3. **Body Parameters (POST Requests)**:
   Use `@Body` to send complex data as JSON in a POST request.
   ```kotlin
   @POST("users")
   fun createUser(@Body user: User): Call<User>
   ```

#### **7. Error Handling**

Retrofit provides robust error handling by delivering HTTP error responses as part of the `onFailure()` method of the `Callback` interface.

Example of handling errors:
```kotlin
override fun onFailure(call: Call<List<User>>, t: Throwable) {
    Log.e("Network Error", "Error: ${t.message}")
}
```

You can also inspect the HTTP status code in the `onResponse()` method:
```kotlin
if (!response.isSuccessful) {
    Log.e("Error", "Server responded with: ${response.code()}")
}
```

#### **8. Making Secure Requests (Headers and Authentication)**

1. **Adding Headers**:
   You can use the `@Header` annotation to pass custom headers to your request.
   ```kotlin
   @GET("users")
   fun getUsers(@Header("Authorization") token: String): Call<List<User>>
   ```

2. **Adding Interceptors**:
   Interceptors allow you to automatically add headers or manipulate the request before it is sent.

   Example of adding an interceptor:
   ```kotlin
   val okHttpClient = OkHttpClient.Builder()
       .addInterceptor { chain ->
           val request = chain.request().newBuilder()
               .addHeader("Authorization", "Bearer your_token")
               .build()
           chain.proceed(request)
       }
       .build()

   val retrofit = Retrofit.Builder()
       .baseUrl("https://api.example.com/")
       .client(okHttpClient)
       .addConverterFactory(GsonConverterFactory.create())
       .build()
   ```

#### **9. Retrofit with Kotlin Coroutines (Advanced)**

Retrofit integrates easily with Kotlin Coroutines, allowing you to make network requests without callbacks.

1. **Add Coroutine Dependency**:
   ```groovy
   implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0'
   implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0'
   ```

2. **Use `suspend` Functions**:
   Define Retrofit methods as `suspend` functions to use with coroutines.
   ```kotlin
   interface ApiService {
       @GET("users")
       suspend fun getUsers(): List<User>
   }
   ```

3. **Calling the API with Coroutines**:
   Use coroutines to call the API without blocking the main thread.
   ```kotlin
   GlobalScope.launch(Dispatchers.IO) {
       val users = retrofit.create(ApiService::class.java).getUsers()
       withContext(Dispatchers.Main) {
           // Update UI with the response
       }
   }
   ```

---

### **Summary of Retrofit:**
- Retrofit makes HTTP requests simple and efficient in Android by converting APIs into Java/Kotlin interfaces.
- It handles JSON parsing automatically with the help of Gson or other converters.
- It supports both synchronous and asynchronous requests, with built-in error handling.
- Retrofit can be integrated with other libraries such as OkHttp, RxJava, and Kotlin Coroutines for advanced functionality.

