/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monjpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Formation
 */
@Entity
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titre;

    private Integer duree;

    @OneToMany(mappedBy = "film")
    private List<Lien> liens = new ArrayList<>();

    @ManyToMany(mappedBy = "films")
    private List<Pays> pays = new ArrayList<>();

    @ManyToMany(mappedBy = "films")
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(mappedBy = "filmsJoues")
    private List<Personne> acteurs = new ArrayList<>();

    @ManyToMany(mappedBy = "filmsRealises")
    private List<Personne> realisateurs = new ArrayList<>();

    public Film() {

    }

    public Film(String titre, Integer duree) {

        this.titre = titre;
        this.duree = duree;
    }

    public List<Lien> getLiens() {
        return liens;
    }

    public void setLiens(List<Lien> liens) {
        this.liens = liens;
    }

    public List<Pays> getPays() {
        return pays;
    }

    public void setPays(List<Pays> pays) {
        this.pays = pays;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Personne> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Personne> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Personne> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Personne> realisateurs) {
        this.realisateurs = realisateurs;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "monjpa.Film[ id=" + id + " titre=" + titre + " duree=" + duree + " ]";
    }

}
