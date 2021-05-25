package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class TodosPojo {
    private int UserId;
    private String Title;
    private boolean isCompleted;
     //2)CREATE ALL GETTER AND SETTERS
    public int getUserId() {
        return UserId;
    }

    public String getTitle() {
        return Title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
    //3)create constructors with parameter and non-parameter


    public TodosPojo() {
    }

    public TodosPojo(int userId, String title, boolean isCompleted) {
        this.UserId= userId;
        this.Title = title;
        this.isCompleted = isCompleted;
    }
    //5)create toString()


    @Override
    public String toString() {
        return "TodosPojo{" +
                "UserId=" + UserId +
                ", Title='" + Title + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}