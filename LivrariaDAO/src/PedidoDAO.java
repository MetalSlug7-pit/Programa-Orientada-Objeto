import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PedidoDAO {
	
	Connection conn;

	public static void main(String[] args) throws SQLException {
		Properties connConfig = new Properties();
		connConfig.setProperty("user", "root");
		connConfig.setProperty("password", "1234");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", connConfig)){
			conn.setAutoCommit(false);
			try(Statement stmt = conn.createStatement()){
				stmt.execute(
					"CREATE TABLE IF NOT EXISTS library.pedido (" +
						"id INT PRIMARY KEY AUTO_INCREMENT," +
						"endereco VARCHAR(25)," +
						"usuario VARCHAR(25))" +
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
	
	public void insert(Pedido pedido1) {
		conectar();
		try(PreparedStatement prep = conn.prepareStatement(
				"INSERT INTO library.pedido (endereco, usuario) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS)){
			
			prep.setString(1, pedido1.getEndereco());
			prep.setString(2, pedido1.getUsuario());
			prep.execute();
			conn.commit();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void update(Pedido pedido1) {
		conectar();
		try(PreparedStatement prep = conn.prepareStatement(
				"UPDATE library.pedido " +
				"SET usuario = ? WHERE id = ?")){
			
			prep.setString(1, "Joaozinho");
			prep.setInt(2, 1);
			prep.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void delete(Pedido pedido1) {
		conectar();
		try(PreparedStatement prep = conn.prepareStatement(
				"DELETE FROM library.pedido " +
				"WHERE id = ?")){
			
			prep.setInt(1,1);
			prep.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void listar(Pedido pedido1) throws SQLException {
		conectar();
		Statement stmt = conn.createStatement();
		conn.commit();
		ResultSet pedido_list = stmt.executeQuery(
				"SELECT endereco, usuario " +
				"FROM library.pedido");
		System.out.println("Pedido:");
		while(pedido_list.next()) {
			System.out.println(
					String.format(
							"- %s <%s>",
							pedido_list.getString("endereco"),
							pedido_list.getString("usuario")));
		}
	}
}
