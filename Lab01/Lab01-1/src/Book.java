public class Book {
    String title;
    int pages;

    public Book(String title, int pages){
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {return title;}
    public int getPages() {return pages;}

    @Override
    public String toString() {
        return ("Book: " + title + ", # Pages = " + pages);
    }
}