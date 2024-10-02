import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextScreen extends Application {

    private ScrollPane scrollPane;
    private VBox textContainer;
    private Text permoTriassicText, jurassicCretaceousText, cenomanianText, plioceneText;
    private Text permoTriassicTitle, jurassicCretaceousTitle, cenomanianTitle, plioceneTitle;

    public void start(Stage stage) {
        // Janela com ScrollPane contendo textos
        scrollPane = new ScrollPane();
        textContainer = new VBox(20);
        textContainer.setPadding(new Insets(10));

        // Cria os títulos e os textos com informações sobre os períodos
        permoTriassicTitle = new Text("Permo-Triássico");
        permoTriassicTitle.setFont(Font.font(20));  // Define o tamanho da fonte do título
        permoTriassicText = new Text("Informações sobre o período Permo-Triássico...");

        jurassicCretaceousTitle = new Text("Jurássico-Cretáceo");
        jurassicCretaceousTitle.setFont(Font.font(20));  // Define o tamanho da fonte do título
        jurassicCretaceousText = new Text("Informações sobre o período Jurássico-Cretáceo...");

        cenomanianTitle = new Text("Cenomaniano");
        cenomanianTitle.setFont(Font.font(20));  // Define o tamanho da fonte do título
        cenomanianText = new Text("Informações sobre o período Cenomaniano...");

        plioceneTitle = new Text("Plioceno");
        plioceneTitle.setFont(Font.font(20));  // Define o tamanho da fonte do título
        plioceneText = new Text("Informações sobre o período Plioceno...");

        // Adiciona os títulos e textos ao contêiner
        textContainer.getChildren().addAll(
            permoTriassicTitle, permoTriassicText,
            jurassicCretaceousTitle, jurassicCretaceousText,
            cenomanianTitle, cenomanianText,
            plioceneTitle, plioceneText
        );

        scrollPane.setContent(textContainer);

        // Layout principal
        AnchorPane root = new AnchorPane(scrollPane);
        AnchorPane.setTopAnchor(scrollPane, 10.0);
        AnchorPane.setBottomAnchor(scrollPane, 10.0);
        AnchorPane.setLeftAnchor(scrollPane, 10.0);
        AnchorPane.setRightAnchor(scrollPane, 10.0);

        // Define a cena e a exibe
        Scene scene = new Scene(root, 1280, 720); // Tamanho da janela
        stage.setTitle("Janela de Textos");
        stage.setScene(scene);
        stage.show();
    }

    // Método para rolar até o texto específico
    public void scrollToText(String periodo) {
        Text targetText = null;

        // Identifica qual texto (período) foi solicitado
        switch (periodo) {
            case "Permo-Triássico":
                targetText = permoTriassicTitle;
                break;
            case "Jurássico-Cretáceo":
                targetText = jurassicCretaceousTitle;
                break;
            case "Cenomaniano":
                targetText = cenomanianTitle;
                break;
            case "Plioceno":
                targetText = plioceneTitle;
                break;
        }

        if (targetText != null) {
            // Calcula a posição de rolagem
            double scrollPosition = (targetText.getBoundsInParent().getMinY()) / (textContainer.getHeight() - scrollPane.getHeight());
            scrollPane.setVvalue(scrollPosition);  // Ajusta a posição do ScrollPane
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
