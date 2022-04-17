package datastructures.binarysearchtree;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BinaryNode {

    private int id;
    private int height;
    private BinaryNode left;
    private BinaryNode right;

}
