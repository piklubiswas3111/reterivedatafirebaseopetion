package westbengal.book;

public class Modal {
    String pdfname;
    String pdflink;

    public Modal() {
    }

    public Modal(String pdflink, String pdfname) {
        this.pdflink = pdflink;
        this.pdfname = pdfname;

    }

    public String getPdfname() {
        return pdfname;
    }

    public void setPdfname(String pdfname) {
        this.pdfname = pdfname;
    }

    public String getPdflink() {
        return pdflink;
    }

    public void setPdflink(String pdflink) {
        this.pdflink = pdflink;
    }
}
