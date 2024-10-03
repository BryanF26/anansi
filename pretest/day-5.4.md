### Test on Making Network Calls with HTTP using Retrofit

#### **Optional Questions:**

1. What is Retrofit used for in Android?
   - a) Data storage
   - b) HTTP calls
   - c) UI updates
   - d) Bluetooth communication
   - e) None of the above

2. Which HTTP method is used to send data to a server?
   - a) GET
   - b) POST
   - c) DELETE
   - d) PATCH
   - e) None of the above

3. What is the return type of Retrofit’s API calls?
   - a) JSON
   - b) Call object
   - c) Response object
   - d) String
   - e) None of the above

4. How do you define a base URL in Retrofit?
   - a) `setBaseURL()`
   - b) `withURL()`
   - c) `baseURL()`
   - d) `@BaseURL`
   - e) None of the above

5. Which library is often used with Retrofit for parsing JSON responses?
   - a) Moshi
   - b) SQLite
   - c) OkHttp
   - d) Volley
   - e) None of the above

---

#### **True/False Questions:**

1. Retrofit supports both synchronous and asynchronous API requests. 
2. Retrofit cannot handle different HTTP methods like GET, POST, PUT, and DELETE. 
3. Retrofit can convert JSON responses into Java/Kotlin objects automatically. 
4. Retrofit automatically retries failed network requests. 
5. The `@GET` annotation in Retrofit is used for sending data to a server. 

---

#### **Short Answer Questions:**

1. What is the purpose of using `GsonConverterFactory` in Retrofit?
2. How do you make an asynchronous network call with Retrofit?
3. What is the difference between synchronous and asynchronous API calls in Retrofit?
4. How do you pass query parameters to a Retrofit API method?
5. Explain how error handling works in Retrofit when a network request fails.

---

#### **Code Fix Questions:**

1. **Incorrect code:**
   ```kotlin
   @GET("users")
   fun getUsers(): Call<List<User>> {
       return retrofit.execute()
   }
   ```
   **Fix the code to correctly make the network request.**

2. **Incorrect code:**
   ```kotlin
   @POST("login")
   fun loginUser(@Body credentials: Map<String, String>): Call<LoginResponse>
   val response = loginUser("username", "password")
   ```
   **Fix the code to properly pass the parameters to the POST request.**

3. **Incorrect code:**
   ```kotlin
   @GET("user/{id}")
   fun getUserById(@Path("id") userId: Int): Call<User>
   getUserById(123).execute()
   ```
   **Fix the code to correctly fetch the user with the given ID asynchronously.**

---

### Project: Making a Network Call with Retrofit

#### **Project: Create a Simple App that Fetches User Data from an API**

**Task:**
- Build an app that makes an HTTP GET request to a public API using Retrofit and displays the fetched user data in a `RecyclerView`.

**Instructions:**

1. **Set up Retrofit:**
   - Add Retrofit and Gson dependencies in the `build.gradle` file.
   - Define the base URL for the API (GET `https://reqres.in/api/users?page=2`).
   - Create an `ApiService` interface with a method to fetch user data using a GET request.

2. **Create the Data Model:**
   - Define a data class `User` that represents the JSON structure of the user data (e.g., `id`, `first_name`, `last_name`, `email`).

3. **Implement the Retrofit Request:**
   - Set up Retrofit in your `MainActivity`.
   - Use `enqueue()` to make an asynchronous API call to fetch the user data.
   - Handle the response and any errors that occur during the network request.

4. **Display Data in a RecyclerView:**
   - Create a `RecyclerView` in the activity’s layout file.
   - Set up an adapter to bind the list of users to the `RecyclerView`.
   - When the API response is received, update the adapter with the fetched user data.

5. **Handle Error Cases:**
   - Display a `Toast` or an error message if the network call fails.
   - Handle any HTTP errors (e.g., 404 or 500) gracefully in the app.

**Bonus:**
- Add a search functionality where the user can search for a specific user by name, and the list updates dynamically.

**Expected Outcome:**
- The app should make a successful network request to fetch user data and display it in a `RecyclerView`.
- In case of any errors (e.g., no internet connection), appropriate error messages should be displayed.

