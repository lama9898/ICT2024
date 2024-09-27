package encapsulation13;

public class Contack600 {
	// field
	SneezeCap sneezeCap = new SneezeCap();
	SnifffleCap sniffleCap = new SnifffleCap();
	SnivelCap snivelCap = new SnivelCap();
	
	// method
	void take() {
		// 복용 순서 : 재채기 → 콧물 → 기침
		sneezeCap.take();
		snivelCap.take();
		sniffleCap.take();
	}

}
