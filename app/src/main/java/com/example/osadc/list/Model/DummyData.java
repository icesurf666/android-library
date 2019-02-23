package com.example.osadc.list.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vykra on 18.03.2016.
 */
public class DummyData {
    public static final List<Book> ITEMS = new ArrayList<Book>();
    private static final int COUNT = 25;

    //Static data initialization.
    static {
        // Add some sample ITEMS.
        for (int i = 1; i <= COUNT; i++)
        {
            Book newBook = new Book();
            newBook.BookAuthor = "Author " + i;
            newBook.BookName = "Title " + i;
            newBook.BookDescription = "Description " + i;

            ITEMS.add(newBook);
        }
    }
}
