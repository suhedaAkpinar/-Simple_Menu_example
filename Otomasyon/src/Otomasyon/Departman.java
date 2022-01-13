package Otomasyon;

import java.util.Scanner;

public class Departman {
	
	private int depNo;   
	private String depAd;
	
	public Personel personeller[];
	public Servis servisler[];
	
	public int getDepNo() {
		return depNo;
	}
	
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	
	public String getDepAd() {
		return depAd;
	}
	
	public void setDepAd(String depAd) {
		this.depAd = depAd;
	}
	
	public Personel[] getPersoneller() {
		return personeller;
	}
	
	public void setPersoneller(Personel[] personeller) {
		this.personeller = personeller;
	}
	
	public Servis[] getServisler() {
		return servisler;
	}
	
	public void setServisler(Servis[] servisler) {
		this.servisler = servisler;
	}
	
	
	public static Departman[] Olustur() {
		//Bu metot kullan�c�dan s�ras�yla departman say�s�n�,her bir departman�n numaras�n� ve ad�n� al�r.
		 
		Scanner scan=new Scanner(System.in);
		System.out.print("Departman sayisi giriniz:");
		int sayi=scan.nextInt();
		Departman departmanlar[]= new Departman[sayi]; //
		
		for(int i=0;i<sayi;i++) {
		
			Departman dep = new Departman();
			System.out.print("Departman No:");
			dep.setDepNo(scan.nextInt());
			
			System.out.print("Departman Ad�:");
			dep.setDepAd(scan.next());
			
			departmanlar[i] = dep;
			
			dep.personeller = Personel.Olustur(dep.getDepNo());//Al�nan departman bilgisinden sonra personel olu�tur metodu �a��r�l�r.
			
			dep.servisler = Servis.Olustur(dep.getDepNo());//Al�nan personel bilgilerinden sonra ise servis bilgileri al�n�r.
		}
	
		
		return departmanlar;
	}
	
	public static void Listele(Departman[] departmanlar) {//menudeki listeleme i�lemi burda ger�ekle�tirilir
		System.out.println("\nDepartmanlar\t");
		for(int i=0;i<departmanlar.length;i++) {
			Yazdir(departmanlar[i]);
			System.out.println();
		}
		
	}
	
	public static void Yazdir(Departman dep) {
		System.out.print(dep.depNo+".\t");
		System.out.print(dep.depAd+"\n");
		Personel.Listele(dep);
		Servis.Listele(dep);
	}
	
	public static void Ara(Departman[] departmanlar,String adi) { //Deparmanda isme g�re ara yapar
		for(int i=0;i<departmanlar.length;i++) {
			if(departmanlar[i].getDepAd().equals(adi)) {
				Yazdir(departmanlar[i]);
				return;
			}
		}
		System.out.println("Departman bulunamad�.\n");
	}
	
	public static Departman Ara(Departman[] departmanlar,int depNo) {//Deparman numar�s�na g�re arama yapar
		for(int i=0;i<departmanlar.length;i++) {
			if(departmanlar[i].getDepNo() == depNo) {
				return departmanlar[i];
			}
		}
		return null;
	}

}
