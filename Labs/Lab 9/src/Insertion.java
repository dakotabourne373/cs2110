import java.util.ArrayList;

public class Insertion {

	public static void algorithim(Comparable[] listie){
		for(int j=1; j<listie.length; j++) {
			for(int i=j-1; i >= 0; i--) {
				if(listie[j].compareTo(listie[i]) < 0){
					Comparable no = listie[i];
					listie[i] = listie[j];
					listie[j] = no;
					j--;
				}
			}
		}
	}

	public static void main(String[] args) {
		Comparable[] yesie = new Comparable[7];
		yesie[0] = 9;
		yesie[1] = 6;
		yesie[2] = 4;
		yesie[3] = 3;
		yesie[4] = 0;
		yesie[5] = 10;
		yesie[6] = -2;


		algorithim(yesie);
		System.out.println(yesie.toString());

		for(int i=0; i<7;i++) {
			System.out.println(yesie[i]);
		}
	}
}
