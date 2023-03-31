package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.Car;
import models.DataService;
import models.api.Restapi;

public class MainView extends VBox {

    Label carsLabel;
    DataService datasService;
    Restapi restapi;
    TableView<Car> tableView;

    public MainView() {
        carsLabel = new Label("Autók");

        this.initData();
        this.initTable();
        this.getChildren().add(carsLabel);
        this.getChildren().add(tableView);
    }

    private void initTable() {
        tableView = new TableView<>();

        TableColumn<Car, Integer> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));


        TableColumn<Car, String> nameCol = new TableColumn<>("Név");
        nameCol.setMinWidth(50);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,String>>() {

            @Override
            public void handle(CellEditEvent<Car, String> event) {
                Car car = event.getRowValue();
                car.setName(event.getNewValue());
            }
        });


        TableColumn<Car, String> brandCol = new TableColumn<>("Márka");
        brandCol.setMinWidth(50);
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        brandCol.setCellFactory(TextFieldTableCell.forTableColumn());
        brandCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,String>>() {

            @Override
            public void handle(CellEditEvent<Car, String> event) {
                Car car = event.getRowValue();
                car.setBrand(event.getNewValue());
            }
        });


        TableColumn<Car, String> platenumberCol = new TableColumn<>("Rendszám");
        platenumberCol.setMinWidth(50);
        platenumberCol.setCellValueFactory(new PropertyValueFactory<>("platenumber"));
        platenumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        platenumberCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,String>>() {

            @Override
            public void handle(CellEditEvent<Car, String> event) {
                Car car = event.getRowValue();
                car.setPlatenumber(event.getNewValue());
            }
        });


        TableColumn<Car, Integer> quantityCol = new TableColumn<>("Mennyiség");
        quantityCol.setMinWidth(50);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,Integer>>() {

            @Override
            public void handle(CellEditEvent<Car, Integer> event) {
                Car car = event.getRowValue();
                car.setQuantity(event.getNewValue());
            }
        });


        TableColumn<Car, Integer> spaceCol = new TableColumn<>("Férőhely");
        spaceCol.setMinWidth(50);
        spaceCol.setCellValueFactory(new PropertyValueFactory<>("space"));
        spaceCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        spaceCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,Integer>>() {

            @Override
            public void handle(CellEditEvent<Car, Integer> event) {
                Car car = event.getRowValue();
                car.setSpace(event.getNewValue());
            }    
        });


        TableColumn<Car, String> gearboxCol = new TableColumn<>("Váltó");
        gearboxCol.setMinWidth(50);
        gearboxCol.setCellValueFactory(new PropertyValueFactory<>("gearbox"));
        gearboxCol.setCellFactory(TextFieldTableCell.forTableColumn());
        gearboxCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,String>>() {

            @Override
            public void handle(CellEditEvent<Car, String> event) {
                Car car = event.getRowValue();
                car.setGearbox(event.getNewValue());
            }
        });


        TableColumn<Car, Double> priceCol = new TableColumn<>("Ár");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        priceCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car,Double>>() {

            @Override
            public void handle(CellEditEvent<Car, Double> event) {
                Car car = event.getRowValue();
                car.setPrice(event.getNewValue());
            }
        });

        tableView.setEditable(true);

        

        // Restapi restApi = new Restapi();
        // boolean success = restApi.checkUrl("http://localhost:8000");
        // if(success) {
        //     tableView.setItems(this.getCars());
        // }else {
        //     System.out.println("A REST API nem elérhető!");
        // }

        tableView.setItems(this.getCars());

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(brandCol);
        tableView.getColumns().add(platenumberCol);
        tableView.getColumns().add(quantityCol);
        tableView.getColumns().add(spaceCol);
        tableView.getColumns().add(gearboxCol);
        tableView.getColumns().add(priceCol);
    }

    private ObservableList<Car> getCars() {
        ObservableList<Car> carsList =
        FXCollections.observableArrayList(restapi.getCars());
        return carsList;
    }

    private void initData() {
        this.restapi = new Restapi();
    }
}
