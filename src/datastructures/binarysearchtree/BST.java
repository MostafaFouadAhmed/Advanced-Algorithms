package datastructures.binarysearchtree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class BST {

    private BinaryNode root;
    private int left = 0;
    private int right = 0;
    private static final Queue<BinaryNode> BINARY_NODES_QUEUE = new LinkedList<>();
    private static final Queue<Character> BINARY_NODE_POSITION_QUEUE = new LinkedList<>();
    private static int counter = 0;
    private static int kthNode;

    public void insertNode(final BinaryNode nodeToBeInserted, final BST tree) {

        if (Objects.isNull(root)) {
           root = nodeToBeInserted;
           return;
        }

        final Stack<BinaryNode> binaryNodeStack = new Stack<>();
        binaryNodeStack.push(tree.getRoot());

        while (!binaryNodeStack.isEmpty()) {

            BinaryNode currentBinaryNode = binaryNodeStack.pop();

            if (nodeToBeInserted.getId() <= currentBinaryNode.getId() && currentBinaryNode.getLeft() == null) {

                currentBinaryNode.setLeft(nodeToBeInserted);
                break;

            } else if (nodeToBeInserted.getId() <= currentBinaryNode.getId()){

                binaryNodeStack.push(currentBinaryNode.getLeft());

            } else if (nodeToBeInserted.getId() > currentBinaryNode.getId() && currentBinaryNode.getRight() == null) {

                currentBinaryNode.setRight(nodeToBeInserted);
                break;

            } else if (nodeToBeInserted.getId() > currentBinaryNode.getId()) {

                binaryNodeStack.push(currentBinaryNode.getRight());
            }
        }
    }

    public BinaryNode getNodeById(final int id) {

        if (this.getRoot().getId() == id) return root;

        BinaryNode binaryNode;

        if (id <= this.root.getId()) binaryNode = this.root.getLeft();
        else binaryNode = this.root.getRight();

        while (binaryNode.getId() != id) {

            if (id <= binaryNode.getId()) binaryNode = binaryNode.getLeft();
            else binaryNode = binaryNode.getRight();
        }

        return binaryNode;
    }

    public void preOrderTraversal(final BinaryNode binaryNode){

        System.out.println("Current Node : " + binaryNode.getId());

        if (binaryNode.getLeft() != null) {
                preOrderTraversal(binaryNode.getLeft());
        }

        if (binaryNode.getRight() != null) {
            preOrderTraversal(binaryNode.getRight());
        }
    }

    public void inOrderTraversal(final BinaryNode binaryNode) {

        if (binaryNode.getLeft() != null) inOrderTraversal(binaryNode.getLeft());

        System.out.println("Current Node : " + binaryNode.getId());

        if (binaryNode.getRight() != null) inOrderTraversal(binaryNode.getRight());

    }

    public void postOrderTraversal(final BinaryNode binaryNode) {

        if (binaryNode.getLeft() != null) postOrderTraversal(binaryNode.getLeft());

        if (binaryNode.getRight() != null) postOrderTraversal(binaryNode.getRight());

        System.out.println("Current Node : " + binaryNode.getId());

    }

    public void levelOrderTraversal() {

        final Queue<BinaryNode> binaryNodeQueue = new LinkedList<>();

        binaryNodeQueue.add(root);

        while (!binaryNodeQueue.isEmpty()) {

            final BinaryNode binaryNode = binaryNodeQueue.remove();
            System.out.println(binaryNode.getId());

            if(binaryNode.getLeft() != null) binaryNodeQueue.add(binaryNode.getLeft());
            if(binaryNode.getRight() != null) binaryNodeQueue.add(binaryNode.getRight());

        }
    }

    public static int getKthSmallestValue (final BST binarySearchTree, final int kthValue) {

        counter = 0;

        return getRequiredSmallestValue(binarySearchTree.root, kthValue);

    }

    private static int getRequiredSmallestValue(final BinaryNode node, final int kthValue) {

        if (node.getLeft() != null) getRequiredSmallestValue(node.getLeft(), kthValue);

        counter++;
        if(counter == kthValue) kthNode = node.getId();

        if (node.getRight() != null) getRequiredSmallestValue(node.getRight(), kthValue);

        return kthNode;
    }

    public static int getKthLargestValue (final BST binarySearchTree, final int kthValue) {
        counter = 0;

        return getRequiredLargestValue(binarySearchTree.root, kthValue);

    }

    private static int getRequiredLargestValue(final BinaryNode node, final int kthValue) {

        if (node.getRight() != null) getRequiredLargestValue(node.getRight(), kthValue);

//        System.out.println("Current Node : " + node.getId());

        counter++;
        if(counter == kthValue) kthNode = node.getId();

        if (node.getLeft() != null) getRequiredLargestValue(node.getLeft(), kthValue);

        return kthNode;
    }

    public static boolean compareTrees(final BST binaryTree1, final BST binaryTree2) {

        final Queue<BinaryNode> binaryNodeQueue1 = new LinkedList<>();
        final Queue<BinaryNode> binaryNodeQueue2 = new LinkedList<>();

        binaryNodeQueue1.add(binaryTree1.root);
        binaryNodeQueue2.add(binaryTree2.root);

        while (!binaryNodeQueue1.isEmpty()) {

            final BinaryNode binaryNode1 = binaryNodeQueue1.remove();
            final BinaryNode binaryNode2 = binaryNodeQueue2.remove();
            System.out.println("binaryNode1 : " + binaryNode1.getId());
            System.out.println("binaryNode2 : " + binaryNode2.getId());
            System.out.println("----------------------------------------------");

            if (binaryNode1.getId() != binaryNode2.getId()) return false;

            if (binaryNode1.getLeft() != null && binaryNode2.getLeft() == null ||
                    binaryNode1.getLeft() == null && binaryNode2.getLeft() != null) return false;

            if (binaryNode1.getRight() != null && binaryNode2.getRight() == null ||
                    binaryNode1.getRight() == null && binaryNode2.getRight() != null) return false;

            if(binaryNode1.getLeft() != null) binaryNodeQueue1.add(binaryNode1.getLeft());
            if(binaryNode1.getRight() != null) binaryNodeQueue1.add(binaryNode1.getRight());

            if(binaryNode2.getLeft() != null) binaryNodeQueue2.add(binaryNode2.getLeft());
            if(binaryNode2.getRight() != null) binaryNodeQueue2.add(binaryNode2.getRight());

        }

        return true;
    }

    public boolean validateBinarySearchTree() {

        BINARY_NODES_QUEUE.add(root);
        BINARY_NODE_POSITION_QUEUE.add('s');

        while (!BINARY_NODES_QUEUE.isEmpty()) {

            final BinaryNode binaryNode = BINARY_NODES_QUEUE.remove();
            final char position = BINARY_NODE_POSITION_QUEUE.remove();
            System.out.println(binaryNode.getId());

            if(position == 's') {
                if(handleRoot() == false) return false;

            } else if (position == 'l') {
                if(handleLeft(binaryNode) == false) return false;

            } else if (position == 'r') {
                if(handleRight(binaryNode) == false) return false;
            }

        }

        return true;
    }

    private boolean handleRoot() {
        if (root.getLeft() == null && root.getRight() == null) return true;

        if (root.getLeft() != null) {
            BINARY_NODE_POSITION_QUEUE.add('l');
            BINARY_NODES_QUEUE.add(root.getLeft());
            left = root.getId();
            if (root.getLeft().getId() >= root.getId()) return false;

        }

        if (root.getRight() != null) {
            BINARY_NODE_POSITION_QUEUE.add('r');
            BINARY_NODES_QUEUE.add(root.getRight());
            right = root.getId();
            if (root.getRight().getId() <= root.getId()) return false;

        }
        return true;
    }

    private boolean handleLeft(final BinaryNode leftSubtreeNode) {

        left = leftSubtreeNode.getId();

        if (leftSubtreeNode.getLeft() != null) {

            if (leftSubtreeNode.getLeft().getId() >= leftSubtreeNode.getId()) return false;
            BINARY_NODES_QUEUE.add(leftSubtreeNode.getLeft());
            BINARY_NODE_POSITION_QUEUE.add('l');
        }

        if (leftSubtreeNode.getRight() != null) {

            if (leftSubtreeNode.getRight().getId() <= leftSubtreeNode.getId() || leftSubtreeNode.getRight().getId() > left) return false;
            BINARY_NODES_QUEUE.add(leftSubtreeNode.getRight());
            BINARY_NODE_POSITION_QUEUE.add('l');
            left = leftSubtreeNode.getRight().getId();
        }

        return true;
    }

    private boolean handleRight(final BinaryNode rightSubtreeNode) {

        right = rightSubtreeNode.getId();

        if (rightSubtreeNode.getLeft() != null) {

            if (rightSubtreeNode.getLeft().getId() >= rightSubtreeNode.getId() || rightSubtreeNode.getLeft().getId() < right) return false;
            BINARY_NODES_QUEUE.add(rightSubtreeNode.getLeft());
            BINARY_NODE_POSITION_QUEUE.add('r');
            right = rightSubtreeNode.getLeft().getId();
        }

        if (rightSubtreeNode.getRight() != null) {

            if (rightSubtreeNode.getRight().getId() <= rightSubtreeNode.getId()) return false;
            BINARY_NODES_QUEUE.add(rightSubtreeNode.getRight());
            BINARY_NODE_POSITION_QUEUE.add('r');

        }

        return true;
    }
}