package terraanciaapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeScreen extends Application {

    public void start(Stage primaryStage) {
        // Configurando os textos
        Label welcomeLabel = new Label("Bem-vindo ao Terra Anciã!");
        Label messageLabel = new Label("Explore como era dividido o planeta de eras em eras.");
        Label footerLabel = new Label("Rayan & Jhulya");

        // Adicionando botão "Entrar"
        Button enterButton = new Button("Começar Exploração");
        enterButton.setOnAction(event -> {
            // Ir para a próxima interface
            Selection selection = new Selection();
            try {
                selection.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Adicionando estilos CSS
        welcomeLabel.getStyleClass().add("welcome-text");
        messageLabel.getStyleClass().add("message-text");
        footerLabel.getStyleClass().add("footer-text");
        enterButton.getStyleClass().add("enter-button"); // Estilo para o botão

        // Layout central
        VBox centralLayout = new VBox(20, welcomeLabel, messageLabel, enterButton);
        centralLayout.setAlignment(Pos.CENTER);  // Alinhado no centro da tela
        centralLayout.setPadding(new Insets(50));
        
        // Layout do rodapé
        VBox footerLayout = new VBox(footerLabel);
        footerLayout.setAlignment(Pos.BOTTOM_LEFT);  // Alinha o rodapé no canto inferior esquerdo
        
        // Layout principal
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(centralLayout);         // Textos e botão centrais no meio
        mainLayout.setBottom(footerLayout);          // Rodapé no fundo

        // Adicionando imagem de fundo via Java
        mainLayout.setStyle("-fx-background-image: url('" + getClass().getResource("/resources/galaxy-night-panorama.jpg").toExternalForm() + "');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat;");

        // Cena
        Scene scene = new Scene(mainLayout, 1366, 768);
        scene.getStylesheets().add(getClass().getResource("/terraanciaapp/style.css").toExternalForm());

        // Configurando o palco
        primaryStage.setTitle("Bem-vindo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}