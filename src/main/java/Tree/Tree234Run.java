package Tree;

import lombok.Data;

public class Tree234Run {
    public static void main(String[] args) {
        DataItem item = new DataItem(77);
    }
}

@Data
class DataItem {
    public long dData;

    public DataItem(long dd) {
        dData = dd;
    }

    public void displayItem() {
        System.out.print("/" + dData);
    }
}


