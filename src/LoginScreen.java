import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    public void start(Stage primaryStage) {
        // Logo do usuário
        Image userLogo = new Image("file:user_logo.png"); // caminho da sua imagem
        ImageView userLogoView = new ImageView(userLogo);
        userLogoView.setFitHeight(100);
        userLogoView.setFitWidth(100);
        
        // Campos de entrada de texto
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-font-size: 16px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-font-size: 16px;");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 16px; -fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-weight: bold;"
        			+ "-fx-padding: 5 10; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        // Ação ao clicar no botão de login
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Validação simples
            if ("admin".equals(username) && "1234".equals(password)) {
                // Navegar para a interface de seleção
                Selection selection = new Selection();
                try {
                    selection.start(primaryStage);
                } catch (Exception s) {
                    s.printStackTrace();
                }
            } else {
            	JOptionPane.showInternalMessageDialog(null, "Nome de usuário ou senha incorreta. Tente novamente.");
                System.out.println("Nome de usuário ou senha incorreta. Tente novamente.");
            }
        });

        // Organizando os elementos em um VBox
        VBox vbox = new VBox(15, userLogoView, usernameField, passwordField, loginButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(50));
        vbox.setStyle("-fx-background-color: #f0f0f0;"); // Cor de fundo da tela
        
        // Definindo a cena e estilo
        Scene loginScene = new Scene(vbox, 1280, 720);
        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
        
//        primaryStage.setFullScreen(true); // Adiciona a funcionalidade de tela cheia

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
