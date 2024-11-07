package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Document {
    private int documentId;
    private String title;
    private String description;
    private String content;
    private Date releaseDate;
    private Date lastUpdateDate;
    private Author author;
    private static int nowId = 0;

    public Document(String title, String description, String content, Date releaseDate, Author author) {
        this.documentId = nowId++;
        this.title = title;
        this.description = description;
        this.content = content;
        this.releaseDate = releaseDate;
        this.author = author;
        this.lastUpdateDate = releaseDate;
    }

    public boolean equals(Document other) {
        return this.documentId == other.documentId;
    }

    public String toString() {
        return this.title + " " +
                this.lastUpdateDate.toString() + " " +
                this.author.toString();
    }

    public String toPrintText() {
        return this.title + "\n" +
               this.author.toString() + "\n" +
               this.description + "\n" +
               this.lastUpdateDate.toString() + "\n";
    }

    public static int numberOfCreatedDocuments() {
        return nowId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
