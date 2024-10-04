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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Logo do usuário
        Image userLogo = new Image("file:user_logo.png"); // caminho da imagem
        ImageView userLogoView = new ImageView(userLogo);
        userLogoView.setFitHeight(100);
        userLogoView.setFitWidth(100);

        // Campos de entrada de texto
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setStyle("-fx-font-size: 16px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-font-size: 16px;");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;"
                + "-fx-padding: 5 10; -fx-border-radius: 5; -fx-background-radius: 5;");

        // Ação ao clicar no botão de login
        loginButton.setOnAction(event -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            // Validação simples
            if ("admin@gmail.com".equals(email) && "1234".equals(password)) {
                // Navegar para a interface de seleção
                Selection selection = new Selection();
                try {
                    selection.start(primaryStage);
                } catch (Exception s) {
                    s.printStackTrace();
                }
            } else {
            	JOptionPane.showInternalMessageDialog(null, "Email ou senha incorreta. Tente novamente.");
                System.out.println("Email ou senha incorreta. Tente novamente.");
            }
        });

        // Caixa de login com espaçamento
        VBox vbox = new VBox(15, userLogoView, emailField, passwordField, loginButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8); -fx-background-radius: 10;");

        // Faixa superior (simulando uma logo ou título)
        Text logoText = new Text("Terra Anciã");
        logoText.setFont(new Font("Arial", 24));
        logoText.setFill(Color.WHITE);

        VBox topBox = new VBox(logoText);
        topBox.setAlignment(Pos.CENTER_LEFT);
        topBox.setStyle("-fx-background-color: #333; -fx-padding: 20 0;");

        // Configurando o fundo da tela
        Image backgroundImage = new Image("file:background_login.jpg"); // caminho da imagem de fundo
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(vbox);
        root.setBackground(new Background(background));

        // Ajustando o tamanho da tela
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);

        // Definindo a cena e estilo
        Scene loginScene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        
//        primaryStage.setMaximized(true); // tela maximizada
    }

    public static void main(String[] args) {
        launch(args);
    }
}
