package Other;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Notification {
    private int pdfId;
    private String filePath;
    private String pdfName;
    private Timestamp createTime;
    private String type;
    

    public Notification(int pdfId, String filePath, String pdfName, Timestamp createTime, String type) {
        this.pdfId = pdfId;
        this.filePath = filePath;
        this.pdfName = pdfName;
        this.createTime = createTime;
        this.type = type;
    }

    public int getPdfId() {
        return pdfId;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public String getPdfName() {
        return pdfName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public String getType() {
        return type;
    }
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(createTime);
        return "PDF ID: " + pdfId + " | PDF Name: " + pdfName + " | Created Time: " + formattedTime + " | Type: " + type;
    }
}
