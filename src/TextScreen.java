import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
        permoTriassicText = new Text
        		(
        		"A extinção do Permiano-Triássico ou extinção Permo-Triássica, também conhecida informalmente como Great Dying (em português: Grande Morte), foi uma extinção em massa ocorrida por volta de 252 milhões de anos atrás, "
        		+ "\n"
        		+ "determinando a passagem do período Permiano para o Triássico, bem como a fronteira entre as eras Paleozoica e Mesozoica."
        		+ "\n"
        		+ "\n"
        		+ "Este evento é a extinção em massa de maiores proporções que já ocorreu na Terra, resultando no desaparecimento de 95% das espécies marinhas e 70% das espécies terrestres. Os dados estimam que 57% das famílias e "
        		+ "\n"
        		+ "85% dos gêneros foram ceifados. Tornou-se também o único evento de extinção em massa de insetos conhecido. Por causa de seu impacto, foi descrita como a \"mãe de todas as extinções em massa."
        		);

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

        Button backButton = new Button("Voltar");
        backButton.setOnAction(event -> {
            // Volta para a tela anterior
            Selection selectionScreen = new Selection();
            try {
                selectionScreen.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Caixa de botões inferior
        HBox buttonBox = new HBox(10, backButton);
        buttonBox.setStyle("-fx-padding: 10;");

        // Layout principal
        AnchorPane root = new AnchorPane(scrollPane);
        AnchorPane.setTopAnchor(scrollPane, 10.0);
        AnchorPane.setBottomAnchor(scrollPane, 10.0);
        AnchorPane.setLeftAnchor(scrollPane, 10.0);
        AnchorPane.setRightAnchor(scrollPane, 10.0);

        // Adiciona a caixa de botões ao layout principal
        root.getChildren().add(buttonBox);

        // Configura a posição da buttonBox no AnchorPane
        AnchorPane.setBottomAnchor(buttonBox, 10.0); // Distância do fundo
        AnchorPane.setLeftAnchor(buttonBox, 10.0);   // Distância da esquerda

        // Define a cena e a exibe
        Scene scene = new Scene(root, 1366, 768); // Tamanho da janela
        stage.setTitle("Janela de Textos");
        stage.setScene(scene);
        stage.show();
//        stage.setMaximized(true); // tela maximizada
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
