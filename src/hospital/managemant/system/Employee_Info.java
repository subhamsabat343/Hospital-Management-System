package hospital.managemant.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.ResultSet;

public class Employee_Info extends JFrame{

    Employee_Info()
    {

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        add(panel);

       JTable table=new JTable();
       table.setBounds(10,34,980,450);
       table.setBackground(new Color(109,164,170));
       table.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(table);

       try {
            conn c=new conn();
            String q="select * from EMP_INFO";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Name");
        label1.setBounds(41,9,120,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Age");
        label2.setBounds(180,9,120,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Phone Number");
        label3.setBounds(350,9,120,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Salary");
        label4.setBounds(550,9,120,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("Gmail");
        label5.setBounds(700,9,120,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6=new JLabel("Aadhar Id");
        label6.setBounds(830,9,80,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

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
        setSize(1000,600);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_Info();
    }
    
}
