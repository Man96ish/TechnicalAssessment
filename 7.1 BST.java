import java.util.*;
class node
{
    private int info;
    private node left;
    private node right;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }
}

public class BST {
    public static void bstmenu()
    {
        System.out.println("\n\t\t Menu ");
        System.out.println("\n\t\t 1. Insert node");
        System.out.println("\n\t\t 2. Find Minimum");
        System.out.println("\n\t\t 3. Find Maximum");
        System.out.println("\n\t\t 4. Delete Node");
        System.out.println("\n\t\t 5. Find Node");
        System.out.println("\n\t\t 6. Inorder Traversal");
        System.out.println("\n\t\t 7. PreOrder Traversal");
        System.out.println("\n\t\t 8. PostOrder Traversal");
        System.out.println("\n\t\t 9. Exit");
        System.out.println("\n\t\t 4. Please enter your choice (1-9) :");
    }

    public static node findmin(node tnode)
    {
        //check if tree is empty or not
        if(tnode==null) {
            return null;
        }
        /* we have to go to left sub tree to find the min element*/
        if(tnode.getLeft() !=null)
            return (findmin(tnode.getLeft()));
        else
            return tnode;
    }

    public static node findmax(node tnode)
    {
        //check if tree is empty or not
        if(tnode==null) {
            return null;
        }
        /* we have to go to right sub tree to find the max element*/
        if(tnode.getRight() !=null)
            return (findmax(tnode.getRight()));
        else
            return tnode;
    }

    public static node insert(node tnode, int data)
    {
        /*check if tree is empty then it is root node*/
        if(tnode==null)
        {
            //create a new node
            node temp=new node();
            temp.setInfo(data);
            temp.setLeft(null);
            temp.setRight(null);
            return(temp);
        }
        /*if tree is not empty then*/
        if(data>tnode.getInfo())
        {
            tnode.setRight(insert(tnode.getRight(), data));
        }
        else
        if(data<tnode.getInfo())
        {
            tnode.setLeft(insert(tnode.getLeft(), data));
        }
            /*else if the data is already present in the tree
            do not insert node just return the node
             */
        return (tnode);
    }

    public static node deletenode(node tnode, int data)
    {
        node temp;
        /* check if tree is empty or not */
        if(tnode==null)
        {
            System.out.println("\n Tree is empty or data does not exists");
        }
        else
        if(data<tnode.getInfo())
        {
            tnode.setLeft(deletenode(tnode.getLeft(), data));
        }
        else
        if(data>tnode.getInfo())
        {
            tnode.setRight(deletenode(tnode.getRight(), data));
        }
        else
                    /*now we can replace this node with either minimum
                    element in the right subtree or maximum element in the
                    left subtree
                     */
            /*check if node to delete has both child*/
            /*here I shall prefer to go to min of right*/
            if((tnode.getRight() !=null)&&(tnode.getLeft()!= null))
            {
                temp = findmin(tnode.getRight());
                tnode.setInfo(temp.getInfo());
                        /* now we have swaped the leff node value with the
                        node value to be deleted
                        */
                tnode.setRight(deletenode(tnode.getRight(), temp.getInfo()));
            }
            else
                    /*if there is only one child of the node or no child
                    we can directly remove the it from the tree and connect
                    its parent to the child
                     */
            {
                temp=tnode;
                if(tnode.getLeft() == null)
                {
                    tnode=tnode.getRight();
                }
                else
                if(tnode.getRight()==null)
                {
                    tnode=tnode.getLeft();
                }
            }
        return tnode;
    }

    public static node find(node tnode, int data)
    {
        /*check if tree is empty or not*/
        if(tnode==null)
        {
            return(null);
        }
        if(data> tnode.getInfo())
        {
            /*search the right subtree*/
            return find(tnode.getRight(), data);
        }
        else
        if(data<tnode.getInfo())
        {
            /*search the left subtree*/
            return find(tnode.getLeft(), data);
        }
        else
            return tnode; //element found
    }

    public static void dispinorder(node tnode)
    {
        /* check tree is empty of reached to leaf*/
        if(tnode==null)
            return;
        dispinorder(tnode.getLeft());
        System.out.printf("%5d", tnode.getInfo());
        dispinorder(tnode.getRight());
    }

    public static void disppreorder(node tnode)
    {
        /* check tree is empty of reached to leaf*/
        if(tnode==null)
            return;
        System.out.printf("%5d", tnode.getInfo());
        disppreorder(tnode.getLeft());
        disppreorder(tnode.getRight());
    }

    public static void disppostorder(node tnode)
    {
        /* check tree is empty of reached to leaf*/
        if(tnode==null)
            return;
        disppostorder(tnode.getLeft());
        disppostorder(tnode.getRight());
        System.out.printf("%5d", tnode.getInfo());
    }

    public static void main(String[] args) {

        node root=null, temp;
        int data;
        int ch;
        Scanner scn=new Scanner(System.in);
        do {
            do {
                bstmenu();
                ch=scn.nextInt();

                if((ch<1)||(ch>9))
                {
                    System.out.println("\n Invalid Choice ... try again");
                    continue;
                }
                else
                    break;
            }while(true);

            switch(ch)
            {
                case 1:
                    System.out.println("\n Enter data to insert :");
                    data=scn.nextInt();
                    root=insert(root, data);
                    break;
                case 2:
                    temp=findmin(root);
                    System.out.println("\n Minimum element : " + temp.getInfo());
                    break;
                case 3:
                    temp=findmax(root);
                    System.out.println("\n Maximum element : " + temp.getInfo());
                    break;
                case 4:
                    System.out.println("\n Enter data to delete : ");
                    data=scn.nextInt();
                    root=deletenode(root, data);
                    break;
                case 5:
                    System.out.println("\n Enter data to search : ");
                    data=scn.nextInt();
                    temp=find(root, data);
                    if(temp==null)
                        System.out.println("\n Element not found");
                    else
                        System.out.println("\n Element found");
                    break;
                case 6:
                    dispinorder(root);
                    break;
                case 7:
                    disppreorder(root);
                    break;
                case 8:
                    disppostorder(root);
                    break;
            }
        }while(ch<9);
    }
}
