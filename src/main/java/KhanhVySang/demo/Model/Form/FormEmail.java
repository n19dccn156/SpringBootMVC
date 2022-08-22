package KhanhVySang.demo.Model.Form;

public class FormEmail {
    
    private String mailForm;
    private String mailTo;
    private String mailSubject;
    private String mailContet;
    

    public FormEmail() {
    }

    public FormEmail(String mailForm, String mailTo, String mailSubject, String mailContet) {
        this.mailForm = mailForm;
        this.mailTo = mailTo;
        this.mailSubject = mailSubject;
        this.mailContet = mailContet;
    }

    public String getMailForm() {
        return this.mailForm;
    }

    public void setMailForm(String mailForm) {
        this.mailForm = mailForm;
    }

    public String getMailTo() {
        return this.mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailSubject() {
        return this.mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContet() {
        return this.mailContet;
    }

    public void setMailContet(String mailContet) {
        this.mailContet = mailContet;
    }
    
}
