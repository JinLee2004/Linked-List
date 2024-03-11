/* Implemented as a doubly linked double ended linked list */
public class LinkedList
{

    private class ListNode
    {
        private Object value;
        private ListNode next;
        private ListNode prev;

        public ListNode(Object inValue)
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

        public ListNode getNext()
        {
            return next;
        }

        public void setNext(ListNode newNext)
        {
            next = newNext;
        }

        public ListNode getPrev()
        {
            return prev;
        }

        public void setPrev(ListNode newPrev)
        {
            prev = newPrev;
        }

        
    // Class fields for Linked List
    private ListNode head;
    private ListNode tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void insertFirst(Object newValue)
    {
        ListNode newNode = new ListNode(newValue);
        if (isEmpty())
        {
            tail = newNode;
            newNode.setNext(null);
        }
        else
        {
            newNode.setNext(head);
        }
        head = newNode;
        newNode.setPrev(null); // Makes head node point to null for previous node
    }

    public void insertLast (Object newValue)
    {
        ListNode newNode = new ListNode(newValue);
        if (isEmpty())
        {
            head = newNode;
            newNode.setPrev(null);
        }
        else
        {
            newNode.setPrev(tail);
            tail.setNext(newNode); // Links tail to new node
        }
        newNode.setNext(null); // newNode next node is initialised to null
        tail = newNode;
    }

    public boolean isEmpty()
    {
        boolean empty = false;
        if (head == null && tail == null)
        {
            empty = true;
        }
        return empty;
    }

    public Object peekFirst() // Return value of first node
    {
        if (isEmpty())
        {
            throw new IllegalStateException("The linked list is empty.");
        }
        Object nodeValue = head.getValue();
        return nodeValue;
    }

    public Object peekLast() // Return value of last node
    {
        if (isEmpty())
        {
            throw new IllegalStateException("The linked list is empty.");
        }
        Object nodeValue = tail.getValue();
        return nodeValue;
    }

    public Object removeFirst()
    {
        Object nodeValue = null;
        if (isEmpty())
        {
            throw new IllegalStateException("The linked list is empty.");
        }
        else if(head.getNext() == null && tail.getPrev() == null) // If only 1 element in linked list
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else if(tail.getPrev() == head) // If there are only 2 elements in the linked list
        {
            nodeValue = head.getValue(); // Gets value to be returned
            head = tail; // Head is set to tail as there is only 1 element remaining
            head.setNext(null);
            tail.setPrev(null);
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext(); // Sets first element as second element
            head.setPrev(null);
            head.setNext(head.getNext());
        }
        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue = null;
        if (isEmpty())
        {
            throw new IllegalStateException("The linked list is empty.");
        }
        else if(head.getNext() == null && tail.getPrev() == null) // If only 1 element in linked list
        {
            System.out.println("I am here");
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else if(tail.getPrev() == head) // If there are only 2 elements in the linked list
        {
            nodeValue = tail.getValue(); // Gets value to be returned
            tail = head; // Tail is set to head as there is only 1 element remaining
            tail.setPrev(null);
            head.setNext(null);
        }
        else
        {
            nodeValue = tail.getValue(); 
            tail = tail.getPrev(); // Sets first element as second element
            tail.setNext(null); // New tail has next set to null
        }
        return nodeValue;
    }

    public void printAllElements()
    {
        int i = 1;
        ListNode currentNode = head;
        while(currentNode != null)
        {
            System.out.println("Element number " + i + " is: " + currentNode.getValue());
            i++;
            currentNode = currentNode.getNext();
        }
    }
    }

}