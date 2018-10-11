import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application{

    public static ArrayList<Utilisateur> mapInfos = new ArrayList<Utilisateur>();

    public static void main(String[] args) { launch(args); }



    public void start(Stage primaryStage) {
        primaryStage.setWidth(520);
        primaryStage.setHeight(550);
        primaryStage.setTitle("Laboratoire #5");
        primaryStage.setResizable(false);

        try {
            List<String> list = Files.readAllLines(Paths.get("comptes.csv"));
            String[] parties;
            for (int i = 0; i<list.size(); i++){
                parties = list.get(i).split(",");

                mapInfos.add(new Utilisateur(parties[0], parties[1], parties[2], parties[3], parties[4], parties[5]));
            }

        }catch (IOException e){}

        /*
        for (Utilisateur m: mapInfos) {
            System.out.println(m.getInfos());
        } */





        //LOGIN

        //TF = text field    L = label

        Label userNameL = new Label("Nom d'utilisateur");
        Label passwordL = new Label("Mot de passe");
        Label echoue = new Label("");

        TextField userNameTF = new TextField();
        userNameTF.setPromptText("Nom d'utilisateur");                                        //enlever les listener


        PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("Mot de passe");


        Button connecter = new Button("Se connecter");

        Button inscrire = new Button("S'inscrire");


        userNameTF.setTranslateX(180); userNameTF.setTranslateY(180);
        passwordTF.setTranslateX(180); passwordTF.setTranslateY(230);

        userNameL.setTranslateX(182); userNameL.setTranslateY(158);
        passwordL.setTranslateX(182); passwordL.setTranslateY(208);

        connecter.setTranslateX(180); connecter.setTranslateY(268);
        inscrire.setTranslateX(270); inscrire.setTranslateY(268);
        echoue.setTranslateX(181); echoue.setTranslateY(297);

        echoue.setTextFill(Color.RED);

        Group logIn = new Group(userNameTF, passwordTF, userNameL, passwordL, connecter, inscrire, echoue );
        Scene accueil = new Scene(logIn);
        primaryStage.setScene(accueil);

        //SIGNIN
        Label prenom = new Label("Prénom");
        Label nomFamille = new Label("Nom de famille");
        Label nomUtilisateur = new Label("Nom d'utilisateur");
        Label motDePasse = new Label("Mot de passe");
        Label confirmerMdp = new Label("Confirmer le mot de passe");
        Label genre = new Label("Genre");
        Label age = new Label("Âge");


        TextField prenomTF = new TextField();
        prenomTF.setPromptText("Prénom");

        TextField nomFamilleTF = new TextField();
        nomFamilleTF.setPromptText("Nom de famille");


        TextField nomUtiliTF = new TextField();
        nomUtiliTF.setPromptText("Nom d'utilisateur");
        nomUtiliTF.textProperty().addListener((observable, oldValue, newValue) -> {
            });

        PasswordField motDePasseTF = new PasswordField();
        motDePasseTF.setPromptText("Mot de passe");

        PasswordField confirmationTF = new PasswordField();
        confirmationTF.setPromptText("Mot de passe");

        Spinner choixAge = new Spinner(18,100,18);

        prenom.setTranslateX(182); prenom.setTranslateY(10);
        prenomTF.setTranslateX(180); prenomTF.setTranslateY(30);

        nomFamille.setTranslateX(182); nomFamille.setTranslateY(60);
        nomFamilleTF.setTranslateX(180); nomFamilleTF.setTranslateY(80);

        nomUtilisateur.setTranslateX(182); nomUtilisateur.setTranslateY(110);
        nomUtiliTF.setTranslateX(180); nomUtiliTF.setTranslateY(130);

        motDePasse.setTranslateX(182); motDePasse.setTranslateY(160);
        motDePasseTF.setTranslateX(180); motDePasseTF.setTranslateY(180);

        confirmerMdp.setTranslateX(182); confirmerMdp.setTranslateY(210);
        confirmationTF.setTranslateX(180); confirmationTF.setTranslateY(230);

        Button effacer = new Button("Effacer");
        Button retour = new Button("Retour");
        Button confirmSignin = new Button("S'inscrire");

        confirmSignin.setTranslateX(180); confirmSignin.setTranslateY(390);
        effacer.setTranslateX(250); effacer.setTranslateY(390);
        retour.setTranslateX(310); retour.setTranslateY(390);
        genre.setTranslateX(182); genre.setTranslateY(260);

        RadioButton homme = new RadioButton("Homme");
        RadioButton femme = new RadioButton("Femme");
        RadioButton autre = new RadioButton("Autre");

        ToggleGroup genres = new ToggleGroup();

        femme.setTranslateX(180); femme.setTranslateY(280);femme.setToggleGroup(genres);
        homme.setTranslateX(250); homme.setTranslateY(280);homme.setToggleGroup(genres);
        autre.setTranslateX(320); autre.setTranslateY(280);autre.setToggleGroup(genres);


        age.setTranslateX(182); age.setTranslateY(300);
        choixAge.setTranslateX(180); choixAge.setTranslateY(320);
        choixAge.editableProperty().setValue(true);


        CheckBox conditions = new CheckBox("J'accepte les conditions d'utilisation");
        conditions.setTranslateX(180); conditions.setTranslateY(360);

        Label missing = new Label(" ");
        missing.setTextFill(Color.RED);
        missing.setTranslateX(180); missing.setTranslateY(420);

        effacer.setOnAction(event->{

            missing.setText("");

            try {

                prenomTF.textProperty().setValue(null);
                nomFamilleTF.textProperty().setValue(null);
                nomUtiliTF.textProperty().setValue(null);
                motDePasseTF.textProperty().setValue(null);
                confirmationTF.textProperty().setValue(null);

                homme.selectedProperty().setValue(false);
                femme.selectedProperty().setValue(false);
                autre.selectedProperty().setValue(false);

                choixAge.decrement(choixAge.valueProperty().hashCode()-18);

                conditions.selectedProperty().setValue(false);

            }catch (Exception e){
                System.out.println("EXCEPTION!!!!");
            }

        });


        confirmSignin.setOnAction(event->{

            String g = "";

            if (prenomTF.getText().isEmpty()){ missing.setText("Prénom manquant"); }
            else if (nomFamilleTF.getText().isEmpty()) { missing.setText("Nom de famille manquant");}
            else if (nomUtiliTF.getText().isEmpty()) { missing.setText("Nom d'utilisateur manquant");}
            else if (dejaPris(nomUtiliTF.getText())) { missing.setText("Nom d'utilisateur déjà pris");}
            else if (motDePasseTF.getText().isEmpty()) { missing.setText("Mot de passe manquant");}
            else if (!(confirmationTF.getText().equals(motDePasseTF.getText()))) {
                     missing.setText("Confirmation du mot de passe invalide");}
            else if (!femme.selectedProperty().getValue() && !homme.selectedProperty().getValue() && !autre.selectedProperty().getValue())
            { missing.setText("Genre manquant"); }
            else if (!conditions.selectedProperty().getValue())
                     { missing.setText("Veuillez accepter les conditons d'utilisations");}
            else {
                missing.setText(" ");

                if (femme.selectedProperty().getValue()){ g = "F"; }
                else if (homme.selectedProperty().getValue()) { g = "H"; }
                else if (autre.selectedProperty().getValue()){ g = "A"; }

                mapInfos.add(new Utilisateur(prenomTF.getText(), nomFamilleTF.getText(), nomUtiliTF.getText(), encoding(motDePasseTF.getText()), g, choixAge.getValue().toString()));


                String enregistrer = "";
                for (Utilisateur mapInfo : mapInfos) {
                    enregistrer = enregistrer + mapInfo.getInfos();
                }
                try {
                    Files.write(Paths.get("comptes.csv"), enregistrer.getBytes());
                }catch (Exception e){}


                effacer.fire();
                primaryStage.setScene(accueil);
            }
        });

        retour.setOnAction(event->{ effacer.fire(); primaryStage.setScene(accueil);});

        Group signIn = new Group(prenom, prenomTF, nomFamille, nomFamilleTF, nomUtilisateur,
                nomUtiliTF, motDePasse, motDePasseTF, confirmerMdp, confirmationTF, genre,
                femme, homme, autre,
                age, choixAge, conditions, confirmSignin, effacer, retour, missing);

        Scene inscription = new Scene(signIn);

        //LOADING

        ProgressIndicator rond = new ProgressIndicator();
        Label label = new Label("Chargement du contenu");

        rond.setTranslateX(235);rond.setTranslateY(180);
        label.setTranslateX(205);label.setTranslateY(265);

        Group loading = new Group(rond, label);
        Scene chargement = new Scene(loading);

        //accueil
        connecter.setOnAction(event->{
            if (!valideUser(userNameTF.getText())){ echoue.setText("La connexion a échoué"); }
            else if (!validePassword(userNameTF.getText(),passwordTF.getText())){ echoue.setText("La connexion a échoué"); }
            else {primaryStage.setScene(chargement); }
            });                              // A FAIRE



        inscrire.setOnAction(event->{ primaryStage.setScene(inscription); userNameTF.setText(""); passwordTF.setText("");  });
        //inscription



        primaryStage.show();



    }



    private boolean valideUser(String username){
        boolean valide = false;

        for (int i=0; i<mapInfos.size(); i++){
            if (username.equals(mapInfos.get(i).getNomUtili())){
                valide = true;
            }
        }
        return valide;
    }

    private boolean validePassword (String userame, String password){
        int indice = 0;
        boolean valide = false;
        for (int i=0; i<mapInfos.size(); i++){
            if (mapInfos.get(i).getNomUtili().equals(userame)){
                indice = i;
            }
        }

        if (mapInfos.get(indice).getMotDePasse().equals(encoding(password))){
            valide = true;
        }
        return valide;
    }

    private boolean dejaPris(String nomUtili){
        boolean dejaPris = false;

        for (int i = 0; i < mapInfos.size(); i++){
            if (nomUtili.equals(mapInfos.get(i).getNomUtili())){
                dejaPris = true;
            }
        }

        return dejaPris;
    }


    private static String encoding(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));
            String secret = bytesToHex(encodedhash);
            return secret;

        }catch (Exception e){

        }
        return "ERREUR";
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
