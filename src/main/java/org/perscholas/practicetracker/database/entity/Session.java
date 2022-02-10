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
    @Column(name = "id")
    private Integer id;

    @Column(name = "session_name")
    private String sessionName;

}
