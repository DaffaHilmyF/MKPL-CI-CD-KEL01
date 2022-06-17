package org.untitlednankatsu;

import org.untitlednankatsu.model.Book;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws Exception {
        var bookList = Arrays.asList(
                new Book("Spideman: No Way Home", "lorem ipsum", "Jon Watts"),
                new Book("Spideman: Home Coming", "lorem ipsum", "Jon Watts")
                );

        bookList.forEach(item->{
            logger.log(Level.INFO, item.getDescription());
        });
    }
}