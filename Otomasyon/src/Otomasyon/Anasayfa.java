package Otomasyon;

import java.awt.List;
import java.util.Scanner;

public class Anasayfa {


	
	public Anasayfa()
	{
		//departman bilgisini almak için departman dizisi oluþturuldu.Daha sonra oluþturma fonk. çaðýrýldý
		Departman[] departmanlar = Departman.Olustur();
		
		
		boolean durum=true;
		do{
			ekranayaz(".::MENU::.", true);
			ekranayaz("1) Tüm Departmanlarý Listele", true);
			ekranayaz("2) Departman Adýna Göre Arama Yap", true);
			ekranayaz("3) Personel  Adýna Göre Arama Yap", true);
			ekranayaz("4) Servis Güzergahýna Göre Arama Yap", true);
			ekranayaz("5) Yaþý En Büyük ve Em Küçük Personel/Personelleri Bul", true);
			ekranayaz("6) Çýkýþ", true);
			
			
			
			String secim=verigirisi("Seçim Yapýnýz:");
			
			switch (secim) {
			case "1":
				Departman.Listele(departmanlar);
		 		break;
		 		
			case "2":
				Departman.Ara(departmanlar, verigirisi("Departman Adý:"));	
				break;
			
			case "3":
				Personel.Ara(departmanlar, verigirisi("Personel Adý:"));	
			break;
				
			case "4":
				Servis.Ara(departmanlar, verigirisi("Güzergah Adý:"));
				break;
			
			case "5":
				System.out.println("En küçük personel");
				Personel enk = Personel.Enk(departmanlar);
				System.out.print("Departman="+Departman.Ara(departmanlar, enk.getDepNo()).getDepAd());
				Personel.Yazdir(enk);
				System.out.println("En Büyük personel");
				Personel enb = Personel.Enb(departmanlar);
				System.out.print("Departman="+Departman.Ara(departmanlar, enb.getDepNo()).getDepAd());
				Personel.Yazdir(enb);
				break;
			
			case "6":
			ekranayaz("Çýkýþ Yapýldý!", true);
			durum=false;
			break;
			
			default:
					ekranayaz("Geçerli bir seçim yapmadýnýz!", true);
				break;
			}
			
		}while(durum);
		
		
	}
	public static void main(String[] args) {
		new Anasayfa();
	}
	
	//String veri giriþi için tanýmlanan metot
	public String verigirisi(String metin)
	{
		Scanner sc = new Scanner(System.in);
		ekranayaz(metin,false);
		return sc.nextLine();
	}
	
	//int veri giriþi için tanýmlý metot
	public int verigirisi_int(String metin)
	{
		Scanner sc = new Scanner(System.in);
		
		int veri=0;
		
		boolean durum=true;
		do{
			
			try{
				ekranayaz(metin,false);
				veri = sc.nextInt();
				durum=false;
			}catch(Exception ex){
				ekranayaz("Girilen Bilgi Hatalý!", true);
			}
		}
		while(durum);
		return veri; 
	}
	
	
	
	public void ekranayaz(String metin, boolean tur)
	{
		if(tur)
			System.out.println(metin); 
		else
			System.out.print(metin); 
	}
	}

