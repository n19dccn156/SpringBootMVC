package KhanhVySang.demo.Model;

import java.io.Serializable;


public class GoogleDriveFileDTO implements Serializable{
 
    private String id;
    private String name;
    private String link;
    private String size;
    private String thumbnailLink;
    private boolean shared;


    public GoogleDriveFileDTO() {
    }

    public GoogleDriveFileDTO(String id, String name, String link, String size, String thumbnailLink, boolean shared) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.size = size;
        this.thumbnailLink = thumbnailLink;
        this.shared = shared;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getThumbnailLink() {
        return this.thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public boolean isShared() {
        return this.shared;
    }

    public boolean getShared() {
        return this.shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

}
