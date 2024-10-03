### Pre-test on Android UI Components

#### **Optional Questions:**

1. Which component is used to display images in Android?
   - a) `ImageView`
   - b) `TextView`
   - c) `EditText`
   - d) `RecyclerView`
   - e) None of the above

2. What is `RecyclerView` used for?
   - a) To display a single image
   - b) To display a scrollable list of data
   - c) To handle user interactions
   - d) To create buttons
   - e) None of the above

3. Which layout is best for creating a simple list of UI components arranged vertically?
   - a) `FrameLayout`
   - b) `LinearLayout`
   - c) `ConstraintLayout`
   - d) `GridLayout`
   - e) None of the above

4. Which of the following is required for a `RadioButton` to be used correctly?
   - a) `CheckBox`
   - b) `RadioGroup`
   - c) `RecyclerView`
   - d) `ImageView`
   - e) None of the above

5. What does the `TextView` component do?
   - a) Displays images
   - b) Displays text
   - c) Handles user input
   - d) Responds to button clicks
   - e) None of the above

---

#### **True/False Questions:**

1. A `RecyclerView` requires an adapter to display data. 
2. `ConstraintLayout` is more flexible than `LinearLayout`. 
3. `EditText` is used to display images in Android. 
4. You can group multiple `RadioButtons` using a `RadioGroup`. 
5. `ProgressBar` is used to display progress in percentages. 

---

#### **Short Answer Questions:**

1. What is the purpose of `RecyclerView` in Android?
2. How do you display a clickable button in Android?
3. Explain the difference between `LinearLayout` and `ConstraintLayout`.
4. How can you display a progress indicator in Android?
5. What is the purpose of `CheckBox` in an Android app?

---

#### **Code Fix Questions:**

1. **Incorrect code:**
   ```xml
   <ImageView
       android:id="@+id/imageView"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Click me!" />
   ```
   **Fix the code to correctly display an image instead of text.**

2. **Incorrect code:**
   ```xml
   <Button
       android:id="@+id/button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:onClick="clickButton"
       android:text="Press Me" />
   ```
   **Fix the code and explain how to correctly handle button clicks.**

3. **Incorrect code:**
   ```xml
   <RecyclerView
       android:id="@+id/recyclerView"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content" />
   ```
   **Fix the code and explain how to make the RecyclerView fill the screen.**

   ### Project Creation Tasks for Android UI Components

#### 1. **Basic UI Layout with `TextView` and `Button`**
   **Task:**
   - Create a simple UI with a `TextView` and a `Button` that changes the text when clicked.

   **Instructions:**
   1. Create a new Android project.
   2. In the layout XML file, add a `TextView` and a `Button`.
   3. In the `MainActivity`, set up an `OnClickListener` for the `Button` to change the text of the `TextView` when clicked.
   4. Run the app and verify that clicking the button changes the text.

#### 2. **ImageView Project**
   **Task:**
   - Create a UI that displays an image using `ImageView`, and changes the image when a button is clicked.

   **Instructions:**
   1. In the layout XML file, add an `ImageView` and a `Button`.
   2. In `MainActivity`, create an array of drawable resource IDs for the images.
   3. Set up an `OnClickListener` for the `Button` that cycles through the images and updates the `ImageView`.
   4. Run the app and verify that the image changes when the button is clicked.

#### 3. **RecyclerView Implementation**
   **Task:**
   - Build an app that displays a list of items using `RecyclerView`.

   **Instructions:**
   1. Add a `RecyclerView` to the activity’s layout.
   2. Create a custom adapter class to bind the data to the `RecyclerView`.
   3. In `MainActivity`, initialize the `RecyclerView` and set the adapter.
   4. Run the app and ensure the list displays correctly.

#### 4. **Checkbox Interaction**
   **Task:**
   - Create a form that contains several `CheckBox` components and displays a summary of the selected options when submitted.

   **Instructions:**
   1. In the layout XML, add multiple `CheckBox` components.
   2. Add a `Button` to submit the form.
   3. In `MainActivity`, collect the checked options when the `Button` is clicked and display the selected options in a `TextView`.
   4. Run the app and ensure that it correctly shows the selected checkboxes when the form is submitted.

#### 5. **RadioGroup with Submit Button**
   **Task:**
   - Create a simple quiz app where the user selects an answer from a `RadioGroup` and submits it. Display a message indicating whether the answer is correct.

   **Instructions:**
   1. In the layout XML, add a `RadioGroup` containing several `RadioButton` options and a `Submit` button.
   2. In `MainActivity`, set up the logic to check if the selected answer is correct when the user clicks the `Submit` button.
   3. Display a `Toast` message showing whether the answer was correct or not.
   4. Run the app and verify the answer-checking functionality.

