package clue.model.vo.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clue.controller.Base;
import clue.model.vo.Player;
import clue.model.vo.card.PersonCards;
import clue.model.vo.card.PlaceCards;
import clue.model.vo.card.ThingsCards;

public class SelectFrame extends JFrame {
	private JButton person1;
	private JButton person2;
	private JButton person3;
	private JButton person4;
	private JButton person5;
	private JButton person6;
	private String murderCards;
	private Player[] player = new Player[6];
	{
		player[0] = new Player("나");
		player[1] = new Player("com1");
		player[2] = new Player("com2");
		player[3] = new Player("com3");
		player[4] = new Player("com4");
		player[5] = new Player("com5");
	}

	public SelectFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 512, d.height / 2 - 384, 1024, 768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 768);
		panel.setLayout(new GridLayout(2, 3));

		person1 = new JButton(new ImageIcon(
				new ImageIcon("images/그린.jpg").getImage().getScaledInstance(341, 384, Image.SCALE_DEFAULT)));
		person2 = new JButton(new ImageIcon(
				new ImageIcon("images/머스타드.jpg").getImage().getScaledInstance(341, 384, Image.SCALE_DEFAULT)));
		person3 = new JButton(new ImageIcon(
				new ImageIcon("images/스칼렛.jpg").getImage().getScaledInstance(341, 384, Image.SCALE_DEFAULT)));
		person4 = new JButton(new ImageIcon(
				new ImageIcon("images/플럼.jpg").getImage().getScaledInstance(341, 384, Image.SCALE_DEFAULT)));
		person5 = new JButton(new ImageIcon(
				new ImageIcon("images/피콕.jpg").getImage().getScaledInstance(341, 384, Image.SCALE_DEFAULT)));
		person6 = new JButton(new ImageIcon(
				new ImageIcon("images/화이트.jpg").getImage().getScaledInstance(341, 384, Image.SCALE_DEFAULT)));

		// 이벤트리스너 지정
		person1.addActionListener(new SelectActionListener());
		person2.addActionListener(new SelectActionListener());
		person3.addActionListener(new SelectActionListener());
		person4.addActionListener(new SelectActionListener());
		person5.addActionListener(new SelectActionListener());
		person6.addActionListener(new SelectActionListener());

		panel.add(person1);
		panel.add(person2);
		panel.add(person3);
		panel.add(person4);
		panel.add(person5);
		panel.add(person6);

		add(panel);

		Base base = new Base(player);
		murderCards = (String)base.getMurderCards();
		System.out.println(murderCards);

		setResizable(false);
		setVisible(true);

	}

	class SelectActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 내캐릭터 정해서 player배열에 넣기
			if (e.getSource() == person1) {
				player[0].setCharacter("그린");
			} else if (e.getSource() == person2) {
				player[0].setCharacter("머스타드");
			} else if (e.getSource() == person3) {
				player[0].setCharacter("스칼렛");
			} else if (e.getSource() == person4) {
				player[0].setCharacter("플럼");
			} else if (e.getSource() == person5) {
				player[0].setCharacter("피콕");
			} else if (e.getSource() == person6) {
				player[0].setCharacter("화이트");
			}

			// 컴퓨터 캐릭터들 랜덤으로 player배열에 넣기
			int overlap = 0; // 중복
			PersonCards personC = new PersonCards();

			// 선택한 캐릭터 번호 가져오기
			for (int i = 0; i < player.length; i++) {
				if (personC.getPersonCard()[i].getName().equals(player[0].getCharacter())) {
					overlap = personC.getPersonCard()[i].getCardNum();
				}
			}

			// 중복없는 랜덤값
			Set<Integer> rnd = new LinkedHashSet<>();
			while (rnd.size() < 6) {
				int r = (int) (Math.random() * 6);
				rnd.add(r);
			}

			// 사용자 선택 캐릭터 제외
			rnd.remove(overlap - 1);

			// 컴퓨터에게 말 분배
			int num = 1;
			for (int r : rnd) {
				player[num].setCharacter(personC.getPersonCard()[r].getName());
				num++;
			}

			// 다음 프레임으로 가기
			dispose();
			new GameFrame(player, murderCards);
		}

	}

}
