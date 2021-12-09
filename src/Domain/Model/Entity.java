package Domain.Model;

import java.util.ArrayList;

public interface Entity {
    Integer getCountOfParams();
    ArrayList<String> getListOfAttributes();
    Entity setParams(ArrayList<String> params);
    Integer getPrimaryKey();
}
