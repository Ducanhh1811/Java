package ManagerSubject;

// 1. Add subject
// 2. Display subjects
// 3. Search subject
// 4. Remove subject
// 5. Exit

import java.util.ArrayList;

public class Manager {
    private ArrayList<Subject> subjects;

    public Manager(){
        subjects = new ArrayList<>();
    }

    public ArrayList<Subject> getArray(){
        return subjects;
    }

    public void addSubject(Subject s){
        subjects.add(s);
    }

    public void display(){
        for (Subject s : subjects) {
            System.out.println(s);
        }
    }

    public int search(String input){
        for(int i = 0; i < subjects.size(); i++){
            if(subjects.get(i).getSubject().equals(input)){
                return i;
            }
        }
        return -1;
    }

    public void removeSubject(String input){
        int index = search(input);
        if(index >= 0){
            subjects.remove(index);
        }
    }

    public void searchName(String input){
        int index = search(input);
        if(index == -1){
            System.out.println("Subject not found.");
        }else{
            System.out.println("Found at position: " + (index + 1));
        }
    }
}
