### 1. **Advanced Ticketing System**

#### Repository Setup:

- **Repository Name**: `advanced-ticketing-system`
- **Folder Structure**:
  - `src/` directory for Kotlin source files.
  - Files to create:
    - `Main.kt` for CLI logic.
    - `Ticket.kt` for the ticket object model.
    - `TicketManager.kt` to handle the logic.
    - `User.kt` for user management.

#### Fields Required:

- **Ticket**:

  - `id` (Int)
  - `description` (String, non-empty)
  - `priority` (String, values: "Low", "Medium", "High")
  - `status` (String, values: "Open", "In Progress", "Closed")
  - `assignee` (User, nullable)
  - `dueDate` (LocalDate, nullable)

- **User**:
  - `id` (Int)
  - `name` (String, non-empty)
  - `role` (String, values: "User", "Admin")

#### Features:

1. **Create Ticket**:
   - Allows the user to create a new ticket with a description and priority. Ensure that the description is not empty and the priority is valid.
2. **Assign User**:

   - Assign an existing user to a ticket. Validate that the ticket and user exist.

3. **Update Ticket Status**:

   - Change the status of a ticket. Ensure only valid statuses are used and the ticket exists.

4. **Set Due Date**:

   - Assign a due date to the ticket, ensuring valid date format (`YYYY-MM-DD`).

5. **View Tickets**:

   - Display all tickets with their current details (status, assignee, due date).

6. **Search Ticket by ID**:
   - Allow searching for a specific ticket by its ID.

#### Validation:

- **Description**: Must not be empty.
- **Priority**: Must be one of the allowed values.
- **Status**: Must be one of the allowed statuses.
- **Due Date**: Must follow the `YYYY-MM-DD` format.

---

### 2. **Project Management System**

#### Repository Setup:

- **Repository Name**: `project-management-system`
- **Folder Structure**:
  - `src/` directory for source files.
  - Files to create:
    - `Main.kt` for CLI logic.
    - `Project.kt` for project data model.
    - `Task.kt` for tasks within projects.
    - `ProjectManager.kt` for managing projects and tasks.
    - `User.kt` for team member assignment.

#### Fields Required:

- **Project**:

  - `id` (Int)
  - `name` (String, non-empty)
  - `deadline` (LocalDate)
  - `status` (String, values: "Active", "Completed", "On Hold")
  - `tasks` (List of Task objects)

- **Task**:

  - `id` (Int)
  - `description` (String, non-empty)
  - `priority` (String, values: "Low", "Medium", "High")
  - `assignedTo` (User, nullable)
  - `status` (String, values: "Not Started", "In Progress", "Completed")
  - `dueDate` (LocalDate, nullable)

- **User**:
  - `id` (Int)
  - `name` (String, non-empty)
  - `role` (String, values: "Manager", "Developer", "Tester")

#### Features:

1. **Create Project**:
   - Allow the creation of a new project with a name and deadline. Validate that the name is not empty and the deadline follows the `YYYY-MM-DD` format.
2. **Add Task to Project**:

   - Add tasks to a project. Each task must have a description, priority, and due date.

3. **Assign Task**:

   - Assign a team member to a task. Ensure that tasks are assigned only to existing users.

4. **Update Task Status**:

   - Change the status of a task within the project. Only valid statuses should be allowed.

5. **Project Status Tracking**:
   - Automatically change the project status to "Completed" if all tasks are completed.

#### Validation:

- **Project Name**: Must not be empty.
- **Task Description**: Must not be empty.
- **Task Priority**: Must be one of the allowed values.
- **Task Status**: Must be one of the allowed statuses.
- **Dates**: Must be in `YYYY-MM-DD` format.

---

### 3. **Library Management System**

#### Repository Setup:

- **Repository Name**: `library-management-system`
- **Folder Structure**:
  - `src/` directory for source files.
  - Files to create:
    - `Main.kt` for CLI logic.
    - `Book.kt` for book data.
    - `Member.kt` for member management.
    - `LibraryManager.kt` for book and member handling.

#### Fields Required:

- **Book**:

  - `id` (Int)
  - `title` (String, non-empty)
  - `author` (String, non-empty)
  - `genre` (String)
  - `status` (String, values: "Available", "Borrowed")

- **Member**:
  - `id` (Int)
  - `name` (String, non-empty)
  - `membershipType` (String, values: "Standard", "Premium")

#### Features:

1. **Add Book**:

   - Add new books to the library. Ensure that each book has a title, author, and genre.

2. **Borrow Book**:

   - Allow members to borrow books. The system must update the book’s status to "Borrowed" and track which member borrowed it.

3. **Return Book**:

   - Update the status of a borrowed book to "Available" when returned.

4. **List Available Books**:

   - Show a list of books that are currently available.

5. **Member Management**:
   - Add or remove members. Manage different membership types.

#### Validation:

- **Book Title/Author**: Must not be empty.
- **Book Status**: Can only be "Available" or "Borrowed."
- **Member Name**: Must not be empty.

---
