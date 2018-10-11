import java.io.Serializable;
public class Utilisateur implements Serializable {

    public Utilisateur(String prenom, String nomFamille, String nomUtili,
                       String motDePasse, String genre, String age) {
        this.prenom = prenom;
        this.nomFamille = nomFamille;
        this.nomUtili = nomUtili;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.age = age;
        this.infos = prenom + "," + nomFamille + "," + nomUtili + "," + motDePasse + "," + genre + "," + age + "\n";

    }

    private String prenom;
    private String nomFamille;
    private String nomUtili;
    private String motDePasse;
    private String genre;
    private String age;
    private String infos;



    public void afficher(){

        System.out.println(prenom + nomFamille + nomUtili + motDePasse + genre + age );

    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getNomUtili() {
        return nomUtili;
    }

    public void setNomUtili(String nomUtili) {
        this.nomUtili = nomUtili;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }






}
