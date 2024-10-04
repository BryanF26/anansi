
### **Food Tracker App - Updated Requirements and Tasks**
team 1

### **Project Overview**
This is an Android app built with Kotlin. It allows users to log in using the Reqres API, and once logged in, they can post food photos with descriptions. Food posts are stored locally using SharedPreferences for user credentials and local storage for post data.

### **Updated Features:**

#### **1. Login & Register (Using Reqres API)**
- **Login Activity**: Authenticate users using the Reqres API. Store user token and login status in SharedPreferences.
- **Register Activity**: This will be implemented locally for demonstration purposes, where users can register with a name, email, and password (data stored in SharedPreferences).
- **SharedPreferences** will be used to store:
  - User credentials (email, token) after login.
  - Login status for keeping users logged in.

#### **2. MainActivity**
MainActivity contains three fragments:
- **Fragment 1: Food Photo List** (local storage)
    - Displays a grid of food photos posted by the user.
    - Data comes from local storage (Room or SQLite).
  
- **Fragment 2: Profile Fragment** (local storage)
    - Displays the user's profile (photo, name, email).
    - Fetch user info from SharedPreferences.

- **Fragment 3: Food Detail Fragment** (local storage)
    - Displays detailed information about a selected food post (image, description, date).
  
#### **3. Add Posting Activity** (Local Posting)
- Allows users to upload food photos (taken via camera or chosen from gallery) and add a description.
- Posted data will be saved locally (Room or SQLite).
- Each post will contain:
  - Username (retrieved from SharedPreferences).
  - Photo (stored locally in device storage or database).
  - Description.
  - Date.

### **Technical Details:**

#### **Login with Reqres API:**
- **POST Login**: Use the Reqres API endpoint to log in the user.
  - **URL**: `POST https://reqres.in/api/login`
  - **Request Body**:
    ```json
    {
      "email": "eve.holt@reqres.in",
      "password": "cityslicka"
    }
    ```
  - **Response**:
    ```json
    {
      "token": "QpwL5tke4Pnpja7X4"
    }
    ```
  - Store the token and login status in SharedPreferences.

#### **Local Storage for Posts and User Profile:**
- Use SharedPreferences for saving user data such as the token, name, and email after logging in.
- Store food posts in local storage (Room or SQLite) with fields for:
  - Username
  - Photo (local path or byte data)
  - Description
  - Date of post

#### **Multimedia Handling (Camera & Gallery Access):**
- Request camera and storage permissions.
- Allow users to upload a food photo by taking a picture with the camera or selecting one from the gallery.

### **Tasks Breakdown:**

#### **1. Login Implementation:**
- Create a login screen that posts to the Reqres API.
- On successful login, store the user's email and token in SharedPreferences.
- Navigate to MainActivity upon successful login.

#### **2. SharedPreferences Setup:**
- Store the following in SharedPreferences:
  - `email`
  - `token`
  - `isLoggedIn` (boolean)
  
#### **3. MainActivity with Fragments:**
- Set up `BottomNavigationView` or `ViewPager2` to switch between the following fragments:
  - **Food List Fragment**: Display a grid of food posts stored locally.
  - **Profile Fragment**: Display user details (name, email, photo) from SharedPreferences.
  - **Detail Fragment**: Display the full image, description, and date of a selected post.

#### **4. Add Posting Activity:**
- Implement an activity for posting food photos.
- Add options to upload photos via camera or gallery.
- Store the post details (username, photo, description, date) in local storage.

### **Sample Code for Uploading Photos (Camera & Gallery)**:

1. **Request Camera and Storage Permissions:**
   Ensure you add the necessary permissions in your `AndroidManifest.xml` and request them at runtime:

```kotlin
// Permissions array
private val REQUEST_CODE_PERMISSIONS = 100
private val REQUIRED_PERMISSIONS = arrayOf(
    Manifest.permission.CAMERA,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.WRITE_EXTERNAL_STORAGE
)

// Check and request permissions
private fun checkAndRequestPermissions() {
    if (!allPermissionsGranted()) {
        ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
    }
}

// Helper to check if all permissions are granted
private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
    ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
}

override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    if (requestCode == REQUEST_CODE_PERMISSIONS) {
        if (!allPermissionsGranted()) {
            Toast.makeText(this, "Permissions not granted", Toast.LENGTH_SHORT).show()
        }
    }
}
```

2. **Handling Camera and Gallery Photo Selection:**
```kotlin
private val REQUEST_IMAGE_CAPTURE = 1
private val REQUEST_PICK_PHOTO = 2

// Open Camera for capturing photo
private fun openCamera() {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
}

// Open Gallery for selecting a photo
private fun openGallery() {
    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    startActivityForResult(intent, REQUEST_PICK_PHOTO)
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == Activity.RESULT_OK) {
        when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                val imageBitmap = data?.extras?.get("data") as Bitmap
                // Use the imageBitmap for your post (e.g., display it or save it)
            }
            REQUEST_PICK_PHOTO -> {
                val selectedImageUri = data?.data
                // Use the selectedImageUri to get the image from the gallery
            }
        }
    }
}
```

3. **Storing Post Data Locally (Using SQLite or Room)**
For storing posts, use a local database. Here's an outline using **Room** for persistence:
```kotlin
@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val username: String,
    val photoUri: String,
    val description: String,
    val date: String
)

@Dao
interface PostDao {
    @Insert
    fun insertPost(post: Post)

    @Query("SELECT * FROM posts")
    fun getAllPosts(): List<Post>
}

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
```

