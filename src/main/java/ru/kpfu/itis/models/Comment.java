package ru.kpfu.itis.models;

import java.sql.Date;
import java.util.Objects;

public class Comment {

    private Long id;
    private Long idFlat;
    private String author;
    private String authorImage;
    private Date date;
    private String content;

    public Comment(Long id, Long idFlat, String author, String authorImage, Date date, String content) {
        this.id = id;
        this.idFlat = idFlat;
        this.author = author;
        this.authorImage = authorImage;
        this.date = date;
        this.content = content;
    }

    public Comment(Long idFlat, String author, String authorImage, Date date, String content) {
        this.id = null;
        this.idFlat = idFlat;
        this.author = author;
        this.authorImage = authorImage;
        this.date = date;
        this.content = content;
    }

    public Comment(Long id, Long idFlat, String author, Date date, String content) {
        this.id = id;
        this.idFlat = idFlat;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Comment(Long idFlat, String author, Date date, String content) {
        this.id = null;
        this.idFlat = idFlat;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFlat() {
        return idFlat;
    }

    public void setIdFlat(Long idFlat) {
        this.idFlat = idFlat;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id.equals(comment.id) && Objects.equals(idFlat, comment.idFlat) && Objects.equals(author, comment.author) && Objects.equals(authorImage, comment.authorImage) && Objects.equals(date, comment.date) && Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFlat, author, authorImage, date, content);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", idFlat=" + idFlat +
                ", author='" + author + '\'' +
                ", authorImage='" + authorImage + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
