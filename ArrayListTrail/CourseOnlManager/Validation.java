package CourseOnlManager;

public class Validation {
    public static String validId(String id){
        if(id.isEmpty() || id == null){
            throw new IllegalArgumentException("Id cannot be empty.");
        }
        return id.trim();
    }

    public static String validName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        return name.trim();
    }

    public static String validInstructor(String instructor){
        if(instructor == null || instructor.isEmpty()){
            throw new IllegalArgumentException("Instructor cannot be empty.");
        }
        return instructor.trim();
    }

    public static double validPrice(String priceStr){
        if(priceStr == null || priceStr.isEmpty()){
            throw new IllegalArgumentException("Price cannot be empty.");
        }
        try{
            double price = Double.parseDouble(priceStr.trim());
            if(price <= 0){
                throw new IllegalArgumentException("Price must be greater than 0");
            }
            return price;
        }catch(NumberFormatException n){
            throw new IllegalArgumentException("Price must be a valid double.");
        }
    }

    public static int validEnrolls(String enrolledStr){
        if(enrolledStr.isEmpty() || enrolledStr == null){
            throw new IllegalArgumentException("Enrolled Students cannot beb empty.");
        }
        try{
            int enrolled = Integer.parseInt(enrolledStr.trim());
            if(enrolled < 0){
                throw new IllegalArgumentException("Enrolled Students must be > 0");
            }
            return enrolled;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Enrolled Students must be a valid Integer.");
        }
    }
}
