package org.perscholas.practicetracker.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @Column(name = "session_id")
    public Integer sessionId;

    @Column(name = "session_type")
    public String sessionType;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + sessionId +
                ", sessionName='" + sessionType + '\'' +
                '}';
    }
}
