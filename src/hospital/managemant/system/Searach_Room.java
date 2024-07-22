package hospital.managemant.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.ResultSet;

public class Searach_Room extends JFrame {

    Choice choice;
    JTable table;

    Searach_Room()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel For=new JLabel("Search For Room ");
        For.setBounds(250,11,186,30);
        For.setForeground(Color.white);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status=new JLabel("Status ");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice =new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(10,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);

        try {
            conn c=new conn();
            String q="select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
  

        JLabel Roomno=new JLabel("Room No");
        Roomno.setBounds(23,162,150,20);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        Roomno.setForeground(Color.white);
        panel.add(Roomno);

        JLabel available=new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.white);
        panel.add(available);

        JLabel price=new JLabel("Room No");
        price.setBounds(358,162,150,20);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.white);
        panel.add(price);

        JLabel Bed=new JLabel("Bed Type");
        Bed.setBounds(550,162,150,20);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        Bed.setForeground(Color.white);
        panel.add(Bed);

        JButton search=new JButton("Search");
        search.setBounds(200,420,120,30);
        search.setFont(new Font("serif",Font.BOLD,15));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String q="select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try {
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                    
                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });


        JButton back=new JButton("Back");
        back.setBounds(380,420,120,30);
        back.setFont(new Font("serif",Font.BOLD,15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);

            }
        });

        

        setUndecorated(true);
        setSize(700,500);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Searach_Room();
    }
    
}
