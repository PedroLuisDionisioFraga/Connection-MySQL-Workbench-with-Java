package com.example.inatel.DAO;

// Importando a biblioteca pra usar recursos relacionados ao JDBC (Java Database Connectivity).
import java.sql.*;

/*
 *  O banco de dados de um objeto **Connection** é capaz de fornecer
 * informações que descrevem suas tabelas, sua gramática SQL suportada,
 * seus procedimentos armazenados, os recursos dessa conexão
 * e assim por diante.
 */

public abstract class ConnectionDataBase {
  // Declaração das variáveis utilizadas para estabelecer
  // conexão com o banco de dados
  protected static Connection connection; // Retorna o tipo de conexão
  protected static PreparedStatement pst; // Declaração(query) preparada - código em sql, ele prepara a query pra ser
                                          // executada, possui "?" e podemos trocar os "?" por informações
  protected static Statement statement; // Declaração(query) - código em sql, já é a query formada em SQL sem nenhum "?"
  protected static ResultSet resultBD; // Resposta do BD a uma query

  private static final String dataBase = "Integration"; // nome do dataBase
  private static final String serverName = "localhost:3306"; // Caminho do servidor do BD
  private static final String user = "root"; // Nome do host
  private static final String password = "Minecraft*11"; // Senha do host
  private static final String url = "jdbc:mysql://" + serverName + "/" + dataBase
      + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

  // Methods
  public void openConnection() {
    try {
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connection Success");
    } catch (SQLException exc) {
      System.out.println("Connection Error: " + exc.getMessage());
    }
  }

  public void closeConnection() {
    try {
      connection.close();
      pst.close();
    } catch (SQLException exc) {
      System.out.println("Disconnection Error: " + exc.getMessage());
    }
  }
}
