import lombok.AllArgsConstructor;
import lombok.Data;

public class HashTableRun {
    public static void main(String[] args) {
    }
}


@Data
@AllArgsConstructor
class Item {
    private int key;
    private String name;
}


class HashTable {
    Item[] array = new Item[30];

    private int hashFunc(int key) {
        return key % array.length;
    }

    public Item insert(Item item) {
        int index = hashFunc(item.getKey());
        while (array[index] != null && array[index].getKey() != -1 ) {
            ++index;
            index %= array.length;
        }
        array[index] = item;
    }
}
