package umairayub.gwbasic;


/*Created by Umair Ayub
20 - 12 - 2018
*/

public class Item  {

    int id;
    String name;
    String code;
    public Item(int id,String name,String code) {
        this.id = id;
        this.name = name;
        this.code = code;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name;
    }
}