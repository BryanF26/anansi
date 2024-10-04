### **YahNgantorLagi - Detailed Requirements and Tasks**

### **Project Overview:**
This app is designed to simplify employee attendance management. It features a summary of attendance, clock-in/clock-out functionality using photos and location, leave requests, and the current weather forecast. Additionally, it allows employees to view their profile and manage absentee forms.

### **Pages Overview:**

#### **1. Halaman Pertama (Main Page):**
- Displays:
  - **Current Time** and **Current Weather** (fetched from a weather API).
  - **Attendance Summary**:
    - Clock-in and clock-out records.
    - Summary of attendance (On Time, Early Leave, Absent, Late Come).
  - **Buttons**:
    - Clock In/Clock Out: Navigates to the **Attendance Page**.
    - Pengajuan Izin (Leave Request): Navigates to the **Leave Request Page**.

#### **2. Halaman Kedua (Attendance Page):**
- The employee will clock in or clock out using this page.
- Features:
  - **Camera Integration**: Capture the employee’s photo.
  - **Location Access**: Automatically fetch the employee’s current location (latitude and longitude).
  - **Time Record**: Record the current time when submitting.
  - **Submit Button**: Once the photo and location are captured, clicking the submit button stores the attendance record.

#### **3. Halaman Ketiga (Leave Request Form Page):**
- A form similar to a registration form.
- Fields include:
  - **Start Date** and **End Date** (for the leave period).
  - **Reason for Leave** (text input).
  - **Submit Button**: Submits the leave request and stores it in local storage (SQLite or Room).

#### **4. Halaman Keempat (Profile Page):**
- Displays the employee’s profile:
  - **Name**
  - **Department**
  - **Supervisor**
  - **Office Location**
  
---

### **Feature Details:**

#### **1. Attendance Summary:**
- A summary of the employee’s attendance is shown on the **Main Page**:
  - **Clock-In and Clock-Out times** for the day.
  - **Rangkuman Absensi**:
    - On Time
    - Early Leave
    - Absent
    - Late Come
- The data can be fetched from local storage (SQLite or Room) and displayed as a list of recent attendance records.

#### **2. Jumlah Hari Kerja (Total Workdays):**
- The system keeps track of how many days the employee has worked.
- Display the number of workdays on the **Main Page**.

#### **3. Input Izin (Leave Submission):**
- The **Leave Request Form** allows the employee to submit a leave request.
- This feature collects details like start and end dates, reasons for leave, and stores the submission locally for HR review.

#### **4. Absensi (Attendance with Photo & Location):**
- When clocking in or out, the employee’s photo is captured using the camera.
- The system also records the employee’s location using GPS coordinates (latitude and longitude).
- These records are stored along with the time of clock-in/clock-out.

#### **5. Weather Integration:**
- The app fetches the **current weather** for the employee’s location.
- Use a weather API (such as OpenWeatherMap) to retrieve and display the current weather on the **Main Page**.

---

### **Technical Requirements and Tasks Breakdown:**

#### **1. Halaman Pertama (Main Page):**
**Tasks**:
- **Task 1: Display Current Time**:
  - Use `System.currentTimeMillis()` or `Calendar` to show the current time on the top of the page.

- **Task 2: Fetch and Display Weather**:
  - Use `Retrofit` to call the OpenWeatherMap API or any other weather API.
  - Display current temperature, humidity, and weather description (e.g., clear, rain).

- **Task 3: Display Attendance Summary**:
  - Fetch recent clock-in and clock-out times and display them.
  - Show attendance status (On Time, Early Leave, Absent, Late Come) for the day.

- **Task 4: Add Clock-In/Clock-Out Button**:
  - Create a button that navigates to the **Attendance Page**.

- **Task 5: Add Leave Request Button**:
  - Create a button that navigates to the **Leave Request Page**.

#### **2. Halaman Kedua (Attendance Page):**
**Tasks**:
- **Task 6: Camera Integration**:
  - Use `CameraX` or the native `Camera` API to capture the employee's photo during clock-in/clock-out.
  
- **Task 7: Fetch and Display Location**:
  - Use `FusedLocationProviderClient` to get the current location (latitude and longitude).
  - Display the location on the page and store it with the attendance record.

- **Task 8: Record Attendance**:
  - When the employee clicks the **Submit** button, store the following details in local storage (Room or SQLite):
    - Clock-in/clock-out time
    - Captured photo
    - Location (latitude and longitude)

#### **3. Halaman Ketiga (Leave Request Form Page):**
**Tasks**:
- **Task 9: Create Leave Request Form**:
  - Include fields for:
    - **Start Date** and **End Date** (use `DatePicker`).
    - **Reason for Leave** (text input).
  
- **Task 10: Handle Form Submission**:
  - Store the submitted leave request (dates and reason) in the local database (SQLite or Room).

#### **4. Halaman Keempat (Profile Page):**
**Tasks**:
- **Task 11: Display Profile Information**:
  - Show the employee’s **Name**, **Department**, **Supervisor**, and **Office Location**.
  - This data can be stored locally using `SharedPreferences` or `Room`.

---

### **API Integration for Weather:**

You can use the **OpenWeatherMap API** to fetch current weather data based on the user's location.

- **API Example**:  
  ```bash
  GET https://api.openweathermap.org/data/2.5/weather?q=YOUR_CITY&appid=YOUR_API_KEY
  ```
- **Weather Response Fields**:
  - Temperature (`main.temp`)
  - Humidity (`main.humidity`)
  - General weather description (`weather[0].description`)

### **Code Snippets:**

#### **Fetching Weather Data (Using Retrofit):**
Add this code to fetch the weather:

```kotlin
interface WeatherApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Call<WeatherResponse>
}

// Fetch and display the weather
fun fetchWeather() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService = retrofit.create(WeatherApiService::class.java)

    val call = weatherService.getWeather("YOUR_CITY", "YOUR_API_KEY")
    call.enqueue(object : Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            if (response.isSuccessful) {
                val weather = response.body()
                // Update the UI with weather info
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            // Handle failure
        }
    })
}
```

#### **Camera Integration for Clock-In/Clock-Out (Using CameraX):**
You can use `CameraX` for capturing images.

```kotlin
private lateinit var imageCapture: ImageCapture

private fun startCamera() {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
    cameraProviderFuture.addListener({
        val cameraProvider = cameraProviderFuture.get()

        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(viewFinder.surfaceProvider)
        }

        imageCapture = ImageCapture.Builder().build()

        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture)
        } catch (exc: Exception) {
            // Handle error
        }
    }, ContextCompat.getMainExecutor(this))
}

private fun takePhoto() {
    val photoFile = File(outputDirectory, SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".jpg")
    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

    imageCapture.takePicture(outputOptions, ContextCompat.getMainExecutor(this), object : ImageCapture.OnImageSavedCallback {
        override fun onError(exc: ImageCaptureException) {
            // Handle error
        }

        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
            val savedUri = Uri.fromFile(photoFile)
            // Save photo and attendance details
        }
    })
}
```

