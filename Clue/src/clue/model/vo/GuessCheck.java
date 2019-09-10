package clue.model.vo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clue.model.vo.ui.EndFrame;
import clue.model.vo.ui.GameFrame;

public class GuessCheck {
	private JTextField jt;
	private JDialog jd;
	private String place = "???";
	private String person = "???";
	private String thing = "???";
	private String murderCards;
	private Player[] playerArr;
	private int num;
	private JButton jb;


	public GuessCheck(Player[] playerArr, String murderCards) {
		this.playerArr = playerArr;
		this.murderCards = murderCards;
		
		for(int i=0;i<playerArr.length;i++) {
			if(playerArr[i].getName().equals("나 ")) num = i;
		}
		
		jd = new JDialog();
		jd.setTitle("정답 추리 하기");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		jd.setBounds(d.width / 2 - 640, d.height / 2 - 360, 550, 300);
		jd.setLayout(null);

		JPanel person = new JPanel();
		person.setBounds(0, 0, 540, 70);
		TitledBorder personBorder = new TitledBorder(new LineBorder(Color.BLACK), "살인범을 추리하세요");
		person.setBorder(personBorder);
		JRadioButton jrp1 = new JRadioButton("스칼렛");
		JRadioButton jrp2 = new JRadioButton("화이트");
		JRadioButton jrp3 = new JRadioButton("머스타드");
		JRadioButton jrp4 = new JRadioButton("그린");
		JRadioButton jrp5 = new JRadioButton("피콕");
		JRadioButton jrp6 = new JRadioButton("플럼");

		jrp1.addActionListener(new printButton());
		jrp2.addActionListener(new printButton());
		jrp3.addActionListener(new printButton());
		jrp4.addActionListener(new printButton());
		jrp5.addActionListener(new printButton());
		jrp6.addActionListener(new printButton());

		ButtonGroup personGroup = new ButtonGroup();
		personGroup.add(jrp1);
		personGroup.add(jrp2);
		personGroup.add(jrp3);
		personGroup.add(jrp4);
		personGroup.add(jrp5);
		personGroup.add(jrp6);

		person.add(jrp1);
		person.add(jrp2);
		person.add(jrp3);
		person.add(jrp4);
		person.add(jrp5);
		person.add(jrp6);

		JPanel things = new JPanel();
		things.setBounds(0, 70, 540, 70);
		TitledBorder thingsBorder = new TitledBorder(new LineBorder(Color.BLACK), "살인 도구를 추리하세요");
		things.setBorder(thingsBorder);
		JRadioButton jrt1 = new JRadioButton("밧줄");
		JRadioButton jrt2 = new JRadioButton("단검");
		JRadioButton jrt3 = new JRadioButton("랜치");
		JRadioButton jrt4 = new JRadioButton("권총");
		JRadioButton jrt5 = new JRadioButton("촛대");
		JRadioButton jrt6 = new JRadioButton("파이프");

		jrt1.addActionListener(new printButton2());
		jrt2.addActionListener(new printButton2());
		jrt3.addActionListener(new printButton2());
		jrt4.addActionListener(new printButton2());
		jrt5.addActionListener(new printButton2());
		jrt6.addActionListener(new printButton2());

		ButtonGroup thingsGroup = new ButtonGroup();
		thingsGroup.add(jrt1);
		thingsGroup.add(jrt2);
		thingsGroup.add(jrt3);
		thingsGroup.add(jrt4);
		thingsGroup.add(jrt5);
		thingsGroup.add(jrt6);

		things.add(jrt1);
		things.add(jrt2);
		things.add(jrt3);
		things.add(jrt4);
		things.add(jrt5);
		things.add(jrt6);

		JPanel places = new JPanel();
		places.setBounds(0, 140, 540, 70);
		TitledBorder placeBorder = new TitledBorder(new LineBorder(Color.BLACK), "살인 장소를 추리하세요");
		places.setBorder(placeBorder);
		JRadioButton jrplace1 = new JRadioButton("마당");
		JRadioButton jrplace2 = new JRadioButton("게임룸");
		JRadioButton jrplace3 = new JRadioButton("서재");
		JRadioButton jrplace4 = new JRadioButton("식당");
		JRadioButton jrplace5 = new JRadioButton("차고");
		JRadioButton jrplace6 = new JRadioButton("거실");
		JRadioButton jrplace7 = new JRadioButton("부엌");
		JRadioButton jrplace8 = new JRadioButton("침실");
		JRadioButton jrplace9 = new JRadioButton("욕실");

		jrplace1.addActionListener(new printButton3());
		jrplace2.addActionListener(new printButton3());
		jrplace3.addActionListener(new printButton3());
		jrplace4.addActionListener(new printButton3());
		jrplace5.addActionListener(new printButton3());
		jrplace6.addActionListener(new printButton3());
		jrplace7.addActionListener(new printButton3());
		jrplace8.addActionListener(new printButton3());
		jrplace9.addActionListener(new printButton3());

		ButtonGroup placeGroup = new ButtonGroup();
		placeGroup.add(jrplace1);
		placeGroup.add(jrplace2);
		placeGroup.add(jrplace3);
		placeGroup.add(jrplace4);
		placeGroup.add(jrplace5);
		placeGroup.add(jrplace6);
		placeGroup.add(jrplace7);
		placeGroup.add(jrplace8);
		placeGroup.add(jrplace9);

		places.add(jrplace1);
		places.add(jrplace2);
		places.add(jrplace3);
		places.add(jrplace4);
		places.add(jrplace5);
		places.add(jrplace6);
		places.add(jrplace7);
		places.add(jrplace8);
		places.add(jrplace9);

		JPanel result = new JPanel();
		result.setBounds(0, 220, 540, 30);
		result.setLayout(new BoxLayout(result, BoxLayout.X_AXIS));
		JLabel l = new JLabel("추리결과 = ");
		jt = new JTextField(8);
		jt.setEditable(false);

		jb = new JButton("확정");
		jb.setSize(20, 20);
		jb.addActionListener(new button());

		result.add(l);
		result.add(jt);
		result.add(jb);

		jd.add(person);
		jd.add(things);
		jd.add(places);
		jd.add(result);
		
		
		
		jd.setResizable(false);
		jd.setVisible(true);
	}

	class printButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton jr = (JRadioButton) e.getSource();
			person = jr.getText();
			jt.setText(place + "에서 " + person + "이(가) " + thing + "(으)로 살인을 함");

		}
	}

	class printButton2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton jr = (JRadioButton) e.getSource();
			thing = jr.getText();
			jt.setText(place + "에서 " + person + "이(가) " + thing + "(으)로 살인을 함");

		}
	}

	class printButton3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton jr = (JRadioButton) e.getSource();
			place = jr.getText();
			jt.setText(place + "에서 " + person + "이(가) " + thing + "(으)로 살인을 함");

		}
	}

	class button implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String check;
			check = place + "에서 " + person + "이(가) " + thing + "(으)로 살인을 함";
			
			if (!person.equals("???") && !thing.equals("???")&& !place.equals("???")) {
				if (check.equals(murderCards)) {
					playerArr[num].setScore(playerArr[num].getScore()+100);
					new EndFrame(playerArr);
					
					jd.dispose();
				} else {
					JOptionPane.showMessageDialog(jd, "틀렸습니다", "입력오류", JOptionPane.WARNING_MESSAGE);
					jd.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(jd, "살인범과 살인도구와 장소를 모두 선택하세요", "입력오류", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public JButton getJb() {
		return jb;
	}

	public void setJb(JButton jb) {
		this.jb = jb;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}