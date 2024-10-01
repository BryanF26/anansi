
### **1. Calculator App**

**Objective**: Create a simple calculator app that performs basic arithmetic operations like addition, subtraction, multiplication, and division.

#### Requirements:
- **Input**: Two number inputs using `EditText`.
- **Operations**: Provide buttons for each arithmetic operation (+, -, *, /).
- **Output**: Display the result of the selected operation in a `TextView`.
  
#### Instructions:
- Use two `EditText` fields to input numbers.
- Create four buttons: `Add`, `Subtract`, `Multiply`, and `Divide`.
- When the user presses a button, the app should calculate the result and display it in a `TextView`.
- Handle error cases, such as division by zero.

---

### **2. Temperature Converter App**

**Objective**: Create an app that converts temperature between Celsius and Fahrenheit.

#### Requirements:
- **Input**: One `EditText` for the temperature input.
- **Conversion Options**: Provide two buttons, one to convert from Celsius to Fahrenheit and another to convert from Fahrenheit to Celsius.
- **Output**: Display the converted temperature in a `TextView`.

#### Instructions:
- Create an `EditText` where the user inputs a temperature.
- Add two buttons: `Convert to Celsius` and `Convert to Fahrenheit`.
- When a button is clicked, calculate the result and show it in a `TextView`.
  
**Conversion formulas**:
- Fahrenheit to Celsius: `(F - 32) * 5/9`
- Celsius to Fahrenheit: `(C * 9/5) + 32`

---

### **3. Simple Tip Calculator App**

**Objective**: Create an app that calculates the tip amount and total cost based on the user input.

#### Requirements:
- **Input**: One `EditText` for the total bill amount.
- **Tip Selection**: Provide three buttons to choose a tip percentage: 10%, 15%, and 20%.
- **Output**: Display the tip amount and the total cost after including the tip.

#### Instructions:
- Add an `EditText` for the bill amount input.
- Create three buttons: `10% Tip`, `15% Tip`, `20% Tip`.
- When the user selects a tip percentage, the app should calculate the tip and total amount and display them in a `TextView`.
- Handle edge cases like empty input.

---

### **4. BMI Calculator App**

**Objective**: Create a BMI (Body Mass Index) calculator that calculates the BMI based on user input for weight and height.

#### Requirements:
- **Input**: Two `EditText` fields for height (in meters) and weight (in kilograms).
- **Output**: Display the calculated BMI in a `TextView`.
- **Bonus**: Display the BMI category (Underweight, Normal, Overweight, Obese).

#### Instructions:
- Add two `EditText` fields to input height and weight.
- Add a button to calculate BMI.
- When the button is clicked, calculate BMI and display the result in a `TextView`.
- Formula: `BMI = weight / (height * height)`
- Optionally, display the BMI category based on the result.

---

### **5. Currency Converter App**

**Objective**: Create an app that converts between two currencies (e.g., USD to EUR and EUR to USD).

#### Requirements:
- **Input**: One `EditText` for the amount.
- **Conversion Options**: Provide two buttons for conversion, one to convert USD to EUR and another to convert EUR to USD.
- **Output**: Display the converted amount in a `TextView`.
- **Bonus**: Allow the user to select the conversion rate.

#### Instructions:
- Create an `EditText` for the input amount.
- Add two buttons: `Convert to EUR` and `Convert to USD`.
- Use a predefined conversion rate (e.g., 1 USD = 0.85 EUR, 1 EUR = 1.18 USD).
- Calculate the result and show it in a `TextView`.

---

### **6. Distance Converter App**

**Objective**: Create an app that converts between kilometers and miles.

#### Requirements:
- **Input**: One `EditText` for the distance input.
- **Conversion Options**: Provide two buttons, one to convert from kilometers to miles and another to convert from miles to kilometers.
- **Output**: Display the converted distance in a `TextView`.

#### Instructions:
- Create an `EditText` for the user to input a distance.
- Add two buttons: `Convert to Miles` and `Convert to Kilometers`.
- Formula:
  - Kilometers to Miles: `km * 0.621371`
  - Miles to Kilometers: `mi / 0.621371`
- Show the result in a `TextView`.

---

### **7. Age Calculator App**

**Objective**: Create an app that calculates the user’s age based on their birth year.

#### Requirements:
- **Input**: One `EditText` for the birth year.
- **Output**: Display the user's age in a `TextView`.

#### Instructions:
- Add an `EditText` for the user to input their birth year.
- Create a button `Calculate Age`.
- When the user clicks the button, calculate the age by subtracting the birth year from the current year.
- Display the result in a `TextView`.

---

### **8. Loan EMI Calculator App**

**Objective**: Create an app that calculates the monthly EMI (Equated Monthly Installment) for a loan.

#### Requirements:
- **Input**: Three `EditText` fields for loan amount, interest rate, and loan tenure (in months).
- **Output**: Display the EMI in a `TextView`.

#### Instructions:
- Add `EditText` fields to input the loan amount, interest rate, and tenure.
- Create a button `Calculate EMI`.
- Use the formula:
  \[
  EMI = \frac{P \times r \times (1 + r)^n}{(1 + r)^n - 1}
  \]
  where `P` is the loan amount, `r` is the monthly interest rate (annual interest rate divided by 12), and `n` is the tenure in months.
- Display the result in a `TextView`.

