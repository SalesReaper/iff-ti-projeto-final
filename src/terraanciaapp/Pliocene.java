package terraanciaapp;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pliocene extends Application {

    private static final int WIDTH = 1366;
    private static final int HEIGHT = 768;

    private double mouseX;
    private boolean isAutomaticRotation = false;
    private RotateTransition rotateTransition;
    private Rotate yRotate;

    public void start(Stage primaryStage) {
        
    	// Título da Interface selecionada
    	Text plioceneTitle = new Text("Plioceno");
    	plioceneTitle.setStyle(
    	    "-fx-font-family: 'Orbitron', sans-serif;" +
    	    "-fx-font-size: 14px;" +
    	    "-fx-fill: white;" +  // Definindo a cor branca para o texto
    	    "-fx-font-weight: bold;"
    	);

    	// Informações do período
    	Text plioceneText = new Text(
    	    "O Plioceno foi marcado por mudanças "
    	    + "\n"
    	    + "climáticas significativas, com o "
    	    + "\n"
    	    + "resfriamento global que levou à "
    	    + "\n"
    	    + "formação de grandes calotas polares. "
    	    + "\n"
    	    + "Neste período, surgiram os primeiros "
    	    + "\n"
    	    + "humanos ancestrais, e muitos grandes "
    	    + "\n"
    	    + "mamíferos, como mamutes, prosperaram."
    	);
    	plioceneText.setStyle(
    	    "-fx-font-family: 'Orbitron', sans-serif;" +
    	    "-fx-font-size: 12px;" +
    	    "-fx-fill: white;" +  // Definindo a cor branca para o texto
    	    "-fx-font-weight: bold;" +
    	    "-fx-padding: 10px 20px;"
    	);
        
        // Caixa com o título e o texto
        VBox plioceneBox = new VBox(10);
        plioceneBox.setPadding(new Insets(10));
        
        // Adiciona título e o texto ao VBox
        plioceneBox.getChildren().addAll(plioceneTitle, plioceneText);
        plioceneBox.setAlignment(Pos.TOP_LEFT);
        
        
        // Criar a esfera da Terra
        Sphere earth = new Sphere(220);

        PhongMaterial earthMaterial = new PhongMaterial();
        Image earthImage = new Image(getClass().getResourceAsStream("/resources/earth_pliocene_texture.jpg")); // caminho da textura
        earthMaterial.setDiffuseMap(earthImage);
        earth.setMaterial(earthMaterial);
        
        // Criar a esfera da lua
        Sphere moon = new Sphere(55);
        // Posicionando no espaço 3D em relação à Terra
        moon.setTranslateX(-200);
        moon.setTranslateY(200);
        moon.setTranslateZ(-200);
        
        PhongMaterial moonMaterial = new PhongMaterial();
        Image moonImage = new Image(getClass().getResourceAsStream("/resources/moon_texture.jpg")); // caminho da textura
        moonMaterial.setDiffuseMap(moonImage);
        moon.setMaterial(moonMaterial);
        
        // Configuração da imagem de fundo (espaço)
        Image backgroundImage = new Image(getClass().getResourceAsStream("/resources/space_background.jpg"));
        BackgroundImage background = new BackgroundImage
        		(
        		backgroundImage,
                BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, 
                BackgroundSize.DEFAULT
                );


        Button backButton = new Button("Voltar");
        backButton.setStyle(
        	"-fx-background-color: #778899;" +
        	"-fx-text-fill: white;" +
        	"-fx-font-family: 'Orbitron', sans-serif;" +
        	"-fx-font-size: 16px;" +
        	"-fx-font-weight: bold;" +
        	"-fx-padding: 10px 20px;" +
        	"-fx-background-radius: 10px;" +
        	"-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 5, 0.3, 2, 2);" +
        	"-fx-cursor: hand;"
        );
        backButton.setOnAction(event -> {
            // Volta para a tela anterior
            Selection selectionScreen = new Selection();
            try {
                selectionScreen.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button autoRotateButton = new Button("Rotação Automática");
        autoRotateButton.setStyle(
            "-fx-background-color: #778899;" +
            "-fx-text-fill: white;" +
            "-fx-font-family: 'Orbitron', sans-serif;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 10px 20px;" +
            "-fx-background-radius: 10px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 5, 0.3, 2, 2);" +
            "-fx-cursor: hand;"
        );

        Button manualRotateButton = new Button("Rotação Manual");
        manualRotateButton.setStyle(
        	"-fx-background-color: #778899;" +
        	"-fx-text-fill: white;" +
        	"-fx-font-family: 'Orbitron', sans-serif;" +
        	"-fx-font-size: 16px;" +
        	"-fx-font-weight: bold;" +
        	"-fx-padding: 10px 20px;" +
        	"-fx-background-radius: 10px;" +
        	"-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 5, 0.3, 2, 2);" +
        	"-fx-cursor: hand;"
        );

        // Caixa de botões inferior
        HBox buttonBox2 = new HBox(10, autoRotateButton, manualRotateButton, backButton);
        buttonBox2.setStyle("-fx-padding: 10;");

        // Cria textos para os continentes
        Text africa3D = new Text("África");
        africa3D.setStyle(
        	    "-fx-font-size: 20px;" + 
        	    "-fx-font-weight: bold;" + 
        	    "-fx-fill: white;" + 
        	    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.5, 2, 2);"
        	);
        // Posicionando no espaço 3D em relação à Terra
        africa3D.setTranslateX(50);
        africa3D.setTranslateY(-20);
        africa3D.setTranslateZ(-230);
        // Inclinação para alinhar à superfície
        africa3D.getTransforms().add(new Rotate(-20, Rotate.Y_AXIS));

        Text america3D = new Text("América");
        america3D.setStyle(
        	    "-fx-font-size: 20px;" + 
        	    "-fx-font-weight: bold;" + 
        	    "-fx-fill: white;" + 
        	    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.5, 2, 2);"
        	);
        // Posicionando no espaço 3D em relação à Terra
        america3D.setTranslateX(-235);
        america3D.setTranslateY(-20);
        america3D.setTranslateZ(-20);
        // Inclinação para alinhar à superfície 
        america3D.getTransforms().add(new Rotate(75, Rotate.Y_AXIS)); 
        
        Text europa3D = new Text("Europa");
        europa3D.setStyle(
        	    "-fx-font-size: 20px;" + 
        	    "-fx-font-weight: bold;" + 
        	    "-fx-fill: white;" + 
        	    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.5, 2, 2);"
        	);
        // Posicionando no espaço 3D em relação à Terra
        europa3D.setTranslateX(65);
        europa3D.setTranslateY(-130);
        europa3D.setTranslateZ(-180);
        // Inclinação para alinhar à superfície 
        europa3D.getTransforms().add(new Rotate(-35, Rotate.X_AXIS)); 
        europa3D.getTransforms().add(new Rotate(-25, Rotate.Y_AXIS)); 
        europa3D.getTransforms().add(new Rotate(-14, Rotate.Z_AXIS));
        
        Text asia3D = new Text("Ásia");
        asia3D.setStyle(
        	    "-fx-font-size: 20px;" + 
        	    "-fx-font-weight: bold;" + 
        	    "-fx-fill: white;" + 
        	    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.5, 2, 2);"
        	);
        // Posicionando no espaço 3D em relação à Terra
        asia3D.setTranslateX(210);
        asia3D.setTranslateY(-90);
        asia3D.setTranslateZ(-20);
        // Inclinação para alinhar à superfície 
        asia3D.getTransforms().add(new Rotate(95, Rotate.X_AXIS)); 
        asia3D.getTransforms().add(new Rotate(-110, Rotate.Y_AXIS)); 
        asia3D.getTransforms().add(new Rotate(95, Rotate.Z_AXIS)); 
        
        Text oceania3D = new Text("Oceania");
        oceania3D.setStyle(
        	    "-fx-font-size: 20px;" + 
        	    "-fx-font-weight: bold;" + 
        	    "-fx-fill: white;" + 
        	    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.5, 2, 2);"
        	);
        // Posicionando no espaço 3D em relação à Terra
        oceania3D.setTranslateX(170);
        oceania3D.setTranslateY(60);
        oceania3D.setTranslateZ(150);
        // Inclinação para alinhar à superfície 
        oceania3D.getTransforms().add(new Rotate(165, Rotate.X_AXIS)); 
        oceania3D.getTransforms().add(new Rotate(-40, Rotate.Y_AXIS)); 
        oceania3D.getTransforms().add(new Rotate(170, Rotate.Z_AXIS)); 
        
        // Agrupar a Terra e os textos em um único grupo para que os textos sigam a Terra
        Group earthGroup = new Group(earth, africa3D, america3D, europa3D, asia3D, oceania3D);
        
        // Layout principal usando BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(earthGroup);
        root.setRight(moon);
        root.setBottom(buttonBox2);
        root.setBackground(new Background(background));
        
        // Adiciona o VBox
        root.setLeft(plioceneBox);
        
        // Configurando a câmera
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);

        // Configuração inicial da Terra
        earthGroup.translateXProperty().set(WIDTH / -100);
        earthGroup.translateYProperty().set(HEIGHT / 100);
        
     // Controles de zoom com o scroll do mouse
        scene.setOnScroll(event -> {
            double zoomFactor = event.getDeltaY() > 0 ? -100 : 100;
            double newTranslateZ = earthGroup.getTranslateZ() + zoomFactor;
            double newTranslateZ2 = moon.getTranslateZ() + zoomFactor;

            // Limitar o zoom entre dois valores (ex: -500 e 500)
            if (newTranslateZ > -500 && newTranslateZ < 100) {
                earthGroup.translateZProperty().set(newTranslateZ);
            }
            if (newTranslateZ2 > -700 && newTranslateZ2 < -100) {
                moon.translateZProperty().set(newTranslateZ2);
            }
        });
        
        // Inicializa a rotação manual
        yRotate = new Rotate(0, Rotate.Y_AXIS);
        earthGroup.getTransforms().add(yRotate);

        scene.setOnMousePressed((MouseEvent event) -> {
            mouseX = event.getSceneX();
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            if (!isAutomaticRotation) {
                double deltaX = event.getSceneX() - mouseX;
                mouseX = event.getSceneX();
                yRotate.setAngle(yRotate.getAngle() - deltaX);
            }
        });

        // Ação do botão de rotação automática
        autoRotateButton.setOnAction(event -> {
            if (!isAutomaticRotation) {
                rotateTransition = new RotateTransition(Duration.seconds(200), earthGroup);
                rotateTransition.setAxis(Rotate.Y_AXIS);
                rotateTransition.setByAngle(3600);
                rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
                rotateTransition.play();

                isAutomaticRotation = true;
            }
        });

        // Ação do botão de rotação manual
        manualRotateButton.setOnAction(event -> {
            if (isAutomaticRotation) {
                rotateTransition.stop();
                isAutomaticRotation = false;
            }
        });
        
        primaryStage.setTitle("Plioceno");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}