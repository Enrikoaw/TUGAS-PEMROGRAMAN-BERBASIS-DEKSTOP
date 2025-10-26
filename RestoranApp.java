

import java.util.Scanner;


public class RestoranApp {

    
    public static void tampilkanMenu(Menu[] daftarMenu) {
        System.out.println("========= SELAMAT DATANG DI RESTORAN =========");
        System.out.println("                 DAFTAR MENU                  ");
        System.out.println("----------------------------------------------");
        System.out.println("--- Makanan ---");
        
        System.out.println("1. " + daftarMenu[0].nama + "\t\t- Rp " + daftarMenu[0].harga);
        System.out.println("2. " + daftarMenu[1].nama + "\t\t- Rp " + daftarMenu[1].harga);
        System.out.println("3. " + daftarMenu[2].nama + "\t\t- Rp " + daftarMenu[2].harga);
        System.out.println("4. " + daftarMenu[3].nama + "\t\t- Rp " + daftarMenu[3].harga);
        
        System.out.println("\n--- Minuman ---");
        
        System.out.println("5. " + daftarMenu[4].nama + "\t\t\t- Rp " + daftarMenu[4].harga);
        System.out.println("6. " + daftarMenu[5].nama + "\t\t- Rp " + daftarMenu[5].harga);
        System.out.println("7. " + daftarMenu[6].nama + "\t\t- Rp " + daftarMenu[6].harga);
        System.out.println("8. " + daftarMenu[7].nama + "\t\t- Rp " + daftarMenu[7].harga);
        System.out.println("==============================================");
    }

    
    public static void hitungDanCetak(Menu[] daftarMenu,
                                      int idx1, int qty1,
                                      int idx2, int qty2,
                                      int idx3, int qty3,
                                      int idx4, int qty4) {

        
        int total1 = 0;
        if (qty1 > 0) {
            total1 = daftarMenu[idx1].harga * qty1;
        }

        int total2 = 0;
        if (qty2 > 0) {
            total2 = daftarMenu[idx2].harga * qty2;
        }

        int total3 = 0;
        if (qty3 > 0) {
            total3 = daftarMenu[idx3].harga * qty3;
        }

        int total4 = 0;
        if (qty4 > 0) {
            total4 = daftarMenu[idx4].harga * qty4;
        }

        
        int totalBiaya = total1 + total2 + total3 + total4;

        
        double pajak = totalBiaya * 0.10;
        int biayaPelayanan = 20000;
        double diskonPersen = 0.0;
        int diskonBOGO = 0; 

       
        
        if (totalBiaya > 100000) {
            diskonPersen = totalBiaya * 0.10;
        }

        
        
        if (totalBiaya > 50000) {
            
            int minumanTermurah = Integer.MAX_VALUE; 

            
            if (qty1 > 0 && daftarMenu[idx1].kategori.equals("Minuman")) {
                if (daftarMenu[idx1].harga < minumanTermurah) {
                    minumanTermurah = daftarMenu[idx1].harga;
                }
            }
           
            if (qty2 > 0 && daftarMenu[idx2].kategori.equals("Minuman")) {
                if (daftarMenu[idx2].harga < minumanTermurah) {
                    minumanTermurah = daftarMenu[idx2].harga;
                }
            }
            
            if (qty3 > 0 && daftarMenu[idx3].kategori.equals("Minuman")) {
                if (daftarMenu[idx3].harga < minumanTermurah) {
                    minumanTermurah = daftarMenu[idx3].harga;
                }
            }
            
            if (qty4 > 0 && daftarMenu[idx4].kategori.equals("Minuman")) {
                if (daftarMenu[idx4].harga < minumanTermurah) {
                    minumanTermurah = daftarMenu[idx4].harga;
                }
            }

            
            if (minumanTermurah != Integer.MAX_VALUE) {
                diskonBOGO = minumanTermurah;
            }
        }

        
        double totalAkhir = totalBiaya - diskonPersen - diskonBOGO + pajak + biayaPelayanan;

        
        System.out.println("\n========= STRUK PEMBAYARAN ==========");
        System.out.println("Item\t\tJumlah\tHarga\tTotal");
        System.out.println("-------------------------------------");

        
        if (qty1 > 0) {
            System.out.println(daftarMenu[idx1].nama + "\t" + qty1 + "\t" + daftarMenu[idx1].harga + "\t" + total1);
        }
        if (qty2 > 0) {
            System.out.println(daftarMenu[idx2].nama + "\t" + qty2 + "\t" + daftarMenu[idx2].harga + "\t" + total2);
        }
        if (qty3 > 0) {
            System.out.println(daftarMenu[idx3].nama + "\t" + qty3 + "\t" + daftarMenu[idx3].harga + "\t" + total3);
        }
        if (qty4 > 0) {
            System.out.println(daftarMenu[idx4].nama + "\t" + qty4 + "\t" + daftarMenu[idx4].harga + "\t" + total4);
        }
        
        System.out.println("-------------------------------------");
        System.out.println("Subtotal\t\t\t\tRp " + totalBiaya);
        System.out.println("-------------------------------------");
        
        
        if (diskonPersen > 0) {
            System.out.println("Diskon (10%)\t\t\t\t-Rp " + (int)diskonPersen);
        }
        if (diskonBOGO > 0) {
            System.out.println("Penawaran BOGO (Minuman)\t\t-Rp " + diskonBOGO);
        }

        System.out.println("Pajak (10%)\t\t\t\tRp " + (int)pajak);
        System.out.println("Biaya Pelayanan\t\t\t\tRp " + biayaPelayanan);
        System.out.println("=====================================");
        System.out.println("TOTAL AKHIR\t\t\t\tRp " + (int)totalAkhir);
        System.out.println("=====================================");

        
        System.out.println("\n--- Analisis Skenario Diskon ---");
        if (totalBiaya > 100000) {
            System.out.println("[INFO] Skenario 1 (IF): Total > 100rb, diskon 10% diterapkan.");
        } else if (totalBiaya > 50000) {
            System.out.println("[INFO] Skenario 2 (ELSE IF): Total > 50rb (tapi <= 100rb), diskon 10% TIDAK diterapkan.");
        } else {
            System.out.println("[INFO] Skenario 3 (ELSE): Total <= 50rb, diskon 10% TIDAK diterapkan.");
        }

        if (diskonBOGO > 0) {
            System.out.println("[INFO] Skenario 4 (NESTED IF): Total > 50rb DAN memesan minuman, BOGO diterapkan.");
        } else if (totalBiaya > 50000) {
            System.out.println("[INFO] Skenario 5 (NESTED IF): Total > 50rb tapi TIDAK memesan minuman, BOGO tidak berlaku.");
        }
    }


    
    public static void main(String[] args) {
       
        
        Menu[] daftarMenu = new Menu[8];
        daftarMenu[0] = new Menu("Nasi Padang", 22000, "Makanan");
        daftarMenu[1] = new Menu("Ayam Geprek", 18000, "Makanan");
        daftarMenu[2] = new Menu("Sate Ayam", 25000, "Makanan");
        daftarMenu[3] = new Menu("Bakso Urat", 20000, "Makanan");
        daftarMenu[4] = new Menu("Es Teh Manis", 6000, "Minuman");
        daftarMenu[5] = new Menu("Jus Alpukat", 15000, "Minuman");
        daftarMenu[6] = new Menu("Kopi Susu", 12000, "Minuman");
        daftarMenu[7] = new Menu("Air Mineral", 5000, "Minuman");

        
        tampilkanMenu(daftarMenu);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSilakan masukkan pesanan Anda (maks. 4 item).");
        System.out.println("Masukkan nomor menu (1-8). Masukkan '0' jika sudah selesai memesan.");

        
        System.out.print("Pesanan 1 - No. Menu (0-8): ");
        int no1 = scanner.nextInt();
        int qty1 = 0;
        int idx1 = 0;
        if (no1 > 0 && no1 <= 8) {
            idx1 = no1 - 1; 
            System.out.print("Pesanan 1 - Jumlah: ");
            qty1 = scanner.nextInt();
        }

        
        System.out.print("Pesanan 2 - No. Menu (0-8): ");
        int no2 = scanner.nextInt();
        int qty2 = 0;
        int idx2 = 0;
        if (no2 > 0 && no2 <= 8) {
            idx2 = no2 - 1;
            System.out.print("Pesanan 2 - Jumlah: ");
            qty2 = scanner.nextInt();
        }

        
        System.out.print("Pesanan 3 - No. Menu (0-8): ");
        int no3 = scanner.nextInt();
        int qty3 = 0;
        int idx3 = 0;
        if (no3 > 0 && no3 <= 8) {
            idx3 = no3 - 1;
            System.out.print("Pesanan 3 - Jumlah: ");
            qty3 = scanner.nextInt();
        }

       
        System.out.print("Pesanan 4 - No. Menu (0-8): ");
        int no4 = scanner.nextInt();
        int qty4 = 0;
        int idx4 = 0;
        if (no4 > 0 && no4 <= 8) {
            idx4 = no4 - 1;
            System.out.print("Pesanan 4 - Jumlah: ");
            qty4 = scanner.nextInt();
        }

        
        hitungDanCetak(daftarMenu, idx1, qty1, idx2, qty2, idx3, qty3, idx4, qty4);

        scanner.close();
    }
}