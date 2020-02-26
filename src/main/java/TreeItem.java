import java.util.ArrayList;

public class TreeItem {

    int id;
    int parentId;
    ArrayList<TreeItem> children = new ArrayList<TreeItem>();

    TreeItem(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }
}