package model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album", schema = "public")
public class Album {

  private int id;
  private String name;
  private String type;

  @ManyToOne
  @JoinColumn(name = "artist_id", referencedColumnName = "id")
  private Artist artist;

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  //  ID SERIAL PRIMARY KEY,
//  NAME varchar(256) NOT NULL,
//  TYPE varchar(256),
//  ARTIST_ID INTEGER NOT NULL,
//  CONSTRAINT ARTIST_ID_FK FOREIGN KEY (ARTIST_ID) REFERENCES artist (ID)
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
  @Column(name = "type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Album album = (Album) o;
    return id == album.id && Objects.equals(name, album.name) && Objects.equals(
        type, album.type) && Objects.equals(artist, album.artist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, artist);
  }

  //  ID SERIAL PRIMARY KEY,
//  NAME varchar(256) NOT NULL,
//  TYPE varchar(256),
//  ARTIST_ID INTEGER NOT NULL,
//  CONSTRAINT ARTIST_ID_FK FOREIGN KEY (ARTIST_ID) REFERENCES artist (ID)
}
