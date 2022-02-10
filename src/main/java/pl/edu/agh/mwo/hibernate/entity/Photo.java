package pl.edu.agh.mwo.hibernate.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDateTime date;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Likes",
            joinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<User> likes;

    public Photo() {
    }

    public Photo(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void addLike(User user) {
        likes.add(user);
    }

    public void removeLike(User user) {
        likes.remove(user);
    }

}
