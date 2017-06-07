package fx;

import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoaderModel {
	private final SimpleObjectProperty<LocalDateTime> time;
	private final StringProperty source;
	private final StringProperty destination;
	private final StringProperty type;
	private final StringProperty status;
	
	public LoaderModel() {
		this(null, null, null, null, null);
	}
	
	public LoaderModel(LocalDateTime ldt, String source, String destination, String type, String status) {
		this.time = new SimpleObjectProperty<LocalDateTime>(ldt);
		this.source = new SimpleStringProperty(source);
		this.destination = new SimpleStringProperty(destination);
		this.type = new SimpleStringProperty(type);
		this.status =  new SimpleStringProperty(status);
	}
	
	//Дата выполнения загрузки
    public LocalDateTime getTime() {
        return time.get();
    }

    public void setTime(LocalDateTime time) {
        this.time.set(time);
    }

    public ObjectProperty<LocalDateTime> timeProperty() {
        return time;
    }

    
    //Адрес загрузки
    public String getSource() {
        return source.get();
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public StringProperty sourceProperty() {
        return source;
    }

    
    //Место выгрузки
    public String getDestination() {
        return source.get();
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    
    //Тип программы для обработки
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }

    
    //Статус обработки задания
    public String getStatus() {
        return type.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }

}
