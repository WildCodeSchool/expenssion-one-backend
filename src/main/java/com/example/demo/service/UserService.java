package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

        @Autowired
    private UserRepository userRepository;




        public List<User> getAll() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User getUserById(String id) {

        User user = this.userRepository.findById(id).get();
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public String delete(String userUUID,String password) {
        User user = this.getUserById(userUUID);
        if (user.getPassword().equals(password)) {
            this.userRepository.delete(user);
            return "User deleted";
        } else {
            return "Wrong password";
        }
    }

    public User findById(String id) {
        return this.userRepository.findById(id).get();
    }

    public User findByPseudo(String pseudo) {
        return this.userRepository.findByPseudo(pseudo);
    }

    public User updateUserPersonnalData(String userUUID, String firstname, String lastname, String email, Date dateOfBirth) {
        User userToUpdate = this.getUserById(userUUID);
        userToUpdate.setFirstname( firstname);
        userToUpdate.setLastname(lastname);
        userToUpdate.setEmail(email);
        userToUpdate.setDateOfBirth(dateOfBirth);
        this.userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User updateBiography(String userUUID, String biography) {
        User userToUpdate = this.getUserById(userUUID);
        userToUpdate.setBiography(biography);
        this.userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User updateDisplayPseudo(String userUUID, String pseudoDisplayName) {
        User userToUpdate = this.getUserById(userUUID);
        userToUpdate.setPseudoDisplay(pseudoDisplayName);
        this.userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User updateProfilPicture(String userUUID, String profilPictureUrl) {
        User userToUpdate = this.getUserById(userUUID);
        userToUpdate.setProfilPictureUrl(profilPictureUrl);
        this.userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User changePassword(String userUUID, String oldPassword, String newPassword) {
        User user = this.getUserById(userUUID);

        if (user.getPassword().equals(oldPassword)) {
            
            this.userRepository.save(user);
            return user;
        } else {
            throw new RuntimeException("Wrong password");
        }
    }

    public User addFriend(String userUUID, String friendUUID) {
        User user = this.getUserById(userUUID);
        User friend = this.userRepository.findById(friendUUID).get();
        user.getFriends().add(friend);
        this.userRepository.save(user);
        return user;
    }

    public User removeFriend(String userUUID, String friendUUID) {
        User user = this.getUserById(userUUID);
        User friend = this.getUserById(friendUUID);
        user.getFriends().remove(friend);
        this.userRepository.save(user);
        return user;
    }

   public User updateParameters(String userUUID, Boolean isPublic, Boolean isNewsletter){
        User userToUpdate = this.getUserById(userUUID);
        userToUpdate.setIsNewletters(isNewsletter);
        userToUpdate.setIsPublic(isPublic);
        this.userRepository.save(userToUpdate);
        return userToUpdate;
    }




}
