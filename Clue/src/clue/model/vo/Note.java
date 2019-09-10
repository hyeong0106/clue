package clue.model.vo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class Note extends JFrame {
	JTable table;
	
	public Note() {
		super("추리 노트");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 640, d.height / 2 - 360, 450, 720);

		// 테이블 생성
		String[] columns = { "      ", "나", "컴퓨터1", "컴퓨터2", "컴퓨터3", "컴퓨터4", "컴퓨터5" };
		Object[][] data = { { "사람", "", "", "", "", "", "" }, { "플럼", "", "", "", "", "", "" },
				{ "화이트", "", "", "", "", "", "" }, { "스칼렛", "", "", "", "", "", "" }, { "그린", "", "", "", "", "", "" },
				{ "머스타드", "", "", "", "", "", "" }, { "피콕", "", "", "", "", "", "" }, { "도구", "", "", "", "", "", "" },
				{ "밧줄", "", "", "", "", "", "" }, { "단검", "", "", "", "", "", "" }, { "렌치", "", "", "", "", "", "" },
				{ "권총", "", "", "", "", "", "" }, { "촛대", "", "", "", "", "", "" }, { "파이프", "", "", "", "", "", "" },
				{ "장소", "", "", "", "", "", "" }, { "마당", "", "", "", "", "", "" }, { "개인룸", "", "", "", "", "", "" },
				{ "서재", "", "", "", "", "", "" }, { "식당", "", "", "", "", "", "" }, { "차고", "", "", "", "", "", "" },
				{ "거실", "", "", "", "", "", "" }, { "부엌", "", "", "", "", "", "" }, { "침실", "", "", "", "", "", "" },
				{ "욕실", "", "", "", "", "", "" } };
		table = new JTable(data, columns);
		table.setRowHeight(25);

		// 스크롤페인으로 관리
		JScrollPane scr = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		// data 편집시 ComboBox 제공
		TableColumn player1 = table.getColumnModel().getColumn(1);
		TableColumn player2 = table.getColumnModel().getColumn(2);
		TableColumn player3 = table.getColumnModel().getColumn(3);
		TableColumn player4 = table.getColumnModel().getColumn(4);
		TableColumn player5 = table.getColumnModel().getColumn(5);
		TableColumn player6 = table.getColumnModel().getColumn(6);

		JComboBox<String> combo = new JComboBox<>();
		combo.addItem(" ");
		combo.addItem("O");
		combo.addItem("X");
		combo.addItem("?");

		// 해당컬럼의 기본편집기를 CellEditor객체로 지정
		player1.setCellEditor(new DefaultCellEditor(combo));
		player2.setCellEditor(new DefaultCellEditor(combo));
		player3.setCellEditor(new DefaultCellEditor(combo));
		player4.setCellEditor(new DefaultCellEditor(combo));
		player5.setCellEditor(new DefaultCellEditor(combo));
		player6.setCellEditor(new DefaultCellEditor(combo));

		add(scr);
		setResizable(false);
		setVisible(true);
	}

}
