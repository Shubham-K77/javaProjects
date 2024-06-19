package Application;
import java.awt.*;
import dataBase.fetchAll;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class displayRecordPage extends JPanel{
    JTable displayTable;
    JScrollPane scroll;
    Font myfont;
    public displayRecordPage(){
        this.setLayout(null);
        scroll = new JScrollPane();
        myfont = new Font("Verdana", Font.PLAIN, 20);
        String[][]data = fetchAll.getFetchedData();
        String[]columns = {"FirstName", "LastName", "Gender", "Program", "Section", "BookTaken"};
        displayTable = new JTable(data,columns);
        displayTable.setFont(myfont);
        displayTable.setRowHeight(50);
        JTableHeader header = displayTable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 60));
        header.setFont(myfont);
        scroll.setViewportView(displayTable);
        scroll.setBounds(50, 15, 900, 450);
        this.add(scroll);
    }
}
