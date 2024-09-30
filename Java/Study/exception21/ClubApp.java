package exception21;

public class ClubApp {

	public static void main(String[] args) {
		Club club = new Club();
		try {
			club.entrance("남루",25);
		} catch(NotGoodApperanceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrance("정장",15);
		} catch(NotGoodApperanceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrance("정장",45);
		} catch(NotGoodApperanceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrance("정장",35);
		} catch(NotGoodApperanceException e) {
			System.out.println(e.getMessage());
		}
	}

}
