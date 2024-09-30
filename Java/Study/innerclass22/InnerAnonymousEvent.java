package innerclass22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InnerAnonymousEvent extends JFrame{
	JButton btn1, btn2, btn3;
	
	public InnerAnonymousEvent() {
		setTitle("내부 익명 클래스로 이벤트 처리하기");
		setLayout(new FlowLayout());
		add(btn1 = new JButton("1번 버튼"));
		add(btn2 = new JButton("2번 버튼"));
		add(btn3 = new JButton("3번 버튼"));
		
		// 윈도우의 시스템 이벤트 처리를 익명 클래스로 처리해보기
		// windowListener라는 인터페이스 -> 모든 함수 재정의해야함
		// windowListener를 상속받은 windowadapter -> 원하는 함수만 재정의가능
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 익명클래스로 버튼 이벤트 처리 방법 1.
		/*
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn1, "1번 버튼 클릭");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn2, "2번 버튼 클릭");
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn3, "3번 버튼 클릭");
			}
		});
		*/
		
		// 방법 2. ♣
		btn1.addActionListener(handler);
		btn2.addActionListener(handler);
		btn3.addActionListener(handler);
		
		pack();
		setVisible(true);
	}	
	
	// 익명클래스로 버튼 이벤트 처리 방법 2. ♣
	private ActionListener handler = new ActionListener() {	//익명클래스 타입의 주소 넣어주기
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1)
				JOptionPane.showMessageDialog(btn1, "1번 버튼 클릭");
			else if(e.getSource() == btn2)
				JOptionPane.showMessageDialog(btn2, "2번 버튼 클릭");
			else
				JOptionPane.showMessageDialog(btn3, "3번 버튼 클릭");
			
		}
	};
	
	
	public static void main(String[] args) {
		new InnerAnonymousEvent();
	}

}
