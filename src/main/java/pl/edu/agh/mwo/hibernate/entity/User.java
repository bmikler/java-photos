package pl.edu.agh.mwo.hibernate.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private LocalDateTime joinDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Album> albums = new HashSet<>();
    @ManyToMany(mappedBy = "likes", fetch = FetchType.EAGER)
    private Set<Photo> photoLiked = new HashSet<>();

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

    public Set<Photo> getPhotoLiked() {
        return photoLiked;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void removeAlbum(Album album) {
        albums.remove(album);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && joinDate.equals(user.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, joinDate);
    }
}
