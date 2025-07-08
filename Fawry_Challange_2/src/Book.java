abstract public class Book {
    protected String ISBN;
    protected String title;
    protected int year;
    protected float price;
    protected String author;

    public Book(String ISBN , String title , int year , float price , String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getISBN() {
        return this.ISBN;
    }
    public int getYear() {
        return this.year;
    }

    public abstract void buy(int quantity , String email , String address);
}