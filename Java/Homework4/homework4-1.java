import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
        int count = 0;
        ArrayList<Integer> found = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int o = list.get(i) + list.get(j);
                if (list.contains(o) && !found.contains(o)) {
                    count++;
                    found.add(o);
                }
            }
        }
        System.out.println(count);
        }
    }
class Book {
    private String name;
    private String publisher;
    private ArrayList<String> authors;
    private double price;
    private int pages;
    private int currentPage;
    private HashMap<Integer, String> bookmarks;

    public Book() {}
    public Book(String name, String publisher, ArrayList<String> authors) {
        this.name = name;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Book(String name, String publisher, ArrayList<String> authors, double price, int pages, int currentPage, HashMap<Integer, String> bookmarks) {
        this.name = name;
        this.publisher = publisher;
        this.authors = authors;
        this.price = price;
        this.pages = pages;
        this.currentPage = currentPage;
        this.bookmarks = bookmarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public HashMap<Integer, String> getBookmarks() {
        return bookmarks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                ", price=" + price +
                ", pages=" + pages +
                ", currentPage=" + currentPage +
                ", bookmarks=" + bookmarks +
                '}';
    }

    void printInfo() {
        System.out.println("Name:" + name +"\nPublisher:" + publisher + "\nAuthors:" + authors);
    }

    void printInfoFull() {
        System.out.println(this);
    }

    void placeBookmark(int location, String content) {
        this.bookmarks.put(location, content);
    }

    void turnToPage(int pagenumber) {
        this.currentPage = pagenumber;
    }
}