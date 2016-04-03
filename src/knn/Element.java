package knn;

/**
 * @author Yuheng Li
 * @version 1.0
 * @since Mar 28, 2016
 */
public class Element {
    private Type type;
    private Style style;
    private int Vacation;
    private int credit;
    private int salary;
    private int property;
    private Label label;

    public Element(String str) {
        String[] params = str.split(",");
        setType(params[0]);
        setStyle(params[1]);
        setVacation(Integer.parseInt(params[2]));
        setCredit(Integer.parseInt(params[3]));
        setSalary(Integer.parseInt(params[4]));
        setProperty(Integer.parseInt(params[5]));
        setLabel(params[6]);
    }

    public Type getType() {
        return type;
    }

    public Style getStyle() {
        return style;
    }

    public int getVacation() {
        return Vacation;
    }

    public int getCredit() {
        return credit;
    }

    public int getSalary() {
        return salary;
    }

    public int getProperty() {
        return property;
    }

    public Label getLabel() {
        return label;
    }

    public void setType(String key) {
        switch (key) {
            case "librarian":
                type = Type.LIB;
                break;
            case "Student":
                type = Type.STU;
                break;
            case "professor":
                type = Type.PRO;
                break;
            case "engineer":
                type = Type.ENG;
            default:
                break;
        }
    }

    public void setStyle(String key) {
        switch (key) {
            case "spend<<saving":
                style = Style.SAV2;
                break;
            case "spend<saving":
                style = Style.SAV;
                break;
            case "spend>saving":
                style = Style.SPD;
                break;
            case "spend>>saving":
                style = Style.SPD2;
            default:
                break;
        }
    }

    public void setVacation(int vacation) {
        Vacation = vacation;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public void setLabel(String key) {
        switch (key) {
            case "C1":
                label = Label.C1;
                break;
            case "C2":
                label = Label.C2;
                break;
            case "C3":
                label = Label.C3;
                break;
            case "C4":
                label = Label.C4;
                break;
            case "C5":
                label = Label.C5;
                break;
            default:
                break;
        }
    }

    enum Type {
        LIB, STU, ENG, PRO, DOC;
    }

    enum Style {
        SAV2, SAV, SPD, SPD2;
    }

    enum Label {
        C1, C2, C3, C4, C5;
    }
}