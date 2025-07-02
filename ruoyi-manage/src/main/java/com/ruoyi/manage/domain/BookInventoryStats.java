package com.ruoyi.manage.domain;

public class BookInventoryStats {
    private Long bookId;
    private String title;
    private String author;
    private Integer totalPurchased;
    private Integer totalSold;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTotalPurchased() {
        return totalPurchased;
    }

    public void setTotalPurchased(Integer totalPurchased) {
        this.totalPurchased = totalPurchased;
    }

    public Integer getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Integer totalSold) {
        this.totalSold = totalSold;
    }
}