package com.example.project_java_nfk.Module;

public class Book extends Library {
    String name;
    String authorName;
    int publishedDate;
    int column;
    int range;
    String summary;


    public Book(String name, String authorName, int publishedDate, int column, int range, String summary) {
        this.name = name;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        this.column = column;
        this.range = range;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishedDate=" + publishedDate +
                ", column=" + column +
                ", range=" + range +
                ", summary='" + summary + '\'' +
                '}';
    }
}
