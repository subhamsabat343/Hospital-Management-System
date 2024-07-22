package hospital.managemant.system;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department()
    {

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        add(panel);

       JTable table=new JTable();
       table.setBounds(10,40,700,350);
       table.setBackground(new Color(90,156,163));
       table.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(table);

       try {
            conn c=new conn();
            String q="select * from department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label1=new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Phone Number");
        label2.setBounds(430,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);


        JButton b1=new JButton("Back");
        b1.setBounds(280,410,130,30);
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
        setSize(700,500);
        setLocation(350,250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
    
}
