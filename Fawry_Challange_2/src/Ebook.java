public class Ebook extends Book {
    private  String fileType;

    public Ebook(String ISBN , String title , int year , float price , String author , String fileType) {
        super(ISBN , title , year , price, author);
        this.fileType = fileType;

    }

    @Override
    public void buy(int quantity, String email, String address) {
        System.out.println("You Bought " + quantity + " eBooks , total: " + (this.price * quantity));
        System.out.println("You Bought " + email);
    }
}