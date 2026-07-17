package ManagerSubject;

public class Subject {
    private String subject;

    public Subject() {
    }

    public Subject(String subject) {
        setSubject(subject);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot empty");
        }
        this.subject = subject;
    }

    @Override
    public String toString() {
        return subject;
    }

}
