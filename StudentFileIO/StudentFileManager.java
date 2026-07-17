import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * StudentFileManager class - Handles all file I/O operations
 * Implements methods to write and read student information
 */
public class StudentFileManager {

    private String resolvePath(String path) {
        if (path == null || path.trim().isEmpty()) {
            return "";
        }

        String trimmedPath = path.trim();
        File inputFile = new File(trimmedPath);
        if (inputFile.isAbsolute()) {
            return inputFile.getPath();
        }

        File currentDir = new File(System.getProperty("user.dir")).getAbsoluteFile();
        if (currentDir.getName().equals("StudentFileIO")) {
            return new File(currentDir, trimmedPath).getPath();
        }

        File preferredFile = new File(currentDir, "StudentFileIO" + File.separator + trimmedPath);
        return preferredFile.getPath();
    }

    /**
     * Function 1: Write content to file
     * @param path File path where content will be written
     * @param content The content to write to the file
     * @return true if writing is successful, false otherwise
     */
    public boolean writeFile(String path, String content) {
        if (path == null || path.trim().isEmpty()) {
            System.err.println("File path cannot be empty.");
            return false;
        }

        try {
            String resolvedPath = resolvePath(path);
            File file = new File(resolvedPath);
            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fileWriter = new FileWriter(file, false);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(content == null ? "" : content);
            }

            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Function 2: Read file content
     * @param path File path from which content will be read
     * @return The content of the file, or null if reading failed
     */
    public String readFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            System.err.println("File path cannot be empty.");
            return null;
        }

        StringBuilder content = new StringBuilder();
        try {
            String resolvedPath = resolvePath(path);
            File file = new File(resolvedPath);

            if (!file.exists()) {
                System.err.println("File not found: " + path);
                return null;
            }

            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }

            return content.toString();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Helper method to append content to existing file
     * @param path File path
     * @param content Content to append
     * @return true if successful, false otherwise
     */
    public boolean appendToFile(String path, String content) {
        if (path == null || path.trim().isEmpty()) {
            System.err.println("File path cannot be empty.");
            return false;
        }

        try {
            String resolvedPath = resolvePath(path);
            File file = new File(resolvedPath);
            try (FileWriter fileWriter = new FileWriter(file, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.append(content == null ? "" : content).append("\n");
            }

            return true;
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
            return false;
        }
    }
}
