package org.perscholas.practicetracker.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "following")
public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "user_id")
    private Integer userId;

    @JoinColumn(name = "following_id")
    private Integer followingId;

    @Override
    public String toString() {
        return "Following{" +
                "id=" + id +
                ", userId=" + userId +
                ", followingId=" + followingId +
                '}';
    }
}
