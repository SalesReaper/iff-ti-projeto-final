package terraanciaapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Selection extends Application {

    public void start(Stage primaryStage) {
        // Configurando o período Permo-Triássico (Caminho da logo e o tamnho)
//        Image ptriassicLogo = new Image(getClass().getResourceAsStream("/resources/ptriassic_logo.png"));
//        ImageView ptriassicView = new ImageView(ptriassicLogo);
//        ptriassicView.setFitHeight(100);
//        ptriassicView.setFitWidth(100);

        Label ptriassicTitle = new Label("Permo-Triássico");
        ptriassicTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;"); // Tamanho da fonte e cor

        Label ptriassicDescription = new Label
        		(
        		""
        		+ "\n"
        		+ "\n"
        		+ "A extinção do Permiano-Triássico ou"
        		+ "\n"
        		+ "extinção Permo-Triássica, também"
        		+ "\n"
        		+ "conhecida informalmente como"
        		+ "\n"
        		+ "Great Dying (em português: Grande Morte), "
        		+ "\n"
        		+ "foi uma extinção em massa ocorrida "
        		+ "\n"
        		+ "por volta de 252 milhões de anos atrás,"
        		+ "\n"
        		+ "determinando a passagem do período "
        		+ "\n"
        		+ "Permiano para o Triássico, bem como a "
        		+ "\n"
        		+ "fronteira entre as eras Paleozoica "
        		+ "\n"
        		+ "e Mesozoica."
        		);
        ptriassicDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;"); // Tamanho da fonte e cor

        // Organizar a imagem, título e descrição em um VBox (descomentar quando tiver imagem)
        VBox ptriassicInfo = new VBox(5, /*ptriassicView,*/ ptriassicTitle, ptriassicDescription);
        ptriassicInfo.setAlignment(Pos.CENTER);  // Alinhar ao centro

        Rectangle ptriassicBackground = new Rectangle(320, 695);
        ptriassicBackground.setFill(Color.BLUEVIOLET);
        
        StackPane ptriassicPane = new StackPane(ptriassicBackground, ptriassicInfo);
        ptriassicPane.setOnMouseClicked(event -> {
            Permo_Triassic earth3D = new Permo_Triassic();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Jurássico-Cretáceo (Caminho da logo e o tamnho)
//        Image jcretaceousLogo = new Image(getClass().getResourceAsStream("/resources/jcretaceous_logo.png"));
//        ImageView jcretaceousView = new ImageView(jcretaceousLogo);
//        jcretaceousView.setFitHeight(100);
//        jcretaceousView.setFitWidth(100);

        Label jcretaceousTitle = new Label("Jurássico-Cretáceo");
        jcretaceousTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;");

        Label jcretaceousDescription = new Label("blá blá blá");
        jcretaceousDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        // Organizar a imagem, título e descrição em um VBox (descomentar quando tiver imagem)
        VBox jcretaceousInfo = new VBox(5, /*jcretaceousView,*/ jcretaceousTitle, jcretaceousDescription);
        jcretaceousInfo.setAlignment(Pos.CENTER);

        Rectangle jcretaceousBackground = new Rectangle(320, 695);
        jcretaceousBackground.setFill(Color.DARKBLUE);

        StackPane jcretaceousPane = new StackPane(jcretaceousBackground, jcretaceousInfo);
        jcretaceousPane.setOnMouseClicked(event -> {
            Jurassic_Cretaceous earth3D = new Jurassic_Cretaceous();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Cenomaniano (Caminho da logo e o tamnho)
//        Image cenomanianLogo = new Image(getClass().getResourceAsStream("/resources/cenomanian_logo.png"));
//        ImageView cenomanianView = new ImageView(cenomanianLogo);
//        cenomanianView.setFitHeight(100);
//        cenomanianView.setFitWidth(100);

        Label cenomanianTitle = new Label("Cenomaniano");
        cenomanianTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;");

        Label cenomanianDescription = new Label("blá blá blá");
        cenomanianDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");
        
        // Organizar a imagem, título e descrição em um VBox (descomentar quando tiver imagem)
        VBox cenomanianInfo = new VBox(5, /*cenomanianView,*/ cenomanianTitle, cenomanianDescription);
        cenomanianInfo.setAlignment(Pos.CENTER);

        Rectangle cenomanianBackground = new Rectangle(320, 695);
        cenomanianBackground.setFill(Color.DARKKHAKI);

        StackPane cenomanianPane = new StackPane(cenomanianBackground, cenomanianInfo);
        cenomanianPane.setOnMouseClicked(event -> {
            Cenomanian earth3D = new Cenomanian();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Plioceno (Caminho da logo e o tamnho)
//        Image plioceneLogo = new Image(getClass().getResourceAsStream("/resources/pliocene_logo.png"));
//        ImageView plioceneView = new ImageView(plioceneLogo);
//        plioceneView.setFitHeight(100);
//        plioceneView.setFitWidth(100);

        Label plioceneTitle = new Label("Plioceno");
        plioceneTitle.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-weight: bold;");

        Label plioceneDescription = new Label("blá blá blá");
        plioceneDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        // Organizar a imagem, título e descrição em um VBox (descomentar quando tiver imagem)
        VBox plioceneInfo = new VBox(5, /*plioceneView,*/ plioceneTitle, plioceneDescription);
        plioceneInfo.setAlignment(Pos.CENTER);

        Rectangle plioceneBackground = new Rectangle(320, 695);
        plioceneBackground.setFill(Color.GREEN);

        StackPane pliocenePane = new StackPane(plioceneBackground, plioceneInfo);
        pliocenePane.setOnMouseClicked(event -> {
            Pliocene earth3D = new Pliocene();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Organizando os períodos lado a lado
        HBox hbox = new HBox(10, ptriassicPane, jcretaceousPane, cenomanianPane, pliocenePane);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: #000000;");
        
        // O layout principal é o VBox, contendo o HBox e o botão
        VBox mainLayout = new VBox(10, hbox);
        mainLayout.setStyle("-fx-background-color: #000000; -fx-padding: 10;");

        // Ajustando o tamanho da tela
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);

        Scene scene = new Scene(mainLayout);
        primaryStage.setTitle("Selecione um Período da Terra");
        primaryStage.setScene(scene);
        
        // Exibe a janela
        primaryStage.show();
    }
}