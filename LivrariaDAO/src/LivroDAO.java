import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class LivroDAO {
	
		Connection conn;

		public static void main(String[] args) throws SQLException{
			Properties connConfig = new Properties();
			connConfig.setProperty("user", "root");
			connConfig.setProperty("password", "1234");
			try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", connConfig)){
				conn.setAutoCommit(false);
				try(Statement stmt = conn.createStatement()){
					stmt.execute(
						"CREATE TABLE IF NOT EXISTS library.livro (" +
							"id INT PRIMARY KEY AUTO_INCREMENT," +
							"titulo VARCHAR(25)," +
							"autor VARCHAR(25)," +
							"publicadora VARCHAR(25))" +
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
			
		public void insert(Livro livro1) {
			conectar();
			try(PreparedStatement prep = conn.prepareStatement(
					"INSERT INTO library.livro (titulo, autor, publicadora) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS)){
				
				prep.setString(1, livro1.getTitulo());
				prep.setString(2, livro1.getAutor());
				prep.setString(3, livro1.getPublicadora());
				prep.execute();
				conn.commit();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		public void update(Livro livro1) {
			conectar();
			try(PreparedStatement prep = conn.prepareStatement(
					"UPDATE library.livro " +
					"SET autor = ? WHERE id = ?")){
				
				prep.setString(1, "Preto");
				prep.setInt(2, 1);
				prep.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		public void delete(Livro livro1) {
			conectar();
			try(PreparedStatement prep = conn.prepareStatement(
					"DELETE FROM library.livro " +
					"WHERE id = ?")){
				
				prep.setInt(1,1);
				prep.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		public void listar(Livro livro1) throws SQLException {
			conectar();
			Statement stmt = conn.createStatement();
			conn.commit();
			ResultSet livro_list = stmt.executeQuery(
					"SELECT titulo, autor, publicadora " +
					"FROM library.livro");
			System.out.println("Livro:");
			while(livro_list.next()) {
				System.out.println(
						String.format(
								"- %s <%s> <%s>",
								livro_list.getString("titulo"),
								livro_list.getString("autor"),
								livro_list.getString("publicadora")));
			}
		}
}
