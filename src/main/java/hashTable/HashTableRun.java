package hashTable;

import lombok.Data;

public class HashTableRun {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.insert(new Item(10, "hello"));
        table.insert(new Item(11, "hello"));
        table.insert(new Item(1123, "hello"));
        table.insert(new Item(188, "hello"));
        table.insert(new Item(10423432, "hello"));
        table.delete(1123);
        Item item = table.find(1123);

    }
}


@Data
class Item {
    public Item(int key, String name) {
        this.key = key;
        this.name = name;
    }

    private int key;
    private String name;
}


class HashTable {
    private Item[] array = new Item[30];

    private int hashFunc(int key) {
        return key % array.length;
    }

    public int insert(Item item) {
        int index = hashFunc(item.getKey());
        while (array[index] != null && array[index].getKey() != -1) {
            ++index;
            index %= array.length;
        }
        array[index] = item;
        return index;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while (array[hashVal] != null) {
            if (array[hashVal].getKey() == key)
                return array[hashVal];
            ++hashVal;
            hashVal %= array.length;
        }
        return null;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        while (array[hashVal] != null) {
            if (array[hashVal].getKey() == key) {
                array[hashVal].setKey(-1);
                return array[hashVal];
            }
            ++hashVal;
            hashVal %= array.length;
        }
        return null;
    }
}


class HashTableChain {
    private LinkedList<Item>[] array = new LinkedList[30];

    private int hashFunc(int key) {
        return key % array.length;
    }

    public void insert(Item item) {
        int index = hashFunc(item.getKey());
        if (array[index] == null) {
            LinkedList<Item> list = new LinkedList<>();
            array[index] = list;
        }
        array[index].forEach(i -> {
            if (i.getKey() == item.getKey()) array[index].remove(i);
        });
        array[index].push(item);
    }

    public Item find(int key) {
        int index = hashFunc(key);
        if (array[index] == null) return null;
        for (var item : array[index]) {
            if (item.getKey() == key) return item;
        }
        return null;
    }
     
    public void delete(int key) {
        int index = hashFunc(key);
        if (array[index] == null) return;
        array[index].removeIf(item -> item.getKey() == key);
    }
}

