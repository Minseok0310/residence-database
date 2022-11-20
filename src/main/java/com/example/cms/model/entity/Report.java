package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reports")
public class Report {
    @Id
    private long reportId;

    @DateTimeFormat
    private Date date;

    @DateTimeFormat
    private Time time;

    @Nullable
    private String description;

    @Nullable
    private String type;

    @NotEmpty
    private String status;

    @ManyToOne
    @JoinColumn(name = "lastName")
    private Admin author;

    //Assumption, infractions (thus reports) can only happen in one room, hence ManyToOne
    @ManyToOne
    @JoinColumn(name="roomNum")
    private Room location;

}
