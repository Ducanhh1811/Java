import java.util.Scanner;

/**
 * StudentManagementProgram class - Main program with user interface
 * Handles user interaction and orchestrates file operations
 * Follows OOP principles with clear separation of concerns
 */
public class StudentManagementProgram {
    private StudentFileManager fileManager;
    private Scanner scanner;

    // Constructor
    public StudentManagementProgram() {
        this.fileManager = new StudentFileManager();
        this.scanner = new Scanner(System.in);
    }

    private String repeatLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }

    /**
     * Main entry point of the program
     * Implements Function 1 (write) and Function 2 (read)
     */
    public void run() {
        displayWelcomeMessage();

        // Function 1: Ask if user wants to write to file
        if (askForFileWriting()) {
            performFileWriting();
        }

        // Function 2: Ask if user wants to read from file
        if (askForFileReading()) {
            performFileReading();
        } else {
            displayExitMessage();
        }

        scanner.close();
    }

    /**
     * Ask user if they want to write to file
     * @return true if yes, false if no
     */
    private boolean askForFileWriting() {
        System.out.println("\n" + repeatLine('=', 50));
        System.out.println("FUNCTION 1: WRITE DATA TO FILE");
        System.out.println(repeatLine('=', 50));
        return askYesNo("Do you want to write student data to a file? (yes/no): ");
    }

    /**
     * Perform file writing operation
     */
    private void performFileWriting() {
        System.out.print("\nEnter file path (e.g., students.txt): ");
        String filePath = scanner.nextLine().trim();

        // Collect student data
        String studentData = collectStudentData();

        if (studentData != null && !studentData.isEmpty()) {
            boolean success = fileManager.writeFile(filePath, studentData);
            if (success) {
                System.out.println("✓ Data successfully written to file: " + filePath);
            } else {
                System.out.println("✗ Failed to write data to file.");
            }
        }
    }

    /**
     * Collect student information from user input
     * @return String with formatted student data
     */
    private String collectStudentData() {
        StringBuilder data = new StringBuilder();
        System.out.println("\n--- Enter Student Information ---");
        System.out.print("How many students do you want to enter? ");

        try {
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= count; i++) {
                System.out.println("\nStudent " + i + ":");
                System.out.print("  ID: ");
                String id = scanner.nextLine().trim();

                System.out.print("  Name: ");
                String name = scanner.nextLine().trim();

                System.out.print("  GPA: ");
                double gpa = Double.parseDouble(scanner.nextLine());

                System.out.print("  Major: ");
                String major = scanner.nextLine().trim();

                Student student = new Student(id, name, gpa, major);
                data.append(student.toFileFormat()).append("\n");
            }

            return data.toString();
        } catch (NumberFormatException e) {
            System.err.println("Invalid input format!");
            return null;
        }
    }

    /**
     * Ask user if they want to read from file
     * @return true if yes, false if no
     */
    private boolean askForFileReading() {
        System.out.println("\n" + repeatLine('=', 50));
        System.out.println("FUNCTION 2: READ DATA FROM FILE");
        System.out.println(repeatLine('=', 50));
        return askYesNo("Do you want to read student data from a file? (yes/no): ");
    }

    private boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes") || response.equals("y")) {
                return true;
            }
            if (response.equals("no") || response.equals("n")) {
                return false;
            }
            System.out.println("Please enter yes or no.");
        }
    }

    /**
     * Perform file reading operation
     */
    private void performFileReading() {
        System.out.print("\nEnter file path to read (e.g., students.txt): ");
        String filePath = scanner.nextLine().trim();

        String content = fileManager.readFile(filePath);

        if (content != null && !content.isEmpty()) {
            displayStudentData(content);
        } else {
            System.out.println("✗ Failed to read file or file is empty.");
        }

        displayExitMessage();
    }

    /**
     * Display student data from file in formatted way
     * @param content Raw content from file
     */
    private void displayStudentData(String content) {
        System.out.println("\n" + repeatLine('=', 50));
        System.out.println("STUDENT DATA FROM FILE");
        System.out.println(repeatLine('=', 50));
        System.out.println(String.format("%-10s | %-20s | %-6s | %-20s", "ID", "Name", "GPA", "Major"));
        System.out.println(repeatLine('-', 60));

        String[] lines = content.split("\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.println(String.format("%-10s | %-20s | %-6s | %-20s",
                            parts[0], parts[1], parts[2], parts[3]));
                }
            }
        }
        System.out.println(repeatLine('-', 60));
    }

    /**
     * Display welcome message
     */
    private void displayWelcomeMessage() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║     STUDENT INFORMATION MANAGEMENT SYSTEM      ║");
        System.out.println("║              File I/O Operations               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    /**
     * Display exit message
     */
    private void displayExitMessage() {
        System.out.println("\n" + repeatLine('=', 50));
        System.out.println("Thank you for using Student Management System!");
        System.out.println("Program is exiting...");
        System.out.println(repeatLine('=', 50) + "\n");
    }

    /**
     * Main method - Entry point of the program
     */
    public static void main(String[] args) {
        StudentManagementProgram program = new StudentManagementProgram();
        program.run();
    }
}
