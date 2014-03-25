package domein.domein;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Gebruiker implements Serializable{
    
    @Id
    private String idNummer;
    private String naam;
    private String voornaam;
    private String hashedWachtwoord;

    public Gebruiker() {}

    public Gebruiker(String idNummer, String naam, String voornaam) {
        this.idNummer = idNummer;
        this.naam = naam;
        this.voornaam = voornaam;
    }
    
    public void stelWachtwoordIn(String unhashedWachtwoord)
    {
        hashedWachtwoord = hash(unhashedWachtwoord);
    }
    
    private String hash(String s)
    {
        StringBuffer sb = new StringBuffer();
        try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(s.getBytes());
                byte byteData[] = md.digest();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
            }
            return sb.toString();
    }

    public String getHashedWachtwoord() {
        return hashedWachtwoord;
    }

    public void setHashedWachtwoord(String hashedWachtwoord) {
        this.hashedWachtwoord = hashedWachtwoord;
    }

    public String getIdNummer() {
        return idNummer;
    }

    public void setIdNummer(String idNummer) {
        this.idNummer = idNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }


    
    
    

    
    
    
    
    
}