package model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artist", schema = "public")
public class Artist {

  public Artist() {
  }

  //  ID SERIAL PRIMARY KEY ,
//  NAME varchar(256) NOT NULL
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Basic
  @Column(name = "name")
  private String name;

//  @OneToMany(mappedBy = "artist", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  private List<Album> albums;
//
//  @OneToMany(mappedBy = "artist", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  private List<Track> tracks;

//  public List<Album> getAlbums() {
//    return albums;
//  }
//
//  public void setAlbums(List<Album> albums) {
//    this.albums = albums;
//  }
//
//  public List<Track> getTracks() {
//    return tracks;
//  }
//
//  public void setTracks(List<Track> tracks) {
//    this.tracks = tracks;
//  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    Artist atrist = (Artist) o;
//    return id == atrist.id && Objects.equals(name, atrist.name);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id, name);
//  }
}
