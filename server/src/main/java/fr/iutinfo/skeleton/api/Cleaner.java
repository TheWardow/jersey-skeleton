package fr.iutinfo.skeleton.api;

import java.security.Principal;
import java.security.SecureRandom;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import fr.iutinfo.skeleton.common.dto.CleanerDto;

public class Cleaner implements Principal {
    final static Logger logger = LoggerFactory.getLogger(Cleaner.class);
    private static Cleaner anonymous = new Cleaner(-1, "Anonymous");
    private int id = 0;
    private String nom;
    private String prenom;
    private String tel;
    private Date dob;
    private String email;
    private String login;
    private String password;
    private String passwdHash;
    private String salt;
    private String search;
    private String localisation;
    private Double note;
    

    public Cleaner(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public Cleaner() {
    }

    
    
    public static Cleaner getAnonymous() {
		return anonymous;
	}

	public static void setAnonymous(Cleaner anonymous) {
		Cleaner.anonymous = anonymous;
	}

	public String getLocalisation() {
		return localisation;
	}

	public Double getNote() {
		return note;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public static Cleaner getAnonymousUser() {
        return anonymous;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        passwdHash = buildHash(password, getSalt());
        this.password = password;
    }

    private String buildHash(String password, String s) {
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(password + s, Charsets.UTF_8);
        return hasher.hash().toString();
    }

    public boolean isGoodPassword(String password) {
        if (isAnonymous()) {
        	System.out.println("User is anonymous");
            return false;
        }
        String hash = buildHash(password, getSalt());
        System.out.println("hash  = " + hash);
        return hash.equals(getPasswdHash());
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }

    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        Cleaner user = (Cleaner) arg;
        return login.equals(user.login) && email.equals(user.email) && passwdHash.equals(user.getPasswdHash()) && salt.equals((user.getSalt()));
    }
    

    @Override
    public String toString() {
        return id + ": " + login + " <" + email + ">";
    }


    public String getSalt() {
        if (salt == null) {
        	System.out.println("Salt was null, generating salt");
            salt = generateSalt();
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putLong(random.nextLong());
        return hasher.hash().toString();
    }

    public void resetPasswordHash() {
        if (password != null && !password.isEmpty()) {
            setPassword(getPassword());
        }
    }

    public boolean isInUserGroup() {
        return !(id == anonymous.getId());
    }

    public boolean isAnonymous() {
        return this.getId() == getAnonymousUser().getId();
    }

    public String getSearch() {
        search = login + " " + email;
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void initFromDto(CleanerDto dto) {
        this.setEmail(dto.getEmail());
        this.setId(dto.getId());
        this.setLogin(dto.getLogin());
        this.setPassword(dto.getPassword());
        this.setDob(dto.getDob());
        this.setLocalisation(dto.getLocalisation());
        this.setNom(dto.getNom());
        this.setNote(dto.getNote());
        this.setPrenom(dto.getPrenom());
        this.setTel(dto.getTel());
        this.salt = getSalt();
    }

    public CleanerDto convertToDto() {
        CleanerDto dto = new CleanerDto();
        dto.setNom(getNom());
        dto.setPrenom(getPrenom());
        dto.setTel(getTel());
        dto.setDob(getDob());
        dto.setLocalisation(getLocalisation());
        dto.setNote(getNote());
        dto.setEmail(this.getEmail());
        dto.setId(this.getId());
        dto.setLogin(this.getLogin());
        dto.setPassword(this.getPassword());
        return dto;
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.nom;
	}
}
