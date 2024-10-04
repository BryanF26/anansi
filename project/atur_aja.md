### **Aplikasi Pengelola Keuangan Pribadi - Updated Requirements and Tasks**
team 1

### **Project Overview:**
This app helps users track their daily expenses, provides an overview of monthly spending, and requires users to log in or register using an API. It consists of fragments to display the current balance, a pie chart of expenses, view expense history, and an activity to add new expenses. 

### **Fragments and Activity Overview:**

#### **1. Login and Registration:**
- **Login Page**: Allows users to log in using email and password.
- **Registration Page**: New users can sign up with their email, password, and other basic information.
- Upon successful login, users are directed to the **Home Fragment**.

#### **2. Fragment Home:**
- Displays:
  - **Current Balance**: The total balance after accounting for expenses.
  - **Pie Chart of Expenses**: Visual representation of spending across different categories (e.g., food, transportation, entertainment, etc.).

#### **3. Fragment History:**
- Displays a list of past expenses:
  - **Amount**: The amount spent.
  - **Category**: The category of the expense (e.g., food, transportation, etc.).
  - **Date**: The date of the expense.
  - **Description/Notes**: A short note or description of the expense.

#### **4. Activity Menambah Pengeluaran (Add Expense Activity):**
- A form for adding new expenses:
  - **Amount**: Input field for the expense amount.
  - **Category**: Dropdown or list of categories (e.g., food, transportation, bills, etc.).
  - **Description/Notes**: Optional field to add a note or description of the expense.
  - **Submit Button**: Save the new expense and update the history and balance.

---

### **Feature Details:**

#### **1. API for User Authentication:**
You can use a public API like **Reqres** for login and registration, which will handle user authentication.

- **API Link**: [Reqres API](https://reqres.in/)
- **Endpoints**:
  - **Login**:
    ```bash
    POST https://reqres.in/api/login
    Body:
    {
      "email": "eve.holt@reqres.in",
      "password": "cityslicka"
    }
    ```
    Response:
    ```json
    {
      "token": "QpwL5tke4Pnpja7X4"
    }
    ```

  - **Register**:
    ```bash
    POST https://reqres.in/api/register
    Body:
    {
      "email": "eve.holt@reqres.in",
      "password": "pistol"
    }
    ```
    Response:
    ```json
    {
      "id": "4",
      "token": "QpwL5tke4Pnpja7X4"
    }
    ```

#### **2. Current Balance Calculation:**
- The **Current Balance** is calculated by subtracting the total of all expenses from a predefined starting balance (e.g., the user’s total monthly budget).
- Display the balance at the top of the **Home Fragment**.

#### **3. Pie Chart of Expenses:**
- Use a pie chart to visually represent the distribution of expenses by category.
- The chart will update dynamically as new expenses are added.

#### **4. Expense History (Riwayat Pengeluaran):**
- Display a list of all past expenses in the **History Fragment**.
- Each entry should display:
  - **Amount**
  - **Category**
  - **Date**
  - **Description/Notes**

#### **5. Adding New Expenses (Menambah Pengeluaran):**
- In the **Add Expense Activity**, the user will input:
  - **Amount**
  - **Category**
  - **Description/Notes**
- The new expense will be added to the history, and the balance and pie chart will update accordingly.

---

### **Tasks Breakdown:**

#### **1. Login and Registration:**
**Tasks**:
- **Task 1: Create Login UI**:
  - Design a login page with email and password fields.
  
- **Task 2: Implement Login via API**:
  - Use **Reqres API** for authentication.
  - Store the token in `SharedPreferences` for maintaining the user session.
  
- **Task 3: Create Registration UI**:
  - Design a registration page for new users.
  
- **Task 4: Implement Registration via API**:
  - Use **Reqres API** for registering new users.

#### **2. Fragment Home:**
**Tasks**:
- **Task 5: Display Current Balance**:
  - Calculate and display the user’s current balance after subtracting expenses from a starting amount.

- **Task 6: Display Pie Chart of Expenses**:
  - Use a charting library (like MPAndroidChart) to display the distribution of expenses by category.

#### **3. Fragment History:**
**Tasks**:
- **Task 7: Display Expense History**:
  - Use a `RecyclerView` to display a list of past expenses, showing the amount, category, date, and optional description.

#### **4. Activity Menambah Pengeluaran (Add Expense Activity):**
**Tasks**:
- **Task 8: Create Expense Form**:
  - Create input fields for:
    - **Amount**
    - **Category**
    - **Description**
  
- **Task 9: Save Expense**:
  - When the user submits the form, save the new expense to local storage.
  - Update the **current balance** and the **pie chart** on the Home Fragment.
  - Add the new expense to the **History Fragment**.

---

### **Code Snippets:**

#### **Login and Registration via Reqres API:**

**Login API Call**:
```kotlin
fun loginUser(email: String, password: String) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(UserApiService::class.java)

    val call = api.loginUser(LoginRequest(email, password))
    call.enqueue(object : Callback<LoginResponse> {
        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            if (response.isSuccessful) {
                val token = response.body()?.token
                // Save token in SharedPreferences and proceed to Home Fragment
            }
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            // Handle error
        }
    })
}

interface UserApiService {
    @POST("api/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>
}

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String)
```

**Registration API Call**:
```kotlin
fun registerUser(email: String, password: String) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(UserApiService::class.java)

    val call = api.registerUser(RegisterRequest(email, password))
    call.enqueue(object : Callback<RegisterResponse> {
        override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
            if (response.isSuccessful) {
                val token = response.body()?.token
                // Save token in SharedPreferences and proceed to Home Fragment
            }
        }

        override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
            // Handle error
        }
    })
}

data class RegisterRequest(val email: String, val password: String)
data class RegisterResponse(val id: String, val token: String)
```

