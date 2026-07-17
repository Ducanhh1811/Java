package EmployeeManager;

public class Validation {
    public static String validID(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be empty.");
        }
        return id.trim();
    }

    public static String validName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        return name.trim();
    }

    public static double validSalary(String salaryStr) {
        if (salaryStr == null || salaryStr.isEmpty()) {
            throw new IllegalArgumentException("Salary cannot be empty.");
        }
        try {
            double salary = Double.parseDouble(salaryStr.trim());
            if (salary <= 0) {
                throw new IllegalArgumentException("Salary must be greater than 0.");
            }
            return salary;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Salary must be a valid double.");
        }
    }

    public static int validExperience(String exStr) {
        if (exStr == null || exStr.isEmpty()) {
            throw new IllegalArgumentException("Experience cannot be empty.");
        }
        try {
            int experience = Integer.parseInt(exStr.trim());
            if (experience < 0) {
                throw new IllegalArgumentException("Experience must be an integer greater than or equal to 0.");
            }
            return experience;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Experience must be a valid integer.");
        }
    }
}
