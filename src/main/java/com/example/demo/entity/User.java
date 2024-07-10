package com.example.demo.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique=true,updatable = false)
    private String pseudo;
    private String pseudoDisplay;
    private String lastname;
    private String firstname;
    private String password;
    private Date dateOfBirth;
    @Column(unique=true)
    private String email;
    private String profilPictureUrl=null;
    private String biography=null;


     @ManyToMany
    @JoinTable(
        name = "user_friends",
        joinColumns = @JoinColumn(name = "userId"),
        inverseJoinColumns = @JoinColumn(name = "friendId")
    )
    private Set<User> friends=null;
    

    private Boolean isNewletters=true;
    private Boolean isPublic=true;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("user-character")
    private List<Character> characters;

    
    


    public User(Date dateOfBirth, String email, String firstname, String lastname, String password, String pseudo) {
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.pseudo = pseudo;
        this.pseudoDisplay = pseudo;
    }

    public User() {
    }

    public String getId() {
        return id;
    }


    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilPictureUrl() {
        return profilPictureUrl;
    }

    public void setProfilPictureUrl(String profilPictureUrl) {
        this.profilPictureUrl = profilPictureUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }



    public Boolean getIsNewletters() {
        return isNewletters;
    }

    public void setIsNewletters(Boolean isNewletters) {
        this.isNewletters = isNewletters;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getPseudoDisplay() {
        return pseudoDisplay;
    }

    public void setPseudoDisplay(String pseudoDisplay) {
        this.pseudoDisplay = pseudoDisplay;
    }

}