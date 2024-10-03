#### **Optional Questions:**
1. Which method is called when an activity is first created?
   - a) `onResume()`
   - b) `onPause()`
   - c) `onStart()`
   - d) `onCreate()`
   - e) `onDestroy()`

2. What is the purpose of `onSaveInstanceState()` in an activity?
   - a) To start a new activity
   - b) To save temporary UI state when the activity is killed
   - c) To initialize UI components
   - d) To handle user inputs
   - e) To destroy an activity

3. How do you navigate between activities in Android?
   - a) Using intents
   - b) Using `ActivityManager`
   - c) Using `FragmentTransaction`
   - d) Using `startFragment()`
   - e) None of the above

4. What does `finish()` do in an activity?
   - a) Pauses the activity
   - b) Starts a new activity
   - c) Destroys the current activity
   - d) Saves the activity's state
   - e) None of the above

5. What is the role of `setContentView()` in an activity?
   - a) To initialize the activity's lifecycle
   - b) To define the UI layout for the activity
   - c) To create a new fragment
   - d) To destroy the activity
   - e) To handle background processes

#### **True/False Questions:**
1. Every activity in Android must define its own layout in an XML file. (False)
2. `onResume()` is called after `onCreate()` when the activity becomes visible. (True)
3. Activities in Android are always destroyed when the user rotates the screen. (False)
4. The `onPause()` method is called when the activity loses foreground focus. (True)
5. You cannot start another activity from within an activity. (False)

#### **Short Answer Questions:**
1. What is the difference between `onPause()` and `onStop()` in the activity lifecycle?
2. How do you pass data from one activity to another using an `Intent`?
3. What is the significance of `onSaveInstanceState()` when handling screen rotations?
4. Describe how an activity transitions through different lifecycle states when the user presses the back button.
5. How can you start a new activity and expect a result from it in the current activity?

#### **Code Fix Questions:**
1. **Incorrect code:**
   ```kotlin
   startActivity(MainActivity::class.java)
   ```
   **Fix the code and explain why it doesn't work.**

2. **Incorrect code:**
   ```kotlin
   override fun onCreate(savedInstanceState: Bundle) {
       super.onCreate()
   }
   ```
   **Fix the code to properly initialize the activity with a layout.**

3. **Incorrect code:**
   ```kotlin
   onDestroy() {
       super.onDestroy()
   }
   ```
   **Fix the code to properly override the `onDestroy()` method.**

### Project Creation Tasks

#### 1. **Basic Activity Creation**
   **Task:**
   - Create a simple activity that displays a "Hello, World!" message.
   
   **Instructions:**
   1. Create a new Android project.
   2. Define the layout in XML (`activity_main.xml`) with a `TextView` for the message.
   3. In the `MainActivity`, use `setContentView(R.layout.activity_main)` to bind the layout.
   4. Run the app and ensure the message is displayed.

#### 2. **Passing Data Between Activities**
   **Task:**
   - Create two activities: one to collect a user’s name and another to display it.
   
   **Instructions:**
   1. Create two activities: `MainActivity` and `DisplayActivity`.
   2. In `MainActivity`, add an `EditText` and a `Button` in the layout.
   3. On button click, pass the name entered in `EditText` to `DisplayActivity` using an `Intent`.
   4. In `DisplayActivity`, retrieve the name from the intent and display it in a `TextView`.

#### 3. **Activity Lifecycle Logging**
   **Task:**
   - Create an activity that logs lifecycle method calls (`onCreate()`, `onStart()`, etc.) to the console.
   
   **Instructions:**
   1. In `MainActivity`, override lifecycle methods like `onCreate()`, `onStart()`, `onResume()`, etc.
   2. Use `Log.d(TAG, "Message")` to log each lifecycle call.
   3. Run the app and observe the lifecycle logs in Logcat.

#### 4. **Activity with Implicit Intent**
   **Task:**
   - Create an activity that allows users to open a webpage using an implicit intent.
   
   **Instructions:**
   1. Add a `Button` in `MainActivity` to trigger the intent.
   2. In `MainActivity`, create an implicit intent to open a URL in the browser.
   3. Use `startActivity()` to start the browser when the button is clicked.

#### 5. **Activity for Result**
   **Task:**
   - Create two activities where `MainActivity` starts `SecondActivity` and gets a result back.
   
   **Instructions:**
   1. Create `MainActivity` and `SecondActivity`.
   2. In `MainActivity`, start `SecondActivity` using `startActivityForResult()`.
   3. In `SecondActivity`, return a result (e.g., a message) back to `MainActivity`.
   4. In `MainActivity`, override `onActivityResult()` to receive and display the result.

These tasks and questions should provide a comprehensive overview for your students to understand activities in Android development.