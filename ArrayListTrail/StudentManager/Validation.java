package StudentManager;

public class Validation{
    public static String validID(String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        return id.trim();
    }

    public static String validName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        return name.trim(); 
    }

    public static float validGPA(String gpaStr){
        if(gpaStr == null || gpaStr.isEmpty()){
            throw new IllegalArgumentException("Gpa cannot be empty.");
        }
        try{
            float gpa = Float.parseFloat(gpaStr.trim());
            if(gpa < 0){
                throw new IllegalArgumentException("Gpa must be a position float.");
            }
            return gpa;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Gpa must be a valid float.");
        }
    }
}