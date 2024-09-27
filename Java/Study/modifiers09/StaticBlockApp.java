package modifiers09;

import javax.swing.plaf.synth.SynthToggleButtonUI;


public class StaticBlockApp {

	public static void main(String[] args) {
		System.out.println("StaticBlockApp의 main메소드");
		//StaticBlock의 인스턴스화
		
		
		StaticBlock sb = new StaticBlock();	// static block이 생성자보다 먼저 실행됨

	}	//main

}	//class StaticBlockApp