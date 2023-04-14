/*
 * "setString(index, String)" ou "setInt(index, int)" ou relacionados
 * trocam a interrupção "?" na posição "index" pela informação
 * do tipo da função, setTIPODAFUNÇÃO(index, tipo_da_função).
 *  É possível pegar apenas alguns resultados da query usando
 * pst.getInt() ou pst.getString() entre outros.
 */

package com.example.inatel.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.inatel.Models.User;

// DAO - Data Access Object
public class CRUD extends ConnectionDataBase {

  // Methods
  private void executeQueryUpdate(String query, User user) throws SQLException {
    pst = connection.prepareStatement(query);
    final String userName = user.getNome();
    final String CPF = user.getCpf();
    pst.setString(1, userName);
    pst.setString(2, CPF);
    pst.setInt(3, user.getId());
    pst.execute();
    System.out.println("User with Name_ " + userName + " e CPF " + CPF + " was update with success" + "\n");
  }

  private void executeQueryInsert(String query, User user) throws SQLException {
    pst = connection.prepareStatement(query);
    final String userName = user.getNome();
    final String CPF = user.getCpf();
    // Trocando as "?" por informações
    pst.setString(1, userName);
    pst.setString(2, CPF);
    pst.execute(); // Executando o cursor
    System.out.println("User with Name_ " + userName + " and CPF " + CPF + " was insert with success" + "\n");
  }

  private void executeQueryDelete(String query, int idUser) throws SQLException {
    pst = connection.prepareStatement(query);
    pst.setInt(1, idUser);
    pst.execute();
    System.out.println("User com idUser " + idUser + " as delete with success" + "\n");
  }

  private void executeQuerySelect(ResultSet result, ArrayList<User> users) throws SQLException {
    String query = "SELECT * FROM User";
    statement = connection.createStatement();
    resultBD = statement.executeQuery(query);

    System.out.println("Lista de users:");

    // Imprime os resultados da query
    while (resultBD.next()) {
      User userAux = new User(resultBD.getString("Name_"), resultBD.getString("CPF"), resultBD.getInt("idUser"));

      System.out.println("idUser = " + userAux.getId());
      System.out.println("Name_ = " + userAux.getNome());
      System.out.println("CPF = " + userAux.getCpf());
      System.out.println("--------------------------------" + "\n");

      users.add(userAux);
    }
  }

  private void logError(SQLException e) {
    System.out.println("Error: " + e.getMessage());
  }

  // INSERT
  public void insertUser(User user) {
    openConnection();

    String query = "INSERT INTO User (Name_ , CPF) VALUES (?, ?)";
    try {
      executeQueryInsert(query, user);
    } catch (SQLException exception) {
      logError(exception);
    }
    //
    try {
      connection.close();
      pst.close();
    } catch (SQLException exception) {
      logError(exception);
    }
  }

  // UPDATE
  public void updateUser(int id, User user) {
    openConnection();
    String query = "UPDATE User SET Name_ = ?, CPF = ? WHERE idUser = ?";
    try {
      executeQueryUpdate(query, user);
    } catch (SQLException exception) {
      logError(exception);
    }
    closeConnection();
  }

  // DELETE
  public void deleteUser(int idUser) {
    openConnection();
    String query = "DELETE FROM User where idUser = ?";
    try {
      executeQueryDelete(query, idUser);
    } catch (SQLException exception) {
      logError(exception);
    }
    closeConnection();
  }

  // SELECT
  public ArrayList<User> selectUser() {
    ArrayList<User> users = new ArrayList<>();
    openConnection();

    try {
      executeQuerySelect(resultBD, users);
    } catch (SQLException exception) {
      logError(exception);
    }
    closeConnection();

    return users;
  }
}