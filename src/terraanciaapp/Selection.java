package terraanciaapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;  // Importando VBox
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Selection extends Application {

    public void start(Stage primaryStage) {
        // Configurando o período Permo-Triássico (Caminho da logo e o tamnho)
        Image ptriassicLogo = new Image(getClass().getResourceAsStream("/resources/logo_ptriassic.jpg"));
        ImageView ptriassicView = new ImageView(ptriassicLogo);
        ptriassicView.setFitHeight(100);
        ptriassicView.setFitWidth(100);

        Label ptriassicTitle = new Label("Permo-Triássico");
        ptriassicTitle.setStyle("-fx-font-size: 30px; -fx-text-fill: #E0E0E0; -fx-font-family: 'Segoe UI', Arial; -fx-font-weight: bold;"); // Tamanho da fonte e cor

        Label ptriassicDescription = new Label(
                "A extinção do Permiano-Triássico "
                + "\n"
                + "ou extinção Permo-Triássica, "
                + "\n"
                + "também conhecida informalmente "
                + "\n"
                + "como Great Dying "
                + "\n"
                + "(em português: Grande Morte), "
                + "\n"
                + "foi uma extinção em massa "
                + "\n"
                + "ocorrida por volta de 252 "
                + "\n"
                + "milhões de anos atrás, determinando "
                + "\n"
                + "a passagem do período Permiano "
                + "\n"
                + "para o Triássico, bem como a "
                + "\n"
                + "fronteira entre as eras Paleozoica "
                + "\n"
                + "e Mesozoica."
        );
        ptriassicDescription.setStyle("-fx-font-size: 16px; -fx-text-fill: #FFFFFF; -fx-wrap-text: true;"); // Tamanho da fonte e cor

        // Organizar a imagem, título e descrição em um VBox
        VBox ptriassicInfo = new VBox(5, ptriassicView, ptriassicTitle, ptriassicDescription);
        ptriassicInfo.setAlignment(Pos.CENTER);  // Alinhar ao centro

        Rectangle ptriassicBackground = new Rectangle(320, 695);
        ptriassicBackground.setFill(Color.DARKSLATEBLUE); // Tom escuro de azul
        
        StackPane ptriassicPane = new StackPane(ptriassicBackground, ptriassicInfo);
        ptriassicPane.setOnMouseClicked(event -> {
            Permo_Triassic earth3D = new Permo_Triassic();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Jurássico-Cretáceo
        Image jcretaceousLogo = new Image(getClass().getResourceAsStream("/resources/logo_jcretaceous.jpg"));
        ImageView jcretaceousView = new ImageView(jcretaceousLogo);
        jcretaceousView.setFitHeight(100);
        jcretaceousView.setFitWidth(100);

        Label jcretaceousTitle = new Label("Jurássico-Cretáceo");
        jcretaceousTitle.setStyle("-fx-font-size: 30px; -fx-text-fill: #E0E0E0; -fx-font-family: 'Segoe UI', Arial; -fx-font-weight: bold;");

        Label jcretaceousDescription = new Label(
                "O Cretáceo é o último período da "
                + "\n"
                + "Era Mesozoica. Portanto, o período "
                + "\n"
                + "que o antecede é o Jurássico, "
                + "\n"
                + "que se estendeu de 200 a 146 "
                + "\n"
                + "milhões de anos atrás."
        );
        jcretaceousDescription.setStyle("-fx-font-size: 16px; -fx-text-fill: #FFFFFF; -fx-wrap-text: true;");

        // Organizar a imagem, título e descrição em um VBox
        VBox jcretaceousInfo = new VBox(5, jcretaceousView, jcretaceousTitle, jcretaceousDescription);
        jcretaceousInfo.setAlignment(Pos.CENTER);

        Rectangle jcretaceousBackground = new Rectangle(320, 695);
        jcretaceousBackground.setFill(Color.DARKSLATEGRAY); // Tom escuro de cinza

        StackPane jcretaceousPane = new StackPane(jcretaceousBackground, jcretaceousInfo);
        jcretaceousPane.setOnMouseClicked(event -> {
            Jurassic_Cretaceous earth3D = new Jurassic_Cretaceous();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Cenomaniano
        Image cenomanianLogo = new Image(getClass().getResourceAsStream("/resources/logo_cenomanian.jpg"));
        ImageView cenomanianView = new ImageView(cenomanianLogo);
        cenomanianView.setFitHeight(100);
        cenomanianView.setFitWidth(100);

        Label cenomanianTitle = new Label("Cenomaniano");
        cenomanianTitle.setStyle("-fx-font-size: 30px; -fx-text-fill: #E0E0E0; -fx-font-family: 'Segoe UI', Arial; -fx-font-weight: bold;");

        Label cenomanianDescription = new Label(
                "Na escala de tempo geológico, o "
                + "\n"
                + "Cenomaniano é a idade da época "
                + "\n"
                + "Cretácea Superior do período "
                + "\n"
                + "Cretáceo da era Mesozoica "
                + "\n"
                + "do éon Fanerozoico que está "
                + "\n"
                + "compreendida entre "
                + "\n"
                + "há 100,5 milhões e 93,9 milhões "
                + "\n"
                + "de anos, aproximadamente."
        );
        cenomanianDescription.setStyle("-fx-font-size: 16px; -fx-text-fill: #FFFFFF; -fx-wrap-text: true;");
        
        // Organizar a imagem, título e descrição em um VBox
        VBox cenomanianInfo = new VBox(5, cenomanianView, cenomanianTitle, cenomanianDescription);
        cenomanianInfo.setAlignment(Pos.CENTER);

        Rectangle cenomanianBackground = new Rectangle(320, 695);
        cenomanianBackground.setFill(Color.MIDNIGHTBLUE); // Outro tom escuro de azul

        StackPane cenomanianPane = new StackPane(cenomanianBackground, cenomanianInfo);
        cenomanianPane.setOnMouseClicked(event -> {
            Cenomanian earth3D = new Cenomanian();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Configurando o período Plioceno
        Image plioceneLogo = new Image(getClass().getResourceAsStream("/resources/logo_pliocene.jpg"));
        ImageView plioceneView = new ImageView(plioceneLogo);
        plioceneView.setFitHeight(100);
        plioceneView.setFitWidth(100);

        Label plioceneTitle = new Label("Plioceno");
        plioceneTitle.setStyle("-fx-font-size: 30px; -fx-text-fill: #E0E0E0; -fx-font-family: 'Segoe UI', Arial; -fx-font-weight: bold;");

        Label plioceneDescription = new Label(
                "Plioceno ou pliocénico é a última "
                + "\n"
                + "época do antigo período "
                + "\n"
                + "Terciário (atual Neogeno) da "
                + "\n"
                + "era Cenozoica.Está compreendido "
                + "\n"
                + "entre há cerca de 5 e 2 milhões de "
                + "\n"
                + "anos. Divide-se nas idadesZancleana, "
                + "\n"
                + "Piacenziana e Gelasiana,da "
                + "\n"
                + "mais antiga para a mais recente. "
        );
        plioceneDescription.setStyle("-fx-font-size: 16px; -fx-text-fill: #FFFFFF; -fx-wrap-text: true;");

        // Organizar a imagem, título e descrição em um VBox
        VBox plioceneInfo = new VBox(5, plioceneView, plioceneTitle, plioceneDescription);
        plioceneInfo.setAlignment(Pos.CENTER);

        Rectangle plioceneBackground = new Rectangle(320, 695);
        plioceneBackground.setFill(Color.GRAY); // Tom escuro de cinza

        StackPane pliocenePane = new StackPane(plioceneBackground, plioceneInfo);
        pliocenePane.setOnMouseClicked(event -> {
            Pliocene earth3D = new Pliocene();
            try {
                earth3D.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Organizando os períodos lado a lado em um HBox
        HBox hbox = new HBox(10, ptriassicPane, jcretaceousPane, cenomanianPane, pliocenePane);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: #1A1A1A; -fx-padding: 10;"); // Fundo do HBox
        
        // O layout principal é o VBox, contendo o HBox
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