### **SQLite and Room on Android with Kotlin**

Both **SQLite** and **Room** are commonly used for local database management in Android. SQLite is a light database engine built into Android, and Room is an abstraction layer over SQLite that simplifies database operations. Here’s a detailed guide for implementing both in an Android project using Kotlin.

---

### **1. SQLite on Android**

**SQLite** is a relational database included in Android, and you can use it directly through the `SQLiteOpenHelper` class. You manually write SQL queries for creating tables, inserting, updating, deleting, and querying data.

#### **Steps for Using SQLite in Android:**

##### **Step 1: Create a SQLite Database Helper**
You need to create a helper class that extends `SQLiteOpenHelper`. This class will manage database creation and versioning.

```kotlin
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "finance.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_EXPENSES = "expenses"
        private const val COLUMN_ID = "id"
        private const val COLUMN_AMOUNT = "amount"
        private const val COLUMN_CATEGORY = "category"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = ("CREATE TABLE $TABLE_EXPENSES ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_AMOUNT REAL,"
                + "$COLUMN_CATEGORY TEXT,"
                + "$COLUMN_DESCRIPTION TEXT,"
                + "$COLUMN_DATE TEXT)")
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_EXPENSES")
        onCreate(db)
    }
}
```

##### **Step 2: Inserting Data into SQLite**
Now, you can insert data (e.g., an expense) into the database:

```kotlin
fun addExpense(dbHelper: DatabaseHelper, amount: Double, category: String, description: String, date: String) {
    val db = dbHelper.writableDatabase
    val contentValues = ContentValues().apply {
        put("amount", amount)
        put("category", category)
        put("description", description)
        put("date", date)
    }
    db.insert("expenses", null, contentValues)
    db.close()
}
```

##### **Step 3: Querying Data**
You can query the SQLite database to get all expenses:

```kotlin
fun getAllExpenses(dbHelper: DatabaseHelper): List<Expense> {
    val db = dbHelper.readableDatabase
    val cursor = db.query("expenses", null, null, null, null, null, null)
    val expenses = mutableListOf<Expense>()

    while (cursor.moveToNext()) {
        val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
        val amount = cursor.getDouble(cursor.getColumnIndexOrThrow("amount"))
        val category = cursor.getString(cursor.getColumnIndexOrThrow("category"))
        val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
        val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))

        expenses.add(Expense(id, amount, category, description, date))
    }

    cursor.close()
    db.close()

    return expenses
}
```

##### **Step 4: Deleting Data**
Here’s how you can delete a specific expense by `id`:

```kotlin
fun deleteExpense(dbHelper: DatabaseHelper, id: Int) {
    val db = dbHelper.writableDatabase
    db.delete("expenses", "id = ?", arrayOf(id.toString()))
    db.close()
}
```

##### **SQLite Key Points:**
- You write raw SQL queries for data manipulation.
- Requires manual management of database schema and migrations.
- Direct interaction with SQLite API.

**References:**
- [SQLite Android Documentation](https://developer.android.com/training/data-storage/sqlite)

---

### **2. Room on Android**

**Room** is a higher-level abstraction over SQLite that reduces boilerplate and simplifies database operations by allowing developers to interact with the database through **Data Access Objects (DAO)** and entities.

#### **Steps for Using Room in Android:**

##### **Step 1: Add Dependencies**
First, add the Room dependencies in your `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("androidx.room:room-runtime:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    // Optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.5.0")
}
```

##### **Step 2: Create the Expense Entity**
An **entity** represents a table in Room. Each field corresponds to a column in the table.

```kotlin
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val category: String,
    val description: String?,
    val date: String
)
```

##### **Step 3: Create a DAO (Data Access Object)**
A **DAO** defines the methods to interact with the database (insert, update, query, delete).

```kotlin
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface ExpenseDao {
    @Insert
    fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): List<Expense>

    @Delete
    fun deleteExpense(expense: Expense)
}
```

##### **Step 4: Create the Database**
The **RoomDatabase** class is an abstract class that defines your database configuration and serves as the main access point to the app’s data.

```kotlin
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}
```

##### **Step 5: Initialize Room Database**
You’ll initialize the Room database instance in your application context.

```kotlin
import android.content.Context
import androidx.room.Room

object DatabaseInstance {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "finance_manager_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
```

##### **Step 6: Insert Data**
Inserting data using the `ExpenseDao`:

```kotlin
fun addExpense(context: Context, amount: Double, category: String, description: String?, date: String) {
    val expense = Expense(amount = amount, category = category, description = description, date = date)
    val db = DatabaseInstance.getDatabase(context)
    Thread {
        db.expenseDao().insertExpense(expense)
    }.start()
}
```

##### **Step 7: Query Data**
You can query all expenses as follows:

```kotlin
fun loadExpenses(context: Context): List<Expense> {
    val db = DatabaseInstance.getDatabase(context)
    return db.expenseDao().getAllExpenses()
}
```

##### **Step 8: Delete Data**
Deleting an expense in Room:

```kotlin
fun deleteExpense(context: Context, expense: Expense) {
    val db = DatabaseInstance.getDatabase(context)
    Thread {
        db.expenseDao().deleteExpense(expense)
    }.start()
}
```

##### **Room Key Points:**
- Room automatically maps your **Kotlin objects (entities)** to **SQLite tables**.
- It abstracts raw SQL queries with **DAO methods**.
- **Database migrations** are much easier to manage with Room.
- **Compile-time verification** for SQL queries.

**References:**
- [Room Android Documentation](https://developer.android.com/training/data-storage/room)

---

### **Comparison of SQLite and Room:**

| Feature                    | SQLite                                 | Room                                 |
|----------------------------|----------------------------------------|--------------------------------------|
| **API Level**               | Lower-level, direct SQL queries        | Abstraction over SQLite              |
| **Query Writing**           | Raw SQL queries                        | DAO methods, compile-time verification |
| **Migration Handling**      | Manual schema migration                | Simplified migrations                |
| **Boilerplate Code**        | More boilerplate (managing cursors)    | Less boilerplate, more streamlined   |
| **Best Use Case**           | Small, simple apps                     | Larger, more complex apps with schema evolution |

---

By using Room, you can reduce boilerplate code and take advantage of more structured database operations, making it ideal for modern Android applications. On the other hand, SQLite gives you full control over the SQL queries but requires more manual work.

