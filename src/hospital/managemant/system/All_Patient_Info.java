package hospital.managemant.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.ResultSet;


public class All_Patient_Info extends JFrame{

    All_Patient_Info()
    {

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        add(panel);

       JTable table=new JTable();
       table.setBounds(10,40,900,450);
       table.setBackground(new Color(90,156,163));
       table.setFont(new Font("Tahoma",Font.BOLD,12));
       panel.add(table);

       try {
            conn c=new conn();
            String q="select * from Patient_Info";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label1=new JLabel("ID");
        label1.setBounds(31,11,100,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Number");
        label2.setBounds(150,11,100,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Name");
        label3.setBounds(270,11,100,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Gender");
        label4.setBounds(360,11,100,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("Disease");
        label5.setBounds(480,11,100,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6=new JLabel("Room");
        label6.setBounds(600,11,100,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7=new JLabel("Time");
        label7.setBounds(700,11,100,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8=new JLabel("Deposite");
        label8.setBounds(800,11,100,20);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton b1=new JButton("Back");
        b1.setBounds(400,500,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);

            }
        });


        setUndecorated(true);
        setSize(900,600);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new All_Patient_Info();
    }
    
}
