package test.fx.view;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import test.fx.App;
import test.fx.model.LoaderModel;

public class LoaderController {

    @FXML
    private TableView<LoaderModel> loaderTable;
    @FXML
    private TableColumn<LoaderModel, LocalDateTime> timeColumn;
    @FXML
    private TableColumn<LoaderModel, String> sourceColumn;
    @FXML
    private TableColumn<LoaderModel, String> destinationColumn;
    @FXML
    private TableColumn<LoaderModel, String> typeColumn;
    @FXML
    private TableColumn<LoaderModel, String> statusColumn;

    // Ссылка на главное приложение.
    private App App;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public LoaderController() {
    }
  
    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @SuppressWarnings("restriction")
	@FXML
    private void initialize() {
        // Инициализация таблицы адресатов с пятью столбцами.
    	timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        sourceColumn.setCellValueFactory(cellData -> cellData.getValue().sourceProperty());
        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        
        Double currentWidth = timeColumn.prefWidthProperty().get();
        currentWidth += sourceColumn.prefWidthProperty().get();
        currentWidth += destinationColumn.prefWidthProperty().get();
        currentWidth += typeColumn.prefWidthProperty().get();
        currentWidth += statusColumn.prefWidthProperty().get();

        timeColumn.prefWidthProperty().bind(loaderTable.widthProperty().multiply(
        		(timeColumn.widthProperty().get()/currentWidth)));
        sourceColumn.prefWidthProperty().bind(loaderTable.widthProperty().multiply(
        		(sourceColumn.widthProperty().get()/currentWidth)));
        destinationColumn.prefWidthProperty().bind(loaderTable.widthProperty().multiply(
        		(destinationColumn.widthProperty().get()/currentWidth)));
        typeColumn.prefWidthProperty().bind(loaderTable.widthProperty().multiply(
        		(typeColumn.widthProperty().get()/currentWidth)));
        statusColumn.prefWidthProperty().bind(loaderTable.widthProperty().multiply(
        		(statusColumn.widthProperty().get()/currentWidth)));
       
    }
    
    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     * 
     * @param mainApp
     */
    public void setApp(App App) {
        this.App = App;

        // Добавление в таблицу данных из наблюдаемого списка
        loaderTable.setItems(App.getLoaderModelData());
     }

 
}
