package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.NoticeTable;
import utils.HibernateUtils;
import utils.TableService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Scene2Controller {
    private TableService  tableService = new TableService(new HibernateUtils());

    //@FXML
    //private DatePicker dataField;
    //<DatePicker fx:id="dataField" layoutX="14.0" layoutY="38.0" />
    @FXML
    private Button backButton;
    @FXML
    private Button addNoticeButton;
    @FXML
    private TextField noticeField;
    @FXML
    private TextField dataField1;

    @FXML
    void initialize(){
        initDate();

        addNoticeButton.setOnAction(event -> {
            String notice = noticeField.getText();
            //LocalDate date = dataField.getValue();
            String date = dataField1.getText();
            System.out.println("!!!!!!!!!!!!!!!!!!" + date);

            tableService.add(new NoticeTable(date, notice));

            clearFields();
        });

        backButton.setOnAction(event -> {
            tableService.getAllElements();

            backButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/scenes/MyScene1.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("FirstForm");
            stage.show();
        });
    }

    private void clearFields(){
        noticeField.clear();
    }

    private void initDate(){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dataField1.setText(df.format(new Date()));
    }
}