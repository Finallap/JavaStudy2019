/**
 * @description: problem37:二叉树的序列化与反序列化
 * @date: 2020/3/5 22:10
 * @author: Finallap
 * @version: 1.0
 */
public class problem37 {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("$,");
        } else {
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }

        return sb.toString();
    }


    int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len)
            return null;
        TreeNode node = null;
        String[] strs = str.split(",");

        //遍历strs数组，重构二叉树：当前遍历元素非 # 则作为一个结点插入树中，作为上一个结点的左儿子；
        //当前遍历元素为 # 则表示此子树已结束，遍历下一个元素作为上一个结点的右孩子
        //即遍历到数字作为上一个结点的左孩子，遇到#变向作为上一个结点的右孩子
        if (!strs[index].equals("$")) {
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
