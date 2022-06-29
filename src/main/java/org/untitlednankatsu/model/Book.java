package org.untitlednankatsu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String title;
    private String description;
    private List<String> authorCollection;

    public Book() {};

    public Book(String title, String description, String author) throws Exception {
        setId();
        setTitle(title);
        setDescription(description);
        setAuthor(author);
    }

    private void setId() {
        this.id = count.incrementAndGet();
    }

    private void setTitle(String title) throws Exception {
        if(title.isEmpty()) throw new Exception("title should not be empty");
        if(title.length() < 2) throw new Exception("title's length should more than 1 character");

        this.title = title;
    }

    private void setDescription(String description) throws Exception {
        if(description.isEmpty()) throw new Exception("description should not be empty");
        if(description.length() < 2) throw new Exception("description's length should more than 1 character");
        if(description.length() > 255) throw new Exception("description's length should less than 255 character");

        this.description = description;
    }

    private void setAuthor(String author) throws Exception {
        if(author.isEmpty()) throw new Exception("author should not be empty");

        if(this.authorCollection == null){
            authorCollection = new ArrayList<>();
        }

        this.authorCollection.add(author);
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public List<String> getAuthor() { return authorCollection; }
}
