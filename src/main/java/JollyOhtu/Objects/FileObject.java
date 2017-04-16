package JollyOhtu.Objects;

/**
 *
 * @author Arttu
 */
public class FileObject {

    private String name;
    private String contentType;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            this.name = "References.bib";
        } else {
            this.name = name + ".bib";
        }
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
