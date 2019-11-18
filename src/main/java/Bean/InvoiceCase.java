package Bean;

import lombok.Data;

@Data
public class InvoiceCase {
    private String id;
    private String title;
    private String priority;
    private int statusCode;
    private String returnMsg;
    private String runResult;
    private String runStatus;
}
