/**
* Ad Soyad: Ezgi Efsa Güleç
* Numara:250541023
* Proje: sinema bileti 
* Tarih: 19.11.2025
*/


import java.util.Scanner;
public class sinemaBiletiFiyatlandirma {
	// hafta sonu kontrolü
	public static boolean isWeekend(int gun) {
		return gun == 6 || gun == 7;
	}
	// matine kontrolü
	public static boolean isMatinee(int saat) {
		return saat < 12.00;

	}
	//temel fiyat hesaplma 
	public static double calculateBasePrice(int gun, int saat) {
		boolean weekend = isWeekend(gun);
		boolean matinee = isMatinee(saat);

		if (!weekend && matinee) return 45 ;
		if (!weekend && !matinee) return 65;
		if (weekend && !matinee) return 55;
		else return 85;
	}
	//indirim hesaplama
	public static double calculateDiscount(int yas, int meslek, int gun) {
		double indirimOrani = 0;
		// 65 yaş indirimi 
		if (yas >= 65) {
			indirimOrani = 0.3;
			// 12 yaş altı 
		} else if (yas <= 12) {
			indirimOrani = 0.25;
			//öğrenci
		} else if (meslek == 1) {
			if (gun >= 1 && gun <= 4)
				indirimOrani = 0.20;
			else
				indirimOrani = 0.15;
			// öğretmen 
		} else if (meslek == 2 && gun == 3) {
			indirimOrani = 0.35;

		}
		return indirimOrani;
	}
	// format ekstrası
     public static double getFormatExtra(int filmTuru) {
    	 switch (filmTuru){
    	 case 1:  return 0;
    	 case 2:  return 25;
    	 case 3:  return 35;
    	 case 4:  return 50;
    	 default: return 0;
    	 
    	 }
    	 }
     // final fiyat hesabı
      public static double calculateFinalPrice(int gun ,int saat ,int yas ,int meslek,int filmTuru) {
      double base = calculateBasePrice(gun,saat);
      double indirimOrani = calculateDiscount (yas,meslek,gun);
      double indirim =base * indirimOrani;
      
      double indirimliFiyat = base -indirim;
      double extra = getFormatExtra(filmTuru);
      
      return indirimliFiyat + extra;
      }

	// bilet bilgisi oluşturma 
	public static String generateTicketInfo(int gun ,int saat,int yas ,int meslek ,int filmTuru) {
		double base = calculateBasePrice (gun,saat);
		double indirimOrani = calculateDiscount(yas,meslek,gun);
		double extra = getFormatExtra(filmTuru);
		double finalPrice = calculateFinalPrice (gun, saat, yas ,meslek,filmTuru);
	
				 return "----- BİLET BİLGİLERİ -----\n" +
	                "Temel Fiyat: " + base + " TL\n" +
	                "İndirim Oranı: %" + (int)(indirimOrani * 100) + "\n" +
	                "Ekstra Ücret: " + extra + " TL\n" +
	                "Toplam Fiyat: " + finalPrice + " TL\n";
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Gün (1=Pzt ... 7=Pazar): ");
	        int gun = sc.nextInt();

	        System.out.print("Saat (8-23): ");
	        int saat = sc.nextInt();

	        System.out.print("Yaş: ");
	        int yas = sc.nextInt();

	        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
	        int meslek = sc.nextInt();

	        System.out.print("Film Türü (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
	        int filmTuru = sc.nextInt();

	        System.out.println();
	        System.out.println(generateTicketInfo(gun, saat, yas, meslek, filmTuru));
	    }
	}
		
		
		
		
		
		
		

