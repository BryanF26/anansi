### Step-by-Step Instructions

1. **Create the XML Layout with a Button**
   - First, create a layout for `MainActivity` with a `Button` that the user will click to open the webpage.

```xml
<!-- res/layout/activity_main.xml -->
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/openWebPageButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Open Webpage"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

2. **MainActivity Kotlin Code**
   - In your `MainActivity`, set up the button to trigger an implicit intent when clicked.

```kotlin
// MainActivity.kt
package com.example.openwebpage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button by its ID
        val openWebPageButton: Button = findViewById(R.id.openWebPageButton)

        // Set an OnClickListener on the button
        openWebPageButton.setOnClickListener {
            // Create an implicit intent to open a URL
            val url = "https://www.example.com"  // Replace with the desired URL
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            // Start the intent (browser)
            startActivity(intent)
        }
    }
}
```

### Breakdown:

- **Step 1:** The XML layout defines a button in the center of the screen.
- **Step 2:** In `MainActivity.kt`, the `Button` triggers an implicit `Intent` that opens a URL in the browser using `Intent.ACTION_VIEW` and `Uri.parse()` to handle the URL.

