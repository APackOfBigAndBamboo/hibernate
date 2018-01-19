package DoMain.One2One;

import java.util.Date;

public class IdCard {
    private int id;
    private Date usefullife;
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUsefullife() {

        return usefullife;
    }

    public void setUsefullife(Date usefullife) {
        this.usefullife = usefullife;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
