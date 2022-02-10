package pl.edu.agh.mwo.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name="album_id")
    private Set<Photo> photos;

    public Album() {
    }

    public Album(String name, String description, Set<Photo> photos) {
        this.name = name;
        this.description = description;
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(Photo photo){
        photos.add(photo);
    }

    public void removePhoto(Photo photo){
        photos.remove(photo);
    }
}
