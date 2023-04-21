public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int phone;
    private byte year;

    public Employee ( String fullName, String position, String email, int phone, byte year) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public byte getYear() {
        return year;
    }

    public void setYear(byte year) {
        this.year = year;
    }
}
