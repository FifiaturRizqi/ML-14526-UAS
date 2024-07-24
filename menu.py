import java.util.Scanner;

public class ProductMenu {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
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
        
        scanner.close();
    }
    
    public static void tampilkanDaftarProduk() {
        // Implementasi untuk menampilkan daftar produk dari database
        System.out.println("\n=== DAFTAR PRODUK ===");
        // Tampilkan daftar produk dari database
        // Misalnya, dapat menggunakan koneksi database dan query SQL
        // Contoh: SELECT * FROM produk;
    }
    
    public static void tambahProduk() {
        // Implementasi untuk menambah produk baru ke dalam database
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== TAMBAH PRODUK BARU ===");
        System.out.print("Nama Produk: ");
        String namaProduk = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        
        // Simpan data produk ke dalam database
        // Misalnya, dapat menggunakan koneksi database dan query SQL
        // Contoh: INSERT INTO produk (nama_produk, harga, stok) VALUES ('namaProduk', harga, stok);
        
        System.out.println("Produk berhasil ditambahkan.");
    }
    
    public static void ubahProduk() {
        // Implementasi untuk mengubah informasi produk di database
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== UBAH INFORMASI PRODUK ===");
        System.out.print("Masukkan ID Produk yang akan diubah: ");
        int idProduk = scanner.nextInt();
        System.out.print("Nama Produk baru: ");
        String namaProduk = scanner.nextLine(); // Menangkap newline setelah nextInt
        namaProduk = scanner.nextLine(); // Baru mengambil input nama produk
        System.out.print("Harga baru: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok baru: ");
        int stok = scanner.nextInt();
        
        // Update informasi produk di database
        // Misalnya, dapat menggunakan koneksi database dan query SQL
        // Contoh: UPDATE produk SET nama_produk='namaProduk', harga=harga, stok=stok WHERE id=idProduk;
        
        System.out.println("Produk berhasil diubah.");
    }
    
    public static void hapusProduk() {
        // Implementasi untuk menghapus produk dari database
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== HAPUS PRODUK ===");
        System.out.print("Masukkan ID Produk yang akan dihapus: ");
        int idProduk = scanner.nextInt();
        
        // Hapus produk dari database
        // Misalnya, dapat menggunakan koneksi database dan query SQL
        // Contoh: DELETE FROM produk WHERE id=idProduk;
        
        System.out.println("Produk berhasil dihapus.");
    }
}
