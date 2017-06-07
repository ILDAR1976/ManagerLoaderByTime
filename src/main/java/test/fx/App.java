package test.fx;

import java.io.IOException;
import java.time.LocalDateTime;

import fx.LoaderModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *  Main module
 *
 */

public class App extends Application
{
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<LoaderModel> listData = FXCollections.observableArrayList();

    
    public App(){
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    	listData.add(new LoaderModel(LocalDateTime.now(),"http:\\\\wwww.mail.ru","d:\\download","youtube","ready"));
    }
    
	public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
	    this.primaryStage = primaryStage;
	   
	    this.primaryStage.setTitle("Loader manager");

	    initRootLayout();
	    showLoaderList();
	}

	/**
     * Инициализирует корневой макет.
     */
    @SuppressWarnings("restriction")
	public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("/RootLayout.fxml"));
            
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setScene(scene);
            
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Показывает в корневом макете таблицу заданий.
     */
    public void showLoaderList() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("/LoaderList.fxml"));
            
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);
            
            // Даём контроллеру доступ к главному приложению.
            LoaderController controller = loader.getController();
            controller.setApp(this);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    /**
     * Возвращает данные в виде наблюдаемого списка заданий.
     * @return
     */
    public ObservableList<LoaderModel> getLoaderModelData() {
        return listData;
    }


}

