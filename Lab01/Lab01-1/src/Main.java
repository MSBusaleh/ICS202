public class Main {
    public static void main(String[] args) {
        Book[] library = new Book[10];
        library[0] = new Book("ABC", 100);
        library[1] = new Book("Arabic", 201);
        library[2] = new Textbook("Data structures, ICS-202", 225, "ICS-202");
        library[3] = new Textbook("Writing Practice, ENGL-101", 225, "ENGL-101");
        library[4] = new Textbook("Algebra, MATH-101", 893, "MATH-101");
        library[5] = new Book("Environment", 590);
        library[6] = new Book("NewYork", 449);
        library[7] = new Book("Visual C++", 999);
        library[8] = new Textbook("Logic, ICS-253", 225, "ICS-253");
        library[9] = new Textbook("Holy quran", 604, "IAS-111");

        int Books = 0;
        int TBooks = 0;
        for(Book i : library){
            System.out.println(i.toString());
            if(i instanceof Textbook){TBooks++;}
            else{Books++;}
        }

        System.out.println("Number of books = " + Books + "\nNumber of Textbooks = " + TBooks);
    }
}