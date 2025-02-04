public class Textbook extends Book {
    String course;

    public Textbook(String title, int pages, String course) {
        super(title, pages);
        this.course = course;
    }

    public String getCourse() {return course;}

    @Override
    public String toString() {
        return ("Text Book: " + title + ", # Pages = " + pages  + ", Course = " + getCourse());
    }
}
