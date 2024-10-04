### **Language Learning App - Requirements and Tasks**
team 2

### **Project Overview:**
This app allows users to log in, view available language classes, participate in quizzes, and access course content like video E-Learning. Users can also manage their profiles and view courses they are currently enrolled in.

### **Pages Overview:**

#### **1. Log-in Page:**
- Users can log in with their email and password.
- Once authenticated, users are taken to the **Home** page.

#### **2. Home Page:**
- Shows:
  - Recommended classes for beginners.
  - Available courses for all users.
  - Each course includes:
    - **Course Title**
    - **Course Overview**
    - **Video E-Learning Content**

- When a course is selected, the user is taken to a **Class Overview Page** where they can:
  - View details about the course.
  - Watch the E-Learning videos.
  - Attempt a quiz (multiple-choice).

#### **3. Class Overview Page:**
- Displays:
  - **Course Overview**: A brief description of the course.
  - **Video Lessons**: Each class will have a video-based lesson.
  - **Quiz**: After completing the video, users can attempt a multiple-choice quiz.

#### **4. Profile Page:**
- Displays user information such as:
  - Full Name
  - Email
  - Other general profile details.

#### **5. Quiz Activity:**
- Multiple-choice quiz for each course.
- Users will receive feedback on their performance after submission.

#### **6. Fragments Setup:**
The app will use fragments to separate different sections:
- **Home Fragment**: Displays available classes and suggested classes for beginners.
- **My Course Fragment**: Displays courses the user is currently enrolled in.
- **Profile and Settings Fragment**: Displays the user’s profile and settings.

---

### **Feature Details:**

#### **1. Log-in Page:**
- The user will log in using their email and password.
- Store login credentials using `SharedPreferences` for session management.
- On successful login, navigate to the **Home Page**.

#### **2. Home Page (Courses and Recommendations):**
- Show a list of available language learning classes and suggestions for beginner classes.
- Each class will display:
  - **Course Title**
  - **Course Overview**
  - **Access to Video E-Learning Content**
- Clicking on a course will take the user to the **Class Overview Page**.

#### **3. Class Overview Page:**
- Show an overview of the selected class.
- Include a list of available video lessons for the course.
- After completing a video, show a **Take Quiz** button to proceed to the quiz.

#### **4. Profile Page:**
- Display user information such as:
  - Full Name
  - Email
  - Any additional profile information
- Users can update their information if needed.

#### **5. Multiple-Choice Quiz:**
- At the end of each course, there will be a quiz with multiple-choice questions.
- The user selects an answer, submits the quiz, and receives feedback on their performance.

---

### **Tasks Breakdown:**

#### **1. Log-in Page:**
**Tasks**:
- **Task 1: Create Login UI**:
  - Design a simple login page with email and password fields.
  
- **Task 2: Implement Authentication**:
  - Validate the user's credentials and store login session in `SharedPreferences`.
  - On successful login, redirect the user to the **Home Page**.

#### **2. Home Page:**
**Tasks**:
- **Task 3: Display Available Classes**:
  - Show a list of available classes.
  - Highlight suggested classes for beginners.
  
- **Task 4: Navigate to Class Overview Page**:
  - On selecting a class, navigate to the **Class Overview Page**, passing the course details.

#### **3. Class Overview Page:**
**Tasks**:
- **Task 5: Display Course Overview and Video Lessons**:
  - Show a brief overview of the course.
  - Display a list of video lessons for that course.

- **Task 6: Implement Video Playback**:
  - Use an embedded video player (`ExoPlayer` or `VideoView`) to play the lesson videos.

- **Task 7: Quiz Navigation**:
  - After completing a video, provide a **Take Quiz** button to navigate to the quiz for that course.

#### **4. Profile Page:**
**Tasks**:
- **Task 8: Display and Update Profile Information**:
  - Show user information such as name, email, etc.
  - Allow users to update their profile details.

#### **5. Multiple-Choice Quiz:**
**Tasks**:
- **Task 9: Quiz Creation**:
  - Create multiple-choice questions for each course.
  
- **Task 10: Quiz Feedback**:
  - Provide feedback after quiz submission, indicating correct and incorrect answers.

#### **6. Fragments for Navigation:**
**Tasks**:
- **Task 11: Set up Fragment Navigation**:
  - Implement fragments for:
    - **Home Fragment**: Shows available and recommended classes.
    - **My Course Fragment**: Displays ongoing courses the user is enrolled in.
    - **Profile and Settings Fragment**: Displays user profile and settings.

---

### **Code Snippets:**

#### **Login Authentication with SharedPreferences**:
Here’s how you can handle login and store user information using `SharedPreferences`:

```kotlin
private fun loginUser(email: String, password: String) {
    // Assume login success
    val sharedPreferences = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("email", email)
    editor.putBoolean("isLoggedIn", true)
    editor.apply()

    // Navigate to HomePage
    startActivity(Intent(this, HomeActivity::class.java))
    finish()
}
```

#### **Fragment Navigation with BottomNavigationView**:
You can set up the fragment navigation using a `BottomNavigationView`.

```kotlin
bottomNavigationView.setOnNavigationItemSelectedListener { item ->
    when (item.itemId) {
        R.id.nav_home -> {
            loadFragment(HomeFragment())
            true
        }
        R.id.nav_my_course -> {
            loadFragment(MyCourseFragment())
            true
        }
        R.id.nav_profile -> {
            loadFragment(ProfileFragment())
            true
        }
        else -> false
    }
}

private fun loadFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
}
```

#### **Displaying Video Content Using ExoPlayer**:
Use ExoPlayer for video playback in the course lessons:

```kotlin
private fun initializePlayer() {
    val player = ExoPlayer.Builder(this).build()
    val videoUri = Uri.parse("https://path_to_your_video")
    val mediaItem = MediaItem.fromUri(videoUri)
    player.setMediaItem(mediaItem)
    player.prepare()
    videoView.player = player
}
```

#### **Quiz Implementation with Multiple-Choice Questions**:
Here’s a basic structure for displaying and handling multiple-choice quizzes:

```kotlin
private fun showQuiz(questions: List<Question>) {
    val currentQuestion = questions[0]
    questionTextView.text = currentQuestion.text
    option1Button.text = currentQuestion.option1
    option2Button.text = currentQuestion.option2
    option3Button.text = currentQuestion.option3
    option4Button.text = currentQuestion.option4

    option1Button.setOnClickListener { checkAnswer(currentQuestion, 1) }
    option2Button.setOnClickListener { checkAnswer(currentQuestion, 2) }
    option3Button.setOnClickListener { checkAnswer(currentQuestion, 3) }
    option4Button.setOnClickListener { checkAnswer(currentQuestion, 4) }
}

private fun checkAnswer(question: Question, selectedOption: Int) {
    if (question.correctOption == selectedOption) {
        // Correct answer
    } else {
        // Incorrect answer
    }
}
```


## API QUIZ(OPTIONAL) https://opentdb.com/api.php
```
API: https://opentdb.com/api.php?amount=10
```