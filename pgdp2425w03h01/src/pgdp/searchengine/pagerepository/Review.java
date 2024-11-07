package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Review {
    private int postId;
    private String title;
    private String content;
    private int rating;
    private Date postDate;
    private Author reviewer;
    private Document reviewedDocument;
    private static int nowId = 0;
    public Review(String title, String content, Date postDate, Author reviewer, Document reviewedDocument, int rating) {
        this.postId = nowId++;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.reviewer = reviewer;
        this.reviewedDocument = reviewedDocument;
        this.rating = rating;
    }


    public boolean equals(Review other) {
        return this.postId == other.getPostId();

    }

    public String toString() {
        return this.title + " " +
                this.rating + " " +
                this.reviewedDocument.toString();
    }

    public String toPrintText() {
        return this.reviewedDocument.toString() + "\n" +
                this.rating + "\n" +
                this.title + "\n" +
                this.content + "\n" +
                this.postDate.toString() + "\n" +
                this.reviewer.toString() + "\n";
    }

    public static int numberOfCreatedReviews() {
        return nowId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public Document getReviewedDocument() {
        return reviewedDocument;
    }

    public Author getReviewer() {
        return reviewer;
    }

    public Date getPostDate() {
        return postDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
