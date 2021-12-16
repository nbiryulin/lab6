package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artist", schema = "public")
public class Track {
//  ID SERIAL PRIMARY KEY,
//  NAME varchar(256) NOT NULL,
//  TIME INTEGER NOT NULL,
//  ALBUM_ID INTEGER NOT NULL,
//  Artist_ID;

  private int id;
  private String name;
  private int time;

  @ManyToOne
  @JoinColumn(name = "artist_id", referencedColumnName = "id")
  private Artist artist;

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "time")
  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }
}
