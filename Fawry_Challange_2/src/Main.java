//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inventory store = new Inventory();


        store.addBook(new PaperBook("ISBN001", "A Game of Thrones", 1996, 50.0F, "George Raymond Richard", 100));
        store.addBook(new Ebook("ISBN002", "Fire & Blood", 2018, 100.0F, "George Raymond Richard", "PDF"));
        store.addBook(new ShowcaseBook("ISBN003", "The Winds of Winter", 0, 0.0F, "George Raymond Richard"));

        store.buyBook("ISBN001", 2, "user@example.com", "Banha, Egypt");
        store.buyBook("ISBN002", 1, "user@example.com", null);

        store.removeOutdatedBook("ISBN003", 5);

        try {
            store.buyBook("ISBN003", 1, "user@example.com", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}