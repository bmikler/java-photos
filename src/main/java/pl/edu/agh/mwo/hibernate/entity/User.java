package pl.edu.agh.mwo.hibernate.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private LocalDateTime joinDate;
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Album> albums;

    public User() {
    }

    public User(String username, LocalDateTime joinDate) {
        this.username = username;
        this.joinDate = joinDate;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void removeAlbum(Album album) {
        albums.remove(album);
    }
}
