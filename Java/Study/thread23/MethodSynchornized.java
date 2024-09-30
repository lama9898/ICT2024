package thread23;

//메소드 동기화: 여러 스레드에 의해 호출되는 공유 메소드를 동기화 함으로써 여러 스레드가
//동시에 호출 못하도록 lock을 거는 것
/*
	[형식]
		접근지정자 synchronized  반환타입 메소드명([매개변수]){
		
		}
*/
//여러 스레드가 공유하는 메소드를 가진 클래스-인스턴스 하나만 만든다 각 스레드에 인스턴스를 전달한다

class MethodSyncClass{
	int seed; //여러 스레드가 공유하는 메모리
	public MethodSyncClass(int seed) {
		this.seed = seed; 
	}
	
	// 동기화시 synchronized 지정자 추가
	synchronized void increase(int inc) {
		for(int i=0;i<=10;i++) {
			seed+=inc;
			System.out.println(String.format("스레드 이름 : %s, 공유 데이터 :%s", Thread.currentThread().getName(),seed,i));
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) { e.printStackTrace(); }
		}
	}
}

// 공유 데이터를 사용하는 스레드
class MethodSyncThread extends Thread{
	MethodSyncClass msc;	//공유할 데이터를 갖고 있는 DataSyncClass 타입
	// 일정하게 증가시킬 숫자를 저장
	int inc;
	// 인자 생성자
	public MethodSyncThread(MethodSyncClass msc, int inc, String threadName) {
		super(threadName);
		this.msc = msc;
		this.inc = inc;
	}
	
	@Override
	public void run() {
		msc.increase(inc);
	}
}



public class MethodSynchornized {
	public static void main(String[] args) {
		// 공유메모리를 갖고 있는 클래스를 하나만 인스턴스화
		MethodSyncClass msc = new MethodSyncClass(10);
		
		// 두개의 스레드 생성
		MethodSyncThread mst1 = new MethodSyncThread(msc,2, "1st 스레드");
		MethodSyncThread mst2 = new MethodSyncThread(msc,5, "2nd 스레드");
		mst1.start();
		mst2.start();
		
	}	// main
}	// class DataSynchornized
