package Objects;
public class bookObject {
    private String authorName, title, publicationName, subject;
    public bookObject(String authorName, String title, String publicationName, String subject){
        this.authorName = authorName;
        this.title = title;
        this.publicationName = publicationName;
        this.subject = subject;
    }
    public String getAuthorName() {
        return authorName;
    }
    public String getTitle() {
        return title;
    }
    public String getSubject() {
        return subject;
    }
    public String getPublicationName() {
        return publicationName;
    }
}
