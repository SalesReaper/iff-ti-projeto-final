package terraanciaapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

public class WelcomeScreen extends Application {

    public void start(Stage primaryStage) {
        // Texto de saudação
        Text greetingText = new Text("Bem-vindo à Terra Anciã!");
        greetingText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        greetingText.setFill(Color.WHITE); // Cor de fundo da fonte

        // Resumo do programa
        Text summaryText = new Text("Este programa permite explorar os períodos geológicos da Terra e visualizar a distribuição dos continentes ao longo do tempo.");
        summaryText.setStyle("-fx-font-size: 16px;");
        summaryText.setFill(Color.WHITE); // Cor de fundo da fonte

        // Botão para começar
        Button startButton = new Button("Começar Exploração");
        startButton.setStyle("-fx-font-size: 16px;");
        startButton.setOnAction(event -> {
            // Ir para a próxima interface
            Selection selection = new Selection();
            try {
                selection.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Faixa superior simulando uma logo 
        Text logoText = new Text("Terra Anciã");
        logoText.setFont(new Font("Arial", 24));
        logoText.setFill(Color.WHITE);

        VBox topBox = new VBox(logoText);
        topBox.setAlignment(Pos.CENTER_LEFT);
        topBox.setStyle("-fx-background-color: #1C1C1C; -fx-padding: 15 30;");

        // Fundo da tela
        Image backgroundImage = new Image(getClass().getResourceAsStream("/resources/background_welcome.jpg")); // caminho da imagem de fundo
        BackgroundImage background = new BackgroundImage
        		(
        		backgroundImage, 
        		BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.CENTER,
                	new BackgroundSize
                		(
                		BackgroundSize.AUTO, 
                		BackgroundSize.AUTO, 
                		false, false, true, true
                		)
                );

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setBackground(new Background(background));

        // Layout central para os textos e o botão
        VBox vbox = new VBox(20, greetingText, summaryText, startButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(50));
        root.setCenter(vbox); // Adiciona o VBox no centro do BorderPane

        // Tamanho da tela
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);

        // Definindo a cena
        Scene scene = new Scene(root);
        primaryStage.setTitle("Terra Anciã");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}