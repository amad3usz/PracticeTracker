package org.perscholas.practicetracker.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_sessions")
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
//    @Column(name = "user_id")
    private User user;

    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "date")
    private String date;

    @Column(name = "rating")
    private Integer rating;


    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "notes")
    private String notes;

    @Column(name = "time")
    private Integer time;


    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", userId=" + user +
                ", sessionId=" + sessionId +
                ", date='" + date + '\'' +
                ", rating=" + rating +
                ", sessionName='" + sessionName + '\'' +
                ", notes='" + notes + '\'' +
                ", time=" + time +
                '}';
    }
}
