#### **Optional Questions:**

1. Which class is used to play audio files in Android?
   - a) `AudioPlayer`
   - b) `MediaRecorder`
   - c) `MediaPlayer`
   - d) `AudioRecorder`
   - e) `VideoView`

2. What is the purpose of `VideoView` in Android?
   - a) To display and play audio files
   - b) To capture videos from the camera
   - c) To play video content
   - d) To stream live video
   - e) None of the above

3. How do you capture images using the camera in Android?
   - a) Using `Intent.ACTION_IMAGE_CAPTURE`
   - b) Using `Intent.ACTION_VIDEO_CAPTURE`
   - c) Using `MediaRecorder`
   - d) Using `ImageView`
   - e) None of the above

4. Which class is used for recording audio in Android?
   - a) `MediaPlayer`
   - b) `MediaRecorder`
   - c) `AudioRecorder`
   - d) `AudioCapture`
   - e) `SoundPlayer`

5. What is the role of `setVideoURI()` in `VideoView`?
   - a) To start recording video
   - b) To set the path of the video to be played
   - c) To play audio content
   - d) To control audio playback
   - e) None of the above

---

#### **True/False Questions:**

1. `MediaPlayer` is used for both playing and recording audio. 
2. The `VideoView` class requires a `MediaController` to play videos. 
3. You need runtime permissions to access the device's microphone or camera. 
4. The `MediaRecorder` class can be used to capture both audio and video. 
5. `ImageView` is used to capture images from the camera in Android. 

---

#### **Short Answer Questions:**

1. What is the purpose of `MediaPlayer` in Android?
2. How do you display and play a video in an Android app using `VideoView`?
3. Explain the process of capturing images using the camera in Android.
4. What permissions are required to record audio in an Android app?
5. How can you play an audio file stored in the device’s raw resource directory?

---

#### **Code Fix Questions:**

1. **Incorrect code:**
   ```kotlin
   val mediaPlayer = MediaPlayer()
   mediaPlayer.setAudioSource("audio.mp3")
   mediaPlayer.start()
   ```
   **Fix the code to correctly load and play an audio file using `MediaPlayer`.**

2. **Incorrect code:**
   ```kotlin
   val videoView: VideoView = findViewById(R.id.videoView)
   videoView.setVideoPath("video.mp4")
   videoView.play()
   ```
   **Fix the code to correctly set and start video playback in a `VideoView`.**

3. **Incorrect code:**
   ```kotlin
   val intent = Intent(MediaRecorder.ACTION_IMAGE_CAPTURE)
   startActivityForResult(intent, 1)
   ```
   **Fix the code to correctly capture an image using the camera intent.**

---

### Project: Implementing Multimedia Features in an Android App

#### **Project Overview:**
Create an Android app that plays an audio file, displays a video, and allows the user to capture and display an image using the device’s camera.

---


#### **Task : Play Video using `VideoView`**
**Expectation:**
- Implement video playback using `VideoView`.
- Allow the user to load and play a video stored in the app’s resources.

**Step Details:**
1. Add a video file (e.g., `.mp4`) to the `res/raw` directory of your project.
2. In your activity, add a `VideoView` component to the layout.
3. Set the video source using `setVideoURI()` or `setVideoPath()`.
4. Add controls for the user to play and pause the video (using `MediaController` if necessary).
5. Ensure that the video starts and stops properly when the controls are used.

**Expected Outcome:**
- The user can play the video and control playback (play/pause) through the provided UI controls.

---


