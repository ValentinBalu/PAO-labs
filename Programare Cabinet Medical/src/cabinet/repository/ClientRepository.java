package cabinet.repository;

import cabinet.Client;
import cabinet.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientRepository {
    //creare tabela
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS clienti" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                "cnp varchar(30), varsta int, sex char)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //inserare client
    public void insertClient(Client client) {
        String insertClientSql = "INSERT INTO clienti(nume,cnp,varsta,sex) VALUES(?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertClientSql);
            preparedStatement.setString(1, client.getNume());
            preparedStatement.setString(2, client.getCnp());
            preparedStatement.setInt(3,client.getVarsta());
            preparedStatement.setString(4,String.valueOf(client.getSex()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //preluarea unui client dupa id
    public Client getClientById(int id) {
        String selectSql = "SELECT * FROM clienti WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToClient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Client mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Client(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4),resultSet.getString(5).toCharArray()[0],new String[]{});
        }
        return null;
    }

    public ArrayList<Client> getAllClients(){
        ArrayList<Client> clienti = new ArrayList<Client>();

        String selectSql = "SELECT * FROM clienti";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Client client = new Client(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4),resultSet.getString(5).toCharArray()[0],new String[]{});
                clienti.add(client);
            }
            return clienti;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateClientAge(int varsta, int id) {
        String updateNameSql = "UPDATE clienti SET varsta=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, varsta);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int id){
        String deleteSql = "delete from clienti WHERE id=?";

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
