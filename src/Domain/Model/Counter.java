package Domain.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Counter implements Entity {

    private Integer counter_id;
    private Integer count_of_emploee;

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "counter_id", "count_of_emploee"
    ));

    public Counter() {
    }

    @Override
    public Integer getCountOfParams() {
        return LIST_OF_ATTRIBUTES.size();
    }

    @Override
    public ArrayList<String> getListOfAttributes() {
        return LIST_OF_ATTRIBUTES;
    }

    @Override
    public Entity setParams(ArrayList<String> params){
        this.counter_id = Integer.parseInt(params.get(0));
        this.count_of_emploee = Integer.parseInt(params.get(1));
        return this;
    }

    public Integer getCounter_id() {
        return counter_id;
    }

    public void setCounter_id(Integer counter_id) {
        this.counter_id = counter_id;
    }

    public Integer getCount_of_emploee() {
        return count_of_emploee;
    }

    public void setCount_of_emploee(Integer count_of_emploee) {
        this.count_of_emploee = count_of_emploee;
    }


    @Override
    public Integer getPrimaryKey() {
        return this.counter_id;
    }

}
