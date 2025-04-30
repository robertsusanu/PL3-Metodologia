package Ejercicio_2;

public class BookAuthors {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public BookAuthors(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public BookAuthors(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return "Book [name=" + name + "," + getAuthorInfo() + ", price=" + price + ", qty=" + qty + "]";
    }

    public String getAuthorNames() {
        String mensaje = "Authors: ";
        for (int i = 0; i < authors.length; i++) {
            mensaje += authors[i].getName() + ", ";
        }
        return mensaje;
    }

    public String getAuthorInfo() {
        String mensaje = "Authors: ";
        for (int i = 0; i < authors.length; i++) {
            mensaje += authors[i].getName() + ", " + authors[i].getEmail() + ", " + authors[i].getGender();
        }
        return mensaje;
    }
    public String getAuthorEmail() {
        String mensaje = "Authors: ";
        for (int i = 0; i < authors.length; i++) {
            mensaje += authors[i].getEmail() + ", ";
        }
        return mensaje;
    }
    public String getAuthorGender() {
        String mensaje = "Authors: ";
        for (int i = 0; i < authors.length; i++) {
            mensaje += authors[i].getGender() + ", ";
        }
        return mensaje;
    }

    /* Que el test no va a funcionar porque va a buscar un Author
     en vez del array de Authors, que es lo que ahora tenemos.
     */

}
