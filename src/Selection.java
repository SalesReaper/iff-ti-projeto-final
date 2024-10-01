import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Selection extends Application {

    public void start(Stage primaryStage) {
        // Configurando o período Permo-Triássico
        Image ptriassicLogo = new Image("file:ptriassic_logo.png");
        ImageView ptriassicView = new ImageView(ptriassicLogo);
        ptriassicView.setFitHeight(100);
        ptriassicView.setFitWidth(100);

        Label ptriassicTitle = new Label("Permo-Triássico");
        ptriassicTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;"); // Tamanho da fonte e cor

        Label ptriassicDescription = new Label("blá blá blá");
        ptriassicDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;"); // Tamanho da fonte e cor

        // Organizar a imagem, título e descrição em um VBox
        VBox ptriassicInfo = new VBox(5, ptriassicView, ptriassicTitle, ptriassicDescription);
        ptriassicInfo.setAlignment(Pos.CENTER);  // Alinhar ao centro

        Rectangle ptriassicBackground = new Rectangle(300, 800);
        ptriassicBackground.setFill(Color.BLUEVIOLET);
        
        StackPane ptriassicPane = new StackPane(ptriassicBackground, ptriassicInfo);
        ptriassicPane.setOnMouseClicked(event -> {
            System.out.println("Permo-Triássico selecionado");
            Earth3D_Permo_Triassic earth3D = new Earth3D_Permo_Triassic();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Jurássico-Cretáceo
        Image jcretaceousLogo = new Image("file:jcretaceous_logo.png");
        ImageView jcretaceousView = new ImageView(jcretaceousLogo);
        jcretaceousView.setFitHeight(100);
        jcretaceousView.setFitWidth(100);

        Label jcretaceousTitle = new Label("Jurássico-Cretáceo");
        jcretaceousTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;");

        Label jcretaceousDescription = new Label("blá blá blá");
        jcretaceousDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        VBox jcretaceousInfo = new VBox(5, jcretaceousView, jcretaceousTitle, jcretaceousDescription);
        jcretaceousInfo.setAlignment(Pos.CENTER);

        Rectangle jcretaceousBackground = new Rectangle(300, 800);
        jcretaceousBackground.setFill(Color.DARKBLUE);

        StackPane jcretaceousPane = new StackPane(jcretaceousBackground, jcretaceousInfo);
        jcretaceousPane.setOnMouseClicked(event -> {
            System.out.println("Jurássico-Cretáceo selecionado");
            Earth3D_Jurassic_Cretaceous earth3D = new Earth3D_Jurassic_Cretaceous();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Cenomaniano
        Image cenomanianLogo = new Image("file:cenomanian_logo.png");
        ImageView cenomanianView = new ImageView(cenomanianLogo);
        cenomanianView.setFitHeight(100);
        cenomanianView.setFitWidth(100);

        Label cenomanianTitle = new Label("Cenomaniano");
        cenomanianTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;");

        Label cenomanianDescription = new Label("blá blá blá");
        cenomanianDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");
        
        VBox cenomanianInfo = new VBox(5, cenomanianView, cenomanianTitle, cenomanianDescription);
        cenomanianInfo.setAlignment(Pos.CENTER);

        Rectangle cenomanianBackground = new Rectangle(300, 800);
        cenomanianBackground.setFill(Color.DARKKHAKI);

        StackPane cenomanianPane = new StackPane(cenomanianBackground, cenomanianInfo);
        cenomanianPane.setOnMouseClicked(event -> {
            System.out.println("Cenomaniano selecionado");
            Earth3D_Cenomanian earth3D = new Earth3D_Cenomanian();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Plioceno
        Image plioceneLogo = new Image("file:_logo.png");
        ImageView plioceneView = new ImageView(plioceneLogo);
        plioceneView.setFitHeight(100);
        plioceneView.setFitWidth(100);

        Label plioceneTitle = new Label("Plioceno");
        plioceneTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;");

        Label plioceneDescription = new Label("blá blá blá");
        plioceneDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        VBox plioceneInfo = new VBox(5, plioceneView, plioceneTitle, plioceneDescription);
        plioceneInfo.setAlignment(Pos.CENTER);

        Rectangle plioceneBackground = new Rectangle(300, 800);
        plioceneBackground.setFill(Color.GREEN);

        StackPane pliocenePane = new StackPane(plioceneBackground, plioceneInfo);
        pliocenePane.setOnMouseClicked(event -> {
            System.out.println("Plioceno selecionado");
            Earth3D_Pliocene earth3D = new Earth3D_Pliocene();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        String buttonStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-padding: 5 10; -fx-border-radius: 5; -fx-background-radius: 5;";
        
        // Adicionando o botão de Voltar
        Button backButton = new Button("Voltar");
        backButton.setStyle(buttonStyle);
        backButton.setOnMouseExited(e -> backButton.setStyle(buttonStyle));
        backButton.setOnAction(event -> {
            // Retorna para a tela de login
            LoginScreen loginScreen = new LoginScreen();
            try {
                loginScreen.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Organizando os períodos lado a lado
        HBox hbox = new HBox(10, ptriassicPane, jcretaceousPane, cenomanianPane, pliocenePane);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: #000000;");
        
        // O layout principal é o VBox, contendo o HBox e o botão
        VBox mainLayout = new VBox(10, hbox, backButton);
        mainLayout.setAlignment(Pos.BOTTOM_LEFT);
        mainLayout.setStyle("-fx-background-color: #000000; -fx-padding: 10;");

        // Ajustando o tamanho da tela
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        Scene scene = new Scene(mainLayout, 1280, 720);
        primaryStage.setTitle("Selecione um Período da Terra");
        primaryStage.setScene(scene);

        // Exibe a janela
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}