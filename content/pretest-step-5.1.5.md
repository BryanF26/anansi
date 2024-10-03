

### 1. **Create `MainActivity` and `SecondActivity`**
   - Make two activities: `MainActivity` (the starting activity) and `SecondActivity` (the one that returns a result).

### 2. **Start `SecondActivity` from `MainActivity`**
   - In `MainActivity`, use a button to open `SecondActivity` and get a result back.
   - **Use the modern method:**
     - Use `registerForActivityResult()` or `startActivityForResult()` method.

### 3. **Return a Result from `SecondActivity`**
   - In `SecondActivity`, send data back to `MainActivity` using `setResult()` with an `Intent`.
   - This data can be anything simple, like a message.

### 4. **Handle the Result in `MainActivity`**
   - In `MainActivity`, use a callback to receive the result and display it.
   - Show the result using a `Toast` message or set it in a `TextView`.

