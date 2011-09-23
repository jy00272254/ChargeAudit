package cd.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**********************Java计算器 主类*********************/

/**
 * 网上COPY的类,以后写计算器的时候看看.
 */
public class SunnyCalculator implements ActionListener {
    JFrame f;
    JMenu mEdit;
    JMenu mView;
    JMenu mHelp;
    JMenuItem mCopy;
    JMenuItem mPaste;
    JTextField tResult;
    JButton bNumber;
    JButton bOperator;
    JButton bOther;
    JButton bM;
    boolean isDouble=false;//是否为实数
    int opFlag=-1;
    static double t1=0,t2=0,t3=0,result=0;
    static int opflag1=-1,opflag2=-1,flag=0,resflag=1;
    int preOp,currentOp=0;//标准位
    double op1=0,op2=0;//操作数
    double n3;
    StringBuffer buf=new StringBuffer(20);
    StringBuffer copyBoard=new StringBuffer(20);//剪贴板
    StringBuffer memory=new StringBuffer(20);//M系列
    StringBuffer str=new StringBuffer();
    //Java计算器 构造器
    public SunnyCalculator()
    {
        f = new JFrame("Sunny计算器_杨梅树的盔甲");
        Container contentPane = f.getContentPane();
        /**************************Java计算器 菜单的创建*****************************/
        JMenuBar mBar = new JMenuBar();
        mBar.setOpaque(true);
        mEdit = new JMenu("编辑(E)");
        mEdit.setMnemonic(KeyEvent.VK_E);
        mCopy = new JMenuItem("复制(C)");
        mEdit.add(mCopy);
        mPaste = new JMenuItem("粘贴(P)");
        mEdit.add(mPaste);
        mView = new JMenu("查看(V)");
        mView.setMnemonic(KeyEvent.VK_V);
        mView.add(new JMenuItem("标准型"));
        mView.add(new JMenuItem("科学型"));
        mView.addSeparator();
        mView.add(new JMenuItem("查看分组"));
        mHelp = new JMenu("帮助(H)");
        mHelp.setMnemonic(KeyEvent.VK_H);
        mHelp.add(new JMenuItem("帮助主题"));
        mHelp.addSeparator();
        mHelp.add(new JMenuItem("关于计算器"));
        mBar.add(mEdit);
        mBar.add(mView);
        mBar.add(mHelp);
        f.setJMenuBar(mBar);
        contentPane.setLayout(new BorderLayout());
        JPanel pTop = new JPanel();
        tResult = new JTextField("0.",26);
        tResult.setHorizontalAlignment(JTextField.RIGHT);
        tResult.setEditable(false);
        pTop.add(tResult);
        contentPane.add(pTop,BorderLayout.NORTH);
        JPanel pBottom = new JPanel();
        pBottom.setLayout(new BorderLayout());
        JPanel pLeft = new JPanel();
        pLeft.setLayout(new GridLayout(5,1,3,3));
        bM = new JButton(" ");
        bM.setEnabled(false);
        pLeft.add(bM);

        /*************************Java计算器 功能键定义***************************/
        bOther = new JButton("MC");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        bOther.setMargin(new Insets(3,2,3,2));
        pLeft.add(bOther);

        bOther = new JButton("MR");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        bOther.setMargin(new Insets(3,2,3,2));
        pLeft.add(bOther);

        bOther = new JButton("MS");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        bOther.setMargin(new Insets(3,2,3,2));
        pLeft.add(bOther);

        bOther = new JButton("M+");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        bOther.setMargin(new Insets(3,2,3,2));
        pLeft.add(bOther);

        pBottom.add(pLeft,BorderLayout.WEST);
        JPanel pRight = new JPanel();
        pRight.setLayout(new BorderLayout());
        JPanel pUp = new JPanel();
        pUp.setLayout(new GridLayout(1,3,3,0));

        bOther = new JButton("BackSpace");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        bOther.setMargin(new Insets(3,0,3,5));
        pUp.add(bOther);

        bOther = new JButton("CE");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        pUp.add(bOther);

        bOther = new JButton("C");
        bOther.addActionListener(this);
        bOther.setForeground(Color.red);
        pUp.add(bOther);

        /***************************Java计算器 数字键盘区定义**************************/
        JPanel pDown = new JPanel();
        pDown.setLayout(new GridLayout(4,5,3,2));
        bNumber = new JButton("7");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bNumber = new JButton("8");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bNumber = new JButton("9");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bOperator = new JButton("/");
        bOperator.setForeground(Color.red);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,0,3,0));
        pDown.add(bOperator);
        bOperator = new JButton("sqrt");
        bOperator.addActionListener(this);
        bOperator.setForeground(Color.red);
        bOperator.setMargin(new Insets(3,0,3,0));
        pDown.add(bOperator);
        bNumber = new JButton("4");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        bNumber.setHorizontalTextPosition(JButton.LEFT);
        pDown.add(bNumber);
        bNumber = new JButton("5");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bNumber = new JButton("6");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bOperator = new JButton("*");
        bOperator.setForeground(Color.red);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        bOperator = new JButton("%");
        bOperator.setForeground(Color.blue);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        bNumber = new JButton("1");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bNumber = new JButton("2");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bNumber = new JButton("3");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bOperator = new JButton("-");
        bOperator.setForeground(Color.red);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        bOperator = new JButton("1/x");
        bOperator.setForeground(Color.blue);
        bOperator.addActionListener(this);
        pDown.add(bOperator);
        bNumber = new JButton("0");
        bNumber.setForeground(Color.blue);
        bNumber.addActionListener(this);
        bNumber.setMargin(new Insets(3,3,3,3));
        pDown.add(bNumber);
        bOperator = new JButton("+/-");
        bOperator.setForeground(Color.blue);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        bOperator = new JButton(".");
        bOperator.setForeground(Color.blue);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        bOperator = new JButton("+");
        bOperator.setForeground(Color.blue);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        bOperator = new JButton("=");
        bOperator.setForeground(Color.blue);
        bOperator.addActionListener(this);
        bOperator.setMargin(new Insets(3,3,3,3));
        pDown.add(bOperator);
        pRight.add(pUp,BorderLayout.NORTH);
        pRight.add(pDown,BorderLayout.SOUTH);
        pBottom.add(pRight,BorderLayout.EAST);
        contentPane.add(pBottom,BorderLayout.SOUTH);
        f.setSize(new Dimension(320,256));
        f.setResizable(false);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }
        );
    }
    /************************Java计算器 计算方法区***************************/
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("复制(C)"))
        {
            String temp = tResult.getText().trim();
            copyBoard.replace(0, copyBoard.length(), temp);
            mPaste.setEnabled(true);
        }
        else if(s.equals("粘贴(p)"))
        {
            tResult.setText(copyBoard.toString());
        }
        else if(s.equals("CE"))
        {
            //如果是CE则清除文本框
            tResult.setText("0.");
        }
        else if(s.equals("BackSpace"))
        {
            if(!tResult.getText().trim().equals("0."))
            {
                //如果文本框中有内容
                if(str.length()!=1 && str.length()!=0)
                {
                    tResult.setText(str.delete(str.length()-1,str.length()).toString());
                }
                else
                {
                    tResult.setText("0.");
                    str.setLength(0);
                }
            }
            op2 = Double.parseDouble(tResult.getText().trim());
        }
        else if(s.equals("C"))
        {
            //如果是C删除当前计算
            tResult.setText("0.");
            op1 = op2 = 0;
            str.replace(0, str.length(), " ");
            preOp = currentOp = 0;
        }
        else if(s.equals("MC"))
        {
            //如果是MC则清除缓冲区
            String temp = "";
            memory.replace(0, memory.length(), temp);
            bM.setText(" ");
        }
        else if(s.equals("MR"))
        {
            //如果按键为MR则恢复缓冲区的数到文本框
            tResult.setText(memory.toString());
        }
        else if(s.equals("MS"))
        {
            //如果按键为MS则将文本框的数存入缓冲区
            String s1 = tResult.getText().trim();
            memory.replace(0, memory.length(), s1);
            bM.setText("M");
        }
        else if(s.equals("M+"))
        {
            //如果按键为MS则将文本框值与缓冲区的数相加但不显示结果
            String temp1 = tResult.getText().trim();
            double dtemp = Double.parseDouble(temp1);
            String temp2 = memory.toString();
            dtemp += Double.parseDouble(temp2);
            temp1 = String.valueOf(dtemp);
            memory.replace(0, memory.length(), temp1);
        }
        else if(s.equals("1/x"))
        {
            //如果按键为1/x则将文本框中的数据为它的倒数
            String temp = tResult.getText().trim();
            double dtemp = Double.parseDouble(temp);
            tResult.setText(""+1/dtemp);
        }
        else if(s.equals("sqrt"))
        {
            //如果按键为sqrt则将文本框中的内容求平方根
            String temp = tResult.getText().trim();
            double dtemp = Double.parseDouble(temp);
            tResult.setText(""+Math.sqrt(dtemp));
        }
        else if(s.equals("+"))
        {
            str.setLength(0);
            if(currentOp==0)
            {
                preOp = currentOp = 1;
                op2 = 0;
                tResult.setText(""+op1);
            }
            else
            {
                currentOp = preOp;
                preOp = 1;
                switch(currentOp){
                case 1:
                    op1 += op2;
                    tResult.setText(""+op1);
                    break;
                case 2:
                    op1 -= op2;
                    tResult.setText(""+op1);
                    break;
                case 3:
                    op1 *= op2;
                    tResult.setText(""+op1);
                    break;
                case 4:
                    op1 /= op2;
                    tResult.setText(""+op1);
                    break;
                }
            }
        }
        else if(s.equals("-")){
            str.setLength(0);
            if(currentOp==0)
            {
                preOp=currentOp=2;//op1=op2;op2=0;
                tResult.setText(""+op1);
            }
            else
            {
                currentOp =preOp;
                preOp =2;
                switch(currentOp){
case 1:op1=op1+op2;tResult.setText(""+op1);break;
case 2:op1=op1-op2;tResult.setText(""+op1);break;
case 3:op1=op1*op2;tResult.setText(""+op1);break;
case 4:op1=op1/op2;tResult.setText(""+op1);break;
                }
            }
        }
        else if(s.equals("*"))//*
        {
            str.setLength(0);
            if(currentOp==0)
            {
                preOp=currentOp=3;//op1=op2;op2=1;
                tResult.setText(""+op1);//op1=op2;
            }
            else
            {
                currentOp =preOp;
                preOp =3;
                switch(currentOp){
case 1:op1=op1+op2;tResult.setText(""+op1);break;
case 2:op1=op1-op2;tResult.setText(""+op1);break;
case 3:op1=op1*op2;tResult.setText(""+op1);break;
case 4:op1=op1/op2;tResult.setText(""+op1);break;
                }
            }
        }
        else if(s.equals("/"))// /
        {
            str.setLength(0);
            if(currentOp==0)
            {
                preOp=currentOp=4;//op2=1;
                tResult.setText(""+op1);//op1=op2;
            }
            else
            {
                currentOp =preOp;
                preOp =4;
                switch(currentOp){
case 1:op1=op1+op2;tResult.setText(""+op1);break;
case 2:op1=op1-op2;tResult.setText(""+op1);break;
case 3:op1=op1*op2;tResult.setText(""+op1);break;
case 4:op1=op1/op2;tResult.setText(""+op1);break;
                }
            }
        }
        else if(s.equals("="))// =
        {
            if(currentOp==0)
            {
                str.setLength(0);
                tResult.setText(""+op2);
            }
            else
            {
                str.setLength(0);
                currentOp =preOp;
                switch(currentOp){
case 1:op1=op1+op2;tResult.setText(""+op1);break;
case 2:op1=op1-op2;tResult.setText(""+op1);break;
case 3:op1=op1*op2;tResult.setText(""+op1);break;
case 4:op1=op1/op2;tResult.setText(""+op1);break;
                }
                currentOp=0;
                op2=0;
            }
        }
        else if(s.equals("."))
        {
            isDouble=true;
            if(tResult.getText().trim().indexOf('.')!=-1);
            else {
                if(tResult.getText().trim().equals("0")) {
                    str.setLength(0);
                    tResult.setText((str.append("0"+s)).toString());
                }
                //else if(tResult.getText().trim().equals("")){}//如果初时显示为空则不做任何操作
                else {
                    tResult.setText((str.append(s)).toString());
                }
            }
        }
        else if(s.equals("0"))//如果选择的是"0"这个数字键
        {
            if(tResult.getText().trim().equals("0.")){}
            else{
                tResult.setText(str.append(s).toString());
                op2=Double.parseDouble(tResult.getText().trim());
            }
        }
        else{
            tResult.setText(str.append(s).toString());
            op2=Double.parseDouble(tResult.getText().trim());
            if(currentOp==0)
                op1=op2;
        }
    }//end actionPerformed
    public static void main(String[] args) {
        new SunnyCalculator();
    }
}