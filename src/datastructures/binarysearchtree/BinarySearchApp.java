package datastructures.binarysearchtree;

public class BinarySearchApp {

    public static void main(String[] args) {

        final BST binarySearchTree1 = new BST();
        final BST binarySearchTree2 = new BST();

        createTree(new int[]{70,50,90,100,30,60,20}, binarySearchTree1);
        createTree(new int[]{90,80,100,70,50,30,60}, binarySearchTree2);


//        createDefaultTree(binarySearchTree);;

//        System.out.println(binarySearchTree2);

//        System.out.println(binarySearchTree.getNodeById(95));

//        System.out.println("################ PRE-ORDER ################");
//        binarySearchTree.preOrderTraversal(binarySearchTree.getNodeById(70));
//
//        System.out.println("################ IN-ORDER ################");
//        binarySearchTree.inOrderTraversal(binarySearchTree.getNodeById(70));
//
//        System.out.println("################ POST-ORDER ################");
//        binarySearchTree.postOrderTraversal(binarySearchTree.getNodeById(70));
//
//        System.out.println("################ LEVEL-ORDER ################");
//        binarySearchTree1.levelOrderTraversal();

//        System.out.println("################ TREE COMPARISON ################");
//        System.out.println(BST.compareTrees(binarySearchTree1,binarySearchTree2));

        System.out.println("################ GET KTH SMALLEST NODE VALUE################");
        System.out.println(BST.getKthSmallestValue(binarySearchTree1, 7));

        System.out.println("################ GET KTH LARGEST NODE VALUE################");
        System.out.println(BST.getKthLargestValue(binarySearchTree1, 1));

//        System.out.println("################ TREE VALIDATION ################");
//        System.out.println(binarySearchTree.validateBinarySearchTree());
    }

    private static void createDefaultTree(final BST binarySearchTree) {

        binarySearchTree.insertNode(BinaryNode.builder().id(70).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(50).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(90).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(80).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(100).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(30).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(60).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(20).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(40).height(12).build(), binarySearchTree);

    }

    private static void createTree(final int [] idArray, final BST binarySearchTree) {

        for (final int id : idArray) {
            binarySearchTree.insertNode(BinaryNode.builder().id(id).height(12).build(), binarySearchTree);
        }

    }

    private static void createCustomTree(final BST binarySearchTree) {

        binarySearchTree.insertNode(BinaryNode.builder().id(5).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(4).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder()
                .id(6)
                .height(12)
                .left(BinaryNode.builder().id(3).build())
                .right(BinaryNode.builder().id(7).build()).build(), binarySearchTree);

    }

    private static void createCustomTreeV2(final BST binarySearchTree) {

        binarySearchTree.insertNode(BinaryNode.builder().id(60).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(50).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(70).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(45).height(12)
                .right(BinaryNode.builder().id(60).build())
                .left(BinaryNode.builder().id(40).build()).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(55).height(12).build(), binarySearchTree);

    }

    private static void createCustomTreeV3(final BST binarySearchTree) {

        binarySearchTree.insertNode(BinaryNode.builder().id(32).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(26).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(47).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder()
                .id(19)
                .height(12)
                .right(BinaryNode.builder().id(27).build()).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(56).height(12).build(), binarySearchTree);

    }

    private static void createCustomTreeV4(final BST binarySearchTree) {

        binarySearchTree.insertNode(BinaryNode.builder().id(3).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(1).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(5).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(0).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(2).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(4).height(12).build(), binarySearchTree);
        binarySearchTree.insertNode(BinaryNode.builder().id(6).height(12).build(), binarySearchTree);


    }

}