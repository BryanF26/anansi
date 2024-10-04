### **Soundtok - Requirements and Tasks**
team 3

### **Project Overview:**
This Android app allows users to upload or record sounds, add metadata (title, description, time, location), and manage audio files. Users can browse a list of sounds, view detailed sound information, and play audio. The project will use fragments for listing and adding sounds, and an activity for viewing sound details.

### **Features:**

#### **1. MainActivity**
MainActivity will contain two fragments:
1. **Fragment 1: Sound List Fragment**
   - Displays a list of all sounds.
   - Use a `RecyclerView` to show each sound’s **title**, **duration**, **age restriction**, and **rating**.

2. **Fragment 2: Add Sound Fragment**
   - Allows users to:
     - **Record audio** using the device’s microphone.
     - **Upload audio** files (`.mp3`, `.wav`).
     - Set **location** and **time** metadata.
     - Add **title** and **description**.

#### **2. Sound Detail Activity**
   - Displays the details of a sound selected from the list.
   - Shows:
     - **Title**
     - **Duration**
     - **Time**
     - **Location**
     - **Description**
     - Option to **play the audio file**.

### **Technical Details:**

#### **1. Sound List Fragment:**
- **RecyclerView** will be used to display each sound with the following information:
  - **Title** (TextView)
  - **Duration** (TextView)
  - **Age Restriction** (TextView)
  - **Rating** (TextView)
  
- Data will be stored locally using SQLite, Room, or another preferred local storage.

#### **2. Add Sound Fragment:**
- **Record Audio:**
  - Use Android's `MediaRecorder` API to allow users to record audio and save it as a `.wav` file.
  
- **Upload Audio:**
  - Allow users to select an audio file from their device (`.mp3` or `.wav`).
  
- **Metadata:**
  - Allow users to input a **title** and **description**.
  - Use Android's location services to set the **location** of the sound.
  - Record the **time** of upload (automatically capture the current time).

#### **3. Sound Detail Activity:**
- Show details for a selected sound:
  - **Title**: The title of the sound.
  - **Duration**: The length of the sound in seconds.
  - **Time**: The timestamp of when the sound was uploaded.
  - **Location**: The geographical location where the sound was recorded or uploaded.
  - **Description**: A brief description of the sound.
  
- **Play Audio**: Use Android’s `MediaPlayer` to play the selected audio file.

### **Tasks Breakdown:**

#### **1. Sound List Fragment:**
- **Task 1**: Set up the `RecyclerView` in the Sound List Fragment.
  - Create a `RecyclerView` adapter and view holder.
  - Display a list of sounds, showing their title, duration, age restriction, and rating.
  - Implement `onClickListener` to navigate to the `Sound Detail Activity`.

- **Task 2**: Fetch data from local storage (SQLite or Room) and populate the `RecyclerView`.

#### **2. Add Sound Fragment:**
- **Task 3**: Set up the UI for recording and uploading sounds.
  - Add buttons for **recording** audio and **selecting audio files**.

- **Task 4**: Implement **audio recording** using the `MediaRecorder` API.
  - Record audio in `.wav` format and store it in local storage.

- **Task 5**: Implement **file picker** for selecting `.mp3` or `.wav` audio files from the device.

- **Task 6**: Implement **location services** to retrieve the current location (latitude/longitude).
  - Use `FusedLocationProviderClient` to get the device’s location.
  
- **Task 7**: Capture the **current time** when the sound is recorded or uploaded.

- **Task 8**: Allow the user to input **title** and **description** for the sound.

#### **3. Sound Detail Activity:**
- **Task 9**: Display sound details:
  - Show the title, duration, time, location, and description.
  
- **Task 10**: Implement the **audio playback** feature using `MediaPlayer` to play the selected sound.

### **Code Snippets:**

#### **Recording Audio with MediaRecorder**:
```kotlin
private var mediaRecorder: MediaRecorder? = null
private var audioFile: File? = null

private fun startRecording() {
    audioFile = File(externalCacheDir?.absolutePath + "/audio_record.wav")
    mediaRecorder = MediaRecorder().apply {
        setAudioSource(MediaRecorder.AudioSource.MIC)
        setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        setOutputFile(audioFile?.absolutePath)

        try {
            prepare()
            start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

private fun stopRecording() {
    mediaRecorder?.apply {
        stop()
        release()
    }
    mediaRecorder = null
}
```

#### **Uploading Audio (File Picker)**:
```kotlin
private val REQUEST_PICK_AUDIO = 1

// Open file picker
private fun openFilePicker() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "audio/*"
    startActivityForResult(intent, REQUEST_PICK_AUDIO)
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == REQUEST_PICK_AUDIO && resultCode == RESULT_OK) {
        val audioUri: Uri? = data?.data
        // Process the selected audio file (audioUri)
    }
    super.onActivityResult(requestCode, resultCode, data)
}
```

#### **Fetching Location with FusedLocationProviderClient**:
```kotlin
private lateinit var fusedLocationClient: FusedLocationProviderClient

private fun getLocation() {
    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
        // Got last known location, use location.latitude and location.longitude
    }
}
```

#### **Playing Audio with MediaPlayer**:
```kotlin
private var mediaPlayer: MediaPlayer? = null

private fun playAudio(audioFilePath: String) {
    mediaPlayer = MediaPlayer().apply {
        setDataSource(audioFilePath)
        prepare()
        start()
    }
}

override fun onDestroy() {
    mediaPlayer?.release()
    mediaPlayer = null
    super.onDestroy()
}
