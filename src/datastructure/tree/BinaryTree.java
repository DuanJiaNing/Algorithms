package datastructure.tree;

import java.util.Iterator;

/**
 * Created on 2017/12/4.
 *
 * @author DuanJiaNing
 */
public interface BinaryTree<T> {

    /**
     * 前序遍历
     */
    int TRAVERSE_DLR = 1;

    /**
     * 中序遍历
     */
    int TRAVERSE_LDR = 2;

    /**
     * 后序遍历
     */
    int TRAVERSE_LRD = 3;


    /**
     * 插入
     *
     * @param value
     */
    boolean add(T value);

    /**
     * 遍历二叉树
     *
     * @param traverse {@link #TRAVERSE_DLR}先序
     *                 {@link #TRAVERSE_LDR}中序
     *                 {@link #TRAVERSE_LRD}后序
     * @return
     */
    Iterator<T> iterator(int traverse);

    /**
     * 删除节点
     *
     * @param value
     * @return
     */
    boolean delete(T value);
}
