package ehu.isad.controller.ui;

import ehu.isad.main;
import ehu.isad.controller.db.MainKud;
import ehu.isad.main;
import ehu.isad.models.klasePrintzipala;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;

public class MainUI implements Initializable{

    private main main;

    @Override  //pantaila iditzerakoan agertu beharrekoa
    public void initialize(URL location, ResourceBundle resources) {

        //this.pantailaKargatu();
    }

    public void setMainApp(ehu.isad.main main) {
        this.main = main;
    }

    //dauden botoiak jarri
    @FXML
    private Button btn_check;

    @FXML
    private TextField txtUrl;

    @FXML
    private TableView tblTaula;

    @FXML
    private TableColumn tblURL;

    @FXML
    private TableColumn tblmd5;

    @FXML
    private TableColumn tblVersion;

    @FXML
    private Label lblLabela;

    //beste pantaila batera eramateko botoiak
    @FXML
    void klikEgin(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        pantailaKargatu();
    }


    //metodoak,taulak betetzeko...
    public void pantailaKargatu() throws IOException, NoSuchAlgorithmException {
        String url1= txtUrl.getText();
        String url= txtUrl.getText()+ "/README";
        String md5= MessageDigestForUrl.lortumd5(url);
        boolean badago= MainKud.md5Badago(md5);
        List<klasePrintzipala> kargatzekoa = MainKud.getInstance().kargatu(url1);

        //tblTaula.setItems(klasePrintzipala);
        tblTaula.setEditable(true);

        if(badago){
            tblURL.setCellValueFactory(new PropertyValueFactory<>("url1"));
            tblmd5.setCellValueFactory(new PropertyValueFactory<>("md5"));
            tblVersion.setCellValueFactory(new PropertyValueFactory<>("version"));
            lblLabela.setText("Datubasean zegoen");
        }else{
            tblURL.setCellValueFactory(new PropertyValueFactory<>("url1"));
            tblmd5.setCellValueFactory(new PropertyValueFactory<>("md5"));
            tblVersion.setCellValueFactory(new PropertyValueFactory<>("version"));
            lblLabela.setText("Datubasean ez zegoen");
        }
        //add your data to the table here.



        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class

    }
}
