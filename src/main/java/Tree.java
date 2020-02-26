import java.util.TreeMap;

public class Tree { 
    
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.addItem(new TreeItem(1, 0));
        tree.addItem(new TreeItem(2, 0));
        tree.addItem(new TreeItem(3, 1));
        tree.addItem(new TreeItem(4, 3));
        tree.addItem(new TreeItem(5, 4));
        tree.addItem(new TreeItem(6, 0));  
    

        tree.printTree();
    }



    TreeMap<Integer, TreeItem> items = new TreeMap<Integer, TreeItem>();

    Tree() {
        items.put(0, new TreeItem(0, -1));   // root     
    }

    public void addItem (TreeItem item) {

        items.put(item.id, item);      

        if(items.containsKey(item.parentId)) {
            items.get(item.parentId).children.add(item);
        }

    }

    public void printTree () {
        printItem (0); 

    }
    public void printItem (int itemId) {
        if(!items.containsKey(itemId))
            return;

        TreeItem item = items.get(itemId);
        System.out.println("id " + item.id + "  -  parentId " + item.parentId);
        
        for (TreeItem it : item.children) {
            printItem(it.id);
            
        }
    }
}