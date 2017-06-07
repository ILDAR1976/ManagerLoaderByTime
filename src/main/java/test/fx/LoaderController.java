package test.fx;

import java.time.LocalDateTime;

import fx.LoaderModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
