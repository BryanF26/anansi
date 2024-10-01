### 10. **Advanced Hotel Room Booking System**

#### Repository Setup:

- **Repository Name**: `hotel-booking-system`
- **Folder Structure**:
  - `src/` directory for Kotlin source files.
  - Files to create:
    - `Main.kt` for CLI logic.
    - `Room.kt` for hotel room data.
    - `Booking.kt` for handling bookings.
    - `Customer.kt` for customer information.
    - `HotelManager.kt` for managing rooms and bookings.

#### Fields Required:

- **Room**:

  - `id` (Int)
  - `type` (String, values: "Single", "Double", "Suite")
  - `ratePerNight` (Double, must be positive)
  - `availability` (Map<LocalDate, Boolean>, track room availability by date)
  - `amenities` (List of String, e.g., "Wi-Fi", "AC", "TV")

- **Booking**:

  - `id` (Int)
  - `room` (Room)
  - `customer` (Customer)
  - `checkInDate` (LocalDate)
  - `checkOutDate` (LocalDate)
  - `totalPrice` (Double, auto-calculated)

- **Customer**:
  - `id` (Int)
  - `name` (String, non-empty)
  - `phone` (String, non-empty, valid format)
  - `email` (String, must contain "@" and be non-empty)

#### Features:

1. **Add New Room**:

   - Allows hotel managers to add new rooms to the system. Each room has a type, rate per night, and a list of amenities.

2. **Book Room**:

   - Allows customers to book rooms for a specific date range. The system checks availability across multiple days and reserves the room if it’s available.

3. **Cancel Booking**:

   - Cancel a customer’s booking and free up the room for the corresponding dates.

4. **Room Availability Checker**:

   - Allows users to check room availability for a specific date range and view room types and amenities.

5. **Price Calculation**:

   - Automatically calculate the total price based on the number of nights booked and the room rate. Optionally, include an additional charge for special amenities.

6. **Apply Discount**:
   - Implement business logic to apply discounts for long-term stays (e.g., 10% off for bookings longer than 7 days).

#### Validation:

- **Dates**: Ensure the check-in date is before the check-out date, and that the room is available for the entire date range.
- **Customer Email**: Ensure valid email format.
- **Room Availability**: Check that the room is available on all requested dates.

---

### 11. **Fitness Class Scheduling and Membership Management System**

#### Repository Setup:

- **Repository Name**: `fitness-class-scheduling`
- **Folder Structure**:
  - `src/` directory for Kotlin source files.
  - Files to create:
    - `Main.kt` for CLI logic.
    - `Member.kt` for gym member data.
    - `FitnessClass.kt` for scheduling fitness classes.
    - `FitnessCenterManager.kt` for managing class enrollment and memberships.

#### Fields Required:

- **Member**:

  - `id` (Int)
  - `name` (String, non-empty)
  - `membershipType` (String, values: "Basic", "Premium", "VIP")
  - `subscriptionStartDate` (LocalDate)
  - `subscriptionEndDate` (LocalDate)
  - `attendedClasses` (List of FitnessClass)

- **FitnessClass**:
  - `id` (Int)
  - `name` (String, non-empty)
  - `instructor` (String, non-empty)
  - `date` (LocalDate)
  - `time` (LocalTime)
  - `duration` (Int, in minutes)
  - `maxParticipants` (Int, limit on attendees)
  - `enrolledMembers` (List of Members)

#### Features:

1. **Register Member**:

   - Register new gym members with different membership tiers, each with different privileges for attending classes.

2. **Schedule Fitness Classes**:

   - Schedule classes with an instructor, date, time, and duration. Set participant limits for each class.

3. **Enroll in Class**:

   - Allow members to enroll in fitness classes based on membership privileges. Only premium or VIP members may have access to special classes.

4. **Class Attendance Tracking**:

   - Track how many classes a member has attended. For VIP members, keep track of exclusive classes.

5. **Membership Renewal**:

   - Notify members when their membership is about to expire and allow renewal. Membership benefits adjust based on renewal time (e.g., early renewal benefits).

6. **List Classes by Date**:
   - View available fitness classes by range of dates. Include information on the number of available spots.

#### Validation:

- **Date and Time**: Ensure class scheduling does not overlap with other classes.
- **Membership Type**: Ensure that the member is only enrolling in classes their membership tier allows.
- **Class Capacity**: Ensure that the number of enrolled participants does not exceed the class limit.

---

### 12. **Freelancer Task and Time Management System**

#### Repository Setup:

- **Repository Name**: `freelancer-task-time-management`
- **Folder Structure**:
  - `src/` directory for Kotlin source files.
  - Files to create:
    - `Main.kt` for CLI logic.
    - `Freelancer.kt` for freelancer information.
    - `Project.kt` for project management.
    - `Task.kt` for task tracking.
    - `ProjectManager.kt` for managing projects and assigning tasks.

#### Fields Required:

- **Freelancer**:

  - `id` (Int)
  - `name` (String, non-empty)
  - `hourlyRate` (Double, must be positive)
  - `assignedTasks` (List of Task)

- **Project**:

  - `id` (Int)
  - `name` (String, non-empty)
  - `client` (String, non-empty)
  - `deadline` (LocalDate)
  - `tasks` (List of Task)
  - `totalBudget` (Double, calculated based on task hours)

- **Task**:
  - `id` (Int)
  - `description` (String, non-empty)
  - `freelancer` (Freelancer, assigned freelancer)
  - `estimatedHours` (Int, positive number)
  - `actualHours` (Int, track hours worked)
  - `status` (String, values: "Not Started", "In Progress", "Completed")

#### Features:

1. **Add Freelancer**:

   - Register freelancers with their hourly rates and assign them to projects.

2. **Create Project**:

   - Create new projects with a deadline and assign tasks to freelancers. Each task should have an estimated number of hours.

3. **Log Hours Worked**:

   - Allow freelancers to log the hours they’ve worked on each task. Update the project’s progress based on task completion.

4. **Task Status Tracking**:

   - Track the status of each task (Not Started, In Progress, Completed). Calculate progress for the entire project based on task status.

5. **Estimate vs. Actual Hours**:

   - Compare estimated task hours against actual hours logged. This can help freelancers and project managers track project efficiency.

6. **Budget Calculation**:
   - Automatically calculate the project’s budget based on the hours worked by each freelancer and their hourly rate.

#### Validation:

- **Task Hours**: Ensure that the hours logged are realistic and do not exceed the estimated hours too drastically.
- **Task Status**: Ensure tasks cannot be marked as "Completed" without having logged hours.
- **Budget Accuracy**: Keep the budget calculation dynamic based on updated hours worked.
