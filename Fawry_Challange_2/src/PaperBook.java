public class PaperBook extends Book {
    private int stock;
    public PaperBook(String ISBN , String title , int year , float price , String author , int stock){
        super(ISBN , title , year , price , author);
        this.stock = stock;
    }


    @Override
    public void buy(int quantity, String email, String address) {
        if (this.stock < quantity) {
            throw new IllegalArgumentException("stock is not enough for ISBN " + this.ISBN);
        }
        this.stock -= quantity;
        System.out.println("You Bought " + quantity + " paper books, totla" + (this.price * quantity));
        System.out.println("Shipping to address " + address + " ....");
    }
}