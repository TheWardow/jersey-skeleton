package fr.iutinfo.skeleton.api;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.core.GenericType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.UserDto;

public class Helper {
    private final static Logger logger = LoggerFactory.getLogger(Helper.class);
    private static final UserDao userdao = BDDFactory.getDbi().open(UserDao.class);
    private static final CarDao cardao = BDDFactory.getDbi().open(CarDao.class);
    private static final CleanerDao cleanerdao = BDDFactory.getDbi().open(CleanerDao.class);
    private static final PictureDao picturedao = BDDFactory.getDbi().open(PictureDao.class);
    private static final CommandeDao commandedao = BDDFactory.getDbi().open(CommandeDao.class);
    private static final AdresseDao adressedao = BDDFactory.getDbi().open(AdresseDao.class);
    private static final ProductDao productdao = BDDFactory.getDbi().open(ProductDao.class);
    static GenericType<List<UserDto>> listUserResponseType = new GenericType<List<UserDto>>() {
    };

    public static void initDb() {
    	userdao.dropUserTable();
    	userdao.createUserTable();
    	cardao.dropCarTable();
    	cardao.createCarTable();
    	cleanerdao.dropCleanerTable();
    	cleanerdao.createCleanerTable();
    	picturedao.dropPictureTable();
    	picturedao.createPictureTable();
    	commandedao.dropCommandeTable();
    	commandedao.createCommandeTable();
    	adressedao.dropAdresseTable();
    	adressedao.createAdresseTable();
    	productdao.dropProductTable();
    	productdao.createProductTable();
    }

    static User createUserWithName(String name) {
        User user = new User(0, name);
        return createUser(user);
    }

    static User createUserWithEmail(String name, String email) {
        User user = new User(0, name);
        user.setEmail(email);
        return createUser(user);
    }

    public static User createAdminWithPassword(String name, String passwd) {
        User user = new User(0, name);
        user.setSalt(user.getSalt());
        user.setPassword(passwd);
        user.setIsadmin(1);
        logger.debug("createUserWithPassword Hash : " + user.getPasswdHash());
        return createUser(user);
    }
    
    public static User createUserWithPassword(String name, String passwd) {
        User user = new User(0, name);
        user.setSalt(user.getSalt());
        user.setPassword(passwd);
        System.out.println("cle : "+user.getPasswdHash());
        logger.debug("createUserWithPassword Hash : " + user.getPasswdHash());
        return createUser(user);
    }
    
    public static User createUserWithPassword(String name, String passwd,String salt) {
        User user = new User(0, name);
        user.setSalt(salt);
        user.setPassword(passwd);
        System.out.println("cle : "+user.getPasswdHash());
        logger.debug("createUserWithPassword Hash : " + user.getPasswdHash());
        return createUser(user);
    }
    
    private static User createUser(User user) {
        int id = userdao.insert(user);
        user.setId(id);
        return user;
    }
    
    public static Product createProduct(String type, String modele, int quantite, String cleanerlogin){
    	Product product = new Product(type, modele, quantite, cleanerlogin);
    	int id = productdao.insert(product);
    	product.setId(id);
    	return product;
    }
    
    public static Cleaner createCleanerWithPassword(String login, String passwd, String nom, String prenom) {
        Cleaner user = new Cleaner(0, login);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setSalt(user.getSalt());
        user.setPassword(passwd);
        logger.debug("createCleanerWithPassword Hash : " + user.getPasswdHash());
        return createCleaner(user);
    }
    private static Cleaner createCleaner(Cleaner user) {
        int id = cleanerdao.insert(user);
        user.setId(id);
        return user;
    }
    
    public static Adresse createAdresse(String numero, String voie, String ville, int cp, String login) {
        Adresse adresse = new Adresse(numero, voie, ville, cp, login);
    	int id = adressedao.insert(adresse);
        adresse.setAdresseId(id);
        return adresse;
    }
    
    public static Car createCar(String userLogin, String marque, String modele, String couleur, String commentaire, String immatriculation) {
		Car car = new Car(userLogin, marque, modele, couleur, 0, commentaire,immatriculation);
		int id = cardao.insert(car);
		car.setId(id);
		return car;
	}
    
    public static Commande createCommande(int idCar, String loginCleaner) {
		Commande commande = new Commande(0, idCar, loginCleaner);
		//commande.setDate(LocalDateTime.now());
		int id = commandedao.insert(commande);
		commande.setId(id);
		return commande;
	}
    
    public static Picture createPicture(int commandeId, String path, int nettoye) {
		Picture picture = new Picture(commandeId, path, nettoye, LocalDateTime.now());
		int id = picturedao.insert(picture);
		picture.setId(id);
		return picture;
	}


    private static User createFullUSer(String nom, String prenom, String login, String email, String password, int isAdmin) {
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setIsadmin(isAdmin);
        user.setNom(nom);
        user.setPrenom(prenom);
        int id = userdao.insert(user);
        user.setId(id);
        return user;
    }

    static void createRms() {
        createFullUSer("Richard", "Stallman", "RMS", "rms@fsf.org", "gnuPaswword", 0);
    }

    static User createRob() {
        return createFullUSer("Robert", "Capillo", "rob", "rob@fsf.org", "paswword", 0);
    }

    static User createLinus() {
        return createFullUSer("Linus", "Torvalds", "linus", "linus@linux.org", "paswword", 0);
    }
    
    static User createIan() {
        return createFullUSer("Ian","Murdock", "debian", "ian@debian.org", "mot de passe", 0);
    }
	
}
