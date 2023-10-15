
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class NotificationListCellRenderer extends JPanel implements ListCellRenderer<Notification> {

    private JLabel pdfIdLabel;
    private JLabel pdfNameLabel;
    private JLabel createdTimeLabel;
    private JLabel typeLabel;

    public NotificationListCellRenderer() {
//        setLayout(new GridLayout(1, 4)); // 1 row, 4 columns
setLayout(new FlowLayout(FlowLayout.LEFT));

        pdfIdLabel = new JLabel();
        pdfIdLabel.setFont(new Font("Arial", Font.BOLD, 14));
        pdfIdLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pdfIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        pdfNameLabel = new JLabel();
        pdfNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        pdfNameLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        createdTimeLabel = new JLabel();
        createdTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        createdTimeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        createdTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        typeLabel = new JLabel();
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        typeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        pdfIdLabel.setPreferredSize(new Dimension(50, 30)); // Adjust width and height as needed
        pdfNameLabel.setPreferredSize(new Dimension(400, 30));
        createdTimeLabel.setPreferredSize(new Dimension(150, 30));
        typeLabel.setPreferredSize(new Dimension(200, 30));

        add(pdfIdLabel);
        add(pdfNameLabel);
        add(createdTimeLabel);
        add(typeLabel);
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: Set a border around the cell
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Notification> list, Notification notification, int index, boolean isSelected, boolean cellHasFocus) {
        
        pdfIdLabel.setText(String.valueOf(notification.getPdfId()));
        pdfNameLabel.setText(" "+notification.getPdfName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        createdTimeLabel.setText(dateFormat.format(notification.getCreateTime()));
        typeLabel.setText(notification.getType());

        // Customize the appearance based on selection
        if (isSelected) {
            setBackground(new Color(255, 218, 185)); // Peach
setForeground(Color.DARK_GRAY); // Dark Gray text on peach background

        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
