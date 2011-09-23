package cd.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cd.util.regex.Regex;

/**
 * ������... ��������ܶิ���ַ��м��������ֵļӷ�.��Ҫ�Ƕ������õ���.
 * @author Administrator
 *
 */
public class Calcu  implements ActionListener{

	JFrame frame = null;
	JTextArea textArea = null;
	JTextField textField = null;
	
	public Calcu(){}
	public Calcu(String name){

	    frame = new JFrame(name);
	    frame.setLayout(new BorderLayout());
	    textArea = new JTextArea();
	    textArea.setLineWrap(true);
	    textArea.setRows(20);
	    textArea.setColumns(60);
	    
	    JScrollPane jsp = new JScrollPane(textArea);
	    
	    JPanel northPanel = new JPanel();
	    northPanel.add(jsp);
	    frame.getContentPane().add(northPanel, BorderLayout.NORTH);
	    
	    JPanel southPanel = new JPanel();
	    southPanel.setLayout(new GridLayout(1,2));
	    
	    textField = new JTextField();
	    southPanel.add(textField);
	    
	    JButton button1 = new JButton("��");
	    button1.addActionListener(this);
	    southPanel.add(button1);
	    
	    frame.getContentPane().add(southPanel);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��")){
			Long result = 0L;
			String text = textArea.getText();
//			System.out.println(text);
			if(text == null || "".equals(text)){
				textField.setText("û�ҵ�����");
			}else{
				List<String> ds = Regex.d(text);
				for(String d : ds){
					result += Long.valueOf(d);
				}
				textField.setText(result.toString());
			}
		}
	}

	public static void main(String[] args) {
		new Calcu("���������");
	}

}
