### Content for Android UI Components

#### **Introduction to Android UI Components**
UI components in Android are views and view groups that handle the graphical user interface. They allow interaction between the user and the application.

#### **Basic UI Components**

1. **TextView**
   - Used to display text to the user.
   - Example:
     ```xml
     <TextView
         android:id="@+id/textView"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Hello, World!" />
     ```

2. **EditText**
   - Allows users to input text.
   - Example:
     ```xml
     <EditText
         android:id="@+id/editText"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:hint="Enter text here" />
     ```

3. **Button**
   - A clickable UI element that performs an action when pressed.
   - Example:
     ```xml
     <Button
         android:id="@+id/button"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Click Me" />
     ```

4. **ImageView**
   - Displays images.
   - Example:
     ```xml
     <ImageView
         android:id="@+id/imageView"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:src="@drawable/sample_image" />
     ```

5. **CheckBox**
   - Used for selecting/deselecting options.
   - Example:
     ```xml
     <CheckBox
         android:id="@+id/checkBox"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Accept terms" />
     ```

6. **RadioButton and RadioGroup**
   - Allows users to select one option from a set of options.
   - Example:
     ```xml
     <RadioGroup
         android:id="@+id/radioGroup"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content">
         <RadioButton
             android:id="@+id/radioButton1"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="Option 1" />
         <RadioButton
             android:id="@+id/radioButton2"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="Option 2" />
     </RadioGroup>
     ```

7. **Spinner**
   - Dropdown list that allows users to select an option.
   - Example:
     ```xml
     <Spinner
         android:id="@+id/spinner"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content" />
     ```

#### **Layout Types**

1. **LinearLayout**
   - Arranges its children in a single row or column.
   - Example:
     ```xml
     <LinearLayout
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:orientation="vertical">
         <!-- Child views here -->
     </LinearLayout>
     ```

2. **RelativeLayout**
   - Allows positioning of its children relative to each other or the parent.
   - Example:
     ```xml
     <RelativeLayout
         android:layout_width="match_parent"
         android:layout_height="match_parent">
         <TextView
             android:id="@+id/textView"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="Hello" />
         <Button
             android:id="@+id/button"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="Click"
             android:layout_below="@id/textView" />
     </RelativeLayout>
     ```

3. **ConstraintLayout**
   - Allows flexible UI design with constraints between views.
   - Example:
     ```xml
     <androidx.constraintlayout.widget.ConstraintLayout
         android:layout_width="match_parent"
         android:layout_height="match_parent">
         <TextView
             android:id="@+id/textView"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="Hello, World!"
             app:layout_constraintTop_toTopOf="parent"
             app:layout_constraintStart_toStartOf="parent" />
     </androidx.constraintlayout.widget.ConstraintLayout>
     ```

4. **FrameLayout**
   - Holds a single child view, useful for fragment placement.
   - Example:
     ```xml
     <FrameLayout
         android:id="@+id/frameLayout"
         android:layout_width="match_parent"
         android:layout_height="match_parent">
         <!-- Fragment or child view here -->
     </FrameLayout>
     ```

#### **Event Handling**
1. **OnClickListener for Buttons**
   - Handles click events for buttons or other clickable UI components.
   - Example:
     ```kotlin
     button.setOnClickListener {
         // Action to perform on button click
     }
     ```

2. **Text Change Listener for EditText**
   - Monitors changes in text input.
   - Example:
     ```kotlin
     editText.addTextChangedListener(object : TextWatcher {
         override fun afterTextChanged(s: Editable?) {}
         override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
         override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             // Action on text change
         }
     })
     ```

---
