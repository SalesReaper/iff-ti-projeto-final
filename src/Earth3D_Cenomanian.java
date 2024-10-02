import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

public class Earth3D_Cenomanian extends Application {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;

    private double mouseX;
    private boolean isAutomaticRotation = false;
    private RotateTransition rotateTransition;
    private Rotate yRotate;

    public void start(Stage primaryStage) {
        // Caixa de botões no canto superior esquerdo
        VBox buttonBox1 = new VBox(10);
        buttonBox1.setPadding(new Insets(10));
        
        Text sText = new Text("Sobre os Períodos");
        sText.setStyle("-fx-font-size: 16px; -fx-fill: white;");  // Estilizando o texto
        
        Button ptriassicButton = new Button("Permo-Triássico");
        Button jcretaceousButton = new Button("Jurássico-Cretáceo");
        Button cenomanianButton = new Button("Cenomaniano");
        Button plioceneButton = new Button("Plioceno");

        // Adicionar título e botões ao VBox
        buttonBox1.getChildren().addAll(sText, ptriassicButton, jcretaceousButton, cenomanianButton, plioceneButton);

        // Posicionar os botões no canto superior esquerdo
        AnchorPane anchorPane = new AnchorPane(buttonBox1);
        AnchorPane.setTopAnchor(buttonBox1, 10.0);  // Ajuste para dar espaço no topo
        AnchorPane.setLeftAnchor(buttonBox1, 10.0);
        
        // Ação ao clicar no botão Permo-Triássico
        ptriassicButton.setOnAction(event -> {
            TextScreen textScreen = new TextScreen();
            try {
                textScreen.start(primaryStage);
                textScreen.scrollToText("Permo-Triássico");  // Rola até o Permo-Triássico
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Ação ao clicar no botão Jurássico-Cretáceo
        jcretaceousButton.setOnAction(event -> {
            TextScreen textScreen = new TextScreen();
            try {
                textScreen.start(primaryStage);
                textScreen.scrollToText("Jurássico-Cretáceo");  // Rola até o Jurássico-Cretáceo
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Ação ao clicar no botão Cenomaniano
        cenomanianButton.setOnAction(event -> {
            TextScreen textScreen = new TextScreen();
            try {
                textScreen.start(primaryStage);
                textScreen.scrollToText("Cenomaniano");  // Rola até o Cenomaniano
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Ação ao clicar no botão Plioceno
        plioceneButton.setOnAction(event -> {
            TextScreen textScreen = new TextScreen();
            try {
                textScreen.start(primaryStage);
                textScreen.scrollToText("Plioceno");  // Rola até o Cambriano
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Criar a esfera da Terra
        Sphere earth = new Sphere(220);

        PhongMaterial earthMaterial = new PhongMaterial();
        Image earthImage = new Image("file:earth_cenomanian_texture.jpg"); // caminho da textura
        earthMaterial.setDiffuseMap(earthImage);
        earth.setMaterial(earthMaterial);

        // Estilizando os botões inferiores
        String buttonStyle = "-fx-font-size: 14px; -fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5;";
        String hoverStyle = "-fx-background-color: #45a049;";

        Button backButton = new Button("Voltar");
        backButton.setStyle(buttonStyle);
        backButton.setOnMouseEntered(e -> backButton.setStyle(hoverStyle));
        backButton.setOnMouseExited(e -> backButton.setStyle(buttonStyle));
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
        Button manualRotateButton = new Button("Rotação Manual");

        autoRotateButton.setStyle(buttonStyle);
        manualRotateButton.setStyle(buttonStyle);

        // Caixa de botões inferior
        HBox buttonBox2 = new HBox(10, autoRotateButton, manualRotateButton, backButton);
        buttonBox2.setStyle("-fx-padding: 10;");

        // Layout principal usando BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(earth);
        root.setBottom(buttonBox2);
        root.setStyle("-fx-background-color: black;");
        
        // Adicionar o AnchorPane dos botões no topo
        root.setTop(anchorPane);

        // Configurando a câmera
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);

        // Configuração inicial da Terra
        earth.translateXProperty().set(WIDTH / 30);
        earth.translateYProperty().set(HEIGHT / 30);

        // Inicializa a rotação manual
        yRotate = new Rotate(0, Rotate.Y_AXIS);
        earth.getTransforms().add(yRotate);

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
                rotateTransition = new RotateTransition(Duration.seconds(30), earth);
                rotateTransition.setAxis(Rotate.Y_AXIS);
                rotateTransition.setByAngle(360);
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

        primaryStage.setTitle("Terra 3D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
