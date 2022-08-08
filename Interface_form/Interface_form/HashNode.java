package Interface_form;

public class HashNode<E> {

    final int hash;
    final E key;

    HashNode<E> next;

    HashNode<E> nextLink;
    HashNode<E> prevLink;

    public HashNode(int hash, E key, HashNode<E> next){
        this.hash = hash;
        this.key = key;
        this.next = next;

        this.nextLink = null;
        this.prevLink = null;
    }
    
}
