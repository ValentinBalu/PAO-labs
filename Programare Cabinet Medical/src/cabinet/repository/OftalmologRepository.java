package cabinet.repository;

import cabinet.Medic;
import cabinet.Oftalmolog;
import cabinet.OftalmologService;
import cabinet.config.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;

public class OftalmologRepository {
    //creare tabela
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS oftalmologi" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                " varsta int, specialitatea varchar(30), tura int , organ_vizat varchar(30), durata_consultatie int, chirurgie varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //inserare oftalmolog
    public void insertOftalmolog(Oftalmolog oftalmolog) {
        String insertClientSql = "INSERT INTO oftalmologi(nume,varsta,specialitatea,tura,organ_vizat,durata_consultatie,chirurgie) VALUES(?,?,?,?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertClientSql);
            preparedStatement.setString(1, oftalmolog.getNume());
            preparedStatement.setInt(2, oftalmolog.getVarsta());
            preparedStatement.setString(3,oftalmolog.getSpecialitate());
            preparedStatement.setInt(4,oftalmolog.getTura());
            preparedStatement.setString(5,oftalmolog.getOrganVizat());
            preparedStatement.setInt(6,oftalmolog.getDurataConsultatie());
            preparedStatement.setBoolean(7,oftalmolog.getChirurgie());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //preluarea unui oftalmolog dupa id
    public Oftalmolog getOftalmologById(int id) {
        String selectSql = "SELECT * FROM oftalmologi WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToOftalmolog(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Oftalmolog mapToOftalmolog(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Oftalmolog(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getBoolean(8));
        }
        return null;
    }

    public ArrayList<Oftalmolog> getAllOfts(){
        ArrayList<Oftalmolog> oftalmologs = new ArrayList<Oftalmolog>();

        String selectSql = "SELECT * FROM oftalmologi";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Oftalmolog oftalmolog = new Oftalmolog(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getBoolean(8));
                oftalmologs.add(oftalmolog);
            }
            return oftalmologs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateDurataConsultatie(int durata, int id) {
        String updateNameSql = "UPDATE oftalmologi SET durata_consultatie=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, durata);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOftalmolog(int id){
        String deleteSql = "delete from oftalmologi WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
