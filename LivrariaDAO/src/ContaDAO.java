import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ContaDAO {
	
	Connection conn;

	public static void main(String[] args) throws SQLException {
		Properties connConfig = new Properties();
		connConfig.setProperty("user", "root");
		connConfig.setProperty("password", "1234");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", connConfig)){
			conn.setAutoCommit(false);
			try(Statement stmt = conn.createStatement()){
				stmt.execute(
					"CREATE TABLE IF NOT EXISTS library.conta (" +
						"id INT PRIMARY KEY AUTO_INCREMENT," +
						"identy VARCHAR(25)," +
						"email VARCHAR(25)," +
						"senha VARCHAR(25))" +
					"ENGINE=InnoDB;");
				System.out.println("Conectado");
			}
		}catch(Exception e) {
			System.out.println("Não conectado");
		}
	}
	
	public void conectar() {
		Properties connConfig = new Properties();
		connConfig.setProperty("user", "root");
		connConfig.setProperty("password", "1234");
		try {
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", connConfig);
			conn.setAutoCommit(false);
			System.out.println("Conectado");
		}catch(Exception e) {
			System.out.println("Não conectado");
		}
	}
	
	public void insert(Conta conta1) {
		conectar();
		try(PreparedStatement prep = conn.prepareStatement(
				"INSERT INTO library.conta (identy, email, senha) VALUES (?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS)){
			
			prep.setString(1, conta1.getId());
			prep.setString(2, "joao@gmail.com");
			prep.setString(3, conta1.getSenha());
			prep.execute();
			conn.commit();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void update(Conta conta1) {
		conectar();
		try(PreparedStatement prep = conn.prepareStatement(
				"UPDATE library.conta " +
				"SET email = ? WHERE id = ?")){
			
			prep.setString(1, "joaozinho@gmail.com");
			prep.setInt(2, 1);
			prep.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void delete(Conta conta1) {
		conectar();
		try(PreparedStatement prep = conn.prepareStatement(
				"DELETE FROM library.conta " +
				"WHERE id = ?")){
			
			prep.setInt(1,1);
			prep.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void listar(Conta conta1) throws SQLException {
		conectar();
		Statement stmt = conn.createStatement();
		conn.commit();
		ResultSet conta_list = stmt.executeQuery(
				"SELECT identy, email, senha " +
				"FROM library.conta");
		System.out.println("Conta:");
		while(conta_list.next()) {
			System.out.println(
					String.format(
							"- %s <%s> %s",
							conta_list.getString("identy"),
							conta_list.getString("email"),
							conta_list.getString("senha")));
		}
	}
}
