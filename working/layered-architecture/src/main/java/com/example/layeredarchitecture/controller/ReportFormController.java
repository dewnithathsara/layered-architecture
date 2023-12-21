package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.DAO.custom.OrderDAO;
import com.example.layeredarchitecture.DAO.impl.OrderDAOimpl;
import com.example.layeredarchitecture.DAO.impl.QueryDAOimpl;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.view.tdm.OrderDetailTM;
import com.example.layeredarchitecture.view.tdm.ReportTM;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportFormController {
    public ImageView home;
    public ComboBox cmbOrderId;
    public TableView tbleItem;
    public TableColumn colItemName;
    public TableColumn colqTY;
    public AnchorPane root;
    OrderDAO dao=new OrderDAOimpl();
    QueryDAOimpl queryDAOimpl=new QueryDAOimpl();

    public void initialize(){
        getAllId();
    }
    public void homeOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void cmbOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      //  String id= cmbOrderId.getValue().toString();



    }
    public void getAllId(){
        ObservableList<String> oblist = FXCollections.observableArrayList();
        try {
            List<OrderDTO> dto =dao.getAll();
            for (OrderDTO dtos : dto) {
                oblist.add(dtos.getOrderId());
            }
            cmbOrderId.setItems(oblist);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
