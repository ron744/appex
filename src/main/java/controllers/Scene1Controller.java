package controllers;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.NoticeTable;
import utils.HibernateUtils;
import utils.TableService;


public class Scene1Controller {
    private TableService tableService = new TableService(new HibernateUtils());
    private ObservableList<NoticeTable> noticeData = FXCollections.observableArrayList();

    @FXML
    private Button myButton;
    @FXML
    private TableView<NoticeTable> myTable;
    @FXML
    private TableColumn<NoticeTable, String> noticeColumn;
    @FXML
    private TableColumn<NoticeTable, String> dateColumn;

    @FXML
    void initialize(){
        initData();

        noticeColumn.setCellValueFactory(new PropertyValueFactory<>("record"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        myTable.setItems(noticeData);

        myButton.setOnAction(event -> {
            myButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/scenes/MyScene2.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SecondForm");
            stage.show();
        });
    }

    private void initData(){
        noticeData.addAll(tableService.getAllElements());
    }
}
