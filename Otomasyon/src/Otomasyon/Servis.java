package Otomasyon;

import java.util.Scanner;

public class Servis {
	
	private int depNo;
	private int servisID;
	private String servisGuzergah;
	
	private static int count=0;

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public int getServisID() {
		return servisID;
	}

	public void setServisID() {//servis id si otomatik artan olarak ayarland�
		this.servisID = ++count;
	}

	public String getServisGuzergah() {
		return servisGuzergah;
	}

	public void setServisGuzergah(String servisGuzergah) {
		this.servisGuzergah = servisGuzergah;
	}
	
	//Kullan�c�dan servis say�s� bilgisi istenir.Daha sonra g�zergah bilgileri al�n�r
	public static Servis[] Olustur(int depNo) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Servis sayisi giriniz:");
		int ser_sayi=scan.nextInt();
		Servis servisler[]= new Servis[ser_sayi]; 
		
		for(int j=0;j<ser_sayi;j++) {
			Servis ser = new Servis();
			ser.setServisID();
			ser.setDepNo(depNo);
			
			System.out.print("G�zergah:");
			ser.setServisGuzergah(scan.next());
			
			servisler[j] = ser;
		}
		return servisler;
	}
	
	//Departmanda bulunan servisleri listeler.Yazdir metodu ile servis id si ve g�zergah bilgisini yazdirir
	public static void Listele(Departman dep) {
		System.out.println("Servisler:\n");
		for(int k=0;k<dep.servisler.length;k++) {
			Servis ser =dep.servisler[k];
			System.out.print("\t\t"+ser.getServisID()+".\t");
			System.out.print(ser.getServisGuzergah()+"\n");
			
		}
	}
	public static void Yazdir(Servis ser) {
		System.out.print("\t\t"+ser.servisID+".\t");
		System.out.print(ser.servisGuzergah+"\t");
		
	}
	
	//Kullan�c�dan aranacak g�zergah bilgisi al�nd�ktan sonra bu g�zergaha sahip servis bilgileri bulunur.
	//Servis bilgilerinin hangi departmana aiy-t oldu�u bulunur
	public static void Ara(Departman[] departmanlar,String ser_guzergah) {
		for(int i=0;i<departmanlar.length;i++) {
			Departman dep = departmanlar[i];
			Servis aranan = Servis.Ara(dep.servisler, ser_guzergah);
			if( aranan != null) {
				System.out.print("Departman="+dep.getDepAd());
				Servis.Yazdir(aranan);
				return;
			}
		}
	}
	
	public static Servis Ara(Servis[] servisler,String adi) {
		for(int i=0;i<servisler.length;i++) {
			if(servisler[i].getServisGuzergah().equals(adi)) {
				return servisler[i];
			}
		}
		System.out.println("G�zergah  bulunamad�.\n");
		return null;
	}

}
