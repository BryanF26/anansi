    
  --- 
    // Create an explicit Intent to navigate to SecondActivity
            
            val intent = Intent(this, SecondActivity::class.java)

            // Put the text from the input field into the intent
            intent.putExtra("input", input.text.toString())

            // Start the second activity
            startActivity(intent)

--- 
    // consume intent

        // Get the string from the intent
        val inputText = intent.getStringExtra("input") 

