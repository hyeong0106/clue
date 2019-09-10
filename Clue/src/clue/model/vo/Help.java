package clue.model.vo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame{
	JDialog jd;
	
	public Help() {
		jd = new JDialog();
		jd.setTitle("게임 방법 설명");
		jd.setBounds(0, 0, 970, 350);
		jd.setLayout(null);
		
		JLabel jb1 = new JLabel();
		jb1.setText("게임 방법");
		jb1.setBounds(0, 10, 800, 20);
		
		JLabel jb2 = new JLabel();
		jb2.setText("6명의 [용의자] 카드, 9개의[범행장소] 카드, 6가지[도구] 카드가 있습니다. 게임에서 이기기 위해서는 누가,어떤도구로,어디에서 범행을 저질렀는지 찾아야합니다.");
		jb2.setBounds(0, 30, 950, 20);
		
		JLabel jb3 = new JLabel();
		jb3.setText("6명의 [용의자] : 플럼, 화이트, 스칼렛, 그린, 머스타드, 피콕");
		jb3.setBounds(0, 50, 800, 20);
		
		JLabel jb4 = new JLabel();
		jb4.setText("9개의[범행장소] : 마당, 게임룸, 서재, 식당, 차고, 거실, 부엌, 침실, 욕실");
		jb4.setBounds(0, 70, 800, 20);
		
		JLabel jb5 = new JLabel();
		jb4.setText("6가지[도구] : 밧줄, 단검, 렌치, 권총, 촛대, 파이프");
		jb4.setBounds(0, 90, 800, 20);
		
		JLabel jb6 = new JLabel();
		jb4.setText("진행순서");
		jb4.setBounds(0, 110, 950, 20);
		
		JLabel jb7 = new JLabel();
		jb7.setText("스타트 버튼을 누르면 랜덤으로 순서가 정해지며 각 컴퓨터에게 정답카드를 제외한 3종류의 카드들중 랜덤한 3장의 카드가 주어집니다.");
		jb7.setBounds(0, 130, 950, 20);
		
		JLabel jb8 = new JLabel();
		jb8.setText("플레이어는 한 컴퓨터의 보유 카드와 추리 상황을 보며 정답버튼을 눌러 정답을 맞출 수 있습니다.");
		jb8.setBounds(0, 150, 950, 20);
		
		JLabel jb9 = new JLabel();
		jb9.setText("ex) [들어간방]에서[누가][무엇]으로 살인을 했다");
		jb9.setBounds(8, 180, 800, 20);
		
		JLabel jb10 = new JLabel();
		jb10.setText("역순으로 돌아가며 추측한 카드들중 가지고 있는 카드가 있으면 1개만 추측한 사람에게 보여준 후 턴이 종료됩니다.");
		jb10.setBounds(0, 210, 800, 20);
		
		JLabel jb11 = new JLabel();
		jb11.setText("정답을 맞춘 후 컴퓨터보다 점수가 높다면 게임에서 승리 합니다.");
		jb11.setBounds(0, 230, 800, 20);
		
		JButton jbutton = new JButton("닫기");
		jbutton.setBounds(200, 270, 60, 30);
		jbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jd.dispose();
			}
		});
		
		jd.add(jb1);
		jd.add(jb2);
		jd.add(jb3);
		jd.add(jb4);
		jd.add(jb5);
		jd.add(jb6);
		jd.add(jb7);
		jd.add(jb8);
		jd.add(jb9);
		jd.add(jb10);
		jd.add(jb11);
		jd.add(jbutton);
		jd.setResizable(false);
		jd.setVisible(true);
	}
}