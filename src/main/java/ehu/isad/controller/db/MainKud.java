package ehu.isad.controller.db;

import ehu.isad.controller.ui.MainUI;
import ehu.isad.models.klasePrintzipala;
import javafx.scene.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainKud {

    private static final MainKud instance = new MainKud();

    public static MainKud getInstance() {
        return instance;
    }
    //hemetik bera aldatu, estructura bera du baina beheko metodoak adibideak dira

    public List<klasePrintzipala> kargatu(String url){
        String urla= url;
        String query = "select md5, version from checksums";
        DBKudSQLite dbKudeatzaile = DBKudSQLite.getDBKud();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        List<klasePrintzipala> emaitza = new ArrayList<>();

        try {
            while (rs.next()) {
                String md5 = rs.getString("md5");
                String version = rs.getString("version");
                emaitza.add(this.kargatu(md5, version));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        if(emaitza.isEmpty()){
            String query1 = "update md5, version from checksums"; //hemen datu berriak sartu nahi nituen
            DBKudSQLite dbKudeatzaile1 = DBKudSQLite.getDBKud();
            ResultSet rs1 = dbKudeatzaile.execSQL(query);
        }

        return emaitza;
    }

    private klasePrintzipala kargatu(String md5, String version) {
        klasePrintzipala klase= new klasePrintzipala(md5, version);
        return klase;
    }


    public static boolean md5Badago(String md5Hau) {
        String query = "select md5 from checksums";
        DBKudSQLite dbKudeatzaile = DBKudSQLite.getDBKud();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        List<String> emaitza = new ArrayList<>();
        boolean dago = false;
        try {
            while (rs.next()) {
                String md5 = rs.getString("md5");
                emaitza.add(md5);
                if(md5==md5Hau){
                    dago=true;
                }
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return dago;
    }
}
