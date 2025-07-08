public class ShowcaseBook extends Book{
    public ShowcaseBook(String ISBN , String title , int year , float price , String author) {

        super(ISBN , title , year , 0.0F, author);
    }

    @Override
    public void buy(int quantity, String email, String address) {
        throw new UnsupportedOperationException("This Book Only For Showcase/Demo Only...");
    }
}
