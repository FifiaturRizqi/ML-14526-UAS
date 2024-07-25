import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductMenu {
    
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        try {
            connection = Config.getConnection();
            
            do {
                System.out.println("\n=== MENU PRODUK ===");
                System.out.println("1. Tampilkan Daftar Produk");
                System.out.println("2. Tambah Produk Baru");
                System.out.println("3. Ubah Informasi Produk");
                System.out.println("4. Hapus Produk");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu (1-5): ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        tampilkanDaftarProduk();
                        break;
                    case 2:
                        tambahProduk();
                        break;
                    case 3:
                        ubahProduk();
                        break;
                    case 4:
                        hapusProduk();
                        break;
                    case 5:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                }
                
            } while (choice != 5);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Config.closeConnection(connection);
            scanner.close();
        }
    }
    
    public static void tampilkanDaftarProduk() throws SQLException {
        System.out.println("\n=== DAFTAR PRODUK ===");
        
        String query = "SELECT * FROM produk";
        preparedStatement = connection.prepareStatement(query);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String namaProduk = resultSet.getString("nama_produk");
            double harga = resultSet.getDouble("harga");
            int stok = resultSet.getInt("stok");
            
            System.out.println("ID: " + id + ", Nama: " + namaProduk + ", Harga: " + harga + ", Stok: " + stok);
        }
        
        preparedStatement.close();
    }
    
    public static void tambahProduk() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== TAMBAH PRODUK BARU ===");
        
        System.out.print("Nama Produk: ");
        String namaProduk = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        
        String query = "INSERT INTO produk (nama_produk, harga, stok) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, namaProduk);
        preparedStatement.setDouble(2, harga);
        preparedStatement.setInt(3, stok);
        
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Produk berhasil ditambahkan.");
        }
        
        preparedStatement.close();
    }
    
    public static void ubahProduk() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== UBAH INFORMASI PRODUK ===");
        
        System.out.print("Masukkan ID Produk yang akan diubah: ");
        int idProduk = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
        
        System.out.print("Nama Produk baru: ");
        String namaProduk = scanner.nextLine();
        System.out.print("Harga baru: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok baru: ");
        int stok = scanner.nextInt();
        
        String query = "UPDATE produk SET nama_produk=?, harga=?, stok=? WHERE id=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, namaProduk);
        preparedStatement.setDouble(2, harga);
        preparedStatement.setInt(3, stok);
        preparedStatement.setInt(4, idProduk);
        
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Produk berhasil diubah.");
        }
        
        preparedStatement.close();
    }
    
    public static void hapusProduk() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== HAPUS PRODUK ===");
        
        System.out.print("Masukkan ID Produk yang akan dihapus: ");
        int idProduk = scanner.nextInt();
        
        String query = "DELETE FROM produk WHERE id=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idProduk);
        
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Produk berhasil dihapus.");
        }
        
        preparedStatement.close();
    }
}
