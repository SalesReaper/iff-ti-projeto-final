import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Earth3D_Jurassic_Cretaceous extends Application {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;

    private double mouseX;
    private boolean isAutomaticRotation = false; // Controla se a rotação automática está ativa
    private RotateTransition rotateTransition;
    private Rotate yRotate; // Mantendo o controle de rotação manual

    public void start(Stage primaryStage) {
        Sphere earth = new Sphere(150);

        PhongMaterial earthMaterial = new PhongMaterial();
        Image earthImage = new Image("file:earth_jcretaceous_texture.jpg"); // caminho da textura
        earthMaterial.setDiffuseMap(earthImage);
        earth.setMaterial(earthMaterial);

        // Estilizando os botões
        String buttonStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; "
                + "-fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5;";
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
        
        autoRotateButton.setOnMouseEntered(e -> autoRotateButton.setStyle(hoverStyle));
        autoRotateButton.setOnMouseExited(e -> autoRotateButton.setStyle(buttonStyle));

        manualRotateButton.setOnMouseEntered(e -> manualRotateButton.setStyle(hoverStyle));
        manualRotateButton.setOnMouseExited(e -> manualRotateButton.setStyle(buttonStyle));

        // Organizando os botões em um HBox
        HBox buttonBox = new HBox(10, autoRotateButton, manualRotateButton, backButton);
        buttonBox.setStyle("-fx-padding: 10;");

        // Layout principal usando BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(earth);
        root.setBottom(buttonBox);
        root.setStyle("-fx-background-color: black;"); // Cor de fundo do BorderPane

        // Configurando a câmera
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.BLACK); // Cor de fundo da cena
        scene.setCamera(camera);
        
        earth.translateXProperty().set(WIDTH / 15);
        earth.translateYProperty().set(HEIGHT / 15);
        
        // Inicializa a rotação manual
        yRotate = new Rotate(0, Rotate.Y_AXIS);
        earth.getTransforms().add(yRotate);

        scene.setOnMousePressed((MouseEvent event) -> {
            mouseX = event.getSceneX();
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            if (!isAutomaticRotation) { // Somente permite rotação manual quando a automática estiver desativada
                double deltaX = event.getSceneX() - mouseX;
                mouseX = event.getSceneX();
                yRotate.setAngle(yRotate.getAngle() - deltaX); // Ajuste do sentido da rotação
            }
        });

        // Ação do botão de rotação automática
        autoRotateButton.setOnAction(event -> {
            if (!isAutomaticRotation) {
                // Inicia a rotação automática
                rotateTransition = new RotateTransition(Duration.seconds(30), earth);
                rotateTransition.setAxis(Rotate.Y_AXIS);
                rotateTransition.setByAngle(360);
                rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
                rotateTransition.play(); // Inicia a rotação automática

                isAutomaticRotation = true; // Atualiza o estado
            }
        });

        // Ação do botão de rotação manual
        manualRotateButton.setOnAction(event -> {
            if (isAutomaticRotation) {
                rotateTransition.stop(); // Para a rotação automática
                isAutomaticRotation = false; // Atualiza o estado
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