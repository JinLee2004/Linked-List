/* Implemented as a doubly linked double ended linked list */
public class DSALinkedList
{

    private class DSAListNode
    {
        private Object value;
        private DSAListNode next;
        private DSAListNode prev;

        public DSAListNode(Object inValue)
        {
            value = inValue;
            next = null;
            prev = null;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public DSAListNode getNext()
        {
            return next;
        }

        public void setNext(DSAListNode newNext)
        {
            next = newNext;
        }

        public DSAListNode getPrev()
        {
            return prev;
        }

        public void setPrev(DSAListNode newPrev)
        {
            prev = newPrev;
        }
    }

}