### Content on Storage in Android

#### **1. Shared Preferences**

**Use Case:**
- Used for storing small amounts of simple data, such as user settings, preferences, or state information.
- Data is stored as key-value pairs and persists across app sessions.

**Key Points:**
- Shared Preferences store primitive data types: `String`, `int`, `float`, `boolean`, and `Set<String>`.
- Data is stored in an XML file inside the app's private storage.
- Ideal for saving user preferences (like themes, notifications, login credentials, etc.).

**How to Use:**
1. **Write Data:**
   ```kotlin
   val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
   val editor = sharedPref.edit()
   editor.putString("username", "JohnDoe")
   editor.putBoolean("isLoggedIn", true)
   editor.apply() // or editor.commit() for synchronous saving
   ```

2. **Read Data:**
   ```kotlin
   val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
   val username = sharedPref.getString("username", null)
   val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
   ```

3. **Remove Data:**
   ```kotlin
   val editor = sharedPref.edit()
   editor.remove("username")
   editor.apply()
   ```

---

#### **2. Internal Storage**

**Use Case:**
- Used to store private data within the app's internal storage.
- Files stored in internal storage are only accessible by the app unless explicitly shared.

**Key Points:**
- Internal storage is useful for sensitive data like app-specific files, documents, or media.
- Files saved here are deleted when the app is uninstalled.

**How to Use:**
1. **Write Data:**
   ```kotlin
   val filename = "myfile.txt"
   val fileContents = "Hello, World!"
   openFileOutput(filename, Context.MODE_PRIVATE).use {
       it.write(fileContents.toByteArray())
   }
   ```

2. **Read Data:**
   ```kotlin
   val filename = "myfile.txt"
   openFileInput(filename).bufferedReader().useLines { lines ->
       val content = lines.joinToString("\n")
   }
   ```

3. **Delete a File:**
   ```kotlin
   deleteFile("myfile.txt")
   ```

---

#### **3. External Storage**

**Use Case:**
- Used for storing large files such as media (images, videos, audio), documents, or files that the user may want to access outside of the app.
- External storage includes both public and app-specific directories.

**Key Points:**
- Data stored in external storage can be accessed by other apps if stored in public directories.
- Ensure the necessary permissions are declared for reading/writing external storage in `AndroidManifest.xml`:
  ```xml
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
  ```
  
**How to Use (App-specific directory):**
1. **Write Data:**
   ```kotlin
   val filename = "example.txt"
   val fileContents = "This is a file on external storage"
   val file = File(getExternalFilesDir(null), filename)
   file.writeText(fileContents)
   ```

2. **Read Data:**
   ```kotlin
   val file = File(getExternalFilesDir(null), "example.txt")
   val content = file.readText()
   ```

---

#### **4. SQLite Database**

**Use Case:**
- Used for storing structured data, such as in a relational database, suitable for complex data handling and querying.
- SQLite is a lightweight database embedded within the Android OS, allowing apps to store data using SQL queries.

**Key Points:**
- Best for apps that require complex data storage, relationships between data, or frequent querying.
- You can use `SQLiteOpenHelper` to manage database creation and versioning.

**How to Use:**
1. **Define a Database Helper:**
   ```kotlin
   class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
       override fun onCreate(db: SQLiteDatabase) {
           val createTableQuery = """
               CREATE TABLE users (
                   id INTEGER PRIMARY KEY,
                   username TEXT,
                   email TEXT
               )
           """.trimIndent()
           db.execSQL(createTableQuery)
       }

       override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
           db.execSQL("DROP TABLE IF EXISTS users")
           onCreate(db)
       }
   }
   ```

2. **Insert Data:**
   ```kotlin
   val dbHelper = MyDatabaseHelper(this)
   val db = dbHelper.writableDatabase

   val values = ContentValues().apply {
       put("username", "JohnDoe")
       put("email", "john.doe@example.com")
   }
   db.insert("users", null, values)
   ```

3. **Query Data:**
   ```kotlin
   val db = dbHelper.readableDatabase
   val cursor = db.query("users", arrayOf("id", "username", "email"), null, null, null, null, null)
   
   with(cursor) {
       while (moveToNext()) {
           val userId = getInt(getColumnIndexOrThrow("id"))
           val username = getString(getColumnIndexOrThrow("username"))
           val email = getString(getColumnIndexOrThrow("email"))
       }
   }
   ```

---

#### **5. Room Persistence Library (Alternative to SQLite)**

**Use Case:**
- Room is an abstraction layer over SQLite, providing a more robust and easier-to-use database solution.

**Key Points:**
- Room handles database setup, querying, and lifecycle automatically.
- Uses annotated Data Access Objects (DAO) to perform database operations.

**How to Use:**
1. **Define an Entity:**
   ```kotlin
   @Entity
   data class User(
       @PrimaryKey val id: Int,
       val username: String,
       val email: String
   )
   ```

2. **Define a DAO:**
   ```kotlin
   @Dao
   interface UserDao {
       @Query("SELECT * FROM user")
       fun getAll(): List<User>

       @Insert
       fun insert(user: User)

       @Delete
       fun delete(user: User)
   }
   ```

3. **Create the Database:**
   ```kotlin
   @Database(entities = [User::class], version = 1)
   abstract class AppDatabase : RoomDatabase() {
       abstract fun userDao(): UserDao
   }
   ```

4. **Perform Operations:**
   ```kotlin
   val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").build()
   val userDao = db.userDao()

   val user = User(1, "JohnDoe", "john.doe@example.com")
   userDao.insert(user)
   ```

---

### **Choosing the Right Storage Option**

1. **Shared Preferences**: Use for small, simple data (user settings, login status).
2. **Internal Storage**: Use for app-specific files that should not be accessed by other apps.
3. **External Storage**: Use for large media files or documents that the user may want to access outside of the app.
4. **SQLite Database**: Use for structured, relational data that requires complex querying.
5. **Room**: An easier-to-use database solution that builds on SQLite, providing more abstraction and simpler database handling.

