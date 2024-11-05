/**
 * 
 */
/**
 * 
 */
module iff {
	    // Exporta o pacote 'terraanciaapp'
	    exports terraanciaapp;

	    // Declara as dependências do JavaFX
	    requires javafx.controls; // Para controles do JavaFX
	    requires javafx.fxml;     // Se você estiver usando FXML
	    requires transitive javafx.graphics; // Adicione isso para acessar Stage e outras classes gráficas

	    // Se você estiver usando outras funcionalidades, adicione mais módulos conforme necessário
}