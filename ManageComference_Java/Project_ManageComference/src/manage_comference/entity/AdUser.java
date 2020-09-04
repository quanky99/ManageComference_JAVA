package manage_comference.entity;
// Generated Jul 30, 2020 2:27:59 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AdUser generated by hbm2java
 */
public class AdUser  implements java.io.Serializable {


     private Integer idAccount;
     private String hoten;
     private String username;
     private String passwordAcc;
     private String email;
     private Boolean loai;
     private Set participantses = new HashSet(0);
     private Set participantsSignups = new HashSet(0);

    public AdUser() {
    }

    public AdUser(String hoten, String username, String passwordAcc, String email, Boolean loai, Set participantses, Set participantsSignups) {
       this.hoten = hoten;
       this.username = username;
       this.passwordAcc = passwordAcc;
       this.email = email;
       this.loai = loai;
       this.participantses = participantses;
       this.participantsSignups = participantsSignups;
    }
   
    public Integer getIdAccount() {
        return this.idAccount;
    }
    
    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }
    public String getHoten() {
        return this.hoten;
    }
    
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswordAcc() {
        return this.passwordAcc;
    }
    
    public void setPasswordAcc(String passwordAcc) {
        this.passwordAcc = passwordAcc;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getLoai() {
        return this.loai;
    }
    
    public void setLoai(Boolean loai) {
        this.loai = loai;
    }
    public Set getParticipantses() {
        return this.participantses;
    }
    
    public void setParticipantses(Set participantses) {
        this.participantses = participantses;
    }
    public Set getParticipantsSignups() {
        return this.participantsSignups;
    }
    
    public void setParticipantsSignups(Set participantsSignups) {
        this.participantsSignups = participantsSignups;
    }




}

