package com.artem3010.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phrases")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phrase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "hours_begin")
    int hoursBegin;
    @Column(name = "minutes_begin")
    int minutesBegin;
    @Column(name = "seconds_begin")
    int secondsBegin;
    @Column(name = "mseconds_begin")
    int msecondsBegin;
    @Column(name = "hours_end")
    int hoursEnd;
    @Column(name = "minutes_end")
    int minutesEnd;
    @Column(name = "seconds_end")
    int secondsEnd;
    @Column(name = "mseconds_end")
    int msecondsEnd;
    @Column(name = "phrase")
    String phrase;

    public String toSRTFormat() {
        return "";
    } //todo



}


