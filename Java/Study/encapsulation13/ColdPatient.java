package encapsulation13;

public class ColdPatient {

	//캡슐화 전
	/*
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
	*/
	
	//캡슐화
	Contack600 contack600 = new Contack600();
	void take() {
		contack600.take();
	}
	
}
