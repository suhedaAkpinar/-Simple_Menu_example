package Otomasyon;

import java.util.Scanner;

public class Personel {

	private static int count=0;
	private int depNo;
	private int perID;
	private String perAd;
	private String perSoyad;
	private int perYas;
	
	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public int getPerID() {
		return perID;
	}

	public void setPerID() {//personel id otomatik artan olarak ayarland�
		this.perID = ++count;
	}

	public String getPerAd() {
		return perAd;
	}

	public void setPerAd(String perAd) {
		this.perAd = perAd;
	}

	public String getPerSoyad() {
		return perSoyad;
	}

	public void setPerSoyad(String perSoyad) {
		this.perSoyad = perSoyad;
	}

	public int getPerYas() {
		return perYas;
	}

	public void setPerYas(int perYas) {
		this.perYas = perYas;
	}
	
	public static Personel[] Olustur(int depNo) {
		//bu metot personel say�s�n� kullan�c�dan ister daha sonra her bir personelin ad�,soyad� ve ya� bilgilerini al�r
		Scanner scan = new Scanner(System.in);
		System.out.print("Personel sayisi giriniz:");
		int per_sayi=scan.nextInt();
		Personel personeller[]= new Personel[per_sayi]; 
		for(int j=0;j<per_sayi;j++) {
			Personel per = new Personel();
			per.setPerID();
			
			per.setDepNo(depNo);
			
			System.out.print("Ad�:");
			per.setPerAd(scan.next());
			
			System.out.print("Soyad�:");
			per.setPerSoyad(scan.next());
			
			System.out.print("Ya�:");
			per.setPerYas(scan.nextInt());
			
			personeller[j] = per;
			
		}
		return personeller;
	}
	
	public static void Listele(Departman dep) {//personelleri listeler
		System.out.println("Personeller:\n");
		for(int j=0;j<dep.personeller.length;j++) {
			Yazdir(dep.personeller[j]);
		}
	}
	
	public static void Yazdir(Personel per) {//Personel bilgilerini yazd�r�r
		System.out.print("\t"+per.getPerID()+".\t");
		System.out.print(per.getPerAd()+"\t");
		System.out.print(per.getPerSoyad()+"\t");
		System.out.print(per.getPerYas()+"\n");
	}
	
	//Kullan�c�dan istenilen personel ad�na g�re arama yapar.Personel bilgileri listelenirken hangi departmana ait oldu�unuda bulur.
	public static void Ara(Departman[] departmanlar,String per_adi) {
		for(int i=0;i<departmanlar.length;i++) {
			Departman dep = departmanlar[i];
			Personel aranan = Personel.Ara(dep.personeller, per_adi);
			if( aranan != null) {
				System.out.print("Departman="+dep.getDepAd());
				Personel.Yazdir(aranan);
				return;
			}
		}
	}
	
	public static Personel Ara(Personel[] personeller,String adi) {
		for(int i=0;i<personeller.length;i++) {
			if(personeller[i].getPerAd().equals(adi)) {
				return personeller[i];
			}
		}
		System.out.println("Personel bulunamad�.\n");
		return null;
	}
	
	//A�a��daki metotlar ya�� en b�y�k ve en k���k personel bilgilerini bulur.ayr�ca personellerin hangi departmana ait oldu�u bilgisini de bulur
	private static Personel EnkAra(Personel[] personeller) {
		Personel enk= personeller[0];
		for(int i=0;i<personeller.length;i++) {
			if(personeller[i].getPerYas()<enk.getPerYas()) enk = personeller[i];
		}
		return enk;
	}
	
	
	public static Personel Enk(Departman[] departmanlar) {
		Personel enk = departmanlar[0].getPersoneller()[0];
		for(int i=0;i<departmanlar.length;i++) {
			Departman dep = departmanlar[i];
			Personel dep_enk = EnkAra(dep.personeller);
			if(dep_enk.getPerYas() < enk.getPerYas()) enk = dep_enk;
		}
		return enk;
	}
	private static Personel EnbAra(Personel[] personeller) {
		Personel enb= personeller[0];
		for(int i=0;i<personeller.length;i++) {
			if(personeller[i].getPerYas()>enb.getPerYas()) enb = personeller[i];
		}
		return enb;
	}
	
	
	public static Personel Enb(Departman[] departmanlar) {
		Personel enb = departmanlar[0].getPersoneller()[0];
		for(int i=0;i<departmanlar.length;i++) {
			Departman dep = departmanlar[i];
			Personel dep_enb = EnbAra(dep.personeller);
			if(dep_enb.getPerYas() > enb.getPerYas()) enb = dep_enb;
		}
		return enb;
	}
	
}
